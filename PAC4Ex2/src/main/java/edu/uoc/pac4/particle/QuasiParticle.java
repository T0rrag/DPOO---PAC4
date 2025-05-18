package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class QuasiParticle extends Particle implements Simulatable {

    private double lifetime;
    private double coherenceLength;
    private MaterialType materialType;

    public QuasiParticle(String id, double mass, double charge, double spin, double energy,
                         double lifetime, double coherenceLength, MaterialType materialType) throws ParticleException {
        super(id, mass, charge, spin, energy);
        setLifeTime(lifetime);
        setCoherenceLength(coherenceLength);
        setMaterialType(materialType);
    }

    public double getLifeTime() {
        return lifetime;
    }

    public void setLifeTime(double lifetime) throws ParticleException {
        if (Double.isNaN(lifetime) || lifetime <= 0 || Double.isInfinite(lifetime)) {
            throw new ParticleException(ParticleException.ERROR_LIFETIME);
        }
        this.lifetime = lifetime;
    }

    public double getCoherenceLength() {
        return coherenceLength;
    }

    public void setCoherenceLength(double coherenceLength) throws ParticleException {
        if (Double.isNaN(coherenceLength) || coherenceLength < 0 || Double.isInfinite(coherenceLength)) {
            throw new ParticleException(ParticleException.ERROR_COHERENCE_LENGTH);
        }
        this.coherenceLength = coherenceLength;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) throws ParticleException {
        if (materialType == null) {
            throw new ParticleException(ParticleException.ERROR_MATERIAL_TYPE);
        }
        this.materialType = materialType;
    }

    @Override
    public void simulate() {
        // Implementación de simulación, dejar vacío si no hay especificación
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US,
                "\"quasiParticle\":{\"particle\":%s,\"lifeTime\":%.3e,\"coherenceLength\":%.3e,\"materialType\":%s}",
                super.toString(), getLifeTime(), getCoherenceLength(), getMaterialType().toString());
    }


    @Override
    public QuasiParticle clone() throws CloneNotSupportedException {
        return (QuasiParticle) super.clone();
    }
}
