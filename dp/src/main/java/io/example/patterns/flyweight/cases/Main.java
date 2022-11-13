package io.example.patterns.flyweight.cases;

/**
 * @author luxz
 * @date 2022/11/13-17:15
 */
public class Main {
    public static void main(String[] args) {
        WebsiteFactory wf = new WebsiteFactory();

        Website wx = wf.getWebsite("产品展示");
        wx.use(new User("小菜"));
        Website wy = wf.getWebsite("产品展示");
        wy.use(new User("大鸟"));
        Website wz = wf.getWebsite("产品展示");
        wz.use(new User("娇娇"));

        Website f1 = wf.getWebsite("博客");
        f1.use(new User("老顽童"));
        Website f2 = wf.getWebsite("博客");
        f2.use(new User("桃谷六仙"));
        Website f3 = wf.getWebsite("博客");
        f3.use(new User("南海鳄神"));

        System.out.println("得到网站分类总数为：" + wf.getWebsiteCount());
    }
}
