package hu.adri.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView user,gep;
    private TextView userScoreOut,gepScoreOut;
    private Button koBtn,papirBtn,olloBtn;
    private Random r;
    private int gepValasztott;
    private int userChoiceValue;
    private int userScore;
    private int gepScore;
    private AlertDialog alert;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.rock);

                userChoiceValue=1;
                Valasztott();
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.paper);

                userChoiceValue=2;
                Valasztott();
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.scissors);

                userChoiceValue=3;
                Valasztott();
            }
        });
    }

    private void init(){
        this.user=findViewById(R.id.userChoice);
        this.gep=findViewById(R.id.botChoice);
        this.userScoreOut=findViewById(R.id.emberScore);
        this.gepScoreOut=findViewById(R.id.gepScore);
        this.koBtn=findViewById(R.id.koBtn);
        this.papirBtn=findViewById(R.id.papirBtn);
        this.olloBtn=findViewById(R.id.olloBtn);
        this.r=new Random();
        this.gepValasztott=r.nextInt(2)+1;
        this.userScore=0;
        this.gepScore=0;
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnél új játékot?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gepValasztott=r.nextInt(2)+1;
                        userScore=0;
                        gepScore=0;
                        user.setImageResource(R.drawable.rock);
                        gep.setImageResource(R.drawable.rock);
                        userScoreOut.setText("0");
                        gepScoreOut.setText("0");
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                })
                .setTitle("Játék vége!")
                .setCancelable(false);
        alert = builder.create();
    }

    private void Valasztott(){
        switch(gepValasztott){
            case 1: gep.setImageResource(R.drawable.rock);break;
            case 2: gep.setImageResource(R.drawable.paper); break;
            case 3: gep.setImageResource(R.drawable.scissors);break;
            default: break;
        }
        KiNyert();
    }

    private void KiNyert(){
        if(userChoiceValue==1)
        {
            if(gepValasztott==1)
            {
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
            }
            else if(gepValasztott==2)
            {
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                gepScore++;
                gepScoreOut.setText(gepScore+"");
                if(gepScore>=3){
                    JatekVege();
                }
            }
            else{
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                userScore++;
                userScoreOut.setText(userScore+"");
                if(userScore>=3 ){
                    JatekVege();
                }
            }
        }
        else if(userChoiceValue==2)
        {
            if(gepValasztott==1)
            {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                userScore++;
                userScoreOut.setText(userScore+"");
                if(userScore>=3){
                    JatekVege();
                }
            }
            else if(gepValasztott==2)
            {
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                gepScore++;
                gepScoreOut.setText(gepScore+"");
                if(gepScore>=3){
                    JatekVege();
                }
            }
        }
        else{
            if(gepValasztott==1)
            {
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                gepScore++;
                gepScoreOut.setText(gepScore+"");
                if(gepScore>=3){
                    JatekVege();
                }


            }
            else if(gepValasztott==2)
            {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                userScore++;
                userScoreOut.setText(userScore+"");
                if(userScore>=3){
                    JatekVege();
                }
            }
            else{
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
            }
        }
        gepValasztott=r.nextInt(2)+1;
    }

    private void JatekVege(){
        alert.show();
    }


}