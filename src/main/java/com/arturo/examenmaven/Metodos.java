package com.arturo.examenmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Arturo
 */
public class Metodos{

    private Document doc;

    public void obtenerWeb(){
        try{
            doc=Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();

        }catch(IOException ex){
            Logger.getLogger(ExamenMaven.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String tituloWeb(){
        String tit=doc.title();
        //JOptionPane.showMessageDialog(null,doc.title());
        return tit;
    }

    public String temperatura(){
        String temp=doc.select("div.today_nowcard-temp").text();
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }

    public String frasePronostico(){
        String frase=doc.select("div.today_nowcard-phrase").text();
        //JOptionPane.showMessageDialog(null, frase);
        return frase;
    }

    public String localizacion(){
        String loc=doc.select("h1.h4.today_nowcard-location").text();
        //JOptionPane.showMessageDialog(null, loc);
        return loc;
    }

    public void salidaDatos(){
        JOptionPane.showMessageDialog(null, "El tiempo de hoy en "+localizacion()+"."
                +"\nLa temperatura es de "+temperatura()+" la situación Metereologica actual es de "+frasePronostico()
                +"\nDatos extraidos de "+tituloWeb());
    }

}
