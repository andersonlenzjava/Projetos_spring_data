package springdatatestes.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdatatestes.orm.Entregador;

@Repository
public interface EntregadorRepository extends CrudRepository<Entregador, Long>, JpaSpecificationExecutor<Entregador> {

	boolean existsByNomeAndCpfIgnoreCase(String nome, String cpf);
	
}
