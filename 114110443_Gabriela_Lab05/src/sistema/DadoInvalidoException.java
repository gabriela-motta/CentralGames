package sistema;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

public class DadoInvalidoException extends EntradaException {
	
	public DadoInvalidoException() {
		super("Dado especificado e invalido");
	}

	public DadoInvalidoException(String mensagem) {
		super(mensagem);

	}
}