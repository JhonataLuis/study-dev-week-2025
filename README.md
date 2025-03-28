# Study Dev Week 2025 Java API
RESTful API Study construída em Java com Spring Boot 3

## Principais Tecnologias
- **Java 17**: Utilizaremos a versão LTS do Java para tirar vantagem da últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficar e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- **Railway**: Facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## Diagrama de Classes

```mermaid
classDiagram
  class User {
    +String name
    +Account account
    +List~Feature~ features
    +Card card
    +List~News~ news
  }

  class Account {
    +String number
    +String agency
    +float balance
    +float limit
  }

  class Feature {
    +String icon
    +String description
  }

  class Card {
    +String number
    +float limit
  }

  class News {
    +String icon
    +String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N"  Feature
  User "1" *-- "1" Card
  User "1" *-- "N"  News

  ```
