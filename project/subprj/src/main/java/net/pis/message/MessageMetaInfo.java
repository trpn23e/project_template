/*
 * (c)BOC
 */
package net.pis.message;


import net.pis.common.Direction;
import net.pis.common.Listener;

import java.io.Serializable;

public class MessageMetaInfo implements Serializable {

    public static final long serialVersionUID = 4124122L;

    private String messageTagId;
    private String messageId;
    private Listener destination;
    private Direction direction;
    private boolean isAck;
    private boolean isError;
    private String targetSystemId;
    private String erpSystem;
    private String clientCode;
    private String companyCode;
    private String targetKey;
    private String ticket;

    public String getErpSystem() {
        return erpSystem;
    }

    public void setErpSystem(String erpSystem) {
        this.erpSystem = erpSystem;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }

    public String getMessageTagId() {

        return messageTagId;
    }

    public void setMessageTagId(String messageTagId) {
        this.messageTagId = messageTagId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Listener getDestination() {
        return destination;
    }

    public void setDestination(Listener destination) {
        this.destination = destination;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAck() {
        return isAck;
    }

    public void setAck(boolean isAck) {
        this.isAck = isAck;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public String getTargetSystemId() {
        return targetSystemId;
    }

    public void setTargetSystemId(String targetSystemId) {
        this.targetSystemId = targetSystemId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        switch (this.getDirection()) {
            case Inbound: {
                builder.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<").append(System.lineSeparator());
                break;
            }
            case Outbound: {
                builder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>").append(System.lineSeparator());
                break;
            }
        }
        builder.append("* HASH CODE : ").append(this.hashCode()).append(System.lineSeparator());
        builder.append("messageId : ").append(this.getMessageId()).append(System.lineSeparator());
        builder.append("messageTagId : ").append(this.getMessageTagId()).append(System.lineSeparator());
        builder.append("direction : ").append(this.getDirection()).append(System.lineSeparator());
        builder.append("destination : ").append(this.getDestination()).append(System.lineSeparator());
        builder.append("ack : ").append(this.isAck()).append(System.lineSeparator());
        builder.append("error : ").append(this.isError()).append(System.lineSeparator());
        builder.append("targetSystemId : ").append(this.getTargetSystemId()).append(System.lineSeparator());

        if (null != this.getErpSystem()) {
            builder.append("erpSystem : ").append(this.getErpSystem()).append(System.lineSeparator());
            builder.append("  destination : ").append(this.getTargetKey()).append(System.lineSeparator());

            if (null != this.getClientCode()) {
                builder.append("    client : ").append(
                    this.getClientCode()).append(System.lineSeparator());

                builder.append("    company : ").append(this.getCompanyCode()).append(System.lineSeparator());
            }

        } else {
            builder.append("erpSystem : unkown").append(System.lineSeparator());
        }
        switch (this.getDirection()) {
            case Inbound: {
                builder.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<").append(System.lineSeparator());
                break;
            }
            case Outbound: {
                builder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>").append(System.lineSeparator());
                break;
            }
        }

        return builder.toString();

    }
}
