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

public class encryptDiffieHellman extends AppCompatActivity {

    ClipboardManager cpb;
    EditText privateKey;
    TextView publicKey;
    Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_diffie_hellman);

        privateKey = findViewById(R.id.pvt_key);
        publicKey = findViewById(R.id.pub_key);
        generate = findViewById(R.id.generate_public_key);
        cpb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void Generate(View view) {
        String pvtKey = privateKey.getText().toString();
        int x = Integer.parseInt(pvtKey);
        int y = diffieHellmanEncrypt.generatePublicKey(x);
        if(y == -1) {
            Toast.makeText(this,"enter value less than q", Toast.LENGTH_LONG).show();
        }
        else {
            String pubKey = Integer.toString(y);
            publicKey.setText(pubKey);
        }
    }

    public void clearField(View view) {
        privateKey.setText("");
        publicKey.setText("");
    }

    public void copyNumber(View view){
        String data = publicKey.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("number",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this,"copied", Toast.LENGTH_LONG).show();
        }
    }
}