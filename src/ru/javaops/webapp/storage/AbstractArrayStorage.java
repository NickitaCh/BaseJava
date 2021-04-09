package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int numberOfResumes = 0;

    public void clear() {
        Arrays.fill(storage, 0, numberOfResumes, null);
        numberOfResumes = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(resume.getUuid());
        } else
            storage[index] = resume;
    }

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index != -1) {
            throw new ExistStorageException(resume.getUuid());
        } else if (numberOfResumes == storage.length) {
            throw new StorageException("База данных заполнена.", resume.getUuid());
        } else {
            addResume(resume, index);
            numberOfResumes++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            storage[index] = null;
            System.arraycopy(storage, index + 1, storage, index, numberOfResumes - index - 1);
            storage[numberOfResumes - 1] = null;
            numberOfResumes--;
        } else
            throw new NotExistStorageException(uuid);
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, numberOfResumes);
    }

    public int size() {
        return numberOfResumes;
    }

    protected abstract void addResume(Resume resume, int index);

    protected abstract int findIndex(String uuid);
}