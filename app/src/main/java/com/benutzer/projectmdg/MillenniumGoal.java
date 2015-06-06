package com.benutzer.projectmdg;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.util.DisplayMetrics;
import android.widget.Toast;



public class MillenniumGoal extends ActionBarActivity {

    //variables to be used
    ImageView baseImage;
    ImageView onBaseImage;
    ListView listView;
    ListAdapter listAdapter;
    String[] itemList;
    int goalNumber;    //Basically this will tell us which goal to show to user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_millennium_goal);

        //gathering data from past activity that was passed via intent extras
        Bundle bundle = getIntent().getExtras();
        goalNumber = ((Integer) bundle.get("GoalPos")).intValue();
        int goalDrawId = ((Integer) bundle.get("GoalVal")).intValue();

        //initialising widgets
        baseImage = (ImageView) findViewById(R.id.baseImageId);
        onBaseImage = (ImageView) findViewById(R.id.goalOnBaseImageId);
        listView = (ListView) findViewById(R.id.goalSpecificList);

        //initialising list values
        initialiseList();
        //re adjusting widgets according to screen dimensions
        editImageViewListDisplayMetrics();
        //deploying drawable objects
        baseImage.setImageResource(R.drawable.goalticker_dynamic);
        onBaseImage.setImageResource(goalDrawId);

    }

    private void initialiseList(){

        //string resource used as name of items on list
        itemList = new String[]{"About Goal " + goalNumber, "Country Status", "Live Feed", "Share Views"};
        //listview getting initialised via ArrayAdapter
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(listAdapter);

        //creating item click listener for list
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            //using switch case for calling functions related to the item clicked
                            case 0 : aboutCall();
                                break;
                            case 1 : countryStatusCall();
                                break;
                            case 2 : liveFeedCall();
                                break;
                            case 3 : shareViewsCall();
                                break;
                            default: callToastDefault();
                        }
                    }
                }
        );
    }

    //re adjustment of widgets
    private void editImageViewListDisplayMetrics(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int sw = dm.widthPixels;
        int sh = dm.heightPixels;
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //params.width = sw;
        params.height = sh/2;
        params.leftMargin = 0;
        params.topMargin = -10;
        baseImage.setLayoutParams(params);

        RelativeLayout.LayoutParams params1 = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params1.width = sw;
        params1.topMargin = sh/2 + 5;
        params1.leftMargin = 0;
        listView.setLayoutParams(params1);
    }

    //Following functions will use goalNumber key value to respond to the specific Millenium Goal
    //the function currently only show a toast related to the goal number
    private void aboutCall(){
        String message = "MDG " + goalNumber + " : This function provides details about the MDG " + goalNumber;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void countryStatusCall(){
        String message  = "MDG " + goalNumber + " : This function provides country achievement of MDG " + goalNumber;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void liveFeedCall(){
        String message  = "MDG " + goalNumber + " : This function provides live feed by people globally about MDG " + goalNumber;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void shareViewsCall(){
        String message  = "MDG " + goalNumber + " : This function helps in sharing our views via Twitter/fb/g+ about MDG " + goalNumber;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    //baseImage function for making it dynamic when connected via database, work in progress
    public void generateBaseImageDynamics(View view){
        Toast.makeText(this, "Dynamic Image, Database Link Required", Toast.LENGTH_LONG).show();
    }

    //Default switch method
    private void callToastDefault(){
        Toast.makeText(this, "N/A", Toast.LENGTH_LONG).show();
    }
}
