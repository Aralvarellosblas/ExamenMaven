package com.arturo.examenmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Clase que contiene los metodos necesarios para obtener la información de la
 * web del tiempo
 *
 * @author Arturo
 */
public class Metodos{

    private Document doc; //Elemento de tipo Documento en el que se almacena la información obtenida de la web

    /**
     * Metodo que recoge toda la información de la pagina web
     */
    public void obtenerWeb(){
        try{
            doc=Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();

        }catch(IOException ex){
            Logger.getLogger(ExamenMaven.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que extrae el titulo de la web
     *
     * @return String con el titulo para su posterior uso
     */
    public String tituloWeb(){
        String tit=doc.title();
        //JOptionPane.showMessageDialog(null,doc.title());
        return tit;
    }

    /**
     * Se extrae la temperatura actual de la pagina web
     *
     * @return String con la temperatura actual
     */
    public String temperatura(){
        String temp=doc.select("div.today_nowcard-temp").text();
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }

    /**
     * Recoge la información meteorológica actual
     *
     * @return String con la información meteorológica
     */
    public String frasePronostico(){
        String frase=doc.select("div.today_nowcard-phrase").text();
        //JOptionPane.showMessageDialog(null, frase);
        return frase;
    }

    /**
     * Extrae la localización de la predicción del tiempo
     *
     * @return String con la localización
     */
    public String localizacion(){
        String loc=doc.select("h1.h4.today_nowcard-location").text();
        //JOptionPane.showMessageDialog(null, loc);
        return loc;
    }

    /**
     * Metodo para la salida de datos ordenada en pantalla
     */
    public void salidaDatos(){
        JOptionPane.showMessageDialog(null, "El tiempo de hoy en "+localizacion()+"."
                +"\nLa temperatura es de "+temperatura()+" la situación Metereologica actual es de "+frasePronostico()
                +"\nDatos extraidos de "+tituloWeb());
    }

}
