package com.example.fonts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtHello;
    private Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHello = findViewById(R.id.txtHello);
        btnChange = findViewById(R.id.btnChangeFont);

        Typeface typeface = ResourcesCompat.getFont(this,R.font.mochiypopponeregular);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHello.setTypeface(typeface);
            }
        });
    }
}