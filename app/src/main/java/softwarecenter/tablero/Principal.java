package softwarecenter.tablero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by MassterPCs on 04/06/2015.
 */
public class Principal extends Activity{
    private Generico gen = Generico.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_principal);
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        if(Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.HONEYCOMB_MR2){
            display.getSize(size);
            gen.width = size.x;
            gen.height = size.y;
        } else {
            gen.width = display.getWidth();
            gen.height = display.getHeight();
        }
    }

    public void iniciarJuego(View v){
        Intent ii = new Intent(Principal.this, Game.class);
        startActivity(ii);
    }
}
