
package Logica;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class MetodosConexion{
    
    //Variables
    public int contRegistros = 0;
    int ubicacioRegistros = 0;
    int buscador = 0;
    boolean enter = false;
    boolean idEncontrado = false;
    int NoColumnas;
    int NoFilas;    
    
    //Conexion
    static Connection cn;
    static Statement st;
    static ResultSet rs;
 
    public void conectar()
{
    try
    {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        cn = DriverManager.getConnection(url,"admin","wonder");
        st = cn.createStatement();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Conexion no realizada\n" + e);
    }
}
    
    //Metodo para validar la fecha
    public static boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            
        }
        return true;
    }
}

    