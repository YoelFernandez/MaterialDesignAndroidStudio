package com.example.materialdesign.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.Adapter.TrendsAdapter;
import com.example.materialdesign.Domains.TrendsDomain;
import com.example.materialdesign.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AboutPerson extends AppCompatActivity {
    FloatingActionButton btn_float;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_person);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_float = findViewById(R.id.btn_float);

        btn_float.setOnClickListener(v->{
            Intent intent = new Intent(this, ActivityProfile.class);
            startActivity(intent);
        });
        recyclerView = findViewById(R.id.recyclerView);

        iniRecyclerView();
        btnNavigation();
    }

    private void btnNavigation() {
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(v->{
            startActivity(new Intent(this, ActivityProfile.class));
        });
    }

    private void iniRecyclerView() {
        ArrayList<TrendsDomain> list = new ArrayList<>();
        list.add(new TrendsDomain("Future in AI, what will tomorrow be like?","the national","trends"));
        list.add(new TrendsDomain("Important point in concluding a work contract","reuters","trends2"));
        list.add(new TrendsDomain("Future in AI, what will tomorrow be like?","the national","trends"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new TrendsAdapter(list));
    }
}