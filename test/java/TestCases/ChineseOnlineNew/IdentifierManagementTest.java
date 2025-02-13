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
/**
    标识管理
 */
public class IdentifierManagementTest {
    private BasePage IdentifierManagementPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        IdentifierManagementPage = new BasePage("IdentifierManagementPage", "ChineseOnlineNew/IdentifierManagementPage.xml");
        //打开应用详情页面
        open("https://app.yunxin.163.com/global/application/overview/identification?appid=25126789");
        sleep(500);
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //抄送配置
    @Test(priority = 1)
    public void IdentifierManagement() throws Exception{
        sleep(500);
        //苹果标题
        $(IdentifierManagementPage.byElement("苹果")).should(exist).shouldHave(text("iOS Bundle Identifier"));
        //苹果-编辑按钮
        $(IdentifierManagementPage.byElement("苹果-编辑按钮")).should(exist).shouldHave(text("编辑")).click();
        //苹果-新增按钮
        $(IdentifierManagementPage.byElement("苹果-新增按钮")).should(exist).shouldHave(text("新增"));
        //苹果-保存按钮
        $(IdentifierManagementPage.byElement("苹果-保存按钮")).should(exist).shouldHave(text("保存"));
        //苹果-取消按钮
        $(IdentifierManagementPage.byElement("苹果-取消按钮")).should(exist).shouldHave(text("取消")).click();

        //安卓标题
        $(IdentifierManagementPage.byElement("安卓")).should(exist).shouldHave(text("Android Package Name"));
        //安卓-编辑按钮
        $(IdentifierManagementPage.byElement("安卓-编辑按钮")).should(exist).shouldHave(text("编辑")).click();
        //安卓-新增按钮
        $(IdentifierManagementPage.byElement("安卓-新增按钮")).should(exist).shouldHave(text("新增"));
        //安卓-保存按钮
        $(IdentifierManagementPage.byElement("安卓-保存按钮")).should(exist).shouldHave(text("保存"));
        //安卓-取消按钮
        $(IdentifierManagementPage.byElement("安卓-取消按钮")).should(exist).shouldHave(text("取消")).click();

        //鸿蒙标题
        $(IdentifierManagementPage.byElement("鸿蒙")).should(exist).shouldHave(text("HarmonyOS Package Name"));
        //鸿蒙-编辑按钮
        $(IdentifierManagementPage.byElement("鸿蒙-编辑按钮")).should(exist).shouldHave(text("编辑")).click();
        //鸿蒙-新增按钮
        $(IdentifierManagementPage.byElement("鸿蒙-新增按钮")).should(exist).shouldHave(text("新增"));
        //鸿蒙-保存按钮
        $(IdentifierManagementPage.byElement("鸿蒙-保存按钮")).should(exist).shouldHave(text("保存"));
        //鸿蒙-取消按钮
        $(IdentifierManagementPage.byElement("鸿蒙-取消按钮")).should(exist).shouldHave(text("取消")).click();

        //标识安全验证
        $(IdentifierManagementPage.byElement("标识安全验证-文案")).should(exist).shouldHave(text("进行标识安全验证：当请求登录的客户端App标识不在以上列表中时，登录请求将被拒绝。"));
        //标识安全验证-开关
        $(IdentifierManagementPage.byElement("标识安全验证-开关")).should(exist).click();
        //切换到弹窗
//        switchTo().alert();
        //标识安全验证-弹窗-标题
        $(IdentifierManagementPage.byElement("标识安全验证-弹窗-标题")).should(exist).shouldHave(text("重要提示"));
        //标识安全验证-弹窗-文案
        $(IdentifierManagementPage.byElement("标识安全验证-弹窗-文案")).should(exist).shouldHave(text("勾选此选项并保存后，当请求登录的客户端 App 标识 不在以上列表中时，登录请求将被拒绝"));
        //标识安全验证-弹窗-取消
        $(IdentifierManagementPage.byElement("标识安全验证-弹窗-取消")).should(exist).shouldHave(text("取 消"));
        //标识安全验证-弹窗-确定
        $(IdentifierManagementPage.byElement("标识安全验证-弹窗-确定")).should(exist).shouldHave(text("确 定")).click();
        sleep(1000);
        //标识安全验证-开关
        $(IdentifierManagementPage.byElement("标识安全验证-开关")).should(exist).click();
        sleep(1000);
    }



}
