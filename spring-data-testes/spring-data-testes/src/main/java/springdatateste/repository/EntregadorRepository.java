package springdatateste.repository;

import java.math.BigDecimal;
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
	
	@Query("SELECT e FROM Entregador e WHERE e.salario = :salario")
	List<Entregador> findBySalarioFuncionario(@Param("salario") BigDecimal salario);

}
