package com.example.fitnessmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText,passwordEdiText;
    Button loginBtn;
    ProgressBar progressBar;
    TextView createAccountBtnTextView;
    TextView ForgetPasswordBtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEdiText = findViewById(R.id.password_edit_text);
        loginBtn = findViewById(R.id.Login_btn);
        progressBar = findViewById(R.id.progress_bar);
        createAccountBtnTextView = findViewById(R.id.create_account_text_view_btn);
        ForgetPasswordBtnTextView=findViewById(R.id.forget_btn);

        loginBtn.setOnClickListener((v)->loginUser());
        ForgetPasswordBtnTextView.setOnClickListener((v)->startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class)));
        createAccountBtnTextView.setOnClickListener((v)->startActivity(new Intent(LoginActivity.this,CreateAccountActivity.class)));

    }
    void loginUser(){
        String email = emailEditText.getText().toString();
        String password = passwordEdiText.getText().toString();


        boolean isValidated = validateData(email,password);
        if (!isValidated){
            return;
        }

        loginAccountInFirebase(email,password);


    }

    void loginAccountInFirebase(String email,String password){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        changeInProgress(true);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if (task.isSuccessful()){
                    //login is success
                    if (firebaseAuth.getCurrentUser().isEmailVerified()){
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();

                    }else {
                        Toast.makeText(LoginActivity.this, "Email not verified please verify your email",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    //login failed
                    Toast.makeText(LoginActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            loginBtn.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            loginBtn.setVisibility(View.VISIBLE);

        }
    }

    boolean validateData(String email,String password){

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Email is invalid");
            return false;
        }
        if (password.length()<6){
            passwordEdiText.setError("password length is invalid");
            return false;
        }

        return true;
    }


}