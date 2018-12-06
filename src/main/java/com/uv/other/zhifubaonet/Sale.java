package com.uv.other.zhifubaonet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sale {
    private List<List<String>> 办公用品;
    private List<List<String>> 工业产品;
    private List<List<String>> 汽车和运输工具;
    private List<List<String>> 药品医疗;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("办公用品",this.办公用品);
        myList.put("工业产品",this.工业产品);
        myList.put("汽车和运输工具",this.汽车和运输工具);
        myList.put("药品医疗",this.药品医疗);

        return myList;
    }
}
