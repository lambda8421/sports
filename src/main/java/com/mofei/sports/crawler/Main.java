package com.mofei.sports.crawler;

public class Main {
    public static void main(String[] args) {

        try {
            new Crawler().captureJavascript("http://nba" +
                    ".win007.com/jsData/matchResult/17-18/l1_1_2017_10.js?version=2018072222");
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

    }
}
