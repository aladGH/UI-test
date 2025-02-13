package Utils;

import Object.Locator;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;

public class ElementUtil {

    /**
     * 封装定位方式、元素路径
     */

    public By byElement(String locatorName) throws Exception {
        By element = null;
        Locator locator = XMLUtil.getLocator(locatorName);
        String address = locator.getAddress();
        String name = locator.getAttributeName();
        switch (locator.getByType()) {
            case byXpath:
                element = byXpath(address);
                break;
            case byId:
                element = byId(address);
                break;
            case byName:
                element = byName(address);
                break;
            case byClassName:
                element = byClassName(address);
                break;
            case byLinkText:
                element = byLinkText(address);
                break;
            case byTagName:
                element = byTagName(address);
                break;
            case byText:
                element = byText(address);
                break;
            case byTitle:
                element = byTitle(address);
                break;
            case byValue:
                element = byValue(address);
                break;
            case byAttribute:
                element = byAttribute(name, address);
                break;
            case byCssSelector:
                element = byCssSelector(address);
                break;
            case byPartialLinkText:
                element = byPartialLinkText(address);
                break;
            default:
                break;
        }
        return element;
    }
}
