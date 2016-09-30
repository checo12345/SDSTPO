
package Clases;
import Beans.Paciente;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.RegistrarPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
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
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
             Date fechaNac=formatter.parse(RegistrarPaciente.fechaNac.getText());
             regPaciente.setNombre(RegistrarPaciente.nombre.getText());
             regPaciente.setApellidoPaterno(RegistrarPaciente.apellidoP.getText());
             regPaciente.setApellidoMaterno(RegistrarPaciente.apellidoM.getText());
             regPaciente.setFechaNacimiento(fechaNac);
             regPaciente.setAlergia(RegistrarPaciente.alergias.getText());
             regPaciente.setDireccion(RegistrarPaciente.deloMun.getText());
             regPaciente.setTelefono(RegistrarPaciente.telefono.getText());
             regPaciente.setSexo(RegistrarPaciente.sexo.getText());
             regPaciente.setPadecimientos(RegistrarPaciente.enfermedades.getText());
             regPaciente.setTipoSangre(RegistrarPaciente.tipoSangre.getText());
             regPaciente.setObservacion(RegistrarPaciente.observaciones.getText());
             regPaciente.setCurp(RegistrarPaciente.curp.getText());
             
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
    
    public ServicioRespuesta buscarPaciente()
    {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: buscarPaciente() ============");
        try {
             ServicioDAO servicio = new ServicioDAO();
             Paciente p = new Paciente() ;
             p.setCurp(RegistrarPaciente.curpPaciente.getText());
             respuesta= servicio.buscaPaciente(p) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             logger.info("Se registro el paciente con ID: "+ p.getIdPaciente());
             p=(Paciente)respuesta.getResult() ;
             respuesta= servicio.buscarObservacionesPaciente(p.getIdPaciente()) ;
             p.setObservacion((String)respuesta.getResult());
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
              respuesta= servicio.buscarAlergiasPaciente(p.getIdPaciente()) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
              p.setAlergia((String)respuesta.getResult());
             respuesta= servicio.buscarPadecimientosPaciente(p.getIdPaciente()) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             p.setPadecimientos((String)respuesta.getResult());
             
             respuesta.setSuccess(true);
             respuesta.setResult(p);
             respuesta.setMensaje("Se recuperaron todos los datos del Paciente "+ p.getNombre()+" Correctamente");
             
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
    
    public ServicioRespuesta actualizarPaciente(int idPaciente)
    {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: actualizarPaciente() ============");
        try {
             ServicioDAO servicio = new ServicioDAO();
             Paciente regPaciente= new Paciente() ;
             regPaciente.setIdPaciente(idPaciente);
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
             Date fechaNac=formatter.parse(RegistrarPaciente.fechaNac.getText());
             regPaciente.setNombre(RegistrarPaciente.nombre.getText());
             regPaciente.setApellidoPaterno(RegistrarPaciente.apellidoP.getText());
             regPaciente.setApellidoMaterno(RegistrarPaciente.apellidoM.getText());
             regPaciente.setFechaNacimiento(fechaNac);
             regPaciente.setAlergia(RegistrarPaciente.alergias.getText());
             regPaciente.setDireccion(RegistrarPaciente.deloMun.getText());
             regPaciente.setTelefono(RegistrarPaciente.telefono.getText());
             regPaciente.setSexo(RegistrarPaciente.sexo.getText());
             regPaciente.setPadecimientos(RegistrarPaciente.enfermedades.getText());
             regPaciente.setTipoSangre(RegistrarPaciente.tipoSangre.getText());
             regPaciente.setObservacion(RegistrarPaciente.observaciones.getText());
             regPaciente.setCurp(RegistrarPaciente.curp.getText());
             
             respuesta= servicio.actualizarPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}

             respuesta= servicio.actualizarObservacionesPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
            
              respuesta= servicio.actualizarAlergiasPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             
             respuesta= servicio.actualizarPadecimientosPaciente(regPaciente) ;
             if ((!respuesta.isSuccess())) {throw new SDTPOException(respuesta.getMensaje());}
             
             respuesta.setSuccess(true);
             respuesta.setResult(respuesta);
             respuesta.setMensaje("Se actualizaron todos los datos del Paciente "+ regPaciente.getNombre()+" Correctamente");
             
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
