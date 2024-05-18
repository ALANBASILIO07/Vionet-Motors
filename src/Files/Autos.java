package Files;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    public void altaAuto(JTextField jtf, JTextField jtf2, JTextField jtf3, JTextField jtf4, JTextField jtf5, JTextField jtf6)
    {
        modelo = jtf.getText();
        transmision = jtf2.getText();
        anio = Integer.parseInt(jtf3.getText());
        tipo = jtf4.getText();
        precio = Double.parseDouble(jtf5.getText());
        fabricante = jtf6.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar el platillo
            String sql = "INSERT INTO auto (Modelo, Transmision, Anio, Tipo, Precio, Fabricante) VALUES (?, ?, ?, ?, ?, ?)";

            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, modelo);
                stmt.setString(2, transmision);
                stmt.setInt(3, anio);
                stmt.setString(4, tipo);
                stmt.setDouble(5, precio);
                stmt.setString(6, fabricante);

                // Ejecutar la sentencia
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0)
                {
                    jtf.setText("");
                    jtf2.setText("");
                    jtf3.setText("");
                    jtf4.setText("");
                    jtf5.setText("");
                    jtf6.setText("");
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        }
    }

    public int buscaExistenciaAuto()
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT * FROM auto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return 1;
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return 0;
    }

    public void mostrarAutoEnAltaMed(JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", bdpass))
        {
            String sql = "SELECT ID, modelo, anio FROM auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("modelo"),
                        rs.getString("anio")
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public int buscaAutoEliminar(JTextField jtf, JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);
        modelo = jtf.getText();

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT ID, modelo, transmision, anio FROM auto WHERE modelo = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, modelo);
            ResultSet rs = stmt.executeQuery();
            //if (rs.next())
            //{
            while (rs.next())
            {
                tabla.addRow(new String[]
                {
                    rs.getString("ID"),
                    rs.getString("modelo"),
                    rs.getString("transmision"),
                    rs.getString("anio")
                });
                return 1;
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return 0;
    }

    public int eliminarAuto(JTextField jtf, JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();

        ID = Integer.parseInt(tabla.getValueAt(jt.getSelectedRow(), 0).toString());

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", bdpass))
        {
            // Sentencia SQL para insertar el platillo
            String sql = "DELETE FROM auto WHERE Modelo = ?";
            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setInt(1, ID);

                // Ejecutar la sentencia
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0)
                {
                    jtf.setText("");
                    tabla.setRowCount(0);
                    return 1;
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ocurrió un error con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;

    }
}