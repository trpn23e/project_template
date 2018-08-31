
package net.pis.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class DemoDTO implements Serializable {


    private Integer id;
    private String contractNumber;
    private String smartContractAddress;
    private String transactionId;
    private String contractStatus;
    private String transferStatus;
    private String ownerAddress;
    private String senderAddress;
    private String receiverAddress;
    private String senderBrokerAddress;
    private String receiverBrokerAddress;
    private String ownerName;
    private String senderName;
    private String receiverName;
    private String senderBrokerName;
    private String receiverBrokerName;
    private String contractFileName;
    private String contractFileHash;
    private String contractFileLink;
    private String finalContractFileHash;
    private String finalContractFileLink;
    private String addtionalFileGroupId;
    private LocalDateTime creationDatetime;
    private LocalDateTime updatedDatetime;
    private LocalDateTime sentDatetime;
    private LocalDateTime receptionDatetime;
    private String creationUserId;
    private String updatedUserId;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    public String getSmartContractAddress() {
        return smartContractAddress;
    }
    public void setSmartContractAddress(String smartContractAddress) {
        this.smartContractAddress = smartContractAddress;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getContractStatus() {
        return contractStatus;
    }
    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }
    public String getTransferStatus() {
        return transferStatus;
    }
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }
    public String getOwnerAddress() {
        return ownerAddress;
    }
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
    public String getSenderAddress() {
        return senderAddress;
    }
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    public String getReceiverAddress() {
        return receiverAddress;
    }
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    public String getSenderBrokerAddress() {
        return senderBrokerAddress;
    }
    public void setSenderBrokerAddress(String senderBrokerAddress) {
        this.senderBrokerAddress = senderBrokerAddress;
    }
    public String getReceiverBrokerAddress() {
        return receiverBrokerAddress;
    }
    public void setReceiverBrokerAddress(String receiverBrokerAddress) {
        this.receiverBrokerAddress = receiverBrokerAddress;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getReceiverName() {
        return receiverName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    public String getSenderBrokerName() {
        return senderBrokerName;
    }
    public void setSenderBrokerName(String senderBrokerName) {
        this.senderBrokerName = senderBrokerName;
    }
    public String getReceiverBrokerName() {
        return receiverBrokerName;
    }
    public void setReceiverBrokerName(String receiverBrokerName) {
        this.receiverBrokerName = receiverBrokerName;
    }
    public String getContractFileName() {
        return contractFileName;
    }
    public void setContractFileName(String contractFileName) {
        this.contractFileName = contractFileName;
    }
    public String getContractFileHash() {
        return contractFileHash;
    }
    public void setContractFileHash(String contractFileHash) {
        this.contractFileHash = contractFileHash;
    }
    public String getContractFileLink() {
        return contractFileLink;
    }
    public void setContractFileLink(String contractFileLink) {
        this.contractFileLink = contractFileLink;
    }
    public String getFinalContractFileHash() {
        return finalContractFileHash;
    }
    public void setFinalContractFileHash(String finalContractFileHash) {
        this.finalContractFileHash = finalContractFileHash;
    }
    public String getFinalContractFileLink() {
        return finalContractFileLink;
    }
    public void setFinalContractFileLink(String finalContractFileLink) {
        this.finalContractFileLink = finalContractFileLink;
    }
    public String getAddtionalFileGroupId() {
        return addtionalFileGroupId;
    }
    public void setAddtionalFileGroupId(String addtionalFileGroupId) {
        this.addtionalFileGroupId = addtionalFileGroupId;
    }
    public LocalDateTime getCreationDatetime() {
        return creationDatetime;
    }
    public void setCreationDatetime(LocalDateTime creationDatetime) {
        this.creationDatetime = creationDatetime;
    }
    public LocalDateTime getUpdatedDatetime() {
        return updatedDatetime;
    }
    public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }
    public LocalDateTime getSentDatetime() {
        return sentDatetime;
    }
    public void setSentDatetime(LocalDateTime sentDatetime) {
        this.sentDatetime = sentDatetime;
    }
    public LocalDateTime getReceptionDatetime() {
        return receptionDatetime;
    }
    public void setReceptionDatetime(LocalDateTime receptionDatetime) {
        this.receptionDatetime = receptionDatetime;
    }
    public String getCreationUserId() {
        return creationUserId;
    }
    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }
    public String getUpdatedUserId() {
        return updatedUserId;
    }
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

}
