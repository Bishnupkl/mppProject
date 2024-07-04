package DataAccess;

import java.io.*;

public class FileDataAccess{

    public Object read(String fileName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(fileName);
            return new ObjectInputStream(file).readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
