package edu.uoc.pac4.exception;

public class DataEntryException extends AppException {
  public static final String ERROR_ID = "ID must be positive.";
  public static final String ERROR_TITLE = "Title cannot be null or blank.";
  public static final String ERROR_TIMESTAMP = "Timestamp cannot be null.";
  public static final String ERROR_OBSERVATIONS = "Observations cannot be null.";
  public static final String ERROR_PARTICLE = "Particle cannot be null.";

  public DataEntryException(String message) {
    super(message);
  }
}
