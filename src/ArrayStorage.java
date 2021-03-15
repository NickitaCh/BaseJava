import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int numberOfResumes = 0;

    void clear() {
        for (int i = 0; i < numberOfResumes; i++) {
            storage[i] = null;
        }
        numberOfResumes = 0;
    }

    void save(Resume r) {
        storage[numberOfResumes] = r;
        numberOfResumes++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < numberOfResumes; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                for (int k = i + 1; k < numberOfResumes + 1; k++) {
                    storage[k - 1] = storage[k];
                }
                storage[numberOfResumes - 1] = null;
                numberOfResumes--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, numberOfResumes);
    }

    int size() {
        return numberOfResumes;
    }
}
