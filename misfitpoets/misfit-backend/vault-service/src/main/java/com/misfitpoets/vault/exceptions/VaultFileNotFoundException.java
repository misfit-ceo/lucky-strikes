package com.misfitpoets.vault.exceptions;

public class VaultFileNotFoundException extends RuntimeException {
    public VaultFileNotFoundException(String message) {
        super(message);
    }
}
