# media-platform-sdk-java
使用此 sdk 快速对接腾讯媒体AI中台。
## USAGE(基于 mavan)
1. 下载 release 里面的 [jar包](https://github.com/Tencent-media-asset-system-sdk/media-platform-sdk-java/releases/download/3.3.0/media-platform-java-sdk-v3.3.jar)。
2. 安装到本地 mavan 仓库，执行
   ```shell
   mvn install:install-file -Dfile=/path/to/media-platform-java-sdk-v3.3.jar -DgroupId=media-platform-sdk-java -DartifactId=media-platform-sdk-java -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
   ```
3. 在项目 pom 中加入库依赖
   ```
   <dependency>
      <groupId>media-platform-sdk-java</groupId>
  	  <artifactId>media-platform-sdk-java</artifactId>
  	  <version>0.0.1-SNAPSHOT</version>
   </dependency>
   ```

## 代码示例
### 文件管理
sdk 封装了上传文件的流程，一个方法可以完成上传
```java
import java.nio.file.Files;
import java.nio.file.Paths;

import AIMediaProxyClient;
import TIFileManagerAPI;
import TICertificate;

// 创建文件管理代理 proxy
TIFileManagerAPI proxy = AIMediaProxyClient.newProxyClient(TIFileManagerAPI.class);

String host = "host";
int port = 80;
String secretId = "secret_id";
String secretKey = "secret_key";
int businessid = 1;
int projectid = 1;
int threads = 4; // 并行上传最大线程数量，上传过程占用最大内存 2 * threads * 8M
// 创建签名认证需要的信息
TICertificate cert = new TICertificate(host, port, secretId, secretKey, businessid, projectid);
String f = "./中国足球_cut_10_300.mp4";
String key = proxy.uploadFile(cert, f, threads);
System.out.printf("file key %s", key);
```

同时还支持 buf 上传，下载到文件，下载到内存。
```java
// 下载到文件
proxy.downLoadToFile(cert, url, filedir, filename);
// 下载到内存
byte[] buf = proxy.downLoadToBuf(cert, url);
// 上传 buf
proxy.uploadBuf(cert, buf, filename, threads);
```

### 业务API
以媒资管理为例
```java
import MediaAPI;
import AIMediaProxyClient;
import CommonProtocol;
import TICertificate;
import MediaProtocol;

String host = "host";
int port = 80;
String secretId = "secret_id";
String secretKey = "secret_key";
int businessid = 1;
int projectid = 1;
// 创建媒资管理代理 proxy
MediaAPI proxy = AIMediaProxyClient.newProxyClient(MediaAPI.class);

// 创建输入请求结构
MediaProtocol.MediaInfo mediainfo = MediaProtocol.MediaInfo.newBuilder().setMediaName(medianame).
setMediaType(CommonProtocol.MediaType.MEDIA_TYPE_VIDEO).
setMediaSource(CommonProtocol.MediaSourceType.MEDIA_SOURCE_TYPE_FRONT_PAGE).
build();
CommonProtocol.DomainGroupInfo domain = CommonProtocol.DomainGroupInfo.newBuilder().
  setDomainGroupType(CommonProtocol.DomainGroupType.DOMAIN_GROUP_TYPE_PUBLIC).build(); // 公开权限

MediaProtocol.FileInfo fileinfo = MediaProtocol.FileInfo.newBuilder().setFileName(filename).setKey(key).build();
MediaProtocol.MediaWorkflowTemplateInfo templateinfo = MediaProtocol.MediaWorkflowTemplateInfo.newBuilder().
  setWorkflowMode(CommonProtocol.WorkflowMode.WORKFLOW_MODE_CUSTOMER). // 用户资源必须配置成 WORKFLOW_MODE_CUSTOMER
  setAutoMatchTemplate(true). // 自动入库
  build();
  
MediaProtocol.MediaUnionInfo union = MediaProtocol.MediaUnionInfo.newBuilder().setMediaInfo(mediainfo).
  setDomainGroupInfo(domain).setFileInfo(fileinfo).setMediaWorkflowTemplateInfo(templateinfo).build();
MediaProtocol.CreateMediasRequest request = MediaProtocol.CreateMediasRequest.newBuilder().
  setMediaUnionInfoSet(0, union).build();

// 创建签名认证需要的信息
TICertificate cert = new TICertificate(host, port, secretId, secretKey, businessid, projectid);

// 调用 CreateMedias 接口
MediaProtocol.CreateMediasResponse result = proxy.createMedias(cert, request);
System.out.printf("tRPC Call! request={%s} . response={%s}", request.toString(), result.toString());
```

## 模块 proxy protocol 汇总
每个业务模块对应一个 XXXXAPI interface，用该 API 创建 pxoxy，proxy 下方法会对应接口文档中每个 api 接口。同时还有一个对应的 XXXProtocol class，有对应模块的输入输出协议的 class。
|模块|API|Protocol|
|---------|---------|---------|
|公共模块|无|CommonProtocol|
|文件管理模块|TIFileManagerAPI|无|
|资源管理模块|MediaAPI|MediaProtocol|
|任务管理模块|TaskAPI|TaskProtocol
|智能标签|AITagAPI|VideoStructureProtocol|
|智能拆条|AICutAPI|VideoStructureProtocol|
|智能编目|AICatalogAPI|VideoStructureProtocol|
|人脸集锦|PersonRetrievalAPI|PersonretrievalProtocol|
|自定义人脸库|UserDefinePersonAPI|PersonUserDefineProtocol|
|自定义标签|CustomFeatureAPI|CustomFeatureProtocol|
|内容中台检索模块|同资源管理|同资源管理|
|内容中台工具箱模块|ToolkitAPI|ToolkitProtocol|
|视频处理|YTVideoProcessAPI|YTVideoProcessProtocol|
|视频质检|VideoQualityEvaluationAPI|VideoQualityEvaluationProtocol|
|视频擦除标题字幕|RemoveCaptionAPI|VideoEraseProtocol|
|视频擦除logo|RemoveLogoAPI|VideoEraseProtocol|
