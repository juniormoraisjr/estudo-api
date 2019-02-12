# Projeto Gerador de Licença para Software

Projeto utilizado para gerar licença de software utilizando o Spring Boot + Spring Security + Spring OAuth2

Urls para consumir serviços :

Funcionalidade Autenticar OAtuh
	- Url
		http://localhost:9092/oauth/token?grant_type=password&username=admin&password=123456 
	- Tipo Requisição
		(POST)
	- Header
		Authorization = Basic Y29kZXJlZjokMmEkMTAkcDlQazBmUU5BUVNlc0k0dnV2S0EwT1phbkREMg==
		Content-Type = application/json

Funcionalidade Gerar Token Licença
	- Url
		http://localhost:9093/geradorLicenca/gerarToken 
	- Tipo Requisição
		(POST)
	- Header
		Authorization = Bearer VALOR TOKEN OBTIDO NA REQUISIÇÃO ANTERIOR
		Content-Type = application/json
	- Body
		raw
		JSON
		Valor Body
			{
			  "empresa": "Empresa Software",
			  "idEmpresa": "1",
			  "idOrganizacao": "1",
			  "cnpjEmpresa": "45.416.351/0001-16",
			  "urlSistema": "http://localhost:9091/",
			  "qtdeDiaLicenca": 90
			}   
