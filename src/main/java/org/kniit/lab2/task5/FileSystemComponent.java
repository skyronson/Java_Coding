package org.kniit.lab2.task5;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemComponent {
    protected String name;
    
    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Операция добавления не поддерживается");
    }
    
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Операция удаления не поддерживается");
    }
    public abstract void display(String indent);
}


class File extends FileSystemComponent {
    int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

        @Override
    public void display(String indent) {
        System.out.println(indent + name + " (" + size + " bytes)");
    }
}


class Folder extends FileSystemComponent {
    private List<FileSystemComponent> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
    
    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }
    
    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }
    
    @Override
    public void display(String indent) {
        System.out.println(indent + name);
        String newIndent = indent + "  ";
        for (FileSystemComponent component : children) {
            component.display(newIndent);
        }
    }
}