package questao2.application.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import questao2.application.exception.ProcessoException;
import questao2.application.service.ImagemService;

@RunWith(SpringRunner.class)
public class ImagemServiceTest {

	@InjectMocks
	private ImagemService service;

	BufferedImage imagem = null;

	@Before
	public void setUp() throws IOException {
		MockitoAnnotations.initMocks(this);
		imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagens/teste2.jpg"));
	}

	@Test
	public void teste1() {

		Integer[] vetor = { 1, 2, 3 };

		Map<Integer, Integer> resultado = service.calculaResultado(imagem, vetor);

		assertEquals(9018, resultado.get(1));
		assertEquals(11083, resultado.get(2));
		assertEquals(12669, resultado.get(3));
	}

	@Test
	public void testeErrado() {

		Integer[] vetor = { 1, 2, 3 };

		Throwable thrown = catchThrowable(() -> {
			service.calculaResultado(null, vetor);
		});
		assertThat(thrown).isInstanceOf(ProcessoException.class).hasMessageContaining("Erro ao processar imagem");

	}

}
