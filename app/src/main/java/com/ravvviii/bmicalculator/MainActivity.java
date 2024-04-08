package com.ravvviii.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edt_weight,edt_height_in_feet,edt_height_in_inch;
        Button calculate_Btn;
        TextView result,resultText;

        edt_weight = findViewById(R.id.edt_weight);
        edt_height_in_feet = findViewById(R.id.edt_height_in_feet);
        edt_height_in_inch = findViewById(R.id.edt_height_in_inch);
        calculate_Btn = findViewById(R.id.calculate_Btn);
        result = findViewById(R.id.result);
        resultText = findViewById(R.id.resultText);




        calculate_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edt_weight.getText().toString());
                int ih = Integer.parseInt(edt_height_in_inch.getText().toString());
                int ft = Integer.parseInt(edt_height_in_feet.getText().toString());

                double totalHeight = (ft*12+ih)*2.53/100;


                double bMi = wt/(totalHeight*totalHeight);


                float x = (float) bMi;

                if (bMi<18){
                    result.setText("BMI:- "+x);
                    resultText.setText("UnderWeight !");
                }
                else if(bMi>18 && bMi<25){
                    result.setText("BMI:- "+x);
                    resultText.setText("Healthy !");
                }
                else{
                    result.setText("BMI:- "+x);
                    resultText.setText("Overweight !");
                }




            }
        });







    }
}