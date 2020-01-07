package com.gisinfo.sand.util.docx.command;

import com.aspose.words.*;

/**
 * Created by luyj on 2016/5/15.
 */
public class MergerDoc {

    /**
     * 判断节点是否为Paragaph或Table的一种
     * */
    private void validate(Node insertNode){
        if ((insertNode.getNodeType() != NodeType.PARAGRAPH) &
                (insertNode.getNodeType() != NodeType.TABLE))
            throw new IllegalArgumentException("The destination node should be either a paragraph or table.");
    }

    private Node copy(NodeImporter importer, Node node) throws Exception {
        return importer.importNode(node, true);
    }

    private void insertBefore(Node insertPositionNode,Node newNode){
        CompositeNode compositeNode = insertPositionNode.getParentNode();
        compositeNode.insertBefore(newNode,insertPositionNode);
    }

    private void insertAfter(Node insertPositionNode , Node newNode){
        CompositeNode compositeNode = insertPositionNode.getParentNode();
        compositeNode.insertAfter(newNode,insertPositionNode);
    }

    public void insertBefore(Node insertNode, Document srcDoc) throws Exception
    {
        validate(insertNode);
        NodeImporter importer = new NodeImporter(srcDoc, insertNode.getDocument(), ImportFormatMode.KEEP_SOURCE_FORMATTING);

        for(Section srcSection : srcDoc.getSections()){
            for(Node srcNode : (Iterable<Node>) srcSection.getBody()){
                if(srcNode.getNodeType() == NodeType.PARAGRAPH){
                    Paragraph para = (Paragraph)srcNode;
                    if(para.isEndOfSection() && !para.hasChildNodes()){
                        continue;
                    }
                }

                Node newNode = copy(importer,srcNode);
                insertBefore(insertNode , newNode);
            }
        }
    }

    public void insertAfter(Node insertNode, Document srcDoc) throws Exception
    {
        validate(insertNode);
        NodeImporter importer = new NodeImporter(srcDoc, insertNode.getDocument(), ImportFormatMode.KEEP_SOURCE_FORMATTING);

        for(Section srcSection : srcDoc.getSections()){
            for(Node srcNode : (Iterable<Node>) srcSection.getBody()){
                if(srcNode.getNodeType() == NodeType.PARAGRAPH){
                    Paragraph para = (Paragraph)srcNode;
                    if(para.isEndOfSection() && !para.hasChildNodes()){
                        continue;
                    }
                }

                Node newNode = copy(importer,srcNode);
                insertAfter(insertNode , newNode);
                insertNode = newNode;
            }
        }
    }

}
