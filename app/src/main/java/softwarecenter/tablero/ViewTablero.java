package softwarecenter.tablero;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ViewTablero extends View{
    private Tablero T;

    public ViewTablero(Context context, AttributeSet attrs) {
        super(context, attrs);
        T = new Tablero(this);
        T.crearTablero();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Log.i("Pintando", "----");
        if(T!=null && T.ready)
            T.pintarTablero(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            T.verificarJugada((int) event.getX(), (int) event.getY());
        }
        return super.onTouchEvent(event);
    }
}
