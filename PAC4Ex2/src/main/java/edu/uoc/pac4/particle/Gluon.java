package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;

public class Gluon extends Boson {
    private String colorCharge;

    public Gluon(String id, double mass, double charge, double spin, double energy, boolean forceCarrier, String colorCharge) throws ParticleException {
        super(id, mass, charge, spin, energy, forceCarrier);
        setColorCharge(colorCharge);
    }

    public String getColorCharge() { return colorCharge; }
    public void setColorCharge(String colorCharge) throws ParticleException {
        if (colorCharge == null || colorCharge.trim().isEmpty()) {
            throw new ParticleException(ParticleException.ERR_COLOR_CHARGE_NULL_BLANK);
        }
        this.colorCharge = colorCharge.trim();
    }

    @Override
    public void simulate() {
        System.out.printf("Gluon [%s] interaction: carrying color charge %s to mediate strong force.%n",
                getId(), colorCharge);
    }

    @Override
    public String toString() {
        return String.format(
                "{\n  \"type\": \"gluon\",\n  \"boson\": %s,\n  \"colorCharge\": \"%s\"\n}",
                super.toString().replaceAll("(?m)^", "    ").replaceFirst("\\s+\\{", "{"),
                colorCharge
        );
    }

    @Override
    public Gluon clone() throws CloneNotSupportedException {
        return (Gluon) super.clone();
    }

}
