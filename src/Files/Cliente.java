package Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    
    public void consultaGeneralCliente(JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM usuario";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    tabla.addRow(new String[]
                    {
                        rs.getString("Nombre"),
                        rs.getString("Contraseña")
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }
    
    public void modifCliente(JComboBox jcb, JTextField jtf, JTextField jtf2)
    {
        usuario = jtf.getText();
        contrasenia = jtf2.getText();

        String valor;
        valor = (jcb.getSelectedItem().toString());
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "UPDATE usuario SET Nombre = ?, Contraseña = ? WHERE Nombre = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, usuario); // String
                stmt.setString(2, contrasenia); // String
                stmt.setString(3, valor);

                // Ejecutar la sentencia
                stmt.executeUpdate();

            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos:  " + ex.getMessage());
        }
    }
    
    public void selecCliente(JComboBox<String> jcb, JTextField jtf, JTextField jtf2)
    {
        // Obtener el modelo seleccionado del JComboBox
        String adminSeleccionado = (String) jcb.getSelectedItem();

        // Verificar si se ha seleccionado un elemento válido
        if (adminSeleccionado != null && !adminSeleccionado.isEmpty())
        {
            // Conexión a la base de datos y consulta de datos del auto
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
            {
                String sql = "SELECT * FROM usuario WHERE Nombre = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setString(1, adminSeleccionado);
                    ResultSet rs = stmt.executeQuery();

                    // Verificar si se ha encontrado el registro correspondiente
                    if (rs.next())
                    {
                        jtf.setText(rs.getString("Nombre")); // String)
                        jtf2.setText(rs.getString("Contraseña")); // (String)
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró el administrador seleccionado.");
                    }
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
            }
        }
    }
    
    public void agregaCombo(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM usuario";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    jcb.addItem(rs.getString("Nombre"));
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }
    
    public int buscaClienteEliminar(JTextField jtf, JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);
        usuario = jtf.getText();

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT * FROM usuario WHERE Nombre = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                tabla.addRow(new String[]
                {
                    rs.getString("Nombre"),
                    rs.getString("Contraseña"),
                });
                return 1;
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return 0;
    }
    
    public int eliminarCliente(JTextField jtf, JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();

        usuario = tabla.getValueAt(jt.getSelectedRow(), 0).toString();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar el platillo
            String sql = "DELETE FROM usuario WHERE Nombre = ?";
            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, usuario);

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
