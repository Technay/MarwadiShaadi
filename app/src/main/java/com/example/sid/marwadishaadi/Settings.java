package com.example.sid.marwadishaadi;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {


    protected SwitchCompat notifications;
    protected TextView reset_pass;
    protected TextView deactivate_acc;
    protected TextView delete_acc;
    protected TextView blocked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


      notifications = (SwitchCompat) findViewById(R.id.switchNot);
        reset_pass = (TextView) findViewById(R.id.reset_password);
        deactivate_acc = (TextView) findViewById(R.id.deactivate_acc);
        delete_acc = (TextView) findViewById(R.id.delete_acc);
        blocked = (TextView) findViewById(R.id.blocked);



        reset_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View reset_view = getLayoutInflater().inflate(R.layout.reset_dialog,null);
                AlertDialog.Builder reset = new AlertDialog.Builder(Settings.this);
                reset.setTitle("Reset Password");
                reset.setView(reset_view);

                final EditText email = (EditText) reset_view.findViewById(R.id.user_email);
                final EditText newpass = (EditText) reset_view.findViewById(R.id.user_password);
                Button resetbutton = (Button) reset_view.findViewById(R.id.user_reset);
                final TextView call_us = (TextView) reset_view.findViewById(R.id.call_us);

                resetbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String user_email = email.getText().toString();
                        String user_pass = newpass.getText().toString();

                        Toast.makeText(Settings.this, "yayay", Toast.LENGTH_SHORT).show();
                    }
                });

                call_us.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + call_us.getText().toString()));//change the number
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(getApplicationContext(),"Permission for Call Denied!",Toast.LENGTH_LONG).show();
                            return;
                        }else{
                            AlertDialog.Builder discarduser = new AlertDialog.Builder(Settings.this);
                            discarduser.setMessage("Do you want to call " + call_us.getText().toString() + " ? ")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id)
                                        {
                                            startActivity(callIntent);
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                            // setting up dialog box
                            AlertDialog alertbox = discarduser.create();
                            alertbox.setTitle("Contact Us");
                            alertbox.show();
                        }
                    }
                });

                AlertDialog resetbox = reset.create();
                resetbox.show();
            }
        });

        deactivate_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AlertDialog.Builder deactivate = new AlertDialog.Builder(Settings.this);
                    deactivate.setMessage("Are you sure you want to Deactivate your account ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Settings.this, "cool!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Settings.this, "ohh whyyy", Toast.LENGTH_SHORT).show();
                                }
                            });

                AlertDialog box = deactivate.create();
                box.setTitle("Deactivate Account ?");
                box.show();
            }
        });

        delete_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder delete = new AlertDialog.Builder(Settings.this);
                delete.setMessage("Are you sure you want to Delete your account ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Settings.this, "cool!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Settings.this, "ohh whyyy", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog box = delete.create();
                box.setTitle("Delete Account ?");
                box.show();
            }
        });

        blocked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Settings.this,Blocked.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

    }
}
