package com.example.android.mc4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button bt1, bt2;
    TextView p1,p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        img = (ImageView) findViewById(R.id.imageView);
        p1 = (TextView) findViewById(R.id.process1);
        p2 = (TextView) findViewById(R.id.process2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        img.post(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageResource(R.drawable.flower1);
                                 new CountDownTimer(5000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            p1.setText("running...");
                                        }
                                        @Override
                                        public void onFinish() {
                                            p1.setText("Finished");
                                            img.setImageResource(R.drawable.flower1);
                                        }
                                    }.start();
                            }
                        });

                    }
                }).start();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        img.post(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageResource(R.drawable.flower2);
                                new CountDownTimer(5000,1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        p2.setText("running...");
                                    }
                                    @Override
                                    public void onFinish() {
                                        p2.setText("Finished");
                                        img.setImageResource(R.drawable.flower2);
                                    }
                                }.start();
                            }
                        });
                    }
                }).start();
            }
        });
    }
}