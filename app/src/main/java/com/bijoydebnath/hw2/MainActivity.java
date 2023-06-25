package com.bijoydebnath.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Animal> animalArrayList;
    Spinner spinner;
    Button checkButton;
    TextView displayTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalArrayList = new ArrayList<>();
        spinner = findViewById(R.id.spinner);
        checkButton = findViewById(R.id.checkButton);
        displayTV = findViewById(R.id.textView);

        animalArrayList.clear();
        animalArrayList.add(new Animal(0, "Select One"));
        animalArrayList.add(new Animal(1, "Lion"));
        animalArrayList.add(new Animal(3, "Donkey"));
        animalArrayList.add(new Animal(4, "Leopard"));
        animalArrayList.add(new Animal(5, "Rabbit"));
        animalArrayList.add(new Animal(6, "Tortoise"));

        ArrayAdapter<Animal> adapter =
                new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, animalArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        checkButton.setOnClickListener(view -> {
            Animal selectedAnimal = (Animal) spinner.getSelectedItem();
            if (selectedAnimal.getId() == 0) {
                Toast.makeText(this, "Select One Animal", Toast.LENGTH_SHORT).show();
                displayTV.setText("");
            } else {
                displayTV.setText("Selected Animal id is " + selectedAnimal.getId() + " and name is " + selectedAnimal.getName());
            }
        });

    }
}