package com.passeapp.dark_legion.asacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class EndingActivity extends AppCompatActivity {

    private TextView lblScore;
    private ImageButton restartBtn;
    private ImageButton repeatTestBtn;
    private ImageButton solutionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        init();
    }

    public void init(){
        lblScore = (TextView)findViewById(R.id.lblScore);
        if(getIntent().hasExtra("score")){
            String score = getIntent().getStringExtra("score");
            lblScore.setText(score);
        }
        restartBtn = (ImageButton)findViewById(R.id.repeatBtn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetvariables();
                finish();
                startActivity(new Intent(getApplicationContext(), MateriaActivity.class));
            }
        });
        repeatTestBtn = (ImageButton)findViewById(R.id.repeatTestBtn);
        repeatTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetvariables();
                finish();
                startActivity(new Intent(getApplicationContext(), TestActivity.class));
            }
        });
        solutionBtn = (ImageButton)findViewById(R.id.btnSolucion);
        solutionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SolutionTabebActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    public void resetvariables(){
        /*for (QuestionClass q :VariablesActivity.lstMaterias.get(VariablesActivity.actualIndexMateria).getLstTemas().get(VariablesActivity.actualIndexTema)
                .getLstTest().get(VariablesActivity.actualIndexTest).setLstPreguntas(new ArrayList<QuestionClass>());) {
            q.resetQuestionVariables();
        }*/
        VariablesActivity.lstMaterias.get(VariablesActivity.actualIndexMateria).getLstTemas().get(VariablesActivity.actualIndexTema)
                .getLstTest().get(VariablesActivity.actualIndexTest).setLstPreguntas(new ArrayList<QuestionClass>());
        VariablesActivity.lstMaterias.get(VariablesActivity.actualIndexMateria).getLstTemas().get(VariablesActivity.actualIndexTema)
                .getLstTest().get(VariablesActivity.actualIndexTest).clearScore();
        VariablesActivity.actualTest = null;
        VariablesActivity.actualIndexTest = null;
        VariablesActivity.actualQuestion = null;
        VariablesActivity.actualIndexPregunta = null;
    }

}
