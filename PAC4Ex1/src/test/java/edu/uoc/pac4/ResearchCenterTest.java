package edu.uoc.pac4;

import edu.uoc.pac4.data.DataEntry;
import edu.uoc.pac4.data.DataRepository;
import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.exception.ResearchCenterException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ResearchCenterTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(6, ResearchCenter.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("city").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("city").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("city").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("city").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("address").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("address").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("address").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("address").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("phoneNumber").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("phoneNumber").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("phoneNumber").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("phoneNumber").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("email").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("email").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("email").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("email").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("dataRepository").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("dataRepository").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("dataRepository").getModifiers()));
            assertEquals(DataRepository.class, ResearchCenter.class.getDeclaredField("dataRepository").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, ResearchCenter.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, DataRepository.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(13, ResearchCenter.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getCity").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getCity").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getCity").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getCity").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setCity", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setCity", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setCity", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setCity", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getAddress").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getAddress").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getAddress").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getAddress").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getEmail").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getEmail").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getEmail").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getEmail").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getDataRepository").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getDataRepository").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getDataRepository").getModifiers()));
            assertEquals(DataRepository.class, ResearchCenter.class.getDeclaredMethod("getDataRepository").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testResearchCenterValidParameters() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Test Data Repository", dataEntries);
            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository);

            assertEquals("Test Research Center", researchCenter.getName());
            assertEquals("Test City", researchCenter.getCity());
            assertEquals("Test Address", researchCenter.getAddress());
            assertEquals("+123456789", researchCenter.getPhoneNumber());
            assertEquals("email@uoc.edu", researchCenter.getEmail());
            assertEquals(dataRepository, researchCenter.getDataRepository());

            researchCenter = new ResearchCenter("Another Research Center", "Another City", "Another Address", "+987654321", "another_email@uoc.edu", dataRepository);

            assertEquals("Another Research Center", researchCenter.getName());
            assertEquals("Another City", researchCenter.getCity());
            assertEquals("Another Address", researchCenter.getAddress());
            assertEquals("+987654321", researchCenter.getPhoneNumber());
            assertEquals("another_email@uoc.edu", researchCenter.getEmail());
            assertEquals(dataRepository, researchCenter.getDataRepository());
        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testResearchCenterName() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Test Data Repository", dataEntries);

            AppException exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter(null, "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter(" ", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("Test Research Center", researchCenter.getName());

            researchCenter = new ResearchCenter(" Another Research Center ", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("Another Research Center", researchCenter.getName());

            ResearchCenter finalResearchCenter = researchCenter;
            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setName(null));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setName(""));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setName(" "));
            assertEquals("[ERROR] Name cannot be null or blank.", exception.getMessage());

            finalResearchCenter.setName("New Research Center");
            assertEquals("New Research Center", finalResearchCenter.getName());

            finalResearchCenter.setName(" Another Research Center ");
            assertEquals("Another Research Center", finalResearchCenter.getName());
        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - City")
    public void testResearchCenterCity() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Test Data Repository", dataEntries);

            AppException exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", null, "Test Address", "+123456789", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] City cannot be null.", exception.getMessage());

            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("", researchCenter.getCity());

            researchCenter = new ResearchCenter("Test Research Center", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("Test City", researchCenter.getCity());

            researchCenter = new ResearchCenter("Test Research Center", " Another City ", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("Another City", researchCenter.getCity());

            ResearchCenter finalResearchCenter = researchCenter;
            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setCity(null));
            assertEquals("[ERROR] City cannot be null.", exception.getMessage());

            finalResearchCenter.setCity("Barcelona");
            assertEquals("Barcelona", finalResearchCenter.getCity());

            finalResearchCenter.setCity(" Another City ");
            assertEquals("Another City", finalResearchCenter.getCity());

            finalResearchCenter.setCity("");
            assertEquals("", finalResearchCenter.getCity());

            finalResearchCenter.setCity(" ");
            assertEquals("", finalResearchCenter.getCity());
        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Address")
    public void testResearchCenterAddress() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Test Data Repository", dataEntries);

            AppException exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", null, "+123456789", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Address cannot be null.", exception.getMessage());

            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("", researchCenter.getAddress());

            researchCenter = new ResearchCenter("Test Research Center", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("Test Address", researchCenter.getAddress());

            researchCenter = new ResearchCenter("Test Research Center", "Test City", " Another Address ", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("Another Address", researchCenter.getAddress());

            ResearchCenter finalResearchCenter = researchCenter;
            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setAddress(null));
            assertEquals("[ERROR] Address cannot be null.", exception.getMessage());

            finalResearchCenter.setAddress("Rambla del Poblenou, 154-156");
            assertEquals("Rambla del Poblenou, 154-156", finalResearchCenter.getAddress());

            finalResearchCenter.setAddress(" Another Address ");
            assertEquals("Another Address", finalResearchCenter.getAddress());

            finalResearchCenter.setAddress("");
            assertEquals("", finalResearchCenter.getAddress());

            finalResearchCenter.setAddress(" ");
            assertEquals("", finalResearchCenter.getAddress());
        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - PhoneNumber")
    public void testResearchCenterPhoneNumber() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);

            AppException exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", "", null, "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", "", "123456", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", "", "+123abc456", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", "", "+123-4567", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", "", "123 456 789", "email@uoc.edu", dataRepository));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "Test City", "", "1234567", "email@uoc.edu", dataRepository);
            assertEquals("1234567", researchCenter.getPhoneNumber());

            researchCenter = new ResearchCenter("Test Research Center", "Test City", "", "+34987654321", "email@uoc.edu", dataRepository);
            assertEquals("+34987654321", researchCenter.getPhoneNumber());

            ResearchCenter finalResearchCenter = researchCenter;
            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setPhoneNumber(null));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setPhoneNumber("12-34567"));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setPhoneNumber("123 456 789"));
            assertEquals("[ERROR] Phone number cannot be null and it must contain a valid format", exception.getMessage());

            finalResearchCenter.setPhoneNumber("7654321");
            assertEquals("7654321", finalResearchCenter.getPhoneNumber());

            finalResearchCenter.setPhoneNumber("+34987654321");
            assertEquals("+34987654321", finalResearchCenter.getPhoneNumber());
        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(9)
    @Tag("minimum")
    @DisplayName("Minimum - Email")
    public void testResearchCenterEmail() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);

            // Constructor - casos inválidos
            AppException exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", null, dataRepository));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "email", dataRepository));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "email@", dataRepository));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "@uoc.edu", dataRepository));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "email@uoc", dataRepository));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "email@.edu", dataRepository));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () ->
                    new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "Email@uoc.edu", dataRepository)); // mayúscula
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals("email@uoc.edu", researchCenter.getEmail());

            researchCenter = new ResearchCenter("Test Research Center", "Test City", "", "+123456789", "user.name-123@another.cat", dataRepository);
            assertEquals("user.name-123@another.cat", researchCenter.getEmail());

            ResearchCenter finalResearchCenter = researchCenter;

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail(null));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail("email"));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail("email@"));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail("@uoc.edu"));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail("email@uoc"));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail("email@.edu"));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            exception = assertThrows(ResearchCenterException.class, () -> finalResearchCenter.setEmail("Email@uoc.edu"));
            assertEquals("[ERROR] Email cannot be null and it must contain a valid format", exception.getMessage());

            finalResearchCenter.setEmail("example_1-2@uoc.edu");
            assertEquals("example_1-2@uoc.edu", finalResearchCenter.getEmail());

            finalResearchCenter.setEmail("a@b.es");
            assertEquals("a@b.es", finalResearchCenter.getEmail());

        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(10)
    @Tag("minimum")
    @DisplayName("Minimum - DataRepository")
    public void testResearchCenterDataRepository() {
        try {
            DataEntry[] dataEntries = new DataEntry[0];
            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);

            AppException exception = assertThrows(ResearchCenterException.class, () -> new ResearchCenter("Test Research Center", "Test City", "Test Address", "+123456789", "email@uoc.edu", null));
            assertEquals("[ERROR] Data repository cannot be null.", exception.getMessage());

            ResearchCenter researchCenter = new ResearchCenter("Test Research Center", "Test City", "Test Address", "+123456789", "email@uoc.edu", dataRepository);
            assertEquals(dataRepository, researchCenter.getDataRepository());

            exception = assertThrows(ResearchCenterException.class, () -> researchCenter.setDataRepository(null));
            assertEquals("[ERROR] Data repository cannot be null.", exception.getMessage());

            DataEntry[] newDataEntries = new DataEntry[0];
            DataRepository newDataRepository = new DataRepository("Repository 2", newDataEntries);
            researchCenter.setDataRepository(newDataRepository);
        } catch (AppException e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(11)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testResearchCenterToString() {
        try {
            DataEntry[] dataEntries = new DataEntry[2];
            dataEntries[0] = new DataEntry(1, "First entry", LocalDateTime.now(), "Note 1");
            dataEntries[1] = new DataEntry(2, "Second entry", LocalDateTime.now().minusDays(1), "Note 2");

            DataRepository dataRepository = new DataRepository("Repository 1", dataEntries);

            ResearchCenter researchCenter = new ResearchCenter(
                    "Research Center 1",
                    "Barcelona",
                    "Av. Diagonal 123",
                    "+34987654321",
                    "info@center.cat",
                    dataRepository
            );

            String expected = "{\"name\":\"Research Center 1\""
                    + ", \"city\":\"Barcelona\""
                    + ", \"address\":\"Av. Diagonal 123\""
                    + ", \"phoneNumber\":\"+34987654321\""
                    + ", \"email\":\"info@center.cat\""
                    + ", \"dataRepository\":"
                    + "{\"name\":\"Repository 1\",\"dataEntries\":["
                    + "{\"id\":1,\"title\":\"First entry\",\"timestamp\":\"" + dataEntries[0].getTimestamp() + "\",\"observations\":\"Note 1\"}"
                    + ",{\"id\":2,\"title\":\"Second entry\",\"timestamp\":\"" + dataEntries[1].getTimestamp() + "\",\"observations\":\"Note 2\"}"
                    + "]}"
                    + "}";

            assertEquals(normalize(expected), normalize(researchCenter.toString()));

        } catch (Exception e) {
            fail("ResearchCenter creation failed: " + e.getMessage());
        }
    }

}
