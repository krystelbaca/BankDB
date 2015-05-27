/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void altaReferencias(String Nombre, String Apellidos,
            String Direccion, String NumeroTelefono)
    {
            nombre = Nombre;
            apellidos = Apellidos;
            direccion = Direccion;
            numeroTelefono = NumeroTelefono;

        try
        {
        metodos.conectar();
        
        String result = "INSERT INTO CLIENTES VALUES('','" + nombre + "', '" + //Resul es la concatenacion de valores para hacer una consulta a la base de datos.
                apellidos + "', '" + direccion + "', '" + numeroTelefono + "')";
        
        st.execute(result); //Se ejecuta la consulta.
        
        MetodosSQL.cn.close(); //Cierra la coneccion con base de datos.     
        JOptionPane.showMessageDialog(null, "Registro Guardado");
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Error al llenar datos\n" + e);
        }
    }
    
    
}
