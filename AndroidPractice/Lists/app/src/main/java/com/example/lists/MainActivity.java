package com.example.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView citiesList;
    private Spinner studentSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citiesList = findViewById(R.id.citiesList);
        studentSpinner = findViewById(R.id.studentsSpinner);

        ArrayList<String> students = new ArrayList<>();
        students.add("Sushain");
        students.add("Lovely Singh");
        students.add("Ross");
        students.add("Naveen");
        students.add("Madeline");
        students.add("Tom");

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Kolkata");
        cities.add("Chennai");
        cities.add("Mumbai");
        cities.add("New York");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities
        );
        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                students
        );

        citiesList.setAdapter(citiesAdapter);
        studentSpinner.setAdapter(studentAdapter);

        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, students.get(position)+" Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, cities.get(position)+" Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}