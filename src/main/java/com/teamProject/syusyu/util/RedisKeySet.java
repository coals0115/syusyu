package com.teamProject.syusyu.util;

public class RedisKeySet {
    
    public static String promotionTarget(String promotionCode, String hashCi) {
        return String.format("%s:%s", promotionCode, hashCi);
    }
} 