package TestCases.ChineseOnlineOld;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

//解决方案
public class SolutionTest {

    private BasePage Solution;
    @BeforeTest
    public void CreatPages() throws Exception{
        Solution = new BasePage("Solution", "ChineseOnlineOld/Solution.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void Solution() throws Exception {

        //解决方案按钮存在并点击进入页面
        $(Solution.byElement("解决方案按钮存在并点击进入页面")).should(exist).click();

        //语聊房
        //卡片
        $(Solution.byElement("语聊房-卡片")).should(exist);
        //图片
        $(Solution.byElement("语聊房-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
        //标题
        $(Solution.byElement("语聊房-标题")).shouldBe(text("语聊房"));
        //文案
        $(Solution.byElement("语聊房-文案")).shouldBe(text("多人语音聊天室是娱乐社交的典型玩法，支持1+N连麦互动的纯音频房间和万人聊天室。"));
        //查看详情跳转
        $(Solution.byElement("语聊房-查看详情跳转")).shouldHave(href("https://yunxin.163.com/voicechat"));

        //智能手表
        //卡片
        $(Solution.byElement("智能手表-卡片")).should(exist);
        //图片
        $(Solution.byElement("智能手表-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(Solution.byElement("智能手表-标题")).shouldBe(text("智能手表"));
        //文案
        $(Solution.byElement("智能手表-文案")).shouldBe(text("为智能手表行业提供低功耗、清晰流畅的音视频通话能力，为不同特性的客户提供更具适用性的解决方案。"));
        //查看详情跳转
        $(Solution.byElement("智能手表-查看详情跳转")).shouldHave(href("https://yunxin.163.com/smartwatch"));

        //小程序
        //卡片
        $(Solution.byElement("小程序-卡片")).should(exist);
        //图片
        $(Solution.byElement("小程序-图片")).shouldHave(image);
        //校验图片地址：shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));

        //标题
        $(Solution.byElement("小程序-标题")).shouldBe(text("小程序"));
        //文案
        $(Solution.byElement("小程序-文案")).shouldBe(text("网易云信结合微信生态圈开放能力与云信在IM和音视频上的技术积累，为客户提供IM、聊天室、直播点播等小程序方案。"));
        //查看详情跳转
        $(Solution.byElement("小程序-查看详情跳转")).shouldHave(href("https://yunxin.163.com/wechatApplets"));

        //智慧医院
        //卡片
        $(Solution.byElement("智慧医院-卡片")).should(exist);
        //图片
        $(Solution.byElement("智慧医院-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));

        //标题
        $(Solution.byElement("智慧医院-标题")).shouldBe(text("智慧医院"));
        //文案
        $(Solution.byElement("智慧医院-文案")).shouldBe(text("提供私有化部署等核心能力，助力行业客户建立医疗商业闭环，最大化提升医疗资源利用率与医院协同效，打造医疗服务新模式"));
        //查看详情跳转
        $(Solution.byElement("智慧医院-查看详情跳转")).shouldHave(href("https://yunxin.163.com/medhos"));


        //远程面签
        //卡片
        $(Solution.byElement("远程面签-卡片")).should(exist);
        //图片
        $(Solution.byElement("远程面签-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/faceSign.png"));

        //标题
        $(Solution.byElement("远程面签-标题")).shouldBe(text("远程面签"));
        //文案
        $(Solution.byElement("远程面签-文案")).shouldBe(text("基于音视频通话、IM即时通信、点播录制&转码、互动直播技术，实现远程视频面签和视频双录。"));
        //查看详情跳转
        $(Solution.byElement("远程面签-查看详情跳转")).shouldHave(href("https://yunxin.163.com/finance#remoteSign"));


        //企业服务
        //卡片
        $(Solution.byElement("企业服务-卡片")).should(exist);
        //图片
        $(Solution.byElement("企业服务-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/nice.png"));

        //标题
        $(Solution.byElement("企业服务-标题")).shouldBe(text("企业服务"));
        //文案
        $(Solution.byElement("企业服务-文案")).shouldBe(text("首创性实现企业生态圈内互联互通，为中大型企业提供自主可控、安全私密的一站式企业服务解决方案。"));
        //查看详情跳转
        $(Solution.byElement("企业服务-查看详情跳转")).shouldHave(href("https://yunxin.163.com/nice"));


        //电视端视频通话
        //卡片
        $(Solution.byElement("电视端视频通话-卡片")).should(exist);
        //图片
        $(Solution.byElement("电视端视频通话-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/netcallTv.png"));

        //标题
        $(Solution.byElement("电视端视频通话-标题")).shouldBe(text("电视端视频通话"));
        //文案
        $(Solution.byElement("电视端视频通话-文案")).shouldBe(text("高品质的电视端点对点和多人音视频通话通话解决方案，全方位满足不同功能需求，高效解决电视端音视频通话开发难题。"));
        //查看详情跳转
        $(Solution.byElement("电视端视频通话-查看详情跳转")).shouldHave(href("https://yunxin.163.com/netcall-tv"));


//        //音乐教学
//        //卡片
//        $(Solution.byElement("音乐教学-卡片")).should(exist);
//        //图片
//        $(Solution.byElement("音乐教学-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/eduMusic.png"));
//
//        //标题
//        $(Solution.byElement("音乐教学-标题")).shouldBe(text("音乐教学"));
//        //文案
//        $(Solution.byElement("音乐教学-文案")).shouldBe(text("结合网易集团多年教育行业与音乐领域的经验，将音视频能力深研，满足音乐教学场景中对画面与音质的极致追求。"));
//        //查看详情跳转
//        $(Solution.byElement("音乐教学-查看详情跳转")).shouldHave(href("https://yunxin.163.com/edu-music"));


        //在线教育
        //卡片
        $(Solution.byElement("在线教育-卡片")).should(exist);
        //图片
        $(Solution.byElement("在线教育-图片")).shouldHave(image);
        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/edu.png"));

        //标题
        $(Solution.byElement("在线教育-标题")).shouldBe(text("在线教育"));
        //文案
        $(Solution.byElement("在线教育-文案")).shouldBe(text("网易集团深耕在线教育领域多年，网易云从视频与通讯技术为切入点打造多场景、高可用的教育直播方案。"));
        //查看详情跳转
        $(Solution.byElement("在线教育-查看详情跳转")).shouldHave(href("https://yunxin.163.com/edu"));


//        //虚拟人
//        //卡片
//        $(Solution.byElement("虚拟人-卡片")).should(exist);
//        //图片
//        $(Solution.byElement("虚拟人-图片")).shouldHave(image);
//        //校验图片地址：.shouldHave(attribute("src","/res/images/solutions/xuNiRen.png"));
//
//        //标题
//        $(Solution.byElement("虚拟人-标题")).shouldBe(text("虚拟人"));
//        //文案
//        $(Solution.byElement("虚拟人-文案")).shouldBe(text("提供虚拟人解决方案，应用于娱乐社交、电商直播、秀场直播、虚拟客服等场景，为用户提供更实时、更可靠的沉浸式体验。"));
//        //查看详情跳转
//        $(Solution.byElement("虚拟人-查看详情跳转")).shouldHave(href("https://yunxin.163.com/virtual-human"));

    }

}
