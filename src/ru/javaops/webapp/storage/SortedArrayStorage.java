package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void addResume(Resume resume, int index) {
        int addIndex = -index - 1;
        System.arraycopy(storage, addIndex, storage, addIndex + 1, numberOfResumes - addIndex);
        storage[addIndex] = resume;
    }

    @Override
    protected Integer getKey(String uuid) {
        Resume key = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, numberOfResumes, key, RESUME_COMPARATOR);
    }
}