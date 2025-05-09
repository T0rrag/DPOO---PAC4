package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataEntryException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataEntry {
    private int id;
    private String title;
    private LocalDateTime timestamp;
    private String observations;

    public DataEntry(int id, String title, LocalDateTime timestamp, String observations) throws DataEntryException {
        setId(id);
        setTitle(title);
        setTimestamp(timestamp);
        setObservations(observations);
    }

    public void setId(int id) throws DataEntryException {
        if (id <= 0) {
            throw new DataEntryException(DataEntryException.ERROR_ID);
        }
        this.id = id;
    }

    public void setTitle(String title) throws DataEntryException {
        if (title == null || title.trim().isEmpty()) {
            throw new DataEntryException(DataEntryException.ERROR_TITLE);
        }
        this.title = title.trim();
    }

    public void setTimestamp(LocalDateTime timestamp) throws DataEntryException {
        if (timestamp == null || timestamp.isAfter(LocalDateTime.now())) {
            throw new DataEntryException(DataEntryException.ERROR_TIMESTAMP);
        }
        this.timestamp = timestamp;
    }

    public void setObservations(String observations) throws DataEntryException {
        if (observations == null) {
            throw new DataEntryException(DataEntryException.ERROR_OBSERVATIONS);
        }
        this.observations = observations.trim();
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getObservations() { return observations; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        return String.format("{\"id\": %d, \"title\": \"%s\", \"timestamp\": \"%s\", \"observations\": \"%s\"}",
                id, title, timestamp.format(formatter), observations);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DataEntry)) return false;
        DataEntry other = (DataEntry) obj;
        return this.title.equals(other.title) &&
                this.timestamp.equals(other.timestamp) &&
                this.observations.equals(other.observations);
    }
}