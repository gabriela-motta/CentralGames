package exceptions;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

public class StringInvalidaException extends EntradaException {

	public StringInvalidaException() {
		super("String especificada e invalida");
	}

	public StringInvalidaException(String mensagem) {
		super(mensagem);
	}

}
