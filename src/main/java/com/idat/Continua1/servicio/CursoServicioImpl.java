package com.idat.Continua1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Continua1.dto.CursoDTORequest;
import com.idat.Continua1.dto.CursoDTOResponse;
import com.idat.Continua1.modelo.Curso;
import com.idat.Continua1.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio {

	@Autowired
	public CursoRepositorio repositorio;
	
	@Override
	public void guardarCurso(CursoDTORequest curso) {
		Curso c = new Curso();
		c.setIdCurso(curso.getIdCursoDTO());
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());		
		repositorio.save(c);		
	}

	@Override
	public void editarCurso(CursoDTORequest curso) {
		Curso c = new Curso();
		c.setIdCurso(curso.getIdCursoDTO());
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		repositorio.saveAndFlush(c);
	}

	@Override
	public void eliminarCurso(Integer id) {
		repositorio.deleteById(id);		
	}

	@Override
	public List<CursoDTOResponse> listarCurso() {		
		
		List<CursoDTOResponse> lista = new ArrayList<CursoDTOResponse>();
		CursoDTOResponse c = null;
				
		for (Curso curso : repositorio.findAll()) {
			c = new CursoDTOResponse();
			c.setIdCursoDTO(curso.getIdCurso());
			c.setCursoDTO(curso.getCurso());
			c.setDescripcionDTO(curso.getDescripcion());
			lista.add(c);
		}
		return lista;		
	}

	@Override
	public CursoDTOResponse obtenerCursoporId(Integer id) {
		Curso curso = repositorio.findById(id).orElse(null);
		
		CursoDTOResponse c = new CursoDTOResponse();
		c.setIdCursoDTO(curso.getIdCurso());
		c.setCursoDTO(curso.getCurso());
		c.setDescripcionDTO(curso.getDescripcion());
				
		return c;
	}
}
