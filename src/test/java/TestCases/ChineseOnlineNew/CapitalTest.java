package TestCases.ChineseOnlineNew;
import Object.BasePage;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.NumberFormat;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

//资金管理
public class CapitalTest {
    private BasePage loginPage;
    private BasePage CapitalPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPage = new BasePage("loginPage","ChineseOnlineNew/LoginPage.xml");
        CapitalPage = new BasePage("CapitalPage", "ChineseOnlineNew/CapitalPage.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //资金管理页内容
    @Test(priority = 1)
    public void CapitalPage() throws Exception{
        $(CapitalPage.byElement("费用中心")).should(exist).click();
        $(CapitalPage.byElement("资金管理")).should(exist).click();
        $(CapitalPage.byElement("现金账户")).should(exist).shouldHave(text("现金账户"));
        $(CapitalPage.byElement("资源包")).should(exist).shouldHave(text("资源包"));
        $(CapitalPage.byElement("代金券")).should(exist).shouldHave(text("代金券"));
    }


    //现金账户
    @Test(priority = 2)
    public void Account() throws Exception{
        //第一个标题存在
        $(CapitalPage.byElement("现金账户信息")).should(exist).shouldHave(text("现金账户信息"));
        //充值按钮存在
        if (NumberFormat.getInstance().parse($(CapitalPage.byElement("账户可用额度")).getText()).doubleValue() < 0){
            $(CapitalPage.byElement("欠费充值按钮")).should(exist).shouldHave(text("欠费充值")).click();
            switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/payment");
            closeWindow();
            switchTo().window(0);
        }
        else {
            $(CapitalPage.byElement("充值按钮")).should(exist).shouldHave(text("充 值")).click();
            switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/payment");
            closeWindow();
            switchTo().window(0);
        }
        //收支明细按钮存在
        $(CapitalPage.byElement("收支明细")).should(exist).shouldHave(text("收支明细")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/transaction-flow");
        $(CapitalPage.byElement("资金管理")).should(exist).click();
        //设置余额预警超链接存在
        $(CapitalPage.byElement("设置余额预警超链接")).should(exist).shouldHave(text("设置余额预警")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        $(CapitalPage.byElement("返回按钮")).should(exist).click();
        $(CapitalPage.byElement("资金管理")).should(exist).click();
        //第二个标题存在
        $(CapitalPage.byElement("账户消费趋势")).should(exist).shouldHave(text("账户消费趋势"));
        //消费查看指南链接存在
        $(CapitalPage.byElement("消费查看指南链接")).should(exist).shouldHave(text("消费查看指南")).click();
        //校验链接地址
        switchTo().window(1).getCurrentUrl().equals("https://doc.yunxin.163.com/console/docs/TI1NTkzODk?platform=console");
        closeWindow();
        switchTo().window(0);
    }

    //资源包
    @Test(priority = 3)
    public void Resource() throws Exception{

        $(CapitalPage.byElement("资源包")).should(exist).click();
        sleep(1000);

        //国际短信
        $(CapitalPage.byElement("国际短信")).should(exist).shouldHave(text("国际短信")).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("短信-预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        $(CapitalPage.byElement("购买资源包")).should(exist).shouldHave(text("购买资源包")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/purchase-resource/sms?type=sms");
        sleep(200);
        closeWindow();
        switchTo().window(0);

        //视频短信
        $(CapitalPage.byElement("视频短信")).should(exist).shouldHave(text("视频短信")).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("短信-预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        $(CapitalPage.byElement("购买资源包")).should(exist).shouldHave(text("购买资源包")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/purchase-resource/sms?type=sms");
        sleep(200);
        closeWindow();
        switchTo().window(0);

        //云呼叫中心
        $(CapitalPage.byElement("云呼叫中心")).should(exist).shouldHave(text("云呼叫中心")).click();
        $(CapitalPage.byElement("资源包名称")).should(exist).shouldHave(text("资源包名称"));
        $(CapitalPage.byElement("下拉框")).should(exist).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("短信-预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
//        $(CapitalPage.byElement("下拉框-云呼叫中心A01固话")).should(exist).shouldHave(text("云呼叫中心A01固话"));
//        $(CapitalPage.byElement("下拉框-云呼叫中心A02固话混显")).should(exist).shouldHave(text("云呼叫中心A02固话混显"));
//        $(CapitalPage.byElement("下拉框-云呼叫中心A03固话400")).should(exist).shouldHave(text("云呼叫中心A03固话400"));
//        $(CapitalPage.byElement("下拉框-云呼叫中心B01点击拨号")).should(exist).shouldHave(text("云呼叫中心B01点击拨号"));
//        $(CapitalPage.byElement("下拉框-云呼叫中心B02小号直呼")).should(exist).shouldHave(text("云呼叫中心B02小号直呼"));
//        $(CapitalPage.byElement("下拉框-云呼叫中心语音验证码")).should(exist).shouldHave(text("云呼叫中心语音验证码"));
//        $(CapitalPage.byElement("下拉框-云呼叫中心语音通知")).should(exist).shouldHave(text("云呼叫中心语音通知"));

//        $(CapitalPage.byElement("下拉框-云呼叫中心A01固话")).should(exist).shouldHave(text("云呼叫中心A01固话")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心A01固话"));
//        $(CapitalPage.byElement("下拉框")).should(exist).click();
//        sleep(200);
//        $(CapitalPage.byElement("下拉框-云呼叫中心A02固话混显")).should(exist).shouldHave(text("云呼叫中心A02固话混显")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心A02固话混显"));
//        $(CapitalPage.byElement("下拉框")).should(exist).click();
//        sleep(200);
//        $(CapitalPage.byElement("下拉框-云呼叫中心A03固话400")).should(exist).shouldHave(text("云呼叫中心A03固话400")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心A03固话400"));
//        $(CapitalPage.byElement("下拉框")).should(exist).click();
//        sleep(200);
//        $(CapitalPage.byElement("下拉框-云呼叫中心B01点击拨号")).should(exist).shouldHave(text("云呼叫中心B01点击拨号")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心B01点击拨号"));
//        $(CapitalPage.byElement("下拉框")).should(exist).click();
//        sleep(200);
//        $(CapitalPage.byElement("下拉框-云呼叫中心B02小号直呼")).should(exist).shouldHave(text("云呼叫中心B02小号直呼")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心B02小号直呼"));
//        $(CapitalPage.byElement("下拉框")).should(exist).click();
//        sleep(200);
//        $(CapitalPage.byElement("下拉框-云呼叫中心语音验证码")).should(exist).shouldHave(text("云呼叫中心语音验证码")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心语音验证码"));
//        $(CapitalPage.byElement("下拉框")).should(exist).click();
//        sleep(200);
//        $(CapitalPage.byElement("下拉框-云呼叫中心语音通知")).should(exist).shouldHave(text("云呼叫中心语音通知")).click();
//        $(CapitalPage.byElement("下拉框文案")).should(exist).shouldHave(text("云呼叫中心语音通知"));

        //大客户短信
        $(CapitalPage.byElement("大客户短信")).should(exist).shouldHave(text("大客户短信")).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("短信-预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        //语音短信
        $(CapitalPage.byElement("语音短信")).should(exist).shouldHave(text("语音短信")).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("短信-预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        $(CapitalPage.byElement("购买资源包")).should(exist).shouldHave(text("购买资源包")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/purchase-resource/sms?type=VOICE_SMS");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        //普通文本短信
        $(CapitalPage.byElement("普通文本短信")).should(exist).shouldHave(text("普通文本短信")).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("短信-预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        $(CapitalPage.byElement("购买资源包")).should(exist).shouldHave(text("购买资源包")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/purchase-resource/sms?type=sms");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        //音视频通话2.0
        $(CapitalPage.byElement("音视频通话2.0")).should(exist).shouldHave(text("音视频通话2.0")).click();
        $(CapitalPage.byElement("已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("预警设置")).should(exist).shouldHave(text("预警设置")).click();
        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(200);
        closeWindow();
        switchTo().window(0);
        $(byXpath("/html/body/div[1]/section/main/main/div/div/main/div/div[3]/div/div/div/section/main/div/div[2]" +
                "/div[2]/div[2]/div[2]/span/button")).should(exist).shouldHave(text("购买资源包")).shouldHave(attribute("disabled"));
//        $(CapitalPage.byElement("购买资源包")).should(exist).shouldHave(text("购买资源包")).shouldHave(attribute("disabled"));
//        switchTo().window(1).getCurrentUrl().equals("https://app.yunxin.163.com/global/purchase-resource/sms?type=sms");
        sleep(200);

    }

    //代金券
    @Test(priority = 4)
    public void Coupon() throws Exception{
        $(CapitalPage.byElement("代金券")).should(exist).click();
        $(CapitalPage.byElement("代金券-已失效")).should(exist).shouldHave(text("已失效")).click();
        $(CapitalPage.byElement("代金券-可用")).should(exist).shouldHave(text("可用")).click();
        $(CapitalPage.byElement("代金券号")).should(exist).shouldHave(text("代金券号"));
        $(CapitalPage.byElement("发放时间")).should(exist).shouldHave(text("发放时间"));
        $(CapitalPage.byElement("适用范围")).should(exist).shouldHave(text("适用范围"));
        $(CapitalPage.byElement("余额")).should(exist).shouldHave(text("余额"));
        $(CapitalPage.byElement("历史消耗")).should(exist).shouldHave(text("历史消耗"));
        $(CapitalPage.byElement("代金券-开始生效日期")).should(exist).shouldHave(text("开始生效日期"));
        $(CapitalPage.byElement("代金券-有效截止日期")).should(exist).shouldHave(text("有效截止日期"));
        $(CapitalPage.byElement("代金券-备注")).should(exist).shouldHave(text("备注"));
        $(CapitalPage.byElement("代金券-操作")).should(exist).shouldHave(text("操作"));



    }

}
