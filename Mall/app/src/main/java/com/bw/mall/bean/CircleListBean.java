package com.bw.mall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/12 13:34
 * @Description: 用途：完成特定功能
 */
public class CircleListBean implements Serializable {

    /**
     * result : [{"commodityId":100,"content":"给大家推荐一个一般商品","createTime":1584029193000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-03-11/20200311141243.png","id":2978,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/8237020200312110633.jpg,http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/8571420200312110633.jpg,http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/1268520200312110633.png","nickName":"妩媚的小姐姐","userId":27974,"whetherGreat":2},{"commodityId":1940,"content":"给大家推荐一个垃圾商品","createTime":1584029094000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-03-11/20200311141243.png","id":2977,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/5839120200312110454.png,http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/2570120200312110454.jpg,http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/0492720200312110454.jpg","nickName":"妩媚的小姐姐","userId":27974,"whetherGreat":2},{"commodityId":15,"content":"\"1212122\"","createTime":1582750428000,"greatNum":3,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-02-26/20200226145818.jpg","id":2976,"image":"","nickName":"MB_Z7ZbV","userId":1516,"whetherGreat":2},{"commodityId":2,"content":"推荐","createTime":1582158414000,"greatNum":1,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-02-11/20200211224121.jpg","id":2975,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-02-19/4928720200219182654.jpg","nickName":"Eg_znzDn","userId":28358,"whetherGreat":2},{"commodityId":2,"content":"推荐","createTime":1582155402000,"greatNum":1,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-02-11/20200211224121.jpg","id":2974,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-02-19/8347620200219173642.jpg","nickName":"Eg_znzDn","userId":28358,"whetherGreat":2},{"commodityId":1940,"content":"给大家推荐一个好商品","createTime":1582063965000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-03-06/20200306153601.png","id":2972,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-02-18/4657920200218161245.png","nickName":"55555","userId":28024,"whetherGreat":2},{"commodityId":1,"content":"给大家推荐一个好商品","createTime":1582059896000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":2969,"image":"","nickName":"zo_49m8F","userId":28265,"whetherGreat":2},{"commodityId":1,"content":"给大家推荐一个好商品","createTime":1582059782000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":2968,"image":"","nickName":"zo_49m8F","userId":28265,"whetherGreat":2},{"commodityId":3,"content":"给大家推荐一个好商品32","createTime":1582059400000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":2967,"image":"","nickName":"zo_49m8F","userId":28265,"whetherGreat":2},{"commodityId":1,"content":"给大家推荐一个好商品","createTime":1582059321000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","id":2966,"image":"","nickName":"zo_49m8F","userId":28265,"whetherGreat":2}]
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
         * commodityId : 100
         * content : 给大家推荐一个一般商品
         * createTime : 1584029193000
         * greatNum : 0
         * headPic : http://mobile.bwstudent.com/images/small/head_pic/2020-03-11/20200311141243.png
         * id : 2978
         * image : http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/8237020200312110633.jpg,http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/8571420200312110633.jpg,http://mobile.bwstudent.com/images/small/circle_pic/2020-03-12/1268520200312110633.png
         * nickName : 妩媚的小姐姐
         * userId : 27974
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
