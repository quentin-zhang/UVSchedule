package com.uv.other.weixinyinlian;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class WXYLConverter {
    private String jsonStr = "";
    public WXYLConverter()
    {
        this.init();
    }
    private void init()
    {
        jsonStr = "{\"企业\":{\"网上购物\":[[\"203\",\"线上商超\"]],\"网上服务平台\":[[\"2\",\"团购服务平台\"],[\"95\",\"综合生活服务平台\"],[\"24\",\"旅游服务平台\"],[\"522\",\"订餐服务平台\"]],\"休闲娱乐\":[[\"281\",\"娱乐票务\"],[\"572\",\"院线影城\"],[\"573\",\"演出赛事\"],[\"54\",\"美容abcdefg健身类会所\"],[\"574\",\"美容abcdefg美发abcdefg美甲店\"],[\"280\",\"俱乐部abcdefg休闲会所\"],[\"56\",\"游艺厅abcdefgKTVabcdefg网吧\"],[\"571\",\"酒吧\"]],\"线下零售\":[[\"204\",\"超市\"],[\"205\",\"便利店\"],[\"206\",\"自动贩卖机\"],[\"207\",\"百货\"],[\"270\",\"食品\"],[\"310\",\"数码家电abcdefg电脑办公\"],[\"266\",\"家装建材abcdefg家具厨具\"],[\"271\",\"服饰abcdefg箱包abcdefg饰品\"],[\"6\",\"户外abcdefg运动abcdefg健身器材abcdefg安防\"],[\"267\",\"美妆abcdefg护肤\"],[\"19\",\"母婴用品abcdefg儿童玩具\"],[\"13\",\"计生用品\"],[\"9\",\"黄金珠宝abcdefg钻石abcdefg玉石\"],[\"272\",\"钟表abcdefg眼镜\"],[\"284\",\"宠物abcdefg宠物食品abcdefg饲料\"],[\"268\",\"鲜花abcdefg盆栽abcdefg室内装饰品\"],[\"585\",\"批发业\"],[\"315\",\"书籍abcdefg音像abcdefg文具abcdefg乐器\"]],\"餐饮\":[[\"545\",\"快餐\"],[\"543\",\"火锅\"],[\"544\",\"烧烤\"],[\"548\",\"小吃abcdefg熟食\"],[\"539\",\"其他中餐\"],[\"541\",\"日韩abcdefg东南亚菜\"],[\"540\",\"西餐\"],[\"542\",\"咖啡厅\"],[\"550\",\"甜品饮品\"],[\"549\",\"烘焙糕点\"]],\"居民生活abcdefg商业服务\":[[\"70\",\"物流abcdefg快递公司\"],[\"311\",\"家政abcdefg维修服务\"],[\"273\",\"婚庆abcdefg摄影\"],[\"564\",\"丧仪殡葬服务\"],[\"565\",\"搬家abcdefg回收\"],[\"538\",\"共享服务\"],[\"566\",\"宠物医院abcdefg宠物店\"],[\"317\",\"苗木种植abcdefg园林绿化\"],[\"289\",\"装饰abcdefg设计\"],[\"312\",\"广告abcdefg会展abcdefg活动策划\"],[\"42\",\"咨询abcdefg法律咨询abcdefg金融咨询等\"],[\"93\",\"人才中介机构abcdefg招聘猎头\"],[\"94\",\"职业社交abcdefg婚介abcdefg交友\"],[\"316\",\"房地产\"]],\"交通出行abcdefg票务旅游\":[[\"77\",\"租车\"],[\"274\",\"机票abcdefg机票代理\"],[\"610\",\"高速收费\"],[\"283\",\"交通票务\"],[\"288\",\"城市交通abcdefg高速收费\"],[\"259\",\"加油\"],[\"287\",\"停车缴费\"],[\"269\",\"交通工具abcdefg配件abcdefg改装\"],[\"563\",\"汽车美容abcdefg维修保养\"],[\"75\",\"港口经营港口理货\"],[\"354\",\"景区\"],[\"275\",\"旅馆abcdefg酒店abcdefg度假区\"],[\"23\",\"旅行社\"]],\"网络媒体abcdefg计算机服务abcdefg游戏\":[[\"276\",\"在线图书abcdefg视频abcdefg音乐\"],[\"277\",\"软件abcdefg建站abcdefg技术开发\"],[\"278\",\"网络推广abcdefg网络广告\"],[\"501\",\"游戏\"],[\"104\",\"门户abcdefg资讯abcdefg论坛\"],[\"521\",\"网络直播\"]],\"教育abcdefg医疗\":[[\"52\",\"教育abcdefg培训abcdefg考试缴费abcdefg学费\"],[\"53\",\"私立院校\"],[\"282\",\"保健信息咨询平台\"],[\"66\",\"私立abcdefg民营医院abcdefg诊所\"],[\"67\",\"挂号平台\"]],\"收藏abcdefg拍卖\":[[\"285\",\"文物经营abcdefg文物复制品销售\"],[\"325\",\"拍卖abcdefg典当\"],[\"31\",\"非文物类收藏品\"]],\"生活缴费\":[[\"80\",\"电信运营商\"],[\"81\",\"宽带收费\"],[\"92\",\"话费通讯\"],[\"58\",\"有线电视缴费\"],[\"60\",\"物业管理费\"],[\"57\",\"水电煤缴费abcdefg交通罚款等生活缴费\"],[\"62\",\"其他生活缴费\"]],\"金融\":[[\"112\",\"众筹\"],[\"318\",\"保险业务\"],[\"96\",\"财经资讯\"],[\"97\",\"股票软件类\"],[\"326\",\"信用还款\"]],\"其他\":[[\"111\",\"其他行业\"]]},\"个体工商户\":{\"餐饮\":[[\"557\",\"快餐\"],[\"555\",\"火锅\"],[\"556\",\"烧烤\"],[\"560\",\"小吃abcdefg熟食\"],[\"551\",\"其他中餐\"],[\"553\",\"日韩abcdefg东南亚菜\"],[\"552\",\"西餐\"],[\"554\",\"咖啡厅\"],[\"562\",\"甜品饮品\"],[\"561\",\"烘焙糕点\"]],\"线下零售\":[[\"209\",\"便利店\"],[\"292\",\"食品\"],[\"319\",\"数码家电abcdefg办公设备\"],[\"293\",\"家装建材abcdefg家居家纺\"],[\"297\",\"服饰abcdefg箱包abcdefg饰品\"],[\"116\",\"户外abcdefg运动abcdefg健身器材abcdefg安防\"],[\"294\",\"美妆abcdefg护肤\"],[\"129\",\"母婴用品abcdefg儿童玩具品\"],[\"123\",\"计生用品\"],[\"323\",\"书籍abcdefg音像abcdefg文具abcdefg乐器\"],[\"298\",\"钟表abcdefg眼镜\"],[\"305\",\"宠物abcdefg宠物食品abcdefg饲料\"],[\"295\",\"鲜花abcdefg盆栽abcdefg室内装饰品\"],[\"586\",\"批发业\"]],\"居民生活abcdefg商业服务\":[[\"299\",\"婚庆abcdefg摄影\"],[\"568\",\"丧仪殡葬服务\"],[\"569\",\"搬家abcdefg回收\"],[\"570\",\"宠物医院abcdefg宠物店\"],[\"143\",\"咨询abcdefg法律咨询abcdefg金融咨询等\"],[\"306\",\"装饰abcdefg设计\"],[\"320\",\"家政abcdefg维修服务\"],[\"321\",\"广告abcdefg会展abcdefg活动策划\"],[\"157\",\"职业社交abcdefg婚介abcdefg交友\"],[\"324\",\"苗木种植abcdefg园林绿化\"]],\"休闲娱乐\":[[\"578\",\"娱乐票务\"],[\"579\",\"演出赛事\"],[\"148\",\"美容abcdefg健身类会所\"],[\"580\",\"美容abcdefg美发abcdefg美甲店\"],[\"300\",\"俱乐部abcdefg休闲会所\"],[\"149\",\"游艺厅abcdefgKTVabcdefg网吧\"],[\"577\",\"酒吧\"]],\"交通运输服务\":[[\"296\",\"交通工具abcdefg配件abcdefg改装\"],[\"567\",\"汽车美容abcdefg维修服务\"]],\"网络媒体abcdefg计算机服务abcdefg游戏\":[[\"502\",\"游戏\"],[\"302\",\"软件abcdefg建站abcdefg技术开发\"],[\"303\",\"网络推广abcdefg网络广告\"]],\"教育abcdefg医疗\":[[\"147\",\"教育abcdefg培训abcdefg考试缴费abcdefg学费\"],[\"322\",\"保健器械abcdefg医疗器械abcdefg非处方药品\"],[\"230\",\"私立abcdefg民营医院abcdefg诊所\"]],\"生活缴费\":[[\"309\",\"其他生活缴费\"]],\"金融\":[[\"242\",\"财经资讯\"]],\"交通出行abcdefg票务旅游\":[[\"301\",\"旅馆abcdefg酒店abcdefg度假区\"],[\"308\",\"交通票务\"],[\"340\",\"加油\"]],\"其他\":[[\"158\",\"其他行业\"]]},\"政府及事业单位\":{\"教育abcdefg医疗\":[[\"164\",\"公立院校\"],[\"176\",\"公立医院\"],[\"177\",\"挂号平台\"]],\"交通运输服务\":[[\"290\",\"停车缴费\"]],\"其他生活缴费\":[[\"165\",\"水电煤缴费abcdefg交通罚款等生活缴费\"],[\"167\",\"事业单位\"],[\"170\",\"物业管理费\"],[\"172\",\"其他生活缴费\"],[\"506\",\"其他生活缴费\"]]},\"其他组织\":{\"教育abcdefg医疗\":[[\"506\",\"教育abcdefg培训abcdefg考试缴费abcdefg学费\"],[\"517\",\"私立院校\"],[\"534\",\"私立abcdefg民营医院abcdefg诊所\"]],\"生活abcdefg咨询服务\":[[\"523\",\"咨询abcdefg法律咨询abcdefg金融咨询等\"]],\"交通运输abcdefg票务旅游\":[[\"509\",\"宗教\"],[\"535\",\"娱乐票务\"],[\"537\",\"机票abcdefg机票代理\"],[\"510\",\"公益\"]]}}";
    }

    public void convert()
    {
        Gson gson = new Gson();
        UnionEntity union = gson.fromJson(jsonStr, UnionEntity.class);
        Enterprise enterprise = union.get企业();
        Single single = union.get个体工商户();
        Work work = union.get政府及事业单位();
        Other other = union.get其他组织();
        Map<String,List<List<String>>> enterpriseList = enterprise.toList();
        Map<String,List<List<String>>>  singleList = single.toList();
        Map<String,List<List<String>>>  workList = work.toList();
        Map<String,List<List<String>>>  otherList = other.toList();

        makeSQL("企业",enterpriseList,"weixin","unionpay");
        makeSQL("个体工商户",singleList,"weixin","unionpay");
        makeSQL("企业及事业单位",workList,"weixin","unionpay");
        makeSQL("其他组织",otherList,"weixin","unionpay");
    }

    private String makeSQL(String bigClass,Map<String,List<List<String>>> kvList,String pay_type,String channel_type)
    {
        StringBuilder sb = new StringBuilder();
        kvList.forEach((k,v)->{
            for(List<String> level3: v)
            {
                String eCode = level3.get(0);
                String eName = level3.get(1);
                String industry_name = "[''"+ bigClass+"'',''"+k+"'',''" + eName +"'']";
                industry_name = industry_name.replace("abcdefg","/");
                sb.append("insert into U_C_INDUSTRY_UNION (INDUSTRY_ID,INDUSTRY_NAME,PAY_TYPE,CHANNEL_TYPE) values ('" + eCode +"','" + industry_name + "', '"+ pay_type +"', '"+channel_type+"'); " );
                sb.append("\n");
            }
        });


        String result =sb.toString();
        System.out.println(result);
        return result;
    }
}
