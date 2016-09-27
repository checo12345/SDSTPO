
package Clases;
import Beans.Paciente;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.RegistrarPaciente;
import java.util.logging.Logger;
/**
 *
 * @author Sergio
 */
public class PacienteClass {
    private static final Logger logger = Logger.getLogger("PacienteClass:");
    
    public ServicioRespuesta registrarPaciente()
    {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: registrarPaciente() ============");
        try {
             ServicioDAO servicio = new ServicioDAO();
             Paciente regPaciente= new Paciente() ;
        
             regPaciente.setNombre(RegistrarPaciente.nombre.getText());
             regPaciente.setApellidoPaterno(RegistrarPaciente.apellidoP.getText());
             regPaciente.setApellidoMaterno(RegistrarPaciente.apellidoM.getText());
             regPaciente.setFechaNacimiento(RegistrarPaciente.fechaNac.getText());
             regPaciente.setAlergias(RegistrarPaciente.alergias.getText());
             regPaciente.setDireccion(RegistrarPaciente.calle.getText()+" "+RegistrarPaciente.numero.getText()+" "+RegistrarPaciente.deloMun.getText());
             regPaciente.setTelefono(RegistrarPaciente.telefono.getText());
             regPaciente.setSexo(RegistrarPaciente.sexo.getText());
             regPaciente.setPadecimiento(RegistrarPaciente.enfermedades.getText());
             regPaciente.setTipoSangre(RegistrarPaciente.tipoSangre.getText());
             regPaciente.setObservaciones(RegistrarPaciente.observaciones.getText());
            
             respuesta= servicio.registrarPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             logger.info("Se registro el paciente con ID: "+ regPaciente.getIdPaciente());
             respuesta= servicio.registrarObservacionesPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
            
              respuesta= servicio.registrarAlergiasPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             
             respuesta= servicio.registrarPadecimientosPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             
             respuesta.setSuccess(true);
             respuesta.setResult(respuesta);
             respuesta.setMensaje("Se registraron todos los datos del Paciente "+ regPaciente.getNombre()+" Correctamente");
             
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
