## MyOkhttp Wiki

> 该模块对Okhttp3进行二次封装,对外提供了POST请求,GET请求,上传文件,下载文件,取消请求和Gson转换等功能.

### 0 版本更新

|日期|更新内容|
|---|---|
|2016-08-17|完成POST请求,GET请求,上传文件,下载文件,取消请求和Gson转换功能|
|2016-08-18|结果回调增加RawResponseHandler-直接返回字符串|
|2016-08-30|调用请求增加无context参数的重载方法|

### 1 POST请求

```java
Map<String, String> params = new HashMap<String, String>();
params.put("name", "tsy");

MyOkHttp.get().post(this, "http://192.168.3.1/test_okhttp.php", params, new JsonResponseHandler() {
    @Override
    public void onSuccess(int statusCode, JSONObject response) {
        LogUtils.v(TAG, statusCode + " " + response);
    }

    @Override
    public void onFailure(int statusCode, String error_msg) {
        LogUtils.v(TAG, statusCode + " " + error_msg);
    }
});
```

### 2 GET请求

```java
Map<String, String> params = new HashMap<String, String>();
params.put("name", "tsy");

MyOkHttp.get().get(this, "http://192.168.3.1/test_okhttp.php", params, new RawResponseHandler() {
    @Override
    public void onSuccess(int statusCode, String response) {
        LogUtils.v(TAG, statusCode + " " + response);
    }

    @Override
    public void onFailure(int statusCode, String error_msg) {
        LogUtils.v(TAG, statusCode + " " + error_msg);
    }
});
```

### 3 上传文件

```java
Map<String, String> params = new HashMap<String, String>();
params.put("name", "tsy");

Map<String, File> files = new HashMap<String, File>();
File file = new File(Environment.getExternalStorageDirectory() + "/com.ci123.service.splashandroid/splash/1.png");
files.put("avatar", file);

MyOkHttp.get().upload(this, "http://192.168.3.1/test_post.php", params, files, new GsonResponseHandler<BB>() {
    @Override
    public void onFailure(int statusCode, String error_msg) {
        LogUtils.v(TAG, statusCode + " " + error_msg);
    }

    @Override
    public void onSuccess(int statusCode, BB response) {
        LogUtils.v(TAG, statusCode + " " + response.ret);
    }

    @Override
    public void onProgress(long currentBytes, long totalBytes) {
        LogUtils.v(TAG, currentBytes + "/" + totalBytes);
    }
});
```

### 4 下载文件

```java
MyOkHttp.get().download(this, "http://192.168.3.1/output_tmp.jpg",
        Environment.getExternalStorageDirectory() + "/com.tsy.splashandroid/", "1.jpg",
        new DownloadResponseHandler() {
    @Override
    public void onFinish(File download_file) {
        LogUtils.v(TAG, "onFinish:" + download_file.getPath());
    }

    @Override
    public void onProgress(long currentBytes, long totalBytes) {
        LogUtils.v(TAG, currentBytes + "/" + totalBytes);
    }

    @Override
    public void onFailure(String error_msg) {
        LogUtils.v(TAG, error_msg);
    }
});
```

### 5 取消请求(建议放在BaseActivity,BaseFragment的onDestroy中)

```java
MyOkHttp.get().cancel(this);
```

### 6 返回格式

post,get,upload3个接口可以选择返回格式为普通Json还是Gson

#### 6.1 普通json

回调继承JsonResponseHandler,例如POST请求的例子

#### 6.2 gson

回调继承GsonResponseHandler<T>,并设置泛型T,例如Upload请求的例子

#### 6.3 raw原始数据

回调继承RawResponseHandler,例如GET请求例子

### 7 tag

每个接口都有一个不带首个Context参数的重载函数:

```java
Map<String, String> params = new HashMap<String, String>();
params.put("name", "tsy");

MyOkHttp.get().post(this, "http://192.168.3.1/test_okhttp.php", params, new JsonResponseHandler() {
    @Override
    public void onSuccess(int statusCode, JSONObject response) {
        LogUtils.v(TAG, statusCode + " " + response);
    }

    @Override
    public void onFailure(int statusCode, String error_msg) {
        LogUtils.v(TAG, statusCode + " " + error_msg);
    }
});
```

```java
Map<String, String> params = new HashMap<String, String>();
params.put("name", "tsy");

MyOkHttp.get().post("http://192.168.3.1/test_okhttp.php", params, new JsonResponseHandler() {
    @Override
    public void onSuccess(int statusCode, JSONObject response) {
        LogUtils.v(TAG, statusCode + " " + response);
    }

    @Override
    public void onFailure(int statusCode, String error_msg) {
        LogUtils.v(TAG, statusCode + " " + error_msg);
    }
});
```

**如果不是在activity等中发起的请求可以使用后一个方法.前一个方法适用于在activity等中发起的请求,并在activity销毁的时候统一取消.**