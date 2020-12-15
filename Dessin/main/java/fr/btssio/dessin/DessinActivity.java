package fr.btssio.dessin;

import fr.btssio.dessin.figures.Figure;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DessinActivity extends Activity
{
    /// représente la zone de dessin
    DessinView dessin;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dessin = new DessinView(this,null);
        setContentView(dessin);
    }


    /*** Gestion du menu d'option ***/

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dessin_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.menu_rectangle:
                dessin.setTypeFigure(Figure.Type.RECTANGLE);
                return true;
            case R.id.menu_ligne:
                dessin.setTypeFigure(Figure.Type.LIGNE);
                return true;
            case R.id.menu_cercle:
                dessin.setTypeFigure(Figure.Type.CERCLE);
                return true;

            case R.id.menu_undo:
                dessin.undo();
                return true;
            case R.id.menu_palette:
                ColorPickerDialog.OnColorChangedListener listener = new ColorPickerDialog.OnColorChangedListener() {
                    @Override
                    public void onColorChanged(int color) {
                        dessin.setColor(color);
                    }
                };
                ColorPickerDialog dialog = new ColorPickerDialog(listener,dessin.getColor());
                dialog.show(getFragmentManager(),"tag");
                return true;
            case R.id.menu_swap:
                dessin.swap();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
