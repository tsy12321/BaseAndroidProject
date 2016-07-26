package com.tsy.baseandroidproject.Base;

import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * BaseApi
 * Created by tsy on 16/7/21.
 */
public class BaseApi {

    private static final String mBaseUrl = "http://www.baidu.com/";

    protected Retrofit mRetrofit;

    private final String TAG = "BaseApi";

    public BaseApi() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public BaseApi(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    //处理retrofit回调 并调用ApiCallback相应返回
    protected class RetrofitCallback<T> implements Callback<T> {

        private ApiCallback<T> mCallback;

        public RetrofitCallback(ApiCallback<T> callback) {
            mCallback = callback;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if(response.isSuccessful()) {
                if(((BaseRetData)response.body()).ret == 1) {
                    mCallback.onSuccess(((T)response.body()));
                } else {
                    mCallback.onError(((BaseRetData)response.body()).err_code, ((BaseRetData)response.body()).err_msg);
                }
            } else {
                mCallback.onFailure();
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.e(TAG, "api failure,throw=" + t.getMessage());
            t.printStackTrace();
            mCallback.onFailure();
        }
    }

    //api调用回调
    public interface ApiCallback<T> {
        void onSuccess(T ret);        //ret=1时返回
        void onError(int err_code, String err_msg);   //ret=0时返回
        void onFailure();   //网络请求失败
    }

    //文件下载回调
    public interface FileDownloadCallback {
        void onSuccess();   //下载成功返回
        void onProcess(long fileSizeDownloaded, long fileSize);   //下载进度
        void onFailure();   //网络请求失败
    }

    /**
     * 下载文件
     * @param fileUrl 下载url
     * @param filePath 本地保存path
     * @param callback FileDownloadCallback回调
     */
    public void downloadFile(final String fileUrl, final String filePath, final FileDownloadCallback callback) {
        final ApiStore apiStore = mRetrofit.create(ApiStore.class);

        new AsyncTask<Void, Long, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                Call<ResponseBody> call = apiStore.downloadFile(fileUrl);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            new AsyncTask<Void, Void, Void>() {

                                private boolean mWrittenToDisk;

                                @Override
                                protected Void doInBackground(Void... voids) {
                                    mWrittenToDisk = writeResponseBodyToDisk(response.body(), filePath, callback);
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(Void aVoid) {
                                    if(mWrittenToDisk) {
                                        callback.onSuccess();
                                    } else {
                                        callback.onFailure();
                                    }
                                }
                            }.execute();


                        } else {
                            callback.onFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callback.onFailure();
                    }
                });
                return null;
            }
        }.execute();
    }

    /**
     * responsebody写入文件
     * @param body
     * @param filePath
     * @param callback
     * @return
     */
    private boolean writeResponseBodyToDisk(ResponseBody body, String filePath, FileDownloadCallback callback) {
        try {
            File file = new File(filePath);

            String dir = filePath.substring(0, filePath.lastIndexOf('/'));
            File fileDir = new File(dir);
            if(!fileDir.exists()) {
                fileDir.mkdirs();
            }

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(file);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    callback.onProcess(fileSizeDownloaded, fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                file.delete();
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    public interface ApiStore {
        @Streaming
        @GET
        Call<ResponseBody> downloadFile(@Url String fileUrl);
    }
}