package com.pipizhu.Utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

@SuppressWarnings("all")
public  class IDutils {
    public  static String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }




}
