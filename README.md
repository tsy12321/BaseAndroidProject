# BaseAndroidProject
Android项目基础架构。包含架构分层、基本工具层等, 持续更新中

## 架构

1. 基于MVP架构进行分层.详见[http://www.jianshu.com/p/2ca7767df08c](http://www.jianshu.com/p/2ca7767df08c)
1. 规范命名.详见[http://www.jianshu.com/p/fcdded2f8444](http://www.jianshu.com/p/fcdded2f8444)

## 底层库

### 网络库

采用二次封装后的okhttp3+Gson.(没有使用retrofit,考虑到服务端提供的API可能不会很标准)

基本功能:

1. POST请求
1. GET请求
1. 上传文件&进度监听
1. 下载文件&进度监听
1. 返回可以选择Gson格式
1. 取消某个context的所有网络请求

并且将该功能模块独立为MyOkhttp,可以重复使用.

详细使用见:

[MyOkhttp README](https://github.com/tsy12321/BaseAndroidProject/tree/master/myokhttp)

### 通用工具库

将常用的util封装到一个module - myutil

详细目录wiki见:

[MyUtil README](https://github.com/tsy12321/BaseAndroidProject/tree/master/myutil)

### 依赖注入库

ButterKnife.

详见[http://www.jianshu.com/p/32f6260ac300](http://www.jianshu.com/p/32f6260ac300)

### 图片开源库

Glide.

详见[http://www.jianshu.com/p/18618ad47d01](http://www.jianshu.com/p/18618ad47d01)

### 缓存开源库

ASimpleCache.

详见[http://www.jianshu.com/p/25c107ed7348](http://www.jianshu.com/p/25c107ed7348)

### Android M权限控制库

Easypermissions

详见[http://www.jianshu.com/p/2b3661928e66](http://www.jianshu.com/p/2b3661928e66)

### 欢迎关注我的公众号

![我的公众号](https://github.com/tsy12321/PayAndroid/blob/master/wxmp_avatar.jpg)
