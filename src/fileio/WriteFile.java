package fileio;

import java.io.*;
import java.util.List;

public class WriteFile<T> {
    public void writeToFile(List<T> t) {
        File file = new File("student.csv");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(t);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}