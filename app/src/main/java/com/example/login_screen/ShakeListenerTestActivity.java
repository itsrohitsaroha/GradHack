package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.os.Vibrator;
import android.app.AlertDialog;

public class ShakeListenerTestActivity extends AppCompatActivity {

        private ShakeListener mShaker;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.passcode_login);

            final Vibrator vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

            mShaker = new ShakeListener(this);
            mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
                public void onShake()
                {
                    //vibe.vibrate(100);
                    // check use of parameter in AlertDialog.Builder, previously was Testy.this
                    new AlertDialog.Builder(ShakeListenerTestActivity.this)
                            .setPositiveButton(android.R.string.ok, null)
                            .setMessage("Shooken!")
                            .show();
                }
            });
        }

        @Override
        public void onResume()
        {
            mShaker.resume();
            super.onResume();
        }
        @Override
        public void onPause()
        {
            mShaker.pause();
            super.onPause();
        }
    }
