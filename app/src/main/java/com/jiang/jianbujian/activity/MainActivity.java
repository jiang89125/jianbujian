package com.jiang.jianbujian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gc.materialdesign.views.LayoutRipple;
import com.jiang.jianbujian.R;


public class MainActivity extends ActionBarActivity {

    //自定义控件
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private LayoutRipple layoutRipple;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftlistView;
    private String[] menu = new String[]{"跑步", "深蹲", "俯卧撑", "仰卧起坐"};
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        leftlistView = (ListView) findViewById(R.id.left_list);
        toolbar.setTitle("健不健");    //设置标题名称
        toolbar.setSubtitle("多少时间");  //设置标题副名称
        setSupportActionBar(toolbar);  //将TOOLBAR替代为Actionbar
        getSupportActionBar().setHomeButtonEnabled(true);   //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现返回键功能
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,menu);
        leftlistView.setAdapter(arrayAdapter);
        //点击事件
        layoutRipple = (LayoutRipple) findViewById(R.id.myfitness);
        layoutRipple.setRippleSpeed(50);
        layoutRipple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyfitnessActivity.class);
                startActivity(intent);
            }
        });

        layoutRipple = (LayoutRipple) findViewById(R.id.cursor);
        layoutRipple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CursorActivity.class);
                startActivity(intent);
            }
        });

        layoutRipple = (LayoutRipple) findViewById(R.id.eat);
        layoutRipple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EatActivity.class);
                startActivity(intent);
            }
        });

        layoutRipple = (LayoutRipple) findViewById(R.id.beauty);
        layoutRipple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BeautyActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
