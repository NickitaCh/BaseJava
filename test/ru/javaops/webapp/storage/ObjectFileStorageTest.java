package ru.javaops.webapp.storage;

public class ObjectFileStorageTest extends AbstractStorageTest{
    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamStorage()));
    }
}
