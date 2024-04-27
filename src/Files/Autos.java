package Files;

import java.io.Serializable;

/**
 *
 * @author Alan Basilio
 */
public class Autos implements Serializable
{
    public String modelo;
    public String fabricante;
    public String tipo;
    public int anio;
    public String transmision;
    public double precio;

    public Autos()
    {
        
    }

    public Autos(String modelo, String fabricante, String tipo, int anio, String transmision, double precio)
    {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.anio = anio;
        this.transmision = transmision;
        this.precio = precio;
    }

    
    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    public String getTransmision()
    {
        return transmision;
    }

    public void setTransmision(String transmision)
    {
        this.transmision = transmision;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    
    
}
