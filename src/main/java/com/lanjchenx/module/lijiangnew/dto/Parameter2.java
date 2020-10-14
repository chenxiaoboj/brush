package com.lanjchenx.module.lijiangnew.dto;

import java.util.List;

/**
 * @author admin 2019-05-01 20:27
 */
public class Parameter2 {


    /**
     * orderItemsList : [{"saleSum":"1","orderCertificateItemsList":[{"certificateTypeId":"1","phoneNumber":"18608880855","certificateName":"范学梅","facePicPath":"https://mallinter.ltg.cn:28866/group1/M00/53/65/rBDUsl3ENxeAXcnwAAE4Mi811q849..jpg","certificateNo":"130435196502010929"}],"arriveDT":"2020-03-23","productOnlyNo":"10000008258","productType":"ZHTC"}]
     * orderTimeControlList : [{"timeControlDetailId":"80000000033246","scenicSpotsId":"10000000000002"}]
     * orderNetType : APPGP
     * createOrderUuid : 158485383114174241109
     * arriveDT : 2020-03-23
     * orderTackTicketName : 范学梅
     * remark :
     * orderTackTicketPhone : 18608880855
     * certificateTypeNo :
     * validate : sqPudQRlBmelMHeGdIzA02d1_8kFew-1P0l9vVvgf7GdUxJ5u4IpqdWRvwMqiNkvHXddQVarqPe2oQYwEYX-rB8lDuvd0Ck_AS18ZKUzdFBr8rz-ApODuRmiKG97JqK_Ro9jL-a_dVQWSXxTtx-722c6LnTSCeggoTCZY7cQNgagUi44aZovqxRymEleSKtiC56ArywnJz69wc.9ApkU_P.rxgsZOCQyJwpUgiwuv9KXi-rSmRNsjX7JCDHVWsdNVbC6Exxu5VFGhRMTS4isNGCG0VEcrooDcQ9GciihzgWOH69y-u8bOFHP1Le9hIRSeLVOXQBI_uxaqhOyK_myd5hfv27B_Mvz6TxX.ME_-uRBy.eUw9OViQsNABWY8jTd2bPcObbHKOTrlaYvWxtJEA5lnrEU0.i1Ebh.cDpNJQKDBneEaPawgqPgPwxt8e-GRNNfH6dzAg2gRw6NuKuAIZDlA7LUqDN0OheIAZ2fLifR6ZbU9fuBL1SEdAa3
     */
    private List<OrderItemsList> orderItemsList;
    private List<OrderTimeControlList> orderTimeControlList;
    private String orderNetType;
    private String createOrderUuid;
    private String arriveDT;
    private String orderTackTicketName;
    private String remark;
    private String orderTackTicketPhone;
    private String certificateTypeNo;
    private String validate;

    public void setOrderItemsList(List<OrderItemsList> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public void setOrderTimeControlList(List<OrderTimeControlList> orderTimeControlList) {
        this.orderTimeControlList = orderTimeControlList;
    }

    public void setOrderNetType(String orderNetType) {
        this.orderNetType = orderNetType;
    }

    public void setCreateOrderUuid(String createOrderUuid) {
        this.createOrderUuid = createOrderUuid;
    }

    public void setArriveDT(String arriveDT) {
        this.arriveDT = arriveDT;
    }

    public void setOrderTackTicketName(String orderTackTicketName) {
        this.orderTackTicketName = orderTackTicketName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setOrderTackTicketPhone(String orderTackTicketPhone) {
        this.orderTackTicketPhone = orderTackTicketPhone;
    }

    public void setCertificateTypeNo(String certificateTypeNo) {
        this.certificateTypeNo = certificateTypeNo;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public List<OrderItemsList> getOrderItemsList() {
        return orderItemsList;
    }

    public List<OrderTimeControlList> getOrderTimeControlList() {
        return orderTimeControlList;
    }

    public String getOrderNetType() {
        return orderNetType;
    }

    public String getCreateOrderUuid() {
        return createOrderUuid;
    }

    public String getArriveDT() {
        return arriveDT;
    }

    public String getOrderTackTicketName() {
        return orderTackTicketName;
    }

    public String getRemark() {
        return remark;
    }

    public String getOrderTackTicketPhone() {
        return orderTackTicketPhone;
    }

    public String getCertificateTypeNo() {
        return certificateTypeNo;
    }

    public String getValidate() {
        return validate;
    }

    public static class OrderItemsList {
        /**
         * saleSum : 1
         * orderCertificateItemsList : [{"certificateTypeId":"1","phoneNumber":"18608880855","certificateName":"范学梅","facePicPath":"https://mallinter.ltg.cn:28866/group1/M00/53/65/rBDUsl3ENxeAXcnwAAE4Mi811q849..jpg","certificateNo":"130435196502010929"}]
         * arriveDT : 2020-03-23
         * productOnlyNo : 10000008258
         * productType : ZHTC
         */
        private String saleSum;
        private List<OrderCertificateItemsList> orderCertificateItemsList;
        private String arriveDT;
        private String productOnlyNo;
        private String productType;

        public void setSaleSum(String saleSum) {
            this.saleSum = saleSum;
        }

        public void setOrderCertificateItemsList(List<OrderCertificateItemsList> orderCertificateItemsList) {
            this.orderCertificateItemsList = orderCertificateItemsList;
        }

        public void setArriveDT(String arriveDT) {
            this.arriveDT = arriveDT;
        }

        public void setProductOnlyNo(String productOnlyNo) {
            this.productOnlyNo = productOnlyNo;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getSaleSum() {
            return saleSum;
        }

        public List<OrderCertificateItemsList> getOrderCertificateItemsList() {
            return orderCertificateItemsList;
        }

        public String getArriveDT() {
            return arriveDT;
        }

        public String getProductOnlyNo() {
            return productOnlyNo;
        }

        public String getProductType() {
            return productType;
        }

        public static class OrderCertificateItemsList {
            /**
             * certificateTypeId : 1
             * phoneNumber : 18608880855
             * certificateName : 范学梅
             * facePicPath : https://mallinter.ltg.cn:28866/group1/M00/53/65/rBDUsl3ENxeAXcnwAAE4Mi811q849..jpg
             * certificateNo : 130435196502010929
             */
            private String certificateTypeId;
            private String phoneNumber;
            private String certificateName;
            private String facePicPath;
            private String certificateNo;

            public void setCertificateTypeId(String certificateTypeId) {
                this.certificateTypeId = certificateTypeId;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public void setCertificateName(String certificateName) {
                this.certificateName = certificateName;
            }

            public void setFacePicPath(String facePicPath) {
                this.facePicPath = facePicPath;
            }

            public void setCertificateNo(String certificateNo) {
                this.certificateNo = certificateNo;
            }

            public String getCertificateTypeId() {
                return certificateTypeId;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public String getCertificateName() {
                return certificateName;
            }

            public String getFacePicPath() {
                return facePicPath;
            }

            public String getCertificateNo() {
                return certificateNo;
            }
        }
    }

    public static class OrderTimeControlList {
        /**
         * timeControlDetailId : 80000000033246
         * scenicSpotsId : 10000000000002
         */
        private String timeControlDetailId;
        private String scenicSpotsId;

        public void setTimeControlDetailId(String timeControlDetailId) {
            this.timeControlDetailId = timeControlDetailId;
        }

        public void setScenicSpotsId(String scenicSpotsId) {
            this.scenicSpotsId = scenicSpotsId;
        }

        public String getTimeControlDetailId() {
            return timeControlDetailId;
        }

        public String getScenicSpotsId() {
            return scenicSpotsId;
        }
    }
}
