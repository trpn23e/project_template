/*
 * (c)BOC
 */
package net.pis.dto.message;

import net.pis.message.MessageMetaInfo;

/**
 *
 * @author jh,seo
 */
public interface SBMessage {

    /**
     * 메세지에 대한 메타 정보를 반환한다.
     *
     * @return
     */
    MessageMetaInfo toMessageMetaInfo();

}
