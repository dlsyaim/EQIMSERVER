package com.gisinfo.sand.util.docx.command;

import com.aspose.words.Paragraph;

/**
 * Created by luyj on 2016/5/12.
 */
public interface ICommand<M> {

    void setModel(M model);

    void handle(Paragraph paragraph) throws Exception;

}
