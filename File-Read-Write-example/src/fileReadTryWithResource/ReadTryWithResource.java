package fileReadTryWithResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTryWithResource {

    public static void Write(String path){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
