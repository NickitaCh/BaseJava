package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void addResume(Resume resume, int index) {
        int addIndex = -index - 1;
        System.arraycopy(storage, addIndex, storage, addIndex + 1, numberOfResumes - addIndex);
        storage[addIndex] = resume;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume key = new Resume(uuid);;
        return Arrays.binarySearch(storage, 0, numberOfResumes, key);
    }
}