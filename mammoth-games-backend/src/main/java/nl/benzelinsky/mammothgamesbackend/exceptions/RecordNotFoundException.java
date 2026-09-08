package nl.benzelinsky.mammothgamesbackend.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String type, Long id) {
        super(type + " not found with id: " + id);
    }
}
