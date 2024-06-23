package com.example.booking_hotel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AfterBooking extends AppCompatActivity {
    private final String Channel_ID="personal_notification";
    private final int NOTIFICATION_ID=001;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyDb myDb=new MyDb(this);
        SQLiteDatabase db=myDb.getReadableDatabase();
        setContentView(R.layout.activity_after_booking);
        Bundle bundle=getIntent().getExtras();
        int j=0;
        final String usn=bundle.getString("Username");
        final String Room_no=bundle.getString("Room_no");
        //int numberofdays=getIntent().getExtras().getInt("Number_of_days");
        String nom=getIntent().getExtras().getString("Number_of_days");
        int nn=Integer.parseInt(nom);
        switch (Room_no)
        {
            case "Villa-1":
                j=450000;
                break;
            case "Villa-2":
                j=700000;
                break;
            case "Villa-3":
                j=1000000;
                break;
            case "Villa-4":
                j=1500000;
                break;
            case "Villa-5":
                j=2000000;
                break;
            default:
                j=0;
        }
        int num=nn*j;
        TextView text=findViewById(R.id.textView18);
        text.setText("Tổng tiền đặt cho phòng \n"+String.valueOf(num));
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,Channel_ID);
        builder.setSmallIcon(R.drawable.ic_hotel_book);
        builder.setContentTitle("BNN VillaHotel");
        builder.setContentText("Booked" +
                " "+Room_no);


        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
        TextView tt=findViewById(R.id.textView13);
        tt.setText("Xin cám ơn đã sử dụng dịch vụ của chúng tôi! Chúc quý khách có chuyến đi vui vẻ");
        Button butt=findViewById(R.id.button4);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(j);
            }
        });
    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}