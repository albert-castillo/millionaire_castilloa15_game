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

public class HomeActivity extends AppCompatActivity {

    //declare variables
    private static RadioGroup radG;
    private static RadioButton rad_b;
    private static Button but_quiz1;
    TextView tv1;
    int q1string = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        onClickListenerButton();


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

                        AlertDialog.Builder alertDlg = new AlertDialog.Builder(HomeActivity.this);
                        alertDlg.setMessage("Is "+ rad_b.getText().toString()+" your final answer?");
                        alertDlg.setCancelable(false);

                        alertDlg.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // If the answer is right

                                String answer = "40 DAYS";

                                if (rad_b.getText().toString().equals(answer)){

                                    String q1 = "Question 1: Correct ~ "+answer;
                                    int result = 0;
                                    result=result+100000;

                                    Toast.makeText(HomeActivity.this,q1,Toast.LENGTH_SHORT).show();
                                    //Saves user input
                                    SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putInt("QUIZRESULT",result);
                                    editor.commit();

                                    startActivity(new Intent(HomeActivity.this, quiz2.class));

                                }

                                //If the answer is wrong
                                else{

                                    String q1 = "Question 1: Wrong ~ "+rad_b.getText().toString();
                                    Toast.makeText(HomeActivity.this, q1,Toast.LENGTH_SHORT).show();
                                    int result = 0;

                                    SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putInt("QUIZRESULT",result);
                                    editor.commit();
                                    startActivity(new Intent(HomeActivity.this, wrongAns.class));



                                }


                            }
                        });

                        //if user clicks no during confirmation UI
                        alertDlg.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeActivity.this,
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
