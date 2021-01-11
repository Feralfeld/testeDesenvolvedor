package questao1.application;

import questao1.application.service.ImagemService;

public class Questao1Main {

	public static void main(String[] args) {

		String imagem = "teste2.jpg";
		Integer[] vetor = {0,1,3};
		
		ImagemService service = new ImagemService();
		System.out.println(service.algoritmoBitMap(vetor, imagem));
	}

}
