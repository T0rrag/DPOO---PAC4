package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import java.util.Locale;

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

    public double getBindingEnergy() {
        return bindingEnergy;
    }

    public void setBindingEnergy(double bindingEnergy) throws ParticleException {
        if (bindingEnergy < 0 || Double.isInfinite(bindingEnergy)) {
            throw new ParticleException("[ERROR] Binding energy cannot be negative or infinite.");
        }
        this.bindingEnergy = bindingEnergy;
    }

    @Override
    public double getDecayTime() {
        return decayTime;
    }

    @Override
    public void setDecayTime(double decayTime) throws ParticleException {
        if (decayTime < 0 || Double.isInfinite(decayTime)) {
            throw new ParticleException("[ERROR] Decay time cannot be negative or infinite.");
        }
        this.decayTime = decayTime;
    }

    @Override
    public void simulate() {
        System.out.printf(Locale.US,
                "Exciton [%s] with binding energy %.2f eV decays after %.2e s.%n",
                getId(), bindingEnergy, decayTime);
    }

    @Override
    public String toString() {
        // Si super.toString() es: {"quasiParticle":{....}}
        // Debe quedar: {"type":"exciton","quasiParticle":{....},"bindingEnergy":...,"decayTime":...}
        String superStr = super.toString().trim();
        if (superStr.startsWith("{") && superStr.endsWith("}")) {
            superStr = superStr.substring(1, superStr.length() - 1); // quita llaves
        }
        return String.format(Locale.US,
                "{\"type\":\"exciton\",%s,\"bindingEnergy\":%.2f,\"decayTime\":%.2e}",
                superStr, bindingEnergy, decayTime
        );
    }
}
