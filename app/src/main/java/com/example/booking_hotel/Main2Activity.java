package com.example.booking_hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    GridView gridView;

    String[] facilities = {"Villa 1: Tran Duy Villa R14","Villa 2: Tran Duy City Homes 27","Villa 3: Tran Duy City Homes 38","Villa 4: Tran Duy Villa 1","Villa 5: Tran Duy City Villa 2", "Villa 6: Biệt thự C3"};
    String[] text={
            "– Sinh hoạt quây quần bên nhau với phòng khách rộng rãi và hiện đại.\n" +
                    "– Tuyệt vời hơn khi bạn có thể nấu nướng, thoải mái thưởng thức hải sản tại biệt thự với nhà bếp đầy đủ tiện nghi.\n" +
                    "– Khuôn viên biệt thự có cả không gian làm tiệc BBQ cho cả gia đình bạn nữa nhé!\n" +
                    "– Có khu vui chơi trẻ em ",
            "– Villa mini cách bãi sau chỉ 300m, CITY HOMES 27 hứa hẹn sẽ đem lại cho bạn những giây phút tuyệt vời \n" +
                    "– Phòng khách thoáng mát",
            "4 phòng ngủ đầy đủ tiện nghi\n" +
                    "Thích hợp cho gia đình 15 người\n" +
                    "\uD83C\uDFE1 Y như nhà mình, tiện nghi sinh hoạt, bếp núc, bbq,..\n" +
                    "Cách bãi tắm chỉ 5 phút đi bộ, cách Quảng Trường Thùy Vân 600m, cách mũi Nghinh Phong, Tượng Chúa Giang Tay 700m",
            "Biệt thự 4 phòng ngủ thoáng mát, rộng rãi, phục vụ nhiệt tình, rất đáng để bạn nghỉ dưỡng cùng gia đình hoặc nhóm bạn với tiện nghi đầy đủ (Bếp nướng, máy lạnh, tivi, tủ lạnh, máy giặt,…)",
            "Vị Trí Gần Bãi Tắm Thùy Vân\n" +
                    "Cách Bãi Sau 400m, cách chợ Xóm Lưới 2km\n" +
                    "Thích hợp nghỉ dưỡng, tụ tập bạn bè, gia đình\n" +
                    "Sở hữu vị trí đẹp lưng tựa núi mặt hướng biển, biệt thự C3 với những tiện nghi và chất lương tuyệt hảo, chắc chắn sẽ đem lại cho bạn những phút giây tuyệt vời khi lưu trú tại đây\n" +
                    "\n" +
                    "Vị Trí Cực Đẹp \n" +
                    "– Cách bãi trước chỉ 1 phút đi bộ\n" +
                    "– Thích hợp nghỉ dưỡng, tụ tập bạn bè, gia đình\n" +
                    "– Chỗ đậu xe 4 – 16 chỗ\n" +
                    "7 Phòng Ngủ Sang Trọng\n" +
                    "– 7 phòng ngủ\n" +
                    "– Có bổ sung nệm, gối mền thêm cho du khách\n" +
                    "– Có nhà bếp đầy đủ dụng cụ nấu ăn, phòng khách rộng rãi\n" +
                    "– Thích hợp đoàn từ 15 – 20 khách\n" +
                    "Hồ Bơi\n" +
                    "– Hồ bơi rộng\n" +
                    "– BBQ ngoài trời"};
    int[] facimages = {R.drawable.vtht1,R.drawable.vlht2,R.drawable.vlht3,R.drawable.vlht4,R.drawable.vlht5,R.drawable.vlht7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), GriDItemActivity.class);
                intent.putExtra("name",facilities[i]);
                intent.putExtra("image",facimages[i]);
                intent.putExtra("msg",text[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return facimages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.facilities);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(facilities[i]);
            image.setImageResource(facimages[i]);
            return view1;
        }
    }
}
