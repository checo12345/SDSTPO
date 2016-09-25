package Beans;
import Beans.Persona;
import java.util.Date;

public class Paciente extends Persona{
    private String alergias, padecimientos,tipoSangre,observaciones,curp;
    public Paciente(){}
    
    public String getAlergias(){return alergias;}
    public String getPadecimientos(){return tipoSangre;}
    public String getObservaciones(){return observaciones;}
    public String getTipoSangre(){return padecimientos;}
    public String getCurp(){return curp;}
    public void setCurp(String curpP){curp=curpP;};
    public void setObservaciones(String sangre){observaciones=sangre;};
    public void setTipoSangre(String sangre){tipoSangre=sangre;};
    public void setAlergias(String aler){alergias=aler;}
    public void setPadecimiento(String pade){padecimientos=pade;}
    
}
