
package Clases;

import Beans.Sesion;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.inicioSesion;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class Login {
    private static final Logger logger = Logger.getLogger("Login:");
    public ServicioRespuesta validarIngreso()
    {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: validarIngreso() ============");
        try {
             ServicioDAO servicio = new ServicioDAO();
             Sesion user= new Sesion() ;
        
             user.setPassword(inicioSesion.jTextField2.getText());
             user.setUsuario(inicioSesion.jTextField1.getText() );
             respuesta= servicio.autenticaUsuario(user) ;
             if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {throw new SDTPOException("Ocurrio un error al iniciar Sesion");}
             
             respuesta.setSuccess(true);
             respuesta.setResult(respuesta);
             respuesta.setMensaje(respuesta.getMensaje());
             
        } catch (SDTPOException e) {
	  logger.info("" + e.getMessage());
          respuesta.setSuccess(false);
	  respuesta.setMensaje(e.getMessage());
	} catch (Exception e) {
	  logger.info("###ERROR### " + e.getMessage());
	  respuesta.setSuccess(false);
	  respuesta.setMensaje(e.getMessage());
	}
        return respuesta;
    }
    
}
