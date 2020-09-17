package com.omerkeskin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Singleton selectedLine;
    ListView lvLandmark;
    ArrayList<Landmark> landmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Landmark lm1 = new Landmark();
        lm1.setName("Pisa tower");
        lm1.setCounrty("Italy");
        lm1.setPhoto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.pisa));

        Landmark lm2 = new Landmark();
        lm2.setName("Colesseum");
        lm2.setCounrty("Italy");
        lm2.setPhoto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.colosseum));

        Landmark lm3 = new Landmark();
        lm3.setName("Eiffel Tower");
        lm3.setCounrty("France");
        lm3.setPhoto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.eiffel_tower));

        Landmark lm4 = new Landmark();
        lm4.setName("London Bridge");
        lm4.setCounrty("England");
        lm4.setPhoto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.london_bridge));

        landmarks = new ArrayList<>();
        landmarks.add(lm1);
        landmarks.add(lm2);
        landmarks.add(lm3);
        landmarks.add(lm4);

        ArrayList<String> landmarkNames = new ArrayList<>();
        for (Landmark landmarkItem : landmarks){
            landmarkNames.add(landmarkItem.getName());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames);
        lvLandmark = findViewById(R.id.lvLandmark);
        lvLandmark.setAdapter(adapter);

        lvLandmark.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", landmarks.get(position).getName());
                intent.putExtra("country", landmarks.get(position).getCounrty());

                Landmark landmark = new Landmark();
                Bitmap photo = landmarks.get(position).getPhoto();
                landmark.setPhoto(photo);
                landmark.setCounrty(landmarks.get(position).getCounrty());
                landmark.setName(landmarks.get(position).getName());

                Singleton.getInstance().setLandmark(landmark);
                startActivityForResult(intent, 1);
            }
        });

    }
}