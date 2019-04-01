package com.example.millionaire_castilloa15_game;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class winner extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        tv1 =(TextView)findViewById(R.id.textView2);

        SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int q1string = sp.getInt("QUIZRESULT", 0);

        tv1.setText(String.valueOf(q1string));
    }
}
