package Tut9.problem2;

import java.io.*;

public class XFile {
    public static byte[] read(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            int n = fis.available();
            byte[] data = new byte[n];
            fis.read(data);
            return data;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static void write(String path, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static void copy(String srcPath, String destPath) throws IOException {
        byte[] data = read(srcPath);
        write(destPath, data);
    }

    public static void writeObject(String path, Object obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static Object readObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
