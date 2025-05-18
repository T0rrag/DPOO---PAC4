package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class QuasiParticle extends Particle implements Simulatable {

    private double lifeTime;
    private double coherenceLength;
    private MaterialType materialType;

    public QuasiParticle(String id, double mass, double charge, double spin, double energy,
                         double lifeTime, double coherenceLength, MaterialType materialType) throws ParticleException {
        super(id, mass, charge, spin, energy);
        setLifeTime(lifeTime);
        setCoherenceLength(coherenceLength);
        setMaterialType(materialType);
    }

    public double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(double lifeTime) throws ParticleException {
        if (Double.isNaN(lifeTime) || lifeTime <= 0 || Double.isInfinite(lifeTime)) {
            throw new ParticleException("[ERROR] Lifetime cannot be negative, zero or infinite.");
        }
        this.lifeTime = lifeTime;
    }

    public double getCoherenceLength() {
        return coherenceLength;
    }

    public void setCoherenceLength(double coherenceLength) throws ParticleException {
        if (Double.isNaN(coherenceLength) || coherenceLength < 0 || Double.isInfinite(coherenceLength)) {
            throw new ParticleException("[ERROR] Coherence length cannot be negative or infinite.");
        }
        this.coherenceLength = coherenceLength;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) throws ParticleException {
        if (materialType == null) {
            throw new ParticleException("[ERROR] Material type cannot be null.");
        }
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%n    Lifetime: %.2f%n    Coherence Length: %.2f%n    Material Type: %s",
                super.toString(), lifeTime, coherenceLength,
                (materialType != null ? materialType.getName() : "null")
        );
    }
}
