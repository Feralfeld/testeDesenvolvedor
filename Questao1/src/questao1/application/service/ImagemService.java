package questao1.application.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImagemService {
	
	public Map<Integer, Integer> algoritmoBitMap(Integer[] vetor, String imagem){
		
		 Map<Integer, Integer> contador = new HashMap<>(); 
			
		try { 
		   inicializa(contador, vetor);  			 
	
		   BufferedImage bufi = ImageIO.read( getClass().getResourceAsStream(imagem));
			
			for ( int j = 0; j < bufi.getWidth(); j++ ) {
				for ( int i = 0; i < bufi.getHeight(); i++ ) {
					adiciona(contador, (int) (byte) bufi.getRGB( j, i ));
				}
			}
		} catch ( IOException exc ) {
			exc.printStackTrace();
		}		

		return contador;
	}	

	public void inicializa(Map<Integer, Integer> contador, Integer[] vetor) {
		 for (Integer i : vetor) { 
			 contador.put(i,0); 
		   }
	}
	
	public void adiciona(Map<Integer, Integer> contador, Integer codigo) {
		contador.computeIfPresent(codigo,(key, val) -> val + 1);
	}
}
