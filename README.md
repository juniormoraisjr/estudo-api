# Projeto Estudo Spring Cloud e Spring Boot

Projeto de estudo utilizado para criar uma Arquitetura de MicroServices com Spring Cloud e Spring Boot.

## Config Server

O Projeto estudo-api-config é nosso Servidor de Configuração, que tem como objetivo de centralizar todas as configurações da nossa rede de Microservices em um só lugar. Ele é responsável por ler as informações no repositório e fornece-las às aplicações através de requests HTTP.

Este será o 1º projeto a ser inicializado com o Spring Boot App.

## Eureka Server

O Projeto estudo-eureka-server é nosso Service Registry, que será responsável por gerenciar o status e a localização dos Microservices em nossa rede. 

Para isso utilizamos o Eureka, que é um serviço REST (Representational State Transfer) utilizado principalmente na nuvem AWS (Amazon Web Services) para localizar serviços com o objetivo de balanceamento de carga e failover de servidores.

Este será o 2º projeto a ser inicializado com o Spring Boot App. 

Após inicializado basta acessar a url http://localhost:9091/ e será apresentado o System Status dos microserviços. Veja exemplo abaixo:

![](/EvidenciaEureka.png)

## OAuth2

O Projeto estudo-oauth-server é nosso Servidor de Autorização, que será responsável por controlar a autenticação e autorização de nossos recursos(microserviços). 

Este será o 3º projeto a ser inicializado com o Spring Boot App. 

Após inicializado basta utilizar o Postman para Solicitar um Token de Acesso, para isto o Client deverá estar registrado no servidor de autorização e deve enviar o client-id e o secret que configuramos no application.yml codificado no formato Base 64, respeitando o padrão client-id:secret. 

Para fazer essa requisição teremos que enviar os seguintes dados:

```
Authorization: Basic Y29kZXJlZjokMmEkMTAkcDlQazBmUU5BUVNlc0k0dnV2S0EwT1phbkREMg==
URL: http://localhost:9092/oauth/token?grant_type=password&username=admin&password=123456
Method: POST
Content-Type: application/json
```

Veja exemplo abaixo:

![](/EvidenciaTokenOAuth.png)

## Microserviço Licença Software Server

Projeto estudo-licenca-software-server é nosso microserviço que tem a funcionalidade de gerar uma licença de software, através de uma chamada POST passando alguns parâmetros e retornando um token que poderá ser utilizado como licença de um software.

Este será o 4º projeto a ser inicializado com o Spring Boot App. 

Após inicializado basta utilizar o Postman para solicitar a Licença de Software, para fazer essa requisição teremos que enviar os dados informados abaixo, mas na opção do Bearer devemos informar o token obtido através do OAuth:

```
URL: http://localhost:9093/geradorLicenca/gerarToken
Authorization: Bearer e818e132-6e96-4f5c-9a51-f1332d43d3d7
Content-Type: application/json
Method: POST
Content-Type: application/json
```

Veja exemplo abaixo:

![](/EvidenciaMicroservicoLicencaServer2.png)

```
Body:
{
  "urlSistema": "http://exemplourlsite.com.br",
  "empresa": "Nome da Empresa",
  "idEmpresa": "1",
  "cnpjEmpresa": "46.900.152/0001-41",
  "idOrganizacao": "1",
  "qtdeDiaLicenca": 30
}
Type : raw
```

Veja exemplo abaixo:

![](/EvidenciaMicroservicoLicencaServer.png)

## Microserviço Licença Software Client

Projeto estudo-licenca-software-client é um microserviço que tem a funcionalidade de chamar recursos de outro microserviço, desta forma o intuito do projeto é validar/documentar uma forma de consumir recursos/funcionalidades de outros microserviços. Este microserviço não implementa nenhuma funcionalidade nova mas realiza a centralização/consumo de funcionalidades implementadas em diferentes microservicos.

Para executar utilize os mesmos dados informado no item Microserviço Licença Software Server alterando apenas a url invocada que será http://localhost:9094/geradorLicencaClient/gerarTokenClient.

## Web Client

Projeto estudo-web-client é um projeto WEB implementado com o intuito de consumir recursos/funcionalidades dos microserviços, através das chamadas AJAX, JQUERY.

Este projeto deve ser inicializado após a inicialização dos demais e para acessá-lo utilize a url http://localhost:8080/.

Será apresentado uma tela inicial com dois botões que quando acionados irá exibir o resultado no console do navegador.
