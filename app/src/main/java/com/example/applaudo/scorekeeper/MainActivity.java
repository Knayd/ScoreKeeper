package com.example.applaudo.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtScoreA,txtPenaltyGoalsA,txtFoulsA,txtYellowCardsA,txtDirectRedCardsA,txtRedCardsByYCA,txtTotalRedCardsA,
            txtScoreB,txtPenaltyGoalsB,txtFoulsB,txtYellowCardsB,txtDirectRedCardsB,txtRedCardsByYCB,txtTotalRedCardsB;

    Button btnAddGoalA,btnAddPenaltyGoalA,btnAddFoulA,btnAddYellowCardA,btnAddRedCardA,
            btnAddGoalB,btnAddPenaltyGoalB,btnAddFoulB,btnAddYellowCardB,btnAddRedCardB,
            btnReset;

    int scoreA,penaltiesA,foulsA,yellowCardsA,redCardsA,redCardsBy2YCA,
        scoreB,penaltiesB,foulsB,yellowCardsB,redCardsB, redCardsBy2YCB;

    public void setViews()
    {
        //Team A Textviwes
        txtScoreA = findViewById(R.id.txv_goals_team_a);
        txtPenaltyGoalsA = findViewById(R.id.txv_penaltygoals_a);
        txtFoulsA = findViewById(R.id.txv_fouls_a);
        txtYellowCardsA = findViewById(R.id.txv_yellowcards_a);
        txtDirectRedCardsA = findViewById(R.id.txv_directredcards_a);
        txtRedCardsByYCA = findViewById(R.id.txv_redcardsbyyellowcards_a);
        txtTotalRedCardsA = findViewById(R.id.txv_totalredcards_a);

        //Team B TextViews
        txtScoreB = findViewById(R.id.txv_goals_team_b);
        txtPenaltyGoalsB = findViewById(R.id.txv_penaltygoals_b);
        txtFoulsB = findViewById(R.id.txv_fouls_b);
        txtYellowCardsB = findViewById(R.id.txv_yellowcards_b);
        txtDirectRedCardsB = findViewById(R.id.txv_directredcards_b);
        txtRedCardsByYCB = findViewById(R.id.txv_redcardsbyyellowcards_b);
        txtTotalRedCardsB = findViewById(R.id.txv_totalredcards_b);

        //Buttons Team A
        btnAddGoalA = findViewById(R.id.btn_goal_a);
        btnAddPenaltyGoalA = findViewById(R.id.btn_penaltygoal_a);
        btnAddFoulA = findViewById(R.id.btn_foul_a);
        btnAddYellowCardA = findViewById(R.id.btn_yellow_card_a);
        btnAddRedCardA = findViewById(R.id.btn_red_card_a);

        //Buttons Team B
        btnAddGoalB = findViewById(R.id.btn_goal_b);
        btnAddPenaltyGoalB = findViewById(R.id.btn_penaltygoal_b);
        btnAddFoulB = findViewById(R.id.btn_foul_b);
        btnAddYellowCardB = findViewById(R.id.btn_yellow_card_b);
        btnAddRedCardB = findViewById(R.id.btn_red_card_b);

        //Reset button
        btnReset = findViewById(R.id.btn_reset);

    }

    public void setNumberToTextView(TextView tv, int number){
        tv.setText("" + number);
    }

    public void resetVaraibles(){
        scoreA=0;
        penaltiesA=0;
        foulsA=0;
        yellowCardsA=0;
        redCardsA =0;
        redCardsBy2YCA=0;
        scoreB=0;
        penaltiesB=0;
        foulsB=0;
        yellowCardsB=0;
        redCardsB =0;
        redCardsBy2YCB=0;
    }

    public void clearViews(){
        txtScoreA.setText("0");
        txtPenaltyGoalsA.setText("0");
        txtFoulsA.setText("0");
        txtYellowCardsA.setText("0");
        txtDirectRedCardsA.setText("0");
        txtRedCardsByYCA.setText("0");
        txtTotalRedCardsA.setText("0");
        txtScoreB.setText("0");
        txtPenaltyGoalsB.setText("0");
        txtFoulsB.setText("0");
        txtYellowCardsB.setText("0");
        txtDirectRedCardsB.setText("0");
        txtRedCardsByYCB.setText("0");
        txtTotalRedCardsB.setText("0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

        //TEAM A======================================================

        //Adds a goal to Team A
        btnAddGoalA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA +=1;
                setNumberToTextView(txtScoreA, scoreA);
            }
        });

        //Ads a penalty goal
        btnAddPenaltyGoalA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penaltiesA+=1;
                scoreA+=1;
                setNumberToTextView(txtPenaltyGoalsA,penaltiesA);
                setNumberToTextView(txtScoreA, scoreA); //It also adds a goal to the global score
            }
        });

        //Adds a foul
        btnAddFoulA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foulsA+=1;
                setNumberToTextView(txtFoulsA, foulsA);
            }
        });

        //Adds the yellow cards (+ the double yellow card red card)
        btnAddYellowCardA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowCardsA+=1;
                //checks if the yellow cards total is even
                if(yellowCardsA%2==0){
                    redCardsBy2YCA+=1; //Adds a "double yellow" red card to the individial counter
                }
                setNumberToTextView(txtYellowCardsA, yellowCardsA);
                setNumberToTextView(txtRedCardsByYCA, redCardsBy2YCA);
                setNumberToTextView(txtTotalRedCardsA, (redCardsA +redCardsBy2YCA)); //direct red cards + double yellow red cards

            }
        });

        btnAddRedCardA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redCardsA +=1;
                setNumberToTextView(txtDirectRedCardsA, redCardsA); //adds a direct red card
                setNumberToTextView(txtTotalRedCardsA, (redCardsA +redCardsBy2YCA)); //direct red cards + double yellow red cards

            }
        });

        //TEAM B =====================================================
        //Adds a goal to Team B
        btnAddGoalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB +=1;
                setNumberToTextView(txtScoreB, scoreB);
            }
        });

        //Ads a penalty goal
        btnAddPenaltyGoalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penaltiesB+=1;
                scoreB+=1;
                setNumberToTextView(txtPenaltyGoalsB,penaltiesB);
                setNumberToTextView(txtScoreB, scoreB); //It also adds a goal to the global score
            }
        });


        //Adds a foul
        btnAddFoulB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foulsB+=1;
                setNumberToTextView(txtFoulsB, foulsB);
            }
        });

        //Adds the yellow cards (+ the double yellow card red card)
        btnAddYellowCardB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowCardsB+=1;
                //checks if the yellow cards total is even
                if(yellowCardsB%2==0){
                    redCardsBy2YCB+=1; //Adds a "double yellow" red card to the individial counter
                }
                setNumberToTextView(txtYellowCardsB, yellowCardsB);
                setNumberToTextView(txtRedCardsByYCB, redCardsBy2YCB);
                setNumberToTextView(txtTotalRedCardsB, (redCardsB +redCardsBy2YCB)); //direct red cards + double yellow red cards

            }
        });

        btnAddRedCardB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redCardsB +=1;
                setNumberToTextView(txtDirectRedCardsB, redCardsB); //adds a direct red card
                setNumberToTextView(txtTotalRedCardsB, (redCardsB +redCardsBy2YCB)); //direct red cards + double yellow red cards

            }
        });

        //Resets the values and views ===============================
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetVaraibles();
                clearViews();
            }
        });

    }
}
