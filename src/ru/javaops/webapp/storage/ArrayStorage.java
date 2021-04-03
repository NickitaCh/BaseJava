package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

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
        if (findIndex(resume.getUuid()) != -1) {
            System.out.println("Резюме " + resume.getUuid() + " уже есть в базе данных.");
        } else if (numberOfResumes == storage.length) {
            System.out.println("База данных заполнена.");
        } else {
            storage[numberOfResumes] = resume;
            numberOfResumes++;
        }
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

    protected int findIndex(String uuid) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, numberOfResumes);
    }
}
