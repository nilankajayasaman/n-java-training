package fileWriterTryWithResource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTryWithResource {

    public static void Write(String path){

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){

            int i = 0;

            while (i<=10){
                i++;
                bufferedWriter.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
