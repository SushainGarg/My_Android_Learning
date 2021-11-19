package com.example.uiapplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText edtTxtName,edtTxEmail,edtTxtPassword,edtTxtPassRepeat;
    private Button btnPickImage,btnRegister;
    private TextView txtWarnName,txtWarnEmail,txtWarnPassword,txtWarnPassRepeat;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        
        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yet to talk About", Toast.LENGTH_SHORT).show();
            }
        });
        
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }

    private void initRegister() {
        Log.d(TAG,"initRegister: Started");

        if (validateData()){
            if (agreementCheck.isChecked()){
                showSnackBar();
            }else{
                Toast.makeText(MainActivity.this, "You need to agree to the license agreement", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar() {
        Log.d(TAG,"showSnackbar: started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);

        String name = edtTxtName.getText().toString();
        String email = edtTxEmail.getText().toString();
        String Country = countriesSpinner.getSelectedItem().toString();
        String gender = "";

        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender="Unknown";
                break;
        }

        String snackText = "Name: "+name+"\n" +
                "Email: "+email+"\n" +
                "Country: "+Country;


        Log.d(TAG,"showSnackbar: Snack Bar Text: "+snackText);

        Snackbar.make(parent,snackText,Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtTxtName.setText("");
                        edtTxtPassword.setText("");
                        edtTxEmail.setText("");
                        edtTxtPassRepeat.setText("");

                    }
                }).show();

    }

    private boolean validateData() {
        Log.d(TAG,"validateData: Started");
        if (edtTxtName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Name");
            return false;
        }
        if (edtTxEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your Email");
            return false;
        }
        if (edtTxtPassword.getText().toString().equals("")){
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Enter your Password");
            return false;
        }
        if (edtTxtPassRepeat.getText().toString().equals("")){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Re Enter your Password");
            return false;
        }
        if(!edtTxtPassword.getText().toString().equals(edtTxtPassRepeat.getText().toString())){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Password Does not match");
            return false;
        }
        return true;
    }

    private void initViews() {
        Log.d(TAG,"initViews: Started");
        edtTxtName = findViewById(R.id.edtTextName);
        edtTxEmail = findViewById(R.id.edtTextEmail);
        edtTxtPassRepeat = findViewById(R.id.edtTestPassRepeat);
        edtTxtPassword = findViewById(R.id.edtTextPassword);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPassword = findViewById(R.id.txtWarnPass);
        txtWarnPassRepeat = findViewById(R.id.txtWarnPassRepeat);

        countriesSpinner = findViewById(R.id.spinnerCountry);

        rgGender = findViewById(R.id.rgGender);

        agreementCheck = findViewById(R.id.agreementCheck);

        parent = findViewById(R.id.parent);
    }
}