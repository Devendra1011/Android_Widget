package com.example.androidwidget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
CheckBox cbPizza;
RadioGroup rgPizza;
Spinner spinner;
TimePicker timePicker;
DatePicker datePicker;
Button btnDisSelDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        
        cbPizza = findViewById(R.id.cb_pizza);
        rgPizza = findViewById(R.id.rg_pizza);
        spinner = findViewById(R.id.spinner);
//        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.date_picker);
        btnDisSelDate = findViewById(R.id.btn_dis_sel_date);


        // Data Source
        String[] item = {"Pickle","Lassi","Achar","Tikka"};
        // ArrayAdapter: used to populate the spinner with items from a string resource
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);




        cbPizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "The Checked box is checked", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "The Checked box is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rgPizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton  radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "You selected"+radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

/*
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this,"Hour: "+hourOfDay+"Minute: "+minute,Toast.LENGTH_SHORT).show();
            }
        });*/


        btnDisSelDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day "+datePicker.getDayOfMonth();
                String month = "Month "+datePicker.getMonth();
                String year = "Year "+datePicker.getYear();
                Toast.makeText(MainActivity.this, day+"\n"+month+"\n"+year, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}