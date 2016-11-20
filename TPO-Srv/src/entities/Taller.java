package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dto.TallerDTO;

@Entity
@Table(name="talleres")
public class Taller {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	
	@OneToOne
	@JoinColumn (name = "IdUbicacion")
	private Ubicacion ubicacion;
	
	public Taller(){
		
	}

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

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public TallerDTO toDto(){
		TallerDTO t = new TallerDTO();
		t.setCodigo(codigo);
		t.setNombre(nombre);
		t.setUbicacion(ubicacion.toDto());
		return t;
	}

	public static Taller fromDto(TallerDTO dto) {
		Taller taller = new Taller();
		taller.setCodigo(dto.getCodigo());
		taller.setNombre(dto.getNombre());
		taller.setUbicacion(Ubicacion.fromDto(dto.getUbicacion()));
		return taller;
	}
}
