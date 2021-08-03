package util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rozetkaFilter")
@XmlAccessorType(XmlAccessType.FIELD)
public class RozetkaFilter {

    @XmlElement(name = "filterData")
    private List<FilterData> filterDataList = null;

    public List<FilterData> getFilterDataList() {
        return filterDataList;
    }

    public void setFilterDataList(List<FilterData> filterDataList) {
        this.filterDataList = filterDataList;
    }

    @Override
    public String toString() {
        return "RozetkaFilter{" +
                "filterDataList=" + filterDataList +
                '}';
    }
}