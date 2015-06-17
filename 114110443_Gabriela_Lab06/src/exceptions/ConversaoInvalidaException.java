package exceptions;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

public class ConversaoInvalidaException extends LogicaException {

	public ConversaoInvalidaException() {
		super();
	}

	public ConversaoInvalidaException(String mensagem) {
		super(mensagem);
	}
}