package com.example.asadaboomtham.demoapplication;

import android.widget.ImageView;

/**
 * Created by asada boomtham on 27/9/2560.
 */

public class ListItem {

    private String head;
    private String desc;
    private String imageUrl;
    private String ref;


    //constructer
    public ListItem(String head, String desc,String ref,String imageUrl) {
        this.head = head;
        this.desc = desc;
        this.ref = ref;
        this.imageUrl = imageUrl;
    }

    //getter
    public String getHead() {

        return head;
    }

    public String getDesc() {

        return desc;
    }

    public String getRef() {
        return ref;
    }

    public String getImageUrl() {

        return imageUrl;
    }
}
