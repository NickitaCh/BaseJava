package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean existResume(Object key) {
        return key != null;
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void deleteResume(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopy() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
