package com.generation.db_blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.db_blogpessoal.model.Tema;



/* 	01 – Criar o Recurso Tema

(3)- Na Camada Repository será criada a Interface TemaRepository (com a capacidade de se comunicar com o banco de dados MySQL).

(4)- Na Interface TemaRepository vamos adicionar o Método de busca específica:

findAllByDescricaoContainingIgnoreCase() com a função de trazer todes os Temas cuja descrição possua a palavra pesquisada.


*/
public interface TemaRepository extends JpaRepository<Tema,Long>{
	
	 public List<Tema> findAllByDescricaoContainingIgnoreCase (String descricao); 
	 
}
