package questao3.application.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import questao3.application.dto.HeroiResponse;
import questao3.application.dto.ResultadoResponse;
import questao3.application.model.Heroi;
import questao3.application.model.Volta;

@Service
public class CorridaService {

	double melhorVoltaCorrida = 99999999;
	String melorVoltaCorr = "";

	public ResultadoResponse analisaCorrida(Map<Heroi, List<Volta>> corrida) {
		List<HeroiResponse> resultado = new ArrayList<>();

		for (Heroi heroi : corrida.keySet()) {

			HeroiResponse responseHeroi = analisaHeroi(corrida, heroi);
			resultado.add(responseHeroi);
		}

		ResultadoResponse resposta = new ResultadoResponse();
		resposta.setHerois(resultado);
		resposta.setMelhorVoltaCorrida(melorVoltaCorr);

		return analisaPosicoes(resposta);
	}
	
	public ResultadoResponse analisaPosicoes(ResultadoResponse resposta) {
				
		double[] quantidadeHerois = new double[resposta.getHerois().size()];
		
		for(int i = 0 ; i < resposta.getHerois().size(); i++) {
			quantidadeHerois[i] = resposta.getHerois().get(i).getVelocidadeMedia();
			
		}
		
		Arrays.sort(quantidadeHerois);
		for(int i = 0 ; i < quantidadeHerois.length; i++) {
			for(HeroiResponse heroi : resposta.getHerois()) {
				if(quantidadeHerois[i] == heroi.getVelocidadeMedia()) {
					heroi.setPosicao(quantidadeHerois.length - i);
				}
			}
		}
		
		return resposta;
	}

	public HeroiResponse analisaHeroi(Map<Heroi, List<Volta>> corrida, Heroi heroi) {
		HeroiResponse responseHeroi = new HeroiResponse();
		List<Volta> voltas = corrida.get(heroi);

		responseHeroi.setCodigo(heroi.getNome().substring(0, 3));
		responseHeroi.setNome(heroi.getNome().substring(4, heroi.getNome().length()));
		responseHeroi.setPosicao(0);
		responseHeroi.setQuantidadeVoltas(String.valueOf(voltas.size()));
		String tempoTotal = String
				.valueOf(ChronoUnit.MILLIS.between(voltas.get(0).getHora(), voltas.get(voltas.size() - 1).getHora()))
				+ " milisec";
		responseHeroi.setTempoTotalProva(tempoTotal);

		double velocidadeMedia = 0;
		int melhorvolta = 1;
		double tempoMelhorVolta = voltas.get(0).getTempoVoltaMilisegundos();

		for (Volta volta : voltas) {

			if (volta.getTempoVoltaMilisegundos() < tempoMelhorVolta) {
				melhorvolta = Integer.valueOf(volta.getNumeroVoltar());
				tempoMelhorVolta = volta.getTempoVoltaMilisegundos();
				if (volta.getTempoVoltaMilisegundos() < melhorVoltaCorrida) {
					melorVoltaCorr = "Super-heroi: " + heroi.getNome() + " Volta : "
							+ Integer.valueOf(volta.getNumeroVoltar()) + " Tempo : "
							+ volta.getTempoVoltaMilisegundos();
					melhorVoltaCorrida = volta.getTempoVoltaMilisegundos();
				}
			}
			velocidadeMedia += volta.getVelocidadeMediaVolta();
		}

		responseHeroi.setVelocidadeMedia(velocidadeMedia / voltas.size());
		responseHeroi.setMelhorVolta(melhorvolta);
		return responseHeroi;
	}

}
