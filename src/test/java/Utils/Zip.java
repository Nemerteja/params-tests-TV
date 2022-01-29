package Utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Zip {

    public static void unZip(String path, String pathunzip, String password) throws ZipException {
        ZipFile zipFile = new ZipFile(path);
        if (zipFile.isEncrypted()){
            zipFile.setPassword(password);
        }
        zipFile.extractAll(pathunzip);
    }
}
