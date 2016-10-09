package Beans;
import java.util.Date;

abstract class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String telefono;
    private String direccion;
    private String sexo;
    
    public Persona(){}
    public Persona(String nom,String apeP,String apeM,String fecNac,String Tel,String dir,String sex){
        nombre=nom;
        apellidoPaterno=apeP;
        apellidoMaterno=apeM;
        fechaNacimiento=fecNac;
        telefono=Tel;
        direccion=dir;
        sexo=sex;
    }
    public String getNombre(){return nombre;}
    public String getApellidoPaterno(){return apellidoPaterno;}
    public String getApellidoMaterno(){return apellidoMaterno;}
    public String getFechaNacimiento(){return fechaNacimiento;}
    public String getTelefono(){return telefono;}
    public String getDireccion(){return direccion;}
    public String getSexo(){return sexo;}
    public void setNombre(String nom){nombre=nom;}
    public void setApellidoPaterno(String apePat){apellidoPaterno=apePat;}
    public void setApellidoMaterno(String apeMat){apellidoMaterno=apeMat;}
    public void setFechaNacimiento(String fecNac){fechaNacimiento=fecNac;}
    public void setTelefono(String tel){telefono=tel;}
    public void setDireccion(String dir){direccion=dir;}
    public void setSexo(String sex){sexo=sex;}
}
