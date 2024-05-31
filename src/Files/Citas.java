package Files;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Basilio
 */
public class Citas implements Serializable
{

    public int folio;
    public String nombreCliente;
    public String modeloAuto;
    public int anioAuto;
    public double precioAuto;

    /*Contraseña base de datos*/
    String bdpass = "100%Freestyle";

    public Citas()
    {

    }

    public Citas(int folio, String nombreCliente, String modeloAuto, int anio, double precio)
    {
        this.folio = folio;
        this.nombreCliente = nombreCliente;
        this.modeloAuto = modeloAuto;
        this.anioAuto = anio;
        this.precioAuto = precio;
    }

    public int getFolio()
    {
        return folio;
    }

    public void setFolio(int folio)
    {
        this.folio = folio;
    }

    public String getNombreCliente()
    {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente)
    {
        this.nombreCliente = nombreCliente;
    }

    public String getModeloAuto()
    {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto)
    {
        this.modeloAuto = modeloAuto;
    }

    public int getAnioAuto()
    {
        return anioAuto;
    }

    public void setAnioAuto(int anioAuto)
    {
        this.anioAuto = anioAuto;
    }

    public double getPrecio()
    {
        return precioAuto;
    }

    public void setPrecioAuto(double precioAuto)
    {
        this.precioAuto = precioAuto;
    }

    public void altaCita(JComboBox<String> comboNombreCliente, JComboBox<String> comboModeloAuto, JComboBox<String> comboAnioAuto, JComboBox<String> comboPrecioAuto)
    {
        nombreCliente = comboNombreCliente.getSelectedItem().toString();
        modeloAuto = comboModeloAuto.getSelectedItem().toString();
        anioAuto = Integer.parseInt(comboAnioAuto.getSelectedItem().toString());
        precioAuto = Double.parseDouble(comboPrecioAuto.getSelectedItem().toString());

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar la cita
            String sql = "INSERT INTO cita (NombreCliente, ModeloAuto, AnioAuto, PrecioAuto) VALUES (?, ?, ?, ?)";

            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, nombreCliente);
                stmt.setString(2, modeloAuto);
                stmt.setInt(3, anioAuto);
                stmt.setDouble(4, precioAuto);

