# MyUtil Wiki

> 该模块对通用的工具类进行封装,方便移植到其他项目直接使用

## 0 版本更新

|日期|更新内容|
|---|---|
|2016-08-18|完成一些基本util的封装|


## 目录

- BitmapUtils 主要负责Bitmap相关工具方法
- DeviceUtils 设备属性相关工具类
- HttpURLConnectionUtils 一个基于HttpURLConnection 简单网络请求工具类
- LogUtils LOG工具类
- ManifestUtils manifest工具类
- MD5Utils MD5相关工具类
- NetworkUtils 网络相关工具类
- StringUtils 字符串相关方法
- ToastUtils Toast相关方法

## 1 BitmapUtils

> 主要负责Bitmap相关工具方法

### 1.1 Bitmap readBitMap(Context context, int resId)

```java
/**
 * RGB_565方式读取资源到Bitmap
 * @param context 全局context
 * @param resId 资源id
 * @return bitmap
 */
```

### 1.2 Bitmap readBitMap(String path)

```java
/**
 * RGB_565方式读取资源到Bitmap
 * @param path 文件图片路径
 * @return bitmap
 */
```

### 1.3 byte[] bitmap2Bytes(Bitmap bitmap)

```java
/**
 * Bitmap 转 byte[]
 * @param bitmap 待转bitmap
 * @return 成功-byte[] 失败-null
 */
```

### 1.4 byte[] compressBitmap(byte[] datas, int byteCount)

```java
/**
 * 压缩图片到指定byte大小 (在保证质量的情况下尽可能压缩 不保证压缩到指定字节)
 * @param datas 图片byte格式
 * @param byteCount 指定压缩到字节数
 * @return 压缩后的byte[] (不保证压缩到指定字节)
 */
```

## 2 DeviceUtils

> 设备属性相关工具类

### 2.1 int getDeviceDpi(Context context)

```java
/**
 * 获取设备密度
 * @param context 全局context
 * @return 设备dpi
 */
```

### 2.2 int[] getDeviceSize(Context context)

```java
/**
 * 获取设备宽 高 单位像素
 * @param context 全局context
 * @return int[]
 *      [0] 设备宽(像素)
 *      [1] 设备高(像素)
 */
```

### 2.3 int dip2px(Context context, float dpValue)

```java
/**
 * 根据手机的分辨率从从dp转成为px(像素)
 * @param context 全局context
 * @param dpValue dp值
 * @return px像素值
 */
```

### 2.4 int px2dip(Context context, float pxValue)

```java
/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 * @param context 全局context
 * @param pxValue px像素值
 * @return dp值
 */
```

## 3 HttpURLConnectionUtils

> 一个基于HttpURLConnection 简单网络请求工具类

### 3.1 doPost(final String url, final Map<String, String> params, final HttpResponseCallBack callback)

```java
/**
 * 异步传输post请求 仅文本参数
 * @param url 请求地址
 * @param params 请求参数
 * @param callback 请求回调
 */
```

### 3.2 doPost(final String url, final Map<String, String> params, final Map<String, String> file, final HttpResponseCallBack callback)

```java
/**
 * 异步传输post请求 文本 文件混合参数
 * @param url 请求地址
 * @param params 文本参数
 * @param file 上传文件参数
 * @param callback 请求回调
 */
```

### 3.3 doGet(final String url, final HttpResponseCallBack callback)

```java
/**
 * 异步传输get请求
 * @param url 请求url
 * @param callback 请求回调
 */
```

## 4 LogUtils

> LOG工具类 默认tag-LOGUTIL

### 4.1 void setLogEnable(boolean enable)

```java
/**
 * 设置是否显示Log
 * @param enable true-显示 false-不显示
 */
```

### 4.2 void v(String msg)  /  void v(String tag, String msg)

```java
/**
 * verbose log
 * @param tag tag
 * @param msg log msg
 */
```

### 4.3 其他的i, d, w, e 都类似以上格式


## 5 ManifestUtils

> manifest工具类

### 5.1 String getMetaData(Context context, String key)

```java
/**
 * 返回Manifest指定meta-data值
 * @param context 全局context
 * @param key meta-data key
 * @return
 *      成功-value
 *      失败-""
 */
```

### 5.2 String getVersionName(Context context)

```java
/**
 * 获取版本名
 * @param context 全局context
 * @return versoin name
 */
```

## 6 MD5Utils

> MD5相关工具类

### 6.1 String getMd5(String plainText)

```java
/**
 * md5加密
 * @param plainText 待加密字符串
 * @return 加密后32位字符串
 */
```

## 7 NetworkUtils

> 网络相关工具类

### 7.1 Boolean checkNetworkConnect(Context context)

```java
/**
 * 检查网络是否连接
 * @param context 全局context
 * @return true 已连接 false 未连接
 */
```

## 8 StringUtils

> 字符串相关方法

### 8.1 Boolean isEmpty(String str)

```java
/**
 * 是否为空
 * @param str 字符串
 * @return true 空 false 非空
 */
```

## 9 ToastUtils

> Toast相关方法

### 9.1 void showShort(Context context, int resId) / showLong(Context context, int resId)

```java
/**
 * 显示short/long message
 * @param context 全局context
 * @param resId string string资源id
 */
```

### 9.2 void showShort(Context context, String message) / showLong(Context context, String message)

```java
/**
 * 显示short/long message
 * @param context 全局context
 * @param message 显示msg
 */
```