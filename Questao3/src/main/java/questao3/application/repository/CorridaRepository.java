package questao3.application.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

import questao3.application.exception.ProcessoException;
import questao3.application.model.Heroi;
import questao3.application.model.Volta;

@Repository
public class CorridaRepository {
	public Map<Heroi, List<Volta>> testeHerois() {
		Map<Heroi, List<Volta>> corrida = new HashMap<>();

		try {
			FileInputStream fstream = new FileInputStream(
					"C:\\Users\\Fernando\\Documents\\Compasso\\testeDesenvolvedor\\Questao3\\src\\main\\java\\questao3\\application\\repository\\herois.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			while ((strLine = br.readLine()) != null) {
				String[] dados = strLine.split(";");

				Heroi heroi = new Heroi();
				heroi.setNome(dados[1]);

				Volta volta = new Volta();
				volta.setHora(LocalDateTime.parse("2021-01-09T" + dados[0]));
				volta.setNumeroVoltar(dados[2]);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

				Date date = sdf.parse("1970-01-01 00:" + dados[3]);

				volta.setTempoVoltaMilisegundos(date.getTime());
				volta.setVelocidadeMediaVolta(Double.valueOf(dados[4].replace(",", ".")));

				adicionaHeroi(corrida, heroi);
				adicionaVolta(corrida, heroi, volta);

				if (corrida.get(heroi).size() == 4) { // STOOP QUANDO O PRMEIRO CHEGA
					br.close();
					return corrida;
				}

			}
			fstream.close();

		} catch (Exception e) {
			throw new ProcessoException("Arquivo não encontrado");
		}

		return corrida;
	}
	
	public void adicionaVolta(Map<Heroi, List<Volta>> hm, Heroi heroi, Volta volta) {
		List<Volta> voltas = hm.get(heroi);
		voltas.add(volta);
		hm.put(heroi, voltas);
	}

	public void adicionaHeroi(Map<Heroi, List<Volta>> hm, Heroi heroi) {
		List<Volta> voltas = hm.get(heroi);
		if (voltas == null) {
			voltas = new ArrayList<>();
			hm.put(heroi, voltas);
		}
	}
}
