/**
 * (c)BOC
 */
package net.pis.dto.message;

import java.util.List;

/**
 * 전자세금계산서 문서 데이타
 * <p>
 * 스마트빌로 전송되는 문서 전부이다. 본 클래스는 전자세금 계산서 데이타를 포함한다.</p>
 *
 * @author jh,Seo
 */
public interface TaxInvoiceMessageData extends MessageData {

    /**
     * BODY XML 중 메인 데이타를 제외한 XML 데이타를 반환한다.
     *
     * @return
     */
    List<TaxInvoiceMessageMetaDocument> getMessageMetaDocument();

    /**
     * BODY XML 중 메인 데이타(주로 세금계산서 원본)를 반환한다.
     *
     * @return
     */
    List<TaxInvoiceMessageMainDocument> getMessageMainDocument();

}
