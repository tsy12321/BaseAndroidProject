package com.tsy.myokhttp.body;

import com.tsy.myokhttp.response.IResponseHandler;

import okhttp3.RequestBody;

/**
 * Created by tsy on 16/8/16.
 */
public class ProgressHelper {

    /**
     * 包装请求体用于上传文件的回调
     * @param requestBody 请求体RequestBody
     * @param responseHandler 进度回调接口
     * @return 包装后的进度回调请求体
     */
    public static ProgressRequestBody addProgressRequestListener(RequestBody requestBody, IResponseHandler responseHandler){
        //包装请求体
        return new ProgressRequestBody(requestBody,responseHandler);
    }
}
