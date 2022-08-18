package springdatateste.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import springdatateste.orm.Entregador;

@Repository
public class EntregadorDinamicConsultRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Entregador> customFindMethod(String nome, String cpf, BigDecimal salario) {
		
		String query = "SELECT e FROM Entregador e ";
		String condicao = " WHERE ";
		
		if(!(nome.equals("null"))) {
			query += condicao + " e.nome = :nome";
			condicao = " AND ";			
		}
		
		if(!(cpf.equals("null"))) {
			query += condicao + " e.cpf = :cpf";
			condicao = " AND ";
		}
		
		if(!(salario.compareTo(BigDecimal.ZERO) == 0)) {
			query += condicao + " e.salario = :salario ";
		}
		
		TypedQuery<Entregador> pesq = entityManager.createQuery(query, Entregador.class);
		
		if(!(nome.equals("null"))) {
			pesq.setParameter("nome", nome);			
		}
		
		if(!(cpf.equals("null"))) {
			pesq.setParameter("cpf", cpf);
		}
		
		if(!(salario.compareTo(BigDecimal.ZERO) == 0)) {
			pesq.setParameter("salario", salario);
		}
		
		return pesq.getResultList();
	}

}
