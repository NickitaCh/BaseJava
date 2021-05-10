package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage  extends  AbstractStorage{
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Object getKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        list.set((Integer) key, r);
    }

    @Override
    protected boolean existResume(Object key) {
        return key != null;
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        list.add(r);
    }

    @Override
    protected Resume getResume(Object key) {
        return list.get((Integer) key);
    }

    @Override
    protected void deleteResume(Object key) {
        list.remove(((Integer) key).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return list.size();
    }
}