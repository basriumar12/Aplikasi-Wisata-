package id.co.blogbasbas.wisatasemarang.model;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionDto implements Serializable {
    private static final long serialVersionUID = -766492607595571321L;
    private Long id;
    private String billId;
    private Date transactionDate;
    private Long storeId;
    private Long merchantId;
    private String customerType;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String merchantName;
    private String storeName;
    private String storeAddress1;
    private String storeAddress2;
    private String storeAddress3;
    private String storeReceiptRemark;
    private String storeReceiptRemark2;
    private String storePhone;
    private String storeNpwp;
    private String userFullname;
    private Integer totalItem;
    private BigDecimal itemsAmount;
    private BigDecimal cashDiscountAmount;
    private BigDecimal salesDiscountAmount;
    private BigDecimal extraDiscountAmount;
    private BigDecimal ppnAmount;
    private BigDecimal serviceTaxAmount;
    private BigDecimal subtotalAmount;
    private BigDecimal pb1TaxAmount;
    private BigDecimal totalAmount;
    private BigDecimal roundOffAmount;
    private BigDecimal shippingAmount;
    private BigDecimal finalAmount;
    private BigDecimal billAmount;
    private BigDecimal changeAmount;
    private String transactionStatus;
    private String userActRefId;
    private List<TransactionDetailsDto> details;
    private List<String> orders;
    private int tableNumber;
    private String paymentType;
    private RefBankDto bank;
    private String cardType;
    private String cardNumber;
    private String approvalCode;
    private String struk;
    private Integer version;
    private String userId;

    public static TransactionDto.TransactionDtoBuilder builder() {
        return new TransactionDto.TransactionDtoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getBillId() {
        return this.billId;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public String getCustomerType() {
        return this.customerType;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public String getStoreAddress1() {
        return this.storeAddress1;
    }

    public String getStoreAddress2() {
        return this.storeAddress2;
    }

    public String getStoreAddress3() {
        return this.storeAddress3;
    }

    public String getStoreReceiptRemark() {
        return this.storeReceiptRemark;
    }

    public String getStoreReceiptRemark2() {
        return this.storeReceiptRemark2;
    }

    public String getStorePhone() {
        return this.storePhone;
    }

    public String getStoreNpwp() {
        return this.storeNpwp;
    }

    public String getUserFullname() {
        return this.userFullname;
    }

    public Integer getTotalItem() {
        return this.totalItem;
    }

    public BigDecimal getItemsAmount() {
        return this.itemsAmount;
    }

    public BigDecimal getCashDiscountAmount() {
        return this.cashDiscountAmount;
    }

    public BigDecimal getSalesDiscountAmount() {
        return this.salesDiscountAmount;
    }

    public BigDecimal getExtraDiscountAmount() {
        return this.extraDiscountAmount;
    }

    public BigDecimal getPpnAmount() {
        return this.ppnAmount;
    }

    public BigDecimal getServiceTaxAmount() {
        return this.serviceTaxAmount;
    }

    public BigDecimal getSubtotalAmount() {
        return this.subtotalAmount;
    }

    public BigDecimal getPb1TaxAmount() {
        return this.pb1TaxAmount;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public BigDecimal getRoundOffAmount() {
        return this.roundOffAmount;
    }

    public BigDecimal getShippingAmount() {
        return this.shippingAmount;
    }

    public BigDecimal getFinalAmount() {
        return this.finalAmount;
    }

    public BigDecimal getBillAmount() {
        return this.billAmount;
    }

    public BigDecimal getChangeAmount() {
        return this.changeAmount;
    }

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public String getUserActRefId() {
        return this.userActRefId;
    }

    public List<TransactionDetailsDto> getDetails() {
        return this.details;
    }

    public List<String> getOrders() {
        return this.orders;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public RefBankDto getBank() {
        return this.bank;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getApprovalCode() {
        return this.approvalCode;
    }

    public String getStruk() {
        return this.struk;
    }

    public Integer getVersion() {
        return this.version;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setBillId(final String billId) {
        this.billId = billId;
    }

    public void setTransactionDate(final Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setStoreId(final Long storeId) {
        this.storeId = storeId;
    }

    public void setMerchantId(final Long merchantId) {
        this.merchantId = merchantId;
    }

    public void setCustomerType(final String customerType) {
        this.customerType = customerType;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(final String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setMerchantName(final String merchantName) {
        this.merchantName = merchantName;
    }

    public void setStoreName(final String storeName) {
        this.storeName = storeName;
    }

    public void setStoreAddress1(final String storeAddress1) {
        this.storeAddress1 = storeAddress1;
    }

    public void setStoreAddress2(final String storeAddress2) {
        this.storeAddress2 = storeAddress2;
    }

    public void setStoreAddress3(final String storeAddress3) {
        this.storeAddress3 = storeAddress3;
    }

    public void setStoreReceiptRemark(final String storeReceiptRemark) {
        this.storeReceiptRemark = storeReceiptRemark;
    }

    public void setStoreReceiptRemark2(final String storeReceiptRemark2) {
        this.storeReceiptRemark2 = storeReceiptRemark2;
    }

    public void setStorePhone(final String storePhone) {
        this.storePhone = storePhone;
    }

    public void setStoreNpwp(final String storeNpwp) {
        this.storeNpwp = storeNpwp;
    }

    public void setUserFullname(final String userFullname) {
        this.userFullname = userFullname;
    }

    public void setTotalItem(final Integer totalItem) {
        this.totalItem = totalItem;
    }

    public void setItemsAmount(final BigDecimal itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    public void setCashDiscountAmount(final BigDecimal cashDiscountAmount) {
        this.cashDiscountAmount = cashDiscountAmount;
    }

    public void setSalesDiscountAmount(final BigDecimal salesDiscountAmount) {
        this.salesDiscountAmount = salesDiscountAmount;
    }

    public void setExtraDiscountAmount(final BigDecimal extraDiscountAmount) {
        this.extraDiscountAmount = extraDiscountAmount;
    }

    public void setPpnAmount(final BigDecimal ppnAmount) {
        this.ppnAmount = ppnAmount;
    }

    public void setServiceTaxAmount(final BigDecimal serviceTaxAmount) {
        this.serviceTaxAmount = serviceTaxAmount;
    }

    public void setSubtotalAmount(final BigDecimal subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }

    public void setPb1TaxAmount(final BigDecimal pb1TaxAmount) {
        this.pb1TaxAmount = pb1TaxAmount;
    }

    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setRoundOffAmount(final BigDecimal roundOffAmount) {
        this.roundOffAmount = roundOffAmount;
    }

    public void setShippingAmount(final BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public void setFinalAmount(final BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public void setBillAmount(final BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public void setChangeAmount(final BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public void setTransactionStatus(final String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public void setUserActRefId(final String userActRefId) {
        this.userActRefId = userActRefId;
    }

    public void setDetails(final List<TransactionDetailsDto> details) {
        this.details = details;
    }

    public void setOrders(final List<String> orders) {
        this.orders = orders;
    }

    public void setTableNumber(final int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setPaymentType(final String paymentType) {
        this.paymentType = paymentType;
    }

    public void setBank(final RefBankDto bank) {
        this.bank = bank;
    }

    public void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    public void setCardNumber(final String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setApprovalCode(final String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public void setStruk(final String struk) {
        this.struk = struk;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TransactionDto)) {
            return false;
        } else {
            TransactionDto other = (TransactionDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label567: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label567;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label567;
                    }

                    return false;
                }

                Object this$billId = this.getBillId();
                Object other$billId = other.getBillId();
                if (this$billId == null) {
                    if (other$billId != null) {
                        return false;
                    }
                } else if (!this$billId.equals(other$billId)) {
                    return false;
                }

                label553: {
                    Object this$transactionDate = this.getTransactionDate();
                    Object other$transactionDate = other.getTransactionDate();
                    if (this$transactionDate == null) {
                        if (other$transactionDate == null) {
                            break label553;
                        }
                    } else if (this$transactionDate.equals(other$transactionDate)) {
                        break label553;
                    }

                    return false;
                }

                Object this$storeId = this.getStoreId();
                Object other$storeId = other.getStoreId();
                if (this$storeId == null) {
                    if (other$storeId != null) {
                        return false;
                    }
                } else if (!this$storeId.equals(other$storeId)) {
                    return false;
                }

                label539: {
                    Object this$merchantId = this.getMerchantId();
                    Object other$merchantId = other.getMerchantId();
                    if (this$merchantId == null) {
                        if (other$merchantId == null) {
                            break label539;
                        }
                    } else if (this$merchantId.equals(other$merchantId)) {
                        break label539;
                    }

                    return false;
                }

                Object this$customerType = this.getCustomerType();
                Object other$customerType = other.getCustomerType();
                if (this$customerType == null) {
                    if (other$customerType != null) {
                        return false;
                    }
                } else if (!this$customerType.equals(other$customerType)) {
                    return false;
                }

                label525: {
                    Object this$customerId = this.getCustomerId();
                    Object other$customerId = other.getCustomerId();
                    if (this$customerId == null) {
                        if (other$customerId == null) {
                            break label525;
                        }
                    } else if (this$customerId.equals(other$customerId)) {
                        break label525;
                    }

                    return false;
                }

                label518: {
                    Object this$customerName = this.getCustomerName();
                    Object other$customerName = other.getCustomerName();
                    if (this$customerName == null) {
                        if (other$customerName == null) {
                            break label518;
                        }
                    } else if (this$customerName.equals(other$customerName)) {
                        break label518;
                    }

                    return false;
                }

                Object this$customerPhone = this.getCustomerPhone();
                Object other$customerPhone = other.getCustomerPhone();
                if (this$customerPhone == null) {
                    if (other$customerPhone != null) {
                        return false;
                    }
                } else if (!this$customerPhone.equals(other$customerPhone)) {
                    return false;
                }

                label504: {
                    Object this$merchantName = this.getMerchantName();
                    Object other$merchantName = other.getMerchantName();
                    if (this$merchantName == null) {
                        if (other$merchantName == null) {
                            break label504;
                        }
                    } else if (this$merchantName.equals(other$merchantName)) {
                        break label504;
                    }

                    return false;
                }

                label497: {
                    Object this$storeName = this.getStoreName();
                    Object other$storeName = other.getStoreName();
                    if (this$storeName == null) {
                        if (other$storeName == null) {
                            break label497;
                        }
                    } else if (this$storeName.equals(other$storeName)) {
                        break label497;
                    }

                    return false;
                }

                Object this$storeAddress1 = this.getStoreAddress1();
                Object other$storeAddress1 = other.getStoreAddress1();
                if (this$storeAddress1 == null) {
                    if (other$storeAddress1 != null) {
                        return false;
                    }
                } else if (!this$storeAddress1.equals(other$storeAddress1)) {
                    return false;
                }

                Object this$storeAddress2 = this.getStoreAddress2();
                Object other$storeAddress2 = other.getStoreAddress2();
                if (this$storeAddress2 == null) {
                    if (other$storeAddress2 != null) {
                        return false;
                    }
                } else if (!this$storeAddress2.equals(other$storeAddress2)) {
                    return false;
                }

                label476: {
                    Object this$storeAddress3 = this.getStoreAddress3();
                    Object other$storeAddress3 = other.getStoreAddress3();
                    if (this$storeAddress3 == null) {
                        if (other$storeAddress3 == null) {
                            break label476;
                        }
                    } else if (this$storeAddress3.equals(other$storeAddress3)) {
                        break label476;
                    }

                    return false;
                }

                Object this$storeReceiptRemark = this.getStoreReceiptRemark();
                Object other$storeReceiptRemark = other.getStoreReceiptRemark();
                if (this$storeReceiptRemark == null) {
                    if (other$storeReceiptRemark != null) {
                        return false;
                    }
                } else if (!this$storeReceiptRemark.equals(other$storeReceiptRemark)) {
                    return false;
                }

                Object this$storeReceiptRemark2 = this.getStoreReceiptRemark2();
                Object other$storeReceiptRemark2 = other.getStoreReceiptRemark2();
                if (this$storeReceiptRemark2 == null) {
                    if (other$storeReceiptRemark2 != null) {
                        return false;
                    }
                } else if (!this$storeReceiptRemark2.equals(other$storeReceiptRemark2)) {
                    return false;
                }

                label455: {
                    Object this$storePhone = this.getStorePhone();
                    Object other$storePhone = other.getStorePhone();
                    if (this$storePhone == null) {
                        if (other$storePhone == null) {
                            break label455;
                        }
                    } else if (this$storePhone.equals(other$storePhone)) {
                        break label455;
                    }

                    return false;
                }

                Object this$storeNpwp = this.getStoreNpwp();
                Object other$storeNpwp = other.getStoreNpwp();
                if (this$storeNpwp == null) {
                    if (other$storeNpwp != null) {
                        return false;
                    }
                } else if (!this$storeNpwp.equals(other$storeNpwp)) {
                    return false;
                }

                label441: {
                    Object this$userFullname = this.getUserFullname();
                    Object other$userFullname = other.getUserFullname();
                    if (this$userFullname == null) {
                        if (other$userFullname == null) {
                            break label441;
                        }
                    } else if (this$userFullname.equals(other$userFullname)) {
                        break label441;
                    }

                    return false;
                }

                Object this$totalItem = this.getTotalItem();
                Object other$totalItem = other.getTotalItem();
                if (this$totalItem == null) {
                    if (other$totalItem != null) {
                        return false;
                    }
                } else if (!this$totalItem.equals(other$totalItem)) {
                    return false;
                }

                label427: {
                    Object this$itemsAmount = this.getItemsAmount();
                    Object other$itemsAmount = other.getItemsAmount();
                    if (this$itemsAmount == null) {
                        if (other$itemsAmount == null) {
                            break label427;
                        }
                    } else if (this$itemsAmount.equals(other$itemsAmount)) {
                        break label427;
                    }

                    return false;
                }

                Object this$cashDiscountAmount = this.getCashDiscountAmount();
                Object other$cashDiscountAmount = other.getCashDiscountAmount();
                if (this$cashDiscountAmount == null) {
                    if (other$cashDiscountAmount != null) {
                        return false;
                    }
                } else if (!this$cashDiscountAmount.equals(other$cashDiscountAmount)) {
                    return false;
                }

                label413: {
                    Object this$salesDiscountAmount = this.getSalesDiscountAmount();
                    Object other$salesDiscountAmount = other.getSalesDiscountAmount();
                    if (this$salesDiscountAmount == null) {
                        if (other$salesDiscountAmount == null) {
                            break label413;
                        }
                    } else if (this$salesDiscountAmount.equals(other$salesDiscountAmount)) {
                        break label413;
                    }

                    return false;
                }

                label406: {
                    Object this$extraDiscountAmount = this.getExtraDiscountAmount();
                    Object other$extraDiscountAmount = other.getExtraDiscountAmount();
                    if (this$extraDiscountAmount == null) {
                        if (other$extraDiscountAmount == null) {
                            break label406;
                        }
                    } else if (this$extraDiscountAmount.equals(other$extraDiscountAmount)) {
                        break label406;
                    }

                    return false;
                }

                Object this$ppnAmount = this.getPpnAmount();
                Object other$ppnAmount = other.getPpnAmount();
                if (this$ppnAmount == null) {
                    if (other$ppnAmount != null) {
                        return false;
                    }
                } else if (!this$ppnAmount.equals(other$ppnAmount)) {
                    return false;
                }

                label392: {
                    Object this$serviceTaxAmount = this.getServiceTaxAmount();
                    Object other$serviceTaxAmount = other.getServiceTaxAmount();
                    if (this$serviceTaxAmount == null) {
                        if (other$serviceTaxAmount == null) {
                            break label392;
                        }
                    } else if (this$serviceTaxAmount.equals(other$serviceTaxAmount)) {
                        break label392;
                    }

                    return false;
                }

                label385: {
                    Object this$subtotalAmount = this.getSubtotalAmount();
                    Object other$subtotalAmount = other.getSubtotalAmount();
                    if (this$subtotalAmount == null) {
                        if (other$subtotalAmount == null) {
                            break label385;
                        }
                    } else if (this$subtotalAmount.equals(other$subtotalAmount)) {
                        break label385;
                    }

                    return false;
                }

                Object this$pb1TaxAmount = this.getPb1TaxAmount();
                Object other$pb1TaxAmount = other.getPb1TaxAmount();
                if (this$pb1TaxAmount == null) {
                    if (other$pb1TaxAmount != null) {
                        return false;
                    }
                } else if (!this$pb1TaxAmount.equals(other$pb1TaxAmount)) {
                    return false;
                }

                Object this$totalAmount = this.getTotalAmount();
                Object other$totalAmount = other.getTotalAmount();
                if (this$totalAmount == null) {
                    if (other$totalAmount != null) {
                        return false;
                    }
                } else if (!this$totalAmount.equals(other$totalAmount)) {
                    return false;
                }

                label364: {
                    Object this$roundOffAmount = this.getRoundOffAmount();
                    Object other$roundOffAmount = other.getRoundOffAmount();
                    if (this$roundOffAmount == null) {
                        if (other$roundOffAmount == null) {
                            break label364;
                        }
                    } else if (this$roundOffAmount.equals(other$roundOffAmount)) {
                        break label364;
                    }

                    return false;
                }

                Object this$shippingAmount = this.getShippingAmount();
                Object other$shippingAmount = other.getShippingAmount();
                if (this$shippingAmount == null) {
                    if (other$shippingAmount != null) {
                        return false;
                    }
                } else if (!this$shippingAmount.equals(other$shippingAmount)) {
                    return false;
                }

                Object this$finalAmount = this.getFinalAmount();
                Object other$finalAmount = other.getFinalAmount();
                if (this$finalAmount == null) {
                    if (other$finalAmount != null) {
                        return false;
                    }
                } else if (!this$finalAmount.equals(other$finalAmount)) {
                    return false;
                }

                label343: {
                    Object this$billAmount = this.getBillAmount();
                    Object other$billAmount = other.getBillAmount();
                    if (this$billAmount == null) {
                        if (other$billAmount == null) {
                            break label343;
                        }
                    } else if (this$billAmount.equals(other$billAmount)) {
                        break label343;
                    }

                    return false;
                }

                Object this$changeAmount = this.getChangeAmount();
                Object other$changeAmount = other.getChangeAmount();
                if (this$changeAmount == null) {
                    if (other$changeAmount != null) {
                        return false;
                    }
                } else if (!this$changeAmount.equals(other$changeAmount)) {
                    return false;
                }

                label329: {
                    Object this$transactionStatus = this.getTransactionStatus();
                    Object other$transactionStatus = other.getTransactionStatus();
                    if (this$transactionStatus == null) {
                        if (other$transactionStatus == null) {
                            break label329;
                        }
                    } else if (this$transactionStatus.equals(other$transactionStatus)) {
                        break label329;
                    }

                    return false;
                }

                Object this$userActRefId = this.getUserActRefId();
                Object other$userActRefId = other.getUserActRefId();
                if (this$userActRefId == null) {
                    if (other$userActRefId != null) {
                        return false;
                    }
                } else if (!this$userActRefId.equals(other$userActRefId)) {
                    return false;
                }

                label315: {
                    Object this$details = this.getDetails();
                    Object other$details = other.getDetails();
                    if (this$details == null) {
                        if (other$details == null) {
                            break label315;
                        }
                    } else if (this$details.equals(other$details)) {
                        break label315;
                    }

                    return false;
                }

                Object this$orders = this.getOrders();
                Object other$orders = other.getOrders();
                if (this$orders == null) {
                    if (other$orders != null) {
                        return false;
                    }
                } else if (!this$orders.equals(other$orders)) {
                    return false;
                }

                if (this.getTableNumber() != other.getTableNumber()) {
                    return false;
                } else {
                    label300: {
                        Object this$paymentType = this.getPaymentType();
                        Object other$paymentType = other.getPaymentType();
                        if (this$paymentType == null) {
                            if (other$paymentType == null) {
                                break label300;
                            }
                        } else if (this$paymentType.equals(other$paymentType)) {
                            break label300;
                        }

                        return false;
                    }

                    Object this$bank = this.getBank();
                    Object other$bank = other.getBank();
                    if (this$bank == null) {
                        if (other$bank != null) {
                            return false;
                        }
                    } else if (!this$bank.equals(other$bank)) {
                        return false;
                    }

                    Object this$cardType = this.getCardType();
                    Object other$cardType = other.getCardType();
                    if (this$cardType == null) {
                        if (other$cardType != null) {
                            return false;
                        }
                    } else if (!this$cardType.equals(other$cardType)) {
                        return false;
                    }

                    label279: {
                        Object this$cardNumber = this.getCardNumber();
                        Object other$cardNumber = other.getCardNumber();
                        if (this$cardNumber == null) {
                            if (other$cardNumber == null) {
                                break label279;
                            }
                        } else if (this$cardNumber.equals(other$cardNumber)) {
                            break label279;
                        }

                        return false;
                    }

                    label272: {
                        Object this$approvalCode = this.getApprovalCode();
                        Object other$approvalCode = other.getApprovalCode();
                        if (this$approvalCode == null) {
                            if (other$approvalCode == null) {
                                break label272;
                            }
                        } else if (this$approvalCode.equals(other$approvalCode)) {
                            break label272;
                        }

                        return false;
                    }

                    label265: {
                        Object this$struk = this.getStruk();
                        Object other$struk = other.getStruk();
                        if (this$struk == null) {
                            if (other$struk == null) {
                                break label265;
                            }
                        } else if (this$struk.equals(other$struk)) {
                            break label265;
                        }

                        return false;
                    }

                    Object this$version = this.getVersion();
                    Object other$version = other.getVersion();
                    if (this$version == null) {
                        if (other$version != null) {
                            return false;
                        }
                    } else if (!this$version.equals(other$version)) {
                        return false;
                    }

                    Object this$userId = this.getUserId();
                    Object other$userId = other.getUserId();
                    if (this$userId == null) {
                        if (other$userId != null) {
                            return false;
                        }
                    } else if (!this$userId.equals(other$userId)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TransactionDto;
    }



    public TransactionDto(final Long id, final String billId, final Date transactionDate, final Long storeId, final Long merchantId, final String customerType, final Long customerId, final String customerName, final String customerPhone, final String merchantName, final String storeName, final String storeAddress1, final String storeAddress2, final String storeAddress3, final String storeReceiptRemark, final String storeReceiptRemark2, final String storePhone, final String storeNpwp, final String userFullname, final Integer totalItem, final BigDecimal itemsAmount, final BigDecimal cashDiscountAmount, final BigDecimal salesDiscountAmount, final BigDecimal extraDiscountAmount, final BigDecimal ppnAmount, final BigDecimal serviceTaxAmount, final BigDecimal subtotalAmount, final BigDecimal pb1TaxAmount, final BigDecimal totalAmount, final BigDecimal roundOffAmount, final BigDecimal shippingAmount, final BigDecimal finalAmount, final BigDecimal billAmount, final BigDecimal changeAmount, final String transactionStatus, final String userActRefId, final List<TransactionDetailsDto> details, final List<String> orders, final int tableNumber, final String paymentType, final RefBankDto bank, final String cardType, final String cardNumber, final String approvalCode, final String struk, final Integer version, final String userId) {
        this.paymentType = "";
        this.id = id;
        this.billId = billId;
        this.transactionDate = transactionDate;
        this.storeId = storeId;
        this.merchantId = merchantId;
        this.customerType = customerType;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.merchantName = merchantName;
        this.storeName = storeName;
        this.storeAddress1 = storeAddress1;
        this.storeAddress2 = storeAddress2;
        this.storeAddress3 = storeAddress3;
        this.storeReceiptRemark = storeReceiptRemark;
        this.storeReceiptRemark2 = storeReceiptRemark2;
        this.storePhone = storePhone;
        this.storeNpwp = storeNpwp;
        this.userFullname = userFullname;
        this.totalItem = totalItem;
        this.itemsAmount = itemsAmount;
        this.cashDiscountAmount = cashDiscountAmount;
        this.salesDiscountAmount = salesDiscountAmount;
        this.extraDiscountAmount = extraDiscountAmount;
        this.ppnAmount = ppnAmount;
        this.serviceTaxAmount = serviceTaxAmount;
        this.subtotalAmount = subtotalAmount;
        this.pb1TaxAmount = pb1TaxAmount;
        this.totalAmount = totalAmount;
        this.roundOffAmount = roundOffAmount;
        this.shippingAmount = shippingAmount;
        this.finalAmount = finalAmount;
        this.billAmount = billAmount;
        this.changeAmount = changeAmount;
        this.transactionStatus = transactionStatus;
        this.userActRefId = userActRefId;
        this.details = details;
        this.orders = orders;
        this.tableNumber = tableNumber;
        this.paymentType = paymentType;
        this.bank = bank;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.approvalCode = approvalCode;
        this.struk = struk;
        this.version = version;
        this.userId = userId;
    }

    public String toString() {
        return "TransactionDto(id=" + this.getId() + ", billId=" + this.getBillId() + ", transactionDate=" + this.getTransactionDate() + ", storeId=" + this.getStoreId() + ", merchantId=" + this.getMerchantId() + ", customerType=" + this.getCustomerType() + ", customerId=" + this.getCustomerId() + ", customerName=" + this.getCustomerName() + ", customerPhone=" + this.getCustomerPhone() + ", merchantName=" + this.getMerchantName() + ", storeName=" + this.getStoreName() + ", storeAddress1=" + this.getStoreAddress1() + ", storeAddress2=" + this.getStoreAddress2() + ", storeAddress3=" + this.getStoreAddress3() + ", storeReceiptRemark=" + this.getStoreReceiptRemark() + ", storeReceiptRemark2=" + this.getStoreReceiptRemark2() + ", storePhone=" + this.getStorePhone() + ", storeNpwp=" + this.getStoreNpwp() + ", userFullname=" + this.getUserFullname() + ", totalItem=" + this.getTotalItem() + ", itemsAmount=" + this.getItemsAmount() + ", cashDiscountAmount=" + this.getCashDiscountAmount() + ", salesDiscountAmount=" + this.getSalesDiscountAmount() + ", extraDiscountAmount=" + this.getExtraDiscountAmount() + ", ppnAmount=" + this.getPpnAmount() + ", serviceTaxAmount=" + this.getServiceTaxAmount() + ", subtotalAmount=" + this.getSubtotalAmount() + ", pb1TaxAmount=" + this.getPb1TaxAmount() + ", totalAmount=" + this.getTotalAmount() + ", roundOffAmount=" + this.getRoundOffAmount() + ", shippingAmount=" + this.getShippingAmount() + ", finalAmount=" + this.getFinalAmount() + ", billAmount=" + this.getBillAmount() + ", changeAmount=" + this.getChangeAmount() + ", transactionStatus=" + this.getTransactionStatus() + ", userActRefId=" + this.getUserActRefId() + ", details=" + this.getDetails() + ", orders=" + this.getOrders() + ", tableNumber=" + this.getTableNumber() + ", paymentType=" + this.getPaymentType() + ", bank=" + this.getBank() + ", cardType=" + this.getCardType() + ", cardNumber=" + this.getCardNumber() + ", approvalCode=" + this.getApprovalCode() + ", struk=" + this.getStruk() + ", version=" + this.getVersion() + ", userId=" + this.getUserId() + ")";
    }

    public static class TransactionDtoBuilder {
        private Long id;
        private String billId;
        private Date transactionDate;
        private Long storeId;
        private Long merchantId;
        private String customerType;
        private Long customerId;
        private String customerName;
        private String customerPhone;
        private String merchantName;
        private String storeName;
        private String storeAddress1;
        private String storeAddress2;
        private String storeAddress3;
        private String storeReceiptRemark;
        private String storeReceiptRemark2;
        private String storePhone;
        private String storeNpwp;
        private String userFullname;
        private Integer totalItem;
        private BigDecimal itemsAmount;
        private BigDecimal cashDiscountAmount;
        private BigDecimal salesDiscountAmount;
        private BigDecimal extraDiscountAmount;
        private BigDecimal ppnAmount;
        private BigDecimal serviceTaxAmount;
        private BigDecimal subtotalAmount;
        private BigDecimal pb1TaxAmount;
        private BigDecimal totalAmount;
        private BigDecimal roundOffAmount;
        private BigDecimal shippingAmount;
        private BigDecimal finalAmount;
        private BigDecimal billAmount;
        private BigDecimal changeAmount;
        private String transactionStatus;
        private String userActRefId;
        private List<TransactionDetailsDto> details;
        private List<String> orders;
        private int tableNumber;
        private String paymentType;
        private RefBankDto bank;
        private String cardType;
        private String cardNumber;
        private String approvalCode;
        private String struk;
        private Integer version;
        private String userId;

        TransactionDtoBuilder() {
        }

        public TransactionDto.TransactionDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder billId(final String billId) {
            this.billId = billId;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder transactionDate(final Date transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeId(final Long storeId) {
            this.storeId = storeId;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder merchantId(final Long merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder customerType(final String customerType) {
            this.customerType = customerType;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder customerId(final Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder customerName(final String customerName) {
            this.customerName = customerName;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder customerPhone(final String customerPhone) {
            this.customerPhone = customerPhone;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder merchantName(final String merchantName) {
            this.merchantName = merchantName;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeName(final String storeName) {
            this.storeName = storeName;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeAddress1(final String storeAddress1) {
            this.storeAddress1 = storeAddress1;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeAddress2(final String storeAddress2) {
            this.storeAddress2 = storeAddress2;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeAddress3(final String storeAddress3) {
            this.storeAddress3 = storeAddress3;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeReceiptRemark(final String storeReceiptRemark) {
            this.storeReceiptRemark = storeReceiptRemark;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeReceiptRemark2(final String storeReceiptRemark2) {
            this.storeReceiptRemark2 = storeReceiptRemark2;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storePhone(final String storePhone) {
            this.storePhone = storePhone;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder storeNpwp(final String storeNpwp) {
            this.storeNpwp = storeNpwp;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder userFullname(final String userFullname) {
            this.userFullname = userFullname;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder totalItem(final Integer totalItem) {
            this.totalItem = totalItem;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder itemsAmount(final BigDecimal itemsAmount) {
            this.itemsAmount = itemsAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder cashDiscountAmount(final BigDecimal cashDiscountAmount) {
            this.cashDiscountAmount = cashDiscountAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder salesDiscountAmount(final BigDecimal salesDiscountAmount) {
            this.salesDiscountAmount = salesDiscountAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder extraDiscountAmount(final BigDecimal extraDiscountAmount) {
            this.extraDiscountAmount = extraDiscountAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder ppnAmount(final BigDecimal ppnAmount) {
            this.ppnAmount = ppnAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder serviceTaxAmount(final BigDecimal serviceTaxAmount) {
            this.serviceTaxAmount = serviceTaxAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder subtotalAmount(final BigDecimal subtotalAmount) {
            this.subtotalAmount = subtotalAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder pb1TaxAmount(final BigDecimal pb1TaxAmount) {
            this.pb1TaxAmount = pb1TaxAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder totalAmount(final BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder roundOffAmount(final BigDecimal roundOffAmount) {
            this.roundOffAmount = roundOffAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder shippingAmount(final BigDecimal shippingAmount) {
            this.shippingAmount = shippingAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder finalAmount(final BigDecimal finalAmount) {
            this.finalAmount = finalAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder billAmount(final BigDecimal billAmount) {
            this.billAmount = billAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder changeAmount(final BigDecimal changeAmount) {
            this.changeAmount = changeAmount;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder transactionStatus(final String transactionStatus) {
            this.transactionStatus = transactionStatus;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder userActRefId(final String userActRefId) {
            this.userActRefId = userActRefId;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder details(final List<TransactionDetailsDto> details) {
            this.details = details;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder orders(final List<String> orders) {
            this.orders = orders;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder tableNumber(final int tableNumber) {
            this.tableNumber = tableNumber;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder paymentType(final String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder bank(final RefBankDto bank) {
            this.bank = bank;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder cardType(final String cardType) {
            this.cardType = cardType;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder cardNumber(final String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder approvalCode(final String approvalCode) {
            this.approvalCode = approvalCode;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder struk(final String struk) {
            this.struk = struk;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder version(final Integer version) {
            this.version = version;
            return this;
        }

        public TransactionDto.TransactionDtoBuilder userId(final String userId) {
            this.userId = userId;
            return this;
        }

        public TransactionDto build() {
            return new TransactionDto(this.id, this.billId, this.transactionDate, this.storeId, this.merchantId, this.customerType, this.customerId, this.customerName, this.customerPhone, this.merchantName, this.storeName, this.storeAddress1, this.storeAddress2, this.storeAddress3, this.storeReceiptRemark, this.storeReceiptRemark2, this.storePhone, this.storeNpwp, this.userFullname, this.totalItem, this.itemsAmount, this.cashDiscountAmount, this.salesDiscountAmount, this.extraDiscountAmount, this.ppnAmount, this.serviceTaxAmount, this.subtotalAmount, this.pb1TaxAmount, this.totalAmount, this.roundOffAmount, this.shippingAmount, this.finalAmount, this.billAmount, this.changeAmount, this.transactionStatus, this.userActRefId, this.details, this.orders, this.tableNumber, this.paymentType, this.bank, this.cardType, this.cardNumber, this.approvalCode, this.struk, this.version, this.userId);
        }

        public String toString() {
            return "TransactionDto.TransactionDtoBuilder(id=" + this.id + ", billId=" + this.billId + ", transactionDate=" + this.transactionDate + ", storeId=" + this.storeId + ", merchantId=" + this.merchantId + ", customerType=" + this.customerType + ", customerId=" + this.customerId + ", customerName=" + this.customerName + ", customerPhone=" + this.customerPhone + ", merchantName=" + this.merchantName + ", storeName=" + this.storeName + ", storeAddress1=" + this.storeAddress1 + ", storeAddress2=" + this.storeAddress2 + ", storeAddress3=" + this.storeAddress3 + ", storeReceiptRemark=" + this.storeReceiptRemark + ", storeReceiptRemark2=" + this.storeReceiptRemark2 + ", storePhone=" + this.storePhone + ", storeNpwp=" + this.storeNpwp + ", userFullname=" + this.userFullname + ", totalItem=" + this.totalItem + ", itemsAmount=" + this.itemsAmount + ", cashDiscountAmount=" + this.cashDiscountAmount + ", salesDiscountAmount=" + this.salesDiscountAmount + ", extraDiscountAmount=" + this.extraDiscountAmount + ", ppnAmount=" + this.ppnAmount + ", serviceTaxAmount=" + this.serviceTaxAmount + ", subtotalAmount=" + this.subtotalAmount + ", pb1TaxAmount=" + this.pb1TaxAmount + ", totalAmount=" + this.totalAmount + ", roundOffAmount=" + this.roundOffAmount + ", shippingAmount=" + this.shippingAmount + ", finalAmount=" + this.finalAmount + ", billAmount=" + this.billAmount + ", changeAmount=" + this.changeAmount + ", transactionStatus=" + this.transactionStatus + ", userActRefId=" + this.userActRefId + ", details=" + this.details + ", orders=" + this.orders + ", tableNumber=" + this.tableNumber + ", paymentType=" + this.paymentType + ", bank=" + this.bank + ", cardType=" + this.cardType + ", cardNumber=" + this.cardNumber + ", approvalCode=" + this.approvalCode + ", struk=" + this.struk + ", version=" + this.version + ", userId=" + this.userId + ")";
        }
    }
}
