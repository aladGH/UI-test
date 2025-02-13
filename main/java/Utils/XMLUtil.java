package Utils;

import Object.Locator;
import Object.Locator.*;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XMLUtil {

    static HashMap<String, Locator> locatorMap = new HashMap<>();

    /**
     * 读取页面配置文件
     *
     * @param xmlUrl
     *            页面配置文件路径
     * @param pageName
     *            页面名称
     */
    public static HashMap<String, Locator> readXMLDocument(String xmlUrl, String pageName) throws Exception {
        LogUtil log = new LogUtil(XMLUtil.class);
//        HashMap<String, Locator> locatorMap = new HashMap<>();
        File file = new File(xmlUrl);
        if (!file.exists()) {
            log.error("can't find " + xmlUrl);
        } else {
            // 创建SAXReader对象
            SAXReader sr = new SAXReader();
            // 读取xml文件转换为Document
            Document document = sr.read(file);
            // 获取所有根节点元素对象
            Element root = document.getRootElement();
            Iterator<?> rootIte = root.elementIterator();
            Locator locator = null;
            // 遍历根节点
            while (rootIte.hasNext()) {
                Element page = (Element) rootIte.next();
                // 忽略大小写比较
                if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {
                    log.info("pageName is " + pageName);
                    Iterator<?> pageIte = page.elementIterator();
                    // 找到pageName后遍历该page内各个节点
                    while (pageIte.hasNext()) {
                        String name = "";
                        String type = "";
                        String value = "";
                        String locatorName = "";
                        Element locatorEle = (Element) pageIte.next();
                        Iterator<?> locatorIte = locatorEle.attributeIterator();
                        // 遍历单个标签内的元素
                        while (locatorIte.hasNext()) {
                            Attribute attribute = (Attribute) locatorIte.next();
                            String attributeName = attribute.getName();
                            if (attributeName.equals("type")) {
                                type = attribute.getValue();
                            } else if (attributeName.equals("value")) {
                                value = attribute.getValue();
                            } else if (attributeName.equals("name")) {
                                name = attribute.getValue();
                            }
                        }
                        locator = new Locator(name, value, getByType(type));
                        locatorName = locatorEle.getText();
                        locatorMap.put(locatorName, locator);

                    }
                    break;
                }
            }
        }
        return locatorMap;
    }

    /**
     * 转换元素定位类型
     *
     */
    public static ByType getByType(String type) {
        ByType byType = ByType.byXpath;
        if (type == null || type.equalsIgnoreCase("byXpath")) {
            byType = ByType.byXpath;
        } else if (type.equalsIgnoreCase("byId")) {
            byType = ByType.byId;
        } else if (type.equalsIgnoreCase("byName")) {
            byType = ByType.byName;
        } else if (type.equalsIgnoreCase("byClassName")) {
            byType = ByType.byClassName;
        } else if (type.equalsIgnoreCase("byLinkText")) {
            byType = ByType.byLinkText;
        } else if (type.equalsIgnoreCase("byTagName")) {
            byType = ByType.byTagName;
        } else if (type.equalsIgnoreCase("byText")) {
            byType = ByType.byText;
        } else if (type.equalsIgnoreCase("byTitle")) {
            byType = ByType.byTitle;
        } else if (type.equalsIgnoreCase("byValue")) {
            byType = ByType.byValue;
        } else if (type.equalsIgnoreCase("byAttribute")) {
            byType = ByType.byAttribute;
        } else if (type.equalsIgnoreCase("byCssSelector")) {
            byType = ByType.byCssSelector;
        } else if (type.equalsIgnoreCase("byPartialLinkText")) {
            byType = ByType.byPartialLinkText;
        }
        return byType;
    }

    /**
     * 根据locatorName返回对应的locator
     *
     *
     */
    public static Locator getLocator(String locatorName) {
        Locator locator = null;
        if (locatorMap != null) {
            locator = locatorMap.get(locatorName);
        }
        return locator;
    }
}