package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int numberOfResumes = 0;

    public void clear() {
        Arrays.fill(storage, 0, numberOfResumes, null);
        numberOfResumes = 0;
    }

    public void updateResume(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    public void saveResume(Resume resume, Object index) {
        if (numberOfResumes == STORAGE_LIMIT) {
            throw new StorageException("База данных заполнена.", resume.getUuid());
        } else {
            addResume(resume, (Integer) index);
            numberOfResumes++;
        }
    }

    public Resume getResume(Object index) {
        return storage[(Integer) index];
    }

    public void deleteResume(Object index) {
        System.arraycopy(storage, (Integer) index + 1, storage, (Integer) index, numberOfResumes - (Integer) index - 1);
        storage[numberOfResumes - 1] = null;
        numberOfResumes--;
    }

    public boolean existResume(Object index) {
        return (Integer) index >= 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, numberOfResumes);
    }

    public int size() {
        return numberOfResumes;
    }

    protected abstract void addResume(Resume resume, int index);

    protected abstract Integer getKey(String uuid);
}