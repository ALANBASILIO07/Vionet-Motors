package Files;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Basilio
 */
public class DBConnection
{

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "100%Freestyle";
    private static String URL = "jdbc:mysql://localhost:3306/concesionario";

    static
    {
        try
        {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Error en el Driver: " + e);
        }
    }
    
    public Connection getConection()
    {
        Connection con = null;
        try
        {
            con = (Connection) DriverManager.getConnection(URL, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexión Exitosa");
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error de Conexión: " + e);
        }
        return con;
    }
}
