package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;

import com.baomidou.mybatisplus.annotation.TableField;

public class TEarthquakeProductsPsCondition {
    //当前页数
    private Integer pageNo;
    //每页显示条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer top;

    //关联的业务表中的记录
    @TableField("REL_ID")
    private String relId;

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

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }
}
