package com.example.user.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent passedIntent = getIntent(); //get intent from MainActivity
        Bundle myBundle = passedIntent.getExtras(); //create Bundle to get values

        String passedName = myBundle.getString("name"); //get the user's name by Bundle
        String passedGender = myBundle.getString("gender"); //get user's gender by Bundle
        String passedChecked = myBundle.getString("callBack"); //get user's callback by Bundle

        button = (Button)findViewById(R.id.backBtn);
        TextView name = (TextView)findViewById(R.id.nameTextView);
        TextView gender = (TextView)findViewById(R.id.genderTextView);
        TextView callBack = (TextView)findViewById(R.id.callBackTextView);

        name.setText(": " + passedName); //print the name on the screen
        gender.setText(": " + passedGender); //print the gender on the screen
        callBack.setText(": " + passedChecked); //print the method on the screen

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //press button, and go back to main
                Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
