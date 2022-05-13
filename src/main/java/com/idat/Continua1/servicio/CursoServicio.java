package com.idat.Continua1.servicio;

import java.util.List;

import com.idat.Continua1.dto.CursoDTORequest;
import com.idat.Continua1.dto.CursoDTOResponse;

public interface CursoServicio {
	
	public void guardarCurso(CursoDTORequest curso);
	public void editarCurso(CursoDTORequest curso);
	public void eliminarCurso(Integer id);
	public List<CursoDTOResponse> listarCurso();
	public CursoDTOResponse obtenerCursoporId(Integer id);

}
