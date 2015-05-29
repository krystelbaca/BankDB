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
            String result = "SELECT * FROM EMPLEADOS WHERE usuario like '" + usuario + "' AND contrasenia = '" + contrasenia + "'";
            rs = st.executeQuery(result);
            if(rs.next() == true){
                metodos.cn.close();
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
    
    
}
