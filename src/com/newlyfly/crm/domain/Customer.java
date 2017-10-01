package com.newlyfly.crm.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by llf in 15:09 2017/9/29
 */
@Entity
public class Customer {
    private Long custId;
    private String custName;
    private Long custUserId;
    private Long custCreateId;
    private String custSource;
    private String custIndustry;
    private String custLevel;
//    private String custLinkman;
    private Set<LinkMan> custLinkman = new HashSet<LinkMan>();
    private String custPhone;
    private String custMobile;
    private String custZipcode;
    private String custAddress;
    private Date custCreatetime;
    private String custFax;
    private String custWebsite;

    @Id
    @Column(name = "cust_id")
    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "cust_user_id")
    public Long getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(Long custUserId) {
        this.custUserId = custUserId;
    }

    @Basic
    @Column(name = "cust_create_id")
    public Long getCustCreateId() {
        return custCreateId;
    }

    public void setCustCreateId(Long custCreateId) {
        this.custCreateId = custCreateId;
    }

    @Basic
    @Column(name = "cust_source")
    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    @Basic
    @Column(name = "cust_industry")
    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    @Basic
    @Column(name = "cust_level")
    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

//    @Basic
//    @Column(name = "cust_linkman")
//    public String getCustLinkman() {
//        return custLinkman;
//    }
//
//    public void setCustLinkman(String custLinkman) {
//        this.custLinkman = custLinkman;
//    }


    @OneToMany
    public Set<LinkMan> getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(Set<LinkMan> custLinkman) {
        this.custLinkman = custLinkman;
    }

    @Basic
    @Column(name = "cust_phone")
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Basic
    @Column(name = "cust_mobile")
    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    @Basic
    @Column(name = "cust_zipcode")
    public String getCustZipcode() {
        return custZipcode;
    }

    public void setCustZipcode(String custZipcode) {
        this.custZipcode = custZipcode;
    }

    @Basic
    @Column(name = "cust_address")
    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Basic
    @Column(name = "cust_createtime")
    public Date getCustCreatetime() {
        return custCreatetime;
    }

    public void setCustCreatetime(Date custCreatetime) {
        this.custCreatetime = custCreatetime;
    }

    @Basic
    @Column(name = "cust_fax")
    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    @Basic
    @Column(name = "cust_website")
    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (custId != null ? !custId.equals(customer.custId) : customer.custId != null) return false;
        if (custName != null ? !custName.equals(customer.custName) : customer.custName != null) return false;
        if (custUserId != null ? !custUserId.equals(customer.custUserId) : customer.custUserId != null) return false;
        if (custCreateId != null ? !custCreateId.equals(customer.custCreateId) : customer.custCreateId != null)
            return false;
        if (custSource != null ? !custSource.equals(customer.custSource) : customer.custSource != null) return false;
        if (custIndustry != null ? !custIndustry.equals(customer.custIndustry) : customer.custIndustry != null)
            return false;
        if (custLevel != null ? !custLevel.equals(customer.custLevel) : customer.custLevel != null) return false;
        if (custLinkman != null ? !custLinkman.equals(customer.custLinkman) : customer.custLinkman != null)
            return false;
        if (custPhone != null ? !custPhone.equals(customer.custPhone) : customer.custPhone != null) return false;
        if (custMobile != null ? !custMobile.equals(customer.custMobile) : customer.custMobile != null) return false;
        if (custZipcode != null ? !custZipcode.equals(customer.custZipcode) : customer.custZipcode != null)
            return false;
        if (custAddress != null ? !custAddress.equals(customer.custAddress) : customer.custAddress != null)
            return false;
        if (custCreatetime != null ? !custCreatetime.equals(customer.custCreatetime) : customer.custCreatetime != null)
            return false;
        if (custFax != null ? !custFax.equals(customer.custFax) : customer.custFax != null) return false;
        return custWebsite != null ? custWebsite.equals(customer.custWebsite) : customer.custWebsite == null;
    }

    @Override
    public int hashCode() {
        int result = custId != null ? custId.hashCode() : 0;
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        result = 31 * result + (custUserId != null ? custUserId.hashCode() : 0);
        result = 31 * result + (custCreateId != null ? custCreateId.hashCode() : 0);
        result = 31 * result + (custSource != null ? custSource.hashCode() : 0);
        result = 31 * result + (custIndustry != null ? custIndustry.hashCode() : 0);
        result = 31 * result + (custLevel != null ? custLevel.hashCode() : 0);
        result = 31 * result + (custLinkman != null ? custLinkman.hashCode() : 0);
        result = 31 * result + (custPhone != null ? custPhone.hashCode() : 0);
        result = 31 * result + (custMobile != null ? custMobile.hashCode() : 0);
        result = 31 * result + (custZipcode != null ? custZipcode.hashCode() : 0);
        result = 31 * result + (custAddress != null ? custAddress.hashCode() : 0);
        result = 31 * result + (custCreatetime != null ? custCreatetime.hashCode() : 0);
        result = 31 * result + (custFax != null ? custFax.hashCode() : 0);
        result = 31 * result + (custWebsite != null ? custWebsite.hashCode() : 0);
        return result;
    }
}
