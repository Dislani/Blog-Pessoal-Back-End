package com.generation.db_blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.db_blogpessoal.model.Postagem;
import com.generation.db_blogpessoal.repository.PostagemRepository;


/*ATIVIDADE CRUD BACKEND BLOG-PESSOAL – PARTE 02

Na segunda parte do Projeto Blog Pessoal iremos adicionar as seguintes características:

2- Na Classe PostagemController vamos adicionar os seguintes Métodos:

getById() com a função de trazer uma única Postagem identificada pelo id.

getByTitulo() com a função de trazer todas Postagens cujo titulo possua a palavra pesquisada.

post() com a função de gravar (persistir) uma nova Postagem no banco de dados.

put() com a função de atualizar os dados de uma Postagem.

delete() com a função de apagar uma Postagem no banco de dados.*/

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	
	
	
	@GetMapping ("/{id}") 					//@PathVariable captura o valor que vem pela url
	public ResponseEntity<Postagem>GetById(@PathVariable long id) {
		return repository.findById(id) 
				.map(resp -> ResponseEntity.ok(resp)) 
					.orElse(ResponseEntity.notFound().build()); //orElse retorna notfound caso a resposta venha nula
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>>GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
				
	}
				
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

