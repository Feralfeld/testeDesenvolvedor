package questao2.application.service;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import questao2.application.exception.ProcessoException;

@Service
public class ImagemService {

	public Map<Integer, Integer> calculaResultado(BufferedImage bufi, Integer[] vetor) {

		Map<Integer, Integer> contador = new HashMap<>();

		inicializa(contador, vetor);
		try {
			for (int j = 0; j < bufi.getWidth(); j++) {
				for (int i = 0; i < bufi.getHeight(); i++) {
					adiciona(contador, (int) (byte) bufi.getRGB(j, i));
				}
			}
		} catch (Exception exc) {
			throw new ProcessoException("Erro ao processar imagem");
		}
		return contador;
	}

	private void inicializa(Map<Integer, Integer> contador, Integer[] vetor) {
		for (Integer i : vetor) {
			contador.put(i, 0);
		}
	}

	private void adiciona(Map<Integer, Integer> contador, Integer codigo) {
		contador.computeIfPresent(codigo,(key, val) -> val + 1);
	}
}
