package com.glp;

import java.io.Serializable;
import java.util.List;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 授信额度
 *
 * @author LeonLiang
 * @date 2017-7-14
 */
public class CreditLine implements BizData<Long>,Serializable {

    private static final long serialVersionUID = 8149899168474817586L;

    private Long id;
    private Long applicationId; // 申请id
    private Integer status; // 状态
    private String code; // 额度编码
    private Long productId; // 产品id
    private String productLine; // 产品线
    private String bizType; // 业务类型
    private String actualBizType; //实际产品类型
    private String type; // 类型（循环额度、非循环额度）
    private String relationType; //NULL:直接额度, PARENT:父额度, SUB:子额度
    private String parentCode; //父额度编码, relation_type为SUB时有值
    private String initParentCode; //初始父额度编码
    private Double appliedAmount; // 申请额度（元）
    private Double approvedAmount; // 获批额度（元）
    private Double availableAmount; // 可用额度金额（元）
    private Double occupationAmount; // 用信占用额度（元）
    private Double frozenAmount; // 冻结额度（元）
    private Long approvedTime; // 审批通过时间
    private Long signTime; // 签约时间
    private Long effectiveTime; // 生效时间
    private Long expireTime; // 失效时间
    private Integer validPeriod; // 有效期限（月数）
    private Long customerId; // 客户id
    private String customerType;

    private String isBiddingConform; // 是否符合报价方案（字典YES、NO）
    private String contractStructure; // 合同结构
    private String occupationTerm; // 用信前提
    private String paymentTerm; // 对外付款前提
    private String contractTerm; // 合同生效前提
    private String distributionType;    //分配方式
    private String assetManagementAdvice; // 贷后管理建议
    private String anyOtherBusiness; // 其他事项
    private Long rmId; // 风控经理id
    private String rmName; // 风控经理名称
    private Long cmId; // 客户经理id
    private String cmName; // 客户经理名称
    private String clearMark; // 结清标志
    private String currency; // 币种
    private Long createTime;
    private Long updateTime;

    private String sourceCode;
    private String productName; //产品名称
    private String total;
    private String exceedMode; //超发模式
    private Long modifiedCreditId;//被修改的额度id

    // 自定义字段
  //  private List<AttributeValueDTO> attributeList;


    /*******增加字段********/
    //系统建议额度
    private double adviceQuota; //平台建议额度
    /*******增加字段********/


    /***对接统一额度新增加字段***/

    private String ecifId;            //ecfi客户编号
    private String customerCode;            //ecfi客户编号
    private String customerName;      //客户名称
    private String creditCode;        // 额度编码

    private String guaranteeMeasure; // 担保措施（多个以，隔开）
    private String parentCustomerName; //父额度客户名称
    /** 统一额度 额度编码 **/
    private String unionCode;
    private String productCode; //产品Code
    private String productMode; //额度关系
    private String businessType;        // 融资产品
    private String financeMode; //金融模式
    private String creditName;        //额度名称
    private int clearFlag;              // 结清标志
    private String effectivePeriodUnit; //额度期限单位 D 天 M 月 Y 年
    private Integer   effectivePeriod;     //有效期
    private String parentCreditCode;    // 担保额度或者渠道额度编号relationType为子额度时有值
    private String loopType;            // 是否循环额度：CYCLE 循环 NON_CYCLIC 非循环
    private Long effectiveDate;         // 生效日期
    private Long expireDate;            // 失效日期
    private String applyType;           //申请类型ADD新增  MOD重审
    private  String modType;     //重审类型 :CREDIT_EXTENSION  续授信:  SCHEME_MOD授信方案修改
    private String periodType;          //期限类型  固定期限：FIXED_TERM 固定到期日：FIXED_DATE
    private String validEndDate;        // 有效到期日期
    private String allocateType;        // 分配方式：GRANT 授信  USE 用信relationType为担保额度、渠道额度时有值
    private String guaranteeType;         //占用额度属性  GUARANTEE	保证担保额度  CHANNEL	渠道额度
    private String lendingChannel;      //放款通道  // 放款渠道：保理系统 FACTORING、租赁系统 LEASE、小贷系统 LOAN、供应链系统 SUPPLY_CHAIN

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Long effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    /***对接统一额度新增加字段***/























