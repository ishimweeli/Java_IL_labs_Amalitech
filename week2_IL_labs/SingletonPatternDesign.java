package com.personalExercises;

import com.sun.source.tree.SynchronizedTree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingletonPatternDesign {

    public static class FileLogger{
private static FileLogger instance;
private PrintWriter writer;

private FileLogger(){
    try {
        writer=new PrintWriter( new FileWriter("log.text",true),true);
    }catch (IOException e){
e.printStackTrace();
    }
}
public  static synchronized FileLogger getInstance() {

    if(instance==null){
        instance=new FileLogger();
    }
            return instance;
        }

        public void log(String message){
    writer.println(message);
        }

        public void close(){
    writer.close();
        }
    }

    public static void main(String[] args) {
        FileLogger logger=FileLogger.getInstance();
        logger.log("hello world");
    }

}
