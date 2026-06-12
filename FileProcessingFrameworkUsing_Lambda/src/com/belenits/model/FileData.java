package com.belenits.model;

public class FileData {

    private String fileName;
    private String fileType;
    private Double fileSizeInMb;
    private String content;
    private String uploadedBy;

    public FileData(String fileName, String fileType, Double fileSizeInMb, String content, String uploadedBy) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSizeInMb = fileSizeInMb;
        this.content = content;
        this.uploadedBy = uploadedBy;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Double getFileSizeInMb() {
        return fileSizeInMb;
    }

    public void setFileSizeInMb(Double fileSizeInMb) {
        this.fileSizeInMb = fileSizeInMb;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
