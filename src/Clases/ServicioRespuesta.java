
package Clases;

/**
 *
 * @author Sergio
 */

public class ServicioRespuesta {
	private boolean success;
	private String mensaje;
	private Object result;		
	
	public ServicioRespuesta() {
		super();
	}

	public ServicioRespuesta(boolean success, String mensaje, Object result) {
		super();
		this.success = success;
		this.mensaje = mensaje;
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
