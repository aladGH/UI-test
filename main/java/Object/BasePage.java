package Object;

import Utils.ElementUtil;
import Utils.LogUtil;
import Utils.XMLUtil;

import java.util.HashMap;

public class BasePage extends ElementUtil {
    protected String pageName;// 页面名称
    protected String xmlPath;// 页面元素配置文件路径
    protected String pageXml;// 存储页面元素的xml全称,带后缀
    protected HashMap<String, Locator> locatorMap;//存储页面元素信息
    public LogUtil log;

    public BasePage(String pageName, String pageXml) throws Exception {
        this.pageName = pageName;
        // 获取page.xml路径
        xmlPath = this.getClass().getResource("/XMLResources/").getPath() + pageXml;
        locatorMap = XMLUtil.readXMLDocument(xmlPath, pageName);
    }
}
