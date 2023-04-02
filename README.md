# Projeto de Gerador de Stickers com API usando Spring Boot e MongoDB em Java

Este projeto é uma aplicação Java que permite gerar imagens sobrescritas a partir de um Json.

## Tecnologias utilizadas

- Spring Boot Web
- MongoDB
- Java
- Maven
- Postman

## Descrição do projeto

O projeto é composto por duas partes principais:

**linguagens-api**: uma API RESTful que gera um JSON contendo informações sobre um sticker. Através do Postman, é possível enviar uma imagem, um título e um ranking para a API, que irá armazenar essas informações no banco de dados MongoDB e retornar o JSON contendo todas as informações do sticker.

**rafael-sticker**: um programa Java que utiliza a API criada anteriormente para gerar um sticker personalizado. O programa conta com um Enum que possui os links das APIs do IMDB, NASA e localhost. A classe principal recebe os conteúdos e envia para a classe "stick-generator", que utiliza a biblioteca ImageIO para sobrescrever a imagem com o texto personalizado.

## Como utilizar o projeto

Para utilizar o projeto, siga os seguintes passos:

1. Clone o repositório para o seu computador.
2. Execute o comando `mvn clean install` na pasta `linguagens-api` para instalar todas as dependências e compilar o projeto.
3. Execute o comando `mvn spring-boot:run` para iniciar a API (Ou acesse o diretório .src/main/java/LinguagensApiApplication e execute o run na main).
4. Abra o Postman e envie uma requisição POST para a URL `http://localhost:8080/linguagens` com os seguintes campos no corpo da requisição:
   - `image`: o caminho da imagem
   - `title`: o título do sticker
   - `ranking`: o ranking do sticker
5. A API irá armazenar as informações do sticker no banco de dados MongoDB e retornar um JSON com todas as informações.
6. No Java project `rafael-sticker` acesse a classe `App.java` e descomente ou comente as API's para executar a necessária.
7. Execute o run na classe `App.java`.
8. Veja o resultado na pasta `output`.

## Observações

O projeto foi desenvolvido no ambiente linux.

É importante lembrar que é necessário ter o MongoDB e dependências instaladas em sua máquina para que a API funcione corretamente. Além disso, certifique-se de que a imagem utilizada para gerar o sticker esteja disponível no caminho especificado na requisição.
