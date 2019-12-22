package com.lanjchenx.module.lijiangnew.dto;

import java.util.List;

/**
 * @author admin 2019-05-01 20:27
 */
public class Parameter {

    /**
     * orderNetType : XCXGP
     * orderTackTicketName : 王小康
     * orderTackTicketPhone : 15601708566
     * arriveDT : 2019-04-27
     * certificateTypeNo : 410222199209142015
     * remark :
     * orderItemsList : [{"productOnlyNo":"10000008037","saleSum":2,"orderCertificateItemsList":[{"certificateNo":"410222199209142015","certificateCardName":"身份证","certificateName":"王小康","certificateTypeId":1,"phoneNumber":"15601708566","facePicPath":"https://mallinter.ltg.cn:28866/group1/M00/00/11/rBDUslzBbn-AGWlhAASeqPl4_iI55..jpg"},{"certificateNo":"210803198903280516","certificateCardName":"身份证","certificateName":"陈刚","certificateTypeId":1,"phoneNumber":"15601708586","facePicPath":"https://mallinter.ltg.cn:28866/group1/M00/00/22/rBDUslzC0DSAUyjvAAVzD5K7j9U10..jpg"}]}]
     * orderTimeControlList : [{"scenicSpotsId":10000000000002,"timeControlDetailId":10000000063735}]
     */

    private String orderNetType;
    private String orderTackTicketName;
    private String orderTackTicketPhone;
    private String arriveDT;
    private String certificateTypeNo;
    private String remark;
    private List<OrderItemsList> orderItemsList;
    private List<OrderTimeControlList> orderTimeControlList;

    public String getOrderNetType() {
        return orderNetType;
    }

    public void setOrderNetType(String orderNetType) {
        this.orderNetType = orderNetType;
    }

    public String getOrderTackTicketName() {
        return orderTackTicketName;
    }

    public void setOrderTackTicketName(String orderTackTicketName) {
        this.orderTackTicketName = orderTackTicketName;
    }

    public String getOrderTackTicketPhone() {
        return orderTackTicketPhone;
    }

    public void setOrderTackTicketPhone(String orderTackTicketPhone) {
        this.orderTackTicketPhone = orderTackTicketPhone;
    }

    public String getArriveDT() {
        return arriveDT;
    }

    public void setArriveDT(String arriveDT) {
        this.arriveDT = arriveDT;
    }

    public String getCertificateTypeNo() {
        return certificateTypeNo;
    }

    public void setCertificateTypeNo(String certificateTypeNo) {
        this.certificateTypeNo = certificateTypeNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OrderItemsList> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItemsList> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public List<OrderTimeControlList> getOrderTimeControlList() {
        return orderTimeControlList;
    }

    public void setOrderTimeControlList(List<OrderTimeControlList> orderTimeControlList) {
        this.orderTimeControlList = orderTimeControlList;
    }

    public static class OrderItemsList {
        /**
         * productOnlyNo : 10000008037
         * saleSum : 2
         * orderCertificateItemsList : [{"certificateNo":"410222199209142015","certificateCardName":"身份证","certificateName":"王小康","certificateTypeId":1,"phoneNumber":"15601708566","facePicPath":"https://mallinter.ltg.cn:28866/group1/M00/00/11/rBDUslzBbn-AGWlhAASeqPl4_iI55..jpg"},{"certificateNo":"210803198903280516","certificateCardName":"身份证","certificateName":"陈刚","certificateTypeId":1,"phoneNumber":"15601708586","facePicPath":"https://mallinter.ltg.cn:28866/group1/M00/00/22/rBDUslzC0DSAUyjvAAVzD5K7j9U10..jpg"}]
         */

        private String productOnlyNo;
        private String arriveDT;
        private String productType;
        private int saleSum;

        public String getArriveDT() {
            return arriveDT;
        }

        public void setArriveDT(String arriveDT) {
            this.arriveDT = arriveDT;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        private List<OrderCertificateItemsList> orderCertificateItemsList;

        public String getProductOnlyNo() {
            return productOnlyNo;
        }

        public void setProductOnlyNo(String productOnlyNo) {
            this.productOnlyNo = productOnlyNo;
        }

        public int getSaleSum() {
            return saleSum;
        }

        public void setSaleSum(int saleSum) {
            this.saleSum = saleSum;
        }

        public List<OrderCertificateItemsList> getOrderCertificateItemsList() {
            return orderCertificateItemsList;
        }

        public void setOrderCertificateItemsList(List<OrderCertificateItemsList> orderCertificateItemsList) {
            this.orderCertificateItemsList = orderCertificateItemsList;
        }

        public static class OrderCertificateItemsList {
            /**
             * certificateNo : 410222199209142015
             * certificateCardName : 身份证
             * certificateName : 王小康
             * certificateTypeId : 1
             * phoneNumber : 15601708566
             * facePicPath : https://mallinter.ltg.cn:28866/group1/M00/00/11/rBDUslzBbn-AGWlhAASeqPl4_iI55..jpg
             */

            private String certificateNo;
            private String certificateCardName;
            private String certificateName;
            private int certificateTypeId;
            private String phoneNumber;
            private String facePicPath;

            public String getCertificateNo() {
                return certificateNo;
            }

            public void setCertificateNo(String certificateNo) {
                this.certificateNo = certificateNo;
            }

            public String getCertificateCardName() {
                return certificateCardName;
            }

            public void setCertificateCardName(String certificateCardName) {
                this.certificateCardName = certificateCardName;
            }

            public String getCertificateName() {
                return certificateName;
            }

            public void setCertificateName(String certificateName) {
                this.certificateName = certificateName;
            }

            public int getCertificateTypeId() {
                return certificateTypeId;
            }

            public void setCertificateTypeId(int certificateTypeId) {
                this.certificateTypeId = certificateTypeId;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getFacePicPath() {
                return facePicPath;
            }

            public void setFacePicPath(String facePicPath) {
                this.facePicPath = facePicPath;
            }
        }
    }

    public static class OrderTimeControlList {
        /**
         * scenicSpotsId : 10000000000002
         * timeControlDetailId : 10000000063735
         */

        private long scenicSpotsId;
        private long timeControlDetailId;

        public long getScenicSpotsId() {
            return scenicSpotsId;
        }

        public void setScenicSpotsId(long scenicSpotsId) {
            this.scenicSpotsId = scenicSpotsId;
        }

        public long getTimeControlDetailId() {
            return timeControlDetailId;
        }

        public void setTimeControlDetailId(long timeControlDetailId) {
            this.timeControlDetailId = timeControlDetailId;
        }
    }
}
