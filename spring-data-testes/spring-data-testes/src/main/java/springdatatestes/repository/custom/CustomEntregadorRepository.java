package springdatatestes.repository.custom;

import java.math.BigDecimal;
import java.util.List;

import springdatatestes.orm.Entregador;

public interface CustomEntregadorRepository {
	List<Entregador> customFindMethod(String nome, String cpf, BigDecimal salario);
}
