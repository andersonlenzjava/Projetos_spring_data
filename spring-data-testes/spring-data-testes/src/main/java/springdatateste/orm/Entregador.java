package springdatateste.orm;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Entrg")
public class Entregador extends Funcionario {

	private String chaveMoto;
	private String chaveArmarioEntregas;
	
	public Entregador(String nome, String cpf, BigDecimal salario, String chaveMoto, String chaveArmarioEntregas) {
		super (nome, cpf, salario);
		this.chaveMoto = chaveMoto;
		this.chaveArmarioEntregas = chaveArmarioEntregas;
	}
	
	public Entregador() {
	}

	public String getChaveMoto() {
		return chaveMoto;
	}

	public void setChaveMoto(String chaveMoto) {
		this.chaveMoto = chaveMoto;
	}

	public String getChaveArmarioEntregas() {
		return chaveArmarioEntregas;
	}

	public void setChaveArmarioEntregas(String chaveArmarioEntregas) {
		this.chaveArmarioEntregas = chaveArmarioEntregas;
	}

	@Override
	public String toString() {
		return "Entregador [" + "id=" + this.getId() + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() 
		+ ", salario=" + this.getSalario() + "chaveMoto=" + chaveMoto + ", chaveArmarioEntregas=" + chaveArmarioEntregas + "]";
	}

	
}
