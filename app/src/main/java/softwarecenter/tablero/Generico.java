package softwarecenter.tablero;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by MassterPCs on 03/06/2015.
 */
public class Generico {
    public int width, height;
    public Game game;
    //GENERAL
    public int dificultad;
    public int iniciaTurno=1;
    public int modoJuego;

    //FICHAS
    public int rcA[] = {R.drawable.polloa, R.drawable.zorroa, R.drawable.aguilaa,R.drawable.polloevolucionadoa, R.drawable.zorroevolucionadoa};
    public int rcB[] = {R.drawable.pollob, R.drawable.zorrob, R.drawable.aguilab,R.drawable.polloevolucionadob, R.drawable.zorroevolucionadob};
    public Bitmap bmA[] = new Bitmap[5];
    public Bitmap bmB[] = new Bitmap[5];

    public static Generico instance = new Generico();

    public static Generico getInstance(){
        return instance;
    }

    public void inicializarFichas(int diam){
        for(int i=0; i<5; i++){
            bmA[i] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(game.getResources(), rcA[i]), diam,diam, true);
            bmB[i] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(game.getResources(), rcB[i]), diam,diam, true);
        }
    }
}
