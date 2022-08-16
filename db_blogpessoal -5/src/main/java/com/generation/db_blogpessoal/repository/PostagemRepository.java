package com.generation.db_blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.db_blogpessoal.model.Postagem;

/*ATIVIDADE CRUD BACKEND BLOG-PESSOAL – PARTE 02

Na segunda parte do Projeto Blog Pessoal iremos adicionar as seguintes características:

1- Na Interface PostagemRepository vamos adicionar o Método de busca específica:
findAllByTituloContainingIgnoreCase() com a função de trazer todas as  Postagens cujo título possua a palavra pesquisada.*/


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	/*SELECT * FROM tb_postagens WHERE titulo = ""*/
	/*SELECT * titulo FROM tb_postagens WHERE titulo LIKE="%titulo%"*/
}

