package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente {
	@Transient
	private static final long serialVersionUID = -157689697578913572L;

	@Id
	@Column(name = "IdCliente", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "TipoDoc")
	private String tipoDoc;

	@Column(name = "NroDoc")
	private String nroDoc;

	@Column(name = "Manifiesto")
	private boolean reqManifiesto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public boolean isReqManifiesto() {
		return reqManifiesto;
	}

	public void setReqManifiesto(boolean reqManifiesto) {
		this.reqManifiesto = reqManifiesto;
	}

}