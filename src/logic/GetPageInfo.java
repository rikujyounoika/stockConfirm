package logic;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GetPageInfo {
    private String url;
    private Document document = null;

    public GetPageInfo(String url){
        this.url = url;
        document = this.getDocument();
    }
    Document getDocument(){
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        try {
//            document = Jsoup.connect(url).proxy("127.0.01", 1080).headers(headers).timeout(60000).get();
            document = Jsoup.connect(url).headers(headers).timeout(60000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            document =Jsoup.parse(new URL(url).openStream(), "utf-8", url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(document);
        return document;
    }

    public Element getElement() {
        Element element = null;
        try {
            element = document.getElementById("js_m_submitRelated");
            System.out.println(element.outerHtml());
        }catch (NullPointerException  e) {
//            e.printStackTrace();
            element = document.getElementById("products_maintitle");
            System.out.println("完売");
            System.out.println(element.text());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

}
