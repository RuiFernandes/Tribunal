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
import tribunal.dao.TribunalListenerRegistry;

@Entity
@Table(name = "usuario")
/*
 * This class is generated from the entity 'Usuario' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Usuario implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datadenascimento", nullable = false)
	private Date dataDeNascimento;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Usuario() {
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
	public Usuario(String nome, Date dataDeNascimento, String username, String password, String categoria) {
		super();
		if (nome == null) {
			throw new java.lang.IllegalArgumentException("'nome' must not be null.");
		}
		if (dataDeNascimento == null) {
			throw new java.lang.IllegalArgumentException("'dataDeNascimento' must not be null.");
		}
		if (username == null) {
			throw new java.lang.IllegalArgumentException("'username' must not be null.");
		}
		if (password == null) {
			throw new java.lang.IllegalArgumentException("'password' must not be null.");
		}
		if (categoria == null) {
			throw new java.lang.IllegalArgumentException("'categoria' must not be null.");
		}
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.username = username;
		this.password = password;
		this.categoria = categoria;
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
	 * Returns the value of property {@link #nome}.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the value of property {@link #nome}.
	 */
	public void setNome(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'nome' must not be null.");
		}
		this.nome = newValue;
	}
	
	/**
	 * Returns the value of property {@link #dataDeNascimento}.
	 */
	public Date getDataDeNascimento() {
		return dataDeNascimento == null ? null : new Date(dataDeNascimento.getTime());
	}
	
	/**
	 * Sets the value of property {@link #dataDeNascimento}.
	 */
	public void setDataDeNascimento(Date newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'dataDeNascimento' must not be null.");
		}
		this.dataDeNascimento = new Date(newValue.getTime());
	}
	
	/**
	 * Returns the value of property {@link #username}.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the value of property {@link #username}.
	 */
	public void setUsername(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'username' must not be null.");
		}
		this.username = newValue;
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(this);
	}
	
	/**
	 * Returns the value of property {@link #password}.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the value of property {@link #password}.
	 */
	public void setPassword(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'password' must not be null.");
		}
		this.password = newValue;
	}
	
	/**
	 * Returns the value of property {@link #categoria}.
	 */
	public String getCategoria() {
		return categoria;
	}
	
	/**
	 * Sets the value of property {@link #categoria}.
	 */
	public void setCategoria(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'categoria' must not be null.");
		}
		this.categoria = newValue;
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
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
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
		result.append("Usuario-");
		result.append(getId());
		result.append(" [");
		result.append("nome = ");
		result.append(getNome());
		result.append(", ");
		result.append("dataDeNascimento = ");
		result.append(getDataDeNascimento());
		result.append(", ");
		result.append("username = ");
		result.append(getUsername());
		result.append(", ");
		result.append("password = ");
		result.append(getPassword());
		result.append(", ");
		result.append("categoria = ");
		result.append(getCategoria());
		result.append("]");
		return result.toString();
	}
	
}
