package com.gisinfo.sand.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class DocToPdf {
    private static final Integer WORD_TO_PDF_OPERAND = 17;
    private static final Integer PPT_TO_PDF_OPERAND = 32;
    private static final Integer EXCEL_TO_PDF_OPERAND = 0;
    private static final Integer WD_FORMAT_DOCUMENT = 0;
public static void docSave(String filePath) {
        ActiveXComponent app = null;
        Dispatch doc = null;
        try {
            ComThread.InitSTA();
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", false);
            Dispatch docs = app.getProperty("Documents").toDispatch();
            Object[] obj = new Object[]{
                    filePath,
                    new Variant(false),
                    new Variant(false),//是否只读
                    new Variant(false),
                    new Variant("pwd")
            };
            doc = Dispatch.invoke(docs, "Open", Dispatch.Method, obj, new int[1]).toDispatch();
            Dispatch.put(doc, "RemovePersonalInformation", false);
            Dispatch.call(doc, "Save"); //word保存
            /*       Dispatch.call(doc, "SaveAs","path",WD_FORMAT_DOCUMENT);*/
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (doc != null) {
                Dispatch.call(doc, "Close", false);
            }
            if (app != null) {
                app.invoke("Quit", 0);
            }
            ComThread.Release();
        }
    }
    //word转换为pdf
    public static void doc2pdf(String srcFilePath, String pdfFilePath) throws Exception {
        ActiveXComponent app = null;
        Dispatch doc = null;
        Dispatch pageSetup=null;
        try {
            ComThread.InitSTA();
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", false);
            Dispatch docs = app.getProperty("Documents").toDispatch();
            Object[] obj = new Object[]{
                    srcFilePath,
                    new Variant(false),
                    new Variant(false),//是否只读
                    new Variant(false),
                    new Variant("pwd")
            };
            doc = Dispatch.invoke(docs, "Open", Dispatch.Method, obj, new int[1]).toDispatch();
            //设置纸张宽度，高度，PaperSize，PageHeight
            pageSetup = Dispatch.get(doc, "PageSetup").toDispatch();
//	          Dispatch.put(doc, "Compatibility", false);  //兼容性检查,为特定值false不正确
            Dispatch.put(pageSetup, "PageWidth","50");
            Dispatch.put(doc, "RemovePersonalInformation", false);
            Dispatch.call(doc, "ExportAsFixedFormat", pdfFilePath, WORD_TO_PDF_OPERAND); // word保存为pdf格式宏，值为17


        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (doc != null) {
                Dispatch.call(doc, "Close", false);
            }
            if (app != null) {
                app.invoke("Quit", 0);
            }
            ComThread.Release();
        }
    }

    //ppt转换为pdf
    public static void ppt2pdf(String srcFilePath, String pdfFilePath) throws Exception {
        ActiveXComponent app = null;
        Dispatch ppt = null;
        try {
            ComThread.InitSTA();
            app = new ActiveXComponent("PowerPoint.Application");
            Dispatch ppts = app.getProperty("Presentations").toDispatch();

            /*
             * call
             * param 4: ReadOnly
             * param 5: Untitled指定文件是否有标题
             * param 6: WithWindow指定文件是否可见
             * */
            ppt = Dispatch.call(ppts, "Open", srcFilePath, true,true, false).toDispatch();
            Dispatch.call(ppt, "SaveAs", pdfFilePath, PPT_TO_PDF_OPERAND); // ppSaveAsPDF为特定值32

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ppt != null) {
                Dispatch.call(ppt, "Close");
            }
            if (app != null) {
                app.invoke("Quit");
            }
            ComThread.Release();
        }
    }

    //excel转换为pdf
    public static void excel2Pdf(String inFilePath, String outFilePath) throws Exception {
        ComThread.InitSTA(true);
        ActiveXComponent ax=new ActiveXComponent("Excel.Application");
        try{
            ax.setProperty("Visible", new Variant(false));
            ax.setProperty("AutomationSecurity", new Variant(3)); //禁用宏
            Dispatch excels=ax.getProperty("Workbooks").toDispatch();

            Dispatch excel=Dispatch.invoke(excels,"Open",Dispatch.Method,new Object[]{
                            inFilePath,
                            new Variant(false),
                            new Variant(false)
                    },
                    new int[9]).toDispatch();

            //将所有列缩放为一页
            Dispatch currentSheet = Dispatch.get((Dispatch) excel,
                    "ActiveSheet").toDispatch();
            Dispatch pageSetup = Dispatch.get(currentSheet, "PageSetup")
                    .toDispatch();
            Dispatch.put(pageSetup, "Orientation", new Variant(2));
            Dispatch.put(pageSetup, "Zoom",false);
            /*  Dispatch.put(pageSetup, "StandardHeight",18); */
            Dispatch.put(pageSetup, "FitToPagesWide",1); // 所有列为一页(1或false)
            Dispatch.put(pageSetup, "FitToPagesTall",false);//行不缩放为一页StandardHeight

            //转换格式
            Dispatch.invoke(currentSheet,"ExportAsFixedFormat",Dispatch.Method,new Object[]{
                    new Variant(0), //PDF格式=0
                    outFilePath,
                    new Variant(0)  //0=标准 (生成的PDF图片不会变模糊) 1=最小文件 (生成的PDF图片糊的一塌糊涂)
            },new int[1]);
            //这里放弃使用SaveAs
	    		/*Dispatch.invoke(excel,"SaveAs",Dispatch.Method,new Object[]{
	    			outFile,
	    			new Variant(57),
	    			new Variant(false),
	    			new Variant(57),
	    			new Variant(57),
	    			new Variant(false),
	    			new Variant(true),
	    			new Variant(57),
	    			new Variant(true),
	    			new Variant(true),
	    			new Variant(true)
	    		},new int[1]);*/
            Dispatch.call(excel, "Close",new Variant(false));

            if(ax!=null){
                ax.invoke("Quit",new Variant[]{});
                ax=null;
            }
            ComThread.Release();
            ComThread.quitMainSTA();
        }catch(Exception es){
            es.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        //DocToPdf.docSave("C:\\Users\\gisinfo\\Desktop\\test.pdf");
        DocToPdf.doc2pdf("E:\\地震应急\\D07A4H-震区基本情况.docx",
                "E:\\地震应急\\D07A4H-震区基本情况.pdf");
        //DocToPdf.ppt2pdf("C:\\Users\\gisinfo\\Desktop\\D12A4H-灾情报告.pptx","C:\\Users\\gisinfo\\Desktop\\test.pdf");
        //DocToPdf.excel2Pdf("C:\\Users\\gisinfo\\Desktop\\巡线及阴保2019-10-01至2019-10-08.xls","C:\\Users\\gisinfo\\Desktop\\test.pdf");
    }
}
