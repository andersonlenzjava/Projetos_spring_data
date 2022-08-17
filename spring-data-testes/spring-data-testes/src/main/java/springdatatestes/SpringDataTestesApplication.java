package springdatatestes;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springdatateste.service.CrudEntregadorService;
import springdatateste.service.CrudGerenteService;

@SpringBootApplication
@ComponentScan("springdatateste.service") 
@EnableJpaRepositories(basePackages = "springdatatestes.repository") // para localizar onde estão os repositórios
@EntityScan(basePackages = "springdatatestes.orm") 
public class SpringDataTestesApplication implements CommandLineRunner  {

	private Boolean system = true;

	private final CrudEntregadorService entregadorService;
	private final CrudGerenteService gerenteService;

	public SpringDataTestesApplication(
			CrudEntregadorService entregadorService,
			CrudGerenteService gerenteService) {
		this.entregadorService = entregadorService;
		this.gerenteService = gerenteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataTestesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Entregador");
			System.out.println("2 - Gerente");

			Integer function = scanner.nextInt();

			switch (function) {
			case 1:
				entregadorService.inicial(scanner);
				break;
			case 2:
				gerenteService.inicial(scanner);
				break;
			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}
		}
	}
}
