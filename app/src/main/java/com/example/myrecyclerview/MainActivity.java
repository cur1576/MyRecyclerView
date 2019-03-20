package com.example.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;

    ArrayList<Person> personArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personArrayList = new ArrayList<>();
        personArrayList.addAll(Arrays.asList(
                new Person("Christian","Berlin"),
                new Person("Frank", "Berlin"),
                new Person("Ronny","Berlin"),
                new Person("Sebastian", "Offenbach"),
                new Person("Esin","Hamburg"),
                new Person("Klaus", "Braunschweig")
        ));

        recyclerView = findViewById(R.id.recyclerView);
        rvLayoutManager = new LinearLayoutManager(this);
        rvAdapter = new RvAdapter();

        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }
}
