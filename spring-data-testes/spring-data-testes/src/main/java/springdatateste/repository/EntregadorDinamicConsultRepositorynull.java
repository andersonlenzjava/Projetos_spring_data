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
public class EntregadorDinamicConsultRepositorynull {

	@PersistenceContext
	private EntityManager entityManager;

	// Para o caso de aceitar passar campos nulos (VERIFICAR COMO FAZER AS FUNÇÕES ACEITAREM ISTO)
	public List<Entregador> customFindMethod(String nome, String cpf, BigDecimal salario) {
		
		String query = "SELECT e FROM Entregador e ";
		String condicao = " WHERE ";
		
		if(nome != null) {
			query += condicao + " e.nome = :nome";
			condicao = " AND ";			
		}
		
		if(cpf != null) {
			query += condicao + " e.cpf = :cpf";
			condicao = " AND ";
		}
		
		if(salario != null) {
			query += condicao + " e.salario = :salario ";
		}
		
		TypedQuery<Entregador> pesq = entityManager.createQuery(query, Entregador.class);
		
		if(nome != null) {
			pesq.setParameter("nome", nome);			
		}
		
		if(cpf != null) {
			pesq.setParameter("cpf", cpf);
		}
		
		if(salario != null) {
			pesq.setParameter("salario", salario);
		}
		
		return pesq.getResultList();
	}

}
