package springdatatestes.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import springdatatestes.orm.Entregador;
import springdatatestes.repository.custom.CustomEntregadorRepository;

public class EntregadorDinamicConsultRepository implements CustomEntregadorRepository{

	private EntityManager entityManager;
	
	public EntregadorDinamicConsultRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Entregador> customFindMethod(String nome, String cpf, BigDecimal salario) {
		
		String query = "SELECT e FROM Entregador e ";
		String condicao = " WHERE ";
		
		if(nome != null) {
			query += condicao + " q.nome = :nome";
			condicao = " AND ";			
		}
		
		if(cpf != null) {
			query += condicao + " q.cpf = :cpf";
			condicao = " AND ";
		}
		
		if(salario != null) {
			query += condicao + " q.salario = :salario ";
		}
		
		TypedQuery<Entregador> pesq = entityManager.createNamedQuery(query, Entregador.class);
		
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
