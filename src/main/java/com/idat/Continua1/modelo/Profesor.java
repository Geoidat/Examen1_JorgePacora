package com.idat.Continua1.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Profesor")
@Entity
public class Profesor implements Serializable {
	
	private static final long serialVersionUID = -8292346866821603652L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String profesor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "profesor_curso",
	joinColumns = @JoinColumn(name = "id_curso", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(id_curso) references curso(id_curso)")),
	
	inverseJoinColumns = @JoinColumn(name = "id_profesor", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(id_profesor) references profesor(id_profesor)")))
	private List<Curso> curso;
	
	
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profesor(Integer idProfesor, String profesor) {
		super();
		this.idProfesor = idProfesor;
		this.profesor = profesor;
	}	
}
