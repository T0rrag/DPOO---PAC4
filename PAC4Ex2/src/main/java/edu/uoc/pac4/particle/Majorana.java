package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import java.util.Locale;

public class Majorana extends QuasiParticle {
    private boolean isSelfConjugate;

    public Majorana(String id, double mass, double charge, double spin, double energy,
                    double lifeTime, double coherenceLength, MaterialType materialType, boolean isSelfConjugate) throws ParticleException {
        super(id, mass, charge, spin, energy, lifeTime, coherenceLength, materialType);
        this.isSelfConjugate = isSelfConjugate;
    }

    public boolean isSelfConjugate() { return isSelfConjugate; }
    public void setSelfConjugate(boolean selfConjugate) { isSelfConjugate = selfConjugate; }

    @Override
    public void simulate() {
        String type = isSelfConjugate ? "self-conjugate" : "distinct from its antiparticle";
        String materialStr = String.format("{\"name\": \"%s\", \"density\": %.2f}",
                getMaterialType().getName(), getMaterialType().getDensity());
        System.out.printf("Majorana [%s] in %s material behaving as %s particle.%n",
                getId(), materialStr, type);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "{\"type\":\"majorana\",\"quasiParticle\":%s,\"isSelfConjugate\":%s}",
                super.toString(), isSelfConjugate()
        );
    }
}
