# PROJETO DE ESTUDO SPRING CLOUD E SPRING BOOT

Projeto de estudo utilizado para criar uma Arquitetura de MicroServices com Spring Cloud e Spring Boot.

## Eureka Server

O Projeto estudo-eureka-server é nosso Service Registry, que será responsável por gerenciar o status e a localização dos Microservices em nossa rede. 

Para isso utilizamos o Eureka, que é um serviço REST (Representational State Transfer) utilizado principalmente na nuvem AWS (Amazon Web Services) para localizar serviços com o objetivo de balanceamento de carga e failover de servidores.

## OAuth2

O Projeto estudo-oauth-server é nosso Servidor de Autorização, que será responsável por controlar a autenticação e autorização de nossos recursos(microserviços). 

## Microserviço Licença Software Server

Projeto estudo-licenca-software-server é nosso microserviço utilizado para gerar uma licença de software, onde realizamos uma chamada POST passando alguns parâmetros e o mesmo nos gera um token que poderá ser utilizado como licença de um software.

## Microserviço Licença Software Client

Projeto estudo-licenca-software-client é outro microserviço cliente que irá chamar outro microserviço.

## Web Client

Projeto estudo-web-client
