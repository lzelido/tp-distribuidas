package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.CategoriaTratamientoDTO;

@Entity
@Table (name = "CategoriaTratamiento")
public class CategoriaTratamiento {
	@Transient
	private static final long serialVersionUID = -8289991547902786107L;
	
	@Id
	@Column (name = "IdTratamiento", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column (name = "Descri")
	private String descri;
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public static CategoriaTratamiento fromDto(CategoriaTratamientoDTO dto) {
		CategoriaTratamiento catTratamiento = new CategoriaTratamiento();
		catTratamiento.setCodigo(dto.getCodigo());
		catTratamiento.setDescri(dto.getDescri());
		return catTratamiento;
	}

	public CategoriaTratamientoDTO toDto() {
			CategoriaTratamientoDTO dto = new CategoriaTratamientoDTO();
			dto.setCodigo(this.codigo);
			dto.setDescri(this.descri);
			return dto;
	}
}
