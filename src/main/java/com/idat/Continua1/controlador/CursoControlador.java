package com.idat.Continua1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Continua1.dto.CursoDTORequest;
import com.idat.Continua1.dto.CursoDTOResponse;
import com.idat.Continua1.servicio.CursoServicio;

@RestController
@RequestMapping("/curso/v1")
public class CursoControlador {
	
	@Autowired
	private CursoServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>> listarCurso(){
		return new ResponseEntity<List<CursoDTOResponse>>(servicio.listarCurso(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarCurso(@RequestBody CursoDTORequest curso){
		servicio.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<CursoDTOResponse> listarPorId(@PathVariable Integer id){
		CursoDTOResponse c = servicio.obtenerCursoporId(id);
		if(c != null)
			return new ResponseEntity<CursoDTOResponse>(c, HttpStatus.OK);
		return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editarCurso(@RequestBody CursoDTORequest curso){
		CursoDTOResponse c = servicio.obtenerCursoporId(curso.getIdCursoDTO());
		if(c != null) {
			servicio.editarCurso(curso);
		    return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCurso(@PathVariable Integer id){
		CursoDTOResponse c = servicio.obtenerCursoporId(id);
		if(c != null) {
			servicio.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);	
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);			
	}	
}
	
