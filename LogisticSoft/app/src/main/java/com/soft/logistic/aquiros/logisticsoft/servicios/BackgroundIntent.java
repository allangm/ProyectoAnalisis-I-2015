package com.soft.logistic.aquiros.logisticsoft.servicios;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.soft.logistic.aquiros.logisticsoft.objetos.*;

import javax.crypto.ShortBufferException;


public class BackgroundIntent extends IntentService {

    public static final int STATUS_FINISHED = 1;
    public static final int STATUS_ERROR = 2;

    private static final String TAG = "BackgroundIntent";

    public BackgroundIntent() {
        super(BackgroundIntent.class.getName());
    }



    @Override
    protected void onHandleIntent(Intent intent) {


        Log.d(TAG, "Service Started!");

        final ResultReceiver receiver = intent.getParcelableExtra("receiver");

        Bundle bundle = new Bundle();

        /* Service Started */
        //receiver.send(STATUS_RUNNING, Bundle.EMPTY);
        try {
            Repositorio.cargarDatos();
            //aqui se llaman los metodos a iniciar en servvicio
            OrdenadorPedidos.llenarCamiones();
            double volumenTotal=OrdenadorPedidos.volTotalPedidos();
            //imprimirMatriz(pedidos);
            //imprimirMatriz(camiones);
            OrdenadorPedidos.entregarPedidos(Repositorio.pedidos);
            //ArrayList<ArrayList> resultado = OrdenadorPedidos.ordenarMatriz(Repositorio.pedidos, 4);
            Log.d(TAG, "Termina la ejecucion!");
        }
        catch (Error err)
        {
            bundle.putString(Intent.EXTRA_TEXT, err.getMessage());
            receiver.send(STATUS_ERROR, bundle);
        }

        /* Status Finished */
        receiver.send(STATUS_FINISHED, bundle.EMPTY);
        Log.d(TAG, "Service Stopping!");
        this.stopSelf();
    }
}
