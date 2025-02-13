package TestCases.ChineseOnlineOld;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ApplicationDetailsPageTest {

    private BasePage ApplicationDetailsPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        ApplicationDetailsPage = new BasePage("ApplicationDetailsPage", "ChineseOnlineOld/ApplicationDetailsPage.xml");
        //打开应用详情页面
        open("https://app.yunxin.163.com/application/info?appid=25126789");
        sleep(500);
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //IM
    @Test(priority = 1)
    public void IM() throws Exception{

        //易盾入口
        $(ApplicationDetailsPage.byElement("IM-安全通")).should(exist);

        //API调试入口
        $(ApplicationDetailsPage.byElement("IM-API调试入口")).should(exist);

        //功能配置
        $(ApplicationDetailsPage.byElement("IM-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("IM-开发手册")).should(exist);
    }

    //G1
    @Test(priority = 2)
    public void Netcall1() throws Exception{

        //功能配置
        $(ApplicationDetailsPage.byElement("G1-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("G1-开发手册")).should(exist);
    }
    //G2
    @Test(priority = 3)
    public void Netcall2() throws Exception{

        //安全通
        $(ApplicationDetailsPage.byElement("G2-安全通")).should(exist);

        //功能配置
        $(ApplicationDetailsPage.byElement("G2-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("G2-开发手册")).should(exist);
    }

    //直播
    @Test(priority = 4)
    public void Live() throws Exception{

        //安全通
        $(ApplicationDetailsPage.byElement("直播-安全通")).should(exist);

        //域名管理
        $(ApplicationDetailsPage.byElement("直播-域名管理")).should(exist);

        //直播管理
        $(ApplicationDetailsPage.byElement("直播-直播管理")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("直播-开发手册")).should(exist);
    }

    //点播
    @Test(priority = 5)
    public void Vod() throws Exception{

        //安全通
        $(ApplicationDetailsPage.byElement("点播-安全通")).should(exist);

        //域名管理
        $(ApplicationDetailsPage.byElement("点播-域名管理")).should(exist);

        //文件管理
        $(ApplicationDetailsPage.byElement("点播-文件管理")).should(exist);

        //转码
        $(ApplicationDetailsPage.byElement("点播-转码")).should(exist);

        //水印
        $(ApplicationDetailsPage.byElement("点播-水印")).should(exist);

        //分类
        $(ApplicationDetailsPage.byElement("点播-分类")).should(exist);

        //上传
        $(ApplicationDetailsPage.byElement("点播-上传")).should(exist);

        //短视频
        $(ApplicationDetailsPage.byElement("点播-短视频")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("点播-开发手册")).should(exist);
    }
    //互动直播1.0
    @Test(priority = 6)
    public void InteractiveNetcall1() throws Exception{

        //功能配置
        $(ApplicationDetailsPage.byElement("互动直播1.0-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("互动直播1.0-开发手册")).should(exist);
    }

    //互动直播2.0
    @Test(priority = 7)
    public void InteractiveNetcall2() throws Exception{

        //功能配置
        $(ApplicationDetailsPage.byElement("互动直播2.0-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("互动直播2.0-开发手册")).should(exist);
    }

    //教学白板
    @Test(priority = 8)
    public void EducationWhiteboard() throws Exception{

        //开发手册
        $(ApplicationDetailsPage.byElement("教学白板-开发手册")).should(exist);

    }

    //短信
    @Test(priority = 9)
    public void SMS() throws Exception{

        //已开通功能
        $(ApplicationDetailsPage.byElement("短信-已开通功能")).should(exist);

        //短信模板管理
        $(ApplicationDetailsPage.byElement("短信-短信模板管理")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("短信-开发手册")).should(exist);
    }

    //专线电话
    @Test(priority = 10)
    public void DedicatedTelephone() throws Exception{

        //开发手册
        $(ApplicationDetailsPage.byElement("专线电话-开发手册")).should(exist);
    }

    //隐私号码保护
    @Test(priority = 11)
    public void SmallPhone() throws Exception{

        //小号管理
//        $(ApplicationDetailsPage.byElement("隐私号码保护-小号管理")).should(exist);
    }

    //5G消息
    @Test(priority = 12)
    public void RCS5GSMS() throws Exception{

        //资质审核
        $(ApplicationDetailsPage.byElement("5G消息-资质审核")).should(exist);

        //ChatBot管理
        $(ApplicationDetailsPage.byElement("5G消息-ChatBot管理")).should(exist);

        //素材管理
        $(ApplicationDetailsPage.byElement("5G消息-素材管理")).should(exist);

        //模板管理
        $(ApplicationDetailsPage.byElement("5G消息-模板管理")).should(exist);

        //消息管理
        $(ApplicationDetailsPage.byElement("5G消息-消息管理")).should(exist);

        //回复管理
        $(ApplicationDetailsPage.byElement("5G消息-回复管理")).should(exist);

        //接口配置
        $(ApplicationDetailsPage.byElement("5G消息-接口配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("5G消息-开发手册")).should(exist);
    }
}
