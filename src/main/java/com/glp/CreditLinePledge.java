package com.glp;

import java.io.Serializable;
import java.util.List;

import java.io.Serializable;
import java.util.List;
/**
 * 额度-现货质押 明细
 * @author LeonLiang
 * @date 2017-7-14
 */
public class CreditLinePledge   implements Serializable {

    private static final long serialVersionUID = 8253856780838634193L;

    private Long id;
    private Long creditId; //对应creditLine的id
    private String unionCode; //统一额度编码
    private String regulatory; //合作监管方
    private String recoveryMode; //利息回收方式
    private String scheme; //贷后管理方案
    private String category; //质押产品品类
    private Double pledgeRate; //质押率
    private Integer period; //最大融资期限（天）
    private Integer periodSection; //期限分段
    private Double feeRate; //最低手续费比例
    private Double nominalInterestRate; //名义利率（年化）
    private Double actualInterestRate; //实际利率
    private Double irr;
    private Double lirr;
    private Long createTime;

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    private     String creditCode;          // 额度编号
//    //现货质押-合作伙伴
//    private List<CreditLinePledgeBp> creditLinePledgeBp;
//    //担保人
//    private List<CreditLineGuarantor> creditLineGuarantor;
//    //期限分段
//    private List<CreditLinePeriodSection> creditLinePeriodSection;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CreditLinePledge other = (CreditLinePledge) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreditId() {
        return creditId;
    }
    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }
    public String getRegulatory() {
        return regulatory;
    }
    public void setRegulatory(String regulatory) {
        this.regulatory = regulatory;
    }
    public String getRecoveryMode() {
        return recoveryMode;
    }
    public void setRecoveryMode(String recoveryMode) {
        this.recoveryMode = recoveryMode;
    }
    public String getScheme() {
        return scheme;
    }
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getPledgeRate() {
        return pledgeRate;
    }
    public void setPledgeRate(Double pledgeRate) {
        this.pledgeRate = pledgeRate;
    }
    public Integer getPeriod() {
        return period;
    }
    public void setPeriod(Integer period) {
        this.period = period;
    }
    public Double getFeeRate() {
        return feeRate;
    }
    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }
    public Double getNominalInterestRate() {
        return nominalInterestRate;
    }
    public void setNominalInterestRate(Double nominalInterestRate) {
        this.nominalInterestRate = nominalInterestRate;
    }
    public Double getActualInterestRate() {
        return actualInterestRate;
    }
    public void setActualInterestRate(Double actualInterestRate) {
        this.actualInterestRate = actualInterestRate;
    }
    public Double getIrr() {
        return irr;
    }
    public void setIrr(Double irr) {
        this.irr = irr;
    }
    public Double getLirr() {
        return lirr;
    }
    public void setLirr(Double lirr) {
        this.lirr = lirr;
    }
    public Integer getPeriodSection() {
        return periodSection;
    }
    public void setPeriodSection(Integer periodSection) {
        this.periodSection = periodSection;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
//    public List<CreditLinePledgeBp> getCreditLinePledgeBp() {
//        return creditLinePledgeBp;
//    }
//    public void setCreditLinePledgeBp(List<CreditLinePledgeBp> creditLinePledgeBp) {
//        this.creditLinePledgeBp = creditLinePledgeBp;
//    }
//    public List<CreditLineGuarantor> getCreditLineGuarantor() {
//        return creditLineGuarantor;
//    }
//    public void setCreditLineGuarantor(List<CreditLineGuarantor> creditLineGuarantor) {
//        this.creditLineGuarantor = creditLineGuarantor;
//    }
//    public List<CreditLinePeriodSection> getCreditLinePeriodSection() {
//        return creditLinePeriodSection;
//    }
//    public void setCreditLinePeriodSection(List<CreditLinePeriodSection> creditLinePeriodSection) {
//        this.creditLinePeriodSection = creditLinePeriodSection;
//    }

    public String getUnionCode() {
        return unionCode;
    }

    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }
}
