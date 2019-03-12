package com.example.m6.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.m6.R;
import com.example.m6.model.Player;
import com.example.m6.model.Resource;
import com.example.m6.model.TechLevel;

public class CurrentPlanetActivity extends AppCompatActivity {

    private Button menuButton;
    private TextView name;
    private TextView techLevel;
    private TextView resource;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_planet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        player = (Player) getIntent().getSerializableExtra("player");
        Log.d("player", player.getName()+" is into CurrentPlanetActivity sucessfully" );
        name = findViewById(R.id.system_name);
        techLevel = findViewById(R.id.system_techLevel);
        resource = findViewById(R.id.system_resource);
        menuButton = findViewById(R.id.menu_button);


        name.setText(player.getCurrentplanet().getName());
        techLevel.setText(TechLevel.values()[player.getCurrentplanet().getTechLevel()].toString());
        resource.setText(Resource.values()[player.getCurrentplanet().getResource()].toString());

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });


    }

    public void openMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+" sent from CurrentPlanetactivity to MenuActivity sucessfully" );
        startActivity(intent);
    }

}
