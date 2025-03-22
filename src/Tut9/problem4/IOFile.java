package Tut9.problem4;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class IOFile {
    private String fileName;
    public IOFile(String fileName) {
        this.fileName = fileName;
    }
    public int countLine() throws IOException {
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while(reader.readLine() != null){
                count++;
            }
            return count;
        }catch(IOException e){
            throw new IOException(e);
        }

    }
    public void write(String content) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))){
            writer.write(content);
            writer.newLine();
        }catch(IOException e){
            throw new IOException(e);
        }
    }
    public void print() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            throw new IOException(e);
        }
    }
    public  void copy(String fileNameCopy) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameCopy,true))){

            String line;
            while((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
        }catch(IOException e){
            throw new IOException(e);
        }
    }
    public void delete() throws IOException {
        try {
            File file = new File(this.fileName);

            if (file.exists()) {
                if (!file.delete()) {
                    System.out.println("Failed to delete the file.");
                }
                else{
                    System.out.println("File deleted successfully.");
                }
            } else {
                System.out.println("File does not exist.");
            }
        }catch(Exception e){
            throw new IOException(e);
        }
    }

}
