package Logica;

import static Logica.MetodosConexion.st;
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
    
    //Variable
    
    
    //Operaciones
    public void altaEmpleados(String Nombre, String Apellidos,
            String Direccion, String FechaNacimiento, String NumeroTelefono,
            String Puesto, String Contrasenia)
    {
        if(contRegistros >= 0 ){
            nombre = Nombre;
            apellidos = Apellidos;
            direccion = Direccion;
            fechaNacimiento = FechaNacimiento;
            numeroTelefono = NumeroTelefono;
            contrasenia = Contrasenia;
            puesto = Puesto;
        }
        
        try
    {
        metodos.conectar();
        
        String result = "INSERT INTO EMPLEADOS VALUES('','" + nombre + "', '" + //Resul es la concatenacion de valores para hacer una consulta a la base de datos.
                apellidos + "', '" + direccion + "', '" + 
                fechaNacimiento + "', '" + numeroTelefono + "', '" + 
                puesto + "', '" + contrasenia + "')";
        
        st.execute(result); //Se ejecuta la consulta.
        String Id = 
        metodos.cn.close(); //Cierra la coneccion con base de datos.     
        JOptionPane.showMessageDialog(null, "Registro Guardado");
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Error al llenar datos\n" + e);
    }
    }
    
    
}
