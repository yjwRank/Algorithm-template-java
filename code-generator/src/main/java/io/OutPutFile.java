package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yjw on 16-10-28.
 */
public class OutPutFile {

    public static void OUT(String targetPath, Queue<String> list){
        try {
            OutputStream os=new FileOutputStream(targetPath);
            for(String line:list){
                try {
                    os.write((line).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
       Queue<String> list=new LinkedList<String>();
        list.add("{");
        list.add("\n");
        list.add("}");
        OUT("/home/yjw/tmp/test.txt",list);
    }
}
