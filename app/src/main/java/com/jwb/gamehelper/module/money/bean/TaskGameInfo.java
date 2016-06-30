package com.jwb.gamehelper.module.money.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class TaskGameInfo {
    /**
     * info : [{"id":"1","task_platform":"dianjoy","platform_name":"点乐","sort_id":1,"status":"1","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_dl.jpg","rank":"9","reward":"奖660元","publish_time":"0","online_time":"2016-04-22 10:29:00","desc":"无尽乐趣，一点可得","publisher":"王欣雨","appear_times":"18630","app_income":"0.6"},{"id":"3","task_platform":"youmi","platform_name":"有米","sort_id":2,"status":"1","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_ym.jpg","rank":"10","reward":"奖777元","publish_time":"1460521002","online_time":"2016-04-22 10:29:00","desc":"真的很有米！","publisher":"王欣雨","appear_times":"25885","app_income":"0"},{"id":"8","task_platform":"beiduoad_android","platform_name":"贝多","sort_id":3,"status":"1","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_bd.jpg","rank":"9","reward":"奖666元","publish_time":"1460686960","online_time":"2016-04-22 10:23:00","desc":"应用多，更新快","publisher":"风起","appear_times":"4166","app_income":"21.6"},{"id":"5","task_platform":"datouniao","platform_name":"大头鸟","sort_id":4,"status":"1","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_dtn.jpg","rank":"9","reward":"奖666元","publish_time":"1460595851","online_time":"2016-04-22 10:29:00","desc":"任务傻，钱多，速来","publisher":"王欣雨","appear_times":"4281","app_income":"0"},{"id":"2","task_platform":"guomob_android","platform_name":"果盟","sort_id":5,"status":"1","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_gm.jpg","rank":"8","reward":"奖555元","publish_time":"2016","online_time":"2016-04-15 16:34:00","desc":"果盟积分墙，赚钱真太忙","publisher":"王欣雨","appear_times":"2294","app_income":"0.2"},{"id":"9","task_platform":"dianmoney","platform_name":"点财","sort_id":6,"status":"1","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_dc.jpg","rank":"9","reward":"奖660元","publish_time":"1460703757","online_time":"2016-04-23 15:03:00","desc":"每天都有新惊喜","publisher":"duanwei","appear_times":"1798","app_income":"0.406"},{"id":"6","task_platform":"domob_android","platform_name":"多盟","sort_id":7,"status":"0","type":"2","ad_img":"http://zhushou.72g.com/upload/image/ad_platform/wall_dm.jpg","rank":"8","reward":"奖555元","publish_time":"1460686842","online_time":"2016-04-21 10:21:00","desc":"多重任务享不停","publisher":"duanwei","appear_times":"851","app_income":"0.2"},{"id":"14","task_platform":"billionmobi","platform_name":"中亿","sort_id":8,"status":"0","type":"2","ad_img":"http://i3.72g.com/upload/201606/201606071737291420.jpg","rank":"9","reward":"奖600元","publish_time":"1464689935","online_time":"2016-05-31 18:16:00","desc":"任务超给力，奖励领不停","publisher":"duanwei","appear_times":"8","app_income":"0.2"}]
     * page : null
     * state : success
     */

    private Object page;
    private String state;
    /**
     * id : 1
     * task_platform : dianjoy
     * platform_name : 点乐
     * sort_id : 1
     * status : 1
     * type : 2
     * ad_img : http://zhushou.72g.com/upload/image/ad_platform/wall_dl.jpg
     * rank : 9
     * reward : 奖660元
     * publish_time : 0
     * online_time : 2016-04-22 10:29:00
     * desc : 无尽乐趣，一点可得
     * publisher : 王欣雨
     * appear_times : 18630
     * app_income : 0.6
     */

    private List<InfoBean> info;

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        private String id;
        private String task_platform;
        private String platform_name;
        private int sort_id;
        private String status;
        private String type;
        private String ad_img;
        private String rank;
        private String reward;
        private String publish_time;
        private String online_time;
        private String desc;
        private String publisher;
        private String appear_times;
        private String app_income;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTask_platform() {
            return task_platform;
        }

        public void setTask_platform(String task_platform) {
            this.task_platform = task_platform;
        }

        public String getPlatform_name() {
            return platform_name;
        }

        public void setPlatform_name(String platform_name) {
            this.platform_name = platform_name;
        }

        public int getSort_id() {
            return sort_id;
        }

        public void setSort_id(int sort_id) {
            this.sort_id = sort_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAd_img() {
            return ad_img;
        }

        public void setAd_img(String ad_img) {
            this.ad_img = ad_img;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getReward() {
            return reward;
        }

        public void setReward(String reward) {
            this.reward = reward;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getOnline_time() {
            return online_time;
        }

        public void setOnline_time(String online_time) {
            this.online_time = online_time;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getAppear_times() {
            return appear_times;
        }

        public void setAppear_times(String appear_times) {
            this.appear_times = appear_times;
        }

        public String getApp_income() {
            return app_income;
        }

        public void setApp_income(String app_income) {
            this.app_income = app_income;
        }
    }
}
