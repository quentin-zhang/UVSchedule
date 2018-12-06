package com.uv.other.weixinyinlian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Work {
    private List<List<String>> 教育abcdefg医疗;
    private List<List<String>> 交通运输服务;
    private List<List<String>> 其他生活缴费;


    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("教育abcdefg医疗",this.教育abcdefg医疗);
        myList.put("交通运输服务",this.交通运输服务);
        myList.put("其他生活缴费",this.其他生活缴费);

        return myList;
    }
}
