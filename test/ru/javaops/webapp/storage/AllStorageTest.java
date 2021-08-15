package ru.javaops.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                StorageTest.class,
                SortedStorageTest.class,
                ListStorageTest.class,
                MapStorageTest.class,
                NewMapStorageTest.class,
                ObjectPathStorageTest.class,
                ObjectFileStorageTest.class,
                XmlPathStorageTest.class,
                JsonPathStorageTest.class,
                DataPathStorageTest.class,
                SqlStorageTest.class
        })
public class AllStorageTest {
}
