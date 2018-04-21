package com.example.user.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    RadioGroup radGroupGender;
    RadioButton radMan;
    RadioButton radWoman;
    CheckBox chkSms;
    CheckBox chkEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.regBtn);
        editText = (EditText)findViewById(R.id.editName);
        radGroupGender = (RadioGroup)findViewById(R.id.radGroupGender);
        radMan = (RadioButton)findViewById(R.id.radMan);
        radWoman = (RadioButton)findViewById(R.id.radWoman);
        chkSms = (CheckBox)findViewById(R.id.chkSms);
        chkEmail = (CheckBox)findViewById(R.id.chkEmail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                Bundle myBundle = new Bundle(); //create Bundle to put values in it
                /* name_value1 */
                String name = editText.getText().toString();
                myBundle.putString("name", name);

                /* radio button_value2 */
                int radioId = radGroupGender.getCheckedRadioButtonId();
                String msg = "";
                if(radMan.getId() == radioId)
                    msg  = "남";
                if(radWoman.getId() == radioId)
                    msg = "여";
                myBundle.putString("gender", msg);

                /* check box_value3 */
                String chkMsg = "";
                if(chkSms.isChecked())
                    chkMsg = "SMS";
                if(chkEmail.isChecked())
                    chkMsg = "e-mail";
                myBundle.putString("callBack", chkMsg);

                intent.putExtras(myBundle); //send the values by intent
                startActivity(intent);
            }
        });
    }
}
