package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addResume(Resume resume, int index) {
        storage[numberOfResumes] = resume;
    }

    protected Integer getKey(String uuid) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
