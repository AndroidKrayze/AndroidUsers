package com.example.nikosliridonltd.users.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikosliridonltd.users.Models.User;
import com.example.nikosliridonltd.users.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends BaseAdapter {

    private Context context;
    private List<User> userList;

    public Adapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList != null ? userList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // View rowView = convertView;
        final ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             convertView = inflater.inflate(R.layout.user_item_list, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = userList.get(i);

        viewHolder.tvFullName.setText(String.format(context.getString(R.string.full_name), user.getName().getFirstName(), user.getName().getLastName()));
        Picasso.with(context).load(user.getPicture().getThumbnail()).into(viewHolder.ivUserImage);
        return convertView;
    }

    static class ViewHolder {
        private TextView tvFullName;
        private ImageView ivUserImage;

        public ViewHolder(View itemView) {
            tvFullName = (TextView) itemView.findViewById(R.id.tvFullName);
            ivUserImage = (ImageView) itemView.findViewById(R.id.ivUserImage);
        }
    }
}
