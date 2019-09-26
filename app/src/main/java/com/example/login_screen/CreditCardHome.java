package com.example.login_screen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

public class CreditCardHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_card_home);

        final ImageView carousel = (ImageView ) findViewById(R.id.credit_card_carousel);

        carousel.setOnTouchListener(new OnSwipeTouchListener(CreditCardHome.this) {
            public void onSwipeTop() {
                //Toast.makeText(OutstandingRequestsActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Intent mIntent = new Intent(
                        CreditCardHome.this,
                        OutstandingRequestsActivity.class);
                startActivity(mIntent);
            }
            public void onSwipeLeft() {
            }
            public void onSwipeBottom() {
                //Toast.makeText(OutstandingRequestsActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });

        final ImageView cards = (ImageView) findViewById((R.id.credit_card_types));
        final Integer[] mImageIds = {R.drawable.abc_card, R.drawable.xyz_card};

        cards.setImageResource(mImageIds[0]);

        cards.setOnTouchListener(new OnSwipeTouchListener(CreditCardHome.this) {
            int current_card = 0;

            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                if(current_card == 1){
                    cards.setImageResource(mImageIds[0]);
                    current_card = 0;
                }
            }
            public void onSwipeLeft() {
                if(current_card == 0) {
                    cards.setImageResource(mImageIds[1]);
                    current_card = 1;
                }
            }
            public void onSwipeBottom() {
            }
        });

        final Button button_t_c = (Button) findViewById(R.id.button_t_c);

        button_t_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(
                        CreditCardHome.this,
                        CardDetailActivity.class);
                startActivity(mIntent);
            }
        });

    }
}

