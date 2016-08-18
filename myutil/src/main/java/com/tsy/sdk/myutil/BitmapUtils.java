package com.tsy.sdk.myutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Bitmap相关工具类
 * Created by tsy on 16/7/26.
 */
public class BitmapUtils {

    private static final String TAG = "BitmapUtils";

    /**
     * RGB_565方式读取资源到Bitmap
     * @param context 全局context
     * @param resId 资源id
     * @return bitmap
     */
    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    /**
     * RGB_565方式读取资源到Bitmap
     * @param path 文件图片路径
     * @return bitmap
     */
    public static Bitmap readBitMap(String path) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        return BitmapFactory.decodeFile(path, opt);
    }

    /**
     * Bitmap 转 byte[]
     * @param bitmap 待转bitmap
     * @return 成功-byte[] 失败-null
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if(bitmap != null && !bitmap.isRecycled()) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                if(byteArrayOutputStream.toByteArray() == null) {
                    LogUtils.e(TAG, "bitmap2Bytes byteArrayOutputStream toByteArray=null");
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                LogUtils.e(TAG, "bitmap2Bytes exception", e);
            } finally {
                if(byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException var14) {
                        ;
                    }
                }
            }

            return null;
        } else {
            LogUtils.e(TAG, "bitmap2Bytes bitmap == null or bitmap.isRecycled()");
            return null;
        }
    }

    /**
     * 压缩图片到指定byte大小 (在保证质量的情况下尽可能压缩 不保证压缩到指定字节)
     * @param datas 图片byte格式
     * @param byteCount 指定压缩到字节数
     * @return 压缩后的byte[] (不保证压缩到指定字节)
     */
    public static byte[] compressBitmap(byte[] datas, int byteCount) {
        boolean isFinish = false;
        if(datas != null && datas.length > byteCount) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Bitmap tmpBitmap = BitmapFactory.decodeByteArray(datas, 0, datas.length);
            int times = 1;
            double percentage = 1.0D;

            while(!isFinish && times <= 10) {
                percentage = Math.pow(0.8D, (double)times);
                int compress_datas = (int)(100.0D * percentage);
                tmpBitmap.compress(Bitmap.CompressFormat.JPEG, compress_datas, outputStream);
                if(outputStream != null && outputStream.size() < byteCount) {
                    isFinish = true;
                } else {
                    outputStream.reset();
                    ++times;
                }
            }

            if(outputStream != null) {
                byte[] outputStreamByte = outputStream.toByteArray();
                if(!tmpBitmap.isRecycled()) {
                    tmpBitmap.recycle();
                }

                if(outputStreamByte.length > byteCount) {
                    LogUtils.e(TAG, "compressBitmap cannot compress to " + byteCount + ", after compress size=" + outputStreamByte.length);
                }

                return outputStreamByte;
            }
        }

        return datas;
    }
}
