package edu.uoc.pac4.data;

import java.util.HashMap;
import java.util.Collection;
import edu.uoc.pac4.exception.DataRepositoryException;

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
                } catch (DataRepositoryException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public DataRepository clone() throws CloneNotSupportedException {
        DataRepository copy = (DataRepository) super.clone();
        copy.dataEntries = new java.util.HashMap<>();
        for (java.util.Map.Entry<Integer, DataEntry> entry : this.dataEntries.entrySet()) {
            copy.dataEntries.put(entry.getKey(), entry.getValue().clone());
        }
        return copy;
    }

    public void addDataEntry(DataEntry dataEntry) throws DataRepositoryException {
        if (dataEntry == null) throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_NULL);
        if (dataEntries.containsKey(dataEntry.getId())) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_ENTRY_ALREADY_EXISTS);
        }
        dataEntries.put(dataEntry.getId(), dataEntry);
    }

    public DataEntry getDataEntry(int id) {
        return dataEntries.get(id);
    }

    public Collection<DataEntry> getAllDataEntries() {
        return dataEntries.values();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"name\": \"").append(name).append("\",\n");
        sb.append("  \"dataEntries\": [\n");

        // Ordenar las entradas por id para que el output sea siempre igual
        java.util.List<Integer> ids = new java.util.ArrayList<>(dataEntries.keySet());
        java.util.Collections.sort(ids);

        for (int i = 0; i < ids.size(); i++) {
            DataEntry entry = dataEntries.get(ids.get(i));
            // Indentar cada DataEntry con dos espacios extra
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
} // <--- ESTA llave de cierre es la de la clase
