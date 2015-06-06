package com.benutzer.projectmdg;

/**
 * Created by amitesh on 6/6/15.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


class GoalAdapter extends ArrayAdapter{

    //variable for drawable id of clicked item
    int[] id;

    GoalAdapter(Context context, String[] resource, int[] idResource) {
        super(context, R.layout.custom_goal,resource);
        id = idResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //creating layout for single item in list
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_goal, parent, false);

        //selecting value for the item on list to be displayed
        String singleItem = (String) getItem(position);
        int idItem = id[position];
        //initialising widgets of new custom layout for items
        TextView textView = (TextView) customView.findViewById(R.id.goalTextViewId);
        ImageView imageView = (ImageView) customView.findViewById(R.id.goalSquareImage);

        //applying selected values
        textView.setText(singleItem);
        imageView.setImageResource(idItem);
        return customView;
    }
}
