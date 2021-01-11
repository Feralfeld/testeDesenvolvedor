package questao2.application.repository;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Repository;

import questao2.application.exception.ProcessoException;
import questao2.application.service.ArquivosMapService;

@Repository
public class BuscaArquivoRepository {
	
	@Resource
	ArquivosMapService arquivoMap;
	
	public BufferedImage buscaImagemTigre() {
	BufferedImage imagem = null;
	try {	   		 
		imagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(arquivoMap.getCaminho("Imagem.teste2")));
	} catch ( Exception exc ) {
		throw new ProcessoException("Imagem não encontrada");
	}	
	return imagem;
	}
}
