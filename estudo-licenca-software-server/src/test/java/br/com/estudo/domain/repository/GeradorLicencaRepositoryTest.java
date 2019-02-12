package br.com.estudo.domain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.estudo.EstudoLicencaSoftwareServerApplication;
import br.com.estudo.domain.GeradorLicenca;
import br.com.estudo.domain.repository.GeradorLicencaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EstudoLicencaSoftwareServerApplication.class)
public class GeradorLicencaRepositoryTest {

	@Autowired
	private GeradorLicencaRepository geradorLicencaRepository;

	private GeradorLicenca entity;

	@Before
	public void setUp() throws Exception {
		/* Montagem do Cenário */
		entity = new GeradorLicenca();
		entity.setEmpresa("Empresa Software");
		entity.setCnpjEmpresa("30.127.206/0001-48");

		entity.setIdEmpresa("1");
		entity.setIdOrganizacao("1");
		entity.setQtdeDiaLicenca(60);
		entity.setUrlSistema("http://localhost:8080/sge");
	}

	@After
	public void tearDown() throws Exception {
		geradorLicencaRepository.deleteAll();
	}

	/**
	 * Realiza a persistencia de um Gerador Licenca
	 */
	@Test
	public void testSave() {
		/* Execução */
		GeradorLicenca entityReturn = geradorLicencaRepository.save(entity);

		/* Verificação */
		assertNotNull(entityReturn.getId());
		assertNull(entityReturn.getToken());

		assertThat(entityReturn.getCnpjEmpresa(), is("30.127.206/0001-48"));
		assertThat(entityReturn.getEmpresa(), is("Empresa Software"));
		assertThat(entityReturn.getIdEmpresa(), is("1"));
		assertThat(entityReturn.getIdOrganizacao(), is("1"));
		assertThat(entityReturn.getQtdeDiaLicenca(), is(60));
		assertThat(entityReturn.getUrlSistema(), is("http://localhost:8080/sge"));
	}

	/**
	 * Realiza a pesquisa de um Gerador Licenca através do ID válido
	 */
	@Test
	public void testFindOne() {
		/* Montagem do Cenário */
		GeradorLicenca entitySave = geradorLicencaRepository.save(entity);

		/* Execução */
		GeradorLicenca entityReturn = geradorLicencaRepository.findOne(entitySave.getId());

		/* Verificação */
		assertNotNull(entityReturn.getId());
		assertNull(entityReturn.getToken());

		assertThat(entityReturn.getId(), is(entitySave.getId()));
		assertThat(entityReturn.getCnpjEmpresa(), is("30.127.206/0001-48"));
		assertThat(entityReturn.getEmpresa(), is("Empresa Software"));
		assertThat(entityReturn.getIdEmpresa(), is("1"));
		assertThat(entityReturn.getIdOrganizacao(), is("1"));
		assertThat(entityReturn.getQtdeDiaLicenca(), is(60));
		assertThat(entityReturn.getUrlSistema(), is("http://localhost:8080/sge"));
	}

	/**
	 * Realiza a pesquisa de um Gerador Licenca através do ID Inexistente
	 */
	@Test
	public void testFindOne_Inexistente() {
		/* Execução */
		GeradorLicenca entityReturn = geradorLicencaRepository.findOne(78899966L);

		/* Verificação */
		assertNull(entityReturn);
	}

	/**
	 * Realiza a pesquisa de todos registros de Gerador de Licenca cadastrados e aguardanda uma lista com 1 registro
	 */
	@Test
	public void testFindAll() {
		/* Montagem do Cenário */
		geradorLicencaRepository.save(entity);

		/* Execução */
		List<GeradorLicenca> listEntityReturn = geradorLicencaRepository.findAll();

		/* Verificação */
		assertThat(listEntityReturn.isEmpty(), is(false));

		/* Execução */
		GeradorLicenca entityReturn = listEntityReturn.get(0);

		/* Verificação */
		assertThat(entityReturn, is(IsNull.notNullValue()));
		assertThat(entityReturn.getToken(), not(isEmptyString()));
		assertThat(entityReturn.getCnpjEmpresa(), is("30.127.206/0001-48"));
		assertThat(entityReturn.getEmpresa(), is("Empresa Software"));
		assertThat(entityReturn.getIdEmpresa(), is("1"));
		assertThat(entityReturn.getIdOrganizacao(), is("1"));
		assertThat(entityReturn.getQtdeDiaLicenca(), is(60));
		assertThat(entityReturn.getUrlSistema(), is("http://localhost:8080/sge"));
	}

	/**
	 * Realiza a pesquisa de todos registros de Gerador de Licenca cadastrados e aguardanda uma lista vazia
	 */
	@Test
	public void testFindAll_Vazia() {
		/* Execução */
		List<GeradorLicenca> listEntityReturn = geradorLicencaRepository.findAll();

		/* Verificação */
		assertThat(listEntityReturn.isEmpty(), is(true));
	}

	/**
	 * Realiza a exclusão de um registro Gerador de Licenca
	 */
	@Test
	public void testDelete() {
		/* Montagem do Cenário */
		GeradorLicenca entitySave = geradorLicencaRepository.save(entity);

		/* Execução */
		geradorLicencaRepository.delete(entitySave);
		GeradorLicenca listEntityReturn = geradorLicencaRepository.findOne(entitySave.getId());

		/* Verificação */
		assertNull(listEntityReturn);
	}
}