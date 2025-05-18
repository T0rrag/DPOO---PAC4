package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Muon extends Fermion implements QuantumDecaying {
    private double decayTime;

    public Muon(String id, double mass, double charge, double spin, double energy, int leptonNumber, double decayTime) throws ParticleException {
        super(id, mass, charge, spin, energy, leptonNumber);
        setDecayTime(decayTime);
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
        System.out.printf("Muon [%s] with lepton number %d decays after %.2e s.%n",
                getId(), getLeptonNumber(), decayTime);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"muon\",\n  \"fermion\": %s,\n  \"decayTime\": %.3e\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                decayTime
        );
    }

    @Override
    public Muon clone() throws CloneNotSupportedException {
        return (Muon) super.clone();
    }
}
