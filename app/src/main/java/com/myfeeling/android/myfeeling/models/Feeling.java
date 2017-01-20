package com.myfeeling.android.myfeeling.models;

import android.media.Image;

import java.net.URI;

/**
 * Created by fcng1847 on 20/01/17.
 */

public class Feeling {
    final String name;
    final int imageResource;

    Feeling(String name, int imageResource ){
        this.name = name;
        this.imageResource = imageResource;
    }
}
