package Logica;


import static Logica.MetodosSQL.rs;
import static Logica.MetodosSQL.st;
import java.sql.SQLException;

/**
 *
 * @author Edgar
 */
public class Empleado extends Persona{

    public Empleado() {
    
    }
    
    MetodosSQL metodos = new MetodosSQL();
    
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
            String result = "SELECT * FROM EMPLEADOS WHERE usuario like '" + usuario + "' AND contrasena like '" + contrasenia + "'";
            System.out.println(result);
            rs = st.executeQuery(result);
            System.out.println("Entro en el catch");
            if(rs.next()){
                metodos.cn.close();
                return true;
            }
            else
            {   
                System.out.println("pito");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("MENSAJOTE DE ERROR BASE" +e);
            return false;
        }
    }
    
    
}
