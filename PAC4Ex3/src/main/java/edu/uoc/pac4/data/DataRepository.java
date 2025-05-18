package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataEntryException;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

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
                } catch (DataEntryException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DataRepository copy = (DataRepository) super.clone();
        copy.dataEntries = new HashMap<>();
        for (Map.Entry<Integer, DataEntry> entry : this.dataEntries.entrySet()) {
            copy.dataEntries.put(entry.getKey(), (DataEntry) entry.getValue().clone());
        }
        return copy;
    }

    public void addDataEntry(DataEntry dataEntry) throws DataEntryException {
        if (dataEntry == null) {
            throw new DataEntryException("[ERROR] Data entry cannot be null.");
        }
        if (dataEntries.containsKey(dataEntry.getId())) {
            throw new DataEntryException("[ERROR] Data entry with this ID already exists.");
        }
        dataEntries.put(dataEntry.getId(), dataEntry);
    }

    public DataEntry getDataEntry(int id) throws DataEntryException {
        if (!dataEntries.containsKey(id)) {
            throw new DataEntryException("[ERROR] Data entry not found.");
        }
        return dataEntries.get(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"name\": \"").append(name).append("\",\n");
        sb.append("  \"dataEntries\": [\n");
        List<Integer> ids = new ArrayList<>(dataEntries.keySet());
        Collections.sort(ids);
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

    public List<DataEntry> getDataEntriesPerDay(LocalDate date) {
        return dataEntries.values().stream()
                .filter(entry -> entry.getTimestamp().toLocalDate().equals(date))
                .sorted(Comparator.comparing(DataEntry::getTimestamp))
                .collect(Collectors.toList());
    }

    public Map<String, Long> getDataEntriesCountPerParticle() {
        return dataEntries.values().stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getParticle().getClass().getSimpleName(),
                        Collectors.counting()
                ));
    }
}
