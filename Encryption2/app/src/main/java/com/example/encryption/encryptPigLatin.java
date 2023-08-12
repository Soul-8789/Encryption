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

import java.sql.Timestamp;


public class encryptPigLatin extends AppCompatActivity {

    TextView output;
    ClipboardManager cpb;
    EditText input;
    Button encrypt;
    TextView tim_enc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_pig_latin);
        input = findViewById(R.id.input_field);
        output = findViewById(R.id.output_field);
        encrypt = findViewById(R.id.encrypt_button);
        tim_enc = findViewById(R.id.tim_enc);
        cpb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void encodePigLatin(View view){
        String message = input.getText().toString();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String encrypt_message = pigLatinEncrypt.encode(message);

        output.setText(encrypt_message);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());

        int totalTimeTaken = (int) (timestamp2.getTime() - timestamp.getTime());
        String ttt = Integer.toString(totalTimeTaken);
        tim_enc.setText(ttt + " ms");
    }

    public void clearField(View view) {
        input.setText("");
        output.setText("");
    }

    public void copyMessage1(View view){
        String data = output.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this,"copied", Toast.LENGTH_LONG).show();
        }
    }
}