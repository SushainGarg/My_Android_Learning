package com.example.uibasicspart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtHello;
    private EditText edtTextame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btHello=findViewById(R.id.btnHello);
        btHello.setOnClickListener(this);
        edtTextame=findViewById(R.id.edtTextName);
        edtTextame.setOnClickListener(this);
        txtHello=findViewById(R.id.txtHello);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHello:
                txtHello.setText("Hello " + edtTextame.getText().toString()+" nice to meet you");
                break;
            case R.id.edtTextName:
                Toast.makeText(MainActivity.this, "Attempting to type something", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
}