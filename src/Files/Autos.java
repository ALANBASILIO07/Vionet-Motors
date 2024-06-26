package Files;

import Interface.VtnAutoAdmin;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    public byte[] imagen;

    // Estancias base de datos
    private static Connection Conection;
    private static Statement Consulta;
    private static ResultSet Resultado;

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

    public byte[] getImagen()
    {
        return imagen;
    }

    public void setImagen(byte[] imagen)
    {
        this.imagen = imagen;
    }

    public String getBdpass()
    {
        return bdpass;
    }

    public void setBdpass(String bdpass)
    {
        this.bdpass = bdpass;
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

    /*
    public void altaAuto(JTextField jtf, JComboBox jtf2, JTextField jtf3, JComboBox jtf4, JTextField jtf5, JTextField jtf6)
    {
        modelo = jtf.getText();
        transmision = jtf2.getSelectedItem().toString();
        anio = Integer.parseInt(jtf3.getText());
        tipo = jtf4.getSelectedItem().toString();
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
                    //jtf2.setText("");
                    jtf3.setText("");
                    //jtf4.setText("");
                    jtf5.setText("");
                    jtf6.setText("");
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        }
    }*/
    public void altaAuto(JTextField jtf, JComboBox<String> jtf2, JTextField jtf3, JComboBox<String> jtf4, JTextField jtf5, JTextField jtf6, File imagen)
    {
        modelo = jtf.getText();
        transmision = jtf2.getSelectedItem().toString();
        anio = Integer.parseInt(jtf3.getText());
        tipo = jtf4.getSelectedItem().toString();
        precio = Double.parseDouble(jtf5.getText());
        fabricante = jtf6.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "INSERT INTO auto (Modelo, Transmision, Anio, Tipo, Precio, Fabricante, Imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, modelo);
                stmt.setString(2, transmision);
                stmt.setInt(3, anio);
                stmt.setString(4, tipo);
                stmt.setDouble(5, precio);
                stmt.setString(6, fabricante);

                if (imagen != null)
                {
                    FileInputStream fis = new FileInputStream(imagen);
                    stmt.setBinaryStream(7, fis, (int) imagen.length());
                } else
                {
                    stmt.setNull(7, java.sql.Types.BLOB);
                }

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0)
                {
                    jtf.setText("");
                    jtf3.setText("");
                    jtf5.setText("");
                    jtf6.setText("");
                    //File.setIcon(null);
                }
            }
        } catch (Exception ex)
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

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar el platillo
            String sql = "DELETE FROM auto WHERE ID = ?";
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

    /*public void modifAuto(JComboBox jcb, JTextField txtID, JTextField jtf, JComboBox jtf2, JTextField jtf3, JComboBox jtf4, JTextField jtf5, JTextField jtf6)
    {
        modelo = jtf.getText();
        transmision = jtf2.getSelectedItem().toString();
        anio = Integer.parseInt(jtf3.getText());
        tipo = jtf4.getSelectedItem().toString();
        precio = Double.parseDouble(jtf5.getText());
        fabricante = jtf6.getText();

        String valor;
        valor = (jcb.getSelectedItem().toString());
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "UPDATE auto SET ID = ?, Modelo = ?, Transmision = ?, Anio = ?, Tipo = ?, Precio = ?, Fabricante = ? WHERE Modelo = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, txtID.getText()); // Modelo es String
                stmt.setString(2, modelo); // Modelo es String
                stmt.setString(3, transmision); // Transmisión es String
                // Para el año, necesitamos convertir el texto del JTextField a un objeto Year.
                stmt.setObject(4, anio); // Año es Year
                stmt.setString(5, tipo); // Tipo es String
                stmt.setDouble(6, precio); // Precio es Double
                stmt.setString(7, fabricante); // Fabricante es String
                stmt.setString(8, valor);

                // Ejecutar la sentencia
                stmt.executeUpdate();

            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos:  " + ex.getMessage());
        }
    }*/
    public void modifAuto(JComboBox<String> jcb, JTextField txtID, JTextField jtf, JComboBox<String> jtf2, JTextField jtf3, JComboBox<String> jtf4, JTextField jtf5, JTextField jtf6, File imagenFile) throws FileNotFoundException, IOException
    {
        modelo = jtf.getText();
        transmision = jtf2.getSelectedItem().toString();
        anio = Integer.parseInt(jtf3.getText());
        tipo = jtf4.getSelectedItem().toString();
        precio = Double.parseDouble(jtf5.getText());
        fabricante = jtf6.getText();

        String valor = jcb.getSelectedItem().toString();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "UPDATE auto SET Modelo = ?, Transmision = ?, Anio = ?, Tipo = ?, Precio = ?, Fabricante = ?, Imagen = ? WHERE Modelo = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, modelo); // Modelo es String
                stmt.setString(2, transmision); // Transmisión es String
                stmt.setInt(3, anio); // Año es int
                stmt.setString(4, tipo); // Tipo es String
                stmt.setDouble(5, precio); // Precio es Double
                stmt.setString(6, fabricante); // Fabricante es String

                // Leer la imagen y convertirla a un array de bytes
                byte[] imagenBytes = null;
                if (imagenFile != null)
                {
                    try (FileInputStream fis = new FileInputStream(imagenFile))
                    {
                        imagenBytes = fis.readAllBytes();
                    } catch (IOException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo de imagen: " + ex.getMessage());
                    }
                }
                stmt.setBytes(7, imagenBytes); // Imagen es un array de bytes

                stmt.setString(8, valor); // Valor del modelo para la cláusula WHERE

                // Ejecutar la sentencia
                stmt.executeUpdate();
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos de la base de datos: " + ex.getMessage());
        }
    }

    /*
    public void selecAuto(JComboBox<String> jcb, JTextField txtID, JTextField jtf, JComboBox<String> jtf2, JTextField jtf3, JComboBox<String> jtf4, JTextField jtf5, JTextField jtf6)
    {
        // Obtener el modelo seleccionado del JComboBox
        String modeloSeleccionado = (String) jcb.getSelectedItem();

        // Verificar si se ha seleccionado un elemento válido
        if (modeloSeleccionado != null && !modeloSeleccionado.isEmpty())
        {
            // Conexión a la base de datos y consulta de datos del auto
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
            {
                String sql = "SELECT * FROM Auto WHERE Modelo = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setString(1, modeloSeleccionado);
                    ResultSet rs = stmt.executeQuery();

                    // Verificar si se ha encontrado el registro correspondiente
                    if (rs.next())
                    {
                        txtID.setText(rs.getString("ID")); // ID (String)
                        jtf.setText(rs.getString("Modelo")); // Modelo (String)
                        jtf2.setSelectedItem(rs.getString("Transmision")); // Transmisión (String)

                        // Obtener solo el año (primeros 4 caracteres)
                        String fechaCompleta = rs.getString("Anio");
                        String anio = fechaCompleta.substring(0, 4);
                        jtf3.setText(anio); // Año (solo el año como String)

                        jtf4.setSelectedItem(rs.getString("Tipo")); // Tipo (String)
                        jtf5.setText(rs.getString("Precio")); // Precio (Double como String)
                        jtf6.setText(rs.getString("Fabricante")); // Fabricante (String)
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró el auto con el modelo seleccionado.");
                    }
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
            }
        }
    }*/
    public void selecAuto(JComboBox<String> jcb, JTextField txtID, JTextField jtf, JComboBox<String> jtf2, JTextField jtf3, JComboBox<String> jtf4, JTextField jtf5, JTextField jtf6, JLabel lblImagen)
    {
        // Obtener el modelo seleccionado del JComboBox
        String modeloSeleccionado = (String) jcb.getSelectedItem();

        // Verificar si se ha seleccionado un elemento válido
        if (modeloSeleccionado != null && !modeloSeleccionado.isEmpty())
        {
            // Conexión a la base de datos y consulta de datos del auto
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
            {
                String sql = "SELECT * FROM Auto WHERE Modelo = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setString(1, modeloSeleccionado);
                    ResultSet rs = stmt.executeQuery();

                    // Verificar si se ha encontrado el registro correspondiente
                    if (rs.next())
                    {
                        txtID.setText(rs.getString("ID")); // ID (String)
                        jtf.setText(rs.getString("Modelo")); // Modelo (String)
                        jtf2.setSelectedItem(rs.getString("Transmision")); // Transmisión (String)

                        // Obtener solo el año (primeros 4 caracteres)
                        String fechaCompleta = rs.getString("Anio");
                        String anio = fechaCompleta.substring(0, 4);
                        jtf3.setText(anio); // Año (solo el año como String)

                        jtf4.setSelectedItem(rs.getString("Tipo")); // Tipo (String)
                        jtf5.setText(rs.getString("Precio")); // Precio (Double como String)
                        jtf6.setText(rs.getString("Fabricante")); // Fabricante (String)

                        // Obtener la imagen y mostrarla en el JLabel
                        Blob imagenBlob = (Blob) rs.getBlob("Imagen");
                        if (imagenBlob != null)
                        {
                            int blobLength = (int) imagenBlob.length();
                            byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                            ImageIcon icon = new ImageIcon(blobAsBytes);
                            lblImagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
                        } else
                        {
                            lblImagen.setIcon(null);  // Si no hay imagen, limpiar el JLabel
                        }
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró el auto con el modelo seleccionado.");
                    }
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
            }
        }
    }

    /*
    public void selecAutoCliente(JComboBox<String> jcb, JLabel jtf, JLabel jtf2, JLabel jtf3, JLabel jtf4, JLabel jtf5, JLabel jtf6)
    {
        // Obtener el modelo seleccionado del JComboBox
        String modeloSeleccionado = (String) jcb.getSelectedItem();

        // Verificar si se ha seleccionado un elemento válido
        if (modeloSeleccionado != null && !modeloSeleccionado.isEmpty())
        {
            // Conexión a la base de datos y consulta de datos del auto
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
            {
                String sql = "SELECT * FROM Auto WHERE Modelo = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setString(1, modeloSeleccionado);
                    ResultSet rs = stmt.executeQuery();

                    // Verificar si se ha encontrado el registro correspondiente
                    if (rs.next())
                    {
                        jtf.setText(rs.getString("Modelo")); // Modelo (String)
                        jtf2.setText(rs.getString("Transmision")); // Transmisión (String)

                        // Obtener solo el año (primeros 4 caracteres)
                        String fechaCompleta = rs.getString("Anio");
                        String anio = fechaCompleta.substring(0, 4);
                        jtf3.setText(anio); // Año (solo el año como String)

                        jtf4.setText(rs.getString("Tipo")); // Tipo (String)
                        jtf5.setText(rs.getString("Precio")); // Precio (Double como String)
                        jtf6.setText(rs.getString("Fabricante")); // Fabricante (String)
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró el auto con el modelo seleccionado.");
                    }
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
            }
        }
    }*/
    public void selecAutoCliente(JComboBox<String> jcb, JLabel jtf, JLabel jtf2, JLabel jtf3, JLabel jtf4, JLabel jtf5, JLabel jtf6, JLabel lblImagenCliente)
    {
        // Obtener el modelo seleccionado del JComboBox
        String modeloSeleccionado = (String) jcb.getSelectedItem();

        // Verificar si se ha seleccionado un elemento válido
        if (modeloSeleccionado != null && !modeloSeleccionado.isEmpty())
        {
            // Conexión a la base de datos y consulta de datos del auto
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
            {
                String sql = "SELECT * FROM Auto WHERE Modelo = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setString(1, modeloSeleccionado);
                    ResultSet rs = stmt.executeQuery();

                    // Verificar si se ha encontrado el registro correspondiente
                    if (rs.next())
                    {
                        jtf.setText(rs.getString("Modelo")); // Modelo (String)
                        jtf2.setText(rs.getString("Transmision")); // Transmisión (String)

                        // Obtener solo el año (primeros 4 caracteres)
                        String fechaCompleta = rs.getString("Anio");
                        String anio = fechaCompleta.substring(0, 4);
                        jtf3.setText(anio); // Año (solo el año como String)

                        jtf4.setText(rs.getString("Tipo")); // Tipo (String)
                        jtf5.setText(rs.getString("Precio")); // Precio (Double como String)
                        jtf6.setText(rs.getString("Fabricante")); // Fabricante (String)

                        // Obtener la imagen y mostrarla en el JLabel
                        Blob imagenBlob = (Blob) rs.getBlob("Imagen");
                        if (imagenBlob != null)
                        {
                            int blobLength = (int) imagenBlob.length();
                            byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                            ImageIcon icon = new ImageIcon(blobAsBytes);
                            lblImagenCliente.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImagenCliente.getWidth(), lblImagenCliente.getHeight(), Image.SCALE_SMOOTH)));
                        } else
                        {
                            lblImagenCliente.setIcon(null);  // Si no hay imagen, limpiar el JLabel
                        }
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró el auto con el modelo seleccionado.");
                    }
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
            }
        }
    }

    public void consultaGeneralAuto(JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaCombo(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    jcb.addItem(rs.getString("Modelo"));
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaComboTransmision(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen transmisiones únicas
        Set<String> transmisionesUnicas = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Transmision FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String transmision = rs.getString("Transmision");
                    // Agregar solo transmisiones únicas al ComboBox
                    if (transmisionesUnicas.add(transmision))
                    {
                        jcb.addItem(transmision);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaComboTipo(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen transmisiones únicas
        Set<String> tipoUnico = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Tipo FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String tipo = rs.getString("Tipo");
                    // Agregar solo transmisiones únicas al ComboBox
                    if (tipoUnico.add(tipo))
                    {
                        jcb.addItem(tipo);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaComboAnio(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen años únicos
        Set<String> aniosUnicos = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Anio FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String fechaCompleta = rs.getString("Anio");
                    // Obtener solo el año (primeros 4 caracteres)
                    String anio = fechaCompleta.substring(0, 4);
                    // Agregar solo años únicos al ComboBox
                    if (aniosUnicos.add(anio))
                    {
                        jcb.addItem(anio);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaComboPrecio(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen transmisiones únicas
        Set<String> preciosUnicos = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Precio FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String precio = rs.getString("Precio");
                    // Agregar solo transmisiones únicas al ComboBox
                    if (preciosUnicos.add(precio))
                    {
                        jcb.addItem(precio);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaComboFabricante(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen transmisiones únicas
        Set<String> fabricanteUnico = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Fabricante FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String fabricante = rs.getString("Fabricante");
                    // Agregar solo transmisiones únicas al ComboBox
                    if (fabricanteUnico.add(fabricante))
                    {
                        jcb.addItem(fabricante);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void desactivarOtrosCombos(JTable jt, String cf, String vf, JComboBox<String> comboSeleccionado, JComboBox<String> comboTransmision, JComboBox<String> comboAnio, JComboBox<String> comboTipo, JComboBox<String> comboPrecio, JComboBox<String> comboFabricante)
    {
        // Desactivar todos los JComboBox excepto el seleccionado
        comboTransmision.setEnabled(comboSeleccionado == comboTransmision);
        comboAnio.setEnabled(comboSeleccionado == comboAnio);
        comboTipo.setEnabled(comboSeleccionado == comboTipo);
        comboPrecio.setEnabled(comboSeleccionado == comboPrecio);
        comboFabricante.setEnabled(comboSeleccionado == comboFabricante);

        consultaFiltrada(jt, cf, vf);
    }

    // Método para activar todos los JComboBox
    public void activarTodosCombos(JComboBox<String> comboTransmision, JComboBox<String> comboAnio, JComboBox<String> comboTipo, JComboBox<String> comboPrecio, JComboBox<String> comboFabricante)
    {
        comboTransmision.setEnabled(true);
        comboAnio.setEnabled(true);
        comboTipo.setEnabled(true);
        comboPrecio.setEnabled(true);
        comboFabricante.setEnabled(true);
    }

    public void consultaFiltradaTransmision(JTable jt, String transmisionSeleccionada)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos filtrada por transmisión
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto WHERE Transmision = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, transmisionSeleccionada);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void consultaFiltradaAnio(JTable jt, String transmisionSeleccionada)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos filtrada por transmisión
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto WHERE Anio = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, transmisionSeleccionada);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void consultaFiltradaPrecio(JTable jt, String transmisionSeleccionada)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos filtrada por transmisión
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto WHERE Precio = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, transmisionSeleccionada);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void consultaFiltradaTipo(JTable jt, String transmisionSeleccionada)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos filtrada por transmisión
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto WHERE Tipo = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, transmisionSeleccionada);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void consultaFiltradaFabricante(JTable jt, String transmisionSeleccionada)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos filtrada por transmisión
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM Auto WHERE Fabricante = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, transmisionSeleccionada);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void consultaFiltrada(JTable jt, String campoFiltrado, String valorFiltrado)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos filtrada por campo
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Generar la consulta SQL dinámicamente
            String sql = "SELECT * FROM Auto WHERE " + campoFiltrado + " = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, valorFiltrado);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("Anio");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("ID"),
                        rs.getString("Modelo"),
                        rs.getString("Transmision"),
                        anio, // Solo el año
                        rs.getString("Tipo"),
                        rs.getString("Precio"),
                        rs.getString("Fabricante"),
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void mostrarAutos(JLabel[] lblImagenes, JLabel[] lblModelos)
    {
        // Conexión a la base de datos y consulta de los datos de los autos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Modelo, Imagen FROM Auto LIMIT 6";
            try (Statement stmt = (Statement) conn.createStatement())
            {
                ResultSet rs = stmt.executeQuery(sql);

                int index = 0;
                while (rs.next() && index < 6)
                {
                    // Obtener el modelo y la imagen
                    String modelo = rs.getString("Modelo");
                    Blob imagenBlob = (Blob) rs.getBlob("Imagen");

                    // Configurar el JLabel del modelo
                    lblModelos[index].setText(modelo);

                    // Configurar el JLabel de la imagen
                    if (imagenBlob != null)
                    {
                        int blobLength = (int) imagenBlob.length();
                        byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                        ImageIcon icon = new ImageIcon(blobAsBytes);
                        lblImagenes[index].setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImagenes[index].getWidth(), lblImagenes[index].getHeight(), Image.SCALE_SMOOTH)));
                    } else
                    {
                        lblImagenes[index].setIcon(null);  // Si no hay imagen, limpiar el JLabel
                    }
                    index++;
                }

                // Limpiar los JLabel restantes si hay menos de 6 autos
                for (int i = index; i < 6; i++)
                {
                    lblModelos[i].setText("");
                    lblImagenes[i].setIcon(null);
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void desactivarOtrosCombosBusqueda(JComboBox<String> comboSeleccionado, JComboBox<String> comboTransmision, JComboBox<String> comboAnio, JComboBox<String> comboTipo, JComboBox<String> comboPrecio, JComboBox<String> comboFabricante)
    {
        // Desactivar todos los JComboBox excepto el seleccionado
        comboTransmision.setEnabled(comboSeleccionado == comboTransmision);
        comboAnio.setEnabled(comboSeleccionado == comboAnio);
        comboTipo.setEnabled(comboSeleccionado == comboTipo);
        comboPrecio.setEnabled(comboSeleccionado == comboPrecio);
        comboFabricante.setEnabled(comboSeleccionado == comboFabricante);
    }

    public int consultaFiltradaBusqueda(String campoFiltrado, String valorFiltrado, JLabel[] lblImagenes, JLabel[] lblModelos)
    {
        // Conexión a la base de datos y consulta de autos filtrada por campo
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT Modelo, Imagen FROM Auto WHERE " + campoFiltrado + " = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, valorFiltrado);
            ResultSet rs = stmt.executeQuery();

            int index = 0;
            while (rs.next() && index < 6)
            {
                String autoModelo = rs.getString("Modelo");
                Blob imagenBlob = (Blob) rs.getBlob("Imagen");

                lblModelos[index].setText(autoModelo);

                if (imagenBlob != null)
                {
                    int blobLength = (int) imagenBlob.length();
                    byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                    ImageIcon icon = new ImageIcon(blobAsBytes);
                    lblImagenes[index].setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImagenes[index].getWidth(), lblImagenes[index].getHeight(), Image.SCALE_SMOOTH)));
                } else
                {
                    lblImagenes[index].setIcon(null);
                }
                index++;
            }

            for (int i = index; i < 6; i++)
            {
                lblModelos[i].setText("");
                lblImagenes[i].setIcon(null);
            }

            rs.close();
            stmt.close();
            conn.close();

            return (index > 0) ? 1 : 0;
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return 0;
        }
    }

    public int buscaAutoMostrar(String modelo, JLabel[] lblImagenes, JLabel[] lblModelos)
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT Modelo, Imagen FROM Auto WHERE Modelo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, modelo);
            ResultSet rs = stmt.executeQuery();

            int index = 0;
            while (rs.next() && index < 6)
            {
                String autoModelo = rs.getString("Modelo");
                Blob imagenBlob = (Blob) rs.getBlob("Imagen");

                lblModelos[index].setText(autoModelo);

                if (imagenBlob != null)
                {
                    int blobLength = (int) imagenBlob.length();
                    byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                    ImageIcon icon = new ImageIcon(blobAsBytes);
                    lblImagenes[index].setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImagenes[index].getWidth(), lblImagenes[index].getHeight(), Image.SCALE_SMOOTH)));
                } else
                {
                    lblImagenes[index].setIcon(null);
                }
                index++;
            }

            for (int i = index; i < 6; i++)
            {
                lblModelos[i].setText("");
                lblImagenes[i].setIcon(null);
            }

            rs.close();
            stmt.close();
            conn.close();

            return (index > 0) ? 1 : 0;
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return 0;
        }
    }
}
