package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
    证书管理
 */
public class CertificateManagementTest {
    private BasePage CertificateManagementPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        CertificateManagementPage = new BasePage("CertificateManagementPage", "ChineseOnlineNew/CertificateManagementPage.xml");
        //打开应用详情页面
        open("https://app.yunxin.163.com/global/application/overview/certificate?appid=25126789");
        sleep(500);
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //抄送配置
    @Test(priority = 1)
    public void CertificateManagement() throws Exception{
        sleep(500);
        //iOS-P12标题
        $(CertificateManagementPage.byElement("IOS-P12-标题")).should(exist).shouldHave(text("iOS APNS P12推送证书"));
        //IOS-P12添加证书按钮
        $(CertificateManagementPage.byElement("IOS-P12-添加证书")).should(exist).shouldHave(text("添加证书"));
        //证书名称
        $(CertificateManagementPage.byElement("IOS-P12-表格-证书名称")).should(exist).shouldHave(text("证书名称"));
        //P12证书
        $(CertificateManagementPage.byElement("IOS-P12-表格-P12证书")).should(exist).shouldHave(text("P12证书"));
        //证书密钥
        $(CertificateManagementPage.byElement("IOS-P12-表格-证书密钥")).should(exist).shouldHave(text("证书密钥"));
        //证书有效期
        $(CertificateManagementPage.byElement("IOS-P12-表格-证书有效期")).should(exist).shouldHave(text("证书有效期"));
        //有效期剩余时间
        $(CertificateManagementPage.byElement("IOS-P12-表格-有效期剩余时间")).should(exist).shouldHave(text("有效期剩余时间"));
        //证书环境
        $(CertificateManagementPage.byElement("IOS-P12-表格-证书环境")).should(exist).shouldHave(text("证书环境"));
        //iOS Bundle ldentifier
        $(CertificateManagementPage.byElement("IOS-P12-表格-iOS-Bundle-Identifier")).should(exist).shouldHave(text("iOS Bundle Identifier"));
        //操作
        $(CertificateManagementPage.byElement("IOS-P12-表格-操作")).should(exist).shouldHave(text("操作"));


        //IOS-P8标题
        $(CertificateManagementPage.byElement("IOS-P8-标题")).should(exist).shouldHave(text("iOS APNS P8推送证书"));
        //IOS-P8添加证书按钮
        $(CertificateManagementPage.byElement("IOS-P8-添加证书")).should(exist).shouldHave(text("添加证书"));
        //证书名称
        $(CertificateManagementPage.byElement("IOS-P8-表格-证书名称")).should(exist).shouldHave(text("证书名称"));
        //P12证书
        $(CertificateManagementPage.byElement("IOS-P8-表格-P8证书")).should(exist).shouldHave(text("P8证书"));
        //证书环境
        $(CertificateManagementPage.byElement("IOS-P8-表格-证书环境")).should(exist).shouldHave(text("证书环境"));
        //iOS Bundle ldentifier
        $(CertificateManagementPage.byElement("IOS-P8-表格-iOS-Bundle-Identifier")).should(exist).shouldHave(text("iOS Bundle Identifier"));
        //操作
        $(CertificateManagementPage.byElement("IOS-P8-表格-操作")).should(exist).shouldHave(text("操作"));



        //iOS PushKit标题
        $(CertificateManagementPage.byElement("IOS-PushKit-标题")).should(exist).shouldHave(text("iOS PushKit推送证书"));
        //iOS PushKit添加证书按钮
        $(CertificateManagementPage.byElement("IOS-PushKit-添加证书")).should(exist).shouldHave(text("添加证书"));
        //证书名称
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-证书名称")).should(exist).shouldHave(text("证书名称"));
        //P12证书
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-P12证书")).should(exist).shouldHave(text("P12证书"));
        //证书密钥
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-证书密钥")).should(exist).shouldHave(text("证书密钥"));
        //证书有效期
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-证书有效期")).should(exist).shouldHave(text("证书有效期"));
        //有效期剩余时间
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-有效期剩余时间")).should(exist).shouldHave(text("有效期剩余时间"));
        //证书环境
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-证书环境")).should(exist).shouldHave(text("证书环境"));
        //iOS Bundle ldentifier
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-iOS-Bundle-Identifier")).should(exist).shouldHave(text("iOS Bundle Identifier"));
        //操作
        $(CertificateManagementPage.byElement("IOS-PushKit-表格-操作")).should(exist).shouldHave(text("操作"));

        //Android-标题
        $(CertificateManagementPage.byElement("Android-标题")).should(exist).shouldHave(text("Android推送证书"));
        //Android-添加证书按钮
        $(CertificateManagementPage.byElement("Android-添加证书")).should(exist).shouldHave(text("添加证书"));
        //Android-表格-证书名称
        $(CertificateManagementPage.byElement("Android-表格-证书名称")).should(exist).shouldHave(text("证书名称"));
        //Android-表格-应用包名
        $(CertificateManagementPage.byElement("Android-表格-证书类型")).should(exist).shouldHave(text("证书类型"));
        //筛选按钮
        $(CertificateManagementPage.byElement("Android-表格-证书类型-筛选按钮")).should(exist).click();
        sleep(5000);
        //Android-表格-证书类型-小米
        $(CertificateManagementPage.byElement("Android-表格-证书类型-小米")).should(exist).shouldHave(text("小米")).click();
        //Android-表格-证书类型-华为
        $(CertificateManagementPage.byElement("Android-表格-证书类型-华为")).should(exist).shouldHave(text("华为")).click();
        //Android-表格-证书类型-荣耀
        $(CertificateManagementPage.byElement("Android-表格-证书类型-荣耀")).should(exist).shouldHave(text("荣耀")).click();
        //Android-表格-证书类型-魅族
        $(CertificateManagementPage.byElement("Android-表格-证书类型-魅族")).should(exist).shouldHave(text("魅族")).click();
        //Android-表格-证书类型-谷歌
        $(CertificateManagementPage.byElement("Android-表格-证书类型-谷歌")).should(exist).shouldHave(text("谷歌")).click();
        //Android-表格-证书类型-VIVO
        $(CertificateManagementPage.byElement("Android-表格-证书类型-VIVO")).should(exist).shouldHave(text("VIVO")).click();
        //Android-表格-证书类型-OPPO
        $(CertificateManagementPage.byElement("Android-表格-证书类型-OPPO")).should(exist).shouldHave(text("OPPO")).click();
        //Android-表格-证书类型-重置
        $(CertificateManagementPage.byElement("Android-表格-证书类型-重置")).should(exist).shouldHave(text("重置")).click();
        //Android-表格-证书类型-确定
        $(CertificateManagementPage.byElement("Android-表格-证书类型-确定")).should(exist).shouldHave(text("确 定")).click();
        //Android-表格-ProjectId
        $(CertificateManagementPage.byElement("Android-表格-应用包名")).should(exist).shouldHave(text("应用包名"));
        //Android-表格-KeyId
        $(CertificateManagementPage.byElement("Android-表格-AppSecret")).should(exist).shouldHave(text("AppSecret"));
        //Android-表格-SubAccount
        $(CertificateManagementPage.byElement("Android-表格-Activity")).should(exist).shouldHave(text("Activity"));
        //Android-表格-操作
        $(CertificateManagementPage.byElement("Android-表格-操作")).should(exist).shouldHave(text("操作"));
        //Android-通道优先级文案
        $(CertificateManagementPage.byElement("Android-通道优先级文案")).should(exist).shouldHave(text("安卓设备推送通道优先级："));
        //Android-推送优先编辑按钮
        $(CertificateManagementPage.byElement("Android-推送优先编辑按钮")).should(exist).shouldHave(text("编辑")).click();
        //Android-FCM推送优先
        $(CertificateManagementPage.byElement("Android-FCM推送优先")).should(exist).shouldHave(text("FCM推送优先")).click();
        //Android-推送优先确定按钮
        $(CertificateManagementPage.byElement("Android-推送优先确定按钮")).should(exist).shouldHave(text("确定")).click();
        //Android-推送优先编辑按钮
        $(CertificateManagementPage.byElement("Android-推送优先编辑按钮")).should(exist).shouldHave(text("编辑")).click();
        //Android-厂商推送优先
        $(CertificateManagementPage.byElement("Android-厂商推送优先")).should(exist).shouldHave(text("厂商推送优先")).click();
        //Android-推送优先取消按钮
        $(CertificateManagementPage.byElement("Android-推送优先取消按钮")).should(exist).shouldHave(text("取消")).click();
        //Android-推送优先编辑按钮
        $(CertificateManagementPage.byElement("Android-推送优先编辑按钮")).should(exist).shouldHave(text("编辑")).click();
        //Android-厂商推送优先
        $(CertificateManagementPage.byElement("Android-厂商推送优先")).should(exist).shouldHave(text("厂商推送优先")).click();
        //Android-推送优先确定按钮
        $(CertificateManagementPage.byElement("Android-推送优先确定按钮")).should(exist).shouldHave(text("确定")).click();


        //HarmonyOS-标题
        $(CertificateManagementPage.byElement("HarmonyOS-标题")).should(exist).shouldHave(text("HarmonyOS推送证书"));
        //HarmonyOS-添加证书按钮
        $(CertificateManagementPage.byElement("HarmonyOS-添加证书")).should(exist).shouldHave(text("添加证书"));
        //HarmonyOS-表格-证书名称
        $(CertificateManagementPage.byElement("HarmonyOS-表格-证书名称")).should(exist).shouldHave(text("证书名称"));
        //HarmonyOS-表格-应用包名
        $(CertificateManagementPage.byElement("HarmonyOS-表格-应用包名")).should(exist).shouldHave(text("应用包名"));
        //HarmonyOS-表格-ProjectId
        $(CertificateManagementPage.byElement("HarmonyOS-表格-ProjectId")).should(exist).shouldHave(text("ProjectId"));
        //HarmonyOS-表格-KeyId
        $(CertificateManagementPage.byElement("HarmonyOS-表格-KeyId")).should(exist).shouldHave(text("KeyId"));
        //HarmonyOS-表格-SubAccount
        $(CertificateManagementPage.byElement("HarmonyOS-表格-SubAccount")).should(exist).shouldHave(text("SubAccount"));
        //HarmonyOS-表格-操作
        $(CertificateManagementPage.byElement("HarmonyOS-表格-操作")).should(exist).shouldHave(text("操作"));

    }



}
