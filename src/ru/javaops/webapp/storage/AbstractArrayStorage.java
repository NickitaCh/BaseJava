package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int numberOfResumes = 0;

    public void clear() {
        Arrays.fill(storage, 0, numberOfResumes, null);
        numberOfResumes = 0;
    }

    public void updateResume(Resume resume, Integer index) {
        storage[index] = resume;
    }

    public void saveResume(Resume resume, Integer index) {
        if (numberOfResumes == STORAGE_LIMIT) {
            throw new StorageException("База данных заполнена.", resume.getUuid());
        } else {
            addResume(resume, index);
            numberOfResumes++;
        }
    }

    public Resume getResume(Integer index) {
        return storage[index];
    }

    public void deleteResume(Integer index) {
        System.arraycopy(storage, index + 1, storage, index, numberOfResumes - index - 1);
        storage[numberOfResumes - 1] = null;
        numberOfResumes--;
    }

    public boolean existResume(Integer index) {
        return index >= 0;
    }

    public List<Resume> doCopy() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, numberOfResumes));
    }

    public int size() {
        return numberOfResumes;
    }

    protected abstract void addResume(Resume resume, int index);

    protected abstract Integer getKey(String uuid);
}