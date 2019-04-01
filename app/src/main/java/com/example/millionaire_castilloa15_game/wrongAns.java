package com.example.millionaire_castilloa15_game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class wrongAns extends AppCompatActivity {

    Button lButton;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_ans);


        lButton=(Button)findViewById(R.id.log);
        tv1 =(TextView)findViewById(R.id.textView2);

        //loads money earned from saved internal data
        SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int q1string = sp.getInt("QUIZRESULT", 0);

        //replaces textview with money earned
        tv1.setText(String.valueOf(q1string));

    }

    //moves user to the First Question if they click the button
    public void moveToQuiz(View view) {
        startActivity(new Intent(wrongAns.this, HomeActivity.class));
    }




}
