package tribunal.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

// This class is generated. Any change will be overridden.
public abstract class TribunalSchemaUpdaterBase {
	
	public interface IRawDatabaseFunction<ResultType> {
		
		public ResultType execute(Connection connection);
	}
	
	/**
	 * Returns the latest schema version (which might be different from the current
	 * one) or 0 if schema versioning is not enabled.
	 */
	public int getLatestSchemaVersion() {
		return 0;
	}
	
	public boolean updateSchema(String databaseURL, String username, String password) throws SchemaUpdateException {
		Integer currentVersionObject = getCurrentSchemaVersion(databaseURL, username, password);
		if (currentVersionObject == null) {
			throw new SchemaUpdateException("Can't find last schema version in table 'schemaupdate'. Can't perform schema update.");
		}
		
		return true;
	}
	
	/**
	 * Returns the current schema version or <code>null</code> if no schema
	 * information is available.
	 */
	public Integer getCurrentSchemaVersion(String databaseURL, String username, String password) {
		Integer lastVersionObject = executeRawQuery(databaseURL, username, password, new IRawDatabaseFunction<Integer>() {
			
			public Integer execute(Connection connection) {
				
				Integer lastVersion = null;
				ResultSet resultSet1 = null;
				Statement createStatement = null;
				Statement createTableStatement = null;
				ResultSet resultSet2 = null;
				try {
					DatabaseMetaData meta = connection.getMetaData();
					resultSet1 = meta.getTables(null, null, null, new String[] { "TABLE" });
					boolean schemaUpdateTableExists = false;
					while (resultSet1.next()) {
						String name = resultSet1.getString("TABLE_NAME");
						if ("schemaupdate".equals(name)) {
							schemaUpdateTableExists = true;
							break;
						}
					}
					
					if (!schemaUpdateTableExists) {
						createTableStatement = connection.createStatement();
						createTableStatement.execute("CREATE TABLE `schemaupdate` (`id` int(11) NOT NULL AUTO_INCREMENT, `end` datetime NOT NULL, `start` datetime NOT NULL, `success` tinyint(1) NOT NULL, `version` int(11) NOT NULL, PRIMARY KEY (`id`));");
					}
					
					createStatement = connection.createStatement();
					resultSet2 = createStatement.executeQuery("SELECT version FROM schemaupdate WHERE success = 1 ORDER BY version DESC, id DESC LIMIT 1");
					if (resultSet2.next()) {
						lastVersion = resultSet2.getInt("version");
					}
					resultSet2.close();
				} catch (SQLException se) {
					logException(se);
				} finally {
					if (resultSet1 != null) {
						try {
							resultSet1.close();
						} catch (SQLException se) {
							// Ignore
						}
					}
					if (createTableStatement != null) {
						try {
							createTableStatement.close();
						} catch (SQLException se) {
							// Ignore
						}
					}
					if (createStatement != null) {
						try {
							createStatement.close();
						} catch (SQLException se) {
							// Ignore
						}
					}
					if (resultSet2 != null) {
						try {
							resultSet2.close();
						} catch (SQLException se) {
							// Ignore
						}
					}
				}
				return lastVersion;
			}
		});
		return lastVersionObject;
	}
	
	protected boolean throwException(int version) {
		throw new java.lang.RuntimeException(getErrorMessage(version));
	}
	
	protected String getErrorMessage(int version) {
		return "Custom schema updates for version " + version + " are not implemented. Can't perform schema update.";
	}
	
	protected void handleUpdateResult(int schemaVersion, long start, boolean updateSuccess, String databaseURL, String username, String password) throws SchemaUpdateException {
		long end = System.currentTimeMillis();
		boolean logUpdateSuccess = logUpdate(databaseURL, username, password, schemaVersion, start, end, updateSuccess);
		if (!updateSuccess) {
			throw new SchemaUpdateException("Update to schema version " + schemaVersion + " failed.");
		}
		if (!logUpdateSuccess) {
			throw new SchemaUpdateException("Logging successful update to schema version " + schemaVersion + " failed.");
		}
	}
	
	protected <ResultType> ResultType executeRawQuery(String databaseURL, String username, String password, IRawDatabaseFunction<ResultType> function) {
		Connection conn = null;
		try {
			// Open connection
			conn = DriverManager.getConnection(databaseURL, username, password);
			return function.execute(conn);
		} catch (SQLException se) {
			logException(se);
		} finally {
			// finally block used to close resources
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				logException(se);
			}
		}
		return null;
	}
	
	protected boolean logUpdate(String databaseURL, String username, String password, final int version, final long start, final long end, final boolean success) {
		Boolean insertSuccess = executeRawQuery(databaseURL, username, password, new IRawDatabaseFunction<Boolean>() {
			public Boolean execute(Connection connection) {
				boolean insertSuccess = false;
				PreparedStatement statement = null;
				try {
					statement = connection.prepareStatement("INSERT INTO schemaupdate (version, start, end, success) VALUES (?, ?, ?, ?);");
					statement.setInt(1, version);
					statement.setTimestamp(2, new Timestamp(start));
					statement.setTimestamp(3, new Timestamp(end));
					statement.setBoolean(4, success);
					insertSuccess = statement.executeUpdate() > 0;
				} catch (SQLException se) {
					logException(se);
				} finally {
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException se) {
							logException(se);
						}
					}
				}
				return insertSuccess;
			}
		});
		if (insertSuccess == null) {
			return false;
		}
		return insertSuccess.booleanValue();
	}
	
	protected void logException(SQLException se) {
		se.printStackTrace();
	}
	
}
