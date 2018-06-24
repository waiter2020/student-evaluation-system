package UPCmvc.development;

import UPCmvc.development.service.TransCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.dsig.TransformService;

/**
 * Created by lylllcc on 2017/7/21.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgTest {

    String img = "iVBORw0KGgoAAAANSUhEUgAAAC4AAAAsCAYAAAAacYo8AAAB+ElEQVRYhe2Z2UvDQBCHfwn9/xF80ifxBAUfFKxapHjhUazaStVaraKtB23xrtnTSdAXqUdrskkgH+QlsMvHMDuZnViaQAyxwxbolUTcNIm4aRJx0yTipknETZOImyYRN01sxVNhC3SNe+/hLGbiSkE9NMAzozESVxLiYANsfgiyshcPcf18D7Y4ApFbgLyuwop8qlBqyPqplxo8vwTduoVFr93bfXTFuQNxvAOWGYMsbQCvT97rz5FEJMW104YsrIItDEMcbcOiSvJ1hhI5cf3yALGbBVuaQKqyC9FB2iVS4vqxCb6ZJulxpOoVOOr7WVVkxL3KkZ0CJ2m7dQP2y4AtGuLM8VLDfezWNaXH70vC71UEA8/Ng6/PwCJp+cdJZrgRlwJibxnOzCBUrdLV0vAiTtKyWoQz3e9JW10uD0dcU7PUqMOZ7IO8OqE6rTqWvJ8IRVzTV5DNDkCe5L3I9zKgNy6u289Uq+foQC5CUzXpFbOHk1pTWT2gTm/Uq9v/wWjE1e0F+Oo0rFr533sZi7ib12J/BWIrDT/+OhmKuIYs5+kjMwuLvfmyoxFxdXcJvpOBfV7ED31TVxhJFXm4Tf31GnzJkQ8Cj7g8L0Hks0Cz5lu0XYIXL9CBPNryfd9AxdVlGYIOpU23Gj+j7RKouHsg5VkhkL3fAbEhDcaUV3gaAAAAAElFTkSuQmCC";

    @Autowired
    private TransCodeService transCodeService;

    @Test
    public void img(){
 //       String path = ".//uploadFiles/"+ 1507020129 + "/" + System.currentTimeMillis()+".png";
//        transCodeService.generateImage(img,path);
    }

}
