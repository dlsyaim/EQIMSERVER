package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//港口条件类
public class HarborCondition {
    //港口名称
    private String harborName;
    //港口最小年吞吐量
    private String minHarborVolume;
    //港口最大年吞吐量
    private String maxHarborVolume;
    //港口抗震设防烈度
    private String harborIntensity;
    //当前页数
    private Integer pageNo;
    //每页记录数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer top;


    public String getHarborName() {
        return harborName;
    }

    public void setHarborName(String harborName) {
        this.harborName = harborName;
    }

    public String getMinHarborVolume() {
        return minHarborVolume;
    }

    public void setMinHarborVolume(String minHarborVolume) {
        this.minHarborVolume = minHarborVolume;
    }

    public String getMaxHarborVolume() {
        return maxHarborVolume;
    }

    public void setMaxHarborVolume(String maxHarborVolume) {
        this.maxHarborVolume = maxHarborVolume;
    }

    public String getHarborIntensity() {
        return harborIntensity;
    }

    public void setHarborIntensity(String harborIntensity) {
        this.harborIntensity = harborIntensity;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
