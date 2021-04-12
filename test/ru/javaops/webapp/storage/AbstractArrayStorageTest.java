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
    private static final Resume Resume1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume Resume2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume Resume3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume Resume4 = new Resume(UUID_4);

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(Resume1);
        storage.save(Resume2);
        storage.save(Resume3);
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
        assertEquals(Resume1, allResumes[0]);
        assertEquals(Resume2, allResumes[1]);
        assertEquals(Resume3, allResumes[2]);
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_4));
        checkSize(4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(Resume1);
    }

    @Test(expected = StorageException.class)
    public void storageTooMatch() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
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
        getResume(Resume1);
        getResume(Resume2);
        getResume(Resume3);
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