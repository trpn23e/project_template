/*
 * (c)BOC
 */
package net.pis.common;

public enum Direction {

    Inbound("I"),
    Outbound("O");

    private final String code;

    private Direction(String code) {

        this.code = code;

    }

    public String getCode() {
        return this.code;
    }

}
