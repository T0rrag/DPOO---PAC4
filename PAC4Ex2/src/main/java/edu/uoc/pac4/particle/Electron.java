package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

import java.util.Locale;

public class Electron extends Fermion {

    public Electron(String id, double mass, double charge, double spin, double energy, int leptonNumber) throws ParticleException {
        super(id, mass, charge, spin, energy, leptonNumber);
    }

    public String toString() {
        return String.format(Locale.US,
                "{\"type\":\"electron\",\"fermion\":{\"particle\":{\"id\":\"%s\",\"mass\":%.2f,\"charge\":%.2f,\"spin\":%.2f,\"energy\":%.2f},\"leptonNumber\":%d}}",
                getId(), getMass(), getCharge(), getSpin(), getEnergy(), getLeptonNumber()
        );
    }

    public void simulate() {
        System.out.printf(
                "Electron [%s] with lepton number %d is stable and does not decay.",
                getId(), getLeptonNumber()
        );
    }
}
