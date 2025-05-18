package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Exciton extends QuasiParticle implements QuantumDecaying {
    private double bindingEnergy;
    private double decayTime;

    public Exciton(String id, double mass, double charge, double spin, double energy,
                   double lifeTime, double coherenceLength, MaterialType materialType,
                   double bindingEnergy, double decayTime) throws ParticleException {
        super(id, mass, charge, spin, energy, lifeTime, coherenceLength, materialType);
        setBindingEnergy(bindingEnergy);
        setDecayTime(decayTime);
    }

    public double getBindingEnergy() { return bindingEnergy; }
    public void setBindingEnergy(double bindingEnergy) throws ParticleException {
        if (bindingEnergy < 0 || Double.isInfinite(bindingEnergy)) {
            throw new ParticleException(ParticleException.ERR_BINDING_ENERGY_NEG_INF);
        }
        this.bindingEnergy = bindingEnergy;
    }

    @Override
    public double getDecayTime() { return decayTime; }
    @Override
    public void setDecayTime(double decayTime) throws ParticleException {
        if (decayTime < 0 || Double.isInfinite(decayTime)) {
            throw new ParticleException(ParticleException.ERR_DECAY_TIME_NEG_INF);
        }
        this.decayTime = decayTime;
    }

    @Override
    public void simulate() {
        System.out.printf("Exciton [%s] with binding energy %.2f eV decays after %.2e s.%n",
                getId(), bindingEnergy, decayTime);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"exciton\",\n  \"quasiParticle\": %s,\n  \"bindingEnergy\": %.2f,\n  \"decayTime\": %.3e\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                bindingEnergy, decayTime
        );
    }

    @Override
    public Exciton clone() throws CloneNotSupportedException {
        return (Exciton) super.clone();
    }
}
