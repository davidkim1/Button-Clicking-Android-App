package com.example.buttonclickinghw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterTxt;
    private Button minusBtn;
    private Button plusBtn;
    private Button resetBtn;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.minusBtn :
                    minusCounter();
                    break;
                case R.id.plusBtn:
                    plusCounter();
                    break;
                case R.id.resetBtn:
                    initCounter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTxt = (TextView) findViewById(R.id.counterTxt);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(clickListener);

        initCounter();
    }

    private void initCounter(){
        counter = 0;
        counterTxt.setText(counter + "");
    }

    private void plusCounter() {
        counter++;
        int nNumber = getIntent().getIntExtra("New Number", 0);

        if (nNumber != 0){

            if (nNumber > 0){

                if (counter > nNumber){
                    openSetterActivity();
                }

                else
                    counterTxt.setText(counter + "");

            }

            else
                counterTxt.setText(counter + "");

        }

        else if (counter > 5 ){
            openSetterActivity();
        }
        else
        counterTxt.setText(counter + "");
    }

    private void minusCounter() {
        counter--;
        int nNumber = getIntent().getIntExtra("New Number", 0);

        if (nNumber != 0){

            if (nNumber < 0){

                if (counter < nNumber){
                    openSetterActivity();
                }

                else
                    counterTxt.setText(counter + "");
            }

            else
                counterTxt.setText(counter + "");
        }

        else if (counter > 5 ){
            openSetterActivity();
        }
        else
            counterTxt.setText(counter + "");
    }

    public void openSetterActivity() {
        Intent intent = new Intent(this, SetterActivity.class);
        startActivity(intent);
    }
}
