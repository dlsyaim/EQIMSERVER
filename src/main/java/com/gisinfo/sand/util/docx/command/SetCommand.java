package com.gisinfo.sand.util.docx.command;

import com.aspose.words.Paragraph;
import com.gisinfo.sand.util.ConstantsUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Created by luyj on 2016/5/12.
 */
public class SetCommand implements ICommand<Map<String,Object>> {

    private Map<String,Object> model = null;

    @Override
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    @Override
    public void handle(Paragraph paragraph) throws Exception {
        String text = paragraph.getText();
//        todo 测试文本
//        String text = "<doc:set param=\"year\"/>年<doc:set param=\"month\"/>月<doc:set param=\"date\"/>日";

        Matcher matcher = CommandPattern.SET.matcher(text);
        String command = ConstantsUtil.EMPTY_VALUE;
        String field = ConstantsUtil.EMPTY_VALUE;
        while (matcher.find()){
            command = matcher.group(0);
            field = matcher.group(1);

            paragraph.getRange().replace(command,toString(model.get(field)),true,false);
//            todo 测试替换功能代码
//            text = text.replaceAll(command,toString(model.get(field)));
        }

//        todo 测试结果查看
//        System.out.println(text);
    }

    private String toString(Object o){
        if(null == o){
            return ConstantsUtil.EMPTY_VALUE;
        }

        return o.toString();
    }

    public static void main(String[] args) {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("year","2016");
        model.put("month","5");
        model.put("date","12");

        ICommand<Map<String,Object>> command = new SetCommand();
        command.setModel(model);
        try {
            command.handle(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
