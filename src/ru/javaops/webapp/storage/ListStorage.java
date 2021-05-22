package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void updateResume(Resume r, Integer key) {
        list.set(key, r);
    }

    @Override
    protected boolean existResume(Integer key) {
        return key != null;
    }

    @Override
    protected void saveResume(Resume r, Integer key) {
        list.add(r);
    }

    @Override
    protected Resume getResume(Integer key) {
        return list.get(key);
    }

    @Override
    protected void deleteResume(Integer key) {
        list.remove(key.intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> doCopy() {
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }
}