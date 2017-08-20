package com.example.user.class13noataskmanager;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.class13noataskmanager.data.DBUtils;
import com.example.user.class13noataskmanager.data.MyUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etRePassword, etPhone, etName;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etRePassword = (EditText)findViewById(R.id.etRePassword);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etName = (EditText)findViewById(R.id.etName);
        btnSave = (Button) findViewById(R.id.btnSave);

        eventHandler();
    }

    private void eventHandler() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataHandler();
            }
        });
    }

    private void saveDataHandler() {
        final String stEmail = etEmail.getText().toString();
        String stPassword = etPassword.getText().toString();
        String stRePassword = etRePassword.getText().toString();
        final String stPhone = etPhone.getText().toString();
        final String stName = etName.getText().toString();

        boolean isOk = true;

        if (stEmail.length() < 6 || stEmail.indexOf('@') < 1)//can add more tests
        {
            etEmail.setError("Wrong Email!");
            isOk = false;
        }
        if (stName.length() < 1)
        {
            etName.setError("Name can't be empty");
            isOk = false;
        }
        //// TODO: 14/08/2017 complete checks

        if (isOk)
        {
            //the last parameter
            final ProgressDialog progressDialog = ProgressDialog.show(this, "Please wait...", "Signing up", true,true);

            DBUtils.auth.createUserWithEmailAndPassword(stEmail, stPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        //// TODO: 14/08/2017 add new user to MyUsers database

                        MyUser u = new MyUser();
                        u.setName(stName);
                        u.setuKey_email(stEmail);
                        u.setPhone(stPhone);

                        DBUtils.myUserRef.child(u.getuKey_email()).setValue(u).addOnCompleteListener(
                                new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressDialog.dismiss();
                                        if (task.isSuccessful())
                                        {
                                            finish();//close sign up activity, sign in activity will be displayed
                                        }
                                        else
                                        {
                                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this,
                                task.getException().getMessage(), //the error message
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else
        {

        }
    }
}
