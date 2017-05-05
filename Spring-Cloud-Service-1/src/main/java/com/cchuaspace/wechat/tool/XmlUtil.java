package com.cchuaspace.wechat.tool;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class XmlUtil  {


    public  Map<String, String> XmlAnalysis(String Xmldata) throws ParserConfigurationException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    /*    StringReader stringReader  =  new StringReader("<xml>\n" +
                "    <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "    <return_msg><![CDATA[OK]]></return_msg>\n" +
                "    <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "    <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "    <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>\n" +
                "    <openid><![CDATA[oUpF8uMuAJO_M2pxb1Q9zNjWeS6o]]></openid>\n" +
                "    <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>\n" +
                "    <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "    <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>\n" +
                "    <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "</xml>");*/


        StringReader stringReader  =  new StringReader(Xmldata);
        InputSource inputSource  =  new  InputSource(stringReader);
        Document doc = null;
        try {
            doc = dBuilder.parse(inputSource);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> container = new LinkedHashMap<String,String>();
        NodeList list = doc.getElementsByTagName("*");
        for(int i=1;i<list.getLength();i++){
            container.put(list.item(i).getNodeName(),list.item(i).getTextContent());
            /*container.forEach((key,value)->System.out.printf("%s = %s\n",key,value));*/

        }
        return container;
    }


    /*public static void main(String[] args) {

        try {
            Map<String, String> aa = XmlAnalysis();
            String bb =aa.get("result_code");
            System.out.print(bb);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }



    }
*/


}
