package com.tencent.aimedia;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class HttpClientUtil {
	/**
	 * httpClient的get请求方式 使用GetMethod来访问一个URL对应的网页实现步骤： 1.生成一个HttpClient对象并设置相应的参数；
	 * 2.生成一个GetMethod对象并设置响应的参数； 3.用HttpClient生成的对象来执行GetMethod生成的Get方法； 4.处理响应状态码；
	 * 5.若响应正常，处理HTTP响应内容； 6.释放连接。
	 * 
	 * @param url
	 * @param header
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 */
	public static GetMethod doGet(HashMap<String, String> header, String url) throws HttpException, IOException {
		// 1.生成HttpClient对象并设置参数
		HttpClient httpClient = new HttpClient();
		// 设置 HTTP 连接超时为30分钟
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1800 * 1000);
		// 2.生成GetMethod对象并设置参数
		GetMethod getMethod = new GetMethod(url);
		// 设置get请求超时为5秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 1800 * 1000);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		// 设置 header
		Iterator<HashMap.Entry<String, String>> iterable = header.entrySet().iterator();
		while (iterable.hasNext()) {
			HashMap.Entry<String, String> entry = iterable.next();
			getMethod.addRequestHeader(entry.getKey(), entry.getValue());
		}
		// 3.执行HTTP GET 请求
		int statusCode = httpClient.executeMethod(getMethod);
		// 4.判断访问的状态码
		if (statusCode != HttpStatus.SC_OK) {
			throw new IOException("请求出错：" + getMethod.getStatusLine());
		}
		return getMethod;
	}

	/**
	 * post请求
	 * 
	 * @param header
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 */
	public static String doPost(HashMap<String, String> header, String url, String body)
			throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1800 * 1000);
		PostMethod postMethod = new PostMethod(url);

		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 1800 * 1000);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		postMethod.addRequestHeader("accept", "*/*");
		postMethod.addRequestHeader("connection", "Keep-Alive");
		
		// 设置请求参数
		postMethod.setRequestEntity(new StringRequestEntity(body, null, null));
		// 设置 header
		Iterator<HashMap.Entry<String, String>> iterable = header.entrySet().iterator();
		while (iterable.hasNext()) {
			HashMap.Entry<String, String> entry = iterable.next();
			postMethod.addRequestHeader(entry.getKey(), entry.getValue());
		}
		int statusCode = httpClient.executeMethod(postMethod);
		if (statusCode != HttpStatus.SC_OK) {
			throw new IOException("请求出错：" + postMethod.getStatusLine());
		}
		return postMethod.getResponseBodyAsString();
	}

	public static String doPut(HashMap<String, String> header, String url, byte[] buffer)
			throws HttpException, IOException {
		// 1.生成HttpClient对象并设置参数
		HttpClient httpClient = new HttpClient();
		// 设置 HTTP 连接超时为30分钟
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1800 * 1000);
		// 2.生成GetMethod对象并设置参数
		PutMethod putMethod = new PutMethod(url);
		// 设置get请求超时为5秒
		putMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 1800 * 1000);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		putMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		
		putMethod.setRequestEntity(new ByteArrayRequestEntity(buffer));
		// 设置 header
		Iterator<HashMap.Entry<String, String>> iterable = header.entrySet().iterator();
		while (iterable.hasNext()) {
			HashMap.Entry<String, String> entry = iterable.next();
			putMethod.addRequestHeader(entry.getKey(), entry.getValue());
		}
		// 3.执行HTTP PUT 请求
		int statusCode = httpClient.executeMethod(putMethod);
		// 4.判断访问的状态码
		if (statusCode != HttpStatus.SC_OK) {
			throw new IOException("请求出错：" + putMethod.getStatusLine());
		}
		return putMethod.getResponseBodyAsString();
	}
}