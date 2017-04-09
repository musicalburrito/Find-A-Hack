package com.sample.project.find_a_hack;

import java.util.ArrayList;

/**
 * Created by nancyli on 4/9/17.
 */

public class worker {
    String username;
    ArrayList<String> categories;

    public worker(){
        super();
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setCategories(ArrayList<String> categories){
        this.categories = new ArrayList<String>(categories);
    }
}
