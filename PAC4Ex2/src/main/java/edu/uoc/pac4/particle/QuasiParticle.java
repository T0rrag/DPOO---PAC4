package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class QuasiParticle extends Particle {
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

    public double getLifeTime() { return lifeTime; }
    public void setLifeTime(double lifeTime) throws ParticleException {
        if (lifeTime <= 0 || Double.isInfinite(lifeTime)) {
            throw new ParticleException(ParticleException.ERR_LIFETIME_NEG_ZERO_INF);
        }
        this.lifeTime = lifeTime;
    }
    public double getCoherenceLength() { return coherenceLength; }
    public void setCoherenceLength(double coherenceLength) throws ParticleException {
        if (coherenceLength < 0 || Double.isInfinite(coherenceLength)) {
            throw new ParticleException(ParticleException.ERR_COHERENCE_LENGTH_NEG_INF);
        }
        this.coherenceLength = coherenceLength;
    }
    public MaterialType getMaterialType() { return materialType; }
    public void setMaterialType(MaterialType materialType) throws ParticleException {
        if (materialType == null) {
            throw new ParticleException(ParticleException.ERR_MATERIAL_TYPE_NULL);
        }
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"particle\": %s,\n  \"lifeTime\": %.3e,\n  \"coherenceLength\": %.3e,\n  \"materialType\": %s\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                lifeTime, coherenceLength,
                materialType.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{")
        );
    }

    @Override
    public QuasiParticle clone() throws CloneNotSupportedException {
        return (QuasiParticle) super.clone();
    }

}
