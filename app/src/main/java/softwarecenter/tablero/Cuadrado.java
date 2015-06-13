package softwarecenter.tablero;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
public class Cuadrado {
    private Point centro;
    private int rad;
    private Ficha ficha;
    private Paint paint, paintB;

    private int color = Color.WHITE;
    private int colorSelect = Color.YELLOW;
    public int value;
    private Bitmap image = null;
    private Generico gen = Generico.getInstance();

    public Cuadrado(Point c, int rad){
        this.centro = c;
        this.rad = rad;
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);

        paintB = new Paint();
        paintB.setColor(Color.GREEN);
        paintB.setStyle(Paint.Style.STROKE);

    }
    public void setValue(int value){
        this.value = value;
        switch (value){
            case 1:
                image = gen.bmA[0];
                break;
            case 2:
                image = gen.bmA[1];
                break;
            case 3:
                image = gen.bmA[2];
                break;

            case -1:
                image = gen.bmB[0];
                break;
            case -2:
                image = gen.bmB[1];
                break;
            case -3:
                image = gen.bmB[2];
                break;
        }


    }
    public boolean getIn(int x, int y){
        if(x>centro.x-rad && x<centro.x+rad && y>centro.y-rad && y<centro.y+rad)
            return true;
        return false;
    }
    public void render(Canvas canvas){
        canvas.drawRect(centro.x-rad, centro.y-rad,centro.x+rad, centro.y+rad, paint);
        canvas.drawRect(centro.x-rad, centro.y-rad,centro.x+rad, centro.y+rad, paintB);
    }
    public void renderImage(Canvas canvas){
        if(image != null)
            canvas.drawBitmap(image, centro.x-rad+2, centro.y-rad+2, null);
    }

    public void seleccionar(){
        paint.setColor(colorSelect);
    }
    public void deseleccionar(){
        paint.setColor(color);
    }
}
