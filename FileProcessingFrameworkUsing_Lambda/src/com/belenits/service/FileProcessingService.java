package com.belenits.service;

import com.belenits.functional.FileProcessor;
import com.belenits.model.FileData;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FileProcessingService {

    private static final double MAX_FILE_SIZE = 5.0;

    private static final Set<String> ALLOWED_TYPES =
            Set.of("CSV", "JSON", "XML", "TXT");


    public static Consumer<FileData> fileLogger =
            file -> {
                System.out.println("File Name: "
                        + file.getFileName());
            };


    public static BiConsumer<String, String> statusPrinter =
            (status, message) ->
                    System.out.println(status + ": " + message);


    public static Predicate<FileData> fileValidator =
            file ->
                    file != null
                            && file.getFileSizeInMb() != null
                            && file.getFileSizeInMb() < MAX_FILE_SIZE
                            && file.getFileType() != null
                            && ALLOWED_TYPES.contains(
                            file.getFileType().toUpperCase())
                            && file.getContent() != null
                            && !file.getContent().trim().isEmpty()
                            && file.getUploadedBy() != null
                            && !file.getUploadedBy().trim().isEmpty();


    private final Map<String, FileProcessor> processorMap =
            new HashMap<>();

    public FileProcessingService() {

        processorMap.put("CSV",
                file -> {
                    System.out.println(
                            "Processor Selected: CSV Processor");
                    System.out.println(
                            "CSV Records Processed Successfully");
                });

        processorMap.put("JSON",
                file -> {
                    System.out.println(
                            "Processor Selected: JSON Processor");
                    System.out.println(
                            "JSON Data Parsed Successfully");
                });

        processorMap.put("XML",
                file -> {
                    System.out.println(
                            "Processor Selected: XML Processor");
                    System.out.println(
                            "XML Nodes Processed Successfully");
                });

        processorMap.put("TXT",
                file -> {
                    System.out.println(
                            "Processor Selected: TXT Processor");
                    System.out.println(
                            "Text File Processed Successfully");
                });
    }

    public void processFile(FileData fileData) {

        fileLogger.accept(fileData);

        if (!fileValidator.test(fileData)) {

            statusPrinter.accept(
                    "Validation",
                    "FAILED"
            );

            return;
        }

        statusPrinter.accept(
                "Validation",
                "SUCCESS"
        );

        FileProcessor processor =
                processorMap.get(
                        fileData.getFileType().toUpperCase()
                );

        if (processor != null) {
            processor.process(fileData);
        } else {
            System.out.println(
                    "No Processor Available"
            );
        }
    }
}