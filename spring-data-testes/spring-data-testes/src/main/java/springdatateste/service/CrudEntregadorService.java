package springdatateste.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import springdatateste.orm.Entregador;
import springdatateste.repository.EntregadorDinamicConsultRepository;
import springdatateste.repository.EntregadorRepository;

@Service
public class CrudEntregadorService {
	
	private final EntregadorRepository entregadorRepository;
	private final EntregadorDinamicConsultRepository entregadorDinamicRepository;
	
	public CrudEntregadorService(EntregadorRepository entregadorRepository, 
			EntregadorDinamicConsultRepository entregadorDinamicRepository) {
		this.entregadorRepository = entregadorRepository;
		this.entregadorDinamicRepository = entregadorDinamicRepository;
	}
	
	public void inicial(Scanner scanner) {
		Boolean system = true;
		while (system) {
			System.out.println("Qual acao de entregador deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			System.out.println("5 - Busca dinamica");

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
			case 5:
				buscaDinamica(scanner);
				break;	
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {
		
		System.out.println("Nome do entregador: ");
		String nome = scanner.next();
		System.out.println("CPF do entregador: ");
		String cpf = scanner.next();
		System.out.println("Salario do entregador: ");
		BigDecimal salario = scanner.nextBigDecimal();
		System.out.println("Chave da moto do entregador: ");
		String chaveMoto = scanner.next();
		System.out.println("Chave do Armario entregas do entregador: ");
		String chaveArmarioEntregas = scanner.next();
		Entregador entregador = new Entregador(nome, cpf, salario, chaveMoto, chaveArmarioEntregas);
		
		if (!entregadorRepository.existsByNomeAndCpfIgnoreCase(nome, cpf)) {
			entregadorRepository.save(entregador);
			System.out.println("Salvo");
		} else {
			System.out.println("Entregador já existe");
		}
	}

	private void atualizar(Scanner scanner) {

		System.out.println("Digite o id do Entregador");
		Long id = scanner.nextLong();

		Optional<Entregador> optional = entregadorRepository.findById(id);

		if (optional.isPresent()) {
			Entregador entregador = optional.get();
			System.out.println("Nome do entregador: ");
			String nome = scanner.next();
			System.out.println("CPF do entregador: ");
			String cpf = scanner.next();
			System.out.println("Salario do entregador: ");
			BigDecimal salario = scanner.nextBigDecimal();
			System.out.println("Chave da moto do entregador: ");
			String chaveMoto = scanner.next();
			System.out.println("Chave do Armario entregas do entregador: ");
			String chaveArmarioEntregas = scanner.next();
			
			entregador.setNome(nome);
			entregador.setCpf(cpf);
			entregador.setSalario(salario);
			entregador.setChaveMoto(chaveMoto);
			entregador.setChaveArmarioEntregas(chaveArmarioEntregas);
			
			entregadorRepository.save(entregador);
			System.out.println("Entregador de id " + id + " atualizado com sucesso!");
		} else {
			new RuntimeException("Entregador de id" + id + "não localizado");
		}
	}

	private void visualizar() {
		Iterable<Entregador> entregadores = entregadorRepository.findAll();
		entregadores.forEach(entregador -> System.out.println(entregador));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Id");
		Long id = scanner.nextLong();
		entregadorRepository.deleteById(id);
		System.out.println("Deletado");
	}
	
	private void buscaDinamica(Scanner scanner) {
		System.out.println("Nome do entregador: ");
		String nome = scanner.next();
		System.out.println("CPF do entregador: ");
		String cpf = scanner.next();
		System.out.println("Salario do entregador: ");
		BigDecimal salario = scanner.nextBigDecimal();
		Iterable<Entregador> entregadores = entregadorDinamicRepository.customFindMethod(nome, cpf, salario);
		entregadores.forEach(entregador -> System.out.println(entregador));
	}
}
