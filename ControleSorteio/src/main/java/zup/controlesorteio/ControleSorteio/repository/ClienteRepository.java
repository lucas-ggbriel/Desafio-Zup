package zup.controlesorteio.ControleSorteio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zup.controlesorteio.ControleSorteio.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query(value="select id from cliente where email = :email", nativeQuery = true)
	public String bucaClientePorEmail(@Param("email") String email);
}
