package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Magnon extends QuasiParticle {
    private int spinFlipCount;

    public Magnon(String id, double mass, double charge, double spin, double energy,
                  double lifeTime, double coherenceLength, MaterialType materialType, int spinFlipCount) throws ParticleException {
        super(id, mass, charge, spin, energy, lifeTime, coherenceLength, materialType);
        setSpinFlipCount(spinFlipCount);
    }

    public int getSpinFlipCount() { return spinFlipCount; }
    public void setSpinFlipCount(int spinFlipCount) throws ParticleException {
        if (spinFlipCount < 0) {
            throw new ParticleException(ParticleException.ERR_SPIN_FLIP_COUNT_NEG);
        }
        this.spinFlipCount = spinFlipCount;
    }

    @Override
    public void simulate() {
        System.out.printf("Magnon [%s] propagating in %s with %d spin flips.%n",
                getId(), getMaterialType().getName(), spinFlipCount);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"magnon\",\n  \"quasiParticle\": %s,\n  \"spinFlipCount\": %d\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                spinFlipCount
        );
    }

    @Override
    public Magnon clone() throws CloneNotSupportedException {
        return (Magnon) super.clone();
    }

}
