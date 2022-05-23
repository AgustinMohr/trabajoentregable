package guia05.ejIntegrador;

@SuppressWarnings("serial")
public class CantMaxBienesException extends Exception {
	
	public CantMaxBienesException() {
		
	}
	
	public CantMaxBienesException(String msj_error) {
		super(msj_error);
	}
	
}
