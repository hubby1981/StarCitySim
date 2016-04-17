package games.biitworx.starcitysim;

import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Colors.shaderBack = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        Colors.backPainterContentShader.setStyle(Paint.Style.FILL);
        Colors.backPainterContentShader.setShader(Colors.shaderBack);
        setContentView(R.layout.activity_game);

    }


}
