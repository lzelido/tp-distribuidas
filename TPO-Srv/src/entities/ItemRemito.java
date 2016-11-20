package entities;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dto.ItemRemitoDTO;

@Entity
@Table (name = "ItemRemito")
public class ItemRemito {
	private static final long serialVersionUID = 7303003145706082949L;

	@Id
	@Column (name = "IdItemRemito", nullable = false)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
		
	@OneToOne
	@JoinColumn (name = "IdCarga")
	private Carga carga;
	
	@ManyToOne
	@JoinColumn (name = "IdRemito")
	private Remito remito;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
	
	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public static List<ItemRemito> fromDtos(List<ItemRemitoDTO> dtos) {
		List<ItemRemito> items = new ArrayList<ItemRemito>();
		for (ItemRemitoDTO dto : dtos) {
			items.add(fromDto(dto));
		}
		return items;
	}
	
	public static ItemRemito fromDto(ItemRemitoDTO dto) {
		ItemRemito item = new ItemRemito();
		item.setCarga(Carga.fromDto(dto.getCarga()));
		item.setCodigo(dto.getCodigo());
		item.setRemito(Remito.fromDto(dto.getRemito()));
		return item;
	}
}
