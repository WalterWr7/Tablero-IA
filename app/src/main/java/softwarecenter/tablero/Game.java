package softwarecenter.tablero;

import android.app.Activity;
import android.os.Bundle;

public class Game extends Activity {
    private Generico gen = Generico.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gen.game = this;
        setContentView(R.layout.l_game);
    }


}
