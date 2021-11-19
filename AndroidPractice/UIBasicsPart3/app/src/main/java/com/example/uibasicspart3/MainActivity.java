package com.example.uibasicspart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox harry,matrix,joker;
    private RadioGroup MaritalStatus;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        harry = findViewById(R.id.checkboxharry);
        matrix=findViewById(R.id.checkboxthematrix);
        joker=findViewById(R.id.checkboxjoker);
        MaritalStatus=findViewById(R.id.rMaritalStatus);
        progressBar=findViewById(R.id.progressbar);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();
        int Checkedbutton=MaritalStatus.getCheckedRadioButtonId();
        switch (Checkedbutton){
            case R.id.rMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rInRel:
                Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        MaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rInRel:
                        Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        if (harry.isChecked()){
            Toast.makeText(MainActivity.this, "You have watched this movie", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "You Need to watch Harry potter", Toast.LENGTH_SHORT).show();
        }
        harry.setOnCheckedChangeListener(this::onCheckedChanged);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkboxharry:
                if (isChecked){
                    Toast.makeText(MainActivity.this, "You have watched this movie", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "You Need to watch Harry potter", Toast.LENGTH_SHORT).show();
                }
        }
    }
}