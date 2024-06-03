# Desafio: API para POIs (pontos de interesse)

![Java](https://img.shields.io/badge/Java-8%2B-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/joão-santos-1115a5304/)
![GPL License](https://img.shields.io/badge/License-GPL-blue) [![LinkedIn](https://img.shields.io/badge/Type-Challenge-purple)](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md)

Essa é a minha solução para o desafio backend **API para POIs (pontos de interesse)**. Acesse o [desafio](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md) para obter mais informações do problema.  

## Tabela de conteúdos

- [Introdução](#introdução)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Iniciando](#iniciando)
- [Configuração](#configuração)
- [Endpoints](#endpoints)
- [Contribuições](#contribuições)
- [Contato](#contato)

## Introdução

O problema principal no desafio é criar uma rota http GET que retorne os pontos de interesse dentro de um raio X em metros, baseando-se nas coordenadas informadas.

## Funcionalidades

- CRUD completo para pontos de interesse
- busca dos pontos de interesse próximos
- Integração com o banco de dados H2.

## Tecnologias

- ![Java](https://img.shields.io/badge/Java-8%2B-orange): Linguagem de programação.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework usado para a construção de aplicações voltadas à produção.
- ![H2](https://img.shields.io/badge/H2-Database-blue): Banco de dados em memória.

## Iniciando

Siga esses passos para executar o projeto na sua máquina:

1. Clone o repositório: `git clone https://github.com/gabrieudev/points-of-interest.git`
2. Navegue para o diretório do projeto: `cd <caminho>`
3. Atualize as configurações de banco de dados no arquivo `application.properties`
4. Construa a aplicação: `./mvnw clean install` (para Windows: `mvnw.cmd clean install`)
5. Execute a aplicação: `./mvnw spring-boot:run` (para Windows: `mvnw.cmd spring-boot:run`)

## Configuração

- Configuração de banco de dados: atualize o arquivo `application.properties` com as informações do seu banco de dados H2.

## Endpoints

- `POST /points`: Registra um novo ponto de interesse.
- `GET /points`: Obtém todos os pontos de interesse registrados.
- `GET /points/{id}`: Obtém um ponto de interesse de acordo com o id.
- `GET /points/{x}/{y}/{dMax}`: Obtém todos os pontos de interesse dentro da distância máxima informada, tendo as coordenadas X e Y como ponto de referência.
- `PUT /points`: Atualiza um ponto de interesse existente.
- `DELETE /points/{id}`: Deleta um ponto de interesse de acordo com o id.

Acesse a documentação completa no endpoint `/swagger-ui.html`

## Contribuições

Contribuições são muito bem vindas! Caso queira contribuir, faça um fork do repositório e crie um pull request.

## Contato

Caso tenha alguma sugestão ou dúvida, entre em contato comigo em [LinkedIn](https://www.linkedin.com/in/gabrieudev/)

---

**Licença:** Esse projeto é licenciado sob os termos da [GNU General Public License (GPL)](LICENSE).
