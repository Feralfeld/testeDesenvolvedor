package questao2.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BitMapResponse {

	private String mensagem;
	private Object dados;
}
