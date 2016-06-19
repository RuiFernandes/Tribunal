package tribunal.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "processo")
/*
 * This class is generated from the entity 'Processo' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Processo implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "requerente", nullable = false)
	private Requerente requerente;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "requerido", nullable = false)
	private Requerido requerido;
	
	@Column(name = "auto", nullable = false)
	private String auto;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Processo() {
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
	public Processo(String numero, Date data, Requerente requerente, Requerido requerido, String auto) {
		super();
		if (numero == null) {
			throw new java.lang.IllegalArgumentException("'numero' must not be null.");
		}
		if (data == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		if (requerente == null) {
			throw new java.lang.IllegalArgumentException("'requerente' must not be null.");
		}
		if (requerido == null) {
			throw new java.lang.IllegalArgumentException("'requerido' must not be null.");
		}
		if (auto == null) {
			throw new java.lang.IllegalArgumentException("'auto' must not be null.");
		}
		this.numero = numero;
		this.data = data;
		this.requerente = requerente;
		this.requerido = requerido;
		this.auto = auto;
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
	 * Returns the value of property {@link #numero}.
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Sets the value of property {@link #numero}.
	 */
	public void setNumero(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'numero' must not be null.");
		}
		this.numero = newValue;
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
	 * Returns the value of property {@link #requerente}.
	 */
	public Requerente getRequerente() {
		return requerente;
	}
	
	/**
	 * Sets the value of property {@link #requerente}.
	 */
	public void setRequerente(Requerente newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'requerente' must not be null.");
		}
		this.requerente = newValue;
	}
	
	/**
	 * Returns the value of property {@link #requerido}.
	 */
	public Requerido getRequerido() {
		return requerido;
	}
	
	/**
	 * Sets the value of property {@link #requerido}.
	 */
	public void setRequerido(Requerido newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'requerido' must not be null.");
		}
		this.requerido = newValue;
	}
	
	/**
	 * Returns the value of property {@link #auto}.
	 */
	public String getAuto() {
		return auto;
	}
	
	/**
	 * Sets the value of property {@link #auto}.
	 */
	public void setAuto(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'auto' must not be null.");
		}
		this.auto = newValue;
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
		if (!(obj instanceof Processo)) {
			return false;
		}
		Processo other = (Processo) obj;
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
		result.append("Processo-");
		result.append(getId());
		result.append(" [");
		result.append("numero = ");
		result.append(getNumero());
		result.append(", ");
		result.append("data = ");
		result.append(getData());
		result.append(", ");
		result.append("auto = ");
		result.append(getAuto());
		result.append("]");
		return result.toString();
	}
	
}
