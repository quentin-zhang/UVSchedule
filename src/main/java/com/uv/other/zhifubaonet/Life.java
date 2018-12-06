package com.uv.other.zhifubaonet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Life {
    private List<List<String>> 百货商城;
    private List<List<String>> 服饰鞋包;
    private List<List<String>> 家居家纺建材;
    private List<List<String>> 美妆珠宝配饰;
    private List<List<String>> 母婴玩具;
    private List<List<String>> 数码家电;
    private List<List<String>> 图书音像;
    private List<List<String>> 文化玩乐宠物;
    private List<List<String>> 饮食保健;
    private List<List<String>> 运动户外;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("百货商城",this.百货商城);
        myList.put("服饰鞋包",this.服饰鞋包);
        myList.put("家居家纺建材",this.家居家纺建材);
        myList.put("美妆珠宝配饰",this.美妆珠宝配饰);
        myList.put("母婴玩具",this.母婴玩具);
        myList.put("数码家电",this.数码家电);
        myList.put("图书音像",this.图书音像);
        myList.put("文化玩乐宠物",this.文化玩乐宠物);
        myList.put("饮食保健",this.饮食保健);
        myList.put("运动户外",this.运动户外);

        return myList;
    }
}
