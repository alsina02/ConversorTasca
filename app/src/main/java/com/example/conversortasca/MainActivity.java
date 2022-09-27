package com.example.conversortasca;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText input;
    Integer posicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.editText1);


        // On spinner, we create an spinner related to the spinner's id
        Spinner spin = (Spinner) findViewById(R.id.spinner_time_units);

        //Creating the ArrayAdapter with Char Sequence, related to the string array created on String.xml
        ArrayAdapter<CharSequence> unitats = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        unitats.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(unitats);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        //This function allows working on the recently selected item
        String valor = parent.getItemAtPosition(i).toString();
        posicio = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    public void convert(View view) {
        String value = input.getText().toString();

        Float number = Float.parseFloat(value);

        TextView secs = findViewById(R.id.resSecs);
        TextView mins = findViewById(R.id.resMins);
        TextView hrs = findViewById(R.id.resHrs);
        TextView dys = findViewById(R.id.resDys);
        TextView yrs = findViewById(R.id.resYrs);

        Float sec;
        Float min;
        Float hr;
        Float dy;
        Float yr;


        switch (posicio) {
            case 1: sec = number * 60;
                secs.setText(String.format("%.0f", sec) + " " + getResources().getString(R.string.sec));
                mins.setText(String.format("%.0f", number) + " " + getResources().getString(R.string.min));
                hr = number / 60;
                hrs.setText(String.format("%.2f", hr) + " " + getResources().getString(R.string.hr));
                dy = hr / 24;
                dys.setText(String.format("%.2f", dy) + " " + getResources().getString(R.string.dy));
                yr = dy / 365;
                yrs.setText(String.format("%.2f", yr) + " " + getResources().getString(R.string.yr));
                break;
            case 2: min = number * 60;
                sec = min * 60;
                dy = number / 24;
                yr = dy / 365;
                secs.setText(String.format("%.0f", sec) + " " + getResources().getString(R.string.sec));
                mins.setText(String.format("%.0f", min) + " " + getResources().getString(R.string.min));
                hrs.setText(String.format("%.0f", number) + " " + getResources().getString(R.string.hr));
                dys.setText(String.format("%.2f", dy) + " " + getResources().getString(R.string.dy));
                yrs.setText(String.format("%.2f", yr) + " " + getResources().getString(R.string.yr));
                break;
            case 3: hr = number * 24;
                min = hr * 60;
                sec = min * 60;
                yr = number / 365;
                secs.setText(String.format("%.0f", sec) + " " + getResources().getString(R.string.sec));
                mins.setText(String.format("%.0f", min) + " " + getResources().getString(R.string.min));
                hrs.setText(String.format("%.0f", hr) + " " + getResources().getString(R.string.hr));
                dys.setText(String.format("%.0f", number) + " " + getResources().getString(R.string.dy));
                yrs.setText(String.format("%.2f", yr) + " " + getResources().getString(R.string.yr));
                break;
            case 4: dy = number * 365;
                hr = dy * 24;
                min = hr * 60;
                sec = min * 60;
                secs.setText(String.format("%.0f", sec) + " " + getResources().getString(R.string.sec));
                mins.setText(String.format("%.0f", min) + " " + getResources().getString(R.string.min));
                hrs.setText(String.format("%.0f", hr) + " " + getResources().getString(R.string.hr));
                dys.setText(String.format("%.0f", dy) + " " + getResources().getString(R.string.dy));
                yrs.setText(String.format("%.0f", number) + " " + getResources().getString(R.string.yr));
                break;
            default: secs.setText(String.format("%.0f", number) + " " + getResources().getString(R.string.sec));
                min = number / 60;
                mins.setText(String.format("%.2f", min) + " " + getResources().getString(R.string.min));
                hr = min / 60;
                hrs.setText(String.format("%.2f", hr) + " " + getResources().getString(R.string.hr));
                dy = hr / 24;
                dys.setText(String.format("%.2f", dy) + " " + getResources().getString(R.string.dy));
                yr = dy / 365;
                yrs.setText(String.format("%.2f", yr) + " " + getResources().getString(R.string.yr));
                break;
        }
    }
}