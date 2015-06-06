package com.benutzer.projectmdg;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    //variables used in main activity
    ImageView UNDPImageView;
    ImageView MDPImageView;
    Button goalButton;
    Button aboutButton;
    DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising variables
        UNDPImageView = (ImageView) findViewById(R.id.UNDPLogoId);
        MDPImageView = (ImageView) findViewById(R.id.millenniumLogoId);
        goalButton = (Button) findViewById(R.id.millenniumButtonId);
        aboutButton = (Button) findViewById(R.id.aboutButtonId);
        displayMetrics = new DisplayMetrics();

        //grabbing dimensions of user screen
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        //Function for widget size adjustment
        adjustWidgetSize(displayMetrics);
        //providing default images
        UNDPImageView.setImageResource(R.drawable.undp_logo);
        MDPImageView.setImageResource(R.drawable.mdg_logo);
    }

    private void adjustWidgetSize(DisplayMetrics dm){
        int widthScreen = dm.widthPixels;
        int heightScreen = dm.heightPixels;

        //Using LayoutParams for re adjustment of widgets
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.width = ((widthScreen/8)*3);
        params.leftMargin = widthScreen/2 - params.width/2;
        params.topMargin = 0;
        UNDPImageView.setLayoutParams(params);

        RelativeLayout.LayoutParams params1 = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params1.width = widthScreen/2;
        params1.leftMargin = widthScreen/2 - params1.width/2;
        params1.topMargin = heightScreen/4;
        //params1.setMargins(0, 0, 0, 0);
        MDPImageView.setLayoutParams(params1);

    }


    //Menu currently not installed work in progress
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Next intent opening
    public void openGoalPage(View view){
        Intent intent = new Intent(this, GoalPage.class);
        startActivity(intent);
    }

    //It needs server linkage for issue of data feed about MDG
    public void openAboutPage(View view){

        Toast.makeText(this, "Database Link required", Toast.LENGTH_LONG).show();

    }
}
