package fauzi.hilmy.learnintent;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityImplicitIntent extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    String noTelp = "081364311928";

    //tambahkan permission
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        btn1 = (Button)findViewById(R.id.btnPhone);
        btn2 = (Button)findViewById(R.id.btnEmail);
        btn3 = (Button)findViewById(R.id.btnSms);
        btn4 = (Button)findViewById(R.id.btnUrl);

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                //aksi ketika btnPhone diklik
                //intent implicit ke no telp
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + noTelp));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        //aksi sms
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataIsiSMS = "Hallo, Ini adalah sms";
                //android permission 6.0
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                        Log.d("permission","permission denied to SEND_SMS - requesting it");
                        String[] permissions = {Manifest.permission.SEND_SMS};

                        requestPermissions(permissions, PERMISSION_REQUEST_CODE);
                    }
                }
                Intent intent = new Intent(getApplicationContext(), ActivityImplicitIntent.class);
                //tentang pendingIntent
                //https://developer.android.com/reference/android/app/PendingIntent.html
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                //memanggil library SMSManager dan memanggil string dataIsiSMS
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(noTelp, null, dataIsiSMS, pi, null);

                Toast.makeText(getApplicationContext(), "SMS Berhasil dikirim", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //string untuk pengiriman email
                String emailTujuan = "hilmy2602@gmail.com";
                String subjectEmail = "Haloooo";
                String isiEmail = "Ini isi Email nya yaa";

                //intent Email
                Intent nEmail = new Intent(Intent.ACTION_SEND);
                nEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTujuan});
                nEmail.putExtra(Intent.EXTRA_SUBJECT, subjectEmail);
                nEmail.putExtra(Intent.EXTRA_TEXT, isiEmail);

                //format kode untuk pengiriman Email
                nEmail.setType("message/rfc822");
                startActivity(Intent.createChooser(nEmail, "Pilih Email Client"));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "https://github.com/Fauzee26";
                //memanggil urlWeb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });
    }
}
