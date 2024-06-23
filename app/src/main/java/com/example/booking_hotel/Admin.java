package com.example.booking_hotel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final Spinner dropdown=findViewById(R.id.spinner);
        String[] items=new String[]{"Villa-1","Villa-2","Villa-3","Villa-4","Villa-5"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);
        MyDb myDb=new MyDb(this);
        Button all=findViewById(R.id.button8);
        final SQLiteDatabase db=myDb.getWritableDatabase();
        final SQLiteDatabase dbr=myDb.getReadableDatabase();
        final Button b1=findViewById(R.id.button5);
        Button b2=findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbr.rawQuery("SELECT * FROM rooms",null);
                StringBuffer buffer=new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("Vila:  "+c.getString(0)+"\n");
                    buffer.append("Khách hàng: "+c.getString(1)+"\n");
                    buffer.append("Ngày bắt đầu: "+c.getString(2)+"\n");
                    buffer.append("Thuê bao nhiêu ngày:  "+c.getString(3)+"\n");
                    buffer.append("===============================" +"\n");
                }
                showMessage("Chi tiết phòng",buffer.toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Room=dropdown.getSelectedItem().toString();
                String table="rooms";
                String where="room_no=?";
                db.delete(table,where,new String[]{Room});
                Toast.makeText(getApplicationContext(),"DELETED ROOM INFO OF "+Room,Toast.LENGTH_SHORT).show();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cc=dbr.rawQuery("SELECT * FROM Customer",null);
                StringBuffer buffer=new StringBuffer();
                while (cc.moveToNext())
                {
                    buffer.append("Họ tên: "+cc.getString(0)+"\n");
                    buffer.append("Tài khoản: "+cc.getString(1)+"\n");
                    buffer.append("Mật khẩu: "+cc.getString(2)+"\n");
                    buffer.append("Giới tính: "+cc.getString(3)+"\n");
                    buffer.append("===============================" +"\n");
                    //buffer.append("Start Date"+cc.getString(4)+"\n");
                    //buffer.append("End Date"+cc.getString(5)+"\n");
                }
                showMessage("Khách hàng đã đăng ký",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String message) { AlertDialog.Builder builder=new AlertDialog.Builder(this); builder.setCancelable(true); builder.setTitle(title); builder.setMessage(message); builder.show(); }

}