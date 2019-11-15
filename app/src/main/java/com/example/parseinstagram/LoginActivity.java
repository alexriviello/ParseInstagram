package com.example.parseinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


// login screen for instagram
public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText usernameText;
    private EditText passwordText;
    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.userNameEntry);
        passwordText = findViewById(R.id.passwordEntry);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                login(username, password);
            }

        });

    signupButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
           goSignUpActivity();
        }
    });
}


    private void login (String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Toast.makeText(LoginActivity.this, "Your login is incorrect.", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Issue with login");
                    e.printStackTrace();
                    return;
                } else {
                    // navigate to new activity for authorized user
                    goMainActivity();
                }
            }
        });
    }

    private void goMainActivity () {
        Log.d(TAG, "Navigating to MainActivity");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void goSignUpActivity () {
        Log.d(TAG, "Navigating to SignupActivity");
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
        finish();

    }
}

