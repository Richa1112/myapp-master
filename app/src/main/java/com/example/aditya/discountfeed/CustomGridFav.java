package com.example.aditya.discountfeed;

/**
 * Created by Manu on 4/1/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class CustomGridFav extends BaseAdapter {
    private Context mContext;
    ArrayList<StoreModel> storeList;


    public CustomGridFav(Context c, ArrayList<StoreModel> storeList) {
        mContext = c;


        ArrayList<StoreModel> favList = new ArrayList<StoreModel>();

        for (StoreModel store : storeList) {

            if (store.isFav) {

                favList.add(store);
            }
        }

        this.storeList = favList;

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


            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item_layout_fav, null);
            //      TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            //    textView.setText(web[position]);
            Picasso.with(mContext).load(storeData.imageUrl).into(imageView);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(mContext, "You Clicked at " + storeList.get(position).getStoreName(), Toast.LENGTH_SHORT).show();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storeList.get(position).url));
                    mContext.startActivity(browserIntent);

                }
            });


        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}