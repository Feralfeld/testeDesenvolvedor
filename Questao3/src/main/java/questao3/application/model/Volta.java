package questao3.application.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Volta {
	
	private LocalDateTime  hora;
	private String numeroVoltar;
	private double  tempoVoltaMilisegundos;
	private double  velocidadeMediaVolta;
	
}