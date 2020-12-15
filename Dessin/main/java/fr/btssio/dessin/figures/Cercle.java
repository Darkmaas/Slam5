package fr.btssio.dessin.figures;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Cercle extends Figure {
    /**
     * crée une ligne de la couleur indiquée
     * @param color couleur de la ligne
     */
    public Cercle(int color)
    {
        // initialisation
        super();

        // création de la peinture (décommenter pour des effets différents)
        paint = new Paint();
        paint.setColor(color);

        // qualité du dessin (tramage et/ou antialiasing)
        //paint.setDither(true);
        //paint.setAntiAlias(true);

        // pour définir la largeur des lignes
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        paint.setStrokeWidth(8);
    }
    @Override
    public void draw(Canvas canvas) {
        if (incomplet()) return;
        canvas.drawCircle(x1,y1, (float) Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)), paint);
    }
}
