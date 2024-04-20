package Files;

import java.io.Serializable;

/**
 *
 * @author Alan Basilio
 */
public class Clientes implements Serializable
{

    String usuario;
    String contrasenia;

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getContrasenia()
    {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }

    public Clientes(String usuario, String contrasenia)
    {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Clientes()
    {
        
    }
    
    
}
