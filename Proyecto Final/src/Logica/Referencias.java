
package Logica;

import static Logica.MetodosSQL.st;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar
 */
public class Referencias extends Persona{
    
    MetodosSQL metodos = new MetodosSQL();
    Cliente cliente = new Cliente();
    
    public void altaReferencias(String Nombre, String Apellidos,
            String Direccion, String NumeroTelefono, int IdCliente)
    {
            nombre = Nombre;
            apellidos = Apellidos;
            direccion = Direccion;
            numeroTelefono = NumeroTelefono;
            id = IdCliente; 

        try
        {
        metodos.conectar();
        
        String result = "INSERT INTO REFERENCIAS VALUES('','" + nombre + "', '" + //Resul es la concatenacion de valores para hacer una consulta a la base de datos.
                apellidos + "', '" + direccion + "', '" + numeroTelefono + "',"+ id +")";
        
        st.execute(result); //Se ejecuta la consulta.
        
        MetodosSQL.cn.close(); //Cierra la coneccion con base de datos.     
        JOptionPane.showMessageDialog(null, "Referencia Guardada");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Error al llenar datos\n" + e);
        }
    }
    
    
}
