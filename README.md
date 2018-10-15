# api-StarWtest

## Api em Java criada como desafio da B2W BIT

### Tecnologias Utilizadas

- **Java**: versão 8 ou superior
- **[Guice](https://github.com/google/guice)**: para injeção de depedencia
- **[Spark Framework](http://sparkjava.com)**: leve biblioteca para criação de API, sintaxe parecido com o Express do Node.js. Por isso a escolha
- **[RestQL-Core-Java](https://github.com/B2W-BIT/restQL-core-java)**: Uma pequena e leve biblioteca que comecei a usar em meus projetos devido ao grande numero de requisições simultâneas que eu fazia em meus projetos. Foi colocada mais por aprendizado do que por nescessidade.
- **[Mongo-drive-java](https://mongodb.github.io/mongo-java-driver/)**: biblioteca para utilizar o banco não relacional MongoDB
- **[Morphia](https://dzone.com/articles/using-morphia-map-java-objects)**: biblioteca para mapear objetos java para utilização no banco MongoDB
- **[JUnit](https://junit.org/junit5/)**: Biblioteca utilizada para testes.

## Endpoints

__[GET]__ /apistartest/planets/ 
- Retorna todos os planetas cadastrados no MongoDB

__[POST]__ /apistartest/planets/ 
- cadastra um novo planeta no MongoDB 
 Ex: __{"name": "Hell de Janeiro","climate": "Calorzao","terrain": "bolachudo" }__
 Obs: A "aparicões em filmes" sera cadastrada sozinha toda vez que voce adcionar um novo planeta.

__[GET]__ /apistartest/planets/:id 
- Retorna o planeta com o id especificado no MongoDB

__[GET]__ /apistartest/planets/name/:name
- Retorna o planeta com o nome especificado no MongoDB

__[GET]__ /apistartest/planets/:id 
- Deleta o planeta com o id especificado no MongoDB
