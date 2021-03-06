package com.passeapp.dark_legion.asacapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class TestCustomAdapter extends ArrayAdapter<TestClass> {

    private Context context;

    public TestCustomAdapter(@NonNull Context context, @NonNull ArrayList<TestClass> objects) {
        super(context, R.layout.custom_row, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_row,parent,false);
        }

        TestClass contact = getItem(position);
        TextView contactName = (TextView) convertView.findViewById(R.id.lblText);
        ImageView icon = (ImageView)convertView.findViewById(R.id.iconFolder);
        contactName.setText(contact.getNombre());
        icon.setImageResource(R.drawable.check2);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            if (position == TestActivity.selectedListPos) {
                convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.answer_select_highlight));
            }else{
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }
        }


        return convertView;
    }
}
