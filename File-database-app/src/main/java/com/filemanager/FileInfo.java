package com.filemanager;

public class FileInfo {
    private final int id;
    private final String fileName;

    public FileInfo(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public int getId() { return id; }
    public String getFileName() { return fileName; }

    @Override
    public String toString() {
        return "ID: " + id + " | Имя: " + fileName;
    }
}