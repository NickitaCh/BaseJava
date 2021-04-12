package ru.javaops.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import static org.junit.Assert.assertEquals;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume resume1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume resume2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume resume3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() throws Exception {
        checkSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        checkSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_3);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] allResumes = storage.getAll();
        assertEquals(resume1, allResumes[0]);
        assertEquals(resume2, allResumes[1]);
        assertEquals(resume3, allResumes[2]);
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_4));
        checkSize(4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(resume1);
    }

    @Test(expected = StorageException.class)
    public void saveToStorageOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Хранилище переполнилось раньше времени!");
        }
        storage.save(new Resume());
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_1);
        checkSize(2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void get() throws Exception {
        getResume(resume1);
        getResume(resume2);
        getResume(resume3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void checkSize(int size) {
        assertEquals(size, storage.size());
    }

    private void getResume(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}