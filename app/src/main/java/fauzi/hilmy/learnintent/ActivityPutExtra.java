package fauzi.hilmy.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityPutExtra extends AppCompatActivity {

    EditText etNama;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_extra);

        etNama = (EditText)findViewById(R.id.etInputNama);
        btnSubmit = (Button)findViewById(R.id.btnSubmitNama);

        //aksi ketika button submit diklik
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nNama = etNama.getText().toString();

                //intent ke kelas getExtra
                Intent nP = new Intent(getApplicationContext(), ActivityGetExtra.class);
                nP.putExtra("nama", nNama);
                startActivity(nP);
            }
        });
    }
}
