package com.uv.other.zhifubaonet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Traffic {
    private List<List<String>> 公共交通;
    private List<List<String>> 航空票务;
    private List<List<String>> 旅行住宿;
    private List<List<String>> 物流仓储;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("公共交通",this.公共交通);
        myList.put("航空票务",this.航空票务);
        myList.put("旅行住宿",this.旅行住宿);
        myList.put("物流仓储",this.物流仓储);

        return myList;
    }
}
