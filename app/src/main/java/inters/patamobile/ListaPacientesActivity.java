package inters.patamobile;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import inters.patamobile.model.Paciente;


public class ListaPacientesActivity extends Activity {

    private ListView listViewPacientes;
    private ArrayAdapter<Paciente> arrayAdapterPaciente;
    public static String EXTRA_PACIENTE = "Paciente extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);
        listViewPacientes = (ListView) findViewById(R.id.listPacientes);
        mostrarPacientes();

        listViewPacientes.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Paciente paciente = arrayAdapterPaciente.getItem(position);
                Intent intent = new Intent(ListaPacientesActivity.this, GestaoPacienteActivity.class);
                intent.putExtra(EXTRA_PACIENTE, paciente);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_pacientes, menu);
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

    private void mostrarPacientes(){
        RequestQueue requestQueue = PATAMobile.getRequestQueue(this);
        String url = PATAMobile.ENDPOINT + "/pacientes?token="+ PATAMobile.token;

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                Paciente[] pacientes = gson.fromJson(s, Paciente[].class);
                ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>(Arrays.asList(pacientes));
                arrayAdapterPaciente = new ArrayAdapter<Paciente>(ListaPacientesActivity.this , android.R.layout.simple_list_item_1, listaPacientes);
                listViewPacientes.setAdapter(arrayAdapterPaciente);
                Toast.makeText(ListaPacientesActivity.this, "Pedido feito com sucesso", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(ListaPacientesActivity.this, "Erro no pedido: "+ volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);

    }
}
