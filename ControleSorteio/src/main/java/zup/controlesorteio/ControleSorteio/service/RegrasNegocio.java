package zup.controlesorteio.ControleSorteio.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import zup.controlesorteio.ControleSorteio.model.Apostas;
import zup.controlesorteio.ControleSorteio.model.Cliente;
import zup.controlesorteio.ControleSorteio.repository.ApostasRepository;
import zup.controlesorteio.ControleSorteio.repository.ClienteRepository;

@Service
public class RegrasNegocio {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ApostasRepository apostaRepository;
	
	public ResponseEntity<String> protecaoDadoscliente(Cliente cliente){
		String verifica = clienteRepository.bucaClientePorEmail(cliente.getEmail());
		if(verifica == null) {
			Apostas aposta = new Apostas(cliente.getEmail(), cliente.getNumeroApostado());
			apostaRepository.save(aposta);
			clienteRepository.save(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso!");
		}else {						
			return ResponseEntity.ok("Já existe um usuário cadastrado com esse email!");
		}
	}
	
	public int geradorSorteio() {
		Random aleatorio = new Random();
		int num = aleatorio.nextInt(10000), num2 = aleatorio.nextInt(20000), newNumero = 0;
		
		String numero = Integer.toString(num) + Integer.toString(num2);
		
		if(numero.length() < 10) {
			newNumero = Integer.parseInt(numero);
			
			while(newNumero < 1000000000) {
				newNumero = newNumero * 111;
			}
			
		}
		
		return newNumero;
	}
	
	public ResponseEntity<String> cadastrarAposta(Apostas aposta){
		String verifica = clienteRepository.bucaClientePorEmail(aposta.getEmail());
		
		if(verifica == null) {
			return ResponseEntity.ok("Aposta não pode ser cadastrada pois o email não existe!");
		}else {
			apostaRepository.save(aposta);
			return ResponseEntity.ok("Aposta cadastrada com sucesso!");
		}
		
		
	}
}
