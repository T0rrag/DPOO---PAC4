package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import java.util.Locale;

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
    public String toString() {
        return String.format(Locale.US,
                "{\"type\":\"emergentPhonon\",\"quasiParticle\":%s,\"vibrationMode\":\"%s\"}",
                super.toString(), getVibrationMode());
    }

    @Override
    public void simulate() {
        System.out.printf(Locale.US, "EmergentPhonon [%s] vibrating in %s mode with lifetime %.2e s.%n",
                getId(), getVibrationMode(), getLifeTime());
    }
}
