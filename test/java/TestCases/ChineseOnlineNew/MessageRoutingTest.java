package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MessageRoutingTest {
    private BasePage MessageRoutingPage;
    private BasePage ApplicationDetailsPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        MessageRoutingPage = new BasePage("MessageRoutingPage", "ChineseOnlineNew/MessageRoutingPage.xml");
        ApplicationDetailsPage = new BasePage("ApplicationDetailsPage", "ChineseOnlineNew/ApplicationDetailsPage.xml");
        //打开应用详情页面
        open("https://app.yunxin.163.com/global/application/overview/appkey?appid=25126789");
        sleep(500);
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //抄送配置
    @Test(priority = 1)
    public void MessageRouting() throws Exception{
        sleep(500);
        $(ApplicationDetailsPage.byElement("应用配置-消息抄送")).should(exist).click();
        //IM/RTC/短信/白板抄送标签
        $(MessageRoutingPage.byElement("IM/RTC/短信/白板抄送-标签")).should(exist).shouldHave(text("IM/RTC/短信/白板抄送"));
        //NERoom抄送-标签
        $(MessageRoutingPage.byElement("NERoom抄送-标签")).should(exist).shouldHave(text("NERoom抄送"));
        //标题
        $(MessageRoutingPage.byElement("抄送配置-标题")).should(exist).shouldHave(text("抄送配置"));
        //抄送配置-解答链接
        $(MessageRoutingPage.byElement("抄送配置-解答链接")).should(exist).shouldHave(text("如何配置IM/RTC/短信/白板等消息抄送？")).click();
        sleep(2000);
        //校验文档地址
        switchTo().window(1).getCurrentUrl().equals("https://doc.yunxin.163.com/messaging/server-apis/jY5MDk1NTQ?platform=server");
        Selenide.closeWindow();
        switchTo().window(0);
        //抄送范围
        $(MessageRoutingPage.byElement("抄送范围")).should(exist).shouldHave(text("抄送范围"));
        //抄送范围-说明
        $(MessageRoutingPage.byElement("抄送范围-说明")).should(exist).shouldHave(text("IM即时通讯、音视频通话1.0或2.0、短信、呼叫组件"));
        //抄送开关
        $(MessageRoutingPage.byElement("抄送开关按钮")).should(exist);
        //抄送地址
        $(MessageRoutingPage.byElement("抄送地址")).should(exist).shouldHave(text("抄送地址"));
        //抄送地址-输入框
        $(MessageRoutingPage.byElement("抄送地址-输入框")).should(exist).shouldHave(attribute("placeholder", "请输入抄送地址，校验成功后即可开启抄送状态"));
        //抄送地址-编辑按钮
        $(MessageRoutingPage.byElement("抄送地址-编辑按钮")).should(exist).shouldHave(text("编辑"));
        //自定义抄送/第三方回调配置
        $(MessageRoutingPage.byElement("自定义抄送")).should(exist).shouldHave(text("自定义抄送/第三方回调配置"));
        //说明文案
        $(MessageRoutingPage.byElement("自定义抄送-说明")).should(exist).shouldHave(text("前往 功能管理-基础功能-第三方回调"));
        //跳转配置页按钮
        $(MessageRoutingPage.byElement("自定义抄送-配置跳转")).should(exist).shouldHave(text("配置"));
        //添加按钮
        $(MessageRoutingPage.byElement("自定义抄送-添加按钮")).should(exist).shouldHave(text("添 加"));
        //环境名称
        $(MessageRoutingPage.byElement("自定义抄送-表格环境名称")).should(exist).shouldHave(text("环境名称"));
        //抄送地址
        $(MessageRoutingPage.byElement("自定义抄送-表格抄送地址")).should(exist).shouldHave(text("抄送地址"));
        //第三方回调地址
        $(MessageRoutingPage.byElement("自定义抄送-表格第三方回调地址")).should(exist).shouldHave(text("第三方回调地址"));
        //操作
        $(MessageRoutingPage.byElement("自定义抄送-表格操作")).should(exist).shouldHave(text("操作"));
        //无数据文案
        $(MessageRoutingPage.byElement("无数据文案")).should(exist).shouldHave(text("暂无数据"));



        //NERoom抄送-标签
        $(MessageRoutingPage.byElement("NERoom抄送-标签")).click();
        //NERoom抄送配置-解答链接
        $(MessageRoutingPage.byElement("NERoom抄送-解答链接")).should(exist).shouldHave(text("如何配置NERoom消息抄送？")).click();
        sleep(2000);
        //校验文档地址
        switchTo().window(1).getCurrentUrl().equals("https://doc.yunxin.163.com/neroom/server-apis/zYxNzIzMTE?platform=server");
        Selenide.closeWindow();
        switchTo().window(0);
        //标题
        $(MessageRoutingPage.byElement("NERoom抄送配置-标题")).should(exist).shouldHave(text("抄送配置"));
        //NERoom抄送开关
        $(MessageRoutingPage.byElement("NERoom抄送开关按钮")).should(exist);
        //NERoom抄送范围
        $(MessageRoutingPage.byElement("NERoom抄送范围")).should(exist).shouldHave(text("抄送范围"));
        //NERoom抄送范围-说明
        $(MessageRoutingPage.byElement("NERoom抄送范围-说明")).should(exist).shouldHave(text("NERoom房间组件模板"));
        //NERoom抄送开关
        $(MessageRoutingPage.byElement("NERoom抄送开关按钮")).should(exist);
        //抄送地址
        $(MessageRoutingPage.byElement("NERoom抄送地址")).should(exist).shouldHave(text("抄送地址"));
        //抄送地址-输入框
        $(MessageRoutingPage.byElement("NERoom抄送地址-输入框")).should(exist).shouldHave(attribute("placeholder", "请输入抄送地址，校验成功后即可开启抄送状态"));
        //抄送地址-编辑按钮
        $(MessageRoutingPage.byElement("NERoom抄送地址-编辑按钮")).should(exist).shouldHave(text("编辑"));
    }



}
