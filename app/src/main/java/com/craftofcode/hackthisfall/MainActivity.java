package com.craftofcode.hackthisfall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sawolabs.androidsdk.Sawo;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //commit to test rebase workflow.
        Button userLoginBtn, adminLoginBtn;
        userLoginBtn = findViewById(R.id.userLoginBtn);
        adminLoginBtn = findViewById(R.id.adminLoginBtn);

        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAdminLogin(v);
            }
        });

        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickUserLogin(v);
            }
        });

    }
    
    public void onClickUserLogin(View view) {
        new Sawo(
                this,
                "164d97c7-ef69-4669-a8ac-837cf6ea6c49", // your api key
                "6172701a8140a809bb7cf69aY2dmio6XcV7AihczeWUiQ22R"  // your api key secret
        ).login(
                "email", // can be one of 'email' or 'phone_number_sms'
                MainActivity2.class.getName()  // Callback class name
        );
    }
    public void onClickAdminLogin(View view) {
        new Sawo(
                this,
                "1891eb08-5447-4cdf-8ec5-6b47f8436902", // your api key
                "61731b32d487f77429787642sBdwKIxKk8pMNjfp4qtW2Wfq"  // your api key secret
        ).login(
                "email", // can be one of 'email' or 'phone_number_sms'
                MainActivity2.class.getName()  // Callback class name
        );
    }
}