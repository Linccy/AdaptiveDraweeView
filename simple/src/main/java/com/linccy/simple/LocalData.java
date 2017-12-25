package com.linccy.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假数据
 */

public class LocalData {

    public static List<DataBean> DATABEAN_LIST = new ArrayList<>(Arrays.asList(
            new DataBean(0, "这里是文本0", "http://img0.imgtn.bdimg.com/it/u=2899834686,2940744334&fm=27&gp=0.jpg"),
            new DataBean(1, "这里是文本1", "http://img0.imgtn.bdimg.com/it/u=4116804551,2658943199&fm=27&gp=0.jpg"),
            new DataBean(2, "这里是文本2", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1358385298,3058583838&fm=27&gp=0.jpg"),
            new DataBean(3, "这里是文本3", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3551525332,1140181607&fm=200&gp=0.jpg"),
            new DataBean(4, "这里是文本4", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=995535741,972784700&fm=200&gp=0.jpg"),
            new DataBean(5, "这里是文本5", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=342543380,2079081224&fm=27&gp=0.jpg"),
            new DataBean(6, "这里是文本6", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1266815233,3677686539&fm=27&gp=0.jpg"),
            new DataBean(7, "这里是文本7", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2149684868,3670039563&fm=27&gp=0.jpg"),
            new DataBean(8, "这里是文本8", "http://img2.imgtn.bdimg.com/it/u=2972192042,773757762&fm=27&gp=0.jpg"),
            new DataBean(9, "这里是文本9", "http://img4.imgtn.bdimg.com/it/u=3300158502,1391229842&fm=27&gp=0.jpg")
    ));

    /**
     * 实体类
     */
    public static class DataBean {
        private int id;
        private String text;
        private String imageUrl;

        public DataBean(int id, String text, String imageUrl) {
            this.id = id;
            this.text = text;
            this.imageUrl = imageUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
