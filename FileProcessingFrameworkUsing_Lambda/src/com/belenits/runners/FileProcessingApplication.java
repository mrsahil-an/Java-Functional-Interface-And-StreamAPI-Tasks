package com.belenits.runners;

import com.belenits.model.FileData;
import com.belenits.service.FileProcessingService;

public class FileProcessingApplication {

    public static void main(String[] args) {

        FileProcessingService service =
                new FileProcessingService();

        FileData csvFile =
                new FileData(
                        "students.csv",
                        "CSV",
                        7.5,
                        "101,Rahul\n102,Priya",
                        "Admin"
                );

        FileData jsonFile =
                new FileData(
                        "students.json",
                        "JSON",
                        1.2,
                        "{\"name\":\"Rahul\"}",
                        "Admin"
                );

        FileData xmlFile =
                new FileData(
                        "students.xml",
                        "XML",
                        3.4,
                        "<student><name>Rahul</name></student>",
                        "Admin"
                );

        FileData txtFile =
                new FileData(
                        "notes.txt",
                        "TXT",
                        0.8,
                        "Java Lambda Expressions",
                        "Admin"
                );

        service.processFile(csvFile);

        System.out.println();

        service.processFile(jsonFile);

        System.out.println();

        service.processFile(xmlFile);

        System.out.println();

        service.processFile(txtFile);
    }
}
