package edu.uoc.pac4.exception;

public class ParticleException extends AppException  {
    public static final String ERROR_ID = "ID cannot be null or blank.";
    public static final String ERROR_MASS = "Mass cannot be negative or infinite.";
    public static final String ERROR_CHARGE = "Charge cannot be infinite.";
    public static final String ERROR_SPIN = "Spin cannot be negative or infinite.";
    public static final String ERROR_ENERGY = "Energy cannot be negative or infinite.";
    public static final String ERROR_WAVELENGTH = "Wavelength cannot be negative or infinite.";
    public static final String ERROR_COLOR_CHARGE = "Color charge cannot be null or blank.";
    public static final String ERROR_LIFETIME = "[ERROR] Lifetime cannot be negative, zero or infinite.";
    public static final String ERROR_COHERENCE_LENGTH = "[ERROR] Coherence length cannot be negative or infinite.";
    public static final String ERROR_MATERIAL_TYPE = "[ERROR] Material type cannot be null.";
    public static final String ERROR_VIBRATION_MODE = "Vibration mode cannot be null or blank.";
    public static final String ERROR_SPIN_FLIP_COUNT = "Spin flip count cannot be negative.";
    public static final String ERROR_LEPTON_NUMBER = "Lepton number cannot be negative.";
    public static final String ERROR_DECAY_TIME = "Decay time cannot be negative or infinite.";
    public static final String ERROR_BINDING_ENERGY = "[ERROR] Binding energy cannot be negative or infinite.";

    // Alias para compatibilidad con nombres alternativos que aparecen en tu error:
    public static final String ERR_ID_NULL_BLANK = ERROR_ID;
    public static final String ERR_MASS_NEG_INF = ERROR_MASS;
    public static final String ERR_CHARGE_INF = ERROR_CHARGE;
    public static final String ERR_SPIN_NEG_INF = ERROR_SPIN;
    public static final String ERR_ENERGY_NEG_INF = ERROR_ENERGY;
    public static final String ERR_WAVELENGTH_NEG_INF = ERROR_WAVELENGTH;
    public static final String ERR_COLOR_CHARGE_NULL_BLANK = ERROR_COLOR_CHARGE;
    public static final String ERR_LIFETIME_NEG_ZERO_INF = ERROR_LIFETIME;
    public static final String ERR_COHERENCE_LENGTH_NEG_INF = ERROR_COHERENCE_LENGTH;
    public static final String ERR_MATERIAL_TYPE_NULL = ERROR_MATERIAL_TYPE;
    public static final String ERR_VIBRATION_MODE_NULL_BLANK = ERROR_VIBRATION_MODE;
    public static final String ERR_SPIN_FLIP_COUNT_NEG = ERROR_SPIN_FLIP_COUNT;
    public static final String ERR_LEPTON_NUMBER_NEG = ERROR_LEPTON_NUMBER;
    public static final String ERR_DECAY_TIME_NEG_INF = ERROR_DECAY_TIME;
    public static final String ERR_BINDING_ENERGY_NEG_INF = ERROR_BINDING_ENERGY;

    public ParticleException(String message) {
        super(message);
    }
}
