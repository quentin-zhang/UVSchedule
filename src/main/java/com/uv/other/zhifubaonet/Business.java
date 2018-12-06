package com.uv.other.zhifubaonet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Business {
    private List<List<String>> 承包商hijk;
    private List<List<String>> 房地产;
    private List<List<String>> 公共事业;
    private List<List<String>> 金融服务;
    private List<List<String>> 汽车租赁和服务;
    private List<List<String>> 商业服务;
    private List<List<String>> 生活服务;
    private List<List<String>> 团购;
    private List<List<String>> 维修服务;
    private List<List<String>> 直销;
    private List<List<String>> 无人值守服务;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("承包商abcdefg",this.承包商hijk);
        myList.put("房地产",this.房地产);
        myList.put("公共事业",this.公共事业);
        myList.put("金融服务",this.金融服务);
        myList.put("汽车租赁和服务",this.汽车租赁和服务);
        myList.put("商业服务",this.商业服务);
        myList.put("生活服务",this.生活服务);
        myList.put("团购",this.团购);
        myList.put("维修服务",this.维修服务);
        myList.put("直销",this.直销);
        myList.put("无人值守服务",this.无人值守服务);

        return myList;
    }
}
