package com.idat.Continua1.servicio;

import java.util.List;

import com.idat.Continua1.dto.MallacurricularDTORequest;
import com.idat.Continua1.dto.MallacurricularDTOResponse;

public interface MallacurricularServicio {
	
	public void guardarMalla(MallacurricularDTORequest malla);
	public void editarMalla(MallacurricularDTORequest  malla);
	public void eliminarMalla(Integer id);
	public List<MallacurricularDTOResponse > listarMalla();
	public MallacurricularDTOResponse  obtenerMallaporId(Integer id);

}
