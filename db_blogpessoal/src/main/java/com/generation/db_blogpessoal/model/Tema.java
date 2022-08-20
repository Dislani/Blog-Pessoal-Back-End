package com.generation.db_blogpessoal.model;


/* 	01 – Criar o Recurso Tema

(1)Na Camada Model será criada a Classe Tema com os seus respectivos atributos.
(2)A Classe Tema criará a Tabela tb_temas no Banco de dados db_blogpessoal.

02 – Criar o Relacionamento entre as Classes Tema e Postagem

(1)Na Camada Model, na Classe Tema, crie a Relação OneToMany com a Classe Postagem. Não esqueça de adicionar todas as Anotações e Métodos Get e Set necessários.
(2)2Na Camada Model, na Classe Postagem, crie a Relação ManyToOne com a Classe Tema. Não esqueça de adicionar todas as Anotações e Métodos Get e Set necessários.
(3)Em especial, não esqueça da anotação @JsonIgnoreProperties para inibir a Recursividade no relacionamento.
(4)Faça os ajustes necessários no Insomnia para Inserir e Atualizar os dados do Recurso Postagem, habilitando o Relacionamento.
(5)Teste todes os Métodos dos Recursos Tema e Postagem no Insomnia.
(6)Verifique nos Testes se ao listar as Postagens, o respectivo Tema associado é exibido, como mostra a figura abaixo:
(7)Verifique nos Testes se ao listar os Temas, as Postagens associadas serão exibidas.

*/
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_temas")
public class Tema {

			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			
			@NotNull
			private String descricao;
			
			
			@OneToMany(mappedBy = "tema",cascade= CascadeType.ALL)
			@JsonIgnoreProperties("tema")
			private List<Postagem> postagem;


			public long getId() {
				return id;
			}


			public void setId(long id) {
				this.id = id;
			}


			public String getDescricao() {
				return descricao;
			}


			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}


			public List<Postagem> getPostagem() {
				return postagem;
			}


			public void setPostagem(List<Postagem> postagem) {
				this.postagem = postagem;
			}
			
			
			
	
}
