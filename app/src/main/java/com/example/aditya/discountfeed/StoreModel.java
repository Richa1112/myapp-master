package com.example.aditya.discountfeed;

/**
 * Created by Manu on 4/3/2017.
 */

public class StoreModel {

    String storeName;
    String imageUrl;
    String url;
    String id;
    boolean isFav;

    public StoreModel(String storeName, String imageUrl, String url, String id, boolean isFav) {
        this.storeName = storeName;
        this.imageUrl = imageUrl;
        this.url = url;
        this.id = id;
        this.isFav = isFav;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
