package fileReadTryWithResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTryWithResource {

    public static void Write(String path){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String line = "";

            while ((line= bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
