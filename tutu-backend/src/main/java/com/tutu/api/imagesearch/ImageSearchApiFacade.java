package com.tutu.api.imagesearch;

import com.tutu.api.imagesearch.model.ImageSearchResult;
import com.tutu.api.imagesearch.sub.GetImageFirstUrlApi;
import com.tutu.api.imagesearch.sub.GetImageListApi;
import com.tutu.api.imagesearch.sub.GetImagePageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author shkstart
 * @create 2025-02-13 16:51
 */
@Slf4j
public class ImageSearchApiFacade {

    /**
     * 搜索图片
     *
     * @param imageUrl
     * @return
     */
    public static List<ImageSearchResult> searchImage(String imageUrl) {
//        String imagePageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imagePageUrl = "https://graph.baidu.com/s?card_key=&entrance=GENERAL&extUiData%5BisLogoShow%5D=1&f=all&isLogoShow=1&session_id=8014247150711163646&sign=12177fb9c647f0065390301739435976&tpl_from=pc";
        // todo URL 固定死了
        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(imagePageUrl);
        List<ImageSearchResult> imageList = GetImageListApi.getImageList(imageFirstUrl);
        return imageList;
    }

    public static void main(String[] args) {
        // 测试以图搜图功能
        String imageUrl = "https://image.meiye.art/pic_9Ork9AmVdusXnn5W0HN1v?imageMogr2/thumbnail/640x/interlace/1";
        List<ImageSearchResult> resultList = searchImage(imageUrl);
        System.out.println("结果列表" + resultList);
    }
}
