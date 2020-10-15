package hu.adri.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView userScore,gepScore;
    private Button koBtn,papirBtn,olloBtn;
    private Random r;
    private int gepValasztott;
    private boolean valasztott;
    private int userChoiceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.rock);
                valasztott=true;
                userChoiceValue=1;
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.paper);
                valasztott=true;
                userChoiceValue=2;
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.scissors);
                valasztott=true;
                userChoiceValue=3;
            }
        });
        if(valasztott){
            switch(gepValasztott){
                case 1: gep.setImageResource(R.drawable.rock);break;
                case 2: gep.setImageResource(R.drawable.paper); break;
                case 3: gep.setImageResource(R.drawable.scissors);break;
                default: break;
            }
            KiNyert();
        }
    }

    private void init(){
        this.user=findViewById(R.id.userChoice);
        this.gep=findViewById(R.id.botChoice);
        this.userScore=findViewById(R.id.emberScore);
        this.gepScore=findViewById(R.id.gepScore);
        this.koBtn=findViewById(R.id.koBtn);
        this.papirBtn=findViewById(R.id.papirBtn);
        this.olloBtn=findViewById(R.id.olloBtn);
        this.valasztott=false;
        this.gepValasztott=r.nextInt(2)+1;
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
                //TODO:
            }
            else{
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                //TODO:
            }
        }
        else if(userChoiceValue==2)
        {
            if(gepValasztott==1)
            {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                //TODO:

            }
            else if(gepValasztott==2)
            {
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                //TODO:
            }
        }
        else{
            if(gepValasztott==1)
            {
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                //TODO:


            }
            else if(gepValasztott==2)
            {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                //TODO:


            }
            else{
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
            }
        }
    }


}