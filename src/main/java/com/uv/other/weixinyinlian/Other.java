package com.uv.other.weixinyinlian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Other {
    private List<List<String>> 教育abcdefg医疗;
    private List<List<String>> 生活abcdefg咨询服务;
    private List<List<String>> 交通运输abcdefg票务旅游;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("教育abcdefg医疗",this.教育abcdefg医疗);
        myList.put("生活abcdefg咨询服务",this.生活abcdefg咨询服务);
        myList.put("交通运输abcdefg票务旅游",this.交通运输abcdefg票务旅游);

        return myList;
    }
}
