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

import univie.g02.t06.tmsd.subsetdata.SubsetData;
import univie.g02.t06.tmsd.subsetdata.SubsetSong;

public class PlaylistAddActivity extends AppCompatActivity {
    Spinner genreSpinner;
    CheckBox familarityCheckbox;
    CheckBox hotnessCheckbox;
    CheckBox genreCheckbox;
    CheckBox yearfromCheckbox;
    CheckBox yeartoCheckbox;
    Switch familaritySwitch;
    Switch hotnessSwitch;
    EditText nameText;
    EditText yearfromText;
    EditText yeartoText;
    SubsetData sd;

    String readGenre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sd = new SubsetData();


        setTitle("Create a Playlist");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlistadd);

        nameText = (EditText) findViewById(R.id.name_Text);

        genreSpinner = (Spinner) findViewById(R.id.genre_Spinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, sd.getAllGenres());
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        genreSpinner.setAdapter(spinnerAdapter);
/*

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                                                       readGenre = Spinner.getSelectedItem().toString();
                                                   }
                                               });*/



        genreCheckbox = (CheckBox) findViewById(R.id.genre_Checkbox);
        genreCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    genreSpinner.setVisibility(View.VISIBLE);
                } else{
                    genreSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });




        yearfromCheckbox = (CheckBox) findViewById(R.id.yearfrom_Checkbox);
        yearfromText = (EditText) findViewById(R.id.yearfrom_Text);
        yearfromCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    yearfromText.setVisibility(View.VISIBLE);
                } else{
                    yearfromText.setVisibility(View.INVISIBLE);
                }
            }
        });

        yeartoCheckbox = (CheckBox) findViewById(R.id.yearto_Checkbox);
        yeartoText = (EditText) findViewById(R.id.yearto_Text);
        yeartoCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    yeartoText.setVisibility(View.VISIBLE);
                } else{
                    yeartoText.setVisibility(View.INVISIBLE);
                }
            }
        });



        familarityCheckbox = (CheckBox) findViewById(R.id.familarity_Checkbox);
        familaritySwitch = (Switch) findViewById(R.id.familarity_Switch);
        familarityCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    familaritySwitch.setVisibility(View.VISIBLE);
                } else{
                    familaritySwitch.setVisibility(View.INVISIBLE);
                }
            }
        });

        hotnessCheckbox = (CheckBox) findViewById(R.id.hotness_Checkbox);
        hotnessSwitch = (Switch) findViewById(R.id.hotness_Switch);
        hotnessCheckbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked){
                    hotnessSwitch.setVisibility(View.VISIBLE);
                } else{
                    hotnessSwitch.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void addplaylistClick(View v) {
        ArrayList<String> listItems = (ArrayList<String>) getIntent().getSerializableExtra("listItems");

        String selectedGenre = genreSpinner.getSelectedItem().toString();

        SubsetData sd = new SubsetData();
        ArrayList<SubsetSong> playlist = new ArrayList<>();
        playlist = sd.getAllSongs();


        if(listItems.contains(nameText.getText().toString())){
            //MESSAGE: "PLAYLIST ALREADY EXISTS"
        } else {
            if (genreSpinner.getVisibility() == View.VISIBLE){
                playlist.retainAll(sd.getSongsbyGenre(selectedGenre));
            }
            if (yearfromText.getVisibility() == View.VISIBLE){
                playlist.retainAll(sd.getSongsbyFromYear(Integer.parseInt(yearfromText.getText().toString())));
            }
            if (yeartoText.getVisibility() == View.VISIBLE){
                playlist.retainAll(sd.getSongsbyToYear(Integer.parseInt(yeartoText.getText().toString())));
            }
            if (familaritySwitch.getVisibility() == View.VISIBLE){
                if (familaritySwitch.isChecked()){
                    playlist.retainAll(sd.getSongsbyArtistFamilarity(true));
                }
                else {
                    playlist.retainAll(sd.getSongsbyArtistFamilarity(false));
                }
            }
            if (hotnessSwitch.getVisibility() == View.VISIBLE){
                if (hotnessSwitch.isChecked()){
                    playlist.retainAll(sd.getSongbyArtistHotness(true));
                }
                else {
                    playlist.retainAll(sd.getSongbyArtistHotness(false));
                }
            }
            TinyDB tinydb = new TinyDB(this);
            tinydb.putListSubsetSong(nameText.getText().toString(), playlist);
            Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
            intent.putExtra("nameText", nameText.getText().toString());
            startActivity(intent);
        }
    }



}


