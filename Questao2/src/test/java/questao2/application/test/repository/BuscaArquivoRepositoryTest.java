package questao2.application.test.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import questao2.application.exception.ProcessoException;
import questao2.application.repository.BuscaArquivoRepository;
import questao2.application.service.ArquivosMapService;

@RunWith(SpringRunner.class)
public class BuscaArquivoRepositoryTest {
	
	@InjectMocks
	BuscaArquivoRepository buscaService;
	
	@Mock
	ArquivosMapService arqMapService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Deve buscar o arquivo corretamente")
	public void devebuscarArquivoExistente() {
		when(arqMapService.getCaminho(Mockito.any())).thenReturn("imagens/teste2.jpg");

		BufferedImage imagem = buscaService.buscaImagemTigre();
			
		assertEquals(704, imagem.getWidth());
		assertEquals(395, imagem.getHeight());
	}
	
	@Test
	@DisplayName("Deve buscar arquivo inexistente e gerar exeption")
	public void devebuscarArquivoErro() {
		when(arqMapService.getCaminho(Mockito.any())).thenReturn("imagenxxxs/teste2.jpg");
		Throwable thrown = catchThrowable(() -> {
			buscaService.buscaImagemTigre();
		});
		assertThat(thrown).isInstanceOf(ProcessoException.class).hasMessageContaining("Imagem não encontrada");
	}
}
