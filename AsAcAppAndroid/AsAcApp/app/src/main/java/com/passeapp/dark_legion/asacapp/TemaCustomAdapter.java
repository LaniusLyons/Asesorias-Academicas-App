package com.passeapp.dark_legion.asacapp;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class TemaCustomAdapter extends ArrayAdapter<TemaClass>{

    private Context context;

    public TemaCustomAdapter(Context context, ArrayList<TemaClass> objects) {
        super(context, R.layout.custom_row, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_row,parent,false);
        }

        TemaClass contact = getItem(position);
        TextView contactName = (TextView) convertView.findViewById(R.id.lblText);
        //ImageView icon = (ImageView)customView.findViewById(R.id.iconFolder);
        contactName.setText(contact.getNombre());
        //icon.setImageResource(R.drawable.folder);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            if (position == TemaActivity.selectedListPos) {
                convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.answer_select_highlight));
            }else{
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }
        }

        return convertView;

        /*ViewHolderItem viewHolder;

        if(convertView==null){

            // inflate the layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_row, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.lblText);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        }else{
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        // object item based on the position
        TemaClass objectItem = getItem(position);

        // assign values if the object is not null
        if(objectItem != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.textViewItem.setText(objectItem.getNombre());
            viewHolder.textViewItem.setTag(objectItem.getNombre());
        }

        return convertView;*/
    }

    static class ViewHolderItem {
        TextView textViewItem;
    }

}