    public CreditLine(){}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditLine other = (CreditLine) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(Double appliedAmount) {
        this.appliedAmount = appliedAmount;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Double getOccupationAmount() {
        return occupationAmount;
    }

    public void setOccupationAmount(Double occupationAmount) {
        this.occupationAmount = occupationAmount;
    }

    public Double getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Double frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public void setEffectiveTime(Long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Integer validPeriod) {
        this.validPeriod = validPeriod;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getGuaranteeMeasure() {
        return guaranteeMeasure;
    }

    public void setGuaranteeMeasure(String guaranteeMeasure) {
        this.guaranteeMeasure = guaranteeMeasure;
    }

    public String getContractStructure() {
        return contractStructure;
    }

    public void setContractStructure(String contractStructure) {
        this.contractStructure = contractStructure;
    }

    public String getOccupationTerm() {
        return occupationTerm;
    }

    public void setOccupationTerm(String occupationTerm) {
        this.occupationTerm = occupationTerm;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(String contractTerm) {
        this.contractTerm = contractTerm;
    }

    public String getAssetManagementAdvice() {
        return assetManagementAdvice;
    }

    public void setAssetManagementAdvice(String assetManagementAdvice) {
        this.assetManagementAdvice = assetManagementAdvice;
    }

    public String getAnyOtherBusiness() {
        return anyOtherBusiness;
    }

    public void setAnyOtherBusiness(String anyOtherBusiness) {
        this.anyOtherBusiness = anyOtherBusiness;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsBiddingConform() {
        return isBiddingConform;
    }

    public void setIsBiddingConform(String isBiddingConform) {
        this.isBiddingConform = isBiddingConform;
    }

    public Long getRmId() {
        return rmId;
    }

    public void setRmId(Long rmId) {
        this.rmId = rmId;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public Long getCmId() {
        return cmId;
    }

    public void setCmId(Long cmId) {
        this.cmId = cmId;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getClearMark() {
        return clearMark;
    }

    public void setClearMark(String clearMark) {
        this.clearMark = clearMark;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

//    public List<AttributeValueDTO> getAttributeList() {
//        return attributeList;
//    }
//
//    public void setAttributeList(List<AttributeValueDTO> attributeList) {
//        this.attributeList = attributeList;
//    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(Long approvedTime) {
        this.approvedTime = approvedTime;
    }

    public Long getSignTime() {
        return signTime;
    }

    public void setSignTime(Long signTime) {
        this.signTime = signTime;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCustomerName() {
        return parentCustomerName;
    }

    public void setParentCustomerName(String parentCustomerName) {
        this.parentCustomerName = parentCustomerName;
    }

    public String getInitParentCode() {
        return initParentCode;
    }

    public void setInitParentCode(String initParentCode) {
        this.initParentCode = initParentCode;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getActualBizType() {
        return actualBizType;
    }

    public void setActualBizType(String actualBizType) {
        this.actualBizType = actualBizType;
    }

    public String getExceedMode() {
        return exceedMode;
    }

    public void setExceedMode(String exceedMode) {
        this.exceedMode = exceedMode;
    }

    public Long getModifiedCreditId() {
        return modifiedCreditId;
    }

    public void setModifiedCreditId(Long modifiedCreditId) {
        this.modifiedCreditId = modifiedCreditId;
    }

    public double getAdviceQuota() {
        return adviceQuota;
    }

    public void setAdviceQuota(double adviceQuota) {
        this.adviceQuota = adviceQuota;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(String validEndDate) {
        this.validEndDate = validEndDate;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getParentCreditCode() {
        return parentCreditCode;
    }

    public void setParentCreditCode(String parentCreditCode) {
        this.parentCreditCode = parentCreditCode;
    }

    public String getAllocateType() {
        return allocateType;
    }

    public void setAllocateType(String allocateType) {
        this.allocateType = allocateType;
    }

    public String getLoopType() {
        return loopType;
    }

    public void setLoopType(String loopType) {
        this.loopType = loopType;
    }

    public String getEffectivePeriodUnit() {
        return effectivePeriodUnit;
    }

    public void setEffectivePeriodUnit(String effectivePeriodUnit) {
        this.effectivePeriodUnit = effectivePeriodUnit;
    }

    public String getLendingChannel() {
        return lendingChannel;
    }

    public void setLendingChannel(String lendingChannel) {
        this.lendingChannel = lendingChannel;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getFinanceMode() {
        return financeMode;
    }

    public void setFinanceMode(String financeMode) {
        this.financeMode = financeMode;
    }

    public String getEcifId() {
        return ecifId;
    }

    public void setEcifId(String ecifId) {
        this.ecifId = ecifId;
    }


    public String getUnionCode() {
        return unionCode;
    }

    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getCustomerName() {
        return customerName;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getEffectiveTime() {
        return effectiveTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getProductMode() {
        return productMode;
    }

    public void setProductMode(String productMode) {
        this.productMode = productMode;
    }


    public Integer getEffectivePeriod() {
        return effectivePeriod;
    }

    public void setEffectivePeriod(Integer effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    public int getClearFlag() {
        return clearFlag;
    }

    public void setClearFlag(int clearFlag) {
        this.clearFlag = clearFlag;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getModType() {
        return modType;
    }

    public void setModType(String modType) {
        this.modType = modType;
    }
}
