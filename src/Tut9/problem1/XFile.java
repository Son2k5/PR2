package Tut9.problem1;
import java.io.*;

public class XFile {
    public static byte[] read(String filename) throws IOException {
        try{
            FileInputStream fis = new FileInputStream(filename);
            int n = fis.available();
            byte[] data = new byte[n];
            fis.read(data);
            fis.close();
            return data;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void write(String path, byte[] data) throws IOException {
        try{
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data);
            fos.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void copy( String srcPath, String destPath) throws IOException {
        byte[] data = read(srcPath);
        write (destPath, data);
    }

}
