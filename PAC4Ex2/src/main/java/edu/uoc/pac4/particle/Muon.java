package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import java.util.Locale;

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
            throw new ParticleException("[ERROR] " + ParticleException.ERROR_DECAY_TIME);
        }
        this.decayTime = decayTime;
    }


    public void simulate() {
        System.out.printf(Locale.US,
                "Muon [%s] with lepton number %d decays after %.2e s.%n",
                getId(), getLeptonNumber(), decayTime);
    }


    public String toString() {
        return String.format(Locale.US,
                "{\"type\":\"muon\",\"fermion\":%s,\"decayTime\":%.2e}",
                super.toString(), decayTime
        );
    }
}
