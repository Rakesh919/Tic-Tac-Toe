package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton zero0;
    ImageButton zero1;
    ImageButton zero2;
    ImageButton one0;
    ImageButton one1;
    ImageButton one2;
    ImageButton two0;
    ImageButton two1;
    ImageButton two2;

    //matrix a is for X's moves
    int[][] a = new int[3][3];
    //matrix b is for X's moves
    int[][] b = new int[3][3];
    //ct is to count the number of moves, if ct is even then its X's move
    //if ct is odd then it is O's move
    int ct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero0 = findViewById(R.id.zerozero);
        zero1 = findViewById(R.id.zeroone);
        zero2 = findViewById(R.id.zerotwo);
        one0 = findViewById(R.id.onezero);
        one1 = findViewById(R.id.oneone);
        one2 = findViewById(R.id.onetwo);
        two0 = findViewById(R.id.twozero);
        two1 = findViewById(R.id.twoone);
        two2 = findViewById(R.id.twotwo);
    }

    public void apply(int l, int k) {
        if (b[l][k] != 1 && a[l][k] != 1 && ct % 2 == 0) {
            a[l][k] = 1;
            b[l][k] = -1;
            imagechange(l, k);
            ct++;
            checkwin(a, 0);

        } else if (a[l][k] != 1 && b[l][k] != 1 && ct % 2 != 0) {
            b[l][k] = 1;
            a[l][k] = -1;
            imagechange(l, k);
            ct++;
            checkwin(b, 1);

        } else {
            msg();
        }

    }

    public void checkwin(int[][] c, int f) {
        TextView txt = findViewById(R.id.result);
        TextView txt2 = findViewById(R.id.press);
        if ((c[0][0] == 1 && c[1][1] == 1 && c[2][2] == 1) || (c[0][2] == 1 && c[1][1] == 1 && c[2][0] == 1) ||
                (c[0][0] == 1 && c[0][1] == 1 && c[0][2] == 1) || (c[1][0] == 1 && c[1][1] == 1 && c[1][2] == 1) ||
                (c[2][0] == 1 && c[2][1] == 1 && c[2][2] == 1) || (c[0][0] == 1 && c[1][0] == 1 && c[2][0] == 1) ||
                (c[0][1] == 1 && c[1][1] == 1 && c[2][1] == 1) || (c[0][2] == 1 && c[1][2] == 1 && c[2][2] == 1)) {
            showwin(f);
        } else {
            if (ct == 9) {
                txt.setText("It's tie");
                txt2.setText("press restart");
            } else {
                if (f == 0)
                    txt.setText("O's move");
                else if (f == 1)
                    txt.setText("X's move");
            }

        }
    }

    public void msg() {
        Context context = getApplicationContext();
        CharSequence text = "Already Selected";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void showwin(int f) {
        TextView winner = findViewById(R.id.result);
        TextView txt = findViewById(R.id.press);
        if (f == 0) {
            winner.setText("X WINS");
            txt.setText("press restart");
        } else if (f == 1) {
            winner.setText("O WINS");
            txt.setText("press restart");
        }

        makeUnPressable();
    }

    private void makeUnPressable() {

        zero0.setClickable(false);
        zero1.setClickable(false);
        zero2.setClickable(false);
        one0.setClickable(false);
        one1.setClickable(false);
        one2.setClickable(false);
        two0.setClickable(false);
        two1.setClickable(false);
        two2.setClickable(false);
    }

    private void makePressable() {

        zero0.setClickable(true);
        zero1.setClickable(true);
        zero2.setClickable(true);
        one0.setClickable(true);
        one1.setClickable(true);
        one2.setClickable(true);
        two0.setClickable(true);
        two1.setClickable(true);
        two2.setClickable(true);
    }

    public void imagechange(int x, int y) {

        if (ct % 2 == 0) {
            if (x == 0 && y == 0)
                zero0.setImageResource(R.drawable.close);
            else if (x == 0 && y == 1)
                zero1.setImageResource(R.drawable.close);
            else if (x == 0 && y == 2)
                zero2.setImageResource(R.drawable.close);
            else if (x == 1 && y == 0)
                one0.setImageResource(R.drawable.close);
            else if (x == 1 && y == 1)
                one1.setImageResource(R.drawable.close);
            else if (x == 1 && y == 2)
                one2.setImageResource(R.drawable.close);
            else if (x == 2 && y == 0)
                two0.setImageResource(R.drawable.close);
            else if (x == 2 && y == 1)
                two1.setImageResource(R.drawable.close);
            else if (x == 2 && y == 2)
                two2.setImageResource(R.drawable.close);
        } else {
            if (x == 0 && y == 0)
                zero0.setImageResource(R.drawable.circle2);
            else if (x == 0 && y == 1)
                zero1.setImageResource(R.drawable.circle2);
            else if (x == 0 && y == 2)
                zero2.setImageResource(R.drawable.circle2);
            else if (x == 1 && y == 0)
                one0.setImageResource(R.drawable.circle2);
            else if (x == 1 && y == 1)
                one1.setImageResource(R.drawable.circle2);
            else if (x == 1 && y == 2)
                one2.setImageResource(R.drawable.circle2);
            else if (x == 2 && y == 0)
                two0.setImageResource(R.drawable.circle2);
            else if (x == 2 && y == 1)
                two1.setImageResource(R.drawable.circle2);
            else if (x == 2 && y == 2)
                two2.setImageResource(R.drawable.circle2);
        }
    }

    public void initialize() {

        ct = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                a[i][j] = 0;
                b[i][j] = 0;
            }

        zero0.setImageResource(R.drawable.mybutton);
        zero1.setImageResource(R.drawable.mybutton);
        zero2.setImageResource(R.drawable.mybutton);
        one0.setImageResource(R.drawable.mybutton);
        one1.setImageResource(R.drawable.mybutton);
        one2.setImageResource(R.drawable.mybutton);
        two0.setImageResource(R.drawable.mybutton);
        two1.setImageResource(R.drawable.mybutton);
        two2.setImageResource(R.drawable.mybutton);

    }

    public void zerozero(View view) {
        apply(0, 0);
    }

    public void zeroone(View view) {
        apply(0, 1);
    }

    public void zerotwo(View view) {
        apply(0, 2);
    }

    public void onezero(View view) {
        apply(1, 0);
    }

    public void oneone(View view) {
        apply(1, 1);
    }

    public void onetwo(View view) {
        apply(1, 2);
    }

    public void twozero(View view) {
        apply(2, 0);
    }

    public void twoone(View view) {
        apply(2, 1);
    }

    public void twotwo(View view) {
        apply(2, 2);
    }

    public void restart(View view) {
        initialize();
        TextView txt = findViewById(R.id.result);
        txt.setText("x's move");
        TextView txt2 = findViewById(R.id.press);
        txt2.setText("");
        makePressable();
    }
}