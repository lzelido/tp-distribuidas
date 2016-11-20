package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import dao.ClienteDAO;
import dto.ParticularDTO;

@Entity
@Table(name = "Particular")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "IdCliente")
public class Particular extends Cliente {
	@Transient
	private static final long serialVersionUID = -3413901829279331340L;

	@Column(name = "PagoAdelantado")
	private boolean esPagoAdelantado;

	// GETTERS Y SETTERS
	public boolean isEsPagoAdelantado() {
		return esPagoAdelantado;
	}

	public void setEsPagoAdelantado(boolean esPagoAdelantado) {
		this.esPagoAdelantado = esPagoAdelantado;
	}

	public static Particular fromDto(ParticularDTO dto) {
		Particular cli = new Particular();
		cli.setCodigo(dto.getCodigo());
		cli.setEsPagoAdelantado(dto.isEsPagoAdelantado());
		cli.setNombre(dto.getNombre());
		cli.setNroDoc(dto.getNroDoc());
		cli.setReqManifiesto(dto.isReqManifiesto());
		cli.setTipoDoc(dto.getTipoDoc());
		return null;
	}

	public ParticularDTO toDto() {
		ParticularDTO particularDTO = new ParticularDTO();
		particularDTO.setCodigo(this.getCodigo());
		particularDTO.setTipoDoc(this.getTipoDoc());
		particularDTO.setNroDoc(this.getNroDoc());
		particularDTO.setNombre(this.getNombre());
		particularDTO.setReqManifiesto(this.isReqManifiesto());
		particularDTO.setEsPagoAdelantado(this.isEsPagoAdelantado());
		return particularDTO;
	}

	public void save() {
		ClienteDAO.getInstancia().save(this);
	}

	public void remove() {
		ClienteDAO.getInstancia().remove(this);
	}

}
