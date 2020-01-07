package com.gisinfo.sand.util.docx.command;

/**
 * Created by luyj on 2016/5/15.
 */
public interface ICallback<I,T> {

    T callback(I in);

}
