package com.example.aditya.discountfeed;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Tab1_Fragment extends Fragment {
    GridView grid;
    String[] web = {
            "walmart",
            "Biglots",
            "walmart",
            "Biglots",
            "walmart",
            "Biglots",
            "walmart",
            "Biglots",
            "walmart2"

    } ;
    int[] imageId = {
            R.drawable.walmart,
            R.drawable.biglots,
            R.drawable.walmart,
            R.drawable.biglots,
            R.drawable.walmart,
            R.drawable.biglots,
            R.drawable.walmart,
            R.drawable.biglots,
            R.drawable.walmart


    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        CustomGrid adapter = new CustomGrid(this.getActivity(), web, imageId);
//        grid=(GridView) this.getActivity().findViewById(R.id.gridview1);
//
//
//        grid.setAdapter(adapter);
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1_fragment, container, false);

        CustomGrid adapter = new CustomGrid(this.getActivity(), web, imageId);
        grid=(GridView) view.findViewById(R.id.gridview1);


        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
