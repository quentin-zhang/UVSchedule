package com.uv.other.weixinnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Work {
    private List<List<String>> 医疗;
    private List<List<String>> 教育abcdefg培训;
    private List<List<String>> 其他生活缴费;


    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("医疗",this.医疗);
        myList.put("教育abcdefg培训",this.教育abcdefg培训);
        myList.put("其他生活缴费",this.其他生活缴费);

        return myList;
    }
}
