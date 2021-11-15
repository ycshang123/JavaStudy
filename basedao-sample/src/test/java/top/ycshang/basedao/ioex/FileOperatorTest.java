package top.ycshang.basedao.ioex;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOperatorTest {


    @Test
    void createDir() {
        String path = "D:\\test";
        boolean res = FileOperator.createDir(path);
        assertTrue(res);
    }

    @Test
    void createFile() {
        String path = "D:\\test\\hello.txt";
        boolean res = false;
        try {
            res = FileOperator.createFile(path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        assertTrue(res);
    }

    @Test
    void getFileInfo() {
        File file = new File("D:\\images\\1.jpg");
        Properties fileProperties = FileOperator.getFileInfo(file);
        assertEquals(4, fileProperties.size());
    }

    @Test
    void deleteFile() {
        boolean res = FileOperator.deleteFile("D:\\images\\1.jpg");
        assertTrue(res);
    }
}