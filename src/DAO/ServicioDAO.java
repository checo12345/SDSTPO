package DAO;

import Beans.ConsultaMedicaBean;
import Beans.ManifestacionBean;
import Beans.Medicamento;
import Beans.MedicoBean;
import Beans.Paciente;
import Beans.PrediagnosticoBean;
import Beans.RecetaMedicaBean;
import Beans.RecetaMedicaMedicamento;
import Beans.ResultadoPrediagnostico;
import Beans.Sesion;
import Clases.ServicioRespuesta;
import Excepciones.SDTPOException;
import java.io.IOException;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Sergio
 */
public class ServicioDAO extends MyBatisConnectionFactory {

    private static final Logger logger = Logger.getLogger("ServicioDAO");

    public ServicioRespuesta autenticaUsuario(Sesion user) {
        logger.info("**********  SERVICIO METODO: autenticaUsuario(" + user.getPassword() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(user != null && user.getUsuario() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            Sesion authUser = (Sesion) sqlSession.selectOne("sql.obtenerUsuario", user);

            if (authUser != null) {
                logger.info("Usuario " + user + " autenticado correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Usuario " + user + " autenticado correctamente");
                respuesta.setResult(authUser);
            } else {
                logger.info("Usuario no encontrado");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Usuario no encontrado");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta registrarPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: registrarPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.insert("sql.registrarPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se registro el paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se registro el paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se puede registrar al pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se puede registrar al pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    
    
    public ServicioRespuesta actualizarPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: actualizarPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.update("sql.actualizarPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se Actualizo el paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se Actualizo el paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se puede Actualizar al pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se puede Actualizar al pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
 
    public ServicioRespuesta actualizarObservacionesPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: actualizarObservacionesPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.update("sql.actualizarObservacionesPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se Actualizo Observaciones del paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se Actualizo Observaciones del paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se puede Actualizar Observaciones del pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se puede Actualizar Observaciones del pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public ServicioRespuesta actualizarAlergiasPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: actualizarAlergiasPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.update("sql.actualizarAlergiasPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se Actualizo Alergias del paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se Actualizo Alergias del paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se puede Actualizar Alergias del pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se puede Actualizar Alergias del pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    
    
        public ServicioRespuesta actualizarPadecimientosPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: actualizarPadecimientosPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.update("sql.actualizarPadecimientosPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se Actualizo Padecimientos del paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se Actualizo Padecimientos del paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se puede Actualizar Padecimientos del paciente: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se puede Actualizar Padecimientos del paciente: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public ServicioRespuesta registrarObservacionesPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: registrarObservacionesPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.insert("sql.registrarObservacionesPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se registraron las observaciones del paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se registraron las observaciones del paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se registraron las observaciones del pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No registraron las observaciones del pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta registrarAlergiasPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: registrarAlergiasPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.insert("sql.registrarAlergiasPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se registraron las Alergias del paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se registraron las Alergias del paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se registraron las Alergias del pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No registraron las Alergias del pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta registrarPadecimientosPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: registrarPadecimientosPaciente(" + paciente.getNombre() + "**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if (!(paciente != null && paciente.getNombre() != null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int afectados = sqlSession.insert("sql.registrarPadecimientosPaciente", paciente);

            if (afectados > 0) {
                logger.info("Se registraron las Padecimientos del paciente " + paciente.getNombre() + " correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Se registraron las Padecimientos del paciente " + paciente.getNombre() + " correctamente");
            } else {
                logger.info("No se registraron las Padecimientos del pacienter: " + paciente.getNombre());
                respuesta.setSuccess(false);
                respuesta.setMensaje("No registraron las Padecimientos del pacienter: " + paciente.getNombre());
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    
    public ServicioRespuesta buscaPaciente(Paciente paciente) {
        logger.info("**********  SERVICIO METODO: buscaPaciente(" + paciente.getCurp()+ ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((paciente == null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            Paciente encontrado = (Paciente) sqlSession.selectOne("sql.getPaciente", paciente);

            if (encontrado != null) {
                logger.info("Usuario " + paciente.getIdPaciente() + " autenticado correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Paciente " + paciente + " encontrado correctamente");
                respuesta.setResult(encontrado);
            } else {
                logger.info("Usuario no encontrado");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Paciente no encontrado");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
     public ServicioRespuesta buscarObservacionesPaciente(int idPaciente) {
        logger.info("**********  SERVICIO METODO: buscarObservacionesPaciente(" + idPaciente+ ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((idPaciente == 0)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            String observaciones = sqlSession.selectOne("sql.getObservaciones", idPaciente);

            if (observaciones != null) {
                logger.info("Observaciones del paciente" + idPaciente + " encontradas");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Observaciones del paciente" + idPaciente + " encontradas");
                respuesta.setResult(observaciones);
            } else {
                logger.info("Observaciones no encontradas");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Observaciones no encontradas");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
     public ServicioRespuesta buscarAlergiasPaciente(int idPaciente) {
        logger.info("**********  SERVICIO METODO: buscarAlergiasPaciente(" + idPaciente+ ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((idPaciente == 0)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            String observaciones = sqlSession.selectOne("sql.getAlergias", idPaciente);

            if (observaciones != null) {
                logger.info("Alergias del paciente" + idPaciente + " encontradas");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Alergias del paciente" + idPaciente + " encontradas");
                respuesta.setResult(observaciones);
            } else {
                logger.info("Alergias no encontradas");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Alergias no encontradas");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
     
        public ServicioRespuesta buscarPadecimientosPaciente(int idPaciente) {
        logger.info("**********  SERVICIO METODO: buscarPadecimientosPaciente(" + idPaciente+ ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((idPaciente == 0)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            String observaciones = sqlSession.selectOne("sql.getPadecimientos", idPaciente);

            if (observaciones != null) {
                logger.info("Padecimientos del paciente" + idPaciente + " encontradas");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Padecimientos del paciente" + idPaciente + " encontradas");
                respuesta.setResult(observaciones);
            } else {
                logger.info("Padecimientos no encontradas");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Padecimientos no encontradas");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public ServicioRespuesta buscaMedico(MedicoBean medico) {
        logger.info("**********  SERVICIO METODO: buscaMedico(" + medico + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((medico == null)) {
                throw new SDTPOException("Petición Inválida");
            }

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            MedicoBean encontrado = (MedicoBean) sqlSession.selectOne("sql.getMedico", medico);

            if (encontrado != null) {
                logger.info("Usuario " + medico.getCedulaProfesional() + " autenticado correctamente");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Medico " + encontrado + " encontrado correctamente");
                respuesta.setResult(encontrado);
            } else {
                logger.info("Usuario no encontrado");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Paciente no encontrado");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta getNextConsulta() {
        logger.info("**********  SERVICIO METODO: getNextConsulta()**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int nextConsulta = (int) sqlSession.selectOne("sql.nextConsulta");

            if (nextConsulta != 0) {
                logger.info("Siguinte Consulta " + nextConsulta);
                respuesta.setSuccess(true);
                respuesta.setMensaje("Siguinte Consulta " + nextConsulta);
                respuesta.setResult(nextConsulta);
            } else {
                logger.info("No existe consulta");
                respuesta.setSuccess(false);
                respuesta.setMensaje("No existe consulta");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta getNextReceta() {
        logger.info("**********  SERVICIO METODO: getNextReceta()**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
            int nextReceta = (int) sqlSession.selectOne("sql.nextReceta");

            if (nextReceta != 0) {
                logger.info("Siguinte Receta " + nextReceta);
                respuesta.setSuccess(true);
                respuesta.setMensaje("Siguinte Receta " + nextReceta);
                respuesta.setResult(nextReceta);
            } else {
                logger.info("No existe Receta");
                respuesta.setSuccess(false);
                respuesta.setMensaje("No existe Receta");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta insertarConsulta(ConsultaMedicaBean consulta) {
        logger.info("**********  SERVICIO METODO: insertatConsulta(" + consulta + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((consulta == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertConsulta", consulta));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta insertarManifestacion(ManifestacionBean manifestacion) {
        logger.info("**********  SERVICIO METODO: insertarManifestacion(" + manifestacion + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((manifestacion == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertManifestacion", manifestacion));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta insertarRecetaMedicamento(RecetaMedicaMedicamento recetaMedicamento) {
        logger.info("**********  SERVICIO METODO: insertarRecetaMedicamento(" + recetaMedicamento + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((recetaMedicamento == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertRecetaMedicamento", recetaMedicamento));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta getMedicamentos() {
        logger.info("**********  SERVICIO METODO: getMedicamentos()**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();

            List<Medicamento> list = sqlSession.selectList("sql.getAllMedicamento");
            if (list != null) {
                logger.info("Medicamentos encontrados: " + list.size());
                respuesta.setSuccess(true);
                respuesta.setMensaje("Medicamentos encontrados: " + list.size());
                respuesta.setResult(list);
            } else {
                logger.info("No se obtuvo respuesta de medicamentos");
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se obtuvo respuesta de medicamentos");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta insertarMedicamento(Medicamento medicamento) {
        logger.info("**********  SERVICIO METODO: insertatMedicamento(" + medicamento + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((medicamento == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertMedicamento", medicamento));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta insertarReceta(RecetaMedicaBean receta) {
        logger.info("**********  SERVICIO METODO: insertaReceta(" + receta + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((receta == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertReceta", receta));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public String insertarMedico(MedicoBean med,Sesion s){
        int val1=0,val2=0;
        logger.info("*********************** PROCESO GUARDAR NUEVO MEDICO ***********************");
        SqlSession sqlSession = null;
        String respuesta="";            
        try {
            sqlSession = getSQLSession();
            val1=sqlSession.insert("sql.insertMedico",med);
            val2=sqlSession.insert("sql.insertSesion",s);
            sqlSession.commit();
            logger.info("Valor_1:"+val1+"\t"+"Valor_2:"+val2);
            if (val1>0 && val2>0){
                respuesta="OK";
            }else
                respuesta="Error desconocido";
        } catch (IOException ex) {
            Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("/tERROR FATAL: " + ex.getMessage());
            respuesta=ex.getMessage();
        }finally{
            logger.info("sqlSession.close();");
            if(sqlSession!=null)sqlSession.close();
        }
        return respuesta;
    }
    public ServicioRespuesta seleccionarMedico(MedicoBean med) {
        logger.info("*********************** PROCESO ACTUALIZAR MEDICO (" + med + ") ***********************");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        MedicoBean med_sel=new MedicoBean();
        respuesta.setMensaje("NOT EXECUTED");
        respuesta.setSuccess(false);
        try {
            sqlSession = getSQLSession();
            med_sel=(MedicoBean)sqlSession.selectOne("sql.selMedico",med);
            
            if (med_sel!= null) {
                logger.info(med_sel.getCedulaProfesional()+"|"+med_sel.getNombre()+"|"+med_sel.getApellidoPaterno()+"|"+med_sel.getApellidoMaterno()+"|"+med_sel.getEspecialidad()+"|"+med_sel.getTelefono()+"|"+med_sel.getFechaNacimiento()+"|"+med_sel.getDireccion());
                respuesta.setSuccess(true);
                respuesta.setMensaje("Medico Seleccionado con exito");
                respuesta.setResult(med_sel);
            }else{
                respuesta.setSuccess(false);
                respuesta.setMensaje("Medico No Encontrado");
                //respuesta.setResult(respuesta);
            }
            
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }finally{
            logger.info("sqlSession.close();");
            if(sqlSession!=null)sqlSession.close();            
        }
        return respuesta;
    }

    public ServicioRespuesta getMedico(int cedulaProf) {
        logger.info("*********************** PROCESO OBTENER MEDICO (" + cedulaProf + ") ***********************");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        MedicoBean med_sel=new MedicoBean(cedulaProf);
        respuesta.setMensaje("NOT EXECUTED");
        respuesta.setSuccess(false);
        try {
            sqlSession = getSQLSession();
            med_sel=(MedicoBean)sqlSession.selectOne("sql.selMedico",med_sel);
            
            if (med_sel!= null) {
                logger.info("Medico Seleccionado.");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Medico Seleccionado con exito");
                respuesta.setResult(med_sel);
            }else{
                logger.info("Medico NO Seleccionado.");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Medico No Encontrado");
                //respuesta.setResult(respuesta);
            }
            
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }finally{
            logger.info("sqlSession.close();");
            if(sqlSession!=null)sqlSession.close();            
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public String actualizarMedico(MedicoBean m, Sesion s) {
        logger.info("*********************** PROCESO ACTUALIZAR MEDICO () ***********************");
        String respuesta="";
        int val1=0,val2=0;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSQLSession();
            val1=sqlSession.update("sql.updateMedico", m);
            val2=sqlSession.update("sql.updateSesion", s);
            sqlSession.commit();
            logger.info("Valor_1:"+val1+"\t"+"Valor_2:"+val2);
            if (val1>0 && val2>0){
                respuesta="OK";
            }else
                respuesta="Error desconocido.";
        }catch(Exception e){
            respuesta=e.getMessage();
        }finally{
            logger.info("sqlSession.close();");
            if(sqlSession!=null)sqlSession.close();            
        }
        return respuesta;
    }
    public ServicioRespuesta getSesion(int cedulaProf) {
        logger.info("*********************** PROCESO OBTENER SESION (" + cedulaProf + ") ***********************");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        //Medico med_sel=new MedicoBean(cedulaProf);
        Sesion ses=new Sesion(cedulaProf);
        respuesta.setMensaje("NOT EXECUTED");
        respuesta.setSuccess(false);
        try {
            sqlSession = getSQLSession();
            ses=(Sesion)sqlSession.selectOne("sql.selSesion",ses);
            
            if (ses!= null) {
                logger.info("Sesion Seleccionada.");
                respuesta.setSuccess(true);
                respuesta.setMensaje("Sesion Seleccionada con exito");
                respuesta.setResult(ses);
            }else{
                logger.info("Sesion NO Seleccionada.");
                respuesta.setSuccess(false);
                respuesta.setMensaje("Sesion No Encontrada");
                //respuesta.setResult(respuesta);
            }
            
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }finally{
            logger.info("sqlSession.close();");
            if(sqlSession!=null)sqlSession.close();            
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    
    public ServicioRespuesta getConsultas(String curp) {
        logger.info("**********  SERVICIO METODO: getConsultas()**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();

            List<ConsultaMedicaBean> list = sqlSession.selectList("sql.getAllConsultas",curp);
            if (list != null) {
                logger.info("Consultas encontradas: " + list.size());
                for(ConsultaMedicaBean c:list){
                    c.setManifestaciones(sqlSession.selectList("sql.getAllManifestaciones",c.getIdConsulta()));
                    logger.info("Manifestaciones: "+c.getManifestaciones().size());
                }
                respuesta.setSuccess(true);
                respuesta.setMensaje("Consultas encontrados: " + list.size());
                respuesta.setResult(list);
            } else {
                logger.info("No se obtuvo respuesta de Consultas");
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se obtuvo respuesta de Consultas");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }

    public ServicioRespuesta getReceta(int idConsulta) {
        logger.info("**********  SERVICIO METODO: getReceta()**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
logger.info("buscando receta con idConsulta="+idConsulta);
            RecetaMedicaBean receta  = sqlSession.selectOne("sql.selReceta",idConsulta);
            if (receta != null) {
                logger.info("Receta Encontrada: "+receta.getIdReceta());
                
                    receta.setMedicamentos(sqlSession.selectList("sql.getAllMedicamentosReceta",receta.getIdReceta()));
                    logger.info("Medicamentos: "+receta.getMedicamentos().size());
                
                respuesta.setSuccess(true);
                respuesta.setMensaje("Receta Encontrada: "+receta.getIdReceta());
                respuesta.setResult(receta);
            } else {
                logger.info("No se obtuvo respuesta de Receta");
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se obtuvo respuesta de Receta");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public ServicioRespuesta insertarResultadoPre(ResultadoPrediagnostico rpb) {
        logger.info("**********  SERVICIO METODO: insertatPrediagnostico(" + rpb + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((rpb == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertReultadoPredignostico", rpb));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public ServicioRespuesta insertarPrediagnostico(PrediagnosticoBean pb) {
        logger.info("**********  SERVICIO METODO: insertatPrediagnostico(" + pb + ")**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {
            if ((pb == null)) {
                throw new SDTPOException("Petición Inválida");
            }
            sqlSession = getSQLSession();

            respuesta.setResult(sqlSession.insert("sql.insertPredignostico", pb));
            respuesta.setMensaje("insercion realizada");
            respuesta.setSuccess(true);

            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
    public ServicioRespuesta getPrediagnostico(int idConsulta) {
        logger.info("**********  SERVICIO METODO: getPrediagnostico()**********");
        ServicioRespuesta respuesta = new ServicioRespuesta();
        SqlSession sqlSession = null;
        try {

            respuesta.setMensaje("NOT EXECUTED");
            respuesta.setSuccess(false);
            sqlSession = getSQLSession();
logger.info("buscando prediagnostico con idConsulta="+idConsulta);
            PrediagnosticoBean prediagnostico  = sqlSession.selectOne("sql.selPrediagnostico",idConsulta);
            if (prediagnostico != null) {
                logger.info("Prediagnostico Encontrado: "+prediagnostico.getIdPreDiag());
                
                    prediagnostico.setResultados(sqlSession.selectList("sql.getAllResultadosPrediag",prediagnostico.getIdPreDiag()));
                    logger.info("Medicamentos: "+prediagnostico.getResultados().size());
                
                respuesta.setSuccess(true);
                respuesta.setMensaje("Receta Encontrada: "+prediagnostico.getIdPreDiag());
                respuesta.setResult(prediagnostico);
            } else {
                logger.info("No se obtuvo respuesta de Receta");
                respuesta.setSuccess(false);
                respuesta.setMensaje("No se obtuvo respuesta de Receta");
            }
            sqlSession.commit();
            logger.info("PERFORM COMMIT();");
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            if (e.getCause() instanceof SQLException) {
                SQLException sqlE = (SQLException) e.getCause();
                logger.info("###SQL ERROR###: [" + sqlE.getErrorCode() + "] " + sqlE.getMessage());
            }
            respuesta.setSuccess(false);
            respuesta.setMensaje("Ocurrió una excepción.");
        } finally {
            logger.info("sqlSession.close();");
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("************************" + respuesta + "************************");
        return respuesta;
    }
}
