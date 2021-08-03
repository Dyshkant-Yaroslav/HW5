package util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filterData")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterData {
    private String productType;
    private String brand;
    private int priceBounds;

    public FilterData() {
    }

    public FilterData(String productType, String brand, int priceBounds) {
        this.productType = productType;
        this.brand = brand;
        this.priceBounds = priceBounds;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPriceBounds() {
        return priceBounds;
    }

    public void setPriceBounds(int priceBounds) {
        this.priceBounds = priceBounds;
    }

    @Override
    public String toString() {
        return "FilterData{" +
                "productType='" + productType + '\'' +
                ", brand='" + brand + '\'' +
                ", priceBounds=" + priceBounds +
                '}';
    }
}