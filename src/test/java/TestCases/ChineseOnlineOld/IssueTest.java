package TestCases.ChineseOnlineOld;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import Object.BasePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

//工单
public class IssueTest {

    private BasePage Issue;
    @BeforeTest
    public void CreatPages() throws Exception{
        Issue = new BasePage("Issue", "ChineseOnlineOld/Issue.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @Test(priority = 1)
    public void Issue() throws Exception{

        //创建工单页面
        $(Issue.byElement("工单-工单按钮")).hover();
        $(Issue.byElement("工单-提交工单按钮")).click();
        sleep(3000);

        //产品咨询
        //图片-背景图无法判断是否加载完毕
        //标题
        $(Issue.byElement("工单-IM即时通讯-标题")).getText().equals("IM即时通讯");
        //文案
        $(Issue.byElement("工单-IM即时通讯-文案")).shouldBe(text("登录、抄送、消息收发、推送等问题"));

        //IM-融合AI
        //标题
        $(Issue.byElement("工单-IM-融合AI-标题")).shouldBe(text("IM-融合AI"));
        //文案
        $(Issue.byElement("工单-IM-融合AI-文案")).shouldBe(text("定制本地大模型、接入第三方垂类大模型"));

        //音视频通话1.0
        //标题
        $(Issue.byElement("工单-音视频通话1.0-标题")).shouldBe(text("音视频通话1.0"));
        //文案
        $(Issue.byElement("工单-音视频通话1.0-文案")).shouldBe(text("Crash、接口、画面、声音、抄送等问题"));

        //互动直播1.0
        //标题
        $(Issue.byElement("工单-互动直播1.0-标题")).shouldBe(text("互动直播1.0"));
        //文案
        $(Issue.byElement("工单-互动直播1.0-文案")).shouldBe(text("多人音视频互动、直播，全平台支持"));

        //互动直播2.0
        //标题
        $(Issue.byElement("工单-互动直播2.0-标题")).shouldBe(text("互动直播2.0"));
        //文案
        $(Issue.byElement("工单-互动直播2.0-文案")).shouldBe(text("基于新一代音视频通话2.0的一站式互动直播解决方案"));

        //专线电话
        //标题
        $(Issue.byElement("工单-专线电话-标题")).shouldBe(text("专线电话"));
        //文案
        $(Issue.byElement("工单-专线电话-文案")).shouldBe(text("一键呼叫全国任意手机、座机，无需网络"));

        //短信
        //标题
        $(Issue.byElement("工单-短信-标题")).getText().equals("短信");
        //文案
        $(Issue.byElement("工单-短信-文案")).shouldBe(text("API调试、短信接收等问题"));

        //点播
        //标题
        $(Issue.byElement("工单-点播-标题")).getText().equals("点播");
        //文案
        $(Issue.byElement("工单-点播-文案")).shouldBe(text("API调用、集成、播放、卡顿等问题"));

        //直播
        //标题
        $(Issue.byElement("工单-直播-标题")).getText().equals("直播");
        //文案
        $(Issue.byElement("工单-直播-文案")).shouldBe(text("API调用、集成、卡顿、录制等问题"));

        //互动白板
        //标题
        $(Issue.byElement("工单-互动白板-标题")).getText().equals("互动白板");
        //文案
        $(Issue.byElement("工单-互动白板-文案")).shouldBe(text("收不到指令、发起白板失败等问题"));

        //音视频通话2.0
        //标题
        $(Issue.byElement("工单-音视频通话2.0-标题")).getText().equals("音视频通话2.0");
        //文案
        $(Issue.byElement("工单-音视频通话2.0-文案")).shouldBe(text("声音、画面、卡顿、抄送、Crash等问题"));

        //账号财务类
        //标题
        $(Issue.byElement("工单-账号财务类-标题")).getText().equals("账号财务类");
        //文案
        $(Issue.byElement("工单-账号财务类-文案")).shouldBe(text("实名认证、应用配置、账单、数据等问题"));

        //解决方案
        //标题
        $(Issue.byElement("工单-解决方案-标题")).shouldBe(text("解决方案"));
        //文案
        $(Issue.byElement("工单-解决方案-文案")).shouldBe(text("视频会议解决方案"));
    }

}
