package com.tencent.aimedia;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.eclipse.jetty.util.ajax.JSON;

import java.io.File;
import java.io.FileInputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.netty.util.concurrent.ScheduledFuture;

public class TIFileManagerAPI {
	
	private static int UPLOAD_BLOCK_SIZE = 8 * 1024 * 1024;
	
	private static class FileDownloadResponseHandler implements ResponseHandler<File> {

		private final File target;

		public FileDownloadResponseHandler(File target) {
			this.target = target;
		}

		@Override
		public File handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			InputStream source = response.getEntity().getContent();
			FileUtils.copyInputStreamToFile(source, this.target);
			return this.target;
		}

	}
	
	public static String calcMD5(byte[] buffer) throws RuntimeException {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(buffer);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有这个md5算法");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		int l = md5code.length();
		for (int i = 0; i < 32 - l; i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	private JsonNode checkResponseError(String response) throws ResponseErrorException,
			UnsupportedEncodingException, JsonMappingException, JsonProcessingException {
//		byte[] utf8Bytes = response.getBytes("ISO-8859-1");
//        response = new String(utf8Bytes, "UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);
        if (rootNode.get("Response").has("Error")) {
        	JsonNode err = rootNode.get("Response").get("Error");
        	throw new ResponseErrorException(err.get("Code").asText(), err.get("Message").asText(),
        			rootNode.get("Response").get("RequestId").asText());
        }
        return rootNode.get("Response");
	}
	
	public void createDeleteFileTask(TICertificate cert, String key)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "CreateDeleteFileTask";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "POST";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("FileKeys", new String[]{key});
		body.put("Async", false);
		String url = "http://" + host + ":" + port + "/FileManager/CreateDeleteFileTask";
		String input = JSON.toString(body);
		String response = HttpClientUtil.doPost(httpHeaderMap, url, input);
		JsonNode rootNode = checkResponseError(response);
		if (!rootNode.get("FailedFileKeys").get(0).isNull()) {
			throw new ResponseErrorException("Failed", rootNode.get("FailedFileKeys").get(0).get("Reason").asText(),
        			rootNode.get("RequestId").asText());
		}
	}
	
	private String describeUploadKey(TICertificate cert, String name, long fileSize)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "DescribeUploadKey";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "POST";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		Map<String, Object> body = new HashMap<String, Object>();
		Map<String, Object> describeUploadKey = new HashMap<String, Object>();
		describeUploadKey.put("FileName", name);
		describeUploadKey.put("Size", Long.toString(fileSize));
		body.put("DescribeUploadKey", describeUploadKey);
		
		String url = "http://" + host + ":" + port + "/FileManager/DescribeUploadKey?useJson=true";
		String input = JSON.toString(body);
		String response = HttpClientUtil.doPost(httpHeaderMap, url, input);
		JsonNode rootNode = checkResponseError(response);
		return rootNode.get("Key").asText();
	}
	
	
	private String createMultipartUpload(TICertificate cert, String key)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "CreateMultipartUpload";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "POST";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		
		String url = "http://" + host + ":" + port + "/FileManager/CreateMultipartUpload?useJson=true&Bucket=&Key=" +
				URLEncoder.encode(key, "UTF-8");
		String response = HttpClientUtil.doPost(httpHeaderMap, url, "");
		JsonNode rootNode = checkResponseError(response);
		if (rootNode.get("InitiateMultipartUploadResult").get("UploadId").isNull()) {
			throw new ResponseErrorException("ProtocolError", rootNode.toString(), rootNode.get("RequestId").asText());
		}
		return rootNode.get("InitiateMultipartUploadResult").get("UploadId").asText();
	}
	
	private void completeMultipartUpload(TICertificate cert, String key, String uploadId)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "CompleteMultipartUpload";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "POST";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("CompleteMultipartUpload", null);
		String input = JSON.toString(body);
		String url = "http://" + host + ":" + port +  "/FileManager/CompleteMultipartUpload?useJson=true&Bucket=&Key=" +
				URLEncoder.encode(key, "UTF-8") + "&uploadId=" + uploadId;
		String response = HttpClientUtil.doPost(httpHeaderMap, url, input);
		checkResponseError(response);
	}
	
	private String completeMultipartUploadAsync(TICertificate cert, String key, String uploadId)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "CompleteMultipartUploadAsync";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "POST";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("CompleteMultipartUpload", null);
		String input = JSON.toString(body);
		String url = "http://" + host + ":" + port +  "/FileManager/CompleteMultipartUploadAsync?useJson=true&Bucket=&Key=" +
				URLEncoder.encode(key, "UTF-8") + "&uploadId=" + uploadId;
		String response = HttpClientUtil.doPost(httpHeaderMap, url, input);
		JsonNode rootNode = checkResponseError(response);
		if (rootNode.get("TaskId").isNull()) {
			throw new ResponseErrorException("ProtocolError", rootNode.toString(), rootNode.get("RequestId").asText());
		}
		return rootNode.get("TaskId").asText();
	}
	
	private String[] DescribeAsyncTask(TICertificate cert, String taskId)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "DescribeAsyncTask";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/json";
		String httpMethod = "POST";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		Map<String, Object> body = new HashMap<String, Object>();
		String input = JSON.toString(body);
		String url = "http://" + host + ":" + port +  "/FileManager/DescribeAsyncTask?useJson=true&TaskId=" + taskId;
		String response = HttpClientUtil.doPost(httpHeaderMap, url, input);
		JsonNode rootNode = checkResponseError(response);
		
		if (rootNode.get("DescribeAsyncTaskResult").isNull()) {
			throw new ResponseErrorException("ProtocolError", rootNode.toString(), rootNode.get("RequestId").asText());
		}
		return new String[]{rootNode.get("DescribeAsyncTaskResult").get("Status").asText(),
			rootNode.get("DescribeAsyncTaskResult").get("Message").asText()};
	}
	
	private void putObject(TICertificate cert, String key, String bucket, byte[] filebuf)
			throws IOException, RuntimeException, ResponseErrorException {
		String action = "PutObject";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "PUT";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		String md5sum = calcMD5(filebuf);
		String canonicalQueryString = "useJson=true&Bucket=" + bucket + "&Key=" + URLEncoder.encode(key, "UTF-8") + "&Content-MD5=" + md5sum;
		String url = "http://" + host + "/FileManager/PutObject?" + canonicalQueryString;
		String response = HttpClientUtil.doPut(httpHeaderMap, url, filebuf);
		
		checkResponseError(response);
	}
	
	private void uploadPart(TICertificate cert, String key, String uploadId, String bucket, int partNumber, byte[] filebuf)
			throws  IOException, RuntimeException, ResponseErrorException {
		String action = "UploadPart";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "PUT";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}

		String md5sum = calcMD5(filebuf);
		String canonicalQueryString = "useJson=true&Bucket=" + bucket + "&Key=" + URLEncoder.encode(key, "UTF-8")
				+ "&uploadId=" + uploadId + "&partNumber=" + partNumber + "&Content-MD5=" + md5sum;
		String url = "http://" + host + ":" + port + "/FileManager/UploadPart?" + canonicalQueryString;
		String response = HttpClientUtil.doPut(httpHeaderMap, url, filebuf);
		checkResponseError(response);
	}
	
	public String uploadFile(TICertificate cert, String filepath, int threads) throws Exception {
		if (threads == 0) {
			threads = 4;
		}
		File file = new File(filepath);
		if (!file.exists()) {
			throw new IOException(filepath + "文件不存在");
		}
		Long filelength = file.length();

		String bucket = "";
		Path path = Paths.get(filepath);
        String filename = path.getFileName().toString();
		String key = this.describeUploadKey(cert, filename, filelength);
		ExecutorService exec = Executors.newCachedThreadPool(); // 缓存线程池
		final Semaphore semp = new Semaphore(threads); // 最大并发上传，防止内存溢
		InputStream in = new FileInputStream(file);
		if (filelength <= UPLOAD_BLOCK_SIZE) {
			// 不需要分片
			byte[] filecontent = IOUtils.toByteArray(in);
			int sleepTime = 50;
			int tryTime = 5;
			Exception e = null;
			while (tryTime-- > 0) {
				e = null;
				try {
					putObject(cert, key, bucket, filecontent);
				} catch (Exception e1) {
					e = e1;
				}
				Thread.sleep(sleepTime);
				sleepTime *= 2;
			}
			if (e != null) {
				try {
					this.createDeleteFileTask(cert, key);
				} catch (Exception e1) {
				}
				in.close();
				throw e;
			}
		} else {
			int partNumber = 0;
			String uploadId = this.createMultipartUpload(cert, key);
			final Exception[] exception = new Exception[1];

			while (exception[0] == null) {
				byte[] readBuf = new byte[UPLOAD_BLOCK_SIZE];
				int nread = in.read(readBuf);
				if (nread <= 0) {
					in.close();
					break;
				}

				byte[] filecontent;
				if (nread == UPLOAD_BLOCK_SIZE) {
					filecontent = readBuf;
				} else {
					filecontent = Arrays.copyOf(readBuf, nread);
				}
				
				semp.acquire();
				final int number = ++partNumber;
				Runnable run = new Runnable() {
					public void run() {
						int maxTry = 5;
						int sleepTime = 50;
						while (maxTry-- > 0) {
							boolean bk = true;
							try {
								uploadPart(cert, key, uploadId, bucket, number, filecontent);
							} catch (Exception e) {
								if (maxTry == 0) {
									try {
										createDeleteFileTask(cert, key);
									} catch (Exception e1) {
									}
									exception[0] = e;
								} else {
									bk = false;
								}
							}
							if (bk) {
								break;
							}
							try {
								Thread.sleep(sleepTime);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							sleepTime *= 2;
						}
						semp.release();
					};
				};
				exec.execute(run);
			}
			for (int i = 0; i < threads; i++) {
				semp.acquire();
			}
			exec.shutdown();
			if (exception[0] != null) {
				throw exception[0];
			}
			
			String taskId = this.completeMultipartUploadAsync(cert, key, uploadId);
			
			// 定制任务轮询文件合并任务的状态
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
			String failedReson[] = {""};
			int failedCnt[] = {50};
			Runnable task = () -> {
				String res[];
				try {
					res = this.DescribeAsyncTask(cert, taskId);
					if (res[0].equals("FINISHED")) {
						executor.shutdown();
					} else if (res[0].equals("FAILED") || res[0].equals("ABNORMAL")) {
						failedReson[0] = String.format("upload %s: %s", res[0], res[1]);
						executor.shutdown();
		            }
				} catch (Exception e) {
					failedCnt[0]--;
					if (failedCnt[0] == 0) {
						failedReson[0] = "uploadBigFile.DescribeAsyncTask too many error: " + e.toString();
						executor.shutdown();	
					}
				}
	        };
	        // 按照 100m/s, 预估合并用时
	    	int expectedSeconds = (int) (filelength/1000000000);
	    	if (expectedSeconds == 0) {
	    		expectedSeconds = 1;
	    	}
	    	if (expectedSeconds > 10) {
	    		expectedSeconds = 10;
	    	}
	        java.util.concurrent.ScheduledFuture<?> future = executor.scheduleAtFixedRate(task, 
	        		expectedSeconds, expectedSeconds, TimeUnit.SECONDS);
	        // 等待 future 完成
	        try {
	        	executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	        } catch (Exception e) {
//	            e.printStackTrace();
	        }
	        if (failedReson[0] != "") {
	        	throw new IOException("文件上传失败，原因: " + failedReson[0]);
	        }
		}
		
		
		return key;
	}
	
	public String uploadBuf(TICertificate cert, byte[] fileBuf, String filename, int threads) throws Exception {
		if (threads == 0) {
			threads = 4;
		}
		String bucket = "";
		String key = this.describeUploadKey(cert, filename, fileBuf.length);
		ExecutorService exec = Executors.newCachedThreadPool(); // 缓存线程池
		final Semaphore semp = new Semaphore(threads); // 最大并发上传，防止内存溢
		if (fileBuf.length <= UPLOAD_BLOCK_SIZE) {
			// 不需要分片
			int sleepTime = 50;
			int tryTime = 5;
			Exception e = null;
			while (tryTime-- > 0) {
				e = null;
				try {
					putObject(cert, key, bucket, fileBuf);
				} catch (Exception e1) {
					e = e1;
				}
				Thread.sleep(sleepTime);
				sleepTime *= 2;
			}
			if (e != null) {
				try {
					this.createDeleteFileTask(cert, key);
				} catch (Exception e1) {
				}
				throw e;
			}
		} else {
			int partNumber = 0;
			String uploadId = this.createMultipartUpload(cert, key);
			final Exception[] exception = new Exception[1];
			for (int i = 0; i < fileBuf.length; i += UPLOAD_BLOCK_SIZE) {
				if (exception[0] != null) {
					break;
				}
				int end = Math.min(i + UPLOAD_BLOCK_SIZE, fileBuf.length);
				byte[] filecontent = Arrays.copyOfRange(fileBuf, i, end);
				semp.acquire();
				final int number = ++partNumber;
				Runnable run = new Runnable() {
					public void run() {
						int maxTry = 5;
						int sleepTime = 50;
						while (maxTry-- > 0) {
							boolean bk = true;
							try {
								uploadPart(cert, key, uploadId, bucket, number, filecontent);
							} catch (Exception e) {
								if (maxTry == 0) {
									try {
										createDeleteFileTask(cert, key);
									} catch (Exception e1) {
									}
									exception[0] = e;
								} else {
									bk = false;
								}
							}
							if (bk) {
								break;
							}
							try {
								Thread.sleep(sleepTime);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							sleepTime *= 2;
						}
						semp.release();
					};
				};
				exec.execute(run);
			}
			for (int i = 0; i < threads; i++) {
				semp.acquire();
			}
			exec.shutdown();
			if (exception[0] != null) {
				throw exception[0];
			}
			this.completeMultipartUpload(cert, key, uploadId);
		}
		return key;
	}

	public byte[] downLoadToBuf(TICertificate cert, String url) throws IOException {
		String action = "DownloadFile";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "GET";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		return HttpClientUtil.doGet(httpHeaderMap, "http://" + host + ":" + port + "/" + url).getResponseBody();
	}
	
	@SuppressWarnings("deprecation")
	public File downLoadToFile(TICertificate cert, String url, String dirName, String fileName) throws IOException {
		File dir = new File(dirName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String action = "DownloadFile";
		String service = "fusion-media-service";
		String version = "2022-03-02";
		String contentType = "application/octet-stream";
		String httpMethod = "GET";
		String secretId = cert.getSecretId();
		String secretKey = cert.getSecretKey();
		String host = cert.getHost();
		int port = cert.getPort();
		TiSign ts = new TiSign(host, action, version, service, contentType, httpMethod, secretId, secretKey);
		HashMap<String, String> httpHeaderMap = new HashMap<String, String>();
		try {
			ts.CreateHeaderWithSignature(httpHeaderMap);
		} catch (Exception e) {
			throw new IOException("生成签名错误: " + e.toString());
		}
		CloseableHttpClient httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
		try {
			HttpGet httpget = new HttpGet("http://" + host + ":" + port + "/" + url);
			// 设置 header
			Iterator<HashMap.Entry<String, String>> iterable = httpHeaderMap.entrySet().iterator();
			while (iterable.hasNext()) {
				HashMap.Entry<String, String> entry = iterable.next();
				httpget.setHeader(entry.getKey(), entry.getValue());
			}
			File downloaded = httpclient.execute(httpget, new FileDownloadResponseHandler(new File(dirName, fileName)));
			return downloaded;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			IOUtils.closeQuietly(httpclient);
		}
	}
}

