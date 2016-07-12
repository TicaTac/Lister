package com.clm.lister;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a list array, load values, link to an adapter and xml ,get input
        final ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("Send Email");
        arrayList.add("Add to Contacts");
        arrayList.add("Alarm Clock");
        arrayList.add("Rest");
        arrayList.add("Call Me");
        arrayList.add("Find My Location");
        arrayList.add("Settings");
        // attach to list view
        final ListView mainLV=(ListView) findViewById(R.id.mainLV);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.options_list_item_1,R.id.textTV,arrayList);
        mainLV.setAdapter(arrayAdapter);
        mainLV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arrayList.get(position),Toast.LENGTH_SHORT).show();
                menu(arrayList.get(position));

            }
        });




    }

    protected void menu(String action){
        switch (action) {
            case "Send Email" :
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:lior.keshet@gmail.com")); // only email apps should handle this
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Dear");

                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }

                break;

            case "Add to Contacts":
            case "Alarm Clock":
            case "Rest":
                Intent reccomendIntent= new Intent(this, reccomendActivity.class);
                startActivityForResult (reccomendIntent,1);
                break;
            case "Call Me":
            case "Find My Location":
            case "Settings":
                    Intent settingsIntent= new Intent(this, SettingsActivity.class);
                    startActivityForResult (settingsIntent,1);

                  //  finish();

                break;
            //

            default:
                Toast.makeText(MainActivity.this,"::"+action,Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(MainActivity.this,"ReqCode= "+requestCode+" ResCode= "+resultCode,Toast.LENGTH_SHORT).show();

        // super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this,"Back Pressed - Are You Sure??",Toast.LENGTH_SHORT).show();
       // super.onBackPressed();
    }
}
