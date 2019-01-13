package com.amazon.ask.airplanefacts.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactsUtil {

    public static Map getFactMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Crock Pot", "Whether you're on the go or dining at home, the Crock-Pot, 3.5 Quart, Casserole Crock Slow Cooker has got your covered. " +
                "This versatile slow cooker can be used to cook a meal or keep your food warm. An easy way to prepare family meals and a must-have at large gatherings.\n" +
                "Now available at 50% discount");
        map.put("Boeing-747", "The 747-400, the most common variant in service, has a high-subsonic cruise speed of up to 570 miles per hour.");
        return map;
    }

    public static Map getImageMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Crock Pot", "https://target.scene7.com/is/image/Target/GUEST_b2dda82b-0c84-411f-afa9-6303f2eb4e90?wid=1400");
        map.put("Boeing-747", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-1.jpg");
        return map;
    }

    public static List getKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("Crock Pot");
        keys.add("Boeing-747");
        return keys;
    }

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
