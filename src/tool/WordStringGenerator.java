/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author Administrator
 */
public class WordStringGenerator {

    public WordStringGenerator() {
    }

    public static void main(String[] args) {
        parseXml();
    }

    public static List<String> parseXml() {

        List<String> wordList = new ArrayList<String>();
        String filePath = "src/files/ydcd.xml";
        File f = new File(filePath);
        try {
            SAXReader sr = new SAXReader();
            Document doc = sr.read(f);
            Element root = doc.getRootElement();
            Element workdbook = (Element)root.selectSingleNode("//wordbook");
            List<Element> list = workdbook.elements();
            //System.out.println(list.size());
            for (Element s : list) {
                Element word = (Element)s.selectSingleNode("word");
                String wordText = word.getText().trim();
                //System.out.println(wordText);
                wordList.add(wordText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
