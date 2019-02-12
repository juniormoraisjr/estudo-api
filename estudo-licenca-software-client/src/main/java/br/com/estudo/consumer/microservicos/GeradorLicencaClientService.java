package br.com.estudo.consumer.microservicos;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.estudo.controller.model.GeradorLicencaClientModel;

@FeignClient(url = "http://localhost:9093/", name = "geradorLicencaClient")
public interface GeradorLicencaClientService {

	/**
	 * Método responsável por realizar a chamada do endpoint gerarToken do micro serviço estudo-licenca-software-server
	 * 
	 * @param model
	 *            - informações utilizadas para geração da licença
	 * 
	 * @return Licença gerada
	 */
	@GetMapping("/geradorLicenca/gerarToken")
	public String gerarToken(@RequestBody GeradorLicencaClientModel model);
}