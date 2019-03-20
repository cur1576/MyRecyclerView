package com.example.myrecyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;

    static ArrayList<Person> personArrayList;

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
                new Person("Klaus", "Braunschweig"),
                new Person("Christian","Berlin"),
                new Person("Frank", "Berlin"),
                new Person("Ronny","Berlin"),
                new Person("Sebastian", "Offenbach"),
                new Person("Esin","Hamburg"),
                new Person("Klaus", "Braunschweig")
        ));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                       @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10,10,10,10);
            }

            @Override
            public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
                Paint paintCyan = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintCyan.setColor(Color.CYAN);
                paintCyan.setStyle(Paint.Style.STROKE);
                paintCyan.setStrokeWidth(5);
                for(int i=0;i<parent.getChildCount();i++){
                    View child = parent.getChildAt(i);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        c.drawRoundRect(layoutManager.getDecoratedLeft(child)+10,
                                layoutManager.getDecoratedTop(child)+10,
                                layoutManager.getDecoratedRight(child)-10,
                                layoutManager.getDecoratedBottom(child)-10,15,15,paintCyan);
                    }
                }
            }
        });
//        rvLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvLayoutManager = new GridLayoutManager(this, 3);
        rvAdapter = new RvAdapter();

        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }
}
