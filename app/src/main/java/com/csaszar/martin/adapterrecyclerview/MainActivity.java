package com.csaszar.martin.adapterrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1.RecyclerView beálltása
        recyclerView = findViewById(R.id.recyclerView);
        // Ez adja meg, hogy a listaelemek lineárisan, függőlegesen legyenek elhelyezve.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //2. megadjuk az adatokat
        List<String> nevek = Arrays.asList("Anna","Enikő","Erika","Fanni","Kitti","Dóra");

        //3. Adapter beállítása és összekapcsolása a RecyclerView-val
        myAdapter = new MyAdapter(nevek);
        recyclerView.setAdapter(myAdapter);
    }
}