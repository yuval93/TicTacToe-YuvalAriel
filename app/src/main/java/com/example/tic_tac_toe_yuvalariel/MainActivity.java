package com.example.tic_tac_toe_yuvalariel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener   {

    Button[] btn = new Button[9];
    Button playAgain;
    boolean activePlayer;
    int[] gameState={2,2,2,2,2,2,2,2,2}; // 2-empty, p0-0, p1-1
    ImageView imgView;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playAgain= findViewById(R.id.play_again);
        playAgain.setOnClickListener(this);

        imgView=(ImageView) findViewById(R.id.empty_image);

        Button[] btn = new Button[9];

        for(int i=0; i<btn.length; i++) {
            String buttonID = "btn_"+i;
            int resourceID= getResources().getIdentifier(buttonID,"id",getPackageName());
            btn[i]=(Button) findViewById(resourceID);
            btn[i].setText("");
            btn[i].setOnClickListener(this);

        }

        activePlayer=true;//x
    }

    @Override
    public void onClick(View v) {

        if(!((Button)v).getText().toString().equals(""))
            return;

        count++;

        String buttonID= v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer= Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length()));

        if(activePlayer)
        {
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.parseColor("#FFFFFF"));
            gameState[gameStatePointer]=0;
        }
        else
        {
            ((Button)v).setText("O");
            ((Button)v).setTextColor(Color.parseColor("#2d3436"));
            gameState[gameStatePointer]=1;
        }
        if(isWinner())
        {
            if(activePlayer) {
                Drawable  drawable  = getResources().getDrawable(R.drawable.xwin);
                imgView.setImageDrawable(drawable);
            }
            else if(!activePlayer)
            {
                Drawable  drawable = getResources().getDrawable(R.drawable.owin);
                imgView.setImageDrawable(drawable);
            }
        }
        else if (count==9)
        {
            Drawable  drawable  = getResources().getDrawable(R.drawable.nowin);
            imgView.setImageDrawable(drawable);
        }
        else
            activePlayer=!activePlayer;

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain();
            }
        });

    }

    public boolean isWinner()
    {
        for(int i=0; i< btn.length;i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            btn[i] = (Button) findViewById(resourceID);
        }

        if(gameState[0]==gameState[1] && gameState[1]==gameState[2] && gameState[0]!=2) {

            btn[0].setTextColor(Color.parseColor("#2ecc71"));
            btn[1].setTextColor(Color.parseColor("#2ecc71"));
            btn[2].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[3]==gameState[4] && gameState[4]==gameState[5] && gameState[3]!=2) {
            btn[3].setTextColor(Color.parseColor("#2ecc71"));
            btn[4].setTextColor(Color.parseColor("#2ecc71"));
            btn[5].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[6]==gameState[7] && gameState[7]==gameState[8] && gameState[6]!=2) {
            btn[6].setTextColor(Color.parseColor("#2ecc71"));
            btn[7].setTextColor(Color.parseColor("#2ecc71"));
            btn[8].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[0]==gameState[3] && gameState[3]==gameState[6] && gameState[0]!=2) {
            btn[0].setTextColor(Color.parseColor("#2ecc71"));
            btn[3].setTextColor(Color.parseColor("#2ecc71"));
            btn[6].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[1]==gameState[4] && gameState[4]==gameState[7] && gameState[1]!=2) {
            btn[1].setTextColor(Color.parseColor("#2ecc71"));
            btn[4].setTextColor(Color.parseColor("#2ecc71"));
            btn[7].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[2]==gameState[5] && gameState[5]==gameState[8] && gameState[2]!=2) {
            btn[2].setTextColor(Color.parseColor("#2ecc71"));
            btn[5].setTextColor(Color.parseColor("#2ecc71"));
            btn[8].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[0]==gameState[4] && gameState[4]==gameState[8] && gameState[0]!=2) {
            btn[0].setTextColor(Color.parseColor("#2ecc71"));
            btn[4].setTextColor(Color.parseColor("#2ecc71"));
            btn[8].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        else if(gameState[2]==gameState[4] && gameState[4]==gameState[6] && gameState[2]!=2) {
            btn[2].setTextColor(Color.parseColor("#2ecc71"));
            btn[4].setTextColor(Color.parseColor("#2ecc71"));
            btn[6].setTextColor(Color.parseColor("#2ecc71"));
            return true;
        }
        return false;
    }

    public void playAgain()
    {
        count=0;
        activePlayer=true;
        for(int i=0; i< btn.length;i++) {
            String buttonID = "btn_"+i;
            int resourceID= getResources().getIdentifier(buttonID,"id",getPackageName());
            btn[i]=(Button) findViewById(resourceID);
            gameState[i] = 2;
            btn[i].setText("");
            Drawable  drawable = getResources().getDrawable(R.drawable.empty);
            imgView.setImageDrawable(drawable);
        }
    }

}