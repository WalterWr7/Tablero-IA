package softwarecenter.tablero;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public class Tablero {
    private Cuadrado T[][];
    private ViewTablero view;
    private int rad, bH, bV;
    private int turno = 1;

    public boolean ready=false;

    private Point selectC[] = new Point[2];

    private Generico gen = Generico.getInstance();


    public Tablero(ViewTablero view){
        T = new Cuadrado[7][9];
        this.view = view;

        //calcular el radio
        rad = gen.width / 20;
        bH=2*rad;
        bV=2*rad;
    }

    public void crearTablero(){
        gen.inicializarFichas(2*rad-4);
        for(int i=0; i<7; i++){
            for(int j=0; j<9; j++){
                T[i][j] = new Cuadrado(new Point(bH+rad*j*2,bV+rad*i*2), rad);
            }
        }
        //estado inicial
        //Equipo A:
        T[0][0].setValue(2);T[0][1].setValue(1);
        T[1][0].setValue(2);T[1][1].setValue(1);
        T[2][0].setValue(2);T[2][1].setValue(1);
        T[3][0].setValue(3);T[3][1].setValue(1);
        T[4][0].setValue(2);T[4][1].setValue(1);
        T[5][0].setValue(2);T[5][1].setValue(1);
        T[6][0].setValue(2);T[6][1].setValue(1);

        //Equipo B:
        T[0][7].setValue(-1);T[0][8].setValue(-2);
        T[1][7].setValue(-1);T[1][8].setValue(-2);
        T[2][7].setValue(-1);T[2][8].setValue(-2);
        T[3][7].setValue(-1);T[3][8].setValue(-3);
        T[4][7].setValue(-1);T[4][8].setValue(-2);
        T[5][7].setValue(-1);T[5][8].setValue(-2);
        T[6][7].setValue(-1);T[6][8].setValue(-2);
        ready = true;
    }

    public void pintarTablero(Canvas canvas){
        for(int i=0; i<7; i++){
            for(int j=0; j<9; j++){
                T[i][j].render(canvas);
            }
        }
        for(int i=0; i<7; i++){
            for(int j=0; j<9; j++){
                T[i][j].renderImage(canvas);
            }
        }
    }

    public Point buscarCuadrado(int x, int y){
        for(int i=0; i<7; i++){
            for(int j=0; j<9; j++){
                if(T[i][j].getIn(x,y)){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }
    public void verificarJugada(int x, int y){
        if(gen.modoJuego!=1 || turno!=-1){
            Point aux = buscarCuadrado(x,y);
            if(aux != null){
                if(T[aux.x][aux.y].value*turno>0){
                    //solo selecciona los espacios donde esta su ficha
                    if(selectC[0]!=null)
                        T[selectC[0].x][selectC[0].y].deseleccionar();
                    T[aux.x][aux.y].seleccionar();
                    selectC[0] = aux;
                    view.invalidate();
                }
                if(T[aux.x][aux.y].value*turno<=0 && selectC[0]!=null){
                    //solo selecciona espacios vacios
                    selectC[1] = aux;
                    procesarJugada();
                }
            }
        }
    }
    private void procesarJugada(){
        Log.i("Jugada INI", selectC[0].x + ", " + selectC[0].y);
        Log.i("Jugada FI", selectC[1].x + ", " + selectC[1].y);
    }
}
