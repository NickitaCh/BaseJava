package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

public abstract class AbstractStorage  implements Storage{

    protected abstract Object getKey(String uuid);

    protected abstract void updateResume(Resume r, Object key);

    protected abstract boolean existResume(Object key);

    protected abstract void saveResume(Resume r, Object key);

    protected abstract Resume getResume(Object key);

    protected abstract void deleteResume(Object key);

    public void update(Resume r) {
        Object key = getExistedKey(r.getUuid());
        updateResume(r, key);
    }

    public void save(Resume r) {
        Object key = getNotExistedKey(r.getUuid());
        saveResume(r, key);
    }

    public void delete(String uuid) {
        Object key = getExistedKey(uuid);
        deleteResume(key);
    }

    public Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return getResume(key);
    }

    private Object getExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (!existResume(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (existResume(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}
