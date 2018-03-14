package cn.abucc.spider.controller;

import java.util.List;

/**
 * ɸѡͼƬ��ʽ
 */
public class Proving {
    public List<String> screenPictures(List<String> list) {
        String[] format = new String[]{".BMP", ".JPG", ".PNG", ".TIFF", ".GIF", ".PCV", ".TGA", ".EXIF", ".FPX", ".SVG", ".PSD",
                ".CDR", ".PCD", ".DXF", ".UFO", ".EPS", ".AI", ".RAW", ".WMF"};
        for (int i = 0; i < list.size(); i++) {
            String suffix = list.get(i).substring(list.get(i).lastIndexOf("."), list.get(i).length());
            if (suffix.equals("")) {
                boolean isTrue = false;
                for (int j = 0; j < format.length; j++) {
                    if (suffix.toUpperCase().equals(format[j])) {
                        isTrue = true;
                    }
                }
                if (!isTrue) {
                    list.remove(i);
                    i--;
                }
            }
        }
        return list;
    }
}
