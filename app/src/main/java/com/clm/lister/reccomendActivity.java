package com.clm.lister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class reccomendActivity extends AppCompatActivity {
    ArrayList<dish> dishArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reccomend);

        dishArrayList= new ArrayList<>();

        dishArrayList.add(new dish("Sandwich","Aroma",20.5));
        dishArrayList.add(new dish("Pasta","Aroma",39));
        dishArrayList.add(new dish("Coffee","Aroma",8));

        ListView dishLV = (ListView) findViewById(R.id.recommendLV);
        ArrayAdapter<dish> arrayAdapter = new ArrayAdapter<dish>(this,  R.layout.options_list_item_1, R.id.textTV , dishArrayList);
        dishLV.setAdapter(arrayAdapter);

        dishLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //onClick

                Toast.makeText(reccomendActivity.this ,"" + dishArrayList.get(position).getDishPrice(),Toast.LENGTH_SHORT).show();
            }
        });

        dishLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //onLongClick
                Toast.makeText(reccomendActivity.this ,dishArrayList.get(position).getRestrauntName(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
