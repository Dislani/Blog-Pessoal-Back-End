package com.generation.db_blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.db_blogpessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
	
	public Optional<Usuario> findByUsuario (String usuario); //Optional usado quando se tem mais de uma opção de resposta.
	public List <Usuario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
