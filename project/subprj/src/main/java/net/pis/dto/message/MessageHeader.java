/**
 * (c)BOC
 */
package net.pis.dto.message;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jh,Seo
 */
public class MessageHeader implements Serializable {

    /**
     * MESSAGE 트랜잭션 ID (UUID)
     */
    private String messageId;
    /**
     * 데이타 시그널
     */
    private String signal;

    /**
     * 요청 시간
     */
    private Date reqTime;
    /**
     * 송신 사업자 등록 번호
     */
    private String sndComregno;
    /**
     * 수신 사업자 등록 번호
     */
    private String rcvComregno;
    /**
     * 인증 토큰
     */
    private String authTicket;
    /**
     * 서비스 코드 (DTI or DCT)
     */
    private String serviceCode;
    /**
     * SBMS 업무 시스템 종류(SAP/Non-SAP)
     */
    private String systemType;
    /**
     * 스마트빌 관리 ID
     */
    private String conversationId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public String getSndComregno() {
        return sndComregno;
    }

    public void setSndComregno(String sndComregno) {
        this.sndComregno = sndComregno;
    }

    public String getRcvComregno() {
        return rcvComregno;
    }

    public void setRcvComregno(String rcvComregno) {
        this.rcvComregno = rcvComregno;
    }

    public String getAuthTicket() {
        return authTicket;
    }

    public void setAuthTicket(String authTicket) {
        this.authTicket = authTicket;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

}
