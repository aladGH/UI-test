package TestCases;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LeftMenuBarTest {

    @BeforeTest
    public void Login() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

        //executeJavaScript("window.open('your URL', '_blank');");
        open("https://id-auto.netease.im/external/page/autologinbyproduct");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[1]/input")).setValue("16531765267");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[2]/input")).setValue("w123456");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[4]/input")).setValue("media");

        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/button")).click();
        sleep(2000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://apptest.netease.im");
        sleep(9000);

        //关闭反垃圾弹窗
        $(byXpath("//*[@id=\"app\"]/div[4]/div/div[2]/a/i")).should(exist).click();

        //关闭子账号弹窗
        $(byXpath("//*[@id=\"app\"]/div[3]/div/div[2]/a")).should(exist).click();
    }

    //左侧菜单栏按钮
    @Test
    public void LeftMenuBar() {

        //解决方案
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[3]/a")).should(exist).shouldHave(href("/index#/solution"));

        //工单
        $(byXpath("//*[@id=\"issue\"]")).should(exist);
        //提交工单存在
        $(byXpath("//*[@id=\"issue-action\"]/ul/li[1]/a")).should(exist).shouldHave(href("/index#/issue/submit"));
        //我的工单存在
        $(byXpath("//*[@id=\"issue-action\"]/ul/li[2]/a")).should(exist).shouldHave(href("/index#/issue/list"));

        //数据统计
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[6]/a")).should(exist).shouldHave(href("/index#/statistics"));

        //服务监控平台
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[7]/a")).should(exist).shouldHave(href("/index#/qs"));

        //订单
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[8]/a")).should(exist).shouldHave(href("/index#/order"));

        //账单
        $(byXpath("//*[@id=\"bill\"]")).should(exist);
        //账单总览存在
        $(byXpath("//*[@id=\"bill-action\"]/ul/li[1]/a")).should(exist).shouldHave(href("/index#/billOverview"));
        //账单明细存在
        $(byXpath("//*[@id=\"bill-action\"]/ul/li[2]/a")).should(exist).shouldHave(href("/index#/billODetail"));

        //流水明细
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[10]/a")).should(exist).shouldHave(href("/index#/billDetail"));

        //代金券
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[11]/a")).should(exist).shouldHave(href("/index#/coupon"));

        //资源包
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[12]/a")).should(exist).shouldHave(href("/index#/resource"));

        //发票
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[13]/a")).should(exist).shouldHave(href("/index#/invoice"));
    }

    //
    @Test
    public void Solution() {

        //解决方案按钮存在并点击进入页面
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[3]/a")).should(exist).shouldHave(href("/index#/solution")).click();

        //多人语音聊天室解决方案
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/p[1]")).shouldBe(text("多人语音聊天室解决方案"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/p[2]")).shouldBe(text("多人语音聊天室是娱乐社交的典型玩法，支持1+N连麦互动的纯音频房间和万人聊天室。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/a")).shouldHave(href("https://yunxin.163.com/voicechat"));


        //智能手表音视频通话方案
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/p[1]")).shouldBe(text("智能手表音视频通话方案"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/p[2]")).shouldBe(text("为智能手表行业提供低功耗、清晰流畅的音视频通话能力，为不同特性的客户提供更具适用性的解决方案。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/a")).shouldHave(href("https://yunxin.163.com/smartwatch"));


        //小程序解决方案
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[3]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[3]/img")).shouldHave(image);
        //校验图片地址：shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[3]/p[1]")).shouldBe(text("小程序解决方案"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[3]/p[2]")).shouldBe(text("网易云信结合微信生态圈开放能力与云信在IM和音视频上的技术积累，为客户提供IM、聊天室、直播点播等小程序方案。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[3]/a")).shouldHave(href("https://yunxin.163.com/wechatApplets"));


        //互联网智慧医疗解决方案
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[4]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[4]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[4]/p[1]")).shouldBe(text("互联网智慧医疗解决方案"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[4]/p[2]")).shouldBe(text("提供私有化部署等核心能力，助力行业客户建立医疗商业闭环，最大化提升医疗资源利用率与医院协同效，打造医疗服务新模式"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[4]/a")).shouldHave(href("https://yunxin.163.com/medical"));


        //远程视频面签
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[5]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[5]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/faceSign.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[5]/p[1]")).shouldBe(text("远程视频面签"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[5]/p[2]")).shouldBe(text("基于音视频通话、IM即时通信、点播录制&转码、互动直播技术，实现远程视频面签和视频双录。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[5]/a")).shouldHave(href("https://yunxin.163.com/remoteteller"));


        //企业服务
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[6]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[6]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[6]/p[1]")).shouldBe(text("企业服务"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[6]/p[2]")).shouldBe(text("首创性实现企业生态圈内互联互通，为中大型企业提供自主可控、安全私密的一站式企业服务解决方案。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[6]/a")).shouldHave(href("https://yunxin.163.com/nice"));


        //电视端视频通话
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[7]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[7]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/netcallTv.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[7]/p[1]")).shouldBe(text("电视端视频通话"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[7]/p[2]")).shouldBe(text("高品质的电视端点对点和多人音视频通话通话解决方案，全方位满足不同功能需求，高效解决电视端音视频通话开发难题。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[7]/a")).shouldHave(href("https://yunxin.163.com/netcall-tv"));


        //音乐教学
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[8]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[8]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[8]/p[1]")).shouldBe(text("音乐教学"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[8]/p[2]")).shouldBe(text("结合网易集团多年教育行业与音乐领域的经验，将音视频能力深研，满足音乐教学场景中对画面与音质的极致追求。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[8]/a")).shouldHave(href("https://yunxin.163.com/edu-music"));


        //在线教育
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[9]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[9]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/edu.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[9]/p[1]")).shouldBe(text("在线教育"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[9]/p[2]")).shouldBe(text("网易集团深耕在线教育领域多年，网易云从视频与通讯技术为切入点打造多场景、高可用的教育直播方案。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[9]/a")).shouldHave(href("https://yunxin.163.com/edu"));


        //直播竞答
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[10]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[10]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/liveAnswer.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[10]/p[1]")).shouldBe(text("直播竞答"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[10]/p[2]")).shouldBe(text("集直播、问答、聊天室于一体，全面满足知识竞答产品对稳定、同步、高并发的需求。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[10]/a")).shouldHave(href("https://yunxin.163.com/quizgame"));


        //在线抓娃娃
        //卡片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[11]")).should(exist);
        //图片
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[11]/img")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/clawMachine.png"));

        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[11]/p[1]")).shouldBe(text("在线抓娃娃"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[11]/p[2]")).shouldBe(text("基于音视频通话、互动直播、直播、点播和IM能力，为抓娃娃场景的客户提供一整套的在线抓娃娃解决方案。"));
        //查看详情跳转
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[11]/a")).shouldHave(href("https://yunxin.163.com/clawMachine"));

    }

    //工单
    @Test
    public void Issue() {

        //创建工单页面
        $(byXpath("//*[@id=\"issue\"]")).hover();
        $(byXpath("//*[@id=\"issue-action\"]/ul/li[1]/a")).click();
        sleep(3000);

        //产品咨询
        //图片-背景图无法判断是否加载完毕
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/div/span[1]")).shouldBe(text("产品咨询"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/div/span[2]")).shouldBe(text("产品功能、价格、用户账户等相关问题"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[2]/a")).shouldHave(href("https://yunxin.163.com/bizQQWPA.html"));

        //红包
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[2]/div/span[1]")).shouldBe(text("红包"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[2]/div/span[2]")).shouldBe(text("易于集成，安全合规，支持单聊、群组、聊天室场景"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[2]/a")).shouldHave(href("#/issue/create/12"));

        //IM即时通讯
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[3]/div/span[1]")).shouldBe(text("IM即时通讯"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[3]/div/span[2]")).shouldBe(text("支持单聊、群聊、聊天室，适用所有APP"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[3]/a")).shouldHave(href("#/issue/create/1"));

        //音视频通话2.0
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[4]/div/span[1]")).shouldBe(text("音视频通话2.0"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[4]/div/span[2]")).shouldBe(text("基于新一代音视频通话支持双声道128Kbps码率立体声高清音质，支持1080P高清画质"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[4]/a")).shouldHave(href("#/issue/create/14"));

        //音视频通话1.0
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[5]/div/span[1]")).shouldBe(text("音视频通话1.0"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[5]/div/span[2]")).shouldBe(text("基于网络的点对点、多对多实时语音、视频通话功能"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[5]/a")).shouldHave(href("#/issue/create/2"));

        //短信
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[6]/div/span[1]")).shouldBe(text("短信"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[6]/div/span[2]")).shouldBe(text("提供短信送达任务，如短信验证码、模板短信"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[6]/a")).shouldHave(href("#/issue/create/4"));

        //点播
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[7]/div/span[1]")).shouldBe(text("点播"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[7]/div/span[2]")).shouldBe(text("为视频提供云端高质量转码计算服务，支持各终端播放"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[7]/a")).shouldHave(href("#/issue/create/5"));

        //直播
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[8]/div/span[1]")).shouldBe(text("直播"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[8]/div/span[2]")).shouldBe(text("企业级音视频直播服务，稳定流畅、低延时、高并发"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[8]/a")).shouldHave(href("#/issue/create/6"));

        //互动直播2.0
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[9]/div/span[1]")).shouldBe(text("互动直播2.0"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[9]/div/span[2]")).shouldBe(text("基于新一代音视频通话2.0的一站式互动直播解决方案"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[9]/a")).shouldHave(href("#/issue/create/15"));

        //互动直播1.0
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[10]/div/span[1]")).shouldBe(text("互动直播1.0"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[10]/div/span[2]")).shouldBe(text("多人音视频互动、直播，全平台支持"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[10]/a")).shouldHave(href("#/issue/create/7"));

        //互动白板
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[11]/div/span[1]")).shouldBe(text("互动白板"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[11]/div/span[2]")).shouldBe(text("支持文档转码，轨迹实时同步等多种功能"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[11]/a")).shouldHave(href("#/issue/create/8"));

        //信令
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[12]/div/span[1]")).shouldBe(text("信令"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[12]/div/span[2]")).shouldBe(text("提供可靠稳定的信令通道，可搭配目前所有音视频产品使用"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[12]/a")).shouldHave(href("#/issue/create/13"));

        //专线电话
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[13]/div/span[1]")).shouldBe(text("专线电话"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[13]/div/span[2]")).shouldBe(text("一键呼叫全国任意手机、座机，无需网络"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[13]/a")).shouldHave(href("#/issue/create/3"));

        //安全通
        //标题
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[14]/div/span[1]")).shouldBe(text("安全通"));
        //文案
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[14]/div/span[2]")).shouldBe(text("全面覆盖文本、图片、视频等多类数据类型"));
        //按钮
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[14]/a")).shouldHave(href("#/issue/create/10"));

        //我的工单页面
        //$(byXpath("//*[@id=\"issue\"]")).hover();
        //$(byXpath("//*[@id=\"issue-action\"]/ul/li[2]/a")).click();

    }

    //数据统计
    @Test
    public void Statistics() {

        //跳转链接存在
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[6]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[6]/a")).shouldHave(href("/index#/statistics"));

        //用户
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[1]/a")).should(exist);

        //IM
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[2]/a")).should(exist);

        //信令
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[3]/a")).should(exist);

        //G1
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[4]/a")).should(exist);

        //G2
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[5]/a")).should(exist);

        //教学白板
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[6]/a")).should(exist);

        //直播
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[7]/a")).should(exist);

        //点播
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[8]/a")).should(exist);

        //短信
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[9]/a")).should(exist);

        //电话
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[10]/a")).should(exist);

        //号码隐私保护
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/ul/li[11]/a")).should(exist);


    }

    //服务监控平台
    @Test
    public void ServiceMonitoringPlatform() {

        //点击进入QS
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[7]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[7]/a")).shouldHave(href("/index#/qs"));
        sleep(3000);

    }

    //订单
    @Test
    public void Order() {

        //点击进入订单
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[8]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[8]/a")).shouldHave(href("/index#/order"));
        sleep(3000);

        //申请合同入口
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/a[1]")).should(exist).shouldHave(href("#/contract")).shouldHave(text("申请合同"));

        //申请开票入口
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/a[2]")).should(exist).shouldHave(href("#/invoice")).shouldHave(text("申请开票"));

    }

    //账单
    @Test
    public void Bill() {

        //入口存在
        $(byXpath("//*[@id=\"bill\"]")).hover();
        $(byXpath("//*[@id=\"bill-action\"]/ul/li[1]/a")).should(exist).shouldHave(href("/index#/billOverview"));
        $(byXpath("//*[@id=\"bill-action\"]/ul/li[2]/a")).should(exist).shouldHave(href("/index#/billODetail"));

    }

    //流水明细
    @Test
    public void FlowDetails() {

        //按钮存在
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[10]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[10]/a")).shouldHave(href("/index#/billDetail"));

    }

    //代金券
    @Test
    public void Coupon() {

        //按钮存在
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[11]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[11]/a")).shouldHave(href("/index#/coupon"));
    }

    //资源包
    @Test
    public void ResourcePack() {

        //按钮存在
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[12]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[12]/a")).shouldHave(href("/index#/resource"));

    }

    //发票
    @Test
    public void Invoice() {

        //按钮存在，点击按钮进入
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[13]")).should(exist).click();
        $(byXpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/ul/li[13]/a")).shouldHave(href("/index#/invoice"));

        //申请开票按钮存在
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[1]")).should(exist).shouldHave(text("申请开票"));

        //修改开票信息
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[2]/a")).should(exist).shouldHave(href("#/invoice/msgmanage")).shouldHave(text("修改开票信息 >"));

        //修改地址信息
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[3]/a")).should(exist).shouldHave(href("#/invoice/mailAddr")).shouldHave(text("修改地址信息 >"));

    }

}
