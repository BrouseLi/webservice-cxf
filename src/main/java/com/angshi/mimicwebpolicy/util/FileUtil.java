package com.angshi.mimicwebpolicy.util;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class FileUtil {
    /**
     *
     * @param  path 文件保存路径
     * @param bytes 文件字节数组
     * @return
     */
    public static boolean writeFile(String path,byte[] bytes){
        File file =new File(path);
        try(OutputStream outputStream=new FileOutputStream(file)){;
            outputStream.write(bytes);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
            return false;
        }
        return true;
    }
    public static String getFileContent(String path)  {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.warn(e.getLocalizedMessage());
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (String str:lines){
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
