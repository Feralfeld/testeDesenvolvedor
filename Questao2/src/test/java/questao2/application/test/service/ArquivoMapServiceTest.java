package questao2.application.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import questao2.application.service.ArquivosMapService;

@RunWith(SpringRunner.class)
public class ArquivoMapServiceTest {

	@InjectMocks
	ArquivosMapService arquivoService;
	
	@Mock 
	Environment enviroment;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Deve buscar caminho do arquivo corretamente")
	public void devebuscarArquivoExistente() {
		when(enviroment.getProperty(Mockito.any())).thenReturn("Imagens");
		
		String imagem = arquivoService.getCaminho("Imagem.teste2");
			
		assertThat(imagem).isNotBlank();
	}
	
	
	@Test
	@DisplayName("Deve buscar caminho c chave nula e gerar exeption")
	public void devebuscarArquivoErro() {
		Throwable thrown = catchThrowable(() -> {
			arquivoService.getCaminho(null);
		});
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("A chave não pode ser nula");
	}
	
}
