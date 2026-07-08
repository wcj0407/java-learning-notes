package IO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zip {
    public static void main(String[] args) throws IOException {
        File src =new File("D:\\zhuomian\\bbb.txt");
        File dest =new File("D:\\zhuomian\\");

        zip1(src,dest);
    }

    private static void zip1(File src, File dest) throws IOException {
        ZipOutputStream zis = new ZipOutputStream(new FileOutputStream(new File(dest,"bbb.zip")));
        ZipEntry entry = new ZipEntry("bbb.txt");
        zis.putNextEntry(entry);
        FileInputStream fis = new FileInputStream(src);
        int b;
        while((b=fis.read())!=-1) {
           zis.write(b);

        }
        fis.close();
        zis.closeEntry();
        zis.close();
    }
}
