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

import com.idat.Continua1.dto.ProfesorDTORequest;
import com.idat.Continua1.dto.ProfesorDTOResponse;
import com.idat.Continua1.servicio.ProfesorServicio;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorControlador {
	
	@Autowired
	private ProfesorServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTOResponse>> listarProfesor(){
		return new ResponseEntity<List<ProfesorDTOResponse>>(servicio.listarProfesor(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarProfesor(@RequestBody ProfesorDTORequest profesor){
		servicio.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ProfesorDTOResponse> listarPorId(@PathVariable Integer id){
		ProfesorDTOResponse p = servicio.obtenerProfesorporId(id);
		if(p != null)
			return new ResponseEntity<ProfesorDTOResponse>(p, HttpStatus.OK);
		return new ResponseEntity<ProfesorDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editarProfesor(@RequestBody ProfesorDTORequest profesor){
		ProfesorDTOResponse p = servicio.obtenerProfesorporId(profesor.getIdProfesorDTO());
		if(p != null) {
			servicio.editarProfesor(profesor);
		    return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id){
		ProfesorDTOResponse p = servicio.obtenerProfesorporId(id);
		if(p != null) {
			servicio.eliminarProfesor(id);
		    return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);			
	}	

}
