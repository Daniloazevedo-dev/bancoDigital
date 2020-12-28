package br.com.bancodgital.api.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		usuario.setSaldo(new BigDecimal(10));
		
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = "application/json")
	public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable Long id) {
		return new ResponseEntity<Optional<Usuario>>(usuarioService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/saldo/{id}", produces = "application/json")
	public ResponseEntity<BigDecimal> getSaldo(@PathVariable Long id) {
		
		Optional<Usuario> usuario = usuarioService.findById(id);
		
		return new ResponseEntity<BigDecimal>(usuario.get().getSaldo(), HttpStatus.OK);
		
	}
	
} 
