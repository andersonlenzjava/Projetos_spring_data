package springdatateste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springdatateste.orm.Entregador;

@Repository
public interface EntregadorRepository extends CrudRepository<Entregador, Long>, JpaSpecificationExecutor<Entregador> {

	boolean existsByNomeAndCpfIgnoreCase(String nome, String cpf);
	
	@Query("SELECT e FROM Entregador e WHERE e.nome = :nome")
	List<Entregador> findByNamefuncionario(@Param("nome") String nome);

}
