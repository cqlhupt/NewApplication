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

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);        //强制转型
        button1.setOnClickListener(new View.OnClickListener() {      //监听器，创建一个新的按钮监听器
            @Override
            public void onClick(View v) {                           //该方法重写于监听器内部，创建一个点击事件
                //Toast.makeText(FirstActivity.this,"别乱按！！！-_-|||",Toast.LENGTH_SHORT).show();
                //finish();                                           //finish销毁当前活动
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);   //用显式Intent穿梭于活动之间
                Intent intent=new Intent("com.example.activitytest.ACTION_START");    //用隐式Intent，要求匹配action和category,指定action
                intent.addCategory("com.example.activitytest.MY_CATEGORY");                    //用addCategory（）方法添加一个category,添加的category必须包含于AndroidManifest文件相应的活动声明中

                startActivity(intent);                                //调用Activity类的startActivity方法来启动传入的活动
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {                 //创建菜单选项
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {            //定义菜单响应事件
        switch (item.getItemId()) {                                   //用item.getItemId()方法判断点击的是哪个菜单按钮
            case R.id.add_item:
                Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nazo_item:
                //Toast.makeText(this,"Do you want rename it?",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(FirstActivity.this,ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.tel_item:
                Intent intent1=new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:10086"));
                startActivity(intent1);
                break;
            default:
        }
    return true;
    }

}
