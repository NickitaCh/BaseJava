package ru.javaops.webapp.storage;

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
            System.out.println("Резюме " + resume.getUuid() + " нет в базе данных.");
        } else
            storage[index] = resume;
    }

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index != -1) {
            System.out.println("Резюме " + resume.getUuid() + " уже есть в базе данных.");
        } else if (numberOfResumes == storage.length) {
            System.out.println("База данных заполнена.");
        } else {
            addResume(resume, index);
            numberOfResumes++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
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
            System.out.println("Резюме " + uuid + " нет в базе данных.");
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