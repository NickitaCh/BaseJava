package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int numberOfResumes = 0;
    private int numberOfResume = 0;

    public void clear() {
        Arrays.fill(storage, 0, numberOfResumes, null);
        numberOfResumes = 0;
    }

    public void save(Resume resume) {
        if (saveCheck(resume) && fullStorageCheck()) {
            storage[numberOfResumes] = resume;
            numberOfResumes++;
        }
    }

    private boolean saveCheck(Resume resume) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (resume.getUuid().equals(storage[i].getUuid())) {
                System.out.println("Данное резюме уже находится в базе данных.");
                return false;
            }
        }
        return true;
    }

    private boolean fullStorageCheck() {
        if (numberOfResumes == 10_000) {
            System.out.println("База данных заполнена.");
            return false;
        }
        return true;
    }

    public Resume get(String uuid) {
        if (resumeCheck(uuid)) {
            return storage[numberOfResume];
        }
        return null;
    }

    private boolean resumeCheck(String uuid) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                numberOfResume = i;
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
            storage[numberOfResume] = null;
            for (int k = numberOfResume + 1; k < numberOfResumes + 1; k++) {
                storage[k - 1] = storage[k];
            }
            storage[numberOfResumes - 1] = null;
            numberOfResumes--;
        }
    }

    public void update(Resume resume) {
        if (resumeCheck(resume.getUuid())) {
            storage[numberOfResume].setUuid(resume.getUuid());
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
