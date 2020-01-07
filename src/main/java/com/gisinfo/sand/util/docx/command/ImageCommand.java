package com.gisinfo.sand.util.docx.command;

import com.aspose.words.*;
import com.gisinfo.sand.util.ConstantsUtil;
import com.gisinfo.sand.util.docx.TemplateReplacingCallback;
import com.gisinfo.sand.util.docx.WordTemplateGen;
import com.gisinfo.sand.util.docx.WordUtil;
import com.gisinfo.sand.util.docx.model.ImageModel;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luyj on 2016/5/12.
 */
public class ImageCommand implements ICommand<Map<String, Object>> {

    private Map<String, Object> model = null;

    @Override
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    @Override
    public void handle(Paragraph paragraph) throws Exception {
        String text = paragraph.getText();
//        todo 测试文本
//        String text = "<doc:image file=\"./segment/image.docx\" param=\"images\"/>";
        Matcher matcher = CommandPattern.IMAGE.matcher(text);

        String file = ConstantsUtil.EMPTY_VALUE;
        String field = ConstantsUtil.EMPTY_VALUE;
        if (matcher.find()) {
            file = matcher.group(1);
            field = matcher.group(2);

            String tempPath = getImageTemplatePath(file);
            List<Object> images = convert2List(field);
            ImageModel imageModel = null;
            Document subDoc = null;
            if (null == images) {
                imageModel = convert2ImageModel(field);
                imageModel.put(WordUtil.TEMPLATE_PATH,tempPath);
                subDoc = getDocument(tempPath, imageModel);
                new MergerDoc().insertAfter(paragraph, subDoc);
            } else {
                for (Object obj : images) {
                    imageModel = getImageModel(obj);
                    imageModel.put(WordUtil.TEMPLATE_PATH,tempPath);
                    subDoc = getDocument(tempPath, imageModel);
                    new MergerDoc().insertAfter(paragraph, subDoc);
                }
            }
        }

        paragraph.remove();
    }

    private List<Object> convert2List(String field) {
        Object obj = model.get(field);
        if (obj instanceof List) {
            return (List<Object>) obj;
        }

        return null;
    }

    private ImageModel convert2ImageModel(String field) throws Exception {
        Object obj = model.get(field);
        return getImageModel(obj);
    }

    private ImageModel getImageModel(Object obj) throws Exception {
        if (obj instanceof ImageModel) {
            return (ImageModel) obj;
        }

        throw new Exception("can not convert to " + ImageCommand.class.getName());
    }

    private String getImageTemplatePath(String file) throws Exception {
        if (StringUtils.isEmpty(file)) {
            throw new Exception("doc:image file is null or empty");
        }

        String mainTemplatePath = ObjectUtils.toString(model.get(WordUtil.TEMPLATE_PATH));
        String path = ConstantsUtil.EMPTY_VALUE;
        if (file.startsWith(".")) {
            path = mainTemplatePath.substring(0, mainTemplatePath.lastIndexOf(File.separator)) + File.separator + file;
        } else {
            path = file;
        }

        return path;
    }

    private Node findShapeOrDrawingML(Node node){
        if(node.getNodeType() == NodeType.SHAPE){
            return node;
        }

        if(!node.isComposite()){
            return null;
        }

        Node findNode = null;
        for(Node n : (Iterable<Node>) node){
            findNode = findShapeOrDrawingML(n);
            if(null != findNode){
                return findNode;
            }
        }

        return null;
    }

    private Document getDocument(String path, ImageModel imageModel) throws Exception {
        if (!WordTemplateGen.getLicense()) {
            return null;
        }

        Document document = new Document(path);
        Node node = findShapeOrDrawingML(document);
//        Node node = document.getAncestor(NodeType.DRAWING_ML);
        if(null != node) {
            if(node.getNodeType() == NodeType.SHAPE){
                Shape shape = (Shape) node;
                if(shape.hasImage()){
                    shape.getImageData().setImage(imageModel.getImagePath());
                }
            }
        }

//        DocumentBuilder docBuilder = new DocumentBuilder(document);
//        shape = docBuilder.insertImage(imageModel.getImagePath(),
//                RelativeHorizontalPosition.MARGIN,
//                100,
//                RelativeVerticalPosition.MARGIN,
//                100,
//                200,
//                100,
//                WrapType.SQUARE);

        document.getRange().replace(
                Pattern.compile("."),
                new TemplateReplacingCallback(imageModel),
                false);

        return document;
    }


    public static void main(String[] args) {

        ImageModel imageModel = new ImageModel();
        imageModel.put("title", "图1 测试测试测试测试");
        imageModel.setImagePath("D:\\图片\\32x32\\3d_glasses.png");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put(WordUtil.TEMPLATE_PATH, "D:\\temp\\test.docs");
        model.put("images", imageModel);

        ImageCommand command = new ImageCommand();
        command.setModel(model);
        try {
            command.handle(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
