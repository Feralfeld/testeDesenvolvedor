package questao2.application.resource;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import questao2.application.dto.BitMapResponse;
import questao2.application.dto.ErroExecucaoResponse;
import questao2.application.repository.BuscaArquivoRepository;
import questao2.application.service.ImagemService;

@Slf4j
@RestController
@RequestMapping("imagem")
public class ImagemResource {

	@Resource
	BuscaArquivoRepository buscaArquivoRepo;
	
	@Resource
	ImagemService imgService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = BitMapResponse.class ),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = ErroExecucaoResponse.class),		
	})
	@ApiOperation(value = "Quantidade de vezes que os numeros solicitados aparecem nos pixels da imagem")
	@PostMapping(path="contaBitMap")
	public BitMapResponse contaBitMap(@RequestBody Integer[] vetor){
		
		log.info("Contagem BitMap Imagem");
		
		return new BitMapResponse("sucesso",imgService.calculaResultado(buscaArquivoRepo.buscaImagemTigre(), vetor));	
	}	

}
