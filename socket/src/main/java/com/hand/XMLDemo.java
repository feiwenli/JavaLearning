package com.hand;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 读取XML文件
 */

public class XMLDemo {
    public static void main(String [] args){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //DOM
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("languages.xml"));
            Element root = document.getDocumentElement();
            System.out.println("cat="+root.getAttribute("cat"));
            NodeList list = root.getElementsByTagName("lan");
            for (int i=0;i<list.getLength();i++){
                Element lan = (Element) list.item(i);
                System.out.println("----------------");
                System.out.println("id="+lan.getAttribute("id"));

                //不介意采用
//                Element name = (Element) lan.getElementsByTagName("name").item(0);
//                System.out.println("name="+name.getTextContent());

                NodeList child = lan.getChildNodes();
                for (int j =0; j<child.getLength();j++){
                    Node c =child.item(j);
                    // 除去不可见的节点
                    if (c instanceof Element) {
                        System.out.println(c.getNodeName() + "=" + c.getTextContent());
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
