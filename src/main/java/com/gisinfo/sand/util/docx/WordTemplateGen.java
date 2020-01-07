package com.gisinfo.sand.util.docx;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.gisinfo.sand.util.ConstantsUtil;
import com.gisinfo.sand.util.docx.model.ImageModel;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by luyj on 2016/5/12.
 */
public class WordTemplateGen {

    public static boolean getLicense() {
//        return true;
        boolean result = false;
        try {
            InputStream is = WordTemplateGen.class.getClassLoader().getResourceAsStream(File.separator + "license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean gen(String templatePath, String outPath, Map<String, Object> model) {
        if (!WordTemplateGen.getLicense()) {
            return false;
        }

        try {
            Document document = new Document(templatePath);

            model.put(WordUtil.TEMPLATE_PATH, templatePath);

            document.getRange().replace(Pattern.compile("."), new TemplateReplacingCallback(model), false);
            //更新目录
            document.updateFields();

            document.save(outPath);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean genAndPDF(String templatePath, String outPath, Map<String, Object> model) {
        if (!WordTemplateGen.getLicense()) {
            return false;
        }

        try {
            Document document = new Document(templatePath);

            model.put(WordUtil.TEMPLATE_PATH, templatePath);

            document.getRange().replace(Pattern.compile("."), new TemplateReplacingCallback(model), false);
            //更新目录
            document.updateFields();
            //保存word
            document.save(outPath);
            //保存pdf
            String pdfPath = outPath.replaceAll("(?i)" + WordUtil.SUFFIX_DOCX, ConstantsUtil.SUFFIX_PDF)
                    .replaceAll("(?i)" + WordUtil.SUFFIX_DOC, ConstantsUtil.SUFFIX_PDF);
            document.save(pdfPath, SaveFormat.PDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

        ImageModel imageModel1 = new ImageModel();
        imageModel1.put("title", "图1 测试测试测试测试1");
        imageModel1.setImagePath("D:\\图片\\32x32\\3d_glasses.png");

        ImageModel imageModel2 = new ImageModel();
        imageModel2.put("title", "图2 测试测试测试测试2");
        imageModel2.setImagePath("D:\\图片\\32x32\\agp.png");

        List<ImageModel> imageModels = new ArrayList<ImageModel>();
        imageModels.add(imageModel1);
        imageModels.add(imageModel2);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("imagesOne", imageModels);
        //endregion

        boolean res = WordTemplateGen.gen("D:\\temp\\test.docx", "D:\\temp\\out.docx", model);
        System.out.println(res);
    }

}
