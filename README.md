# 🎬 Screenmatch - Consulta de Séries com OMDb API

Este é um projeto Java desenvolvido no curso **"Java: trabalhando com lambdas, streams e Spring Framework"** da Alura.  
O desafio é buscar e exibir informações de **séries de TV** utilizando a [OMDb API](https://www.omdbapi.com/), consolidando os conhecimentos sobre consumo de APIs, uso de `Streams`, `Lambdas`, modelagem de dados e estruturação com Spring Boot.

---

## ✅ Funcionalidades

- Busca de séries pelo título via terminal
- Consumo de API REST (OMDb)
- Exibição de título, ano, avaliação, temporadas e sinopse
- Uso de Streams e Lambdas para filtrar e processar os dados
- Execução automatizada com `CommandLineRunner` do Spring Boot

---

## 🔧 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Lambdas e Streams**
- **Jackson (para desserialização do JSON)**
- **OMDb API** – [https://www.omdbapi.com/](https://www.omdbapi.com/)

---

## 🧪 Exemplo de Execução


Digite o nome da série:
dark

Título: Dark
Ano de lançamento: 2017
Classificação: 8.7
Temporadas: 3
Sinopse: A family saga with a supernatural twist...
🔗 Endpoints da API
A aplicação consome o seguinte endpoint da OMDb:

ruby
Copiar
Editar
https://www.omdbapi.com/?t={titulo}&apikey=3c5fe42d
Exemplo: https://www.omdbapi.com/?t=dark&apikey=3c5fe42d

🗂 Estrutura do Projeto
bash
Copiar
Editar
src/
├── main/
│   ├── java/
│   │   └── com.screenmatch/
│   │       ├── model/       # Classes de modelo como Serie e Episodio
│   │       ├── service/     # Classe para consumir e processar a API
│   │       └── principal/   # Classe principal com lógica da aplicação
└── resources/
    └── application.properties
📚 O que foi praticado
Consumo de uma API REST com Java

Mapeamento de dados JSON com classes Java

Uso de filter, map, collect da Stream API

Aplicação estruturada com Spring Boot e boas práticas de organização

Execução de lógica via CommandLineRunner

🚀 Como executar
Pré-requisitos:
JDK 17 instalado

IntelliJ ou qualquer IDE compatível com projetos Spring Boot

Conexão com a internet para acessar a API

Passo a passo:
bash
Copiar
Editar
git clone https://github.com/thiagoassis7/screanmatch.git
cd screanmatch
./mvnw spring-boot:run
👨‍💻 Autor
Thiago Assis
Estudante de Engenharia de Software | Oracle Next Education
🌱 Em transição de carreira para a área de TI
