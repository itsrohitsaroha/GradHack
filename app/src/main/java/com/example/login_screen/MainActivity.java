package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.*;
import android.view.View.OnClickListener;
import android.view.*;



import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

import org.json.JSONException;
import org.json.JSONObject;

import com.voiceit.voiceit2.VoiceItAPI2;

public class MainActivity extends AppCompatActivity {

    private VoiceItAPI2 myVoiceIt2 = new VoiceItAPI2("key_ed65a6ff5c3c40c3bf4a4721263f3048",
            "tok_0512077528884659b793ec723404b2bb");

    public String userId = "usr_3b3cce9192d740feb2e9b877f750888a";
    private String phrase = "never forget tomorrow is a new day";
    private String contentLanguage = "en-US";
    private boolean doLivenessCheck = false;
    SharedPreferences sharedPref;
    SharedPreferences.Editor prefEditor;

    //TextView displayText;
    TextView createDeleteUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.voice_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        prefEditor = sharedPref.edit();
        phrase = sharedPref.getString("phrase", phrase);
        //displayText = findViewById(R.id.displayText);
        Button bt=(Button)findViewById(R.id.createDeleteUserButton);
        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(
                        MainActivity.this,
                        PasscodeActivity.class);
                startActivity(mIntent);
            }
        });

        /*final Button voiceVerificationButton = (Button) findViewById(R.id.voiceVerificationButton);
        //voice_login_button.setVisibility(View.GONE);

        voiceVerificationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(
                        MainActivity.this,
                        PasscodeActivity.class);
                startActivity(mIntent);
            }
        });*/
        //Intent shake = new Intent(MainActivity.this, ShakeListenerTestActivity.class);
        //startActivity(shake);
    }


    private void enableButtons(boolean enabled) {
        findViewById(R.id.voiceEnrollmentButton).setEnabled(enabled);
        findViewById(R.id.voiceVerificationButton).setEnabled(enabled);
    }
    public void encapsulatedVoiceVerification(View view) {
        myVoiceIt2.encapsulatedVoiceVerification(this, userId, contentLanguage, phrase, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("encapsulatedVoiceVerification Result : " + response.toString());
                Intent mIntent = new Intent(
                        MainActivity.this,
                        PasscodeActivity.class);
                startActivity(mIntent);

                //displayText.setText("encapsulatedVoiceVerification Result : " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    System.out.println("encapsulatedVoiceVerification Result : " + errorResponse.toString());
                    //displayText.setText("encapsulatedVoiceVerification Result : " + errorResponse.toString());
                }
            }
        });
    }

    public void encapsulatedVoiceEnrollment(View view) {
        myVoiceIt2.encapsulatedVoiceEnrollment(this, userId, contentLanguage, phrase, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("encapsulatedVoiceEnrollment Result : " + response.toString());
                //displayText.setText("encapsulatedVoiceEnrollment Result : " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    System.out.println("encapsulatedVoiceEnrollment Result : " + errorResponse.toString());
                    //displayText.setText("encapsulatedVoiceEnrollment Result : " + errorResponse.toString());
                }
            }
        });
    }

    public void encapsulatedVideoEnrollment(View view) {
        myVoiceIt2.encapsulatedVideoEnrollment(this, userId, contentLanguage, phrase, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("encapsulatedVideoEnrollment Result : " + response.toString());
                //displayText.setText("encapsulatedVideoEnrollment Result : " + response.toString());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    System.out.println("encapsulatedVideoEnrollment Result : " + errorResponse.toString());
                    //displayText.setText("encapsulatedVideoEnrollment Result : " + errorResponse.toString());
                }
            }
        });
    }

    public void encapsulatedVideoVerification(View view) {
        myVoiceIt2.encapsulatedVideoVerification(this, userId, contentLanguage, phrase, doLivenessCheck, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("encapsulatedVideoVerification Result : " + response.toString());
                //displayText.setText("encapsulatedVideoVerification Result : " + response.toString());
                Intent mIntent = new Intent(
                        MainActivity.this,
                        PasscodeActivity.class);
                startActivity(mIntent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    System.out.println("encapsulatedVideoVerification Result : " + errorResponse.toString());
                    // displayText.setText("encapsulatedVideoVerification Result : " + errorResponse.toString());
                }
            }
        });
    }


}
