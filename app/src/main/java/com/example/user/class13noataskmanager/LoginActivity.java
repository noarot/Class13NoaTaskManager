package com.example.user.class13noataskmanager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.class13noataskmanager.data.DBUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    private EditText etEmail, etPassword;
    private Button btnSignin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignin = (Button) findViewById(R.id.btnSignIn);
        btnSignup = (Button) findViewById(R.id.btnSignUp);

        if (DBUtils.auth.getCurrentUser() != null)
        {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
            finish();
        }

        eventHandler();

    }

    private void eventHandler() {
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInDataHandler();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    private void signInDataHandler() {
        //// TODO: 14/08/2017 handle sign in by firebase
        String stEmail = etEmail.getText().toString();
        String stPassword = etPassword.getText().toString();
        boolean isOk = true;
        if (stEmail.length() < 6 || stEmail.indexOf('@') < 1)//can add more tests
        {
            etEmail.setError("Wrong Email!");
            isOk = false;
        }
        if (isOk)
        {
            signIn(stEmail, stPassword);
        }
    }

    private void signIn(String stEmail, String stPassword) {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Please wait...", "Signing in", true,true);
        DBUtils.auth.signInWithEmailAndPassword(stEmail, stPassword).addOnCompleteListener(LoginActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "SignIn Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "signIn failed", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}


        //get the FireBase database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference refMyUsers = database.getReference("myUsers");//return a reference to myUsers. if not exists, create new
//        DatabaseReference refMyGroups = database.getReference("myGroups");//return a reference to myGroups. if not exists, create new
//        DatabaseReference refMyTasks = database.getReference("myTasks");//return a reference to myTasks. if not exists, create new
//
//        MyUser u = new MyUser();
//
//        u.setName("s3");
//        u.setuKey_email("a4@a4.com");
//        u.setPhone("055555");
//        u.addtaskKey("t11");
//        u.addtaskKey("t22");
//        u.addtaskKey("t33");
//        u.addGroupKey("g1");
//
//        //inserts a new entity to the database
//        //the key is u.getuKey_email() and the value, is u
//        //a key can't contain: '.', '#', '$', '[', ']'. need to replace the '.' with a different symbol
//        refMyUsers.child(u.getuKey_email()).setValue(u);
//
//        MyGroup g = new MyGroup();
//
//        g.setName("g1");
//        g.setgKey(refMyGroups.push().getKey());//generate an automatic key
//        g.setMngrUKey(u.getuKey_email());
//        g.addTaskKey("t1");
//        g.addTaskKey("t45");
//        g.addUserKey("u11");
//
//        refMyGroups.child(g.getgKey()).setValue(g);
//
//        MyTask t = new MyTask();
//
//        t.setText("laundry");
//        t.setgKey(g.getgKey());
//        t.setAddress("home");
//        t.setCompleted(false);
//        t.setCreatedAt(20170712);//can use: System.currentTimeMillis();
//        t.setLoc_lat(0);
//        t.setLoc_lng(0);
//        t.settKey(refMyTasks.push().getKey());
//        t.setuKey(u.getuKey_email());
//
//        refMyTasks.child(t.gettKey()).setValue(t);
//    }
//}
