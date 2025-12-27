package com.filemanager;

public class StoredFile {
    private final String fileName;
    private final byte[] data;

    public StoredFile(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() { return fileName; }
    public byte[] getData() { return data; }
}