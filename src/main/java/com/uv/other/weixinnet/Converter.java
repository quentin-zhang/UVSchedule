package com.uv.other.weixinnet;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class Converter {
    private String jsonStr = "";

    public Converter() {
        this.init();
    }

    private void init() {
        jsonStr = "{\"企业\":{\"电商abcdefg团购\":[[\"203\",\"线上商超\"],[\"2\",\"团购\"],[\"3\",\"海淘\"]],\"线下零售\":[[\"204\",\"超市\"],[\"205\",\"便利店\"],[\"206\",\"自动贩卖机\"],[\"207\",\"百货\"],[\"208\",\"其他综合零售\"]],\"生活abcdefg家居\":[[\"6\",\"户外abcdefg运动abcdefg健身器材abcdefg安防\"],[\"9\",\"黄金珠宝abcdefg钻石abcdefg玉石\"],[\"19\",\"母婴用品abcdefg儿童玩具\"],[\"266\",\"家装建材abcdefg家居家纺\"],[\"267\",\"美妆abcdefg护肤\"],[\"268\",\"鲜花abcdefg盆栽abcdefg室内装饰品\"],[\"269\",\"交通工具abcdefg配件abcdefg改装\"],[\"271\",\"服饰abcdefg箱包abcdefg饰品\"],[\"272\",\"钟表abcdefg眼镜\"],[\"284\",\"宠物abcdefg宠物食品abcdefg饲料\"],[\"310\",\"数码家电abcdefg办公设备\"],[\"315\",\"书籍abcdefg音像abcdefg文具abcdefg乐器\"],[\"13\",\"计生用品\"]],\"餐饮abcdefg食品\":[[\"270\",\"食品\"],[\"90\",\"餐饮\"]],\"生活abcdefg咨询服务\":[[\"273\",\"婚庆abcdefg摄影\"],[\"289\",\"装饰abcdefg设计\"],[\"311\",\"家政abcdefg维修服务\"],[\"312\",\"广告abcdefg会展abcdefg活动策划\"],[\"42\",\"咨询abcdefg法律咨询abcdefg金融咨询等\"],[\"93\",\"人才中介机构abcdefg招聘abcdefg猎头\"],[\"94\",\"职业社交abcdefg婚介abcdefg交友\"],[\"95\",\"网上生活服务平台\"]],\"票务abcdefg旅游\":[[\"274\",\"机票abcdefg机票代理\"],[\"275\",\"旅馆abcdefg酒店abcdefg度假区\"],[\"281\",\"娱乐票务\"],[\"283\",\"交通票务\"],[\"313\",\"景区abcdefg宗教\"],[\"23\",\"旅行社\"],[\"24\",\"旅游服务平台\"]],\"网络虚拟服务\":[[\"276\",\"在线图书abcdefg视频abcdefg音乐\"],[\"277\",\"软件abcdefg建站abcdefg技术开发\"],[\"278\",\"网络推广abcdefg网络广告\"],[\"279\",\"游戏\"],[\"104\",\"门户abcdefg资讯abcdefg论坛\"]],\"教育abcdefg培训\":[[\"52\",\"教育abcdefg培训abcdefg考试缴费abcdefg学费\"],[\"53\",\"私立院校\"]],\"娱乐abcdefg健身服务\":[[\"280\",\"俱乐部abcdefg休闲会所\"],[\"54\",\"美容abcdefg健身类会所\"],[\"56\",\"游艺厅abcdefgKTVabcdefg网吧\"]],\"房地产\":[[\"316\",\"房地产\"]],\"医疗\":[[\"282\",\"保健信息咨询平台\"],[\"314\",\"保健器械abcdefg医疗器械abcdefg非处方药品\"],[\"66\",\"私立abcdefg民营医院abcdefg诊所\"],[\"67\",\"挂号平台\"]],\"收藏abcdefg拍卖\":[[\"285\",\"文物经营abcdefg文物复制品销售\"],[\"325\",\"拍卖abcdefg典当\"],[\"31\",\"非文物类收藏品\"]],\"苗木abcdefg绿化\":[[\"317\",\"苗木种植abcdefg园林绿化\"],[\"40\",\"化肥abcdefg农用药剂等\"]],\"交通运输服务类\":[[\"70\",\"物流abcdefg快递公司\"],[\"259\",\"加油\"],[\"75\",\"港口经营港口理货\"],[\"77\",\"租车\"]],\"生活缴费\":[[\"57\",\"水电煤缴费abcdefg交通罚款等生活缴费\"],[\"287\",\"停车缴费\"],[\"288\",\"城市交通abcdefg高速收费\"],[\"58\",\"有线电视缴费\"],[\"60\",\"物业管理费\"],[\"62\",\"其他生活缴费\"]],\"公益\":[[\"103\",\"公益\"]],\"通信\":[[\"80\",\"电信运营商\"],[\"81\",\"宽带收费\"],[\"92\",\"话费通讯\"]],\"金融\":[[\"112\",\"众筹\"],[\"318\",\"保险业务\"],[\"96\",\"财经资讯\"],[\"97\",\"股票软件类\"]],\"其他\":[[\"111\",\"其他行业\"]]},\"个体工商户\":{\"餐饮abcdefg食品\":[[\"292\",\"食品\"],[\"153\",\"餐饮\"]],\"线下零售\":[[\"209\",\"便利店\"],[\"210\",\"其他综合零售\"]],\"生活abcdefg家居\":[[\"116\",\"户外abcdefg运动abcdefg健身器材abcdefg安防\"],[\"129\",\"母婴用品abcdefg儿童玩具\"],[\"293\",\"家装建材abcdefg家居家纺\"],[\"294\",\"美妆abcdefg护肤\"],[\"295\",\"鲜花abcdefg盆栽abcdefg室内装饰品\"],[\"296\",\"交通工具abcdefg配件abcdefg改装\"],[\"297\",\"服饰abcdefg箱包abcdefg饰品\"],[\"298\",\"钟表abcdefg眼镜\"],[\"305\",\"宠物abcdefg宠物食品abcdefg饲料\"],[\"319\",\"数码家电abcdefg办公设备\"],[\"323\",\"书籍abcdefg音像abcdefg文具abcdefg乐器\"],[\"123\",\"计生用品\"]],\"生活abcdefg咨询服务\":[[\"299\",\"婚庆abcdefg摄影\"],[\"306\",\"装饰abcdefg设计\"],[\"320\",\"家政abcdefg维修服务\"],[\"321\",\"广告abcdefg会展abcdefg活动策划\"],[\"143\",\"咨询abcdefg法律咨询abcdefg金融咨询等\"],[\"157\",\"职业社交abcdefg婚介abcdefg交友\"]],\"娱乐abcdefg健身服务\":[[\"300\",\"俱乐部abcdefg休闲会所\"],[\"148\",\"美容abcdefg健身类会所\"],[\"149\",\"游艺厅abcdefgKTVabcdefg网吧\"]],\"票务abcdefg旅游\":[[\"301\",\"旅馆abcdefg酒店abcdefg度假区\"],[\"307\",\"娱乐票务\"],[\"308\",\"交通票务\"]],\"网络虚拟服务\":[[\"302\",\"软件abcdefg建站abcdefg技术开发\"],[\"303\",\"网络推广abcdefg网络广告\"],[\"304\",\"游戏\"]],\"教育abcdefg培训\":[[\"147\",\"教育abcdefg培训abcdefg考试缴费abcdefg学费\"]],\"医疗\":[[\"230\",\"私立abcdefg民营医院abcdefg诊所\"],[\"322\",\"保健器械abcdefg医疗器械abcdefg非处方药品\"]],\"苗木abcdefg绿化\":[[\"324\",\"苗木种植abcdefg园林绿化\"]],\"通信\":[[\"155\",\"话费通讯\"]],\"生活缴费\":[[\"309\",\"生活缴费\"]],\"金融\":[[\"242\",\"财经资讯\"]],\"其他\":[[\"158\",\"其他行业\"]]},\"事业单位\":{\"医疗\":[[\"176\",\"公立医院\"],[\"177\",\"挂号平台\"]],\"教育abcdefg培训\":[[\"164\",\"公立院校\"]],\"其他生活缴费\":[[\"165\",\"水电煤缴费abcdefg交通罚款等生活缴费\"],[\"167\",\"事业单位\"],[\"290\",\"停车缴费\"],[\"291\",\"城市交通abcdefg高速收费\"],[\"170\",\"物业管理费\"],[\"172\",\"其他生活缴费\"]]}}";
    }

    public void convert() {
        Gson gson = new Gson();
        UnionEntity union = gson.fromJson(jsonStr, UnionEntity.class);
        Enterprise enterprise = union.get企业();
        Single single = union.get个体工商户();
        Work work = union.get事业单位();
        Map<String, List<List<String>>> enterpriseList = enterprise.toList();
        Map<String, List<List<String>>> singleList = single.toList();
        Map<String, List<List<String>>> workList = work.toList();

        makeSQL("企业", enterpriseList, "weixin", "netsunion");
        makeSQL("个体工商户", singleList, "weixin", "netsunion");
        makeSQL("事业单位", workList, "weixin", "netsunion");
    }

    private String makeSQL(String bigClass, Map<String, List<List<String>>> kvList, String pay_type, String channel_type) {
        StringBuilder sb = new StringBuilder();
        kvList.forEach((k, v) -> {
            for (List<String> level3 : v) {
                String eCode = level3.get(0);
                String eName = level3.get(1);
                String industry_name = "[''" + bigClass + "'',''" + k + "'',''" + eName + "'']";
                industry_name = industry_name.replace("abcdefg", "/");
                sb.append("insert into U_C_INDUSTRY_UNION (INDUSTRY_ID,INDUSTRY_NAME,PAY_TYPE,CHANNEL_TYPE) values ('" + eCode + "','" + industry_name + "', '" + pay_type + "', '" + channel_type + "'); ");
                sb.append("\n");
            }
        });


        String result = sb.toString();
        System.out.println(result);
        return result;
    }
}
