package com.sajithan.android.sajiivideorentingshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
//import android.support.v4.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox action,comedy,romance,horror,fantasy;
   // String[] sex = { "Male", "Female", "Not applicaple"};
    String[] ageGroup = {"10-17","18-40","41-60","60-100"};
    EditText username,dob,address,nic;
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        dob = (EditText) findViewById(R.id.dob);
        address = (EditText) findViewById(R.id.address);
        nic = (EditText) findViewById(R.id.nic);


        addListenerOnButtonClick();
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
       // Spinner spin1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ageGroup);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item1, ageGroup);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item1);
//        spin.setAdapter(adapter1);
        //spin.setOnItemSelectedListener(this);


    }


    public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        action=(CheckBox)findViewById(R.id.checkBox2);
        comedy=(CheckBox)findViewById(R.id.checkBox3);
        romance=(CheckBox)findViewById(R.id.checkBox5);
        horror=(CheckBox)findViewById(R.id.checkBox4);
        fantasy=(CheckBox)findViewById(R.id.checkBox);
        submit_button=(Button)findViewById(R.id.Submit_button);

        //Applying the Listener on the Button click
        submit_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                StringBuilder result=new StringBuilder();
                String selectedGenre = null;
                result.append("Interest Genres :");
                if(action.isChecked()){
                    result.append("\n Action");
                    selectedGenre += action;
                }
                if(comedy.isChecked()){
                    result.append("\n Comedy");
                    selectedGenre += comedy;
                }
                if(romance.isChecked()){
                    result.append("\n Romance");
                    selectedGenre += romance;
                }
                if(horror.isChecked()){
                    result.append("\n Horror");
                    selectedGenre += horror;
                }
                if(fantasy.isChecked()){
                    result.append("\n Fantasy");
                    selectedGenre += fantasy;
                }
                //result.append("\nYour intersts genres are: "+selectedGenre);
                //Displaying the message on the toast

               // Toast.makeText(getApplicationContext(), "Selected sex: "+sex[position] ,Toast.LENGTH_SHORT).show();
                if (username.getText().toString().isEmpty() || dob.getText().toString().isEmpty() || address.getText().toString().isEmpty() || nic.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter the Data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "User Name -  " + username.getText().toString() + " \n" + "Date of birth -  " + dob.getText().toString()
                            + " \n" + "Address -  " + address.getText().toString() + " \n" + "NIC number -  " + nic.getText().toString() + "\n" + result, Toast.LENGTH_LONG).show();
                   // Toast.makeText(getApplicationContext(),Toast.LENGTH_LONG).show();
                }
            }

        });



    }
}
