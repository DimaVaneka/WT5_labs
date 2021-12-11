package by.bsuir.DimaVaneka.server.dao;


import by.bsuir.DimaVaneka.entity.StudentCard;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

/**
 * Created by dima on 11/11/2021.
 */
public class FileDao {

    private static final String filename = "archive.xml";

    public static synchronized List<StudentCard> loadArchive(){

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
            List<StudentCard> archive = (List<StudentCard>)decoder.readObject();
            decoder.close();
            return  archive;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized void saveArchive(List<StudentCard> archive){
        try {
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
            e.writeObject(archive);
            e.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
