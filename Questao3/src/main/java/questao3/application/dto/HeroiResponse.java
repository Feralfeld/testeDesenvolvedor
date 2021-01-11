package questao3.application.dto;

import lombok.Data;

@Data
public class HeroiResponse {

	private int posicao;
	private String codigo;
	private String nome;
	private String quantidadeVoltas;
	private String tempoTotalProva;
	private int melhorVolta;
	private double velocidadeMedia;
	
}