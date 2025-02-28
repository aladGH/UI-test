package Object;

/**
 * 封装页面元素，每个元素都有相应的定位地址（xpath路径或css或id）,等待时间，定位方式，默认为byXpath
 *
 */
public class Locator {
    private String address; // 定位地址
    private String name;// attribute定位名
    private ByType byType; // 定位方式

    /**
     * 定位类型枚举
     *
     */
    public enum ByType {
        byXpath, byName, byText, byTitle, byValue, byAttribute, byClassName,
        byId, byLinkText, byTagName,byCssSelector, byPartialLinkText
    }

    public Locator() {
    }

    /**
     * Locator构造器，默认定位类型byXpath
     *
     */
    public Locator(String address) {
        this.address = address;
        this.byType = ByType.byXpath;
    }


    public Locator(String address, ByType byType) {
        this.address = address;
        this.byType = byType;
    }

    public Locator(String attributeName, String address, ByType byType) {
        this.name = attributeName;
        this.address = address;
        this.byType = byType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttributeName() {
        return name;
    }

    public void setAttributeName(String name) {
        this.name = name;
    }

    public ByType getByType() {
        return byType;
    }

    public void setByType(ByType byType) {
        this.byType = byType;
    }

}
