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
        JOptionPane.showMessageDialog(null,doc.title());
        return tit;
    }
    public void temperatura(){
        String temp=doc.select("div.today_nowcard-temp").text();
        JOptionPane.showMessageDialog(null, temp);
    }
    public void frasePronostico(){
        String frase=doc.select("div.today_nowcard-phrase").text();
        JOptionPane.showMessageDialog(null, frase);
    }
}
