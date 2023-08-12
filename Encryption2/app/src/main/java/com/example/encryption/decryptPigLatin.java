package com.example.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;

public class decryptPigLatin extends AppCompatActivity {

    TextView output;
    ClipboardManager cpb;
    EditText input;
    Button decrypt;
    TextView tim_dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_pig_latin);

        input = findViewById(R.id.input_field);
        output = findViewById(R.id.output_field);
//        decrypt = findViewById(R.id.decrypt_button);
        tim_dec = findViewById(R.id.tim_dec);
        cpb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void decodePigLatin(View view){
        String message = input.getText().toString();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String encrypt_message = pigLatinDecrypt.decode(message);

        output.setText(encrypt_message);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());

        int totalTimeTaken = (int) (timestamp2.getTime() - timestamp.getTime());
        String ttt = Integer.toString(totalTimeTaken);
        tim_dec.setText(ttt + " ms");
    }

    public void clearField(View view) {
        input.setText("");
        output.setText("");
    }

    public void copyMessage4(View view){
        String data = output.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this,"copied", Toast.LENGTH_LONG).show();
        }
    }
}