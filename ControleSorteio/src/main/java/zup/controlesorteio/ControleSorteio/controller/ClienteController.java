package zup.controlesorteio.ControleSorteio.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zup.controlesorteio.ControleSorteio.model.Cliente;
import zup.controlesorteio.ControleSorteio.repository.ApostasRepository;
import zup.controlesorteio.ControleSorteio.repository.ClienteRepository;
import zup.controlesorteio.ControleSorteio.service.RegrasNegocio;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ApostasRepository apostaRepository;
	@Autowired
	RegrasNegocio tratativaDados = new RegrasNegocio();
	
	@GetMapping("/geradorsorteio")
	public ResponseEntity<String> geradorSorteio(){
		int numeroSorteado = tratativaDados.geradorSorteio();
		String sorteio =  Integer.toString(numeroSorteado);
		return ResponseEntity.ok(sorteio);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente){	
		return tratativaDados.protecaoDadoscliente(cliente);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	@DeleteMapping
	public void deletar() {
		clienteRepository.deleteAll();
	}
	
}