                // Ejecutar la sentencia
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0)
                {
                    // Reiniciar los JComboBox a sus valores por defecto
                    comboNombreCliente.setSelectedIndex(-1);
                    comboModeloAuto.setSelectedIndex(-1);
                    comboAnioAuto.setSelectedIndex(-1);
                    comboPrecioAuto.setSelectedIndex(-1);

                    JOptionPane.showMessageDialog(null, "Cita registrada exitosamente.");
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        }
    }
    
    public void altaCitaCliente(String NombreCliente, JComboBox<String> comboModeloAuto, JComboBox<String> comboAnioAuto, JComboBox<String> comboPrecioAuto)
    {
        modeloAuto = comboModeloAuto.getSelectedItem().toString();
        anioAuto = Integer.parseInt(comboAnioAuto.getSelectedItem().toString());
        precioAuto = Double.parseDouble(comboPrecioAuto.getSelectedItem().toString());

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar la cita
            String sql = "INSERT INTO cita (NombreCliente, ModeloAuto, AnioAuto, PrecioAuto) VALUES (?, ?, ?, ?)";

            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, NombreCliente);
                stmt.setString(2, modeloAuto);
                stmt.setInt(3, anioAuto);
                stmt.setDouble(4, precioAuto);

                // Ejecutar la sentencia
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0)
                {
                    // Reiniciar los JComboBox a sus valores por defecto
                    comboModeloAuto.setSelectedIndex(-1);
                    comboAnioAuto.setSelectedIndex(-1);
                    comboPrecioAuto.setSelectedIndex(-1);

                    JOptionPane.showMessageDialog(null, "Cita registrada exitosamente.");
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        }
    }

    public void consultaGeneralCita(JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);

        // Conexión a la base de datos y consulta de autos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT * FROM cita";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("AnioAuto");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("Folio"),
                        rs.getString("NombreCliente"),
                        rs.getString("ModeloAuto"),
                        anio, // Solo el año
                        rs.getString("PrecioAuto")
                    });
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void desactivarOtrosCombos(JTable jt, String cf, String vf, JComboBox<String> comboSeleccionado, JComboBox<String> comboFiltroCliente/*, JComboBox<String> comboFiltroModelo, JComboBox<String> comboFiltroAnio, JComboBox<String> comboFiltroPrecio*/)
    {
        // Desactivar todos los JComboBox excepto el seleccionado
        comboFiltroCliente.setEnabled(comboSeleccionado == comboFiltroCliente);
        //comboFiltroModelo.setEnabled(comboSeleccionado == comboFiltroModelo);
        //comboFiltroAnio.setEnabled(comboSeleccionado == comboFiltroAnio);
        //comboFiltroPrecio.setEnabled(comboSeleccionado == comboFiltroPrecio);

        consultaFiltrada(jt, cf, vf);
    }

    // Método para activar todos los JComboBox
    public void activarTodosCombos(JComboBox<String> comboFiltroCliente, JComboBox<String> comboFiltroModelo, JComboBox<String> comboFiltroAnio, JComboBox<String> comboFiltroPrecio)
    {
        comboFiltroCliente.setEnabled(true);
        comboFiltroModelo.setEnabled(true);
        comboFiltroAnio.setEnabled(true);
        comboFiltroPrecio.setEnabled(true);
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
            String sql = "SELECT * FROM cita WHERE " + campoFiltrado + " = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, valorFiltrado);
                ResultSet rs = stmt.executeQuery();
                // Llenar la tabla con los datos de la base de datos
                while (rs.next())
                {
                    // Obtener solo el año (primeros 4 caracteres)
                    String fechaCompleta = rs.getString("AnioAuto");
                    String anio = fechaCompleta.substring(0, 4);

                    tabla.addRow(new String[]
                    {
                        rs.getString("Folio"),
                        rs.getString("NombreCliente"),
                        rs.getString("ModeloAuto"),
                        anio, // Solo el año
                        rs.getString("PrecioAuto")
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
            String sql = "SELECT * FROM cita";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    jcb.addItem(rs.getString("Folio"));
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaComboModelo(JComboBox<String> comboModelo)
    {
        // Limpiar el ComboBox actual
        comboModelo.removeAllItems();

        // Conexión a la base de datos y consulta de autos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT Modelo FROM Auto";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    comboModelo.addItem(rs.getString("Modelo"));
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }

    public void agregaCombosAnioPrecio(JComboBox<String> comboModelo, JComboBox<String> comboAnio, JComboBox<String> comboPrecio)
    {
        comboModelo.addActionListener(e ->
        {
            String modeloSeleccionado = (String) comboModelo.getSelectedItem();
            if (modeloSeleccionado != null && !modeloSeleccionado.isEmpty())
            {
                // Conexión a la base de datos y consulta de datos del auto
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
                {
                    String sql = "SELECT Anio, Precio FROM Auto WHERE Modelo = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql))
                    {
                        stmt.setString(1, modeloSeleccionado);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next())
                        {
                            // Obtener solo el año (primeros 4 caracteres)
                            String fechaCompleta = rs.getString("Anio");
                            String anio = fechaCompleta.substring(0, 4);

                            // Limpiar y agregar los valores correspondientes
                            comboAnio.removeAllItems();
                            comboAnio.addItem(anio);
                            comboPrecio.removeAllItems();
                            comboPrecio.addItem(rs.getString("Precio"));

                            // Desactivar los combos de año y precio
                            comboAnio.setEnabled(false);
                            comboPrecio.setEnabled(false);
                        }
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
                }
            }
        });
    }
    
    public int buscaCitaEliminar(JTextField jtf, JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        // Limpiar la tabla actual
        tabla.setRowCount(0);
        folio = Integer.parseInt(jtf.getText());

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass);
            String sql = "SELECT * FROM cita WHERE Folio = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, folio);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                tabla.addRow(new String[]
                {
                    rs.getString("Folio"),
                    rs.getString("NombreCliente"),
                    rs.getString("ModeloAuto"),
                    rs.getString("AnioAuto"),
                    rs.getString("PrecioAuto"),
                });
                return 1;
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return 0;
    }
    
    public void selecCita(JComboBox<String> jcb, JTextField txtFolio,  JComboBox<String> jtf, JComboBox<String> jtf2, JComboBox<String> jtf3, JComboBox<String> jtf4)
    {
        // Obtener el modelo seleccionado del JComboBox
        String folioSeleccionado = (String) jcb.getSelectedItem();

        // Verificar si se ha seleccionado un elemento válido
        if (folioSeleccionado != null && !folioSeleccionado.isEmpty())
        {
            // Conexión a la base de datos y consulta de datos del auto
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
            {
                String sql = "SELECT * FROM cita WHERE folio = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setString(1, folioSeleccionado);
                    ResultSet rs = stmt.executeQuery();

                    // Verificar si se ha encontrado el registro correspondiente
                    if (rs.next())
                    {
                        txtFolio.setText(rs.getString("Folio")); // ID (String)
                        jtf.setSelectedItem(rs.getString("NombreCliente")); // (String)
                        jtf2.setSelectedItem(rs.getString("ModeloAuto")); // (String)
                        jtf3.setSelectedItem(rs.getString("AnioAuto")); // (String)
                        jtf4.setSelectedItem(rs.getString("PrecioAuto")); // (String)
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró la cita con el folio seleccionado.");
                    }
                }
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
            }
        }
    }
    
    public int eliminarCita(JTextField jtf, JTable jt)
    {
        DefaultTableModel tabla = (DefaultTableModel) jt.getModel();
        String valor;
        valor = (jt.getValueAt(jt.getSelectedRow(), 0).toString());

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            // Sentencia SQL para insertar el platillo
            String sql = "DELETE FROM cita WHERE folio = ?";
            // Crear la declaración preparada
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                // Establecer los parámetros
                stmt.setString(1, valor);

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
    
    public void agregaComboNombreCliente(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen nombres únicas
        Set<String> nombresUnicos = new HashSet<>();

        // Conexión a la base de datos y consulta
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT NombreCliente FROM cita";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String nombres = rs.getString("NombreCliente");
                    // Agregar solo nombres únicas al ComboBox
                    if (nombresUnicos.add(nombres))
                    {
                        jcb.addItem(nombres);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }
    
    public void agregaComboModeloAuto(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen transmisiones únicas
        Set<String> modelosUnicos = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT ModeloAuto FROM cita";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String modelos = rs.getString("ModeloAuto");
                    // Agregar solo transmisiones únicas al ComboBox
                    if (modelosUnicos.add(modelos))
                    {
                        jcb.addItem(modelos);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }
    
    public void agregaComboAnioAuto (JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen años únicos
        Set<String> aniosUnicos = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT AnioAuto FROM cita";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String fechaCompleta = rs.getString("AnioAuto");
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
    
    public void agregaComboPrecioAuto(JComboBox<String> jcb)
    {
        // Limpiar el ComboBox actual
        jcb.removeAllItems();

        // Usar un HashSet para asegurarse de que solo se agreguen transmisiones únicas
        Set<String> preciosUnicos = new HashSet<>();

        // Conexión a la base de datos y consulta de platillos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", bdpass))
        {
            String sql = "SELECT PrecioAuto FROM cita";
            try (PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                // Llenar el ComboBox con los datos de la base de datos
                while (rs.next())
                {
                    String precios = rs.getString("PrecioAuto");
                    // Agregar solo transmisiones únicas al ComboBox
                    if (preciosUnicos.add(precios))
                    {
                        jcb.addItem(precios);
                    }
                }
            }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la base de datos: " + ex.getMessage());
        }
    }
}