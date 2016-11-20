package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import dao.CompaniaSeguroDAO;
import dto.CompaniaSeguroDTO;

@Entity
@Table(name = "CompaniaSeguro")

public class CompaniaSeguro {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idCompaniaSeguro", nullable = false)
	// @GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;

	@Column(name = "Descripcion")
	private String descripcion;

	@OneToMany
	@Column(name = "idCompaniaSeguro")
	private List<Tarifa> tarifas;

	public CompaniaSeguro() {

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

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public CompaniaSeguroDTO toDto() {
		CompaniaSeguroDTO dto = new CompaniaSeguroDTO();
		dto.setCodigo(this.codigo);
		dto.setDescripcion(this.descripcion);
		dto.setTarifas(Tarifa.toDto(this.tarifas));
		return dto;
	}

	public static CompaniaSeguro fromDto(CompaniaSeguroDTO dto) {
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		companiaSeguro.setCodigo(dto.getCodigo());
		companiaSeguro.setDescripcion(dto.getDescripcion());
		companiaSeguro.setTarifas(Tarifa.fromDtos(dto.getTarifas()));
		return companiaSeguro;
	}

	public void save() {
		CompaniaSeguroDAO.getInstancia().save(this);
	}

	public void remove() {
		CompaniaSeguroDAO.getInstancia().remove(this);
	}

	public static List<CompaniaSeguroDTO> toDtos(List<CompaniaSeguro> companiaSeguros) {
		List<CompaniaSeguroDTO> dtos = new ArrayList<CompaniaSeguroDTO>();
		for (CompaniaSeguro comp : companiaSeguros) {
			dtos.add(comp.toDto());
		}
		return dtos;
	}
}
