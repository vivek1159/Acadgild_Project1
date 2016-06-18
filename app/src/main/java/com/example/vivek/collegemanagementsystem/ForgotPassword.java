package com.example.vivek.collegemanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Session;

public class ForgotPassword extends AppCompatActivity {

    EditText email, mobileNumber;

    LoginDB loginDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginDB = new LoginDB(getApplicationContext());
        email = (EditText) findViewById(R.id.ForgotPassword_EmailAddress);
        mobileNumber = (EditText) findViewById(R.id.ForgotPassword_MobileNumber);
    }

    public void onClickProceed(View v) {

        final String Email = email.getText().toString();
        String MobileNumber = mobileNumber.getText().toString();

        if (loginDB.checkIfUserExists(Email,MobileNumber)) {
            final GMailSender autoMail = new GMailSender();

            final String Subject = "Reset Password";
            final String Body = "This is an auto-generated email. Your new password is AXCFRTQW. Please change it immediately after login.";

            Boolean success = false;

            try {
                success = autoMail.sendMail(Subject, Body, "vivek1159@gmail.com", Email);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (success) {
                Toast.makeText(ForgotPassword.this, "Email sent successfully!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ForgotPassword.this, "Some Problem occured!!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(ForgotPassword.this, "Email ID/Mobile Number not valid", Toast.LENGTH_SHORT).show();
        }
    }
}
