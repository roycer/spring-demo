package pe.gob.contraloria.demo.presentation.exception;

public class ModelNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4037122593616095257L;

	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}

}
