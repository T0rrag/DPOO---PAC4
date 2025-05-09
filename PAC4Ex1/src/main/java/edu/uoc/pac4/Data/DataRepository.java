package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataRepositoryException;
import java.util.HashMap;

public class DataRepository {
    private String name;
    private HashMap<Integer, DataEntry> dataEntries;

    public DataRepository(String name, DataEntry[] dataEntries) throws DataRepositoryException {
        setName(name);
        this.dataEntries = new HashMap<>();
        if (dataEntries != null) {
            for (DataEntry entry : dataEntries) {
                addDataEntry(entry);
            }
        }
    }

    public void setName(String name) throws DataRepositoryException {
        if (name == null || name.trim().isEmpty()) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_NAME);
        }
        this.name = name.trim();
    }

    public void addDataEntry(DataEntry dataEntry) throws DataRepositoryException {
        if (dataEntry == null) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_NULL);
        }
        if (dataEntries.containsKey(dataEntry.getId())) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_EXISTS);
        }
        dataEntries.put(dataEntry.getId(), dataEntry);
    }

    public DataEntry getDataEntry(int id) throws DataRepositoryException {
        DataEntry entry = dataEntries.get(id);
        if (entry == null) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_NOT_FOUND);
        }
        return entry;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        StringBuilder entriesJson = new StringBuilder("[");
        boolean first = true;
        for (DataEntry entry : dataEntries.values()) {
            if (!first) {
                entriesJson.append(",");
            }
            entriesJson.append(entry.toString());
            first = false;
        }
        entriesJson.append("]");
        return String.format("{\"name\": \"%s\", \"dataEntries\": %s}", name, entriesJson.toString());
    }
}