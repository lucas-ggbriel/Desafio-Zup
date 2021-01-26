package zup.controlesorteio.ControleSorteio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zup.controlesorteio.ControleSorteio.model.Apostas;
import zup.controlesorteio.ControleSorteio.repository.ApostasRepository;
import zup.controlesorteio.ControleSorteio.service.RegrasNegocio;

@RestController
@RequestMapping("/apostas")
public class ApostasController {
	
	@Autowired
	ApostasRepository apostasRepository;
	@Autowired
	RegrasNegocio regrasNegocio = new RegrasNegocio();
	
	@GetMapping
	public ResponseEntity<List<Apostas>> listarApostas(){
		return ResponseEntity.ok(apostasRepository.findAll());
	}
	
	@GetMapping("/listar/{email}")
	public ResponseEntity<List<String>> listarApostasPorEmail(@PathVariable String email){
		return ResponseEntity.ok(apostasRepository.listarApostasPorEmail(email));
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarAposta(@RequestBody Apostas aposta){
		return regrasNegocio.cadastrarAposta(aposta);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Apostas> atualizarApostas(@RequestBody Apostas aposta){
		return ResponseEntity.ok(apostasRepository.save(aposta));
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable long id) {
		apostasRepository.deleteById(id);
	}
	
}
