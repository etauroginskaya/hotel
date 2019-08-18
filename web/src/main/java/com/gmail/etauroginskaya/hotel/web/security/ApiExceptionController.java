package com.gmail.etauroginskaya.hotel.web.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiExceptionController {

    @GetMapping("/access-denied")
    public ResponseEntity<ApiError> error403() {
        return new ResponseEntity<>(new ApiError("Access Denied"), HttpStatus.FORBIDDEN);
    }

    class ApiError {
        private String message;

        public ApiError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
