package com.example.buttonclickinghw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetterActivity extends AppCompatActivity {

    int limitNumber = 0;

    EditText limitNumberInput;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setter);

        limitNumberInput = (EditText) findViewById(R.id.nextNumberLimit);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                limitNumber = Integer.valueOf(limitNumberInput.getText().toString());

                openMainActivity(limitNumber);
            }
        });
    }

    public void openMainActivity(int number) {
        int newNumber = limitNumber;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("New Number", newNumber);
        startActivity(intent);
    }
}
