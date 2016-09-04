
package DAO;

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
    
}
