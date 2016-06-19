package tribunal.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "log")
/*
 * This class is generated from the entity 'Log' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Log implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "log", nullable = false)
	private String log;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Log() {
		super();
	}
	
	/**
	 * <p>
	 * Constructor using all read-only and all non-nullable properties.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used
	 * directly. Rather, the respective create() method must be used instead.
	 * </p>
	 */
	@java.lang.Deprecated
	public Log(Date data, String log) {
		super();
		if (data == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		if (log == null) {
			throw new java.lang.IllegalArgumentException("'log' must not be null.");
		}
		this.data = data;
		this.log = log;
	}
	
	/**
	 * Returns the automatically generated id that identifies this entity object.
	 */
	@java.lang.Override
	public int getId() {
		return id;
	}
	
	/**
	 * <p>
	 * The property 'id' is read-only.
	 * </p>
	 * <p>
	 * This setter is only provided for the JPA provider.
	 * </p>
	 * <p>
	 * It must not be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of property {@link #data}.
	 */
	public Date getData() {
		return data == null ? null : new Date(data.getTime());
	}
	
	/**
	 * Sets the value of property {@link #data}.
	 */
	public void setData(Date newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		this.data = new Date(newValue.getTime());
	}
	
	/**
	 * Returns the value of property {@link #log}.
	 */
	public String getLog() {
		return log;
	}
	
	/**
	 * Sets the value of property {@link #log}.
	 */
	public void setLog(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'log' must not be null.");
		}
		this.log = newValue;
	}
	
	@java.lang.Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + getId();
		return result;
	}
	
	@java.lang.Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Log)) {
			return false;
		}
		Log other = (Log) obj;
		int thisId = getId();
		int otherId = other.getId();
		// this can happen if both intIdentifiables are created in the current database
		// transaction
		if (thisId == 0 && otherId == 0) {
			return this == other;
		}
		if (thisId != otherId) {
			return false;
		}
		return true;
	}
	
	@java.lang.Override
	public java.lang.String toString() {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		result.append("Log-");
		result.append(getId());
		result.append(" [");
		result.append("data = ");
		result.append(getData());
		result.append(", ");
		result.append("log = ");
		result.append(getLog());
		result.append("]");
		return result.toString();
	}
	
}
