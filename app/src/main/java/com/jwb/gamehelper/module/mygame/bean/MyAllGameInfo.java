package com.jwb.gamehelper.module.mygame.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MyAllGameInfo {

    /**
     * total : 32
     * pagesize : 10
     * page : 1
     * page_total : 4
     */

    private PageBean page;
    /**
     * info : [{"id":"817","name":"战争时刻","score":"7.8","icon":"http://i3.72g.com/upload/201606/201606290918386815.png","size":"26M","dl_back_jifen":"100","limit_number":"0","dl_num":"371","android_dl":"http://market-download.kkk5.com/zzsk/zzsk_0_6915.apk","ios_dl":"","count_dl":"571","all_prize":1500,"game_statue":0},{"id":"812","name":"罗马时代:帝国OL","score":"7.5","icon":"http://i3.72g.com/upload/201606/201606071620204837.png","size":"22.58M","dl_back_jifen":"100","limit_number":"0","dl_num":"805","android_dl":"http://market-download.kkk5.com/lmsd/wzsj_0621_7316.apk","ios_dl":"","count_dl":"1005","all_prize":1500,"game_statue":0},{"id":"802","name":"江湖侠客令","score":"7.5","icon":"http://i3.72g.com/upload/201604/201604261014449013.jpg","size":"149MB","dl_back_jifen":"300","limit_number":"0","dl_num":"1645","android_dl":"http://m.51.com/tg/index/1009017.apk","ios_dl":"","count_dl":"1845","all_prize":2010,"game_statue":0},{"id":"798","name":"星辰奇缘","score":"8.0","icon":"http://i3.72g.com/upload/201604/201604011722162255.png","size":"151MB","dl_back_jifen":"300","limit_number":"0","dl_num":"1860","android_dl":"http://market-download.kkk5.com/xcqy/xcqy6803.apk","ios_dl":"","count_dl":"2135","all_prize":2500,"game_statue":0},{"id":"795","name":"皇图","score":"8.0","icon":"http://i3.72g.com/upload/201510/201510201430336075.png","size":"144MB","dl_back_jifen":"100","limit_number":"0","dl_num":"1793","android_dl":"http://dl.sy.9377.com/ht/ht_9377_sig_ht_masbz6.apk","ios_dl":"","count_dl":"2028","all_prize":3800,"game_statue":0},{"id":"793","name":"坦克前线","score":"8.5","icon":"http://i3.72g.com/upload/201603/201603031020598919.png","size":"24.2M","dl_back_jifen":"100","limit_number":"0","dl_num":"1915","android_dl":"http://market-download.kkk5.com/hjtk/RedAlerttank_0_2446.apk","ios_dl":"","count_dl":"2482","all_prize":1302,"game_statue":0},{"id":"792","name":"曹操传","score":"7.5","icon":"http://i3.72g.com/upload/201602/201602241014186510.png","size":"72.2MB","dl_back_jifen":"200","limit_number":"0","dl_num":"1719","android_dl":"http://market-download.kkk5.com/ccz/3kzhuan6088.apk","ios_dl":"","count_dl":"4692","all_prize":2000,"game_statue":0},{"id":"789","name":"御剑飞仙","score":"7.8","icon":"http://i3.72g.com/upload/201601/201601291631591381.png","size":"130MB","dl_back_jifen":"300","limit_number":"0","dl_num":"2052","android_dl":"http://market-download.kkk5.com/yjfx/journey_0_6321.apk","ios_dl":"","count_dl":"5071","all_prize":2500,"game_statue":0},{"id":"787","name":"CF暴击僵尸2015","score":"7.9","icon":"http://i3.72g.com/upload/201601/201601291217271989.png","size":"21.3MB","dl_back_jifen":"200","limit_number":"0","dl_num":"1578","android_dl":"http://open.play.cn/api/v2/egame/get_efs.json?efs_id=448f87ach2b5ffa7&channel_type=9&channel_code=20032453&file_type=800","ios_dl":"","count_dl":"4989","all_prize":1200,"game_statue":0},{"id":"221","name":"神魔","score":"7.3","icon":"http://p16.qhimg.com/t0125c185a342b0a353.png ","size":"160.77MB","dl_back_jifen":"300","limit_number":"1014","dl_num":"1014","android_dl":"http://api.np.mobilem.360.cn/redirect/down/?from=lm_157925&appid=730542","ios_dl":"","count_dl":"7166","all_prize":3000,"game_statue":1}]
     * page : {"total":32,"pagesize":10,"page":1,"page_total":4}
     * state : success
     */

    private String state;
    /**
     * id : 817
     * name : 战争时刻
     * score : 7.8
     * icon : http://i3.72g.com/upload/201606/201606290918386815.png
     * size : 26M
     * dl_back_jifen : 100
     * limit_number : 0
     * dl_num : 371
     * android_dl : http://market-download.kkk5.com/zzsk/zzsk_0_6915.apk
     * ios_dl :
     * count_dl : 571
     * all_prize : 1500
     * game_statue : 0
     */

    private List<InfoBean> info;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
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

    public static class PageBean {
        private int total;
        private int pagesize;
        private int page;
        private int page_total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPage_total() {
            return page_total;
        }

        public void setPage_total(int page_total) {
            this.page_total = page_total;
        }
    }

    public static class InfoBean {
        private String id;
        private String name;
        private String score;
        private String icon;
        private String size;
        private String dl_back_jifen;
        private String limit_number;
        private String dl_num;
        private String android_dl;
        private String ios_dl;
        private String count_dl;
        private int all_prize;
        private int game_statue;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getDl_back_jifen() {
            return dl_back_jifen;
        }

        public void setDl_back_jifen(String dl_back_jifen) {
            this.dl_back_jifen = dl_back_jifen;
        }

        public String getLimit_number() {
            return limit_number;
        }

        public void setLimit_number(String limit_number) {
            this.limit_number = limit_number;
        }

        public String getDl_num() {
            return dl_num;
        }

        public void setDl_num(String dl_num) {
            this.dl_num = dl_num;
        }

        public String getAndroid_dl() {
            return android_dl;
        }

        public void setAndroid_dl(String android_dl) {
            this.android_dl = android_dl;
        }

        public String getIos_dl() {
            return ios_dl;
        }

        public void setIos_dl(String ios_dl) {
            this.ios_dl = ios_dl;
        }

        public String getCount_dl() {
            return count_dl;
        }

        public void setCount_dl(String count_dl) {
            this.count_dl = count_dl;
        }

        public int getAll_prize() {
            return all_prize;
        }

        public void setAll_prize(int all_prize) {
            this.all_prize = all_prize;
        }

        public int getGame_statue() {
            return game_statue;
        }

        public void setGame_statue(int game_statue) {
            this.game_statue = game_statue;
        }
    }
}
