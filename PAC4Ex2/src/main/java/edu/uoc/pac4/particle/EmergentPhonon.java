package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class EmergentPhonon extends QuasiParticle {

    private String vibrationMode;

    public EmergentPhonon(String id, double mass, double charge, double spin, double energy,
                          double lifetime, double coherenceLength, MaterialType materialType,
                          String vibrationMode) throws ParticleException {
        super(id, mass, charge, spin, energy, lifetime, coherenceLength, materialType);
        setVibrationMode(vibrationMode);
    }

    public String getVibrationMode() {
        return vibrationMode;
    }

    public void setVibrationMode(String vibrationMode) throws ParticleException {
        if (vibrationMode == null || vibrationMode.isBlank()) {
            throw new ParticleException(ParticleException.ERROR_VIBRATION_MODE);
        }
        this.vibrationMode = vibrationMode;
    }

    @Override
    public void simulate() {
        // Implementación de simulación para EmergentPhonon, dejar vacío si no hay especificación
    }

    @Override
    public String toString() {
        return String.format(
                "EmergentPhonon{%n    ID: %s%n    Vibration Mode: %s%n    Lifetime: %.2f%n%s}",
                getId(), vibrationMode, getLifeTime(),
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{")
        );
    }

    @Override
    public EmergentPhonon clone() throws CloneNotSupportedException {
        return (EmergentPhonon) super.clone();
    }
}
