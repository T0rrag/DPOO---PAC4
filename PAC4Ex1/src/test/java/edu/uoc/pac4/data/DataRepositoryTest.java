package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.exception.DataRepositoryException;
import org.junit.jupiter.api.*;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataRepositoryTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(2, DataRepository.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(DataRepository.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, DataRepository.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(DataRepository.class.getDeclaredField("dataEntries").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredField("dataEntries").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredField("dataEntries").getModifiers()));
            assertEquals(HashMap.class, DataRepository.class.getDeclaredField("dataEntries").getType());
            ParameterizedType t = (ParameterizedType) DataRepository.class.getDeclaredField("dataEntries").getGenericType();
            assertEquals(Integer.class, t.getActualTypeArguments()[0]);
            assertEquals(DataEntry.class, t.getActualTypeArguments()[1]);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, DataRepository.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredConstructor(String.class, DataEntry[].class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(5, DataRepository.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, DataRepository.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, DataRepository.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getModifiers()));
            assertEquals(void.class, DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getModifiers()));
            assertEquals(DataEntry.class, DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, DataRepository.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testDataRepositoryValidParameters() {
        DataEntry[] dataEntries = new DataEntry[6];
        DataRepository dataRepository = null;

        try {
            for (int i = 0; i < dataEntries.length; i++) {
                dataEntries[i] = new DataEntry(i+1, "Title " + i, LocalDateTime.now(), "");
            }

            dataRepository = new DataRepository("Repository 1", dataEntries);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the insertion of data entries: " + e.getMessage());
        }

        assertNotNull(dataRepository);
        assertEquals("Repository 1", dataRepository.getName());

        for (int i = 0; i < dataEntries.length; i++) {
            try {
                assertEquals(dataEntries[i], dataRepository.getDataEntry(i+1));
            } catch (DataRepositoryException e) {
                fail("[ERROR] There is some problem with the insertion of data entries: " + e.getMessage());
            }
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testDataRepositoryName() {
        DataEntry[] dataEntries = new DataEntry[0];
        AppException exception = assertThrows(DataRepositoryException.class, () -> new DataRepository(null, dataEntries));
        assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

        exception = assertThrows(DataRepositoryException.class, () -> new DataRepository("", dataEntries));
        assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

        exception = assertThrows(DataRepositoryException.class, () -> new DataRepository("  ", dataEntries));
        assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

        try {

            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);
            assertEquals("Repository 1", dataRepository.getName());

            dataRepository = new DataRepository(" a ", dataEntries);
            assertEquals("a", dataRepository.getName());

            DataRepository finalDataRepository = dataRepository;
            exception = assertThrows(DataRepositoryException.class, () -> finalDataRepository.setName(null));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            exception = assertThrows(DataRepositoryException.class, () -> finalDataRepository.setName(""));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            exception = assertThrows(DataRepositoryException.class, () -> finalDataRepository.setName("  "));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());
        } catch (Exception e) {
            fail("DataRepository creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - dataEntries")
    public void testDataRepositoryDataEntries() {
        DataEntry[] dataEntries = new DataEntry[5];

        try {
            for (int i = 0; i < dataEntries.length; i++) {
                dataEntries[i] = new DataEntry(i+1, "Title " + i, LocalDateTime.now().minusDays(i), "Observations " + i);
            }

            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);

            for (int i = 0; i < dataEntries.length; i++) {
                assertEquals(dataEntries[i], dataRepository.getDataEntry(i+1));
            }

            DataEntry newDataEntry = new DataEntry(6, "Title 6", LocalDateTime.now(), "Observations 6");
            dataRepository.addDataEntry(newDataEntry);
            assertEquals(newDataEntry, dataRepository.getDataEntry(6));

            DataEntry duplicateDataEntry = new DataEntry(6, "Title 6", LocalDateTime.now(), "Observations 6");
            AppException exception = assertThrows(DataRepositoryException.class, () -> dataRepository.addDataEntry(duplicateDataEntry));
            assertEquals("[ERROR] Data entry with this ID already exists.", exception.getMessage());

            exception = assertThrows(DataRepositoryException.class, () -> dataRepository.addDataEntry(null));
            assertEquals("[ERROR] Data entry cannot be null.", exception.getMessage());

            exception = assertThrows(DataRepositoryException.class, () -> dataRepository.getDataEntry(100));
            assertEquals("[ERROR] Data entry not found.", exception.getMessage());

            exception = assertThrows(DataRepositoryException.class, () -> dataRepository.getDataEntry(-1));
            assertEquals("[ERROR] Data entry not found.", exception.getMessage());

            exception = assertThrows(DataRepositoryException.class, () -> dataRepository.getDataEntry(0));
            assertEquals("[ERROR] Data entry not found.", exception.getMessage());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the insertion of data entries: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testDataRepositoryToString() {
        DataEntry[] dataEntries = new DataEntry[5];

        try {
            for (int i = 0; i < dataEntries.length; i++) {
                dataEntries[i] = new DataEntry(i+1, "Title " + i, LocalDateTime.now().minusDays(i), "Observations " + i);
            }

            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);
            String expectedString = "{\"name\":\"Repository 1\",\"dataEntries\":[" +
                    "{\"id\":1,\"title\":\"Title 0\",\"timestamp\":\"" + dataEntries[0].getTimestamp() + "\",\"observations\":\"Observations 0\"}" +
                    ",{\"id\":2,\"title\":\"Title 1\",\"timestamp\":\"" + dataEntries[1].getTimestamp() + "\",\"observations\":\"Observations 1\"}" +
                    ",{\"id\":3,\"title\":\"Title 2\",\"timestamp\":\"" + dataEntries[2].getTimestamp() + "\",\"observations\":\"Observations 2\"}" +
                    ",{\"id\":4,\"title\":\"Title 3\",\"timestamp\":\"" + dataEntries[3].getTimestamp() + "\",\"observations\":\"Observations 3\"}" +
                    ",{\"id\":5,\"title\":\"Title 4\",\"timestamp\":\"" + dataEntries[4].getTimestamp() + "\",\"observations\":\"Observations 4\"}" +
                    "]}";
            String actualString = dataRepository.toString();
            assertEquals(normalize(expectedString), normalize(actualString));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the insertion of data entries: " + e.getMessage());
        }
    }

}
