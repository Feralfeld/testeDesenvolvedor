package questao2.application.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.core.env.Environment;

@Service
@PropertySource("classpath:imagens.xml")
public class ArquivosMapService {

	private Environment enviroment;

	public ArquivosMapService(Environment enviroment) {
		this.enviroment = enviroment;
	}

	public String getCaminho(final String key) {
		Assert.notNull(key, "A chave não pode ser nula");
		return this.enviroment.getProperty(key);
	}

}
