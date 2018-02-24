package will.exemploservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        it = new Intent(MainActivity.this, Servico.class);
    }

    public void start(View view){
        Log.i("Main", "start");
        it.putExtra("ativo", true);
        startService(it);
    }

    public void stop(View view){
        Log.i("Main", "stop");
        it.putExtra("ativo", false);
        stopService(it);
    }
}
