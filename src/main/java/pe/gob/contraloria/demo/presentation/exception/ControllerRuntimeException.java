package pe.gob.contraloria.demo.presentation.exception;

public class ControllerRuntimeException extends RuntimeException{

	private static final long serialVersionUID = -4037122593616095257L;

	public ControllerRuntimeException(String mensaje) {
		super(mensaje);
	}

}
