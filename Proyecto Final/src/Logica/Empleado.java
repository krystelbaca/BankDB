package Logica;

import static Logica.MetodosConexion.rs;
import static Logica.MetodosConexion.st;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar
 */
public class Empleado extends Persona{

    public Empleado() {
    
    }
    
    MetodosConexion metodos = new MetodosConexion();
    
    String contrasenia;
    String puesto;
    String usuario;
    
    //Variable
    
    
    //Operaciones
    public boolean Ingresar(String Usuario, String Contrasenia)
    {
        usuario = Usuario;
        contrasenia = Contrasenia;
        try {
            metodos.conectar();
            String result = "SELECT * FROM EMPLEADOS WHERE usuario = '" + usuario + "' AND contrasenia = '" + contrasenia + "'";
            rs = st.executeQuery(result);
            if(rs.next() == true){
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }        
    
    public void altaEmpleados(String Nombre, String Apellidos,
            String Direccion, String FechaNacimiento, String NumeroTelefono,
            String Puesto, String Contrasenia, String Usuario)
    {
            nombre = Nombre;
            apellidos = Apellidos;
            direccion = Direccion;
            fechaNacimiento = FechaNacimiento;
            numeroTelefono = NumeroTelefono;
            contrasenia = Contrasenia;
            usuario = Usuario;
            puesto = Puesto;
        
        try
        {
        metodos.conectar();
        
        String result = "INSERT INTO EMPLEADOS VALUES('','" + nombre + "', '" + //Resul es la concatenacion de valores para hacer una consulta a la base de datos.
                apellidos + "', '" + direccion + "', '" + 
                fechaNacimiento + "', '" + numeroTelefono + "', '" + 
                puesto + "', '" + contrasenia + "', '" + usuario + "')";
        
        st.execute(result); //Se ejecuta la consulta.
        metodos.cn.close(); //Cierra la coneccion con base de datos.     
        JOptionPane.showMessageDialog(null, "Registro Guardado");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Error al llenar datos\n" + e);
        }
    }
    
    
}
