package com.idat.Continua1.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Continua1.modelo.Universidad;

@Repository
public interface UniversidadRepositorio extends JpaRepository<Universidad, Integer>{	
	
}
