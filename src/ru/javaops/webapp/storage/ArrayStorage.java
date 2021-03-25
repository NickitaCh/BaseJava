package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int numberOfResumes = 0;

    public void clear() {
        Arrays.fill(storage, 0, numberOfResumes, null);
        numberOfResumes = 0;
    }

    public void save(Resume r) {
        if (saveCheck(r) && fullStorageCheck()) {
            storage[numberOfResumes] = r;
            numberOfResumes++;
        }
    }

    private boolean saveCheck(Resume r) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (r.uuid.equals(storage[i].uuid)) {
                System.out.println("Данное резюме уже находится в базе данных.");
                return false;
            }
        }
        return true;
    }

    private boolean fullStorageCheck() {
        if (numberOfResumes == 10000) {
            System.out.println("База данных заполнена.");
            return false;
        }
        return true;
    }

    public Resume get(String uuid) {
        if (resumeCheck(uuid)) {
            for (int i = 0; i < numberOfResumes; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    int i = 0;

    private boolean resumeCheck(String uuid) {
        for (i = 0; i < numberOfResumes; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return true;
            }
            if (i + 1 == numberOfResumes) {
                System.out.println("Данного резюме нет в базе данных.");
            }
        }
        return false;
    }

    public void delete(String uuid) {
        if (resumeCheck(uuid)) {
            for (int i = 0; i < numberOfResumes; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    for (int k = i + 1; k < numberOfResumes + 1; k++) {
                        storage[k - 1] = storage[k];
                    }
                    storage[numberOfResumes - 1] = null;
                    numberOfResumes--;
                    break;
                }
            }
        }
    }

    public void update(Resume resume) {
        if (resumeCheck(resume.uuid)) {
            storage[i].uuid = resume.uuid;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, numberOfResumes);
    }

    public int size() {
        return numberOfResumes;
    }
}
