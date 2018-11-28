package Helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by George on 14/12/2017.
 */
public class StoreImage {

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
