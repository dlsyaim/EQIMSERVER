package com.gisinfo.sand.util.docx.command;

import java.util.regex.Pattern;

/**
 * Created by luyj on 2016/5/12.
 */
public class CommandPattern {

    public static Pattern COMMAND = Pattern.compile("<doc:\\.*/>");

    public static Pattern SET = Pattern.compile("<doc:set\\s+param=\"(\\S+)\"\\s*/>");

    public static Pattern IMAGE = Pattern.compile("^<doc:image\\s+file=\"(\\S+)\"\\s+param=\"(\\S+)\"\\s*/>$");
    public static Pattern TABLE = Pattern.compile("^<doc:table\\s+file=\"(\\S+)\"\\s+param=\"(\\S+)\"\\s*/>$");

    public static void main(String[] args) {

        System.out.println(COMMAND.matcher("<doc:set param=\"year\"/>年<doc:set param=\"month\"/>月<doc:set param=\"date\"/>日").find());

    }

}
