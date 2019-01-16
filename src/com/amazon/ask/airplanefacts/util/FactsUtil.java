package com.amazon.ask.airplanefacts.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class FactsUtil {

    public static Map getFactMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Crock Pot", "Whether you're on the go or dining at home, the Crock-Pot, 3.5 Quart, Casserole Crock Slow Cooker has got your covered. " +
                "This versatile slow cooker can be used to cook a meal or keep your food warm. An easy way to prepare family meals and a must-have at large gatherings.\n" +
                "Now available at 50% discount");
        map.put("Beechcraft Beechjet 400A", "The 400A, the most common variant in service, has a high-subsonic cruise speed of up to 570 miles per hour.");
        return map;
    }

    public static Map getImageMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Crock Pot", "https://target.scene7.com/is/image/Target/GUEST_b2dda82b-0c84-411f-afa9-6303f2eb4e90?wid=1400");
        map.put("Beechcraft Beechjet 400A", "https://cdn.avbuyer.com/uploads/image/354601_354700/aircraft-private-jets-beechcraft-beechjet-400a-354658_e00f973f335473d5_920X485.jpg");
        return map;
    }

    public static List getKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("Crock Pot");
        keys.add("Beechcraft Beechjet 400A");
        return keys;
    }

    public static Map getDealsLangingPage() {
        Map<String, String> map = new HashMap<>();
        map.put("Crock Pot", "https://www.target.com/p/crock-pot-174-3-5-quart-casserole-crock-slow-cooker-sccpccm350/-/A-16637101?preselect=17219694#lnk=sametab");
        map.put("Beechcraft Beechjet 400A", "https://www.avbuyer.com/aircraft/private-jets/beechcraft/beechjet-400a/354658");
        return map;
    }

    //URL Shortner
    public static String shortenURL(String longUrl) {
        if (longUrl == null) {
            return longUrl;
        }

        StringBuilder sb = null;
        String line = null;
        String urlStr = longUrl;

        try {
            URL url = new URL("http://goo.gl/api/url");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "toolbar");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write("url=" + URLEncoder.encode(urlStr, "UTF-8"));
            writer.close();

            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            sb = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                sb.append(line + '\n');
            }

            String json = sb.toString();
            //It extracts easily...
            return json.substring(json.indexOf("http"), json.indexOf("\"", json.indexOf("http")));
        } catch (MalformedURLException e) {
            return longUrl;
        } catch (IOException e) {
            return longUrl;
        }
    }


    // QR Code generator
    //http://api.qrserver.com/v1/create-qr-code/?data=https://www.target.com/p/crock-pot-174-3-5-quart-casserole-crock-slow-cooker-sccpccm350/-/A-16637101?preselect=17219694#lnk=sametab&size=512X512&color=0000ff
}

/*
Royalty free image URLS
https://www.pexels.com/photo/airplane-on-sky-during-sunset-48786/
https://www.pexels.com/photo/airplane-aircraft-airport-transportation-system-113017/
https://www.pexels.com/photo/jet-cloud-landing-aircraft-46148/
https://www.pexels.com/photo/white-passenger-plane-flying-on-sky-during-day-time-67807/
https://www.pexels.com/photo/royalty-free-airbus-passenger-aircraft-auckland-68155/
https://www.pexels.com/photo/sky-traveling-airport-airplane-87460/
*/
