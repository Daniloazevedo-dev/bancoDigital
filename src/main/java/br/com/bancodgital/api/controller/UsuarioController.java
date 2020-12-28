package br.com.bancodgital.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancodgital.api.service.UsuarioService;
import br.com.bancodgital.api.user.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/incluir", produces = "application/json")
	public ResponseEntity<Usuario> incluirUsuario(@RequestBody Usuario usuario) {		
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}
	
} 
