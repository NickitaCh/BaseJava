package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void addResume(Resume resume, int index) {
        int addIndex = -index;
        System.arraycopy(storage, addIndex - 1, storage, index, numberOfResumes - addIndex - 1);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume key = new Resume(uuid);;
        return Arrays.binarySearch(storage, 0, numberOfResumes, key);
    }
}