package com.example.androidwidget;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button btnDisSelDate,btnProgress;
    ProgressBar progressBar;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        datePicker = findViewById(R.id.date_picker);
        btnDisSelDate = findViewById(R.id.btn_dis_sel_date);
        btnProgress = findViewById(R.id.btn_progress);
        progressBar = findViewById(R.id.progress_bar);

       btnDisSelDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Day = "Day "+datePicker.getDayOfMonth();
               String Month = "Month "+datePicker.getMonth();
               String Year = "Year "+datePicker.getYear();
               Toast.makeText(ThirdActivity.this, Day+Month+Year, Toast.LENGTH_SHORT).show();
           }
       });


       btnProgress.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               progress = progress + 10;
                progressBar.setProgress(progress);
           }
       });


    }
}