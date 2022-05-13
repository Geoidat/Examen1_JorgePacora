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

import com.idat.Continua1.dto.MallacurricularDTORequest;
import com.idat.Continua1.dto.MallacurricularDTOResponse;
import com.idat.Continua1.servicio.MallacurricularServicio;

@RestController
@RequestMapping("/malla/v1")
public class MallacurricularControlador {
	
	@Autowired
	private MallacurricularServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallacurricularDTOResponse>> listarMalla(){
		return new ResponseEntity<List<MallacurricularDTOResponse>>(servicio.listarMalla(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarMalla(@RequestBody MallacurricularDTORequest malla){
		servicio.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<MallacurricularDTOResponse> listarPorId(@PathVariable Integer id){
		MallacurricularDTOResponse m = servicio.obtenerMallaporId(id);
		if(m != null)
			return new ResponseEntity<MallacurricularDTOResponse>(m, HttpStatus.OK);
		return new ResponseEntity<MallacurricularDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editarMalla(@RequestBody MallacurricularDTORequest malla){
		MallacurricularDTOResponse m = servicio.obtenerMallaporId(malla.getIdMallaDTO());
		if(m != null) {
			servicio.editarMalla(malla);
		    return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarMalla(@PathVariable Integer id){
		MallacurricularDTOResponse m = servicio.obtenerMallaporId(id);
		if(m != null) {
			servicio.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);	
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);			
	}	

}
