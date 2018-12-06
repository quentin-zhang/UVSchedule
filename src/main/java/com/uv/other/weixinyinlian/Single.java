package com.uv.other.weixinyinlian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Single {
    private List<List<String>> 餐饮;
    private List<List<String>> 线下零售;
    private List<List<String>> 居民生活abcdefg商业服务;
    private List<List<String>> 休闲娱乐;
    private List<List<String>> 交通运输服务;
    private List<List<String>> 网络媒体abcdefg计算机服务abcdefg游戏;
    private List<List<String>> 教育abcdefg医疗;
    private List<List<String>> 生活缴费;
    private List<List<String>> 金融;
    private List<List<String>> 交通出行abcdefg票务旅游;
    private List<List<String>> 其他;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("餐饮",this.餐饮);
        myList.put("线下零售",this.线下零售);
        myList.put("居民生活abcdefg商业服务",this.居民生活abcdefg商业服务);
        myList.put("休闲娱乐",this.休闲娱乐);
        myList.put("交通运输服务",this.交通运输服务);
        myList.put("网络媒体abcdefg计算机服务abcdefg游戏",this.网络媒体abcdefg计算机服务abcdefg游戏);
        myList.put("教育abcdefg医疗",this.教育abcdefg医疗);
        myList.put("生活缴费",this.生活缴费);
        myList.put("金融",this.金融);
        myList.put("交通出行abcdefg票务旅游",this.交通出行abcdefg票务旅游);
        myList.put("其他",this.其他);

        return myList;
    }
}
