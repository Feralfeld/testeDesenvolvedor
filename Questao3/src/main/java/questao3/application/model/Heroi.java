package questao3.application.model;

import java.util.List;

import lombok.Data;

@Data
public class Heroi {

	private String nome;
	private List<Volta> voltas;
}
