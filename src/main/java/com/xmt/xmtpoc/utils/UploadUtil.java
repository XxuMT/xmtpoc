package com.xmt.xmtpoc.utils;


import com.xmt.xmtpoc.result.ResultFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 上传文件公共类
 * @date 2019/7/16
 */
public class UploadUtil {
    private final String UPLOAD_DIR_PREFIX = "/upload";

    public static ResultFactory uploadFile(MultipartFile file, String dir) {
        List<MultipartFile> fileList = new ArrayList<>();
        fileList.add(file);
        return null;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class uploadFileModel {
        private String path;

        private String fileName;

        private InputStream inputStream;
    }
}
