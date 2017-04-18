package com.example.aditya.discountfeed;

/**
 * Created by Manu on 4/1/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    ArrayList<StoreModel> storeList;

    public CustomGrid(Context c, ArrayList<StoreModel> storeList) {
        mContext = c;
        this.storeList = storeList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return storeList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            final StoreModel storeData = storeList.get(position);
            grid = inflater.inflate(R.layout.grid_item_layout, null);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            Picasso.with(mContext).load(storeData.imageUrl).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storeData.url));
                    mContext.startActivity(browserIntent);
                }
            });

            ImageView starButton = (ImageView) grid.findViewById(R.id.starButton);
            starButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StoreModel storeData = (StoreModel) StoreController.getInstance().get(position);
                    storeData.isFav = !storeData.isFav;
                }
            });
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}