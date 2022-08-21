package com.generation.db_blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_postagens")
public class Postagem {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		
		@NotNull (message= "O atributo titulo é obrigatorio") // a anotação @NotNull não permite que o valor seja nulo, mas permite campos vazios.
		@Size( min= 5, max= 100, message= " O atributo deve conter no minimo 05 e no maximo 100 caracteres") 
		private String titulo;
		
		
		@NotNull (message = "O atributo texto é obrigatorio ")
		@Size( min= 10, max= 1000, message= "O atributo texto deve conter no minimo 10 e no maximo 1000")
		private String texto;
		
		
		@UpdateTimestamp
		private LocalDateTime data;
		
		
		@ManyToOne
		@JsonIgnoreProperties("postagem") //
		private Tema tema;
		
		
		@ManyToOne
		@JsonIgnoreProperties ("postagem") //
		private Usuario usuario;


		
		/*Iserção dos Getters e Setters*/
		
		
		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTitulo() {
			return titulo;
		}


		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		public String getTexto() {
			return texto;
		}


		public void setTexto(String texto) {
			this.texto = texto;
		}


		public LocalDateTime getData() {
			return data;
		}


		public void setData(LocalDateTime data) {
			this.data = data;
		}


		public Tema getTema() {
			return tema;
		}


		public void setTema(Tema tema) {
			this.tema = tema;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		
		
		
		
		
		
		
	}

