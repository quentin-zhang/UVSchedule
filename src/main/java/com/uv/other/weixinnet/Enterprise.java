package com.uv.other.weixinnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enterprise {

    private List<List<String>> 电商abcdefg团购;
    private List<List<String>> 线下零售;
    private List<List<String>> 生活abcdefg家居;
    private List<List<String>> 餐饮abcdefg食品;
    private List<List<String>> 生活abcdefg咨询服务;
    private List<List<String>> 票务abcdefg旅游;
    private List<List<String>> 网络虚拟服务;
    private List<List<String>> 教育abcdefg培训;
    private List<List<String>> 娱乐abcdefg健身服务;
    private List<List<String>> 房地产;
    private List<List<String>> 医疗;
    private List<List<String>> 收藏abcdefg拍卖;
    private List<List<String>> 苗木abcdefg绿化;
    private List<List<String>> 交通运输服务类;
    private List<List<String>> 生活缴费;
    private List<List<String>> 公益;
    private List<List<String>> 通信;
    private List<List<String>> 金融;
    private List<List<String>> 其他;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("电商abcdefg团购",this.电商abcdefg团购);
        myList.put("线下零售",this.线下零售);
        myList.put("生活abcdefg家居",this.生活abcdefg家居);
        myList.put("餐饮abcdefg食品",this.餐饮abcdefg食品);
        myList.put("生活abcdefg咨询服务",this.生活abcdefg咨询服务);
        myList.put("票务abcdefg旅游",this.票务abcdefg旅游);
        myList.put("网络虚拟服务",this.网络虚拟服务);
        myList.put("教育abcdefg培训",this.教育abcdefg培训);
        myList.put("娱乐abcdefg健身服务",this.娱乐abcdefg健身服务);
        myList.put("房地产",this.房地产);
        myList.put("医疗",this.医疗);
        myList.put("收藏abcdefg拍卖",this.收藏abcdefg拍卖);
        myList.put("苗木abcdefg绿化",this.苗木abcdefg绿化);
        myList.put("交通运输服务类",this.交通运输服务类);
        myList.put("生活缴费",this.生活缴费);
        myList.put("公益",this.公益);
        myList.put("通信",this.通信);
        myList.put("金融",this.金融);
        myList.put("其他",this.其他);

        return myList;
    }



}
