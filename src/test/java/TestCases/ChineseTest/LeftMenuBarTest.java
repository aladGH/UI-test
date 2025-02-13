package TestCases.ChineseTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LeftMenuBarTest {

    private BasePage loginPage;
    private BasePage LeftMenuBar;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPage = new BasePage("loginPage","ChineseTestOld/LoginPage.xml");
        LeftMenuBar = new BasePage("LeftMenuBar", "ChineseTestOld/LeftMenuBar.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //左侧菜单栏按钮
    @Test(priority = 1)
    public void LeftMenuBar() throws Exception{

        //解决方案
        $(LeftMenuBar.byElement("解决方案")).should(exist);

        //工单
        $(LeftMenuBar.byElement("工单")).should(exist).hover();
        //提交工单存在
        $(LeftMenuBar.byElement("提交工单存在")).should(exist);
        //我的工单存在
        $(LeftMenuBar.byElement("我的工单存在")).should(exist);

        //数据统计
        $(LeftMenuBar.byElement("数据统计")).should(exist);

        //服务监控平台
        $(LeftMenuBar.byElement("服务监控平台")).should(exist);

        //订单
        $(LeftMenuBar.byElement("订单")).should(exist);

        //账单
        $(LeftMenuBar.byElement("账单")).should(exist).hover();
        //账单总览存在
        $(LeftMenuBar.byElement("账单总览存在")).should(exist);
        //账单明细存在
        $(LeftMenuBar.byElement("账单明细存在")).should(exist);

        //流水明细
        $(LeftMenuBar.byElement("流水明细")).should(exist);

        //代金券
        $(LeftMenuBar.byElement("代金券")).should(exist);

        //资源包
        $(LeftMenuBar.byElement("资源包")).should(exist);

        //发票
        $(LeftMenuBar.byElement("发票")).should(exist);
    }

    //解决方案
    @Test(priority = 2)
    public void Solution() throws Exception{

        //解决方案按钮存在并点击进入页面
        $(LeftMenuBar.byElement("解决方案按钮存在并点击进入页面")).should(exist).click();

        //语聊房
        //卡片
        $(LeftMenuBar.byElement("语聊房-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("语聊房-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
        //标题
        $(LeftMenuBar.byElement("语聊房-标题")).shouldBe(text("语聊房"));
        //文案
        $(LeftMenuBar.byElement("语聊房-文案")).shouldBe(text("多人语音聊天室是娱乐社交的典型玩法，支持1+N连麦互动的纯音频房间和万人聊天室。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("语聊房-查看详情跳转")).shouldHave(href("https://yunxin.163.com/voicechat"));

        //智能手表
        //卡片
        $(LeftMenuBar.byElement("智能手表-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("智能手表-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(LeftMenuBar.byElement("智能手表-标题")).shouldBe(text("智能手表"));
        //文案
        $(LeftMenuBar.byElement("智能手表-文案")).shouldBe(text("为智能手表行业提供低功耗、清晰流畅的音视频通话能力，为不同特性的客户提供更具适用性的解决方案。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("智能手表-查看详情跳转")).shouldHave(href("https://yunxin.163.com/smartwatch"));

        //小程序
        //卡片
        $(LeftMenuBar.byElement("小程序-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("小程序-图片")).shouldHave(image);
        //校验图片地址：shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(LeftMenuBar.byElement("小程序-标题")).shouldBe(text("小程序"));
        //文案
        $(LeftMenuBar.byElement("小程序-文案")).shouldBe(text("网易云信结合微信生态圈开放能力与云信在IM和音视频上的技术积累，为客户提供IM、聊天室、直播点播等小程序方案。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("小程序-查看详情跳转")).shouldHave(href("https://yunxin.163.com/wechatApplets"));

        //智慧医院
        //卡片
        $(LeftMenuBar.byElement("智慧医院-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("智慧医院-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));

        //标题
        $(LeftMenuBar.byElement("智慧医院-标题")).shouldBe(text("智慧医院"));
        //文案
        $(LeftMenuBar.byElement("智慧医院-文案")).shouldBe(text("提供私有化部署等核心能力，助力行业客户建立医疗商业闭环，最大化提升医疗资源利用率与医院协同效，打造医疗服务新模式"));
        //查看详情跳转
        $(LeftMenuBar.byElement("智慧医院-查看详情跳转")).shouldHave(href("https://yunxin.163.com/medhos"));


        //远程面签
        //卡片
        $(LeftMenuBar.byElement("远程面签-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("远程面签-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/faceSign.png"));

        //标题
        $(LeftMenuBar.byElement("远程面签-标题")).shouldBe(text("远程面签"));
        //文案
        $(LeftMenuBar.byElement("远程面签-文案")).shouldBe(text("基于音视频通话、IM即时通信、点播录制&转码、互动直播技术，实现远程视频面签和视频双录。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("远程面签-查看详情跳转")).shouldHave(href("https://yunxin.163.com/finance#remoteSign"));


        //企业服务
        //卡片
        $(LeftMenuBar.byElement("企业服务-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("企业服务-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));

        //标题
        $(LeftMenuBar.byElement("企业服务-标题")).shouldBe(text("企业服务"));
        //文案
        $(LeftMenuBar.byElement("企业服务-文案")).shouldBe(text("首创性实现企业生态圈内互联互通，为中大型企业提供自主可控、安全私密的一站式企业服务解决方案。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("企业服务-查看详情跳转")).shouldHave(href("https://yunxin.163.com/nice"));


        //电视端视频通话
        //卡片
        $(LeftMenuBar.byElement("电视端视频通话-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("电视端视频通话-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/netcallTv.png"));

        //标题
        $(LeftMenuBar.byElement("电视端视频通话-标题")).shouldBe(text("电视端视频通话"));
        //文案
        $(LeftMenuBar.byElement("电视端视频通话-文案")).shouldBe(text("高品质的电视端点对点和多人音视频通话通话解决方案，全方位满足不同功能需求，高效解决电视端音视频通话开发难题。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("电视端视频通话-查看详情跳转")).shouldHave(href("https://yunxin.163.com/netcall-tv"));


//        //音乐教学
//        //卡片
//        $(LeftMenuBar.byElement("音乐教学-卡片")).should(exist);
//        //图片
//        $(LeftMenuBar.byElement("音乐教学-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
//
//        //标题
//        $(LeftMenuBar.byElement("音乐教学-标题")).shouldBe(text("音乐教学"));
//        //文案
//        $(LeftMenuBar.byElement("音乐教学-文案")).shouldBe(text("结合网易集团多年教育行业与音乐领域的经验，将音视频能力深研，满足音乐教学场景中对画面与音质的极致追求。"));
//        //查看详情跳转
//        $(LeftMenuBar.byElement("音乐教学-查看详情跳转")).shouldHave(href("https://yunxin.163.com/edu-music"));


        //在线教育
        //卡片
        $(LeftMenuBar.byElement("在线教育-卡片")).should(exist);
        //图片
        $(LeftMenuBar.byElement("在线教育-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/edu.png"));

        //标题
        $(LeftMenuBar.byElement("在线教育-标题")).shouldBe(text("在线教育"));
        //文案
        $(LeftMenuBar.byElement("在线教育-文案")).shouldBe(text("网易集团深耕在线教育领域多年，网易云从视频与通讯技术为切入点打造多场景、高可用的教育直播方案。"));
        //查看详情跳转
        $(LeftMenuBar.byElement("在线教育-查看详情跳转")).shouldHave(href("https://yunxin.163.com/edu"));


//        //虚拟人
//        //卡片
//        $(LeftMenuBar.byElement("虚拟人-卡片")).should(exist);
//        //图片
//        $(LeftMenuBar.byElement("虚拟人-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/xuNiRen.png"));
//
//        //标题
//        $(LeftMenuBar.byElement("虚拟人-标题")).shouldBe(text("虚拟人"));
//        //文案
//        $(LeftMenuBar.byElement("虚拟人-文案")).shouldBe(text("提供虚拟人解决方案，应用于娱乐社交、电商直播、秀场直播、虚拟客服等场景，为用户提供更实时、更可靠的沉浸式体验。"));
//        //查看详情跳转
//        $(LeftMenuBar.byElement("虚拟人-查看详情跳转")).shouldHave(href("https://yunxin.163.com/virtual-human"));

    }

    //工单
    @Test(priority = 3)
    public void Issue() throws Exception{

        //创建工单页面
        $(LeftMenuBar.byElement("工单-工单按钮")).hover();
        $(LeftMenuBar.byElement("工单-提交工单按钮")).click();
        sleep(3000);

        //产品咨询
        //图片-背景图无法判断是否加载完毕
        //标题
        $(LeftMenuBar.byElement("工单-IM即时通讯-标题")).getText().equals("IM即时通讯");
        //文案
        $(LeftMenuBar.byElement("工单-IM即时通讯-文案")).shouldBe(text("登录、抄送、消息收发、推送等问题"));
        //按钮（新版没有按钮了，所有都没了）
//        $(LeftMenuBar.byElement("工单-产品咨询-按钮")).shouldHave(href("https://yunxin.163.com/bizQQWPA.html"));

        //红包
        //标题
//        $(LeftMenuBar.byElement("工单-红包-标题")).shouldBe(text("红包"));
        //文案
//        $(LeftMenuBar.byElement("工单-红包-文案")).shouldBe(text("易于集成，安全合规，支持单聊、群组、聊天室场景"));
        //按钮
//        $(LeftMenuBar.byElement("工单-红包-按钮")).shouldHave(href("#/issue/create/12"));

        //IM即时通讯
        //标题
//        $(LeftMenuBar.byElement("工单-IM即时通讯-标题")).shouldBe(text("IM即时通讯"));
        //文案
//        $(LeftMenuBar.byElement("工单-IM即时通讯-文案")).shouldBe(text("支持单聊、群聊、聊天室，适用所有APP"));
        //按钮
//        $(LeftMenuBar.byElement("工单-IM即时通讯-按钮")).shouldHave(href("#/issue/create/1"));

        //音视频通话2.0
        //标题
        $(LeftMenuBar.byElement("工单-音视频通话2.0-标题")).getText().equals("音视频通话2.0");
        //文案
        $(LeftMenuBar.byElement("工单-音视频通话2.0-文案")).shouldBe(text("声音、画面、卡顿、抄送、Crash等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-音视频通话2.0-按钮")).shouldHave(href("#/issue/create/14"));

        //音视频通话1.0
        //标题
        $(LeftMenuBar.byElement("工单-音视频通话1.0-标题")).shouldBe(text("音视频通话1.0"));
        //文案
        $(LeftMenuBar.byElement("工单-音视频通话1.0-文案")).shouldBe(text("Crash、接口、画面、声音、抄送等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-音视频通话1.0-按钮")).shouldHave(href("#/issue/create/2"));

        //短信
        //标题
        $(LeftMenuBar.byElement("工单-短信-标题")).getText().equals("短信");
        //文案
        $(LeftMenuBar.byElement("工单-短信-文案")).shouldBe(text("API调试、短信接收等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-短信-按钮")).shouldHave(href("#/issue/create/4"));

        //点播
        //标题
        $(LeftMenuBar.byElement("工单-点播-标题")).getText().equals("点播");
        //文案
        $(LeftMenuBar.byElement("工单-点播-文案")).shouldBe(text("API调用、集成、播放、卡顿等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-点播-按钮")).shouldHave(href("#/issue/create/5"));

        //直播
        //标题
        $(LeftMenuBar.byElement("工单-直播-标题")).getText().equals("直播");
        //文案
        $(LeftMenuBar.byElement("工单-直播-文案")).shouldBe(text("API调用、集成、卡顿、录制等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-直播-按钮")).shouldHave(href("#/issue/create/6"));

        //互动直播2.0
        //标题
        $(LeftMenuBar.byElement("工单-互动直播2.0-标题")).shouldBe(text("互动直播2.0"));
        //文案
        $(LeftMenuBar.byElement("工单-互动直播2.0-文案")).shouldBe(text("基于新一代音视频通话2.0的一站式互动直播解决方案"));
        //按钮
//        $(LeftMenuBar.byElement("工单-互动直播2.0-按钮")).shouldHave(href("#/issue/create/15"));

        //互动直播1.0
        //标题
//        $(LeftMenuBar.byElement("工单-互动直播1.0-标题")).shouldBe(text("互动直播1.0"));
        //文案
//        $(LeftMenuBar.byElement("工单-互动直播1.0-文案")).shouldBe(text("多人音视频互动、直播，全平台支持"));
        //按钮
//        $(LeftMenuBar.byElement("工单-互动直播1.0-按钮")).shouldHave(href("#/issue/create/7"));

        //互动白板
        //标题
        $(LeftMenuBar.byElement("工单-互动白板-标题")).getText().equals("互动白板");
        //文案
        $(LeftMenuBar.byElement("工单-互动白板-文案")).shouldBe(text("收不到指令、发起白板失败等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-互动白板-按钮")).shouldHave(href("#/issue/create/8"));

        //信令
        //标题
        $(LeftMenuBar.byElement("工单-账号财务类-标题")).getText().equals("账号财务类");
        //文案
        $(LeftMenuBar.byElement("工单-账号财务类-文案")).shouldBe(text("实名认证、应用配置、账单、数据等问题"));
        //按钮
//        $(LeftMenuBar.byElement("工单-信令-按钮")).shouldHave(href("#/issue/create/13"));

        //专线电话
        //标题
//        $(LeftMenuBar.byElement("工单-专线电话-标题")).shouldBe(text("专线电话"));
        //文案
//        $(LeftMenuBar.byElement("工单-专线电话-文案")).shouldBe(text("一键呼叫全国任意手机、座机，无需网络"));
        //按钮
//        $(LeftMenuBar.byElement("工单-专线电话-按钮")).shouldHave(href("#/issue/create/3"));

        //安全通
        //标题
//        $(LeftMenuBar.byElement("工单-安全通-标题")).shouldBe(text("安全通"));
        //文案
//        $(LeftMenuBar.byElement("工单-安全通-文案")).shouldBe(text("全面覆盖文本、图片、视频等多类数据类型"));
        //按钮
//        $(LeftMenuBar.byElement("工单-安全通-按钮")).shouldHave(href("#/issue/create/10"));

        //我的工单页面
        //$(byXpath("//*[@id=\"issue\"]")).hover();
        //$(byXpath("//*[@id=\"issue-action\"]/ul/li[2]/a")).click();

    }

    //数据统计
    @Test(priority = 4)
    public void Statistics() throws Exception{

        //跳转链接存在
        $(LeftMenuBar.byElement("数据统计-按钮")).should(exist).click();

        //用户
        $(LeftMenuBar.byElement("数据统计-用户")).should(exist);

        //IM
        $(LeftMenuBar.byElement("数据统计-IM")).should(exist);

        //信令
        $(LeftMenuBar.byElement("数据统计-信令")).should(exist);

        //G1
        $(LeftMenuBar.byElement("数据统计-G1")).should(exist);

        //G2
        $(LeftMenuBar.byElement("数据统计-G2")).should(exist);

        //教学白板
        $(LeftMenuBar.byElement("数据统计-教学白板")).should(exist);

        //直播
        $(LeftMenuBar.byElement("数据统计-直播")).should(exist);

        //点播
        $(LeftMenuBar.byElement("数据统计-点播")).should(exist);

        //短信
        $(LeftMenuBar.byElement("数据统计-短信")).should(exist);

        //云呼叫中心
        $(LeftMenuBar.byElement("数据统计-云呼叫中心")).should(exist);

        //电话
        $(LeftMenuBar.byElement("数据统计-电话")).should(exist);

        //号码隐私保护
        $(LeftMenuBar.byElement("数据统计-号码隐私保护")).should(exist);

    }

    //服务监控平台
    @Test(priority = 5)
    public void ServiceMonitoringPlatform() throws Exception{

        //点击进入QS
        $(LeftMenuBar.byElement("服务监控平台-按钮")).should(exist).click();
        sleep(3000);

    }

    //订单
    @Test(priority = 6)
    public void Order() throws Exception{

        //点击进入订单
        $(LeftMenuBar.byElement("订单-按钮")).should(exist).click();
        sleep(3000);

        //申请合同入口
        $(LeftMenuBar.byElement("订单-申请合同入口")).should(exist).shouldHave(text("申请合同"));

        //申请开票入口
        $(LeftMenuBar.byElement("订单-申请开票入口")).should(exist).shouldHave(text("申请开票"));

    }

    //账单
    @Test(priority = 7)
    public void Bill() throws Exception{

        //入口存在
        $(LeftMenuBar.byElement("账单-按钮")).hover();
        $(LeftMenuBar.byElement("账单-账单总览")).should(exist);
        $(LeftMenuBar.byElement("账单-账单明细")).should(exist);

    }

    //流水明细
    @Test(priority = 8)
    public void FlowDetails() throws Exception{

        //按钮存在
        $(LeftMenuBar.byElement("流水明细-按钮")).should(exist).click();

    }

    //代金券
    @Test(priority = 9)
    public void Coupon() throws Exception{

        //按钮存在
        $(LeftMenuBar.byElement("代金券-按钮")).should(exist).click();
    }

    //资源包
    @Test(priority = 10)
    public void ResourcePack() throws Exception{

        //按钮存在
        $(LeftMenuBar.byElement("资源包-按钮")).should(exist).click();

    }

    //发票
    @Test(priority = 11)
    public void Invoice() throws Exception{

        //按钮存在，点击按钮进入
        $(LeftMenuBar.byElement("发票-按钮")).should(exist).click();

        //申请开票按钮存在
        $(LeftMenuBar.byElement("发票-申请开票按钮存在")).should(exist).shouldHave(text("申请开票"));

        //修改开票信息
        $(LeftMenuBar.byElement("发票-修改开票信息")).should(exist).shouldHave(text("修改开票信息"));

        //修改地址信息
        $(LeftMenuBar.byElement("发票-修改地址信息")).should(exist).shouldHave(text("修改地址信息"));

    }

}
