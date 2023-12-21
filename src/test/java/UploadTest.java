import java.nio.file.Files;
import java.nio.file.Paths;

import com.tencent.aimedia.AIMediaProxyClient;
import com.tencent.aimedia.TIFileManagerAPI;
import com.tencent.aimedia.TICertificate;

public class UploadTest {
	public static void main(String[] args) throws Exception {
		TIFileManagerAPI proxy = AIMediaProxyClient.newProxyClient(TIFileManagerAPI.class);
		String host = "host";
		int port = 80;
		String secretId = "secret_id";
		String secretKey = "secret_key";
		int businessid = 1;
		int projectid = 1;
        TICertificate cert = new TICertificate(host, port, secretId, secretKey, businessid, projectid);
        String f = "./中国足球_cut_10_300.mp4";
        byte filebuf[] = Files.readAllBytes(Paths.get(f));
        String key = proxy.uploadBuf(cert, filebuf, "中国足球_cut_10_300.mp4", 4);
        System.out.printf("file key %s", key);
//        byte[] buf = proxy.downLoadToBuf(cert, "/DownloadFile?Key=ti-base%2Fti-file-server%2Fupload%2F57%2F78%2Ff5453ee0eb008ea84abe52-RoAuQIvBKdgS4NMQ33sRhdbqA9gL64UH&Token=61eaf4851b047877d94e032904c318f4&IsTemp=false");
//        System.out.println(TIFileManagerAPI.calcMD5(buf));

	}
}
