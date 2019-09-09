import fileReadTryWithResource.ReadTryWithResource;
import fileReader.ReadFromFile;
import fileWriter.WriteToFile;
import fileWriterTryWithResource.WriteTryWithResource;

public class Application {


    public static void main(String[] args) {
        String path = "/home/user/Nilanka/n-java-training/file.txt";
        String path1 = "/home/user/Nilanka/n-java-training/fileTryWithResource.txt";
        WriteFile(path);
        ReadFile(path);
        WriteTryWithResource(path1);
        ReadTryWithResource(path1);

    }


    public static void ReadFile(String path){

        ReadFromFile.Read(path);


    }


    public static void WriteFile(String path){

        WriteToFile.Write(path);

    }

    public static void ReadTryWithResource(String path){

        ReadTryWithResource.Write(path);

    }

    public static void WriteTryWithResource(String path){

        WriteTryWithResource.Write(path);

    }

}
