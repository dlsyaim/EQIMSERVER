package com.gisinfo.sand.mapTemplate.wordUtil;//package com.gisinfo.sand.mapTemplate.test.service.chartUtil;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PieLabelLinkStyle;
//import org.jfree.chart.plot.PiePlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.BarRenderer;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.chart.title.TextTitle;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.PieDataset;
//import org.jfree.ui.RectangleInsets;
//
//import java.awt.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class JFChart {
////    /*public static void main{
////
////        //步骤1：创建XYDataset对象（准备数据）
////
////        XYDataset dataset = createXYDataset(maps);
////
////        //步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
////
////        JFreeChart freeChart = createChart(dataset);
////
////        //步骤3：将JFreeChart对象输出到文件，Servlet输出流等
////        saveAsFile(freeChart, "D:\\test\\ccc.png", 600, 400);
////
////    }*/
//
//    //生成chart图片
//    public static void createPicture(DefaultCategoryDataset data, String imgName, String chartImgUrl, String type, String titleName) {
//        JFreeChart freeChart = null;
//        if (type.equals("bar")) {
//            freeChart = createBarChart(data, titleName);//柱状图
//        } else {
//            freeChart = testCreateLineChart(data, titleName);//折线图
//        }
//        if (freeChart != null) {
//            saveAsFile(freeChart, chartImgUrl + "" + imgName + ".jpg", 600, 400);// 保存为PNG图片
//        }
//    }
//
//
//    //测试柱状图
//    private static JFreeChart createBarChart(DefaultCategoryDataset data, String titleName) {
//        JFreeChart jfreechart = ChartFactory.createBarChart(
//                titleName,
//                "",
//                "",
//                data,
//                PlotOrientation.VERTICAL,
//                true,
//                true,
//                false
//        );
//        CategoryPlot categoryPlot = jfreechart.getCategoryPlot();
//
//        //背景
//        categoryPlot.setBackgroundPaint(Color.WHITE);
//
//        //柱子上显示数值
//        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer.setBaseItemLabelsVisible(true);
//
//        // 取得Y轴 数据间隔
//        NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setAutoRangeIncludesZero(true);
//        rangeAxis.setUpperMargin(0.1);
//        rangeAxis.setLabelAngle(Math.PI / 2.0);
//
//        // 取得X轴
//        CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
//        // 设置X轴坐标上的文字
//        categoryAxis.setTickLabelFont(new Font("黑体", Font.BOLD, 12));
//        // 设置X轴的标题文字
//        categoryAxis.setLabelFont(new Font("黑体", Font.BOLD, 12));
//
//        //title标题
//        TextTitle textTitle = jfreechart.getTitle();
//        textTitle.setFont(new Font("宋体", Font.BOLD, 16));
//
//        return jfreechart;
//    }
//
//
//    //测试折线图
//    private static JFreeChart testCreateLineChart(DefaultCategoryDataset data, String titleName) {
//        // 创建柱状图.标题,X坐标,Y坐标,数据集合,orientation,是否显示legend,是否显示tooltip,是否使用url链接
//        JFreeChart chart = ChartFactory.createLineChart(titleName, "", "", data, PlotOrientation.VERTICAL, true, true, false);
//        chart.setBackgroundPaint(Color.WHITE);
//        Font font = new Font("宋体", Font.BOLD, 12);
//        chart.getTitle().setFont(font);//title
//        chart.setBackgroundPaint(Color.WHITE);//背景
//        chart.getLegend().setItemFont(font);//图例字体
//        // 配置字体（解决中文乱码的通用方法）
//        Font xfont = new Font("仿宋", Font.BOLD, 12); // X轴
//        Font yfont = new Font("宋体", Font.BOLD, 12); // Y轴
//        Font titleFont = new Font("宋体", Font.BOLD, 16); // 图片标题
//        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        categoryPlot.getDomainAxis().setLabelFont(xfont);
//        categoryPlot.getRangeAxis().setLabelFont(yfont);
//        chart.getTitle().setFont(titleFont);
//        categoryPlot.setBackgroundPaint(Color.WHITE);
//        // x轴 // 分类轴网格是否可见
//        categoryPlot.setDomainGridlinesVisible(false);
//        // y轴 //数据轴网格是否可见
//        categoryPlot.setRangeGridlinesVisible(true);
//        // 设置网格竖线颜色
//        categoryPlot.setDomainGridlinePaint(Color.LIGHT_GRAY);
//        // 设置网格横线颜色
//        categoryPlot.setRangeGridlinePaint(Color.LIGHT_GRAY);
//        // 没有数据时显示的文字说明
//        categoryPlot.setNoDataMessage("没有数据显示");
//        // 设置曲线图与xy轴的距离
//        categoryPlot.setAxisOffset(new RectangleInsets(0d, 0d, 0d, 0d));
//        // 设置面板字体
//        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
//        // 取得Y轴
//        NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setAutoRangeIncludesZero(true);
//        rangeAxis.setUpperMargin(0.20);
//        rangeAxis.setLabelAngle(Math.PI / 2.0);
//        // 取得X轴
//        CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
//        // 设置X轴坐标上的文字
//        categoryAxis.setTickLabelFont(new Font("黑体", Font.BOLD, 16));
//        // 设置X轴的标题文字
//        categoryAxis.setLabelFont(new Font("黑体", Font.BOLD, 16));
//        // 横轴上的 Lable 45度倾斜
//        //categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
//        // 设置距离图片左端距离
//        categoryAxis.setLowerMargin(0.0);
//        // 设置距离图片右端距离
//        categoryAxis.setUpperMargin(0.0);
//        // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
//        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
//        //lineandshaperenderer.setSeriesStroke(0, new BasicStroke(4.0F));//设置折线大小
//        lineandshaperenderer.setSeriesPaint(1, Color.yellow);//折线颜色
//        lineandshaperenderer.setSeriesPaint(0, Color.blue);//折线颜色
//        lineandshaperenderer.setSeriesPaint(2, Color.cyan);//折线颜色
//        // 是否显示折点
//        lineandshaperenderer.setBaseShapesVisible(true);
//        // 是否显示折线
//        lineandshaperenderer.setBaseLinesVisible(true);
//        // series 点（即数据点）间有连线可见 显示折点数据
//        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        lineandshaperenderer.setBaseItemLabelsVisible(true);
//        // ChartUtilities.saveChartAsJPEG(new File(filePath), chart, 1207, 500);
//        return chart;
//    }
//
//
//    //饼图
//    private static JFreeChart creatPieChart(PieDataset pieDataset) {
//        JFreeChart jFreeChart = ChartFactory.createPieChart("", pieDataset, false, true, false);
//        PiePlot piePlot = (PiePlot) jFreeChart.getPlot();
//        Font font = new Font("黑体", Font.BOLD, 16);
//        piePlot.setLabelFont(font);
//        piePlot.setNoDataMessage("noData!");
//        piePlot.setStartAngle(180);
//        piePlot.setForegroundAlpha(0.5F);
//        piePlot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
//        piePlot.setLabelBackgroundPaint(null);
//        piePlot.setLabelOutlinePaint(null);
//        piePlot.setLabelShadowPaint(null);
//        piePlot.setBackgroundPaint(null);
//        //piePlot.setBackgroundAlpha(0.0f);
//        return jFreeChart;
//    }
//
//
//    // 保存为文件
//    public static void saveAsFile(JFreeChart chart, String outputPath, int weight, int height) {
//        FileOutputStream out = null;
//        try {
//            File outFile = new File(outputPath);
//            if (!outFile.getParentFile().exists()) {
//                outFile.getParentFile().mkdirs();
//            }
//            out = new FileOutputStream(outputPath);
//            // 保存为PNG
//            ChartUtilities.writeChartAsPNG(out, chart, weight, height);
//            // 保存为JPEG
//            // ChartUtilities.writeChartAsJPEG(out, chart, weight, height);
//            out.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    // do nothing
//                }
//            }
//        }
//    }
//}
