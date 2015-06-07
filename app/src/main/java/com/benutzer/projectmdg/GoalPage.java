package com.benutzer.projectmdg;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ListView;


public class GoalPage extends ActionBarActivity {

    //Variables for goal page
    ListAdapter listAdapter;
    ListView listView;
    String[] goalString;
    int[] goalImageId;
    ImageView dynamicImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);

        //Initialising variables
        dynamicImageView = (ImageView) findViewById(R.id.activeDoodleImageId);
        listView = (ListView) findViewById(R.id.goalListId);
        //Adjusting widgets
        changeListAndImageViewDimen();
        //Initialising extra variables
        initializeVariables();
        //Listener to goal's listView
        setListenerToGoal();

    }

    //Initialising variables
    private void initializeVariables(){
        //creating a string array for naming of values on list
        goalString = new String[]{getString(R.string.goalString01), getString(R.string.goalString02),
                getString(R.string.goalString03), getString(R.string.goalString04), getString(R.string.goalString05),
                getString(R.string.goalString06), getString(R.string.goalString07), getString(R.string.goalString08)};

        //creating drawable id array for using in custom adapter as the image resource link
        goalImageId = new int[]{R.drawable.mdglogo_1, R.drawable.mdglogo_2, R.drawable.mdglogo_3,
                R.drawable.mdglogo_4, R.drawable.mdglogo_5, R.drawable.mdglogo_6, R.drawable.mdglogo_7,
                R.drawable.mdglogo_8};

        //Initialising the goal adapter
        listAdapter = new GoalAdapter(this, goalString, goalImageId);
        listView.setAdapter(listAdapter);

        dynamicImageView.setImageResource(R.drawable.dynamicticker_mdg);
    }

    //listener function for the listView components/attributes
    private void setListenerToGoal(){
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String name = String.valueOf(parent.getItemAtPosition(position));
                        //used for starting new activity related to item clicked
                        startGoalActivity(name);
                    }
                }
        );
    }

    //function would be used in upcoming model to use services and threads for creating
    //dynamic image tickers from database/web making app visually apealing
    public void generateImageDynamics(View view){
        Toast.makeText(this, "Dynamic Image, Database Link Required", Toast.LENGTH_SHORT).show();
    }

    //re adjusting widgets according to screen size
    private void changeListAndImageViewDimen(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int sw = dm.widthPixels;
        int sh = dm.heightPixels;
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.width = sw;
        params.height = sh/4;
        params.leftMargin = 0;
        params.topMargin = 0;
        dynamicImageView.setLayoutParams(params);

        RelativeLayout.LayoutParams params1 = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params1.width = sw;
        params1.topMargin = sh/4 + 5;
        params1.leftMargin = 0;
        listView.setLayoutParams(params1);
    }

    //function used for starting which goal activity to be formed after item click
    private void startGoalActivity(String activity){
        //Toast.makeText(this, activity, Toast.LENGTH_LONG).show();
        boolean startIntent = true;
        Intent intentGoal = new Intent(this, MillenniumGoal.class);
        //Pass extra data regarding which goal is being chosen
        {
            if (activity.equalsIgnoreCase(getString(R.string.goalString01))) {
                intentGoal.putExtra("GoalVal", goalImageId[0]);
                intentGoal.putExtra("GoalPos", 1);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString02))) {
                intentGoal.putExtra("GoalVal", goalImageId[1]);
                intentGoal.putExtra("GoalPos", 2);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString03))) {
                intentGoal.putExtra("GoalVal", goalImageId[2]);
                intentGoal.putExtra("GoalPos", 3);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString04))) {
                intentGoal.putExtra("GoalVal", goalImageId[3]);
                intentGoal.putExtra("GoalPos", 4);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString05))) {
                intentGoal.putExtra("GoalVal", goalImageId[4]);
                intentGoal.putExtra("GoalPos", 5);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString06))) {
                intentGoal.putExtra("GoalVal", goalImageId[5]);
                intentGoal.putExtra("GoalPos", 6);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString07))) {
                intentGoal.putExtra("GoalVal", goalImageId[6]);
                intentGoal.putExtra("GoalPos", 7);
            } else if (activity.equalsIgnoreCase(getString(R.string.goalString08))) {
                intentGoal.putExtra("GoalVal", goalImageId[7]);
                intentGoal.putExtra("GoalPos", 8);
            } else {
                startIntent = false;
            }
        }
        if(startIntent){
            startActivity(intentGoal);
        }
        else{
            Toast.makeText(this, activity + " : NOT RECOGNIZED", Toast.LENGTH_SHORT).show();
        }
    }
}
