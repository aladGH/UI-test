package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ApplicationDetailsPageTest {

    private BasePage ApplicationDetailsPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        ApplicationDetailsPage = new BasePage("ApplicationDetailsPage", "ChineseOnlineNew/ApplicationDetailsPage.xml");
        //打开应用详情页面
        open("https://app.yunxin.163.com/global/application/overview/basic?appid=25126789");
        sleep(500);
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //APP
    @Test(priority = 1)
    public void APP() throws Exception{
        sleep(500);
        //应用名
        $(ApplicationDetailsPage.byElement("应用配置-应用名")).should(exist).shouldHave(text("UI自动化测试应用"));

        //基本信息
        $(ApplicationDetailsPage.byElement("应用配置-基本信息")).should(exist).shouldHave(text("基本信息"));

        //AppKey 管理
        $(ApplicationDetailsPage.byElement("应用配置-AppKey 管理")).should(exist).shouldHave(text("AppKey 管理"));

        //消息抄送
        $(ApplicationDetailsPage.byElement("应用配置-消息抄送")).should(exist).shouldHave(text("消息抄送"));

        //标识管理
        $(ApplicationDetailsPage.byElement("应用配置-标识管理")).should(exist).shouldHave(text("标识管理"));

        //证书管理
        $(ApplicationDetailsPage.byElement("应用配置-证书管理")).should(exist).shouldHave(text("证书管理"));
    }
    //基本信息-产品总览
    @Test(priority = 2)
    public void Products() throws Exception{

        //产品总览
        $(ApplicationDetailsPage.byElement("产品总览")).should(exist).shouldHave(text("产品总览"));

        //IM
        $(ApplicationDetailsPage.byElement("产品总览-IM")).should(exist).shouldHave(text("IM即时通讯"));

        //音视频通话2.0
        $(ApplicationDetailsPage.byElement("产品总览-音视频通话2.0")).should(exist);
        //短信
        $(ApplicationDetailsPage.byElement("产品总览-短信")).should(exist);
        //直播
        $(ApplicationDetailsPage.byElement("产品总览-直播")).should(exist);
        //点播
        $(ApplicationDetailsPage.byElement("产品总览-点播")).should(exist);
        //互动白板
        $(ApplicationDetailsPage.byElement("产品总览-互动白板")).should(exist);

        //更多产品
        $(ApplicationDetailsPage.byElement("产品总览-更多产品")).should(exist).shouldHave(text("更多产品"));
        $(ApplicationDetailsPage.byElement("产品总览-更多产品箭头")).should(exist).click();
        sleep(500);
        //音视频通话1.0
        $(ApplicationDetailsPage.byElement("产品总览-音视频通话1.0")).should(exist);
        //专线电话
        $(ApplicationDetailsPage.byElement("产品总览-专线电话")).should(exist);
        sleep(500);

        //介绍文案
        $(ApplicationDetailsPage.byElement("介绍文案-IM")).should(exist).shouldHave(text("接入 IM SDK ，即刻拥有私聊、群聊、聊天室、圈组等通讯能力"));
        $(ApplicationDetailsPage.byElement("介绍文案-音视频通话2.0")).should(exist).shouldHave(text("支持双声道 128Kbps 码率立体声高清音质、1080P 高清画质"));
        $(ApplicationDetailsPage.byElement("介绍文案-短信")).should(exist).shouldHave(text("验证码短信、通知短信、运营短信、国际短信、语音验证码、视频短信"));
        $(ApplicationDetailsPage.byElement("介绍文案-直播")).should(exist).shouldHave(text("稳定流畅、高可靠、高并发的直播服务，轻松打造企业级在线直播平台"));
        $(ApplicationDetailsPage.byElement("介绍文案-点播")).should(exist).shouldHave(text("提供极速稳定的视频上传、存储、转码、播放和下载等云服务"));
        $(ApplicationDetailsPage.byElement("介绍文案-音视频通话1.0")).should(exist).shouldHave(text("基于网络的点对点、多人的语音、视频聊天功能"));
        $(ApplicationDetailsPage.byElement("介绍文案-专线电话")).should(exist).shouldHave(text("提供基于运营商网络的回拨电话和多人电话会议功能"));
        $(ApplicationDetailsPage.byElement("产品总览-收起")).should(exist).shouldHave(text("收起"));
        $(ApplicationDetailsPage.byElement("产品总览-收起箭头")).should(exist).click();
    }

//
//    //G1
//    @Test(priority = 3)
//    public void Netcall1() throws Exception{
//
//        //功能配置
//        $(ApplicationDetailsPage.byElement("G1-功能配置")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("G1-开发手册")).should(exist);
//    }
//    //G2
//    @Test(priority = 4)
//    public void Netcall2() throws Exception{
//
//        //安全通
//        $(ApplicationDetailsPage.byElement("G2-安全通")).should(exist);
//
//        //功能配置
//        $(ApplicationDetailsPage.byElement("G2-功能配置")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("G2-开发手册")).should(exist);
//    }
//
//    //直播
//    @Test(priority = 5)
//    public void Live() throws Exception{
//
//        //安全通
//        $(ApplicationDetailsPage.byElement("直播-安全通")).should(exist);
//
//        //域名管理
//        $(ApplicationDetailsPage.byElement("直播-域名管理")).should(exist);
//
//        //直播管理
//        $(ApplicationDetailsPage.byElement("直播-直播管理")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("直播-开发手册")).should(exist);
//    }
//
//    //点播
//    @Test(priority = 6)
//    public void Vod() throws Exception{
//
//        //安全通
//        $(ApplicationDetailsPage.byElement("点播-安全通")).should(exist);
//
//        //域名管理
//        $(ApplicationDetailsPage.byElement("点播-域名管理")).should(exist);
//
//        //文件管理
//        $(ApplicationDetailsPage.byElement("点播-文件管理")).should(exist);
//
//        //转码
//        $(ApplicationDetailsPage.byElement("点播-转码")).should(exist);
//
//        //水印
//        $(ApplicationDetailsPage.byElement("点播-水印")).should(exist);
//
//        //分类
//        $(ApplicationDetailsPage.byElement("点播-分类")).should(exist);
//
//        //上传
//        $(ApplicationDetailsPage.byElement("点播-上传")).should(exist);
//
//        //短视频
//        $(ApplicationDetailsPage.byElement("点播-短视频")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("点播-开发手册")).should(exist);
//    }
//    //互动直播1.0
//    @Test(priority = 7)
//    public void InteractiveNetcall1() throws Exception{
//
//        //功能配置
//        $(ApplicationDetailsPage.byElement("互动直播1.0-功能配置")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("互动直播1.0-开发手册")).should(exist);
//    }
//
//    //互动直播2.0
//    @Test(priority = 8)
//    public void InteractiveNetcall2() throws Exception{
//
//        //功能配置
//        $(ApplicationDetailsPage.byElement("互动直播2.0-功能配置")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("互动直播2.0-开发手册")).should(exist);
//    }
//
//    //教学白板
//    @Test(priority = 9)
//    public void EducationWhiteboard() throws Exception{
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("教学白板-开发手册")).should(exist);
//
//    }
//
//    //短信
//    @Test(priority = 10)
//    public void SMS() throws Exception{
//
//        //已开通功能
//        $(ApplicationDetailsPage.byElement("短信-已开通功能")).should(exist);
//
//        //短信模板管理
//        $(ApplicationDetailsPage.byElement("短信-短信模板管理")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("短信-开发手册")).should(exist);
//    }
//
//    //专线电话
//    @Test(priority = 11)
//    public void DedicatedTelephone() throws Exception{
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("专线电话-开发手册")).should(exist);
//    }
//
//    //隐私号码保护
//    @Test(priority = 12)
//    public void SmallPhone() throws Exception{
//
//        //小号管理
////        $(ApplicationDetailsPage.byElement("隐私号码保护-小号管理")).should(exist);
//    }
//
//    //5G消息
//    @Test(priority = 13)
//    public void RCS5GSMS() throws Exception{
//
//        //资质审核
//        $(ApplicationDetailsPage.byElement("5G消息-资质审核")).should(exist);
//
//        //ChatBot管理
//        $(ApplicationDetailsPage.byElement("5G消息-ChatBot管理")).should(exist);
//
//        //素材管理
//        $(ApplicationDetailsPage.byElement("5G消息-素材管理")).should(exist);
//
//        //模板管理
//        $(ApplicationDetailsPage.byElement("5G消息-模板管理")).should(exist);
//
//        //消息管理
//        $(ApplicationDetailsPage.byElement("5G消息-消息管理")).should(exist);
//
//        //回复管理
//        $(ApplicationDetailsPage.byElement("5G消息-回复管理")).should(exist);
//
//        //接口配置
//        $(ApplicationDetailsPage.byElement("5G消息-接口配置")).should(exist);
//
//        //开发手册
//        $(ApplicationDetailsPage.byElement("5G消息-开发手册")).should(exist);
//    }
//
//    //解决方案
//    @Test(priority = 2)
//    public void Solution() throws Exception{
//
//        //解决方案按钮存在并点击进入页面
//        $(ApplicationDetailsPage.byElement("解决方案按钮存在并点击进入页面")).should(exist).click();
//
//        //语聊房
//        //卡片
//        $(ApplicationDetailsPage.byElement("语聊房-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("语聊房-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
//        //标题
//        $(ApplicationDetailsPage.byElement("语聊房-标题")).shouldBe(text("语聊房"));
//        //文案
//        $(ApplicationDetailsPage.byElement("语聊房-文案")).shouldBe(text("多人语音聊天室是娱乐社交的典型玩法，支持1+N连麦互动的纯音频房间和万人聊天室。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("语聊房-查看详情跳转")).shouldHave(href("https://yunxin.163.com/voicechat"));
//
//        //智能手表
//        //卡片
//        $(ApplicationDetailsPage.byElement("智能手表-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("智能手表-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("智能手表-标题")).shouldBe(text("智能手表"));
//        //文案
//        $(ApplicationDetailsPage.byElement("智能手表-文案")).shouldBe(text("为智能手表行业提供低功耗、清晰流畅的音视频通话能力，为不同特性的客户提供更具适用性的解决方案。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("智能手表-查看详情跳转")).shouldHave(href("https://yunxin.163.com/smartwatch"));
//
//        //小程序
//        //卡片
//        $(ApplicationDetailsPage.byElement("小程序-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("小程序-图片")).shouldHave(image);
//        //校验图片地址：shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("小程序-标题")).shouldBe(text("小程序"));
//        //文案
//        $(ApplicationDetailsPage.byElement("小程序-文案")).shouldBe(text("网易云信结合微信生态圈开放能力与云信在IM和音视频上的技术积累，为客户提供IM、聊天室、直播点播等小程序方案。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("小程序-查看详情跳转")).shouldHave(href("https://yunxin.163.com/wechatApplets"));
//
//        //智慧医院
//        //卡片
//        $(ApplicationDetailsPage.byElement("智慧医院-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("智慧医院-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("智慧医院-标题")).shouldBe(text("智慧医院"));
//        //文案
//        $(ApplicationDetailsPage.byElement("智慧医院-文案")).shouldBe(text("提供私有化部署等核心能力，助力行业客户建立医疗商业闭环，最大化提升医疗资源利用率与医院协同效，打造医疗服务新模式"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("智慧医院-查看详情跳转")).shouldHave(href("https://yunxin.163.com/medhos"));
//
//
//        //远程面签
//        //卡片
//        $(ApplicationDetailsPage.byElement("远程面签-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("远程面签-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/faceSign.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("远程面签-标题")).shouldBe(text("远程面签"));
//        //文案
//        $(ApplicationDetailsPage.byElement("远程面签-文案")).shouldBe(text("基于音视频通话、IM即时通信、点播录制&转码、互动直播技术，实现远程视频面签和视频双录。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("远程面签-查看详情跳转")).shouldHave(href("https://yunxin.163.com/finance#remoteSign"));
//
//
//        //企业服务
//        //卡片
//        $(ApplicationDetailsPage.byElement("企业服务-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("企业服务-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("企业服务-标题")).shouldBe(text("企业服务"));
//        //文案
//        $(ApplicationDetailsPage.byElement("企业服务-文案")).shouldBe(text("首创性实现企业生态圈内互联互通，为中大型企业提供自主可控、安全私密的一站式企业服务解决方案。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("企业服务-查看详情跳转")).shouldHave(href("https://yunxin.163.com/nice"));
//
//
//        //电视端视频通话
//        //卡片
//        $(ApplicationDetailsPage.byElement("电视端视频通话-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("电视端视频通话-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/netcallTv.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("电视端视频通话-标题")).shouldBe(text("电视端视频通话"));
//        //文案
//        $(ApplicationDetailsPage.byElement("电视端视频通话-文案")).shouldBe(text("高品质的电视端点对点和多人音视频通话通话解决方案，全方位满足不同功能需求，高效解决电视端音视频通话开发难题。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("电视端视频通话-查看详情跳转")).shouldHave(href("https://yunxin.163.com/netcall-tv"));
//
//
////        //音乐教学
////        //卡片
////        $(ApplicationDetailsPage.byElement("音乐教学-卡片")).should(exist);
////        //图片
////        $(ApplicationDetailsPage.byElement("音乐教学-图片")).shouldHave(image);
////        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
////
////        //标题
////        $(ApplicationDetailsPage.byElement("音乐教学-标题")).shouldBe(text("音乐教学"));
////        //文案
////        $(ApplicationDetailsPage.byElement("音乐教学-文案")).shouldBe(text("结合网易集团多年教育行业与音乐领域的经验，将音视频能力深研，满足音乐教学场景中对画面与音质的极致追求。"));
////        //查看详情跳转
////        $(ApplicationDetailsPage.byElement("音乐教学-查看详情跳转")).shouldHave(href("https://yunxin.163.com/edu-music"));
//
//
//        //在线教育
//        //卡片
//        $(ApplicationDetailsPage.byElement("在线教育-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("在线教育-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/edu.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("在线教育-标题")).shouldBe(text("在线教育"));
//        //文案
//        $(ApplicationDetailsPage.byElement("在线教育-文案")).shouldBe(text("网易集团深耕在线教育领域多年，网易云从视频与通讯技术为切入点打造多场景、高可用的教育直播方案。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("在线教育-查看详情跳转")).shouldHave(href("https://yunxin.163.com/edu"));


//        //虚拟人
//        //卡片
//        $(ApplicationDetailsPage.byElement("虚拟人-卡片")).should(exist);
//        //图片
//        $(ApplicationDetailsPage.byElement("虚拟人-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/xuNiRen.png"));
//
//        //标题
//        $(ApplicationDetailsPage.byElement("虚拟人-标题")).shouldBe(text("虚拟人"));
//        //文案
//        $(ApplicationDetailsPage.byElement("虚拟人-文案")).shouldBe(text("提供虚拟人解决方案，应用于娱乐社交、电商直播、秀场直播、虚拟客服等场景，为用户提供更实时、更可靠的沉浸式体验。"));
//        //查看详情跳转
//        $(ApplicationDetailsPage.byElement("虚拟人-查看详情跳转")).shouldHave(href("https://yunxin.163.com/virtual-human"));

//    }
}
