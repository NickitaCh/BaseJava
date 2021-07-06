package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private Serializer serializer;

    protected PathStorage(String dir, Serializer serializer) {
        Objects.requireNonNull(dir, "directory must not be null");
        this.serializer = serializer;
        directory = Paths.get(dir);
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
    protected Path getKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void updateResume(Resume r, Path path) {
        try {
            serializer.writeResume(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean existResume(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void saveResume(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("IO error", getFileName(path), e);
        }
        updateResume(r, path);
    }

    @Override
    protected Resume getResume(Path path) {
        try {
            return serializer.readResume(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Read error", getFileName(path), e);
        }
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFileName(path), e);
        }
    }

    @Override
    protected List<Resume> doCopy() {
        return getFilesList().map(this::getResume).collect(Collectors.toList());
    }

    @Override
    public void clear() {
        getFilesList().forEach(this::deleteResume);
    }

    @Override
    public int size() {
        return (int) getFilesList().count();
    }

    private String getFileName(Path path) {
        return path.getFileName().toString();
    }

    private Stream<Path> getFilesList() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
    }
}
