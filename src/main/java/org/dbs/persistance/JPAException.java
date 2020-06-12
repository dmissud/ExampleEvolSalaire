package org.dbs.persistance;

public class JPAException extends Exception {
    public JPAException() {
        super("Problem de session Factory");
    }

    public JPAException(String message) {
        super(message);
    }
}
