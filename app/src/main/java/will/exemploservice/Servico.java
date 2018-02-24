package will.exemploservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by will on 23/02/18.
 */

public class Servico extends IntentService {

    static Worker w;
    static boolean ativo = false;

    public Servico(){
        super("Servico");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("Servico", "start");

        if(w == null){
            w  = new Worker();
        }

        if(!w.isAlive()){
            w.start();
        }else{
            w.ativo = false;
            w.interrupt();
            w = null;
        }

    }
}


class Worker extends Thread{

    public boolean ativo = true;

    @Override
    public void run() {
        while (ativo) {
            Log.i("Servico", "worker: " + getId());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}