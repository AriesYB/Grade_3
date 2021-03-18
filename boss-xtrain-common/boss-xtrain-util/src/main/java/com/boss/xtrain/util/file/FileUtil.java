package com.boss.xtrain.util.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Description 整合apache的文件工具类
 * @Date 2020/7/1 20:08
 * @Author HetFrame
 */
public class FileUtil {
    private static FileUtil instance;

    private FileUtil() {
    }

    public static FileUtil getInstance() {
        if (instance == null) {
            synchronized (FileUtil.class) {
                if (instance == null) {
                    instance = new FileUtil();
                }
            }
        }
        return instance;
    }

    /**
     * @param filePath 文件路径
     * @Description 根据路径获取文件
     * @date 2020/7/1 21:50
     * @return: java.io.File
     */
    public File getFile(String filePath) {
        return getFile(filePath);
    }

    /**
     * @param filePath 文件路径
     * @param names    子文件夹名称
     * @Description 根据路径和子文件夹路径获取文件
     * @date 2020/7/1 21:50
     * @return: java.io.File
     */
    public File getFile(String filePath, String... names) {
        return FileUtils.getFile(new File(filePath), names);
    }

    /**
     * @param filePath 文件路径
     * @Description 按行读取文件到List, 默认编码UTF-8
     * @date 2020/7/1 20:28
     * @return: java.util.List<java.lang.String>
     */
    public List<String> readLines(String filePath) throws IOException {
        return readLines(filePath, StandardCharsets.UTF_8);
    }

    /**
     * @param filePath 文件路径
     * @param encoding 编码方式
     * @Description 按行读取文件到List
     * @date 2020/7/1 20:28
     * @return: java.util.List<java.lang.String>
     */
    public List<String> readLines(String filePath, Charset encoding) throws IOException {
        return FileUtils.readLines(new File(filePath), encoding);
    }

    /**
     * @param filePath 文件路径
     * @Description 读取文件到String，默认编码UTF-8
     * @date 2020/7/1 20:32
     * @return: java.lang.String
     */
    public String readFileToString(String filePath) throws IOException {
        return readFileToString(filePath, StandardCharsets.UTF_8);
    }

    /**
     * @param filePath 文件路径
     * @param encoding 编码方式
     * @Description 读取文件到String
     * @date 2020/7/1 20:33
     * @return: java.lang.String
     */
    public String readFileToString(String filePath, Charset encoding) throws IOException {
        return FileUtils.readFileToString(new File(filePath), encoding);
    }

    /**
     * @param filePath 文件路径
     * @param list     字符串List
     * @Description 按行写入文件，默认覆盖文件内容
     * @date 2020/7/1 21:37
     * @return: void
     */
    public void writeLines(String filePath, List<String> list) throws IOException {
        writeLines(filePath, list, false);
    }

    /**
     * @param filePath 文件路径
     * @param list     字符串List
     * @param append   是否在文件尾添加，false会覆盖文件
     * @Description 按行写入文件，false会覆盖文件内容，true在文件尾追加
     * @date 2020/7/1 21:37
     * @return: void
     */
    public void writeLines(String filePath, List<String> list, boolean append) throws IOException {
        FileUtils.writeLines(new File(filePath), list, append);
    }

    /**
     * @param filePath 文件路径
     * @param content  文件内容
     * @param append   为true则在文件末尾添加，false则覆盖文件
     * @Description 写入String到文件
     * @date 2020/7/1 21:58
     * @return: void
     */
    public void writeStringToFile(String filePath, String content, boolean append) throws IOException {
        FileUtils.writeStringToFile(new File(filePath), content, StandardCharsets.UTF_8, append);
    }

    /**
     * @param file1 待复制的文件1
     * @param file2 目标文件2
     * @Description 赋值文件file1到file2
     * @date 2020/7/1 21:54
     * @return: void
     */
    public void copyFile(File file1, File file2) throws IOException {
        FileUtils.copyFile(file1, file2);
    }

    /**
     * @param filePath  文件路径
     * @param directory 文件夹路径
     * @Description 复制文件到文件夹
     * @date 2020/7/1 22:10
     * @return: void
     */
    public void copyToDirectory(String filePath, String directory) throws IOException {
        copyToDirectory(new File(filePath), new File(directory));
    }

    /**
     * @param file      待复制文件
     * @param directory 目标文件夹
     * @Description 复制文件到文件夹
     * @date 2020/7/1 22:12
     * @return: void
     */
    public void copyToDirectory(File file, File directory) throws IOException {
        FileUtils.copyToDirectory(file, directory);
    }
}
