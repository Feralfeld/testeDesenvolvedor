package questao2.application.exception;

public class ProcessoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8068423005080811501L;

	public ProcessoException(final String mensagem) {
		super(mensagem);
	}
}
