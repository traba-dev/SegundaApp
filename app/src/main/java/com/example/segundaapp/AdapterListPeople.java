package com.example.segundaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListPeople extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public AdapterListPeople (Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        IViewHolder viewHolder;

        if (convertView == null) {
            //Se infla la vista que se envía al adaptador
            LayoutInflater layoutInflater =  LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);

            viewHolder = new IViewHolder();
            //Se agrega el nombre al textview de la vista
            viewHolder.textView =  (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (IViewHolder) convertView.getTag();
        }

        //Posición del objeto dentro del array
        String currentName = names.get(position);
        viewHolder.textView.setText(currentName);

        return convertView;
    }

    static class IViewHolder {
        private TextView textView;

    }
}
