package com.filemanager;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;


public class FileDAO {
    private static final String INSERT_FILE = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT id, file_name FROM files ORDER BY id";
    private static final String SELECT_BY_ID = "SELECT file_name, file_binary FROM files WHERE id = ?";


    public void saveFile(File file) throws SQLException, IOException {
        if (file.length() == 0) {
            throw new IllegalArgumentException("Пустой файл: " + file.getName());
        }
        if (file.length() > 10 * 1024 * 1024) {
            throw new IllegalArgumentException("Файл слишком большой: " + file.getName());
        }

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO files (file_name, file_binary) VALUES (?, ?)")) {

            ps.setString(1, file.getName());
            byte[] data = Files.readAllBytes(file.toPath());
            ps.setBytes(2, data);
            ps.executeUpdate();
        }
    }

    public List<FileInfo> listFiles() throws SQLException {
        List<FileInfo> files = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                files.add(new FileInfo(rs.getInt("id"), rs.getString("file_name")));
            }
        }
        return files;
    }

    public StoredFile getFileById(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new StoredFile(rs.getString("file_name"), rs.getBytes("file_binary"));
                }
                return null;
            }
        }
    }
}