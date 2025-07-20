package br.com.thiago.screanmatch;

import br.com.thiago.screanmatch.model.DadosEpisodio;
import br.com.thiago.screanmatch.model.DadosSeries;
import br.com.thiago.screanmatch.model.DadosTemporada;
import br.com.thiago.screanmatch.principal.Principal;
import br.com.thiago.screanmatch.service.ConsumoApi;
import br.com.thiago.screanmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreanmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreanmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
		//List<DadosTemporada> temporadas = new ArrayList<>();

	}
}


