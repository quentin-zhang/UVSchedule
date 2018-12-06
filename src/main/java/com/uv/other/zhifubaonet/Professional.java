package com.uv.other.zhifubaonet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Professional {
    private List<List<String>> 教育服务;
    private List<List<String>> 其他;
    private List<List<String>> 社会组织;
    private List<List<String>> 医疗服务;
    private List<List<String>> 政府服务;
    private List<List<String>> 专业咨询;

    public Map<String,List<List<String>>> toList ()
    {
        Map<String,List<List<String>>>  myList = new HashMap<String,List<List<String>>>();
        myList.put("教育服务",this.教育服务);
        myList.put("其他",this.其他);
        myList.put("社会组织",this.社会组织);
        myList.put("医疗服务",this.医疗服务);
        myList.put("政府服务",this.政府服务);
        myList.put("专业咨询",this.专业咨询);

        return myList;
    }
}
