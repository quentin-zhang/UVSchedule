package com.uv.other.zhifubaonet;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class ZFBUnionPayConverter {
    private String jsonStr = "";
    public ZFBUnionPayConverter()
    {
        this.init();
    }
    private void init()
    {
        jsonStr = "{\"生活百货\":{\"百货商城\":[[5411,\"超市（非平台类）\"],[5914,\"成人用品abcdefg避孕用品abcdefg情趣内衣\"],[5309,\"国外代购及免税店\"],[5300,\"会员制批量零售店\"],[5311,\"平台类综合商城\"],[5999,\"其他专业零售店\"],[5399,\"其他综合零售\"],[5984,\"烟花爆竹\"],[5983,\"油品燃料经销\"],[5331,\"杂货店\"],[5998,\"帐篷和遮阳篷商店\"],[5715,\"酒精饮料批发商（国际专用）\"]],\"服饰鞋包\":[[5697,\"裁缝、修补、改衣制衣\"],[5691,\"高档时装及奢侈品\"],[5699,\"各类服装及饰物\"],[5948,\"行李箱包\"],[5698,\"假发等饰品\"],[5611,\"男性服饰\"],[5651,\"内衣abcdefg家居服\"],[5621,\"女性成衣\"],[5631,\"配饰商店\"],[5681,\"皮草皮具\"],[5661,\"鞋类\"],[5139,\"鞋类销售平台（批发商）\"],[5137,\"制服与商务正装定制\"]],\"家居家纺建材\":[[5718,\"壁炉、屏风\"],[5231,\"玻璃、油漆涂料、墙纸\"],[5131,\"布料、缝纫用品和其他纺织品（批发商）\"],[5261,\"草坪和花园用品\"],[5714,\"窗帘、帷幕、室内装潢\"],[5200,\"大型仓储式家庭用品卖场\"],[5713,\"地板和地毯\"],[5719,\"各种家庭装饰专营\"],[5193,\"花木栽种用品、苗木和花卉（批发商）\"],[5712,\"家具abcdefg家庭摆设\"],[5949,\"家用纺织品\"],[5251,\"家用五金工具\"],[5211,\"木材与建材商店\"],[5039,\"未列入其他代码的建材（批发商）\"],[5198,\"油漆、清漆用品（批发商）\"],[5996,\"游泳、SPA、洗浴设备\"]],\"美妆珠宝配饰\":[[5977,\"化妆品\"],[5997,\"男士用品：剃须刀、烟酒具、瑞士军刀\"],[5944,\"钟表店\"],[5094,\"珠宝和金银饰品\"]],\"母婴玩具\":[[5641,\"母婴用品\"],[5945,\"玩具、游戏用品\"]],\"数码家电\":[[5722,\"家用电器\"],[5045,\"商用计算机及服务器\"],[4812,\"手机、通讯设备销售\"],[5732,\"数码产品及配件\"],[5946,\"专业摄影器材\"]],\"图书音像\":[[5994,\"报纸、杂志\"],[5192,\"书、期刊和报纸（批发商）\"],[5942,\"书籍\"],[5735,\"音像制品\"]],\"文化玩乐宠物\":[[5995,\"宠物及宠物用品\"],[5950,\"瓷器、玻璃和水晶摆件\"],[5970,\"工艺美术用品\"],[5937,\"古玩复制品（赝品）\"],[5992,\"花店\"],[7993,\"家用电子游戏\"],[5931,\"旧商品店、二手商品店\"],[5733,\"乐器\"],[5947,\"礼品、卡片、纪念品\"],[5932,\"文物古董\"],[5971,\"艺术品和画廊\"],[5972,\"邮票abcdefg纪念币\"],[5973,\"宗教物品\"]],\"饮食保健\":[[5467,\"保健品\"],[5812,\"餐厅、订餐服务\"],[5466,\"茶叶\"],[5813,\"酒吧、舞厅、夜总会\"],[5921,\"酒类\"],[5815,\"咖啡厅、茶馆\"],[5814,\"快餐店\"],[5462,\"面包糕点\"],[5499,\"其他食品零售\"],[5422,\"肉、禽、蛋及水产品\"],[5451,\"乳制品abcdefg冷饮\"],[5423,\"水果店\"],[5441,\"糖果及坚果商店\"],[5993,\"烟草abcdefg雪茄\"],[5811,\"宴会提供商\"],[5880,\"校园团餐\"],[5881,\"综合团餐\"]],\"运动户外\":[[5941,\"体育用品abcdefg器材\"],[5655,\"运动服饰\"],[5940,\"自行车及配件\"]]},\"专业销售\":{\"办公用品\":[[5044,\"办公、影印及微缩摄影器材（批发商）\"],[5021,\"办公及商务家具（批发商）\"],[5978,\"打字设备、打印复印机、扫描仪\"],[5046,\"未列入其他代码的商用器材\"],[5111,\"文具、办公用品、复印纸和书写纸（批发商）\"],[5943,\"文具及办公用品\"]],\"工业产品\":[[5065,\"电气产品和设备\"],[5085,\"工业设备和制成品\"],[5074,\"管道及供暖设备\"],[5169,\"化工产品\"],[5051,\"金属产品和服务（批发商）\"],[5099,\"其他工业耐用品\"],[5199,\"其他工业原料和消耗品\"],[5172,\"石油及石油产品（批发商）\"],[5072,\"五金器材及用品（批发商）\"]],\"汽车和运输工具\":[[5551,\"船舶及配件销售\"],[5572,\"电动车及配件\"],[5521,\"二手车销售\"],[5565,\"飞机及配件、航道设施\"],[5564,\"轨道交通设备器材\"],[5271,\"活动房车销售商\"],[5013,\"机动车供应及零配件（批发商）\"],[5599,\"机动车综合经营\"],[5542,\"加油卡、加油服务\"],[5541,\"加油站、服务站\"],[5592,\"露营及旅行汽车\"],[5571,\"摩托车及配件\"],[5533,\"汽车零配件\"],[5532,\"汽车轮胎经销\"],[5511,\"汽车销售\"],[5561,\"拖车、篷车及娱乐用车\"],[5598,\"雪车\"],[5566,\"运输搬运设备、起重装卸设备\"],[5531,\"汽车商店、家庭用品商店（国际专用）\"]],\"药品医疗\":[[5976,\"康复和身体辅助用品\"],[5122,\"药品、药品经营者（批发商）\"],[5912,\"药物\"],[5047,\"医疗器械\"],[5975,\"助听器\"]]},\"网络虚拟\":{\"彩票\":[[7995,\"彩票\"]],\"电信通讯\":[[4814,\"电信运营商\"],[4899,\"付费电视\"],[4815,\"话费充值与缴费\"],[4821,\"网络电话、传真\"]],\"互联网服务\":[[7409,\"SNS社交网站\"],[4816,\"互联网IDC服务\"],[5734,\"计算机软件\"],[7379,\"计算机维护和修理服务\"],[7374,\"门户网站\"],[7413,\"其他在线应用或综合类\"],[7372,\"软件系统商\"],[7414,\"视频点播\"],[7412,\"手机图铃\"],[7373,\"网络论坛\"],[7408,\"网站设计、推广\"],[7375,\"信息检索服务（信息平台）\"],[7410,\"休闲游戏\"],[7411,\"在线文学类\"],[5816,\"数字类产品游戏（国际专用）\"],[5817,\"数字类产品软件提供商\"],[5818,\"数字类产品其他（国际专用）\"]],\"数娱网游\":[[7954,\"网络游戏点卡、渠道代理\"],[7958,\"网游运营商（含网页游戏）\"],[7957,\"网游周边服务、交易平台\"],[7956,\"游戏系统商\"]],\"娱乐票务\":[[7933,\"保龄球\"],[7994,\"电玩娱乐场所\"],[7832,\"电影院及电影票\"],[7998,\"动物园、水族馆\"],[7992,\"高尔夫球场\"],[7911,\"歌舞厅abcdefg夜店\"],[7997,\"健身和运动俱乐部\"],[7929,\"乐队和文艺表演\"],[7999,\"其他娱乐服务\"],[7990,\"棋牌室\"],[7941,\"体育场馆\"],[7989,\"网吧\"],[7922,\"演出票务服务\"],[7829,\"艺术创作服务\"],[7841,\"音像制品出租\"],[7996,\"游乐园、马戏团、嘉年华\"],[7991,\"展览和艺术场馆\"],[7932,\"桌球abcdefg桌游\"]]},\"商业及生活服务\":{\"承包商hijk\":[[1731,\"电器承包商\"],[1771,\"混凝土承包商\"],[1740,\"建筑材料承包商\"],[1761,\"金属产品承包商\"],[\"0780\",\"景观美化与园艺服务\"],[\"0763\",\"农业合作与农具\"],[\"0743\",\"葡萄酒生产商\"],[1799,\"其他工程承包商\"],[\"0744\",\"其他酒类生产商\"],[\"0742\",\"兽医服务\"],[742,\"兽医服务\"],[743,\"葡萄酒生产商\"],[744,\"其他酒类生产商\"],[763,\"农业合作与农具\"],[780,\"景观美化与园艺服务\"],[1711,\"空调类承包商\"],[1750,\"木工承包商\"]],\"房地产\":[[7013,\"不动产代理——房地产经纪\"],[6513,\"不动产管理－物业管理\"],[1520,\"房地产开发商\"]],\"公共事业\":[[4906,\"充电桩\"],[4900,\"公共事业（电、气、水）\"],[4901,\"公共事业-电力缴费\"],[4902,\"公共事业-煤气缴费\"],[4904,\"公共事业-清洁服务缴费\"],[4903,\"公共事业-自来水缴费\"],[4905,\"图书馆\"],[4908,\"其他缴费\"],[4909,\"有线电视缴费\"]],\"金融服务\":[[6301,\"保险代理\"],[6300,\"保险公司\"],[5933,\"典当行\"],[4829,\"电汇和汇票服务\"],[6760,\"个人资金借贷\"],[6050,\"贵金属投资\"],[6068,\"借贷消费平台\"],[6012,\"金融机构-其他服务\"],[6010,\"金融机构-商业银行服务\"],[6011,\"金融机构-自动现金服务\"],[6064,\"金融租赁公司\"],[6062,\"汽车金融公司\"],[6067,\"融资担保公司\"],[6063,\"融资租赁公司\"],[6051,\"外币汇兑\"],[6061,\"消费金融公司\"],[6060,\"小贷公司\"],[6065,\"信托公司\"],[6211,\"证券期货基金\"],[6066,\"支付机构\"],[6069,\"P2P\"],[6070,\"网络借贷信息撮合平台\"]],\"汽车租赁和服务\":[[7519,\"房车和娱乐车辆出租\"],[7513,\"卡车及拖车出租\"],[7534,\"轮胎翻新、维修\"],[7512,\"汽车出租\"],[7538,\"汽车改造等服务（非经销商）\"],[7535,\"汽车喷漆店\"],[7531,\"汽车维修、保养、美容装饰\"],[7523,\"停车服务\"],[7549,\"拖车服务\"],[7542,\"洗车\"]],\"商业服务\":[[7393,\"保安和监控服务\"],[2741,\"出版印刷服务\"],[7338,\"复印及绘图服务\"],[7392,\"公关和企业管理服务\"],[7311,\"广告服务\"],[5935,\"海上船只遇难救助\"],[2791,\"刻版排版服务\"],[7361,\"猎头、职业中介\"],[7342,\"灭虫及消毒服务\"],[7399,\"其他商业服务\"],[7349,\"清洁、保养及门卫服务\"],[2842,\"清洁抛光服务\"],[7340,\"商户拓展\"],[7333,\"商业摄影、设计、绘图服务\"],[7395,\"商业摄影摄像服务\"],[7394,\"设备、工具、家具和电器出租\"],[7339,\"文字处理abcdefg翻译速记\"],[7322,\"债务催收机构\"],[7321,\"征信和信用报告咨询服务\"]],\"生活服务\":[[7297,\"按摩服务\"],[7276,\"财务债务咨询\"],[7278,\"导购、经纪和拍卖服务\"],[7296,\"服装出租\"],[7216,\"干洗店\"],[7273,\"婚介服务\"],[7277,\"婚庆服务\"],[7295,\"家政服务\"],[7231,\"美甲\"],[7230,\"美容abcdefg美发服务\"],[7298,\"美容SPA和美体保健\"],[7261,\"丧仪殡葬服务\"],[7221,\"摄影服务\"],[7217,\"室内清洁服务\"],[7210,\"洗衣服务\"],[7211,\"洗熨服务（自助洗衣服务）\"],[7251,\"鞋帽清洗\"],[7299,\"其他生活服务\"],[7511,\"货品停放交易(国际专用)\"]],\"团购\":[[5310,\"团购及折扣店\"]],\"维修服务\":[[7629,\"办公电器和小家电维修\"],[7622,\"电器维修\"],[7699,\"各类维修相关服务\"],[7692,\"焊接维修服务\"],[7641,\"家具维修、翻新\"],[7623,\"空调、制冷设备维修\"],[7631,\"手表、钟表和首饰维修店\"]],\"直销\":[[5960,\"保险直销（代扣）\"],[5967,\"电话接入直销\"],[5966,\"电话外呼直销\"],[5968,\"订阅订购服务\"],[5962,\"旅游相关服务直销\"],[5964,\"目录直销平台\"],[5963,\"上门直销（直销员）\"],[5969,\"直销\"],[5965,\"直销代理\"]],\"无人值守服务\":[[6071,\"自助贩卖机\"],[6072,\"自助零售\"],[6073,\"自助借还\"],[6074,\"自助娱乐服务\"],[6075,\"其他自助生活服务\"]]},\"航旅交通\":{\"公共交通\":[[4121,\"出租车服务（TAXI）\"],[4457,\"出租船只\"],[4468,\"船舶、海运服务提供商\"],[4111,\"公共交通\"],[4119,\"急救服务\"],[4784,\"路桥通行费\"],[4011,\"铁路货运\"],[4112,\"铁路客运\"],[4411,\"游轮及巡游航线服务\"],[4131,\"长途公路客运\"],[4113,\"ETC不停车自动缴费\"],[4114,\"MTC半自动车道收费\"],[4115,\"地铁\"]],\"航空票务\":[[4511,\"航空公司\"],[4514,\"航空系统商\"],[4582,\"机场服务\"],[4512,\"机票代理人\"],[4513,\"机票平台\"]],\"旅行住宿\":[[4733,\"大型旅游景点\"],[7012,\"度假用别墅服务\"],[4723,\"国际货运代理和报关行\"],[7033,\"活动房车场及野营场所 \"],[4722,\"旅行社和旅游服务\"],[4789,\"未列入其他代码的运输服务\"],[7032,\"运动和娱乐露营\"],[7011,\"住宿服务（旅馆、酒店、汽车旅馆、度假村等）\"]],\"物流仓储\":[[4225,\"公共仓储、集装整理\"],[4215,\"快递服务\"],[4214,\"物流货运服务\"]]},\"专业服务\":{\"教育服务\":[[8220,\"大学与学院\"],[8351,\"儿童保育服务（学前教育）\"],[8241,\"函授学校（成人教育）\"],[8299,\"其他学校和教育服务\"],[8244,\"商业和文秘学校\"],[8298,\"少年宫及青少年发展中心\"],[8249,\"职业技能培训\"],[8211,\"中小学校\"]],\"其他\":[[9702,\"GCAS紧急服务（仅限Visa使用）\"],[9701,\"Visa信任服务\"],[9715,\"档案\"],[9752,\"电子档案\"],[9950,\"站内清算\"]],\"社会组织\":[[8398,\"慈善和社会公益服务\"],[8641,\"行业协会和专业社团\"],[8699,\"其他会员组织\"],[8675,\"汽车协会\"],[8651,\"政府机构\"],[8661,\"宗教组织\"]],\"医疗服务\":[[8041,\"按摩医生\"],[8062,\"公立医院\"],[8050,\"护理和照料服务\"],[8061,\"民营医院\"],[8099,\"其他医疗保健服务\"],[8011,\"诊所\"],[8049,\"公立社区卫生服务中心、卫生院\"],[8021,\"牙科医生\"],[8043,\"眼镜店\"],[8042,\"眼科医疗服务\"],[8071,\"医学及牙科实验室\"],[8031,\"正骨医生\"]],\"政府服务\":[[9223,\"保释金\"],[9211,\"法庭费用\"],[9402,\"国家邮政\"],[9222,\"行政费用和罚款\"],[9399,\"社会保障服务\"],[9400,\"使领馆\"],[9311,\"税务、海关\"],[9405,\"政府采购\"],[9411,\"政府贷款\"]],\"专业咨询\":[[8734,\"测试实验服务\"],[8111,\"法律咨询和律师事务所\"],[8931,\"会计、审计、财务服务\"],[8911,\"建筑、工程和测量服务\"],[8999,\"其他专业服务\"],[8912,\"装修、装潢、园艺\"]]}}";
    }

    public void convert()
    {
        Gson gson = new Gson();
        UnionEntity union = gson.fromJson(jsonStr, UnionEntity.class);
        Life life = union.get生活百货();
        Sale sale = union.get专业销售();
        NetVirtual netVirtual = union.get网络虚拟();
        Business business = union.get商业及生活服务();
        Traffic traffic = union.get航旅交通();
        Professional professional = union.get专业服务();

        Map<String,List<List<String>>> lifeList = life.toList();
        Map<String,List<List<String>>>  saleList = sale.toList();
        Map<String,List<List<String>>>  netVirtualList = netVirtual.toList();
        Map<String,List<List<String>>>  businessList = business.toList();
        Map<String,List<List<String>>>  trafficList = traffic.toList();
        Map<String,List<List<String>>>  professionalList = professional.toList();

        makeSQL("生活百货",lifeList,"zhifubao","unionpay");
        makeSQL("专业销售",saleList,"zhifubao","unionpay");
        makeSQL("网络虚拟",netVirtualList,"zhifubao","unionpay");
        makeSQL("商业及生活服务",businessList,"zhifubao","unionpay");
        makeSQL("航旅交通",trafficList,"zhifubao","unionpay");
        makeSQL("专业服务",professionalList,"zhifubao","unionpay");
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
                industry_name = industry_name.replace("hijk","（农业、建筑、出版）");
                sb.append("insert into U_C_INDUSTRY_UNION (INDUSTRY_ID,INDUSTRY_NAME,PAY_TYPE,CHANNEL_TYPE) values ('" + eCode +"','" + industry_name + "', '"+ pay_type +"', '"+channel_type+"'); " );
                sb.append("\n");
            }
        });


        String result =sb.toString();
        System.out.println(result);
        return result;
    }
}
