package com.idat.Continua1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Continua1.dto.MallacurricularDTORequest;
import com.idat.Continua1.dto.MallacurricularDTOResponse;
import com.idat.Continua1.modelo.Mallacurricular;
import com.idat.Continua1.repositorio.MallacurricularRepositorio;

@Service
public class MallacurricularServicioImpl implements MallacurricularServicio{

	@Autowired
	public MallacurricularRepositorio repositorio;
	
	
	@Override
	public void guardarMalla(MallacurricularDTORequest malla) {
		Mallacurricular m = new Mallacurricular();
		m.setIdMalla(malla.getIdMallaDTO());
		m.setAño(malla.getAñoDTO());
		repositorio.save(m);		
	}

	@Override
	public void editarMalla(MallacurricularDTORequest malla) {
		Mallacurricular m = new Mallacurricular();
		m.setIdMalla(malla.getIdMallaDTO());
		m.setAño(malla.getAñoDTO());
		repositorio.saveAndFlush(m);
	}

	@Override
	public void eliminarMalla(Integer id) {
		repositorio.deleteById(id);		
	}

	@Override
	public List<MallacurricularDTOResponse> listarMalla() {		
		
		List<MallacurricularDTOResponse> lista = new ArrayList<MallacurricularDTOResponse>();
		MallacurricularDTOResponse m = null;
				
		for (Mallacurricular malla : repositorio.findAll()) {
			m = new MallacurricularDTOResponse();
			m.setIdMallaDTO(malla.getIdMalla());
			m.setAñoDTO(malla.getAño());
			lista.add(m);
		}
		return lista;		
	}

	@Override
	public MallacurricularDTOResponse obtenerMallaporId(Integer id) {
		Mallacurricular malla = repositorio.findById(id).orElse(null);
		
		MallacurricularDTOResponse m = new MallacurricularDTOResponse();
		m.setIdMallaDTO(malla.getIdMalla());
		m.setAñoDTO(malla.getAño());				
		return m;
	}

}
