package Files;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alan Basilio
 */
@Entity
public class Usuarios implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nomUsuario;
    private String contraseña;

    public Usuarios()
    {
        
    }

    public Usuarios(String nomUsuario, String contraseña)
    {
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
    }

    public String getNomUsuario()
    {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario)
    {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }
}
