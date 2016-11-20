package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.TarifaDTO;

@Entity
@Table(name = "Tarifa")
public class Tarifa {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdTarifa", nullable = false)
	// @GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;

	@OneToOne
	@JoinColumn(name = "idTipoSeguro")
	private TipoSeguro tipoSeguro;

	@Column(name = "Valor")
	private float valor;

	@ManyToOne
	@JoinColumn(name = "idCompaniaSeguro")
	private CompaniaSeguro compania;

	public Tarifa() {
		// super();
	}

	public Tarifa(TarifaDTO tarifa) {
		this.codigo = tarifa.getCodigo();
		this.valor = tarifa.getValor();
		TipoSeguro tipoSeguro = new TipoSeguro(tarifa.getTipoSeguro());
		this.tipoSeguro = tipoSeguro;
	}

	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/*
	 * public int getIdTipoSeguro() { return idTipoSeguro; }
	 * 
	 * public void setIdTipoSeguro(int idTipoSeguro) { this.idTipoSeguro =
	 * idTipoSeguro; }
	 */

	/*
	 * public int getIdTipoMercaderia() { return idTipoMercaderia; }
	 * 
	 * public void setIdTipoMercaderia(int idTipoMercaderia) {
	 * this.idTipoMercaderia = idTipoMercaderia; }
	 */

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public static List<TarifaDTO> toDto(List<Tarifa> tarifas) {
		List<TarifaDTO> dtos = new ArrayList<TarifaDTO>();
		for (Tarifa tarifa : tarifas) {
			dtos.add(tarifa.toDto());
		}
		return dtos;
	}

	private TarifaDTO toDto() {
		TarifaDTO dto = new TarifaDTO();
		dto.setCodigo(this.codigo);
		dto.setTipoSeguro(this.tipoSeguro.toDto());
		dto.setValor(this.valor);
		return dto;
	}

	public static List<Tarifa> fromDtos(List<TarifaDTO> dtos) {
		List<Tarifa> tarifas = new ArrayList<Tarifa>();
		for (TarifaDTO dto : dtos) {
			tarifas.add(fromDto(dto));
		}
		return tarifas;
	}

	private static Tarifa fromDto(TarifaDTO dto) {
		Tarifa tarifa = new Tarifa();
		tarifa.setCodigo(dto.getCodigo());
		tarifa.setTipoSeguro(TipoSeguro.fromDto(dto.getTipoSeguro()));
		tarifa.setValor(dto.getValor());
		return tarifa;
	}

	/*
	 * public ItemFactura getItemFactura() { return itemFactura; }
	 * 
	 * public void setItemFactura(ItemFactura itemFactura) { this.itemFactura =
	 * itemFactura; }
	 */
}
