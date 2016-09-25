package Beans;
import java.util.Date;

abstract class Persona {
    private String nombre, apellidoPaterno, apellidoMaterno, calle,numero,delMun, sexo,fechaNacimiento,telefono;
    public Persona(){}

    public String getNombre(){return nombre;}
    public String getApellidoPaterno(){return apellidoPaterno;}
    public String getApellidoMaterno(){return apellidoMaterno;}
    public String getFechaNacimiento(){return fechaNacimiento;}
    public String getTelefono(){return telefono;}
    public String getCalle(){return calle;}
    public String getSexo(){return sexo;}
    public String getNumero(){return numero;}
    public String getDeloMun(){return delMun;}
   
    public void setNombre(String nom){nombre=nom;}
    public void setApellidoPaterno(String apePat){apellidoPaterno=apePat;}
    public void setApellidoMaterno(String apeMat){apellidoMaterno=apeMat;}
    public void setFechaNacimiento(String fecNac){fechaNacimiento=fecNac;}
    public void setTelefono(String tel){telefono=tel;}
    public void setSexo(String sex){sexo=sex;}
    public void setCalle(String calleD){calle=calleD;}
    public void setNumero(String num){numero=num;}
    public void setDeloMun(String delMuni){delMun=delMuni;}
}
