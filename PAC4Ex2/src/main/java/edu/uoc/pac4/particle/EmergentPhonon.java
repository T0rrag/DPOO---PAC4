package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class EmergentPhonon extends QuasiParticle {
    private String vibrationMode;

    public EmergentPhonon(String id, double mass, double charge, double spin, double energy,
                          double lifeTime, double coherenceLength, MaterialType materialType, String vibrationMode) throws ParticleException {
        super(id, mass, charge, spin, energy, lifeTime, coherenceLength, materialType);
        setVibrationMode(vibrationMode);
    }

    public String getVibrationMode() { return vibrationMode; }
    public void setVibrationMode(String vibrationMode) throws ParticleException {
        if (vibrationMode == null || vibrationMode.trim().isEmpty()) {
            throw new ParticleException(ParticleException.ERR_VIBRATION_MODE_NULL_BLANK);
        }
        this.vibrationMode = vibrationMode.trim();
    }

    @Override
    public void simulate() {
        System.out.printf("EmergentPhonon [%s] vibrating in %s mode with lifetime %.2e s.%n",
                getId(), vibrationMode, getLifeTime());
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"emergentPhonon\",\n  \"quasiParticle\": %s,\n  \"vibrationMode\": \"%s\"\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                vibrationMode
        );
    }

    @Override
    public EmergentPhonon clone() throws CloneNotSupportedException {
        return (EmergentPhonon) super.clone();
    }
}
