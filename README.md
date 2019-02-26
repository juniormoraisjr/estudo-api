# PROJETO DE ESTUDO SPRING CLOUD E SPRING BOOT

Projeto de estudo utilizado para criar uma Arquitetura de MicroServices com Spring Cloud e Spring Boot.


## Eureka Server

Projeto estudo-eureka-server é nosso Service Registry, que será responsável por gerenciar o status e a localização dos Microservices em nossa rede. 

Para isso utilizamos o Eureka, que é um serviço REST (Representational State Transfer) que é usado principalmente na nuvem AWS (Amazon Web Services) para localizar serviços com o objetivo de balanceamento de carga e failover de servidores.


## OAuth2

Projeto estudo-oauth-server é nosso servidor de autorização que será responsável por controlar a autenticação e autorização de nossos recursos. 

Ele utiliza o Spring Security OAuth2 tem como base o OAuth2 um framework de autenticação e autorização aberto, poderoso e flexivel permitindo que sua aplicação não fique manipulando diretamente as credenciais dos usuários.

## Microserviço Licença Software Server e Client

Projeto estudo-licenca-software-server é nosso microserviço utilizado para gerar uma licença de software, onde realizamos uma chamada POST passando alguns parâmetros e o mesmo nos gera um token que poderá ser utilizado como licença de um software.

Projeto estudo-licenca-software-client é outro microserviço cliente que irá chamar outro microserviço.
