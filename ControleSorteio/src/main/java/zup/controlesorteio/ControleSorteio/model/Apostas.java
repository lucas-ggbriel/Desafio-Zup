package zup.controlesorteio.ControleSorteio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Apostas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String email;
	@NotNull
	private int aposta;
	
	public Apostas(String email, int aposta) {
		this.email = email;
		this.aposta = aposta;
	}
	public Apostas() {
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAposta() {
		return aposta;
	}

	public void setAposta(int aposta) {
		this.aposta = aposta;
	}
}
