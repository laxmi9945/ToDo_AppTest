package com.app.todo.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.app.todo.R;
import com.app.todo.baseclass.BaseActivity;
import com.app.todo.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bridgeit on 25/3/17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    Pattern pattern,pattern2;
    Matcher matcher,matcher2;
    String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String Password_Pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{5,12}$";
    AppCompatEditText editTextEmail,editTextPassword;
    AppCompatButton loginButton;
    AppCompatImageButton fbimageButton,googleimageButton;
    AppCompatTextView createAccountTextview,forgotTextview;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    @Override
    public void initView() {
        editTextEmail=(AppCompatEditText)findViewById(R.id.email_Edittext);
        editTextPassword=(AppCompatEditText)findViewById(R.id.password_Edittext);
        createAccountTextview=(AppCompatTextView)findViewById(R.id.createAccount_Textview);
        forgotTextview=(AppCompatTextView)findViewById(R.id.forgot_textview);
        loginButton=(AppCompatButton)findViewById(R.id.login_button);
        fbimageButton=(AppCompatImageButton)findViewById(R.id.fb_button);
        googleimageButton=(AppCompatImageButton)findViewById(R.id.google_button);
        setClicklistener();
    }

    @Override
    public void setClicklistener() {
        forgotTextview.setOnClickListener(this);
        createAccountTextview.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        fbimageButton.setOnClickListener(this);
        googleimageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createAccount_Textview:

                Intent intent=new Intent(this,RegistrationActivity.class);
                startActivity(intent);
                break;

            case R.id.forgot_textview:

                Intent intent2=new Intent(this,ResetpasswordActivity.class);
                startActivity(intent2);
                break;

            case R.id.login_button:

                SharedPreferences sharedPreferences=getSharedPreferences(Constants.keys, Context.MODE_PRIVATE);
                String email=sharedPreferences.getString("email",Constants.values);
                String password=sharedPreferences.getString("password",Constants.values);
                pattern= Pattern.compile(EMAIL_PATTERN);
                matcher=pattern.matcher(editTextEmail.getText().toString());

                pattern2=Pattern.compile(Password_Pattern);
                matcher2=pattern2.matcher(editTextPassword.getText().toString());

                if(editTextEmail.getText().toString().length()==0){
                    editTextEmail.setError("Email should not empty");
                    editTextEmail.requestFocus();
                    //editTextPassword.setError("Valid pswrd");
                }
                else if(matcher.matches()){

                }
                else{
                    editTextEmail.setError("invalid Mail");
                    editTextEmail.requestFocus();
                }

                if(editTextPassword.getText().toString().length()==0){
                    editTextPassword.setError("Password should not empty");
                    editTextPassword.requestFocus();
                }
                else if(matcher2.matches()){


                }
                else{
                    editTextPassword.setError("invalid Password");
                    editTextPassword.requestFocus();
                }

                if(editTextEmail.getText().toString().equalsIgnoreCase(email) && editTextPassword.getText().toString().equals(password+"")) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(this, TodoItemsActivity.class);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter Correct Details Or Register ",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.fb_button:
                Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
                break;

            case R.id.google_button:
                Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
                break;
        }

        }

}

