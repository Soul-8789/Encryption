package com.example.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class decryptDiffieHellman extends AppCompatActivity {

    ClipboardManager cpb;
    EditText privateKey;
    TextView publicKey, secret_num;
    Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_diffie_hellman);
        secret_num = findViewById(R.id.secret_number);
        privateKey = findViewById(R.id.pvt_key_d);
        publicKey = findViewById(R.id.pub_key_d);
        generate = findViewById(R.id.generate_secret_number);
        cpb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void generate(View view) {
        String pvtKey = privateKey.getText().toString();
        int x = Integer.parseInt(pvtKey);
        String pubKey = publicKey.getText().toString();
        int y = Integer.parseInt(pubKey);
        int sec = diffieHellmanDecrypt.generateSecretNumber(x, y);
//        if(y == -1) {
//            Toast.makeText(this,"enter value less than q", Toast.LENGTH_LONG).show();
//        }
//        else {
//                    Toast.makeText(this,"Generated", Toast.LENGTH_LONG).show();
            String sec_num = Integer.toString(sec);
            secret_num.setText(sec_num);
//        }
    }

    public void clearField(View view) {
        privateKey.setText("");
        publicKey.setText("");
        secret_num.setText("");
    }
}