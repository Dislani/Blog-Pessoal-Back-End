package com.generation.db_blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.db_blogpessoal.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@BeforeAll
	void start(){

		usuarioRepository.deleteAll();
		
		usuarioRepository.save(new Usuario(0L, "Dislani Melo da Silva","dislanidasilva@gmail.com","12345677", "https://i.imgur.com/FETvs20.jpg", " "));
		
		usuarioRepository.save(new Usuario(0L,"Amanda silva","amandasilva@gmail.com","12345678", "https://i.imgur.com/NtyGneo.jpg", " "));
		
		usuarioRepository.save(new Usuario(0L,"Alice Maria","alicemaria@gmail.com","12345679", "https://i.imgur.com/mB3VM2N.jpg", " "));
		
		usuarioRepository.save(new Usuario(0L,"Joana Albuquerque da Silva","joanaalbuquerquesilva@gmail.com","12345680","https://i.imgur.com/JR7kUFU.jpg", " " ));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("dislanidasilva@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("dislanidasilva@gmail.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");

		assertEquals(3, listaDeUsuarios.size());
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Dislani Melo da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Amanda silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Joana Albuquerque da Silva"));
		
	}

	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
	
}
