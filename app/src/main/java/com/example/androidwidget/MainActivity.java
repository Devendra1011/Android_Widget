package com.example.androidwidget;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
    }
}