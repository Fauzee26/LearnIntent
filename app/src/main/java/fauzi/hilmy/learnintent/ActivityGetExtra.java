package fauzi.hilmy.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityGetExtra extends AppCompatActivity {

    TextView txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_extra);

        txtNama = (TextView)findViewById(R.id.txtHalo);
        Intent a1 = getIntent();
        //mengambil data yang sudah di put sebelumnya dengan variable nama
        String ambilNama = a1.getStringExtra("nama");

        //menampilkan nilai ke text view
        txtNama.setText("Hy, " + ambilNama);
    }
}
