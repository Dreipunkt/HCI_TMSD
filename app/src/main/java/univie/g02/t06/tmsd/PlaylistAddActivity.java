package univie.g02.t06.tmsd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;

public class PlaylistAddActivity extends AppCompatActivity{
    CheckBox energyCheckbox;
    CheckBox danceCheckbox;
    CheckBox hotCheckbox;
    Switch energySwitch;
    Switch danceSwitch;
    Switch hotSwitch;
    EditText nameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlistadd);

        nameText = (EditText) findViewById(R.id.name_Text);

        energyCheckbox = (CheckBox) findViewById(R.id.energy_Checkbox);
        energySwitch = (Switch) findViewById(R.id.energy_Switch);
        energyCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    energySwitch.setVisibility(View.VISIBLE);
                } else{
                    energySwitch.setVisibility(View.INVISIBLE);
                }
            }
        });

        danceCheckbox = (CheckBox) findViewById(R.id.dance_Checkbox);
        danceSwitch = (Switch) findViewById(R.id.dance_Switch);
        danceCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    danceSwitch.setVisibility(View.VISIBLE);
                } else{
                    danceSwitch.setVisibility(View.INVISIBLE);
                }
            }
        });

        hotCheckbox = (CheckBox) findViewById(R.id.hot_Checkbox);
        hotSwitch = (Switch) findViewById(R.id.hot_Switch);
        hotCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    hotSwitch.setVisibility(View.VISIBLE);
                } else{
                    hotSwitch.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void addplaylistClick(View v) {
        ArrayList<String> listItems = (ArrayList<String>) getIntent().getSerializableExtra("listItems");
        if(listItems.contains(nameText.getText().toString())){
            //MESSAGE: "PLAYLIST ALREADY EXISTS"
        } else {
            Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
            intent.putExtra("nameText", nameText.getText().toString());
            startActivity(intent);
        }
    }



}


