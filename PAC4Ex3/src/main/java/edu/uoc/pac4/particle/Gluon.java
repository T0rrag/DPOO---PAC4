package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import java.util.Locale;

public class Gluon extends Boson {

    private String colorCharge;

    public Gluon(String id, double mass, double charge, double spin, double energy, boolean forceCarrier, String colorCharge) throws ParticleException {
        super(id, mass, charge, spin, energy, forceCarrier);
        setColorCharge(colorCharge);
    }

    public String getColorCharge() {
        return colorCharge;
    }

    public void setColorCharge(String colorCharge) throws ParticleException {
        if (colorCharge == null || colorCharge.trim().isEmpty()) {
            throw new ParticleException("[ERROR] Color charge cannot be null or blank.");
        }
        this.colorCharge = colorCharge;
    }

    @Override
    public void simulate() {
        System.out.printf("Gluon [%s] interaction: carrying color charge %s to mediate strong force.%n", getId(), colorCharge);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "{\"type\":\"gluon\",\"boson\":{\"particle\":{\"id\":\"%s\",\"mass\":%.2f,\"charge\":%.2f,\"spin\":%.2f,\"energy\":%.2f},\"forceCarrier\":%s},\"colorCharge\":\"%s\"}",
                getId(), getMass(), getCharge(), getSpin(), getEnergy(),
                isForceCarrier(), colorCharge
        );
    }
}
