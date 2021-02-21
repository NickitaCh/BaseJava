import javax.xml.ws.ResponseWrapper;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
        q = 0;
    }

    int q = 0;
    void save(Resume r) {
        storage[q] = r;
        q++;
    }

    Resume get(String uuid) {
        int i = 0;
        for (; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                break;
            }
        }
        return storage[i];
    }

    void delete(String uuid) {
        for(int i = 0; i < q; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
            }
        }
       for (int j = 0; j < q; j++){
            if (storage[j] == null){
                for (int k = j+1; k < q + 1; k++){
                    storage[k - 1] = storage[k];
                }
                storage[storage.length - 1] = null;
                break;
            }
        }
        q--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, q);
    }

    int size() {
        int a = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null)
            {
                a++;
            }
        }
        return a;
    }
}
