package com.example.fuerm.gestionoficinatecnica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.fuerm.gestionoficinatecnica.Adaptadores.AdaptadorDeProyectos;
import com.example.fuerm.gestionoficinatecnica.Adaptadores.Proyecto;
import com.vijay.jsonwizard.activities.JsonFormActivity;

public class Primera extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final int    REQUEST_CODE_GET_JSON = 1;
    private static final String TAG                   = "MainActivity";
    private static final String DATA_JSON_PATH        = "plan_emergencia.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_primera);

        getSupportActionBar().setTitle("TIPOS DE PROYECTOS");

        //Usando un gridview
        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new AdaptadorDeProyectos(this));
        gridview.setOnItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_primera, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_hecho:
                Log.i("ActionBar", "hecho!");
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /*
    Manejamos que proyecto se ha pulsado.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent;

        Proyecto item = (Proyecto) parent.getItemAtPosition(position);

        switch (item.getNombre()) {
            case "Plan de emergencia":
                intent = new Intent(this, JsonFormActivity.class);
                String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH);
                intent.putExtra("json", json);
                startActivityForResult(intent, REQUEST_CODE_GET_JSON);
                break;
            default:
                intent = new Intent(this, EnConstruccion.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("json"));
            Toast.makeText(this, "!!!!!!!!!" +data.getStringExtra("json"), Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}