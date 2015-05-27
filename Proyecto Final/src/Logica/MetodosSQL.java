
package Logica;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MetodosSQL{ 
    
    //Variables Conexion
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
    catch(SQLException e)
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
    
    public ResultSet consultar(String resultset) {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(resultset);
            cn.commit();
        } catch (SQLException e) {
            return null;
        }        
        return resultado;
    }
    
    public ResultSet consultarId(String Result){
        rs = null;
        try {
            rs = st.executeQuery(Result);
            int id = rs.getInt(1);
            cn.commit();
            cn.close();
                    } catch (SQLException ex) {
            return null;
        }        
        return rs;
    }
    
        public void mostrarTabla(JTable tabla, String Sql)
    {
    try {
            //Para establecer el modelo al JTable
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            //Para ejecutar la consulta
            st = cn.createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
             rs = st.executeQuery(Sql);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
             modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
             Object[] fila = new Object[cantidadColumnas];
             for (int i = 0; i < cantidadColumnas; i++) {
               fila[i]=rs.getObject(i+1);
             }
             modelo.addRow(fila);
            }
            rs.close();
            cn.close();
       } catch (Exception ex) {
        ex.printStackTrace();
       }    
    }
}

    