package edu.uoc.pac4.data;

import java.time.LocalDateTime;
import edu.uoc.pac4.particle.Particle;

public class DataEntry implements Cloneable {
    private int id;
    private String title;
    private LocalDateTime timestamp;
    private String observations;
    private edu.uoc.pac4.particle.Particle particle;

    public DataEntry(int id, String title, LocalDateTime timestamp, String observations, Particle particle) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.observations = observations;
        this.particle = particle;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getObservations() { return observations; }
    public Particle getParticle() { return particle; }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }

    @Override
    public DataEntry clone() throws CloneNotSupportedException {
        DataEntry copy = (DataEntry) super.clone();
        if (this.particle != null)
            copy.particle = this.particle.clone();
        return copy;
    }



    @Override
    public String toString() {
        // No piden json real, pero puedes usar String.format o concatenación para el esperado por los tests
        // Aquí, lo básico para el test avanzado
        return String.format("{\"id\":%d,\"title\":\"%s\",\"timestamp\":\"%s\",\"observations\":\"%s\",\"particle\":%s}",
                id, title, timestamp, observations, particle != null ? particle.toString() : "null");
    }
}
