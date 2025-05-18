package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Photon extends Boson {
    private double wavelength;

    public Photon(String id, double mass, double charge, double spin, double energy, boolean forceCarrier, double wavelength) throws ParticleException {
        super(id, mass, charge, spin, energy, forceCarrier);
        setWavelength(wavelength);
    }

    public double getWavelength() { return wavelength; }
    public void setWavelength(double wavelength) throws ParticleException {
        if (wavelength < 0 || Double.isInfinite(wavelength)) {
            throw new ParticleException(ParticleException.ERR_WAVELENGTH_NEG_INF);
        }
        this.wavelength = wavelength;
    }

    @Override
    public void simulate() {
        System.out.printf("Photon [%s] with wavelength %.2f nm has been absorbed, transferring %.2f eV of energy.%n",
                getId(), wavelength, getEnergy());
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"photon\",\n  \"boson\": %s,\n  \"wavelength\": %.2f\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                wavelength
        );
    }

    @Override
    public Photon clone() throws CloneNotSupportedException {
        return (Photon) super.clone();
    }

}
