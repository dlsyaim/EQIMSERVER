package com.gisinfo.sand.mapTemplate.bean;

//打印服务参数
public class PrintParamBean {
    private String printType;//生成类型
    private String printWord;//对应word
    private String printName;//模板名称
    private String printLayers;//显示图层
    private String printTemplate;//模板
    private String printUrl;//模板地址
    private String printWordImgSize;//插入word图片大小
    private String printDownloadPath;//下载位置

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getPrintWord() {
        return printWord;
    }

    public void setPrintWord(String printWord) {
        this.printWord = printWord;
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    public String getPrintLayers() {
        return printLayers;
    }

    public void setPrintLayers(String printLayers) {
        this.printLayers = printLayers;
    }

    public String getPrintTemplate() {
        return printTemplate;
    }

    public void setPrintTemplate(String printTemplate) {
        this.printTemplate = printTemplate;
    }

    public String getPrintUrl() {
        return printUrl;
    }

    public void setPrintUrl(String printUrl) {
        this.printUrl = printUrl;
    }

    public String getPrintWordImgSize() {
        return printWordImgSize;
    }

    public void setPrintWordImgSize(String printWordImgSize) {
        this.printWordImgSize = printWordImgSize;
    }

    public String getPrintDownloadPath() {
        return printDownloadPath;
    }

    public void setPrintDownloadPath(String printDownloadPath) {
        this.printDownloadPath = printDownloadPath;
    }
}
