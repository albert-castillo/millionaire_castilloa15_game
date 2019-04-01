package com.example.millionaire_castilloa15_game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quiz7 extends AppCompatActivity {

    //declare variables
    private static RadioGroup radG;
    private static RadioButton rad_b;
    private static Button but_quiz1;
    int result;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz7);
        onClickListenerButton();

        tv1 =(TextView)findViewById(R.id.textView5);

        //gets the stored info for quiz results
        SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int q1string = sp.getInt("QUIZRESULT", 0);

        //displays how much money the player has earned
        tv1.setText(String.valueOf(q1string));


    }

    public void onClickListenerButton(){
        radG = (RadioGroup)findViewById(R.id.radioG);
        but_quiz1 =(Button)findViewById(R.id.button_quiz1);

        but_quiz1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int sel_id = radG.getCheckedRadioButtonId();
                        rad_b = (RadioButton)findViewById(sel_id);

                        //comfirmation UI

                        AlertDialog.Builder alertDlg = new AlertDialog.Builder(quiz7.this);
                        alertDlg.setMessage("Is "+ rad_b.getText().toString()+" your final answer?");
                        alertDlg.setCancelable(false);

                        alertDlg.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // If the answer is right

                                String answer = "HOCKEY";

                                if (rad_b.getText().toString().equals(answer)){

                                    String q1 = "Question 7: Correct ~ "+answer;
                                    SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    int q1string = sp.getInt("QUIZRESULT", 0);

                                    result=q1string+100000;

                                    Toast.makeText(quiz7.this,q1,Toast.LENGTH_SHORT).show();
                                    //Saves user input
                                    sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putInt("QUIZRESULT",result);
                                    editor.commit();

                                    startActivity(new Intent(quiz7.this, quiz8.class));

                                }

                                //If the answer is wrong
                                else{

                                    String q1 = "Question 7: Wrong ~ "+rad_b.getText().toString();
                                    Toast.makeText(quiz7.this, q1,Toast.LENGTH_SHORT).show();

                                    SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    int q1string = sp.getInt("QUIZRESULT", 0);

                                    result=q1string;

                                    sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putInt("QUIZRESULT",result);
                                    editor.commit();
                                    startActivity(new Intent(quiz7.this, wrongAns.class));



                                }


                            }
                        });

                        //if user clicks no during confirmation UI
                        alertDlg.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(quiz7.this,
                                        "Retry",Toast.LENGTH_SHORT).show();
                            }
                        });
                        //needed to close confirmation UI so it works
                        AlertDialog alert = alertDlg.create();
                        alert.setTitle("Confirmation Window");
                        alert.show();


                    }

                }
        );



    }
}
