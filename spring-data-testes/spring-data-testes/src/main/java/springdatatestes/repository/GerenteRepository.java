package springdatatestes.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdatatestes.orm.Gerente;

@Repository
public interface GerenteRepository extends CrudRepository<Gerente, Long>, JpaSpecificationExecutor<Gerente>  {

	boolean existsByNomeAndCpfAndLoginSecretoIgnoreCase(String nome, String cpf, String loginSecreto);
	
}
