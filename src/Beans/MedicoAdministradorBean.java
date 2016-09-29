/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.MedicoBean;
import java.util.Date;

/**
 *
 * @author David Pantaleón
 */
public class MedicoAdministradorBean extends MedicoBean{
    private MedicoBean m;
    private String cargo;
    public MedicoAdministradorBean(){}
    public String getCargo(){return cargo;}
    public void setCargo(String car){cargo=car;}
}
