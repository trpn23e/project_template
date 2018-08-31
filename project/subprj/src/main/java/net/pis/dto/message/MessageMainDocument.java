/**
 * (c)BOC
 */
package net.pis.dto.message;

import java.io.Serializable;
import java.util.Date;

/**
 * 본문 XML 데이타 DTO
 *
 * @author jh,Seo
 */
public class MessageMainDocument implements Serializable {

    private static final long serialVersionUID = 7188551124519731581L;
    private String documentDataId;
    private String messageTagId;
    private int seq;
    private Enum<?> documentType;
    private String documentData;
    private Date regTimestamp;

    public String getMessageTagId() {
        return messageTagId;
    }

    public void setMessageTagId(String messageTagId) {
        this.messageTagId = messageTagId;
    }

    public String getDocumentData() {
        return documentData;
    }

    public void setDocumentData(String documentData) {
        this.documentData = documentData;
    }

    public Date getRegTimestamp() {
        return regTimestamp;
    }

    public void setRegTimestamp(Date regTimestamp) {
        this.regTimestamp = regTimestamp;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public Enum<?> getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Enum<?> documentType) {
        this.documentType = documentType;
    }

    public String getDocumentDataId() {
        return documentDataId;
    }

    public void setDocumentDataId(String documentDataId) {
        this.documentDataId = documentDataId;
    }
}
