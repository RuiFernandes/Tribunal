package tribunal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tribunal.dao.TribunalListenerRegistry;

@Entity
@Table(name = "livro")
/*
 * This class is generated from the entity 'Livro' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Livro implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "processo", nullable = false)
	private Processo processo;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Livro() {
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
	public Livro(String nome, Processo processo) {
		super();
		if (nome == null) {
			throw new java.lang.IllegalArgumentException("'nome' must not be null.");
		}
		if (processo == null) {
			throw new java.lang.IllegalArgumentException("'processo' must not be null.");
		}
		this.nome = nome;
		this.processo = processo;
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
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(this);
	}
	
	/**
	 * Returns the value of property {@link #processo}.
	 */
	public Processo getProcesso() {
		return processo;
	}
	
	/**
	 * Sets the value of property {@link #processo}.
	 */
	public void setProcesso(Processo newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'processo' must not be null.");
		}
		this.processo = newValue;
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
		if (!(obj instanceof Livro)) {
			return false;
		}
		Livro other = (Livro) obj;
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
		result.append("Livro-");
		result.append(getId());
		result.append(" [");
		result.append("nome = ");
		result.append(getNome());
		result.append("]");
		return result.toString();
	}
	
}
