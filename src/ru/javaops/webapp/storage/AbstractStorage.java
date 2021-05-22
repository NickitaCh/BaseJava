package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK>  implements Storage{

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getKey(String uuid);

    protected abstract void updateResume(Resume r, SK key);

    protected abstract boolean existResume(SK key);

    protected abstract void saveResume(Resume r, SK key);

    protected abstract Resume getResume(SK key);

    protected abstract void deleteResume(SK key);

    protected abstract List<Resume> doCopy();

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK key = getExistedKey(r.getUuid());
        updateResume(r, key);
    }

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK key = getNotExistedKey(r.getUuid());
        saveResume(r, key);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK key = getExistedKey(uuid);
        deleteResume(key);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK key = getExistedKey(uuid);
        return getResume(key);
    }

    private SK getExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (!existResume(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (existResume(key)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopy();
        Collections.sort(list);
        return list;
    }
}