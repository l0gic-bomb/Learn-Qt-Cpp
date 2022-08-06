package com.example.practicefragment.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContentReaderJson {
    private static ContentReaderJson readerJson;
    private String pathToFile;
    private String dataFromFile;

    //! singelton
    public static ContentReaderJson getReaderJson()
    {
        if (readerJson == null) {
            readerJson = new ContentReaderJson();
        }
        return readerJson;
    }

    //! setterPath
    public void setToPath(String path)
    {
        pathToFile = path;
        getDataFromFile();
    }

    //! get all data from file
    private void getDataFromFile()
    {
        File file = new File(pathToFile);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                dataFromFile += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //! get array from our file
    public String[] getStringArray(String key)
    {
        if (dataFromFile == null || key == null)
            return null;

        String[] array = new String[1];
        return array;
    }




}
