package Files;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Alan Basilio
 */
public class Administradores implements Serializable
{

    public String usuario;
    public String contraseña;
    public String codigoAcceso;

    public String getCodigoAcceso()
    {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso)
    {
        this.codigoAcceso = codigoAcceso;
    }
    Scanner leer = new Scanner(System.in);

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    public Scanner getLeer()
    {
        return leer;
    }

    public void setLeer(Scanner leer)
    {
        this.leer = leer;
    }

    public Administradores(String usuario, String contraseña, String codigoAcceso)
    {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codigoAcceso = codigoAcceso;
    }

    public Administradores()
    {
        
        
    }
    
    
}
