package DataAccess;

import java.io.*;

public class FileDataAccess{

    protected Object read(String fileName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(fileName);
            return new ObjectInputStream(file).readObject();
        } catch (FileNotFoundException e) {
            return null;
//            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (file != null) file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void write(String fileName, Object obj) {
        FileOutputStream file = null;
        ObjectOutputStream out = null;
        try {
            file = new FileOutputStream(fileName);
            out = new ObjectOutputStream(file);
            out.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (out != null) out.close();
                if (file != null) file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
