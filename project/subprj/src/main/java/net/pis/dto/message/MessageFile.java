/**
 * (c)BOC
 */
package net.pis.dto.message;

import java.io.Serializable;

/**
 * 첨부파일 전송 데이타 DTO
 *
 * @author jh,Seo
 */
public class MessageFile implements Serializable {

    /**
     * 파일 구분
     */
    private String fileGubun;

    /**
     * 파일 순번
     */
    private String fileSeq;

    /**
     * 파일 명
     */
    private String fileName;

    /**
     * 파일 크기
     */
    private long fileSize;

    /**
     * 파일 데이타
     */
    private byte[] fileData;

    public String getFileGubun() {
        return fileGubun;
    }

    public void setFileGubun(String fileGubun) {
        this.fileGubun = fileGubun;
    }

    public String getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(String fileSeq) {
        this.fileSeq = fileSeq;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

}
