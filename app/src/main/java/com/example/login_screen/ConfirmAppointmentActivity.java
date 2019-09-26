package com.example.login_screen;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class ConfirmAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_appointment);

        final Button confirm_appointment = (Button) findViewById(R.id.back_to_main);

        confirm_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(
                        ConfirmAppointmentActivity.this,
                        OutstandingRequestsActivity.class);
                mIntent.putExtra("increase_request", true);
                startActivity(mIntent);
            }
        });
    }

}
