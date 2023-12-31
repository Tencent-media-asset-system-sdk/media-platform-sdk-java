import com.tencent.aimedia.MediaAPI;
import com.tencent.aimedia.AIMediaProxyClient;
import com.tencent.aimedia.TICertificate;
import com.tencent.aimedia.MediaProtocol;

public class MediaTest {
	public static void main(String[] args) throws Exception {
		
		String host = "host";
		int port = 80;
		String secretId = "secret_id";
		String secretKey = "secret_key";
		int businessid = 1;
		int projectid = 1;
		
		MediaAPI proxy = AIMediaProxyClient.newProxyClient(MediaAPI.class);
		
		MediaProtocol.CreateMediasRequest request = MediaProtocol.CreateMediasRequest.newBuilder().build();
        TICertificate cert = new TICertificate(host, port, secretId, secretKey, businessid, projectid);
        
        MediaProtocol.CreateMediasResponse result = proxy.createMedias(cert, request);
        System.out.printf("tRPC Call! request={%s} . response={%s}", request.toString(), result.toString());
	}
}
