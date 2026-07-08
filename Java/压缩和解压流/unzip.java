package IO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class unzip {
    public static void main(String[] args) throws IOException {
        // 压缩包文件对象：D桌面的aaa.zip
        File src = new File("D:\\zhuomian\\aaa.zip");
        // 解压存放目录
        File dest = new File ("D:\\zhuomian\\aaa");
        //调用方法
        Unzip(src,dest);

    }
    public static void Unzip(File src, File dest) throws IOException {
        // 1. 创建zip输入流，打开压缩包读取内容
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if(entry.isDirectory()) {
                File file = new File(dest, entry.toString());
                file.mkdirs();
            } else {
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int len;
                byte[] buffer = new byte[1024];
                while ((len = zis.read(buffer)) !=-1) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zis.closeEntry();
            }


        }
        zis.close();

    }
}
