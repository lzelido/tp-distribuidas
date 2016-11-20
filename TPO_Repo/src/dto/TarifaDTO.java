package dto;

import java.io.Serializable;

public class TarifaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private TipoSeguroDTO tipoSeguro;
	private TipoMercaderiaDTO tipoMercaderia;
	private float valor;
	
	public TarifaDTO(){
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoSeguroDTO getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguroDTO tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public TipoMercaderiaDTO getTipoMercaderia() {
		return tipoMercaderia;
	}

	public void setTipoMercaderia(TipoMercaderiaDTO tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
