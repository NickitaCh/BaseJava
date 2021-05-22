package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK>  implements Storage{

    protected abstract SK getKey(String uuid);

    protected abstract void updateResume(Resume r, SK key);

    protected abstract boolean existResume(SK key);

    protected abstract void saveResume(Resume r, SK key);

    protected abstract Resume getResume(SK key);

    protected abstract void deleteResume(SK key);

    protected abstract List<Resume> doCopy();

    public void update(Resume r) {
        SK key = getExistedKey(r.getUuid());
        updateResume(r, key);
    }

    public void save(Resume r) {
        SK key = getNotExistedKey(r.getUuid());
        saveResume(r, key);
    }

    public void delete(String uuid) {
        SK key = getExistedKey(uuid);
        deleteResume(key);
    }

    public Resume get(String uuid) {
        SK key = getExistedKey(uuid);
        return getResume(key);
    }

    private SK getExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (!existResume(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (existResume(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopy();
        Collections.sort(list);
        return list;
    }
}