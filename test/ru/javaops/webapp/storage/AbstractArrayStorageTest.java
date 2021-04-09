package ru.javaops.webapp.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import static org.junit.Assert.assertEquals;

public class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";




    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
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

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_4));
        checkSize(4);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void checkSize(int size) {
        assertEquals(size, storage.size());
    }
}