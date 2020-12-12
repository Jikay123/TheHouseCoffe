package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity  {

    RecyclerView recycleuudai, recyclecapnhat,recycle_lover;
    itemAdapter itemAdapter;
    private ImageView imgNotification;
    private Button button;
    private TextView txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button = (Button) findViewById(R.id.button);
        imgNotification = (ImageView) findViewById(R.id.imgNotification);
        txtemail = (TextView) findViewById(R.id.txtemail);
        List<item> uudailist = new ArrayList<>();
        uudailist.add(new item("Giảm 50%, thèm gì gọi nhé Nhà mang tới liền","Hòa vào không khí siêu sale cuối năm, mời team mình ghỉ tay gọi món yêu thích, Nhà giảm 50% khi nhập mã MERRY50 - để lên tinh thần săn sale...","Chi tiết",R.drawable.anh3));
        uudailist.add(new item("Top 10 cửa hàng The Coffee House bạn nên trải nghiệm tại Hà Nội","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Chi tiết",R.drawable.anh5));
        uudailist.add(new item("Team Hà Nội gọi combo trà mát, tặng ngay ly xịn xò","Nhận ngay ly nhựa xin xò 2 lớp phiên bản nắng vàng và biển xanh dung tích 450ml khi mua combo 2 ly Trà sữa Mắc ca trân châu trắng hoặc 2 ly Trà đen Macchiato size L đó","Chi tiết",R.drawable.anh6));
        uudailist.add(new item("Gói combo siêu khủng tỉnh táo bắt đầu ngày mới","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Order ngay",R.drawable.anh7));
        uudailist.add(new item("7 NGÀY FREE UPSIZE - YÊU BẠN NỮ KHÔNG THỂ NÀO CAI","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Order ngay",R.drawable.anh8));

        List<item> capnhatlist = new ArrayList<>();
        capnhatlist.add(new item("Giảm 50%, thèm gì gọi nhé Nhà mang tới liền","Hòa vào không khí siêu sale cuối năm, mời team mình ghỉ tay gọi món yêu thích, Nhà giảm 50% khi nhập mã MERRY50 - để lên tinh thần săn sale...","Chi tiết",R.drawable.anh3));
        capnhatlist.add(new item("Top 10 cửa hàng The Coffee House bạn nên trải nghiệm tại Hà Nội","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Chi tiết",R.drawable.anh5));
        capnhatlist.add(new item("Team Hà Nội gọi combo trà mát, tặng ngay ly xịn xò","Nhận ngay ly nhựa xin xò 2 lớp phiên bản nắng vàng và biển xanh dung tích 450ml khi mua combo 2 ly Trà sữa Mắc ca trân châu trắng hoặc 2 ly Trà đen Macchiato size L đó","Chi tiết",R.drawable.anh6));
        capnhatlist.add(new item("Gói combo siêu khủng tỉnh táo bắt đầu ngày mới","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Order ngay",R.drawable.anh7));
        capnhatlist.add(new item("7 NGÀY FREE UPSIZE - YÊU BẠN NỮ KHÔNG THỂ NÀO CAI","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Order ngay",R.drawable.anh8));

        List<item>  loverlist = new ArrayList<>();
        loverlist.add(new item("Giảm 50%, thèm gì gọi nhé Nhà mang tới liền","Hòa vào không khí siêu sale cuối năm, mời team mình ghỉ tay gọi món yêu thích, Nhà giảm 50% khi nhập mã MERRY50 - để lên tinh thần săn sale...","Chi tiết",R.drawable.anh3));
        loverlist.add(new item("Top 10 cửa hàng The Coffee House bạn nên trải nghiệm tại Hà Nội","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Chi tiết",R.drawable.anh5));
        loverlist.add(new item("Team Hà Nội gọi combo trà mát, tặng ngay ly xịn xò","Nhận ngay ly nhựa xin xò 2 lớp phiên bản nắng vàng và biển xanh dung tích 450ml khi mua combo 2 ly Trà sữa Mắc ca trân châu trắng hoặc 2 ly Trà đen Macchiato size L đó","Chi tiết",R.drawable.anh6));
        loverlist.add(new item("Gói combo siêu khủng tỉnh táo bắt đầu ngày mới","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Order ngay",R.drawable.anh7));
        loverlist.add(new item("7 NGÀY FREE UPSIZE - YÊU BẠN NỮ KHÔNG THỂ NÀO CAI","Tuần này, The Coffee House thật háo hức để gửi tặng một nửa Thế giới xinh đẹp chương trình vô cùng ngọt ngào 7 ngày Free Upsize - Yêu bạn nữ...","Order ngay",R.drawable.anh8));

        setRecycle_uudai(uudailist);
        setRecyclecapnhat(capnhatlist);
        setRecycle_lover(loverlist);
        imgNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Notification.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }
        });
        //Đăng nhập ẩn button login
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            button.setVisibility(View.GONE);
            String email  = user.getEmail();
            txtemail.setText(email);
        }

        imgNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Notification.class);
                        startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.news);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.news:
//                        startActivity(new Intent(getApplicationContext(),Home.class));
//                        overridePendingTransition(0,0);
                        return true;
                    case R.id.delivery:
                        startActivity(new Intent(getApplicationContext(),orderScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.store:
                        startActivity(new Intent(getApplicationContext(),store_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(),account_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void setRecycle_uudai(List<item> itemList ){
        recycleuudai=findViewById(R.id.recycle_uudai);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recycleuudai.setLayoutManager(layoutManager);
        itemAdapter = new itemAdapter(this,itemList);
        recycleuudai.setAdapter(itemAdapter);
    }
    public void setRecyclecapnhat(List<item> itemList ){
        recyclecapnhat=findViewById(R.id.recycle_capnhat);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclecapnhat.setLayoutManager(layoutManager);
        itemAdapter = new itemAdapter(this,itemList);
        recyclecapnhat.setAdapter(itemAdapter);
    }
    public void setRecycle_lover(List<item> itemList ){
        recycle_lover=findViewById(R.id.recycle_lover);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recycle_lover.setLayoutManager(layoutManager);
        itemAdapter = new itemAdapter(this,itemList);
        recycle_lover.setAdapter(itemAdapter);
    }


}