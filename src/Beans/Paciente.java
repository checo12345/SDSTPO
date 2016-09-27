package Beans;
import Beans.Persona;
import java.util.Date;

public class Paciente extends Persona{
    private String alergia, padecimientos,tipoSangre,observacion,curp;
    private int idPaciente;
    public Paciente(){}
    
    public String getAlergias(){return alergia;}
    public String getPadecimientos(){return tipoSangre;}
    public String getObservaciones(){return observacion;}
    public String getTipoSangre(){return padecimientos;}
    public String getCurp(){return curp;}
    public int getIdPaciente(){return idPaciente;}
    public void setIdPaciente(int idPacienteP){idPaciente=idPacienteP;};
    public void setCurp(String curpP){curp=curpP;};
    public void setObservaciones(String obs){observacion=obs;};
    public void setTipoSangre(String sangre){tipoSangre=sangre;};
    public void setAlergias(String aler){alergia=aler;}
    public void setPadecimiento(String pade){padecimientos=pade;}
    
}
