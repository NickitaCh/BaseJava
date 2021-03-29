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

    public void save(Resume resume) {
        if (checkResume(resume.getUuid()) != -1) {
            System.out.println("Данное резюме уже находится в базе данных.");
        } else if (numberOfResumes == 10_000) {
            System.out.println("База данных заполнена.");
        } else {
            storage[numberOfResumes] = resume;
            numberOfResumes++;
        }
    }

    private int checkResume(String uuid) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public Resume get(String uuid) {
        int index = checkResume(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Данного резюме нет в базе данных.");
        return null;
    }

    public void delete(String uuid) {
        int index = checkResume(uuid);
        if (index != -1) {
            storage[index] = null;
            for (int k = index + 1; k < numberOfResumes + 1; k++) {
                storage[k - 1] = storage[k];
            }
            storage[numberOfResumes - 1] = null;
            numberOfResumes--;
        } else
            System.out.println("Данного резюме нет в базе данных.");
    }

    public void update(Resume resume) {
        int index = checkResume(resume.getUuid());
        if (checkResume(resume.getUuid()) == -1) {
            System.out.println("Данного резюме нет в базе данных.");
        } else
            storage[index].setUuid(resume.getUuid());
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
