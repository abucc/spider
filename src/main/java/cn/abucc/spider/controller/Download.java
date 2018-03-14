package cn.abucc.spider.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/***
 * 下载
 */

public class Download {
    public void DownloadPic(List<String> listImgSrc) {
        for (String url : listImgSrc) {
            try {
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                File file = new File("D:\\CatchImage");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fo = new FileOutputStream(file + "//" + imageName);
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println("抓取结束");
    }
}
