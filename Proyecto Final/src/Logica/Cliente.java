package Logica;

import static Logica.MetodosSQL.cn;
import static Logica.MetodosSQL.st;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar
 */
public class Cliente extends Persona{
    
    MetodosSQL metodos = new MetodosSQL();
    
    public void altaClientes(String Nombre, String Apellidos,
            String Direccion, String FechaNacimiento, String NumeroTelefono)
    {
            nombre = Nombre;
            apellidos = Apellidos;
            direccion = Direccion;
            fechaNacimiento = FechaNacimiento;
            numeroTelefono = NumeroTelefono;

        try
        {
        metodos.conectar();
        
        String result = "INSERT INTO CLIENTES VALUES('','" + nombre + "', '" + //Resul es la concatenacion de valores para hacer una consulta a la base de datos.
                apellidos + "', '" + direccion + "', '" + 
                fechaNacimiento + "', '" + numeroTelefono + "')";
        
        st.execute(result); //Se ejecuta la consulta.
        cn.close(); //Cierra la coneccion con base de datos.     
        JOptionPane.showMessageDialog(null, "Registro Guardado");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Error al llenar datos\n" + e);
        }
    }
}
