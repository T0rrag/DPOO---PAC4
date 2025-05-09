package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.exception.DataEntryException;
import edu.uoc.pac4.exception.DataRepositoryException;
import edu.uoc.pac4.exception.ResearchCenterException;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataEntryTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(4, DataEntry.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("id").getModifiers()));
            assertEquals(int.class, DataEntry.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("title").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("title").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("title").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredField("title").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("timestamp").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("timestamp").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("timestamp").getModifiers()));
            assertEquals(LocalDateTime.class, DataEntry.class.getDeclaredField("timestamp").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("observations").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("observations").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("observations").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredField("observations").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, DataEntry.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredConstructor(int.class, String.class, LocalDateTime.class, String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(10, DataEntry.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(int.class, DataEntry.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setId", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setId", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setId", int.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setId", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getTitle").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getTitle").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getTitle").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredMethod("getTitle").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setTitle", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setTitle", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setTitle", String.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setTitle", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getTimestamp").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getTimestamp").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getTimestamp").getModifiers()));
            assertEquals(LocalDateTime.class, DataEntry.class.getDeclaredMethod("getTimestamp").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getObservations").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getObservations").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getObservations").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredMethod("getObservations").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setObservations", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setObservations", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setObservations", String.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setObservations", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertEquals(boolean.class, DataEntry.class.getDeclaredMethod("equals", Object.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testDataEntryValidParameters() {
        try {
            DataEntry dataEntry = new DataEntry(1, "First entry", LocalDateTime.now(), "");

            assertNotNull(dataEntry);
            assertEquals(1, dataEntry.getId());
            assertEquals("First entry", dataEntry.getTitle());
            assertNotNull(dataEntry.getTimestamp());
            assertEquals("", dataEntry.getObservations());

            dataEntry = new DataEntry(2, "Random t1tl3", LocalDateTime.now().minusDays(1), "Some observations");

            assertNotNull(dataEntry);
            assertEquals(2, dataEntry.getId());
            assertEquals("Random t1tl3", dataEntry.getTitle());
            assertNotNull(dataEntry.getTimestamp());
            assertEquals("Some observations", dataEntry.getObservations());
        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Id")
    public void testDataEntryId() {
        AppException exception = assertThrows(DataEntryException.class, () -> new DataEntry(0, "First entry", LocalDateTime.now(), ""));
        assertEquals("[ERROR] ID cannot be negative or zero.", exception.getMessage());

        exception = assertThrows(DataEntryException.class, () -> new DataEntry(-1, "First entry", LocalDateTime.now(), ""));
        assertEquals("[ERROR] ID cannot be negative or zero.", exception.getMessage());

        try {
            DataEntry dataEntry = new DataEntry(1, "First entry", LocalDateTime.now(), "");
            assertEquals(1, dataEntry.getId());

            dataEntry = new DataEntry(2, "First entry", LocalDateTime.now(), "");
            assertEquals(2, dataEntry.getId());

            dataEntry.setId(3);
            assertEquals(3, dataEntry.getId());

            DataEntry finalDataEntry = dataEntry;
            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setId(0));
            assertEquals("[ERROR] ID cannot be negative or zero.", exception.getMessage());

            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setId(-2));
            assertEquals("[ERROR] ID cannot be negative or zero.", exception.getMessage());
        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Title")
    public void testDataEntryTitle() {
        AppException exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, null, LocalDateTime.now(), ""));
        assertEquals("[ERROR] Title cannot be null or blank.", exception.getMessage());

        exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, "", LocalDateTime.now(), ""));
        assertEquals("[ERROR] Title cannot be null or blank.", exception.getMessage());

        exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, " ", LocalDateTime.now(), ""));
        assertEquals("[ERROR] Title cannot be null or blank.", exception.getMessage());

        exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, "     ", LocalDateTime.now(), ""));
        assertEquals("[ERROR] Title cannot be null or blank.", exception.getMessage());

        try {
            DataEntry dataEntry = new DataEntry(1, "First entry", LocalDateTime.now(), "");
            assertEquals("First entry", dataEntry.getTitle());

            dataEntry = new DataEntry(2, "Random t1tl3", LocalDateTime.now(), "");
            assertEquals("Random t1tl3", dataEntry.getTitle());

            dataEntry = new DataEntry(3, " First entry", LocalDateTime.now(), "");
            assertEquals("First entry", dataEntry.getTitle());

            dataEntry = new DataEntry(4, "First entry ", LocalDateTime.now(), "");
            assertEquals("First entry", dataEntry.getTitle());

            dataEntry = new DataEntry(5, "    First entry    ", LocalDateTime.now(), "");
            assertEquals("First entry", dataEntry.getTitle());

            dataEntry.setTitle("New title");
            assertEquals("New title", dataEntry.getTitle());

            DataEntry finalDataEntry = dataEntry;
            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setTitle(null));
            assertEquals("[ERROR] Title cannot be null or blank.", exception.getMessage());

            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setTitle(""));
            assertEquals("[ERROR] Title cannot be null or blank.", exception.getMessage());
        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Timestamp")
    public void testDataEntryTimestamp() {
        AppException exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, "First entry", null, ""));
        assertEquals("[ERROR] Timestamp cannot be null or in the future.", exception.getMessage());

        exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, "First entry", LocalDateTime.now().plusDays(1), ""));
        assertEquals("[ERROR] Timestamp cannot be null or in the future.", exception.getMessage());

        try {
            DataEntry dataEntry = new DataEntry(1, "First entry", LocalDateTime.now(), "");
            assertNotNull(dataEntry.getTimestamp());

            dataEntry = new DataEntry(2, "Random t1tl3", LocalDateTime.now().minusDays(1), "");
            assertNotNull(dataEntry.getTimestamp());

            dataEntry.setTimestamp(LocalDateTime.now());
            assertNotNull(dataEntry.getTimestamp());

            dataEntry.setTimestamp(LocalDateTime.now().minusDays(1));
            assertNotNull(dataEntry.getTimestamp());

            DataEntry finalDataEntry = dataEntry;
            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setTimestamp(null));
            assertEquals("[ERROR] Timestamp cannot be null or in the future.", exception.getMessage());

            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setTimestamp(LocalDateTime.now().plusDays(1)));
            assertEquals("[ERROR] Timestamp cannot be null or in the future.", exception.getMessage());
        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - Observations")
    public void testDataEntryObservations() {
        AppException exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, "First entry", LocalDateTime.now(), null));
        assertEquals("[ERROR] Observations cannot be null.", exception.getMessage());

        try {
            DataEntry dataEntry = new DataEntry(1, "First entry", LocalDateTime.now(), "");
            assertEquals("", dataEntry.getObservations());

            dataEntry = new DataEntry(2, "Random t1tl3", LocalDateTime.now(), "   ");
            assertEquals("", dataEntry.getObservations());

            dataEntry = new DataEntry(3, "Random t1tl3", LocalDateTime.now(), "Some observations");
            assertEquals("Some observations", dataEntry.getObservations());

            dataEntry = new DataEntry(4, "Random t1tl3", LocalDateTime.now(), "   Some observations  ");
            assertEquals("Some observations", dataEntry.getObservations());

            dataEntry = new DataEntry(5, "First entry", LocalDateTime.now(), "Some_oberv@t10ns...");
            assertEquals("Some_oberv@t10ns...", dataEntry.getObservations());

            dataEntry = new DataEntry(6, "First entry", LocalDateTime.now(), " Some_oberv@t10ns...   ");
            assertEquals("Some_oberv@t10ns...", dataEntry.getObservations());

            dataEntry.setObservations("New observations");
            assertEquals("New observations", dataEntry.getObservations());

            dataEntry.setObservations("   New observations   ");
            assertEquals("New observations", dataEntry.getObservations());

            dataEntry.setObservations(" Some_oberv@t10ns...   ");
            assertEquals("Some_oberv@t10ns...", dataEntry.getObservations());

            DataEntry finalDataEntry = dataEntry;
            exception = assertThrows(DataEntryException.class, () -> finalDataEntry.setObservations(null));
            assertEquals("[ERROR] Observations cannot be null.", exception.getMessage());
        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(9)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testDataEntryToString() {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            String expected = "{\"id\":1,\"title\":\"First entry\",\"timestamp\":\"" + localDateTime + "\",\"observations\":\"\"}";
            DataEntry dataEntry = new DataEntry(1, "First entry", localDateTime, "");
            assertEquals(normalize(expected), normalize(dataEntry.toString()));

            localDateTime = LocalDateTime.now().minusDays(1);
            expected = "{\"id\":2,\"title\":\"Random t1tl3\",\"timestamp\":\"" + localDateTime + "\",\"observations\":\"Some observations\"}";
            dataEntry = new DataEntry(2, "Random t1tl3", localDateTime, "Some observations");
            assertEquals(normalize(expected), normalize(dataEntry.toString()));

            localDateTime = LocalDateTime.now().minusYears(1);
            expected = "{\"id\":3,\"title\":\"Random t1tl3\",\"timestamp\":\"" + localDateTime + "\",\"observations\":\"Some observations\"}";
            dataEntry = new DataEntry(3, "    Random t1tl3     ", localDateTime, "    Some observations    ");
            assertEquals(normalize(expected), normalize(dataEntry.toString()));

        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(10)
    @Tag("advanced")
    @DisplayName("Advanced - equals")
    public void testDataEntryEquals() {
        try {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime yesterday = now.minusDays(1);
            DataEntry dataEntry1 = new DataEntry(1, "First entry", now, "");
            DataEntry dataEntry2 = new DataEntry(2, "First entry", now, "");
            assertEquals(dataEntry1, dataEntry2);

            dataEntry2.setTitle("Second entry");
            assertNotEquals(dataEntry1, dataEntry2);

            dataEntry2.setTitle("First entry");
            dataEntry2.setTimestamp(yesterday);
            assertNotEquals(dataEntry1, dataEntry2);

            dataEntry2.setTimestamp(now);
            dataEntry2.setObservations("Some observations");
            assertNotEquals(dataEntry1, dataEntry2);
        } catch (DataEntryException e) {
            fail("DataEntry creation failed: " + e.getMessage());
        }
    }

}
