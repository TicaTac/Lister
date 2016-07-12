package com.clm.lister;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("Send Email");

        arrayList.add("Set Time");
        arrayList.add("Set Date");

        // attach to list view
        final ListView settingsLV=(ListView) findViewById(R.id.settingsLV);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.options_list_item_2,R.id.settingTV,arrayList);
        settingsLV.setAdapter(arrayAdapter);
        settingsLV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SettingsActivity.this,arrayList.get(position),Toast.LENGTH_SHORT).show();
                // menu
                switch (arrayList.get(position)){
                    case "Set Time": // open set time dialog

                     //   break;
                    case "Set Date":// open set date dialog

                        //DatePickerDialog dpd=new DatePickerDialog(SettingsActivity.this, DatePickerDialog.OnDateSetListener(){
                            

                       // },2013, 0 ,0);

                     //   dpd.show();

                        //   break;
                    default:
                        Toast.makeText(SettingsActivity.this,"Default",Toast.LENGTH_SHORT).show();
                        break;

                }


            }
        });



    }
    public void onBackPressed() {
        Toast.makeText(SettingsActivity.this,"Back Pressed - Are You Sure??",Toast.LENGTH_SHORT).show();
        finish();
        //super.onBackPressed();
    }

}
