package zup.controlesorteio.ControleSorteio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zup.controlesorteio.ControleSorteio.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsuario(String usuario);
}
