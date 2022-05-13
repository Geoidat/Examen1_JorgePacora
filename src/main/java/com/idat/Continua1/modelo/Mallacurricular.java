package com.idat.Continua1.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Malla")
@Entity
public class Mallacurricular implements Serializable{
	
	private static final long serialVersionUID = 6751436212348286828L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private Integer año;
	
	@OneToOne
	@JoinColumn(name = "id_universidad", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_universidad) references universidad(id_universidad)"))
	private Universidad universidad;
	
	@ManyToOne(mappedBy = "malla")
	private Curso curso;
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public Mallacurricular() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mallacurricular(Integer idMalla, Integer año) {
		super();
		this.idMalla = idMalla;
		this.año = año;
	}	
}
