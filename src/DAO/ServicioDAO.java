
package DAO;

import Beans.Paciente;
import Beans.Sesion;
import Clases.ServicioRespuesta;
import Excepciones.SDTPOException ;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class ServicioDAO extends MyBatisConnectionFactory{
    
    private static final Logger logger = Logger.getLogger("ServicioDAO");
    
    public ServicioRespuesta autenticaUsuario(Sesion user){
		logger.info("**********  SERVICIO METODO: autenticaUsuario(" +user.getPassword()+"**********");
		ServicioRespuesta respuesta = new ServicioRespuesta();
		SqlSession sqlSession = null;
		try{
			if(!(user !=null && user.getUsuario()!=null)){
				throw new SDTPOException("Petición Inválida");
			}

			respuesta.setMensaje("NOT EXECUTED");
			respuesta.setSuccess(false);
			sqlSession = getSQLSession();
			Sesion authUser = (Sesion)sqlSession.selectOne("sql.obtenerUsuario",user);

			if (authUser!=null){					
				  logger.info("Usuario " + user + " autenticado correctamente");
				  respuesta.setSuccess(true);
				  respuesta.setMensaje("Usuario " + user + " autenticado correctamente");
				  respuesta.setResult(authUser);				
			}else{
                                logger.info("Usuario no encontrado");
				respuesta.setSuccess(false);
				respuesta.setMensaje("Usuario no encontrado");
			}
			sqlSession.commit();
			logger.info("PERFORM COMMIT();");
		}catch(Exception e){
			logger.info(e.getMessage());
			e.printStackTrace();
			if(e.getCause() instanceof SQLException){
				SQLException sqlE = (SQLException)e.getCause();
				logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());					
			}
			respuesta.setSuccess(false);
			respuesta.setMensaje("Ocurrió una excepción.");
		}finally{
			logger.info("sqlSession.close();");
			if(sqlSession!=null)sqlSession.close();			
		}
		logger.info("************************" + respuesta + "************************");
		return respuesta;
	}
    public ServicioRespuesta registrarPaciente(Paciente paciente){
		logger.info("**********  SERVICIO METODO: registrarPaciente("+paciente.getNombre()+"**********");
		ServicioRespuesta respuesta = new ServicioRespuesta();
		SqlSession sqlSession = null;
		try{
			if(!(paciente !=null && paciente.getNombre()!=null)){throw new SDTPOException("Petición Inválida");}

			respuesta.setMensaje("NOT EXECUTED");
			respuesta.setSuccess(false);
			sqlSession = getSQLSession();
			int afectados=sqlSession.insert("sql.registrarPaciente",paciente);

			if (afectados>0){					
				  logger.info("Se registro el paciente " + paciente.getNombre() + " correctamente");
				  respuesta.setSuccess(true);
				  respuesta.setMensaje("Se registro el paciente " + paciente.getNombre() + " correctamente");			
			}else{
                                logger.info("No se puede registrar al pacienter: "+ paciente.getNombre());
				respuesta.setSuccess(false);
				respuesta.setMensaje("No se puede registrar al pacienter: "+ paciente.getNombre());
			}
			sqlSession.commit();
			logger.info("PERFORM COMMIT();");
		}catch(Exception e){
			logger.info(e.getMessage());
			e.printStackTrace();
			if(e.getCause() instanceof SQLException){
				SQLException sqlE = (SQLException)e.getCause();
				logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());					
			}
			respuesta.setSuccess(false);
			respuesta.setMensaje("Ocurrió una excepción.");
		}finally{
			logger.info("sqlSession.close();");
			if(sqlSession!=null)sqlSession.close();			
		}
		logger.info("************************" + respuesta + "************************");
		return respuesta;
	}
    
    public ServicioRespuesta registrarObservacionesPaciente(Paciente paciente){
		logger.info("**********  SERVICIO METODO: registrarObservacionesPaciente("+paciente.getNombre()+"**********");
		ServicioRespuesta respuesta = new ServicioRespuesta();
		SqlSession sqlSession = null;
		try{
			if(!(paciente !=null && paciente.getNombre()!=null)){throw new SDTPOException("Petición Inválida");}

			respuesta.setMensaje("NOT EXECUTED");
			respuesta.setSuccess(false);
			sqlSession = getSQLSession();
			int afectados=sqlSession.insert("sql.registrarObservacionesPaciente",paciente);

			if (afectados>0){					
				  logger.info("Se registraron las observaciones del paciente " + paciente.getNombre() + " correctamente");
				  respuesta.setSuccess(true);
				  respuesta.setMensaje("Se registraron las observaciones del paciente " + paciente.getNombre() + " correctamente");			
			}else{
                                logger.info("No se registraron las observaciones del pacienter: "+ paciente.getNombre());
				respuesta.setSuccess(false);
				respuesta.setMensaje("No registraron las observaciones del pacienter: "+ paciente.getNombre());
			}
			sqlSession.commit();
			logger.info("PERFORM COMMIT();");
		}catch(Exception e){
			logger.info(e.getMessage());
			e.printStackTrace();
			if(e.getCause() instanceof SQLException){
				SQLException sqlE = (SQLException)e.getCause();
				logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());					
			}
			respuesta.setSuccess(false);
			respuesta.setMensaje("Ocurrió una excepción.");
		}finally{
			logger.info("sqlSession.close();");
			if(sqlSession!=null)sqlSession.close();			
		}
		logger.info("************************" + respuesta + "************************");
		return respuesta;
	}
     public ServicioRespuesta registrarAlergiasPaciente(Paciente paciente){
		logger.info("**********  SERVICIO METODO: registrarAlergiasPaciente("+paciente.getNombre()+"**********");
		ServicioRespuesta respuesta = new ServicioRespuesta();
		SqlSession sqlSession = null;
		try{
			if(!(paciente !=null && paciente.getNombre()!=null)){throw new SDTPOException("Petición Inválida");}

			respuesta.setMensaje("NOT EXECUTED");
			respuesta.setSuccess(false);
			sqlSession = getSQLSession();
			int afectados=sqlSession.insert("sql.registrarAlergiasPaciente",paciente);

			if (afectados>0){					
				  logger.info("Se registraron las Alergias del paciente " + paciente.getNombre() + " correctamente");
				  respuesta.setSuccess(true);
				  respuesta.setMensaje("Se registraron las Alergias del paciente " + paciente.getNombre() + " correctamente");			
			}else{
                                logger.info("No se registraron las Alergias del pacienter: "+ paciente.getNombre());
				respuesta.setSuccess(false);
				respuesta.setMensaje("No registraron las Alergias del pacienter: "+ paciente.getNombre());
			}
			sqlSession.commit();
			logger.info("PERFORM COMMIT();");
		}catch(Exception e){
			logger.info(e.getMessage());
			e.printStackTrace();
			if(e.getCause() instanceof SQLException){
				SQLException sqlE = (SQLException)e.getCause();
				logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());					
			}
			respuesta.setSuccess(false);
			respuesta.setMensaje("Ocurrió una excepción.");
		}finally{
			logger.info("sqlSession.close();");
			if(sqlSession!=null)sqlSession.close();			
		}
		logger.info("************************" + respuesta + "************************");
		return respuesta;
	}
     
     
              public ServicioRespuesta registrarPadecimientosPaciente(Paciente paciente){
		logger.info("**********  SERVICIO METODO: registrarPadecimientosPaciente("+paciente.getNombre()+"**********");
		ServicioRespuesta respuesta = new ServicioRespuesta();
		SqlSession sqlSession = null;
		try{
			if(!(paciente !=null && paciente.getNombre()!=null)){throw new SDTPOException("Petición Inválida");}

			respuesta.setMensaje("NOT EXECUTED");
			respuesta.setSuccess(false);
			sqlSession = getSQLSession();
			int afectados=sqlSession.insert("sql.registrarPadecimientosPaciente",paciente);

			if (afectados>0){					
				  logger.info("Se registraron las Padecimientos del paciente " + paciente.getNombre() + " correctamente");
				  respuesta.setSuccess(true);
				  respuesta.setMensaje("Se registraron las Padecimientos del paciente " + paciente.getNombre() + " correctamente");			
			}else{
                                logger.info("No se registraron las Padecimientos del pacienter: "+ paciente.getNombre());
				respuesta.setSuccess(false);
				respuesta.setMensaje("No registraron las Padecimientos del pacienter: "+ paciente.getNombre());
			}
			sqlSession.commit();
			logger.info("PERFORM COMMIT();");
		}catch(Exception e){
			logger.info(e.getMessage());
			e.printStackTrace();
			if(e.getCause() instanceof SQLException){
				SQLException sqlE = (SQLException)e.getCause();
				logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());					
			}
			respuesta.setSuccess(false);
			respuesta.setMensaje("Ocurrió una excepción.");
		}finally{
			logger.info("sqlSession.close();");
			if(sqlSession!=null)sqlSession.close();			
		}
		logger.info("************************" + respuesta + "************************");
		return respuesta;
	}
}
