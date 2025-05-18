package edu.uoc.pac4.exception;

public class ParticleException extends AppException  {
    public static final String ERROR_ID = "[ERROR] ID cannot be null or blank.";
    public static final String ERROR_MASS = "[ERROR] Mass cannot be negative or infinite.";
    public static final String ERROR_CHARGE = "[ERROR] Charge cannot be infinite.";
    public static final String ERROR_SPIN = "[ERROR] Spin cannot be negative or infinite.";
    public static final String ERROR_ENERGY = "[ERROR] Energy cannot be negative or infinite.";
    public static final String ERROR_WAVELENGTH = "[ERROR] Wavelength cannot be negative or infinite.";
    public static final String ERROR_COLOR_CHARGE = "[ERROR] Color charge cannot be null or blank.";
    public static final String ERROR_LIFETIME = "[ERROR] Lifetime cannot be negative, zero or infinite.";
    public static final String ERROR_COHERENCE_LENGTH = "[ERROR] Coherence length cannot be negative or infinite.";
    public static final String ERROR_MATERIAL_TYPE = "[ERROR] Material type cannot be null.";
    public static final String ERROR_VIBRATION_MODE = "[ERROR] Vibration mode cannot be null or blank.";
    public static final String ERROR_SPIN_FLIP_COUNT = "[ERROR] Spin flip count cannot be negative.";
    public static final String ERROR_LEPTON_NUMBER = "[ERROR] Lepton number cannot be negative.";
    public static final String ERROR_DECAY_TIME = "[ERROR] Decay time cannot be negative or infinite.";
    public static final String ERROR_BINDING_ENERGY = "[ERROR] Binding energy cannot be negative or infinite.";

    public ParticleException(String message) {
        super(message);
    }
}
