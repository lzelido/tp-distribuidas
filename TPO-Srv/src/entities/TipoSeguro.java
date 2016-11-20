package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.TipoSeguroDTO;

@Entity
@Table(name = "TipoSeguro")
public class TipoSeguro {
	@Transient
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @Column (name="Codigo") private int codigo;
	 */

	@Id
	@Column(name = "idTipoSeguro", nullable = false)
	// @GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;

	@Column(name = "Descripcion")
	private String descripcion;

	public TipoSeguro() {
		// super();

	}

	public TipoSeguro(TipoSeguroDTO tipoSeguro) {
		this.codigo = tipoSeguro.getCodigo();
		this.descripcion = tipoSeguro.getDescripcion();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoSeguroDTO toDto() {
		TipoSeguroDTO dto = new TipoSeguroDTO();
		dto.setCodigo(this.codigo);
		dto.setDescripcion(this.descripcion);
		return dto;
	}

	public static TipoSeguro fromDto(TipoSeguroDTO dto) {
		TipoSeguro tipoSeguro = new TipoSeguro();
		tipoSeguro.setCodigo(dto.getCodigo());
		tipoSeguro.setDescripcion(dto.getDescripcion());
		return tipoSeguro;
	}
}
