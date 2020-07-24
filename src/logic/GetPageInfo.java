package logic;

import java.io.IOException;
import java.net.SocketTimeoutException;
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

        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        try {
            document = Jsoup.connect(url).headers(headers).timeout(5000).get();
        } catch (SocketTimeoutException e){
            System.out.println("接続失敗しました");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Element getElement() {
        Element element = null;
        try {
            element = document.getElementById("js_m_submitRelated");
            SendMail mail = new SendMail();
            mail.send(document.getElementById("products_maintitle").text(), document.select("input[name=returnUrl]").val());
        }catch (NullPointerException  e) {
            element = document.getElementById("products_maintitle");
            System.out.println("完売");
            System.out.println(element.text());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

}
