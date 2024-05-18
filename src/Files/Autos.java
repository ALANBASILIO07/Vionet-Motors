package Files;

import java.io.Serializable;

/**
 *
 * @author Alan Basilio
 */
public class Autos implements Serializable
{
    public int ID;
    public String modelo;
    public String transmision;
    public int anio;
    public String tipo;
    public double precio;
    public String fabricante;
    
    /*Contraseña base de datos*/
    String bdpass = "100%Freestyle";

    public Autos()
    {
        
    }

    public Autos(int ID, String modelo, String transmision, int anio, String tipo, double precio, String fabricante)
    {
        this.ID = ID;
        this.modelo = modelo;
        this.transmision = transmision;
        this.anio = anio;
        this.tipo = tipo;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getTransmision()
    {
        return transmision;
    }

    public void setTransmision(String transmision)
    {
        this.transmision = transmision;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    
}