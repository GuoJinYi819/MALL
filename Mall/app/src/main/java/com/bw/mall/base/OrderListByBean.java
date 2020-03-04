package com.bw.mall.base;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 15:03
 * @Description: 用途：完成特定功能
 */
public class OrderListByBean implements Serializable {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":113,"commodityName":"闪充充电器 9V-2A快充 适用 X21/X20/X9s/X9sPlus/X9/XPlay6/Xplay5/X7/X7Plus","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/5.jpg","commodityPrice":85,"orderDetailId":15205}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030414092048128055","orderStatus":1,"orderTime":1583302160000,"payAmount":85,"payMethod":1,"userId":28055},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":175,"commodityName":"倍晶 苹果微软联想惠普华硕戴尔宏基笔记本电脑包13英寸内胆14手提15单肩15.6小新11保护套 粉红色手提包+同色电源小包 15.6英寸","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/6/2.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/6/3.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/6/4.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/6/5.jpg","commodityPrice":119,"orderDetailId":15199}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030414030564728055","orderStatus":1,"orderTime":1583301786000,"payAmount":119,"payMethod":1,"userId":28055},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/5.jpg","commodityPrice":78,"orderDetailId":15189}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030410494070628055","orderStatus":1,"orderTime":1583290181000,"payAmount":78,"payMethod":1,"userId":28055}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":113,"commodityName":"闪充充电器 9V-2A快充 适用 X21/X20/X9s/X9sPlus/X9/XPlay6/Xplay5/X7/X7Plus","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/5.jpg","commodityPrice":85,"orderDetailId":15205}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020030414092048128055
         * orderStatus : 1
         * orderTime : 1583302160000
         * payAmount : 85
         * payMethod : 1
         * userId : 28055
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 113
             * commodityName : 闪充充电器 9V-2A快充 适用 X21/X20/X9s/X9sPlus/X9/XPlay6/Xplay5/X7/X7Plus
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/5.jpg
             * commodityPrice : 85
             * orderDetailId : 15205
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
