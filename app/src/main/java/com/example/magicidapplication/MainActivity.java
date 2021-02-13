package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etID;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0, 6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if (gender < 5) {
                    sGender = "Female";
                } else {
                    sGender = "Male";
                }

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if (nationality == 0) {
                    sNationality = getString(R.string.sacit);
                } else {
                    sNationality = getString(R.string.permanent);
                }

                tvResults.setText(getString(R.string.dob) + dob + "\n"
                        + getString(R.string.gender) + sGender + "\n"
                        + getString(R.string.nationality) + sNationality);

                hideSoftKeyBoard();

                tvResults.setVisibility(View.VISIBLE);

            }
        });
    }

    public void hideSoftKeyBoard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}