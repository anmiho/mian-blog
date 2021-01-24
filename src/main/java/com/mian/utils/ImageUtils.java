package com.mian.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.mian.config.GiteeImgBedConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 图片上传工具类
 * @Author mian
 * @Date 2020/12/31 18:35
 */
public class ImageUtils {

    /**
     * 上传图片到Gitee
     */
    public static String upload(MultipartFile file, String flag)throws IOException {
        String trueFileName = file.getOriginalFilename();
        assert trueFileName != null;
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName = IdUtil.simpleUUID() + suffix;
        String paramImgFile = Base64.encode(file.getBytes());

        // 转存到Gitee图床仓库
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBedConfig.ACCESS_TOKEN);
        paramMap.put("message", GiteeImgBedConfig.CREATE_REPOS_MESSAGE);
        paramMap.put("content", paramImgFile);

        String targetDir = "";
        if ("a".equals(flag)){

            targetDir = GiteeImgBedConfig.IMG_FILE_DEST_PATH + fileName;
        }else {
            targetDir = "other/" + fileName;
        }

        String requestUrl = String.format(GiteeImgBedConfig.CREATE_REPOS_URL, GiteeImgBedConfig.OWNER,
                GiteeImgBedConfig.REPO_NAME, targetDir);

        String resultJson = HttpUtil.post(requestUrl, paramMap);

        System.out.println("resultJson = " + resultJson);

        if (JSONUtil.parseObj(resultJson).getObj("commit") != null) {
            return GiteeImgBedConfig.GITPAGE_REQUEST_URL + targetDir;
        }
        return null;
    }

    /**
     * 获得随机的头像
     */
    public static String getRandomImg(){
        String[] imgs = {
                "https://gitee.com/anmiho/blog-images/raw/master/other/377bc6ea369e476abec86a239764e205.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/02d8bf90255944e19605fdd9520a2207.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/3b4981dd486544b1943a691f237aed5b.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/fc92f46217714dbba748b381e7c272c5.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/d16ab6a0fd6343eb96fda27574abcdab.jpg"};
        return imgs[(int) (Math.random() * 5)];
    }

    /**
     * 获得随机的文章封面
     */
    public static String getRandomFace(){
        String[] imgs = {
                "https://gitee.com/anmiho/blog-images/raw/master/other/0dd8d71fb8de4fe2944c006d08240fc9.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/735ffcef4a1e41fcbb1b292d347ea83a.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/f9c56debcb4d455e96703fadf431bb4e.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/35ab1dc8a516434eb9856084cc43ae7a.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/2f94a9400d7a49f1af56f4b4c89158d5.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/aab5527fc1b140cbafe33b776d3e28ef.jpg",
                "https://gitee.com/anmiho/blog-images/raw/master/other/35d35ecb2cd446c4877f01627e74d0bf.jpg"

        };
        return imgs[(int) (Math.random() * 8)];
    }

    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }
}
