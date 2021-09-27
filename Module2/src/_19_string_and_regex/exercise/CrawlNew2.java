package _19_string_and_regex.exercise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNew2 {

    public static void main(String[] args) {
//        URL url = new URL("https://dantri.com.vn/the-gioi.htm");
        ArrayList<String> news = new ArrayList<>();
        String urls = "https://dantri.com.vn/the-gioi.htm";
        Document document = null;
        try {
            document = Jsoup.connect(urls).get();
            Elements elms = document.getElementsByClass("news-item__title");
            for (int i = 0; i < elms.size(); i++) {
                Elements elm_row = elms.get(i).getElementsByTag("a");
                for (int j = 0; j < elm_row.size(); j++) {
                    String newsTitle = elm_row.toString();
                    Pattern p = Pattern.compile("title=\"(.*?)\"");
                    Matcher m = p.matcher(newsTitle);
                    while (m.find()) {
                        System.out.println(m.group(1));
                        news.add(m.group(1));
                    }
                }
            }
            for (String newsTitle:news) {
                System.out.println(newsTitle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}