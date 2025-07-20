package br.com.thiago.screanmatch.principal;

import br.com.thiago.screanmatch.model.DadosEpisodio;
import br.com.thiago.screanmatch.model.DadosSeries;
import br.com.thiago.screanmatch.model.DadosTemporada;
import br.com.thiago.screanmatch.model.Episodio;
import br.com.thiago.screanmatch.service.ConsumoApi;
import br.com.thiago.screanmatch.service.ConverteDados;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
   private final String ENDERECO = "https://www.omdbapi.com/?t=";

   private final String API_KEY = "&apikey=3c5fe42d";

   private  ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

     private Scanner leitura = new Scanner (System.in);


    public void exibeMenu(){


        System.out.println("digite o nome da serie ");
         var nomeSerie = leitura.nextLine();
         var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSeries dados = conversor.obterDados(json , DadosSeries.class);
        System.out.println(dados);
        List<DadosTemporada> temporadas = new ArrayList<>();
        	for (int i = 1; i<= dados.totalTemporadas(); i++){
           		json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +"&season=" + i + API_KEY);
           		DadosTemporada dadosTemporada=conversor.obterDados(json, DadosTemporada.class);
                  temporadas.add(dadosTemporada);

        }
          temporadas.forEach(System.out::println);
        for (int i = 0; i < dados.totalTemporadas(); i++){
            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j< episodiosTemporada.size(); j++ ){

                System.out.println(episodiosTemporada.get(j).titulo());


            }temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));




        }List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());
        System.out.println("\n top 5 episodios ");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio:: avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

         List<Episodio> episodies = temporadas.stream()
                 .flatMap(t-> t.episodios().stream()
                         .map(d -> new Episodio(t.numero(), d)))
                 .collect(Collectors.toList());

          episodies.forEach(System.out::println);

           /*System.out.println("digite o titulo do episodio ");
           var trechoTitulo= leitura.nextLine();
        Optional< Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().contains(trechoTitulo))
                .findFirst();
                if(episodioBuscado.isPresent()){
                    System.out.println("episodio encontrado ");
                    System.out.println("temporada "+ episodioBuscado.get().getTemporada());


                }else {
                    System.out.println("episodio nao encontrado ");
                }*/

       /*System.out.println("apartir de qual ano voce deseja  ve os episodios ?");
        var ano = leitura.nextLine();
        leitura.nextLine();

        LocalDate dataBusca = LocalDate.of(Integer.parseInt(ano),1,1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodies.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println("temporada " + e.getTemporada() + " episodio "
                 + e.getTitulo() + " Data Lançamento " + e.getDataLancamento().format(formatador)
                ));*/


        Map<Integer ,Double> avaliacoesPorTemporada = episodies.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println(avaliacoesPorTemporada);


          DoubleSummaryStatistics est = episodies.stream()
                  .filter(e -> e.getAvaliacao() > 0.0)
                  .collect(Collectors.summarizingDouble(Episodio :: getAvaliacao));
        System.out.println("media "  + est.getAverage());
        System.out.println(" melho episodio " + est.getMax());
        System.out.println("pior episodio " + est.getMin());
        System.out.println("quantidade " + est.getCount());

    }
}
