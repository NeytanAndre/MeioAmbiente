package com.itb.tcc.reciclamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.tcc.reciclamais.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	@Query(value="SELECT * from usuarios u WHERE u.email=?", nativeQuery = true)
	Usuario findByEmail(String email);
	
}
