package tech.flycat.apiverson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 */
public class IllegalVersionException extends ResponseStatusException {
    public IllegalVersionException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
