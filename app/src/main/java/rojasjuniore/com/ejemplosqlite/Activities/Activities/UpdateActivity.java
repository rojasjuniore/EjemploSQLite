package rojasjuniore.com.ejemplosqlite.Activities.Activities;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rojasjuniore.com.ejemplosqlite.Activities.Data;
import rojasjuniore.com.ejemplosqlite.Activities.POJOS.Usuario;
import rojasjuniore.com.ejemplosqlite.Activities.SQLConstants;
import rojasjuniore.com.ejemplosqlite.R;

public class UpdateActivity extends AppCompatActivity {

    Data data;
    Usuario usuario;
    EditText idupdate, nombre, edad, correo;
    Button search_update, btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        usuario = new Usuario();
        idupdate = (EditText) findViewById(R.id.idupdate);
        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);

        data = new Data(getApplicationContext());
        data.open();

        search_update = (Button) findViewById(R.id.search_update);
        search_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idSearch = idupdate.getText().toString();
                usuario = data.getUsuario(idSearch);
                nombre.setText(usuario.getNombre());
                edad.setText(String.valueOf(usuario.getEdad()));
                correo.setText(usuario.getCorreo());

            }
        });

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idSearch = idupdate.getText().toString();
                ContentValues contentValues = new ContentValues(4);

                contentValues.put(SQLConstants.COLUMN_NOMBRE, nombre.getText().toString());
                contentValues.put(SQLConstants.COLUMN_EDAD, Integer.valueOf(edad.getText().toString()));
                contentValues.put(SQLConstants.COLUMN_CORREO, correo.getText().toString());

                data.updateUser(idSearch, contentValues);
                Toast.makeText(getApplicationContext(), "Se actuzalixo el usuario", Toast.LENGTH_SHORT).show();
                data.close();
            }
        });

    }
}
