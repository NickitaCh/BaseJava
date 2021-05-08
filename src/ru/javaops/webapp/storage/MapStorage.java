package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage{
    private Map<Object, Resume> map = new HashMap<>();

    @Override
    protected Object getKey(String uuid) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        map.put(key, r);
    }

    @Override
    protected boolean existResume(Object key) {
        return map.containsKey(key);
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        map.put(key, r);
    }

    @Override
    protected Resume getResume(Object key) {
        return map.get(key);
    }

    @Override
    protected void deleteResume(Object key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        for (Resume r : map.values()) {
            System.out.println(r);
        }
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }
}
