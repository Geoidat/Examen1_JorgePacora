package com.idat.Continua1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Continua1.dto.UniversidadDTORequest;
import com.idat.Continua1.dto.UniversidadDTOResponse;
import com.idat.Continua1.modelo.Universidad;
import com.idat.Continua1.repositorio.UniversidadRepositorio;

@Service  
public class UniversidadServicioImpl implements UniversidadServicio{

	@Autowired
	public UniversidadRepositorio repositorio;
	
	
	@Override
	public void guardarUniversidad(UniversidadDTORequest universidad ) {
		Universidad u = new Universidad();
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		u.setUniversidad(universidad.getUniversidadDTO());
		repositorio.save(u);		
	}

	@Override
	public void editarUniversidad(UniversidadDTORequest universidad) {
		Universidad u = new Universidad();
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		u.setUniversidad(universidad.getUniversidadDTO());
		repositorio.saveAndFlush(u);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);		
	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidad() {		
		
		List<UniversidadDTOResponse> lista = new ArrayList<UniversidadDTOResponse>();
		UniversidadDTOResponse u = null;
				
		for (Universidad universidad : repositorio.findAll()) {
			u = new UniversidadDTOResponse();
			u.setIdUniversidadDTO(universidad.getIdUniversidad());
			u.setUniversidadDTO(universidad.getUniversidad());
			lista.add(u);
		}
		return lista;		
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidadporId(Integer id) {
		Universidad universidad = repositorio.findById(id).orElse(null);
		
		UniversidadDTOResponse u = new UniversidadDTOResponse();
		u.setIdUniversidadDTO(universidad.getIdUniversidad());
		u.setUniversidadDTO(universidad.getUniversidad());
						
		return u;
	}

}
