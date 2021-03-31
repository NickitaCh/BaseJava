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
            System.out.println("Резюме " + resume.getUuid() + " уже есть в базе данных.");
        } else if (numberOfResumes == storage.length) {
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
        System.out.println("Резюме " + uuid + " нет в базе данных.");
        return null;
    }

    public void delete(String uuid) {
        int index = checkResume(uuid);
        if (index != -1) {
            storage[index] = null;
            if (numberOfResumes + 2 - index >= 0)
                System.arraycopy(storage, index + 1, storage, index, numberOfResumes + 2 - index);
            storage[numberOfResumes - 1] = null;
            numberOfResumes--;
        } else
            System.out.println("Резюме " + uuid + " нет в базе данных.");
    }

    public void update(Resume resume) {
        int index = checkResume(resume.getUuid());
        if (index == -1) {
            System.out.println("Резюме " + resume.getUuid() + " нет в базе данных.");
        } else
            storage[index] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, numberOfResumes);
    }

    public int size() {
        return numberOfResumes;
    }
}
