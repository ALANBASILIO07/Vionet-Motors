package Files;

import java.io.Serializable;

/**
 *
 * @author Alan Basilio
 */
public class Citas implements Serializable
{
    public String nombre;
    public int ID;
    public String cliente;
    public String automovil;

    public Citas()
    {
        
    }

    public Citas(String nombre, int ID, String cliente, String automovil)
    {
        this.nombre = nombre;
        this.ID = ID;
        this.cliente = cliente;
        this.automovil = automovil;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    public String getAutomovil()
    {
        return automovil;
    }

    public void setAutomovil(String automovil)
    {
        this.automovil = automovil;
    }
    
    
}
