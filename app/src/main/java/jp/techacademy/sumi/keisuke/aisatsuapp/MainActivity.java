package jp.techacademy.sumi.keisuke.aisatsuapp;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity{
    Handler mHandler;
    TextView textView;
    int s_morning=2,e_morning=10,s_noon=10,e_noon=18,s_evening=18,e_evening=2;
    int defaluthour=13,defaltminuite=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(buttonClickListener);
        textView = (TextView) findViewById(R.id.textView);

    }


    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showTimePickerDialog();
        }
    };

    //確認





    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, final int hourOfDay, final int minute) {



                        if(hourOfDay >=s_morning && 10 > e_morning){
                            textView.setText("おはよう");
                        }else if(hourOfDay>=s_noon&&hourOfDay<e_noon){
                            textView.setText("こんにちわ");
                        }else if(hourOfDay>=s_evening&&hourOfDay<e_evening){
                            textView.setText("こんばんは");
                        }
                    }
                },
                defaluthour, // 初期値（時間）
                defaltminuite,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
