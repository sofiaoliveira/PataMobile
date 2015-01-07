package inters.patamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import inters.patamobile.model.Paciente;


public class GestaoPacienteActivity extends Activity {

    private Paciente paciente;
    private TextView txtNomePaciente;
    private Button btnDadosPaciente;
    public static String DADOS_PACIENTE = "dados paciente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_paciente);
        paciente = (Paciente) getIntent().getSerializableExtra(ListaPacientesActivity.EXTRA_PACIENTE);
        txtNomePaciente = (TextView) findViewById(R.id.txtVisualizarNomePaciente);
        btnDadosPaciente = (Button) findViewById(R.id.btnDadosPaciente);
        txtNomePaciente.setText(paciente.getNome());

        btnDadosPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestaoPacienteActivity.this, CriarPacienteActivity.class);
                intent.putExtra(DADOS_PACIENTE, paciente);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gestao_paciente, menu);
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
}
