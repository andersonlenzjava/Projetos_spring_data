package springdatateste.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdatateste.orm.Entregador;

@Repository
public interface EntregadorRepository extends CrudRepository<Entregador, Long>, JpaSpecificationExecutor<Entregador> {

	boolean existsByNomeAndCpfIgnoreCase(String nome, String cpf);
	
	Entregador findByFirstNameIgnoreCase(String nome);
	
}
