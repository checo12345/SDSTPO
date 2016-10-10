
package Clases;
import Beans.Paciente;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.RegistrarPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
/**
 *
 * @author Sergio
 */
public class PacienteClass {
    private static final Logger logger = Logger.getLogger("PacienteClass:");
    
    public ServicioRespuesta validarPaciente()
    {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: validarPaciente() ============");
        try {
                String cadena="" ;
                boolean estaVacio=false ;
                
             if (RegistrarPaciente.nombre.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.apellidoP.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.apellidoM.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.fechaNac.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.alergias.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.deloMun.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.telefono.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.enfermedades.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.observaciones.getText().length()==0)
                  estaVacio=true;
             if (RegistrarPaciente.curp.getText().length()==0)
                  estaVacio=true;
             
             
             cadena=(String)RegistrarPaciente.sexo.getSelectedItem();
             if (cadena.length()==0)
                  estaVacio=true;

             cadena=(String)RegistrarPaciente.tipoSangre.getSelectedItem();
             if (cadena.length()==0)
                  estaVacio=true;;
             
             respuesta.setSuccess(estaVacio);
        } catch (Exception e) {
	  logger.info("###ERROR### " + e.getMessage());
	  respuesta.setSuccess(false);
	  respuesta.setMensaje(e.getMessage());
	}
        return respuesta;
    }
    
    public ServicioRespuesta registrarPaciente()
    {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: registrarPaciente() ============");
        try {
             ServicioDAO servicio = new ServicioDAO();
             Paciente regPaciente= new Paciente() ;
             /*SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy");
             logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============FECHA: "+RegistrarPaciente.fechaNac.getText());
             Date fechaNac=formatter.parse(RegistrarPaciente.fechaNac.getText());*/
             regPaciente.setNombre(RegistrarPaciente.nombre.getText());
             regPaciente.setApellidoPaterno(RegistrarPaciente.apellidoP.getText());
             regPaciente.setApellidoMaterno(RegistrarPaciente.apellidoM.getText());
             String f_nac=RegistrarPaciente.fechaNac.getText();//01/10/1999
             if (f_nac.length()<=9)
                f_nac="0"+f_nac;
             f_nac=f_nac.substring(6,10)+f_nac.substring(2,6)+f_nac.substring(0,2);
             regPaciente.setFechaNacimiento(f_nac);
             regPaciente.setAlergia(RegistrarPaciente.alergias.getText());
             regPaciente.setDireccion(RegistrarPaciente.deloMun.getText());
             regPaciente.setTelefono(RegistrarPaciente.telefono.getText());
             regPaciente.setSexo((String)RegistrarPaciente.sexo.getSelectedItem());
             regPaciente.setPadecimientos(RegistrarPaciente.enfermedades.getText());
             regPaciente.setTipoSangre((String)RegistrarPaciente.tipoSangre.getSelectedItem());
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
            /* SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy");
             Date fechaNac=formatter.parse(RegistrarPaciente.fechaNac.getText());*/
             regPaciente.setNombre(RegistrarPaciente.nombre.getText());
             regPaciente.setApellidoPaterno(RegistrarPaciente.apellidoP.getText());
             regPaciente.setApellidoMaterno(RegistrarPaciente.apellidoM.getText());
             
             String f_nac=RegistrarPaciente.fechaNac.getText();//01/10/1999
             if (f_nac.length()<=9)
                f_nac="0"+f_nac;
             f_nac=f_nac.substring(6,10)+f_nac.substring(2,6)+f_nac.substring(0,2);
             regPaciente.setFechaNacimiento(f_nac);
             
             regPaciente.setAlergia(RegistrarPaciente.alergias.getText());
             regPaciente.setDireccion(RegistrarPaciente.deloMun.getText());
             regPaciente.setTelefono(RegistrarPaciente.telefono.getText());
             regPaciente.setSexo((String)RegistrarPaciente.sexo.getSelectedItem());
             regPaciente.setPadecimientos(RegistrarPaciente.enfermedades.getText());
             regPaciente.setTipoSangre((String)RegistrarPaciente.tipoSangre.getSelectedItem());
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
