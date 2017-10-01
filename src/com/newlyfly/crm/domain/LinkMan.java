package com.newlyfly.crm.domain;

import javax.persistence.*;

/**
 * Created by llf in 14:58 2017/9/29
 */
@Entity
@Table(name = "link_man", schema = "crm", catalog = "")
public class LinkMan {
    private Long lkmId;
    private String lkmName;
    private String lkmGender;
    private Integer lkmPhone;
    private Integer lkmMobile;
    private Customer custId;

    @Id
    @Column(name = "lkm_id")
    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    @Basic
    @Column(name = "lkm_name")
    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    @Basic
    @Column(name = "lkm_gender")
    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    @Basic
    @Column(name = "lkm_phone")
    public Integer getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(Integer lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    @Basic
    @Column(name = "lkm_mobile")
    public Integer getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(Integer lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    @ManyToOne
    @JoinColumn
    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkMan linkMan = (LinkMan) o;

        if (lkmId != null ? !lkmId.equals(linkMan.lkmId) : linkMan.lkmId != null) return false;
        if (lkmName != null ? !lkmName.equals(linkMan.lkmName) : linkMan.lkmName != null) return false;
        if (lkmGender != null ? !lkmGender.equals(linkMan.lkmGender) : linkMan.lkmGender != null) return false;
        if (lkmPhone != null ? !lkmPhone.equals(linkMan.lkmPhone) : linkMan.lkmPhone != null) return false;
        if (lkmMobile != null ? !lkmMobile.equals(linkMan.lkmMobile) : linkMan.lkmMobile != null) return false;
        return custId != null ? custId.equals(linkMan.custId) : linkMan.custId == null;
    }

    @Override
    public int hashCode() {
        int result = lkmId != null ? lkmId.hashCode() : 0;
        result = 31 * result + (lkmName != null ? lkmName.hashCode() : 0);
        result = 31 * result + (lkmGender != null ? lkmGender.hashCode() : 0);
        result = 31 * result + (lkmPhone != null ? lkmPhone.hashCode() : 0);
        result = 31 * result + (lkmMobile != null ? lkmMobile.hashCode() : 0);
        result = 31 * result + (custId != null ? custId.hashCode() : 0);
        return result;
    }
}
