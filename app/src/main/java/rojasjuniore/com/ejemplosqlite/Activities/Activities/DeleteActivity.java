package rojasjuniore.com.ejemplosqlite.Activities.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rojasjuniore.com.ejemplosqlite.Activities.Data;
import rojasjuniore.com.ejemplosqlite.R;

public class DeleteActivity extends AppCompatActivity {

    EditText delete_idit;
    Button id_delete;
    Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete_idit = (EditText) findViewById(R.id.delete_idit);

        id_delete = (Button) findViewById(R.id.id_delete);
        id_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delete = delete_idit.getText().toString();
                data = new Data(getApplication());
                data.deleteUser(delete);
                Toast.makeText(getApplicationContext(), "Eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
