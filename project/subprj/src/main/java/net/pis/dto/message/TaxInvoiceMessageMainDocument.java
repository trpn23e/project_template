/**
 * (c)BOC
 */
package net.pis.dto.message;


/**
 * Created by achiz on 2015-01-15.
 */
public class TaxInvoiceMessageMainDocument extends MessageMainDocument {

    public enum DocumentType {

        /**
         * 세금 계산서
         */
        DTI("TaxInvoice"),
        /**
         * 거래 명세서
         */
        DTT("SpecificationOnTransaction");

        private String description;

        DocumentType(String arg) {
            this.description = arg;
        }

        public String getDescription() {
            return this.description;
        }

    }

}
