package cn.georgeyang.gycachedemo.bean;

import java.util.List;

/**
 * Created by george.yang on 17/3/12.
 */

public class Bean {

    /**
     * id : 12091810303
     * desc : 微博美女自拍
     * tags : ["小清新"]
     * owner : {"userName":"buobuk","userId":"495828387","userSign":"3170893824 495578591","isSelf":"0","portrait":"a3bd62756f62756b8d1d","isVip":"0","isLanv":"0","isJiaju":"","isHunjia":"","orgName":"","resUrl":"","cert":"","budgetNum":"","lanvName":"","contactName":""}
     * fromPageTitle : 微博美女自拍
     * column : 美女
     * parentTag :
     * date : 2016-10-25
     * downloadUrl : http://h.hiphotos.baidu.com/image/pic/item/94cad1c8a786c917805fddd9cb3d70cf3ac757f6.jpg
     * imageUrl : http://h.hiphotos.baidu.com/image/pic/item/94cad1c8a786c917805fddd9cb3d70cf3ac757f6.jpg
     * imageWidth : 586
     * imageHeight : 789
     * thumbnailUrl : http://imgt8.bdstatic.com/it/u=2,3501875711&fm=25&gp=0.jpg
     * thumbnailWidth : 230
     * thumbnailHeight : 309
     * thumbLargeWidth : 310
     * thumbLargeHeight : 417
     * thumbLargeUrl : http://h.hiphotos.baidu.com/image/w%3D310/sign=6277472aad51f3dec3b2bf65a4eff0ec/94cad1c8a786c917805fddd9cb3d70cf3ac757f6.jpg
     * thumbLargeTnWidth : 400
     * thumbLargeTnHeight : 538
     * thumbLargeTnUrl : http://h.hiphotos.baidu.com/image/w%3D400/sign=029b1581f1deb48ffb69a0dec01e3aef/94cad1c8a786c917805fddd9cb3d70cf3ac757f6.jpg
     * siteName :
     * siteLogo :
     * siteUrl :
     * fromUrl : http://www.mzitu.com/share
     * isBook : 0
     * bookId : 0
     * objUrl : http://ww3.sinaimg.cn/mw690/9d52c073jw1e7e0vkddxtj20ga0lxq4t.jpg
     * shareUrl : http://h.hiphotos.baidu.com/image/s%3D550%3Bc%3Dwantu%2C8%2C95/sign=b87103c2cafcc3ceb0c0c936a27eb5b5/94cad1c8a786c917805fddd9cb3d70cf3ac757f6.jpg?referer=54792dfbd60735fac8e77a8991ac
     * setId : -1
     * albumId : 401373990
     * isAlbum : 0
     * albumName :
     * albumNum : 1
     * userId : 495828387
     * isVip : 0
     * isDapei : 0
     * dressId :
     * dressBuyLink :
     * dressPrice : 0
     * dressDiscount : 0
     * dressExtInfo :
     * dressTag :
     * dressNum : 0
     * objTag : 小清新
     * dressImgNum : 0
     * hostName : www.mzitu.com
     * pictureId : 12091810303
     * pictureSign : 50f64d652f2eeecf80b766fafa10543a5ab59326
     * dataSrc :
     * contentSign : 2992101917,41074721
     * albumDi :
     * canAlbumId :
     * albumObjNum :
     * appId :
     * photoId :
     * fromName : 0
     * fashion : null
     * title : 微博美女自拍
     */

    public String id;
    public String desc;
    public OwnerBean owner;
    public String fromPageTitle;
    public String column;
    public String parentTag;
    public String date;
    public String downloadUrl;
    public String imageUrl;
    public int imageWidth;
    public int imageHeight;
    public String thumbnailUrl;
    public int thumbnailWidth;
    public int thumbnailHeight;
    public int thumbLargeWidth;
    public int thumbLargeHeight;
    public String thumbLargeUrl;
    public int thumbLargeTnWidth;
    public int thumbLargeTnHeight;
    public String thumbLargeTnUrl;
    public String siteName;
    public String siteLogo;
    public String siteUrl;
    public String fromUrl;
    public String isBook;
    public String bookId;
    public String objUrl;
    public String shareUrl;
    public String setId;
    public String albumId;
    public int isAlbum;
    public String albumName;
    public int albumNum;
    public String userId;
    public int isVip;
    public int isDapei;
    public String dressId;
    public String dressBuyLink;
    public int dressPrice;
    public int dressDiscount;
    public String dressExtInfo;
    public String dressTag;
    public int dressNum;
    public String objTag;
    public int dressImgNum;
    public String hostName;
    public String pictureId;
    public String pictureSign;
    public String dataSrc;
    public String contentSign;
    public String albumDi;
    public String canAlbumId;
    public String albumObjNum;
    public String appId;
    public String photoId;
    public int fromName;
    public String fashion;
    public String title;
    public List<String> tags;

    public static class OwnerBean {
        /**
         * userName : buobuk
         * userId : 495828387
         * userSign : 3170893824 495578591
         * isSelf : 0
         * portrait : a3bd62756f62756b8d1d
         * isVip : 0
         * isLanv : 0
         * isJiaju :
         * isHunjia :
         * orgName :
         * resUrl :
         * cert :
         * budgetNum :
         * lanvName :
         * contactName :
         */

        public String userName;
        public String userId;
        public String userSign;
        public String isSelf;
        public String portrait;
        public String isVip;
        public String isLanv;
        public String isJiaju;
        public String isHunjia;
        public String orgName;
        public String resUrl;
        public String cert;
        public String budgetNum;
        public String lanvName;
        public String contactName;
    }
}
