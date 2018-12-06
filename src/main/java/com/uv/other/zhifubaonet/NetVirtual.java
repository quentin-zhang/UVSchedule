package com.uv.other.zhifubaonet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetVirtual {
    private List<List<String>> 彩票;
    private List<List<String>> 电信通讯;
    private List<List<String>> 互联网服务;
    private List<List<String>> 数娱网游;
    private List<List<String>> 娱乐票务;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("彩票",this.彩票);
        myList.put("电信通讯",this.电信通讯);
        myList.put("互联网服务",this.互联网服务);
        myList.put("数娱网游",this.数娱网游);
        myList.put("娱乐票务",this.娱乐票务);

        return myList;
    }
}
