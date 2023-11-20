package com.example.coursework.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "issueattachments")
public class IssueAttachments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "attachmentid")
    private Long attachmentId;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contenttype")
    private String contentType; //расширение файла
    @Column(name = "ispreviewimage")
    private boolean isPreviewImage;
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Issue issue;

    public IssueAttachments(Long attachmentId, String fileName, Long size, String contentType, boolean isPreviewImage, byte[] bytes, Issue issue) {
        this.attachmentId = attachmentId;
        this.fileName = fileName;
        this.size = size;
        this.contentType = contentType;
        this.isPreviewImage = isPreviewImage;
        this.bytes = bytes;
        this.issue = issue;
    }

    public IssueAttachments() {
    }

    public Long getAttachmentId() {
        return this.attachmentId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Long getSize() {
        return this.size;
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean isPreviewImage() {
        return this.isPreviewImage;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public Issue getIssue() {
        return this.issue;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPreviewImage(boolean isPreviewImage) {
        this.isPreviewImage = isPreviewImage;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof IssueAttachments)) return false;
        final IssueAttachments other = (IssueAttachments) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$attachmentId = this.getAttachmentId();
        final Object other$attachmentId = other.getAttachmentId();
        if (this$attachmentId == null ? other$attachmentId != null : !this$attachmentId.equals(other$attachmentId))
            return false;
        final Object this$fileName = this.getFileName();
        final Object other$fileName = other.getFileName();
        if (this$fileName == null ? other$fileName != null : !this$fileName.equals(other$fileName)) return false;
        final Object this$size = this.getSize();
        final Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) return false;
        final Object this$contentType = this.getContentType();
        final Object other$contentType = other.getContentType();
        if (this$contentType == null ? other$contentType != null : !this$contentType.equals(other$contentType))
            return false;
        if (this.isPreviewImage() != other.isPreviewImage()) return false;
        if (!java.util.Arrays.equals(this.getBytes(), other.getBytes())) return false;
        final Object this$issue = this.getIssue();
        final Object other$issue = other.getIssue();
        if (this$issue == null ? other$issue != null : !this$issue.equals(other$issue)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IssueAttachments;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $attachmentId = this.getAttachmentId();
        result = result * PRIME + ($attachmentId == null ? 43 : $attachmentId.hashCode());
        final Object $fileName = this.getFileName();
        result = result * PRIME + ($fileName == null ? 43 : $fileName.hashCode());
        final Object $size = this.getSize();
        result = result * PRIME + ($size == null ? 43 : $size.hashCode());
        final Object $contentType = this.getContentType();
        result = result * PRIME + ($contentType == null ? 43 : $contentType.hashCode());
        result = result * PRIME + (this.isPreviewImage() ? 79 : 97);
        result = result * PRIME + java.util.Arrays.hashCode(this.getBytes());
        final Object $issue = this.getIssue();
        result = result * PRIME + ($issue == null ? 43 : $issue.hashCode());
        return result;
    }

    public String toString() {
        return "IssueAttachments(attachmentId=" + this.getAttachmentId() + ", fileName=" + this.getFileName() + ", size=" + this.getSize() + ", contentType=" + this.getContentType() + ", isPreviewImage=" + this.isPreviewImage() + ", bytes=" + java.util.Arrays.toString(this.getBytes()) + ", issue=" + this.getIssue() + ")";
    }
}
