package com.example.listexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<ItemModel> items;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textCaption = convertView.findViewById();
            viewHolder.imageThumb = convertView.findViewById();
            viewHolder.checkBox = convertView.findViewById();

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemModel item = items.get(position);

        viewHolder.textCaption.setText(item.getCaption());
        viewHolder.imageThumb.setImageResource(item.getImageResource());
        viewHolder.checkBox.setChecked(item.isSelected());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setSelected(viewHolder.checkBox.isChecked());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView textCaption;
        ImageView imageThumb;
        CheckBox checkBox;

    }
}
