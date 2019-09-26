package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OutstandingRequestsActivity extends AppCompatActivity {

    static int tot_requests = 0;

    String next_appointment = "NO UPCOMING" + "\n" + "REQUESTS";
    String appointment_list = "NO UPCOMING" + "\n" + "APPOINTMENTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outstanding_requests);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("increase_request");
            tot_requests += 1;
            next_appointment = "30/9 (Mon)" + "\n"+ "CREDIT CARD";
            appointment_list = "CREDIT CARD APPOINTMENT";
        }

        final TextView counter_requests = (TextView) findViewById(R.id.request_counter);
        final TextView branch_appointment = (TextView) findViewById(R.id.branch_appointment);
        final TextView new_requests = (TextView) findViewById(R.id.new_requests);
        final ImageView carousel = (ImageView ) findViewById(R.id.outstanding_request_carousel);

        counter_requests.setText(Integer.toString(tot_requests));
        branch_appointment.setText(next_appointment);
        new_requests.setText(appointment_list);

        carousel.setOnTouchListener(new OnSwipeTouchListener(OutstandingRequestsActivity.this) {
            public void onSwipeTop() {
                //Toast.makeText(OutstandingRequestsActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                //Toast.makeText(OutstandingRequestsActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Intent mIntent = new Intent(
                        OutstandingRequestsActivity.this,
                        CreditCardHome.class);
                startActivity(mIntent);
            }
            public void onSwipeBottom() {
                //Toast.makeText(OutstandingRequestsActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
