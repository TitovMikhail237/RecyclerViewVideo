package com.example.recyclerviewvideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Item> items = new ArrayList<>();
    private final RecyclerView.Adapter adapter = new Adapter(this.items);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void add(View view){
        EditText editText = findViewById(R.id.editText);
        this.items.add(new Item(editText.getText().toString()));
        editText.setText("");
        adapter.notifyItemInserted(this.items.size() - 1);
    }
}