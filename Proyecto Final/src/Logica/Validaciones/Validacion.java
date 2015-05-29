/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Validaciones;

/**
 * Clase con la cual se realizan validaciones de los campos.
 * @author Krystel Baca
 */
public class Validacion {
    
    public static final String VACIO = "";
    public static final String CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP";
    
    /**
     * Metodo para checar el valor introducido es numerico.
     *
     * @param cadena a validar
     * @return
     */
    public static Boolean esNumerico(String cadena) {
        try {
            Double d = Double.parseDouble(cadena.trim());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para revisar que una cadena no sea nula ni este vacia.
     * @param cadena
     * @return
     */
    public static Boolean esCadenaValida(String cadena) {
        return cadena != null && !cadena.isEmpty() && !cadena.trim().isEmpty();
    }
}
