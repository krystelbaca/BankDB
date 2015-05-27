package Logica;

import static Logica.MetodosSQL.st;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar
 */
public class Cuenta {

    public Cuenta() {
    
    }
        MetodosSQL metodos = new MetodosSQL();
        
        int contRegistros = 0;
        int id_cuenta;
     
    public void altaCuenta()
    {
        if(contRegistros >= 0 ){
            
        }
        
        try
    {
        metodos.conectar();
        
        String result = "INSERT INTO CUENTAS VALUES('";
        st.execute(result);
        metodos.cn.close();
        JOptionPane.showMessageDialog(null, "Registro Guardado");
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Error al llenar datos\n" + e);
    }
}
}
