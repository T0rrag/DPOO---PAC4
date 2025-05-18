package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public abstract class Particle implements Cloneable, Simulatable {
    private String id;
    private double mass;
    private double charge;
    private double spin;
    private double energy;

    public Particle(String id, double mass, double charge, double spin, double energy) throws ParticleException {
        setId(id);
        setMass(mass);
        setCharge(charge);
        setSpin(spin);
        setEnergy(energy);
    }

    public String getId() { return id; }
    public void setId(String id) throws ParticleException {
        if (id == null || id.trim().isEmpty()) {
            throw new ParticleException("[ERROR] ID cannot be null or blank.");
        }
        this.id = id.trim();
    }
    public double getMass() { return mass; }
    public void setMass(double mass) throws ParticleException {
        if (mass < 0 || Double.isInfinite(mass)) {
            throw new ParticleException("[ERROR] Mass cannot be negative or infinite.");
        }
        this.mass = mass;
    }
    public double getCharge() { return charge; }
    public void setCharge(double charge) throws ParticleException {
        if (Double.isInfinite(charge)) {
            throw new ParticleException("[ERROR] Charge cannot be infinite.");
        }
        this.charge = charge;
    }
    public double getSpin() { return spin; }
    public void setSpin(double spin) throws ParticleException {
        if (spin < 0 || Double.isInfinite(spin)) {
            throw new ParticleException("[ERROR] Spin cannot be negative or infinite.");
        }
        this.spin = spin;
    }
    public double getEnergy() { return energy; }
    public void setEnergy(double energy) throws ParticleException {
        if (energy < 0 || Double.isInfinite(energy)) {
            throw new ParticleException("[ERROR] Energy cannot be negative or infinite.");
        }
        this.energy = energy;
    }

    @Override
    public Particle clone() throws CloneNotSupportedException {
        return (Particle) super.clone();
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US,
                "{\"id\":\"%s\",\"mass\":%.2f,\"charge\":%.2f,\"spin\":%.2f,\"energy\":%.2f}",
                getId(), getMass(), getCharge(), getSpin(), getEnergy());
    }
    // NO DECLARES simulate(), equals(), hashCode(), ni ningún otro método extra
}
