package com.example.parseinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {


private static final String TAG = "LoginActivity";
private EditText signupUserName;
private EditText signupPassword;
private EditText signupEmail;
private EditText signupPhoneNum;
private Button signupButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupUserName = findViewById(R.id.signupUserName);
        signupPassword = findViewById(R.id.signupPassword);
        signupEmail = findViewById(R.id.signupEmail);
        signupPhoneNum = findViewById(R.id.signupPhoneNum);
        signupButton = findViewById(R.id.signupButton);


    signupButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

    String username = signupUserName.getText().toString();
    String password = signupPassword.getText().toString();
    String email = signupEmail.getText().toString();
    String phoneNum = signupPhoneNum.getText().toString();

    // Create the ParseUser
    ParseUser user = new ParseUser();
    // Set core properties
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    // Set custom properties
    user.put("phone", phoneNum);
    // Invoke signUpInBackground
    user.signUpInBackground(new SignUpCallback() {
        public void done(ParseException e) {
            if (e == null) {
                // Hooray! Let them use the app now.
                Log.d(TAG, "Navigating back to login");
                Toast.makeText(SignupActivity.this, "New user added!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Log.e(TAG, "Issue with sign up");
                e.printStackTrace();
                // Sign up didn't succeed. Look at the ParseException
                // to figure out what went wrong
            }
        }
    });
}
});
}
}
