package fr.btssio.dessin;

import java.util.LinkedList;

import fr.btssio.dessin.figures.Figure;
import fr.btssio.dessin.figures.Rectangle;
import android.app.Application;
import android.graphics.Color;

public class DessinApplication extends Application
{
    /**
     * contient la liste des figures, voir DessinView.java
     */
    private LinkedList<Figure> figures;

    public DessinApplication()
    {
        // première et dernière affectation de la variable
        figures = new LinkedList<>();


        // TODO supprimer toutes ces lignes qui initialisent le dessin
//        for (int i=0; i<10; i++) {
//            int color = Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
//            Figure rect = new Rectangle(color);
//            figures.add(rect);
//            rect.setReference((float)Math.random()*600+50, (float)Math.random()*600+50);
//            rect.setCoin((float)Math.random()*600+50, (float)Math.random()*600+50);
//        }
    }

    /**
     * retourne la liste de l'application
     * @return liste des figures
     */
    public LinkedList<Figure> getFigures()
    {
        return figures;
    }
}
