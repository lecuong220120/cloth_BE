package com.project_be.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @CreatedDate
    @Column(name = "regDate")
    private Date regDate;
    @CreatedBy
    @Column(name = "regAccount")
    private Long regAccount;
    @LastModifiedDate
    @Column(name = "modDate")
    private Date modDate;
    @LastModifiedBy
    @Column(name = "modAccount")
    private Long modAccount;
    @Column(name = "delFlag")
    private Boolean delFlag = false;

    public boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Long getRegAccount() {
        return regAccount;
    }

    public void setRegAccount(Long regAccount) {
        this.regAccount = regAccount;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public Long getModAccount() {
        return modAccount;
    }

    public void setModAccount(Long modAccount) {
        this.modAccount = modAccount;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
