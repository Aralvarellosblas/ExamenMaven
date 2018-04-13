package com.arturo.examenmaven;

/**
 * Esta clase contiene el metodo principal del programa
 *
 * @author Arturo
 */
public class ExamenMaven{

    /**
     * Metodo main con el constructor de la clase y las llamadas a los metodos
     * del programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Metodos m=new Metodos();
        m.obtenerWeb();
        m.salidaDatos();
    }

}
