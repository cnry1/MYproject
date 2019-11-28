package com.glp;

import java.math.BigDecimal;

import lombok.experimental.PackagePrivate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 统一额度 设立 重申 更新 数据封装对象
 */
public class SingleUnionCreditVO {
    private String sourceCode;          // 额度申请来源：COLLIE 柯力 , LOAN 小贷
    private String customerCode;        // ECIF客户编号
    private String customerName;        // 客户名称
    private String creditCode;          // 额度编号
    private String creditType;          // 额度属性：COMPREHENSIVE:综合授信,NORMAL:普通额度
    private String lendingChannel;      // 放款渠道：保理系统 FACTORING、租赁系统 LEASE、小贷系统 LOAN、供应链系统 SUPPLY_CHAIN
    private String productCode;         //产品代码
    private String businessType;        // 融资产品
    private String financeMode;         // 金融模式：
    private String productMode;         //产品模式
    private String relationType;        // 额度关系 直接额度 INDEPENDENCE ，担保额度 PARENT，子额度 SUB，渠道额度 CHANNEL
    private String parentCreditCode;    // 担保额度或者渠道额度编号relationType为子额度时有值
    private String allocateType;        // 分配方式：GRANT 授信  USE 用信relationType为担保额度、渠道额度时有值
    private String loopType;            // 是否循环额度：CYCLE 循环 NON_CYCLIC 非循环
    private Long effectiveDate;         // 生效日期
    private Long expireDate;            // 失效日期
    private String currency;            // 额度币种
    private BigDecimal amount;          // 额度金额
    private BigDecimal applyAmount;     //申请金额
    private BigDecimal appliedAmount;     //申请金额(柯利)
    private BigDecimal approvedAmount;   // 获批金额取值为 amount一致
    private String status;              // 额度状态：4 待签约、1 生效、2失效、3 已终结
    private BigDecimal frozenAmount;    // 冻结金额
    private Integer effectivePeriod;        // 额度期限
    private String effectivePeriodUnit; // 额度期限单位 D 天 M 月 Y 年
    private String cmName;              // 客户经理名称
    private String rmName;              // 风控名称
    private String creditDisableType;   // 失效类型
    private int clearFlag;              // 结清标志
    private Long approvedTime;          //获批时间
    private String customerType;        //客户类型
    private BigDecimal availableAmount; //可分配余额（综合授信、担保额度、渠道额度适用）
    private Long createTime;            //创建时间
    private String applyType;           //操作类型
    private String applyNo;             //申请编号
    private String parentCustomerName;  //父额度所属客户名称
    private Long applyTime;             //申请时间
    private String parentApplyNo;       // 父额度申请单编号

    public String getParentApplyNo() {
        return parentApplyNo;
    }

    public void setParentApplyNo(String parentApplyNo) {
        this.parentApplyNo = parentApplyNo;
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public String getParentCustomerName() {
        return parentCustomerName;
    }

    public void setParentCustomerName(String parentCustomerName) {
        this.parentCustomerName = parentCustomerName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getLendingChannel() {
        return lendingChannel;
    }

    public void setLendingChannel(String lendingChannel) {
        this.lendingChannel = lendingChannel;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getFinanceMode() {
        return financeMode;
    }

    public void setFinanceMode(String financeMode) {
        this.financeMode = financeMode;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public Integer getEffectivePeriod() {
        return effectivePeriod;
    }

    public void setEffectivePeriod(Integer effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    public String getEffectivePeriodUnit() {
        return effectivePeriodUnit;
    }

    public void setEffectivePeriodUnit(String effectivePeriodUnit) {
        this.effectivePeriodUnit = effectivePeriodUnit;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getCreditDisableType() {
        return creditDisableType;
    }

    public void setCreditDisableType(String creditDisableType) {
        this.creditDisableType = creditDisableType;
    }

    public int getClearFlag() {
        return clearFlag;
    }

    public void setClearFlag(int clearFlag) {
        this.clearFlag = clearFlag;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(Long approvedTime) {
        this.approvedTime = approvedTime;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getProductMode() {
        return productMode;
    }

    public void setProductMode(String productMode) {
        this.productMode = productMode;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public BigDecimal getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(BigDecimal appliedAmount) {
        this.appliedAmount = appliedAmount;
    }
}


