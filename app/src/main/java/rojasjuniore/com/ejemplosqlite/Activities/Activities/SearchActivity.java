package rojasjuniore.com.ejemplosqlite.Activities.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rojasjuniore.com.ejemplosqlite.Activities.Data;
import rojasjuniore.com.ejemplosqlite.Activities.POJOS.Usuario;
import rojasjuniore.com.ejemplosqlite.R;

public class SearchActivity extends AppCompatActivity {

    EditText idsearch;
    Button search;
    Data data;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        usuario = new Usuario();
        idsearch = (EditText) findViewById(R.id.idsearch);

        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idSearch = idsearch.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                usuario = data.getUsuario(idSearch);
                Log.e("DATARESULTADO", usuario.getNombre());
                data.close();
            }
        });

    }
}
