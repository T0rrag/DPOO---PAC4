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
    public double getMass() { return mass; }
    public double getCharge() { return charge; }
    public double getSpin() { return spin; }
    public double getEnergy() { return energy; }

    public void setId(String id) throws ParticleException {
        if (id == null || id.trim().isEmpty()) {
            throw new ParticleException(ParticleException.ERR_ID_NULL_BLANK);
        }
        this.id = id.trim();
    }

    public void setMass(double mass) throws ParticleException {
        if (mass < 0 || Double.isInfinite(mass)) {
            throw new ParticleException(ParticleException.ERR_MASS_NEG_INF);
        }
        this.mass = mass;
    }

    public void setCharge(double charge) throws ParticleException {
        if (Double.isInfinite(charge)) {
            throw new ParticleException(ParticleException.ERR_CHARGE_INF);
        }
        this.charge = charge;
    }

    public void setSpin(double spin) throws ParticleException {
        if (spin < 0 || Double.isInfinite(spin)) {
            throw new ParticleException(ParticleException.ERR_SPIN_NEG_INF);
        }
        this.spin = spin;
    }

    public void setEnergy(double energy) throws ParticleException {
        if (energy < 0 || Double.isInfinite(energy)) {
            throw new ParticleException(ParticleException.ERR_ENERGY_NEG_INF);
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

}
