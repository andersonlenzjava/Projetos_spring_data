package springdatateste.orm;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gert")
public class Gerente extends Funcionario {

	private String chaveCofre;
	private Double numeroTelefone;
	private String loginSecreto;
	private String senhaSecreta;
	
	public Gerente(String nome, String cpf, BigDecimal salario, String chaveCofre,
			Double numeroTelefone, String loginSecreto, String senhaSecreta) {
		super (nome, cpf, salario);
		this.chaveCofre = chaveCofre;
		this.numeroTelefone = numeroTelefone;
		this.loginSecreto = loginSecreto;
		this.senhaSecreta = senhaSecreta;
	}
	
	public Gerente() {
	}

	public String getChaveCofre() {
		return chaveCofre;
	}

	public void setChaveCofre(String chaveCofre) {
		this.chaveCofre = chaveCofre;
	}

	public Double getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Double numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getLoginSecreto() {
		return loginSecreto;
	}

	public void setLoginSecreto(String loginSecreto) {
		this.loginSecreto = loginSecreto;
	}

	public String getSenhaSecreta() {
		return senhaSecreta;
	}

	public void setSenhaSecreta(String senhaSecreta) {
		this.senhaSecreta = senhaSecreta;
	}

	@Override
	public String toString() {
		return "Gerente ["+ "id=" + this.getId() + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", salario=" + this.getSalario() 
		+ "chaveCofre=" + chaveCofre + ", numeroTelefone=" + numeroTelefone + ", loginSecreto=" + loginSecreto + ", senhaSecreta=" + senhaSecreta + "]";
	}

	
}
