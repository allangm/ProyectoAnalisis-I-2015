package com.soft.logistic.aquiros.logisticsoft;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.soft.logistic.aquiros.logisticsoft.objetos.OrdenadorPedidos;
import com.soft.logistic.aquiros.logisticsoft.objetos.Repositorio;
import com.soft.logistic.aquiros.logisticsoft.servicios.*;

import java.util.ArrayList;


public class OrdenEntrega extends ActionBarActivity implements BackgroundResultReceiver.Receiver{

    private ListView result;
    //TextView text;
    private BackgroundResultReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden_entrega);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_orden_entrega, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {
            case BackgroundIntent.STATUS_FINISHED:
                /* Hide progress & extract result from bundle */
                setProgressBarIndeterminateVisibility(false);
                String exectime = resultData.getString("exectime");
                result = (ListView) findViewById(R.id.listView);
                //text = (TextView)findViewById(R.id.labelOrden);
                //text.setText("Inicio");
                ArrayAdapter<String> arrayAdapter;
                arrayAdapter = new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        getList(OrdenadorPedidos.ordenarMatriz(Repositorio.pedidos, 4) ));

                result.setAdapter(arrayAdapter);
                break;
            case BackgroundIntent.STATUS_ERROR:
                //text = (TextView)findViewById(R.id.labelOrden);
                //text.setText("Error");
                /* Handle the error */
                String error = resultData.getString(Intent.EXTRA_TEXT);
                break;
            default:
                //text = (TextView)findViewById(R.id.labelOrden);
                //text.setText("Termino en default");
        }
    }

    public void iniciarOrden(View v){
        mReceiver = new BackgroundResultReceiver(new Handler());
        mReceiver.setReceiver(this);
        Intent intent = new Intent(Intent.ACTION_SYNC, null, this, BackgroundIntent.class);

        intent.putExtra("receiver", mReceiver);
        intent.putExtra("requestId", 101);
        startService(intent);
    }

    private ArrayList<String> getList(ArrayList<ArrayList> lista){
        ArrayList<String> re= new ArrayList<String>();
        for (int i= 0; i<lista.size();i++){
            String s = "";
            for(int j=0; j < lista.get(i).size();j++){
                s+=(" "+lista.get(i).get(j).toString());
            }
            re.add(s);
        }
        return re;
    }

}
