import com.tencent.aimedia.MediaAPI;
import com.tencent.aimedia.AIMediaProxyClient;
import com.tencent.aimedia.TICertificate;
import com.tencent.aimedia.MediaProtocol;

public class MediaTest {
	public static void main(String[] args) throws Exception {
		MediaAPI proxy = AIMediaProxyClient.newProxyClient(MediaAPI.class);
		
		MediaProtocol.CreateMediasRequest request = MediaProtocol.CreateMediasRequest.newBuilder().build();
        TICertificate cert = new TICertificate("xxx", 0, "xxx", "xxx", 1, 1);
        
        MediaProtocol.CreateMediasResponse result = proxy.createMedias(cert, request);
        System.out.printf("tRPC Call! request={%s} . response={%s}", request.toString(), result.toString());
	}
}
