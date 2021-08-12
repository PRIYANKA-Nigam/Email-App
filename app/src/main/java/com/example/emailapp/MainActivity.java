package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button2);
        e1=(EditText) findViewById(R.id.editTextTextEmailAddress);
        e2=(EditText) findViewById(R.id.editTextTextPersonName3);
        e3=(EditText) findViewById(R.id.editTextTextPersonName4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Message Ready to send",Toast.LENGTH_SHORT).show();
                sendMail();
            }
        });
    }
    private void sendMail(){
        String recipientList=e1.getText().toString();
        String[] recipients=recipientList.split(",");
        String subject=e2.getText().toString();
        String mssg=e3.getText().toString();
        Intent i=new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,recipients);
        i.putExtra(Intent.EXTRA_SUBJECT,subject);
        i.putExtra(Intent.EXTRA_TEXT,mssg);
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"choose an email client"));
    }
}