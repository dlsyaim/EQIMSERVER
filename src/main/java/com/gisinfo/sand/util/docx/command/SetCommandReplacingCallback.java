package com.gisinfo.sand.util.docx.command;

import com.aspose.words.*;
import com.gisinfo.sand.util.ConstantsUtil;

import java.util.Map;

/**
 * Created by luyj on 2016/5/12.
 */
public class SetCommandReplacingCallback implements IReplacingCallback {


    private String mainTemplatePath = ConstantsUtil.EMPTY_VALUE;
    private Map<String,Object> model = null;

    public SetCommandReplacingCallback(String mainTemplatePath,Map<String,Object> model) {
        this.mainTemplatePath = mainTemplatePath;
        this.model = model;
    }

    @Override
    public int replacing(ReplacingArgs replacingArgs) throws Exception {
        Node node = replacingArgs.getMatchNode().getParentNode();
        if(NodeType.PARAGRAPH == node.getNodeType()){
            Paragraph paragraph = (Paragraph)node;
            String text = paragraph.getText();

            ICommand command = null;
            if(CommandPattern.SET.matcher(text).find()){
                command = new SetCommand();
            }

            if(null != command){
                command.setModel(model);
                command.handle(paragraph);
            }
        }

        return ReplaceAction.SKIP;
    }

}
