package questao3.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResultadoResponse {

	private String melhorVoltaCorrida;
	List<HeroiResponse> herois;
	
}