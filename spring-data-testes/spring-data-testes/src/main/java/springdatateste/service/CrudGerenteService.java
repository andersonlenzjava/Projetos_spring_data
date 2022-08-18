package springdatateste.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import springdatateste.orm.Gerente;
import springdatateste.repository.GerenteRepository;

@Service
public class CrudGerenteService {

	private final GerenteRepository gerenteRepository;

	public CrudGerenteService(GerenteRepository gerenteRepository) {
		this.gerenteRepository = gerenteRepository;
	}

	public void inicial(Scanner scanner) {
		Boolean system = true;
		while (system) {
			System.out.println("Qual acao de gerente deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {

		System.out.println("Nome do gerente: ");
		String nome = scanner.next();
		System.out.println("CPF do gerente: ");
		String cpf = scanner.next();
		System.out.println("Salario do gerente: ");
		BigDecimal salario = scanner.nextBigDecimal();
		System.out.println("Chave do cofre: ");
		String chaveCofre = scanner.next();
		System.out.println("numero do telefone: ");
		Double numeroTelefone = scanner.nextDouble();
		System.out.println("Login secreto: ");
		String loginSecreto = scanner.next();
		System.out.println("Senha secreto: ");
		String senhaSecreta = scanner.next();

		Gerente gerente = new Gerente(nome, cpf, salario, chaveCofre, numeroTelefone, loginSecreto, senhaSecreta);

		if (!gerenteRepository.existsByNomeAndCpfAndLoginSecretoIgnoreCase(nome, cpf, loginSecreto)) {
			gerenteRepository.save(gerente);
			System.out.println("Salvo");
		} else {
			System.out.println("Gerente já existe");
		}
	}

	private void atualizar(Scanner scanner) {

		System.out.println("Digite o id do Gerente");
		Long id = scanner.nextLong();

		Optional<Gerente> optional = gerenteRepository.findById(id);

		if (optional.isPresent()) {
			Gerente gerente = optional.get();
			System.out.println("Nome do gerente: ");
			String nome = scanner.next();
			System.out.println("CPF do gerente: ");
			String cpf = scanner.next();
			System.out.println("Salario do gerente: ");
			BigDecimal salario = scanner.nextBigDecimal();
			System.out.println("Chave do cofre: ");
			String chaveCofre = scanner.next();
			System.out.println("numero do telefone: ");
			Double numeroTelefone = scanner.nextDouble();
			System.out.println("Login secreto: ");
			String loginSecreto = scanner.next();
			System.out.println("Senha secreto: ");
			String senhaSecreta = scanner.next();

			gerente.setNome(nome);
			gerente.setCpf(cpf);
			gerente.setSalario(salario);
			gerente.setChaveCofre(chaveCofre);
			gerente.setNumeroTelefone(numeroTelefone);
			gerente.setLoginSecreto(loginSecreto);
			gerente.setSenhaSecreta(senhaSecreta);

			gerenteRepository.save(gerente);
			System.out.println("Gerente de id " + id + " atualizado com sucesso!");
		} else {
			new RuntimeException("Gerente de id" + id + "não localizado");
		}
	}

	private void visualizar() {
		Iterable<Gerente> gerentes = gerenteRepository.findAll();
		gerentes.forEach(gerente -> System.out.println(gerente));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Id");
		Long id = scanner.nextLong();
		gerenteRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
