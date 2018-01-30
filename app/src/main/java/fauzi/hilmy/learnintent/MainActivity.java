package fauzi.hilmy.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnImplicit, btnExplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicit = (Button)findViewById(R.id.btnImplicit);
        btnExplicit = (Button)findViewById(R.id.btnExplicit);

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a1 = new Intent(getApplicationContext(), ActivityImplicitIntent.class);
                startActivity(a1);
            }
        });

        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q2 = new Intent(getApplicationContext(), ActivityPutExtra.class);
                startActivity(q2);
            }
        });
    }
}
