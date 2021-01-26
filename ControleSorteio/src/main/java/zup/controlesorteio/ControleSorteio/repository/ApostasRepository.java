package zup.controlesorteio.ControleSorteio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zup.controlesorteio.ControleSorteio.model.Apostas;

@Repository
public interface ApostasRepository extends JpaRepository<Apostas, Long>{
	
	@Query(value = "select aposta from apostas where email = :email", nativeQuery = true)
	public List<String> listarApostasPorEmail(@Param("email") String email);
}
