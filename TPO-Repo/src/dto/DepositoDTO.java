package dto;

import java.io.Serializable;
import java.util.List;

public class DepositoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descri;
	private UbicacionDTO ubicacion;
	private List<CargaDTO> cargas;	
	
	public DepositoDTO(){
		
	}

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

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<CargaDTO> getCargas() {
		return cargas;
	}

	public void setCargas(List<CargaDTO> cargas) {
		this.cargas = cargas;
	}
}
