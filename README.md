# PROJETO DE ESTUDO SPRING CLOUD E SPRING BOOT

Projeto de estudo utilizado para criar uma Arquitetura de MicroServices com Spring Cloud e Spring Boot.

## Eureka Server

O Projeto estudo-eureka-server é nosso Service Registry, que será responsável por gerenciar o status e a localização dos Microservices em nossa rede. 

Para isso utilizamos o Eureka, que é um serviço REST (Representational State Transfer) utilizado principalmente na nuvem AWS (Amazon Web Services) para localizar serviços com o objetivo de balanceamento de carga e failover de servidores.

## OAuth2

O Projeto estudo-oauth-server é nosso Servidor de Autorização, que será responsável por controlar a autenticação e autorização de nossos recursos(microserviços). 

## Microserviço Licença Software Server

Projeto estudo-licenca-software-server é nosso microserviço que tem a funcionalidade de gerar uma licença de software, através de uma chamada POST passando alguns parâmetros e retornando um token que poderá ser utilizado como licença de um software.

## Microserviço Licença Software Client

Projeto estudo-licenca-software-client é um microserviço que tem a funcionalidade de chamar recursos de outro microserviço, desta forma o intuito do projeto é validar/documentar uma forma de consumir recursos/funcionalidades de outros microserviços. Este microserviço não implementa nenhuma funcionalidade nova mas realiza a centralização/consumo de funcionalidades implementadas em diferentes microservicos.

## Web Client

Projeto estudo-web-client é um projeto WEB implementado com o intuito de consumir recursos/funcionalidades dos microserviços, através das chamadas AJAX, JQUERY.
