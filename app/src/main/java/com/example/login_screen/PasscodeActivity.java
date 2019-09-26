package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasscodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passcode_login);
        final EditText et1 = (EditText) findViewById(R.id.passw_field1);
        final EditText et2 = (EditText) findViewById(R.id.passw_field2);
        final EditText et3 = (EditText) findViewById(R.id.passw_field3);
        final EditText et4 = (EditText) findViewById(R.id.passw_field4);

        //move through password textboxes
        passw_field_move(et1, et2, et3, et4);

        //Password validation
        validate__password(et1, et2, et3, et4);
    }

    void passw_field_move(final EditText et1, final EditText et2, final EditText et3, final EditText et4){
        final int size = 1;

        et1.requestFocus();

        // For password input
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // specify length of your editext here to move on next edittext
                if (et1.getText().toString().trim().length() >= size) {
                    et2.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // specify length of your editext here to move on next edittext
                if (et2.getText().toString().trim().length() >= size) {
                    et3.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // specify length of your editext here to move on next edittext
                if (et3.getText().toString().trim().length() >= size) {
                    et4.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
    }

    void validate__password(final EditText et1, final EditText et2, final EditText et3, final EditText et4){
        final Button submit_passw = (Button) findViewById(R.id.submit_passw);

        submit_passw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validationSuccess()) {
                    //change to next activity
                    Intent mIntent = new Intent(
                            PasscodeActivity.this,
                            LoginSuccessActivity.class);
                        startActivity(mIntent);
                } else {
                    AlertDialog();
                }
            }

            // validate password: 3725
            private Boolean validationSuccess() {
                if (et1.getText().toString().equalsIgnoreCase("3") && et2.getText().toString().equalsIgnoreCase("7") && et3.getText().toString().equalsIgnoreCase("2") && et4.getText().toString().equalsIgnoreCase("5")) {
                    System.out.println("ok");
                    return true;
                }
                System.out.println("not ok");
                return false;
            }

            private void AlertDialog() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PasscodeActivity.this);
                alertDialogBuilder.setMessage("PASSCODE INCORRECT, RETYPE").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }
        });
    }
}
