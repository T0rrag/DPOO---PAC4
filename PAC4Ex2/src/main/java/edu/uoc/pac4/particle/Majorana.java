package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

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
        System.out.printf("Majorana [%s] in %s material behaving as %s particle.%n",
                getId(), getMaterialType().getName(), type);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"majorana\",\n  \"quasiParticle\": %s,\n  \"isSelfConjugate\": %b\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                isSelfConjugate
        );
    }

    @Override
    public Majorana clone() throws CloneNotSupportedException {
        return (Majorana) super.clone();
    }
}
