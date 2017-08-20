package rojasjuniore.com.ejemplosqlite.Activities.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rojasjuniore.com.ejemplosqlite.Activities.Data;
import rojasjuniore.com.ejemplosqlite.Activities.POJOS.Usuario;
import rojasjuniore.com.ejemplosqlite.R;

public class InsertActivity extends AppCompatActivity {

    EditText id, nombre, edad, correo;
    Button insert;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        id = (EditText) findViewById(R.id.id);
        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);

        insert = (Button) findViewById(R.id.btn_add);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario(
                        id.getText().toString(),
                        nombre.getText().toString(),
                        Integer.valueOf(edad.getText().toString()),
                        correo.getText().toString()
                );

                data = new Data(getApplicationContext());
                data.open();
                data.insertUsuario(usuario);
                Toast.makeText(getApplicationContext(), "Se agrego un nuevo usuario", Toast.LENGTH_SHORT).show();
                data.close();
            }
        });

    }
}
