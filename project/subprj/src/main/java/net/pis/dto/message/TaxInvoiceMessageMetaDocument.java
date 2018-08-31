/**
 * (c)BOC
 */
package net.pis.dto.message;


/**
 * Created by achiz on 2015-01-15.
 */
public class TaxInvoiceMessageMetaDocument extends MessageMainDocument {

    public enum DocumentType {

        /**
         * 검증
         */
        Rvalue("Rvalue"),
        /**
         * 상태변경
         */
        Status("Status"),
        /**
         * 이메일수신
         */
        Util("Util"),
        /**
         * from INTERFACE
         */
        Interface("Interface");

        private String code;

        DocumentType(String arg) {
            this.code = arg;
        }

        public String getCode() {
            return this.code;
        }

    }

}
