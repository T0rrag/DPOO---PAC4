package edu.uoc.pac4.data;

import java.util.HashMap;

public class DataRepository implements Cloneable {
    private String name;
    private HashMap<Integer, DataEntry> dataEntries;

    public DataRepository(String name, DataEntry[] entries) {
        this.name = name;
        this.dataEntries = new HashMap<>();
        if (entries != null) {
            for (DataEntry entry : entries) {
                try {
                    addDataEntry(entry);
                } catch (edu.uoc.pac4.exception.DataEntryException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DataRepository copy = (DataRepository) super.clone();
        copy.dataEntries = new java.util.HashMap<>();
        for (java.util.Map.Entry<Integer, DataEntry> entry : this.dataEntries.entrySet()) {
            copy.dataEntries.put(entry.getKey(), (DataEntry) entry.getValue().clone());
        }
        return copy;
    }

    public void addDataEntry(DataEntry dataEntry) throws edu.uoc.pac4.exception.DataEntryException {
        if (dataEntries.containsKey(dataEntry.getId())) {
            throw new edu.uoc.pac4.exception.DataEntryException("Duplicate entry ID");
        }
        dataEntries.put(dataEntry.getId(), dataEntry);
    }

    public DataEntry getDataEntry(int id) {
        return dataEntries.get(id);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"name\": \"").append(name).append("\",\n");
        sb.append("  \"dataEntries\": [\n");
        java.util.List<Integer> ids = new java.util.ArrayList<>(dataEntries.keySet());
        java.util.Collections.sort(ids);
        for (int i = 0; i < ids.size(); i++) {
            DataEntry entry = dataEntries.get(ids.get(i));
            String entryString = entry.toString().replaceAll("(?m)^", "    ");
            sb.append(entryString);
            if (i < ids.size() - 1) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append("  ]\n");
        sb.append("}");
        return sb.toString();
    }
}
