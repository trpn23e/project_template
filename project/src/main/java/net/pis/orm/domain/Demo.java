
package net.pis.orm.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "DEMO_TBL")
@PersistenceContext(unitName = "DEMO")
public class Demo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CTR_SEQ")
    private Integer id;

    @Column(name = "CTR_NO")
    private String contractNumber;

    @Column(name = "CTR_ADR")
    private String smartContractAddress;
    @Column(name = "TX_ID")
    private String transactionId;

    @Column(name = "CTR_STAT")
    private String contractStatus;
    @Column(name = "TRN_STAT")
    private String transferStatus;

    @Column(name = "OWN_ADR")
    private String ownerAddress;
    @Column(name = "SND_ADR")
    private String senderAddress;
    @Column(name = "RCV_ADR")
    private String receiverAddress;
    @Column(name = "BRK_SND_ADR")
    private String senderBrokerAddress;
    @Column(name = "BRK_RCV_ADR")
    private String receiverBrokerAddress;

    @Column(name = "OWN_NM")
    private String ownerName;
    @Column(name = "SND_NM")
    private String senderName;
    @Column(name = "RCV_NM")
    private String receiverName;
    @Column(name = "BRK_SND_NM")
    private String senderBrokerName;
    @Column(name = "BRK_RCV_NM")
    private String receiverBrokerName;


    @Column(name = "CTR_FILE_NM")
    private String contractFileName;
    @Column(name = "CTR_FILE_HASH")
    private String contractFileHash;
    @Column(name = "CTR_FILE_LINK")
    private String contractFileLink;

    @Column(name = "CTR_FIN_FILE_HASH")
    private String finalContractFileHash;
    @Column(name = "CTR_FIN_FILE_LINK")
    private String finalContractFileLink;

    @Column(name = "ETC_FILE_GRP_ID")
    private String addtionalFileGroupId;

    @Column(name = "CDATE")
    private LocalDateTime creationDatetime;
    @Column(name = "UDATE")
    private LocalDateTime updatedDatetime;
    @Column(name = "SDATE")
    private LocalDateTime sentDatetime;
    @Column(name = "RDATE")
    private LocalDateTime receptionDatetime;

    @Column(name = "CUSR_ID")
    private String creationUserId;
    @Column(name = "UUSR_ID")
    private String updatedUserId;

    public Demo() {
    }

    @QueryProjection
    public Demo(String contractFileHash) {
        this.contractFileHash = contractFileHash;
    }

    @QueryProjection
    public Demo(int id, String contractStatus) {
        this.id = id;
        this.contractStatus = contractStatus;
    }
    @QueryProjection
    public Demo(String transactionId, String senderName, String senderBrokerName, String receiverName, String receiverBrokerName, String contractStatus, LocalDateTime updatedDatetime) {
        this.transactionId = transactionId;
        this.senderName = senderName;
        this.senderBrokerName = senderBrokerName;
        this.receiverName = receiverName;
        this.receiverBrokerName = receiverBrokerName;
        this.contractStatus = contractStatus;
        this.updatedDatetime = updatedDatetime;
    }
}
