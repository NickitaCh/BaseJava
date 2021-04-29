package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

public abstract class AbstractStorage  implements Storage{

    protected abstract Object getKey(String uuid);

    protected abstract void resumeUpdate(Resume r, Object key);

    protected abstract boolean resumeExist(Object key);

    protected abstract void resumeSave(Resume r, Object key);

    protected abstract Resume resumeGet(Object key);

    protected abstract void resumeDelete(Object key);

    public void update(Resume r) {
        Object key = getExistedKey(r.getUuid());
        resumeUpdate(r, key);
    }

    public void save(Resume r) {
        Object key = getNotExistedKey(r.getUuid());
        resumeSave(r, key);
    }

    public void delete(String uuid) {
        Object key = getExistedKey(uuid);
        resumeDelete(key);
    }

    public Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return resumeGet(key);
    }
    private Object getExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (!resumeExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (resumeExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}
