package com.example.aditya.discountfeed;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by Manu on 4/3/2017.
 */

public class StoreController {

    public static ArrayList<StoreModel> storeList;
    static ArrayList<StoreModel> newStoreList;

    //create an object of SingleObject
    private static StoreController instance;

    //make the constructor private so that this class cannot be
    //instantiated
    private StoreController() {
    }

    //Get the only object available
    public static ArrayList getInstance() {

        if (instance == null) {
            instance = new StoreController();
            ArrayList<StoreModel> storeListAtInit = new ArrayList();

            instance = new StoreController();
            instance.storeList = storeListAtInit;

            getDeals();
        }


        while (newStoreList == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        return instance.newStoreList;
    }

    public static void getDeals() {
        new getBrands().execute();
    }

    private static class getBrands extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://raw.githubusercontent.com/Richa1112/myapp-master/master/app/src/main/java/com/example/aditya/discountfeed/data.json";


            // FOR LOCAL TESTING Comment the 1st line and uncomment the second line
            String jsonStr = sh.makeServiceCall(url);
//            String jsonStr = "[{\"name\":\"nike\",\"url\":\"http://store.nike.com/us/en_us/pw/clearance/47?st=sale:male\",\"imageUrl\":\"http://logok.org/wp-content/uploads/2014/03/Nike-logo-+-wordmark.png\"},{\"name\":\"Walmart\",\"url\":\"https://www.walmart.com/store/2989/weekly-ads\",\"imageUrl\":\"https://news.bitcoin.com/wp-content/uploads/2016/05/Walmart-logo.png\"},{\"name\":\"Macys\",\"url\":\"https://www.macys.com/shop/for-the-home/spring-spectacular-sale?id=42021&cm_sp=us_hdr-_-home-_-42021_spring-spectacular-sale_COL4\",\"imageUrl\":\"http://christineandjim.com/images/macys-logo.png\"},{\"name\":\"Target\",\"url\":\"http://www.target.com/c/clearance/-/N-5q0ga\",\"imageUrl\":\"https://i.ytimg.com/vi/RW3UYQED1bE/maxresdefault.jpg\"},{\"name\":\"Adidas\",\"url\":\"http://www.adidas.com/us/men-sale\",\"imageUrl\":\"https://suppastore-rancher.s3.amazonaws.com/brands/thumbnail/36/adidas-black_1.png\"},{\"name\":\"Walgreens\",\"url\":\"https://www.walgreens.com/offers/offers.jsp?view=weeklyad#/weeklyad\",\"imageUrl\":\"http://visitoxfordms.com/wp-content/uploads/Walgreens.jpg\"}]";

            Log.e(TAG, "Response from url: " + jsonStr);


            if (jsonStr != null) try {

                ArrayList<StoreModel> newStoreListLocal = new ArrayList<StoreModel>();

                JSONArray jsonarray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String name = jsonobject.getString("name");
                    String url1 = jsonobject.getString("url");
                    String imageUrl = jsonobject.getString("imageUrl");
                    newStoreListLocal.add(new StoreModel(name, imageUrl, url1, "9", false));
                }

                newStoreList = newStoreListLocal;


            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
            else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}
