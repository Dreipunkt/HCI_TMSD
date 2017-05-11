package univie.g02.t06.tmsd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;

import univie.g02.t06.tmsd.dummydata.DummyAPIData;
import univie.g02.t06.tmsd.dummydata.DummySong;

public class PlaylistAddActivity extends AppCompatActivity{
    Spinner genreSpinner;
    CheckBox energyCheckbox;
    CheckBox danceCheckbox;
    CheckBox hotCheckbox;
    CheckBox genreCheckbox;
    Switch energySwitch;
    Switch danceSwitch;
    Switch hotSwitch;
    EditText nameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlistadd);

        nameText = (EditText) findViewById(R.id.name_Text);


        ArrayList<String> genres = new ArrayList<String>();
        genres = DummyAPIData.getDummyAllGenres();
        genreSpinner = (Spinner) findViewById(R.id.genre_Spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, DummyAPIData.getDummyAllGenres());
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        genreSpinner.setAdapter(spinnerAdapter);

        genreCheckbox = (CheckBox) findViewById(R.id.genre_Checkbox);
        genreCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    genreSpinner.setVisibility(View.VISIBLE);
                } else{
                    genreSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });

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

        ArrayList<DummySong> playlist = new ArrayList<DummySong>();
        playlist = DummyAPIData.getAllDummySongs();


        if(listItems.contains(nameText.getText().toString())){
            //MESSAGE: "PLAYLIST ALREADY EXISTS"
        } else {
            if (genreSpinner.getVisibility() == View.VISIBLE){
                playlist.retainAll(DummyAPIData.getDummySongsbyGenre(genreSpinner.getSelectedItem().toString()));
            }
            if (energySwitch.getVisibility() == View.VISIBLE){
                if (energySwitch.isChecked()){
                    playlist.retainAll(DummyAPIData.getDummySongsbyEnergy(true));
                }
                else {
                    playlist.retainAll(DummyAPIData.getDummySongsbyEnergy(false));
                }
            }
            if (danceSwitch.getVisibility() == View.VISIBLE){
                if (danceSwitch.isChecked()){
                    playlist.retainAll(DummyAPIData.getDummySongsbyEnergy(true));
                }
                else {
                    playlist.retainAll(DummyAPIData.getDummySongsbyEnergy(false));
                }
            }
            if (hotSwitch.getVisibility() == View.VISIBLE){
                if (hotSwitch.isChecked()){
                    playlist.retainAll(DummyAPIData.getDummySongsbyEnergy(true));
                }
                else {
                    playlist.retainAll(DummyAPIData.getDummySongsbyEnergy(false));
                }
            }
            TinyDB tinydb = new TinyDB(this);
            tinydb.putListDummySong(nameText.getText().toString(), playlist);
            Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
            intent.putExtra("nameText", nameText.getText().toString());
            startActivity(intent);
        }
    }



}


