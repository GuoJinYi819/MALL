package com.bw.mall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/3 20:26
 * @Description: 用途：完成特定功能
 */
public class CommodityByKeyBean implements Serializable {

    /**
     * result : [{"commodityId":88,"commodityName":"冬新品 梵希蔓毛呢外套女短款长袖2018冬季新款宽松英伦格子翻领斜门襟大衣女","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nz/wt/3/1.jpg","price":358,"saleNum":1},{"commodityId":124,"commodityName":"台湾AC5高清4K摄像机数码DV12倍光学变焦专业家用旅游","masterPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/1.jpg","price":1998,"saleNum":0},{"commodityId":171,"commodityName":"HOTBOOM2018男士双肩包休闲背包潮流学生书包多功能笔记本商务14英寸电脑包5606 时尚灰","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/2/1.jpg","price":109,"saleNum":0},{"commodityId":186,"commodityName":"SWISSGEAR双肩包 防水多功能笔记本电脑包14.6英寸/15.6英寸商务背包男学生书包休闲 SA-9393III","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/sjb/3/1.jpg","price":99,"saleNum":0},{"commodityId":118,"commodityName":" 新款 iPad 128G WIFI 版 平板电脑","masterPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/yyyl/5/1.jpg","price":2988,"saleNum":130}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 88
         * commodityName : 冬新品 梵希蔓毛呢外套女短款长袖2018冬季新款宽松英伦格子翻领斜门襟大衣女
         * masterPic : http://mobile.bwstudent.com/images/small/commodity/nz/wt/3/1.jpg
         * price : 358
         * saleNum : 1
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

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

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
