package com.example.kh.sharepreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kh.sharepreferencesdemo.viewHolder.holder_main_activity;

public class MainActivity extends AppCompatActivity {
    com.example.kh.sharepreferencesdemo.viewHolder.holder_main_activity holder ;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        holder = new holder_main_activity();
        holder.txt = (TextView) findViewById(R.id.txtshowdata);
        holder.btnsharedpreferences = (Button) findViewById(R.id.btnsharedpreferences);
        holder.btnshowdata = (Button) findViewById(R.id.btnshowdata);

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        holder.btnsharedpreferences.setOnClickListener(onclicklistener);
        holder.btnshowdata.setOnClickListener(onclicklistener);

    }
    View.OnClickListener onclicklistener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnsharedpreferences:
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("a","vo cong vinh");
                    editor.commit();
                    break;
                case R.id.btnshowdata:
                  String name =  sharedPreferences.getString("a","name not found");
                    holder.txt.setText(name);
                    break;
            }
        }
    };
}
