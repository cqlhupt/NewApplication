package com.example.lh.newapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SecondActivity.this, "You click Button2", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_VIEW);                         //指定action
                intent.setData(Uri.parse("http://www.baidu.com"));                   //set方法，接受一个uri字符串为参数，其实就是网址
                startActivity(intent);
            }
        });

        /*Button button3=(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.second,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_A:
                Toast.makeText(this,"You Click A",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_B:
                Toast.makeText(this,"You Click B",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
