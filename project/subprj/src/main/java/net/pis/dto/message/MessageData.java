/*
 * (c)BOC
 */
package net.pis.dto.message;

import java.util.List;

/**
 *
 * @author jh,seo
 */
public interface MessageData extends SBMessage {

    /**
     * 헤더 데이타를 반환한다.
     *
     * @return
     */
    MessageHeader getMessageHeader();

    /**
     * 파일 데이타를 반환한다.
     *
     * @return
     */
    List<MessageFile> getMessageFiles();

}
