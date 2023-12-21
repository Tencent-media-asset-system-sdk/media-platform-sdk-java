package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcClientContext;

public class TICertificate extends RpcClientContext {
	private String host;
	
	private int port;
	
	private String secretId;
	
	private String secretKey;
	
	private long tIBusinessId;
	
	private long tIProjectId;
	
	public TICertificate(String host, int port, String secretId, String secretKey, long businessId, long projectid) {
		if (port == 0) {
			port = 80;
		}
		this.host = host;
		this.port = port;
		this.secretId = secretId;
		this.secretKey = secretKey;
		this.tIBusinessId = businessId;
		this.tIProjectId = projectid;
	}
	
	
    @Override
	public TICertificate clone() {
    	return new TICertificate(this.host, this.port, this.secretId, this.secretKey, this.tIBusinessId, this.tIProjectId);
        
    }
	
	public int getPort() {
		return port;
	}
	
	public String getHost() {
		return host;
	}
	
    @Override
    public String toString() {
        return "";
    }
    
    
	
	public void setHost(String host) {
		this.host = host;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public long getTIBusinessId() {
		return tIBusinessId;
	}
	public void setTIBusinessId(int tIBusinessId) {
		this.tIBusinessId = tIBusinessId;
	}
	public long getTIProjectId() {
		return tIProjectId;
	}
	public void setTIProjectId(int tIProjectId) {
		this.tIProjectId = tIProjectId;
	}
}
