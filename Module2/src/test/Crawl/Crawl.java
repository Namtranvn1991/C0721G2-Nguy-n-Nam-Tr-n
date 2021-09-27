package test.Crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Crawl {
    private ArrayList<Chap> getAllChapInPage(String urls) throws IOException {
        ArrayList<Chap> list_chap = new ArrayList<>();
        Document document = Jsoup.connect(urls).get();
        Elements elms = document.getElementsByClass("row");
        for (int i = 0; i < elms.size(); i++) {
            Elements elm_row = elms.get(i).getElementsByTag("a");
            for (int j = 0; j < elm_row.size(); j++) {
                String link_chap = elm_row.first().absUrl("href");
                list_chap.add(new Chap(link_chap));
            }
        }
        return list_chap;
    }
    private ArrayList<String> listImgOnPage(String pageURL) throws IOException {
        Document document = Jsoup.connect(pageURL).get();
        ArrayList<String> list_img = new ArrayList<>();
        Elements elms = document.getElementsByClass("grab-content-chap");
        Elements e = document.getElementsByTag("img");
        for (int i = 0; i < e.size(); i++) {
            String url = e.get(i).absUrl("src");
            if (url.equals("")) {
                continue;
            }
            list_img.add(url);
        }
        return list_img;
    }
    private void saveImg(String src_image, String name, String dir) {
        try {
            URL url = new URL(src_image);
            InputStream in = url.openStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(dir + "\\" + name));
            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not Dowload File !");
        }
    }


}
