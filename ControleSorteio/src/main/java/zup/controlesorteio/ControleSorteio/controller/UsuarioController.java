package zup.controlesorteio.ControleSorteio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zup.controlesorteio.ControleSorteio.model.Usuario;
import zup.controlesorteio.ControleSorteio.model.UsuarioLogin;
import zup.controlesorteio.ControleSorteio.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastroUsuario(@RequestBody Usuario user){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(user));
		
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> logarUsuario(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}	
	
}
