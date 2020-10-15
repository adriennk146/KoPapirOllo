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

    private ImageView user, gep, userE1, userE2, userE3, gepE1, gepE2, gepE3;
    private TextView dontetlen;
    private Button koBtn, papirBtn, olloBtn;
    private Random r;
    private int gepValasztott;
    private int userChoiceValue;
    private AlertDialog alert;
    private AlertDialog.Builder builder;
    private int dontetlenDb;
    private int userElet;
    private int gepElet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.rock);

                userChoiceValue = 1;
                Valasztott();
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.paper);

                userChoiceValue = 2;
                Valasztott();
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setImageResource(R.drawable.scissors);

                userChoiceValue = 3;
                Valasztott();
            }
        });
    }

    private void init() {
        this.userE1 = findViewById(R.id.emberH1);
        this.userE2 = findViewById(R.id.emberH2);
        this.userE3 = findViewById(R.id.emberH3);
        this.gepE1 = findViewById(R.id.gepH1);
        this.gepE2 = findViewById(R.id.gepH2);
        this.gepE3 = findViewById(R.id.gepH3);
        this.user = findViewById(R.id.userChoice);
        this.gep = findViewById(R.id.botChoice);
        this.koBtn = findViewById(R.id.koBtn);
        this.papirBtn = findViewById(R.id.papirBtn);
        this.olloBtn = findViewById(R.id.olloBtn);
        this.r = new Random();
        this.userElet = 3;
        this.gepElet = 3;
        this.dontetlen = findViewById(R.id.dontetlenDb);
        this.dontetlenDb = 0;
        this.builder = new AlertDialog.Builder(MainActivity.this);
        this.builder.setMessage("Szeretnél új játékot?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dontetlenDb = 0;
                        userElet = 3;
                        gepElet = 3;
                        dontetlen.setText("0");
                        user.setImageResource(R.drawable.rock);
                        gep.setImageResource(R.drawable.rock);
                        userE1.setImageResource(R.drawable.heart2);
                        userE2.setImageResource(R.drawable.heart2);
                        userE3.setImageResource(R.drawable.heart2);
                        gepE1.setImageResource(R.drawable.heart2);
                        gepE2.setImageResource(R.drawable.heart2);
                        gepE3.setImageResource(R.drawable.heart2);
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

    private void Valasztott() {
        gepValasztott = r.nextInt(2) + 1;
        switch (gepValasztott) {
            case 1:
                gep.setImageResource(R.drawable.rock);
                break;
            case 2:
                gep.setImageResource(R.drawable.paper);
                break;
            case 3:
                gep.setImageResource(R.drawable.scissors);
                break;
            default:
                break;
        }
        KiNyert();
    }

    private void KiNyert() {
        if (userChoiceValue == 1) {
            if (gepValasztott == 1) {
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
                dontetlenDb++;
                dontetlen.setText(dontetlenDb + "");

            } else if (gepValasztott == 2) {
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                EletMinuszUser();
            } else {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                EletMinuszGep();
            }
        } else if (userChoiceValue == 2) {
            if (gepValasztott == 1) {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                EletMinuszGep();
            } else if (gepValasztott == 2) {
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
                dontetlenDb++;
                dontetlen.setText(dontetlenDb + "");
            } else {
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                EletMinuszUser();
            }
        } else {
            if (gepValasztott == 1) {
                Toast.makeText(this, "A gép nyert!", Toast.LENGTH_LONG).show();
                EletMinuszUser();
            } else if (gepValasztott == 2) {
                Toast.makeText(this, "Te nyertél!", Toast.LENGTH_LONG).show();
                EletMinuszGep();
            } else {
                Toast.makeText(this, "Döntetlen!", Toast.LENGTH_LONG).show();
                dontetlenDb++;
                dontetlen.setText(dontetlenDb + "");
            }
        }
    }

    private void EletMinuszGep() {
        switch (gepElet) {
            case 3:
                gepE3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gepE2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                gepE1.setImageResource(R.drawable.heart1);
                break;
        }
        gepElet--;
        if (gepElet == 0) {
            JatekVege();
        }
    }

    private void EletMinuszUser() {
        switch (userElet) {
            case 3:
                userE3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                userE2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                userE1.setImageResource(R.drawable.heart1);
                break;
        }
        userElet--;
        if (userElet == 0) {
            JatekVege();
        }
    }

    private void JatekVege() {
        alert.show();
    }
}