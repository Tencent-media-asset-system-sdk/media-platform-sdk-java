package com.tencent.aimedia;

import com.tencent.trpc.core.rpc.RpcClientContext;

public class TICertificate extends RpcClientContext {
	private String host;
	
	private int port;
	
	private String secretId;
	
	private String secretKey;
	
	private int tIBusinessId;
	
	private int tIProjectId;
	
	public TICertificate(String host, int port, String secretId, String secretKey, int businessId, int projectid) {
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
	public int getTIBusinessId() {
		return tIBusinessId;
	}
	public void setTIBusinessId(int tIBusinessId) {
		this.tIBusinessId = tIBusinessId;
	}
	public int getTIProjectId() {
		return tIProjectId;
	}
	public void setTIProjectId(int tIProjectId) {
		this.tIProjectId = tIProjectId;
	}
}
