package com.idat.Continua1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Continua1.modelo.Curso;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer> {
	
	
}
