package Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Alan Basilio
 */
public class Cliente
{
    private String usuario;
    private String contrasenia;
    
     /*Contraseña base de datos*/
    String bdpass = "100%Freestyle";

    public Cliente()
    {
        
    }

    public Cliente(String usuario, String contrasenia)
    {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

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

    public String getBdpass()
    {
        return bdpass;
    }

    public void setBdpass(String bdpass)
    {
        this.bdpass = bdpass;
    }
    
     public void altaUsuario(JTextField jtf, JPasswordField jpf)
    {
        usuario = jtf.getText();
        contrasenia = "";
        char[] contra = jpf.getPassword();
        for (int i = 0; i < contra.length; i++)
        {
            contrasenia += contra[i];
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar el platillo
            String sql = "INSERT INTO usuario (Nombre, Contraseña) VALUES (?, ?)";

            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, usuario);
                stmt.setString(2, contrasenia);

                // Ejecutar la sentencia
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0)
                {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    jtf.setText("");
                    jpf.setText("");
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        }
    }

    public int buscarCliente(JTextField jtf)
    {
        usuario = jtf.getText();

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT Nombre FROM usuario WHERE Nombre = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
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
    
    public void modifCliente(JTable jt, JTextField jtf, JTextField jtf2)
    {
        String valor;
        valor = (jt.getValueAt(jt.getSelectedRow(), 0).toString());
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "UPDATE usuario SET Nombre = ?, Contraseña = ? WHERE Nombre = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, jtf.getText());
                stmt.setString(2, jtf2.getText());
                stmt.setString(3, valor);

                // Ejecutar la sentencia
                stmt.executeUpdate();

            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }
}
