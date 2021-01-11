package questao3.application.resource;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import questao3.application.dto.ErroExecucaoResponse;
import questao3.application.dto.ResultadoResponse;
import questao3.application.model.Heroi;
import questao3.application.model.Volta;
import questao3.application.repository.CorridaRepository;
import questao3.application.service.CorridaService;

@RestController
@RequestMapping("corrida")
public class CorridaResource {

	@Resource
	CorridaService service;
	
	@Resource
	CorridaRepository repository;

	@ApiOperation(value = "Retorna o resultado da corrida")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso", response = ResultadoResponse.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = ErroExecucaoResponse.class), })
	@PostMapping("resultado")
	public ResultadoResponse resultado() {

		Map<Heroi, List<Volta>> corrida = repository.testeHerois();
		
		return service.analisaCorrida(corrida);
	}


}
