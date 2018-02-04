package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    /**
     * Constants for action recognition
     */
    final int ACTION_ATTACK_KILL  = 0;
    final int ACTION_BLOCK        = 1;
    final int ACTION_SERVICE_ACE  = 2;
    final int ACTION_ERROR        = 3;

    /**
     * Constants for player recognition
     */
    final int ACTION_PLAYER_1_FROM_TEAM_A  = 0;
    final int ACTION_PLAYER_2_FROM_TEAM_A  = 1;
    final int ACTION_PLAYER_1_FROM_TEAM_B  = 2;
    final int ACTION_PLAYER_2_FROM_TEAM_B  = 3;

    /**
     * Common team scores
     */
    int teamAScore = 0;
    int teamBScore = 0;

    /**
     * Team A statistics scores for each player
     */
    int[] teamAPlayer1 = {0, 0, 0, 0};
    int[] teamAPlayer2 = {0, 0, 0, 0};

    /**
     * Team B statistics scores for each player
     */
    int[] teamBPlayer1 = {0, 0, 0, 0};
    int[] teamBPlayer2 = {0, 0, 0, 0};

    /**
     * Last player's action for tracking
     * 0 - No action
     * 1 - Attack / Kill
     * 2 - Block
     * 3 - Service Ace
     * 4 - Error
     */
    int lastPlayerAction = 4;

    /**
     * Id of the player who has done last action
     * 0 - No one
     * 1 - Player 1 from Team A
     * 2 - Player 2 from Team A
     * 3 - Player 1 from Team B
     * 4 - Player 2 from Team B
     */
    int lastPlayerId = 4;

    /**
     * Views on screen for changing text
     */
    TextView tvTeamAScore;
    TextView tvTeamBScore;

    TextView tvTeamAPlayer1Attack;
    TextView tvTeamAPlayer2Attack;
    TextView tvTeamAPlayer1Block;
    TextView tvTeamAPlayer2Block;
    TextView tvTeamAPlayer1ServiceAce;
    TextView tvTeamAPlayer2ServiceAce;
    TextView tvTeamAPlayer1Error;
    TextView tvTeamAPlayer2Error;

    TextView tvTeamBPlayer1Attack;
    TextView tvTeamBPlayer2Attack;
    TextView tvTeamBPlayer1Block;
    TextView tvTeamBPlayer2Block;
    TextView tvTeamBPlayer1ServiceAce;
    TextView tvTeamBPlayer2ServiceAce;
    TextView tvTeamBPlayer1Error;
    TextView tvTeamBPlayer2Error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTeamAScore = findViewById(R.id.tvTeamAScore);
        tvTeamBScore = findViewById(R.id.tvTeamBScore);

        tvTeamAPlayer1Attack = findViewById(R.id.tvAttackPlayer1TeamA);
        tvTeamAPlayer2Attack = findViewById(R.id.tvAttackPlayer2TeamA);
        tvTeamAPlayer1Block = findViewById(R.id.tvBlockPlayer1TeamA);
        tvTeamAPlayer2Block = findViewById(R.id.tvBlockPlayer2TeamA);
        tvTeamAPlayer1ServiceAce = findViewById(R.id.tvServeAcePlayer1TeamA);
        tvTeamAPlayer2ServiceAce = findViewById(R.id.tvServeAcePlayer2TeamA);
        tvTeamAPlayer1Error = findViewById(R.id.tvErrorPlayer1TeamA);
        tvTeamAPlayer2Error = findViewById(R.id.tvErrorPlayer2TeamA);

        tvTeamBPlayer1Attack = findViewById(R.id.tvAttackPlayer1TeamB);
        tvTeamBPlayer2Attack = findViewById(R.id.tvAttackPlayer2TeamB);
        tvTeamBPlayer1Block = findViewById(R.id.tvBlockPlayer1TeamB);
        tvTeamBPlayer2Block = findViewById(R.id.tvBlockPlayer2TeamB);
        tvTeamBPlayer1ServiceAce = findViewById(R.id.tvServeAcePlayer1TeamB);
        tvTeamBPlayer2ServiceAce = findViewById(R.id.tvServeAcePlayer2TeamB);
        tvTeamBPlayer1Error = findViewById(R.id.tvErrorPlayer1TeamB);
        tvTeamBPlayer2Error = findViewById(R.id.tvErrorPlayer2TeamB);
    }

    private void showScores() {
        tvTeamAScore.setText(String.valueOf(teamAScore));
        tvTeamBScore.setText(String.valueOf(teamBScore));
    }

    private void showStatisticsTeamAPlayer1() {
        tvTeamAPlayer1Attack.setText(String.valueOf(teamAPlayer1[ACTION_ATTACK_KILL]));
        tvTeamAPlayer1Block.setText(String.valueOf(teamAPlayer1[ACTION_BLOCK]));
        tvTeamAPlayer1ServiceAce.setText(String.valueOf(teamAPlayer1[ACTION_SERVICE_ACE]));
        tvTeamAPlayer1Error.setText(String.valueOf(teamAPlayer1[ACTION_ERROR]));
    }

    private void showStatisticsTeamAPlayer2() {
        tvTeamAPlayer2Attack.setText(String.valueOf(teamAPlayer2[ACTION_ATTACK_KILL]));
        tvTeamAPlayer2Block.setText(String.valueOf(teamAPlayer2[ACTION_BLOCK]));
        tvTeamAPlayer2ServiceAce.setText(String.valueOf(teamAPlayer2[ACTION_SERVICE_ACE]));
        tvTeamAPlayer2Error.setText(String.valueOf(teamAPlayer2[ACTION_ERROR]));
    }

    private void showStatisticsTeamBPlayer1() {
        tvTeamBPlayer1Attack.setText(String.valueOf(teamBPlayer1[ACTION_ATTACK_KILL]));
        tvTeamBPlayer1Block.setText(String.valueOf(teamBPlayer1[ACTION_BLOCK]));
        tvTeamBPlayer1ServiceAce.setText(String.valueOf(teamBPlayer1[ACTION_SERVICE_ACE]));
        tvTeamBPlayer1Error.setText(String.valueOf(teamBPlayer1[ACTION_ERROR]));
    }

    private void showStatisticsTeamBPlayer2() {
        tvTeamBPlayer2Attack.setText(String.valueOf(teamBPlayer2[ACTION_ATTACK_KILL]));
        tvTeamBPlayer2Block.setText(String.valueOf(teamBPlayer2[ACTION_BLOCK]));
        tvTeamBPlayer2ServiceAce.setText(String.valueOf(teamBPlayer2[ACTION_SERVICE_ACE]));
        tvTeamBPlayer2Error.setText(String.valueOf(teamBPlayer2[ACTION_ERROR]));
    }

    private void increaseScoreA() {
        teamAScore += 1;
        showScores();
    }

    private void decreaseScoreA() {
        if (teamAScore > 0) {
            teamAScore -= 1;
        } else {
            Toast.makeText(this, R.string.less_than_zero, Toast.LENGTH_LONG).show();
        }
        showScores();
    }

    private void increaseScoreB() {
        teamBScore += 1;
        showScores();
    }

    private void decreaseScoreB() {
        if (teamBScore > 0) {
            teamBScore -= 1;
        } else {
            Toast.makeText(this, R.string.less_than_zero, Toast.LENGTH_LONG).show();
        }
        showScores();
    }

    public void increaseScoreByAttackP1TA(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_ATTACK_KILL;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_A;

        teamAPlayer1[ACTION_ATTACK_KILL] += 1;
        showStatisticsTeamAPlayer1();
    }

    public void increaseScoreByBlockP1TA(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_BLOCK;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_A;

        teamAPlayer1[ACTION_BLOCK] += 1;
        showStatisticsTeamAPlayer1();
    }

    public void increaseScoreByAceP1TA(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_SERVICE_ACE;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_A;

        teamAPlayer1[ACTION_SERVICE_ACE] += 1;
        showStatisticsTeamAPlayer1();
    }

    public void increaseScoreByErrorP1TA(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_ERROR;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_A;

        teamAPlayer1[ACTION_ERROR] += 1;
        showStatisticsTeamAPlayer1();
    }

    public void increaseScoreByAttackP2TA(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_ATTACK_KILL;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_A;

        teamAPlayer2[ACTION_ATTACK_KILL] += 1;
        showStatisticsTeamAPlayer2();
    }

    public void increaseScoreByBlockP2TA(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_BLOCK;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_A;

        teamAPlayer2[ACTION_BLOCK] += 1;
        showStatisticsTeamAPlayer2();
    }

    public void increaseScoreByAceP2TA(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_SERVICE_ACE;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_A;

        teamAPlayer2[ACTION_SERVICE_ACE] += 1;
        showStatisticsTeamAPlayer2();
    }

    public void increaseScoreByErrorP2TA(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_ERROR;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_A;

        teamAPlayer2[ACTION_ERROR] += 1;
        showStatisticsTeamAPlayer2();
    }

    public void increaseScoreByAttackP1TB(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_ATTACK_KILL;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_B;

        teamBPlayer1[ACTION_ATTACK_KILL] += 1;
        showStatisticsTeamBPlayer1();
    }

    public void increaseScoreByBlockP1TB(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_BLOCK;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_B;

        teamBPlayer1[ACTION_BLOCK] += 1;
        showStatisticsTeamBPlayer1();
    }

    public void increaseScoreByAceP1TB(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_SERVICE_ACE;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_B;

        teamBPlayer1[ACTION_SERVICE_ACE] += 1;
        showStatisticsTeamBPlayer1();
    }

    public void increaseScoreByErrorP1TB(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_ERROR;
        lastPlayerId = ACTION_PLAYER_1_FROM_TEAM_B;

        teamBPlayer1[ACTION_ERROR] += 1;
        showStatisticsTeamBPlayer1();
    }

    public void increaseScoreByAttackP2TB(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_ATTACK_KILL;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_B;

        teamBPlayer2[ACTION_ATTACK_KILL] += 1;
        showStatisticsTeamBPlayer2();
    }

    public void increaseScoreByBlockP2TB(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_BLOCK;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_B;

        teamBPlayer2[ACTION_BLOCK] += 1;
        showStatisticsTeamBPlayer2();
    }

    public void increaseScoreByAceP2TB(View view) {
        increaseScoreB();
        lastPlayerAction = ACTION_SERVICE_ACE;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_B;

        teamBPlayer2[ACTION_SERVICE_ACE] += 1;
        showStatisticsTeamBPlayer2();
    }

    public void increaseScoreByErrorP2TB(View view) {
        increaseScoreA();
        lastPlayerAction = ACTION_ERROR;
        lastPlayerId = ACTION_PLAYER_2_FROM_TEAM_B;

        teamBPlayer2[ACTION_ERROR] += 1;
        showStatisticsTeamBPlayer2();
    }

    public void undoLastAction(View view) {
        if (lastPlayerAction < 4) {
            switch (lastPlayerId) {
                case ACTION_PLAYER_1_FROM_TEAM_A: // for Player 1 from Team A
                    teamAPlayer1[lastPlayerAction] -= 1;
                    showStatisticsTeamAPlayer1();
                    if (lastPlayerAction == ACTION_ERROR) {
                        decreaseScoreB();
                    } else {
                        decreaseScoreA();
                    }
                    break;
                case ACTION_PLAYER_2_FROM_TEAM_A: // for Player 2 from Team A
                    teamAPlayer2[lastPlayerAction] -= 1;
                    showStatisticsTeamAPlayer2();
                    if (lastPlayerAction == ACTION_ERROR) {
                        decreaseScoreB();
                    } else {
                        decreaseScoreA();
                    }
                    break;
                case ACTION_PLAYER_1_FROM_TEAM_B: // for Player 1 from Team B
                    teamBPlayer1[lastPlayerAction] -= 1;
                    showStatisticsTeamBPlayer1();
                    if (lastPlayerAction == ACTION_ERROR) {
                        decreaseScoreA();
                    } else {
                        decreaseScoreB();
                    }
                    break;
                case ACTION_PLAYER_2_FROM_TEAM_B: // for Player 2 from Team B
                    teamBPlayer2[lastPlayerAction] -= 1;
                    showStatisticsTeamBPlayer2();
                    if (lastPlayerAction == ACTION_ERROR) {
                        decreaseScoreA();
                    } else {
                        decreaseScoreB();
                    }
                    break;
            }
        } else {
            Toast.makeText(this, R.string.toast_no_action, Toast.LENGTH_LONG).show();
        }
        lastPlayerAction = 4;
        lastPlayerId = 4;
    }

    public void resetScore(View view) {
        teamAScore = 0;
        teamBScore = 0;
        teamAPlayer1 = new int[]{0, 0, 0, 0};
        teamAPlayer2 = new int[]{0, 0, 0, 0};
        teamBPlayer1 = new int[]{0, 0, 0, 0};
        teamBPlayer2 = new int[]{0, 0, 0, 0};

        showScores();
        showStatisticsTeamAPlayer1();
        showStatisticsTeamAPlayer2();
        showStatisticsTeamBPlayer1();
        showStatisticsTeamBPlayer2();
    }
}
