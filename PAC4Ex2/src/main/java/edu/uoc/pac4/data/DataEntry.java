package edu.uoc.pac4.data;

import java.time.LocalDateTime;
import java.util.Locale;
import edu.uoc.pac4.particle.Particle;

public class DataEntry implements Cloneable {
    private int id;
    private String title;
    private LocalDateTime timestamp;
    private String observations;
    private Particle particle;

    public DataEntry(int id, String title, LocalDateTime timestamp, String observations, Particle particle) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.observations = observations;
        this.particle = particle;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }

    public Particle getParticle() { return particle; }
    public void setParticle(Particle particle) { this.particle = particle; }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DataEntry copy = (DataEntry) super.clone();
        if (this.particle != null) {
            copy.particle = (Particle) this.particle.clone();
        }
        return copy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DataEntry)) return false;
        DataEntry other = (DataEntry) obj;
        return id == other.id &&
                java.util.Objects.equals(title, other.title) &&
                java.util.Objects.equals(timestamp, other.timestamp) &&
                java.util.Objects.equals(observations, other.observations) &&
                java.util.Objects.equals(particle, other.particle);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "{\"id\":%d,\"title\":\"%s\",\"timestamp\":\"%s\",\"observations\":\"%s\",\"particle\":%s}",
                id, title, timestamp, observations, particle != null ? particle.toString() : "null");
    }
}
