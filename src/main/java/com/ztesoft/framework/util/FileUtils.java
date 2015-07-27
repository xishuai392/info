package com.ztesoft.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 文件操作辅助类
 */
public class FileUtils {

    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(FileUtils.class);

    public FileUtils() {

    }

    private String message;

    public String getMessage() {
        return this.message;
    }

    /**
     * 从文件路径中提取文件名
     * 
     * @param path
     * @return
     */
    public String getFileNameFromPath(String path) {
        path = path.replace('\\', '/');
        return path.substring(path.lastIndexOf("/") + 1);
    }

    /**
     * 获取文件夹路径
     * 
     * @param path 原来的完整路径
     * @param index 指定的斜线数，截取该斜线之前得路径
     * @return
     */
    public String getFolderPathFromPath(String path, int index) {
        path = path.replace('\\', '/');
        String strSplit = path;
        for (int i = 0; i < index; i++) {
            strSplit = path.substring(0, strSplit.lastIndexOf("/"));
        }
        return strSplit;
    }

    /**
     * 从文件路径中提取文件名，倒数第二个“/”与倒数第三个“/”之间的字符串
     * 
     * @param path
     * @return
     */
    public String getFileNameFromPath2And3(String path) {
        path = path.replace('\\', '/');
        String[] st = path.split("/");
        return st[st.length - 3];
    }

    /**
     * 从文件路径中提取文件名，倒数第1个“/”与倒数第2个“/”之间的字符串
     * 
     * @param path
     * @return
     */
    public String getFileNameFromPath1And2(String path) {
        path = path.replace('\\', '/');
        String[] st = path.split("/");
        return st[st.length - 2];
    }

    /**
     * 读取字符串中指定字符串后后面的内容
     * 
     * @param path
     * @return
     */
    public String getFileNameFromPathFistAndSec(String path, String value) {
        String strSplit = path.substring(path.indexOf(value));
        return strSplit.substring(strSplit.indexOf("/"));
    }

    /**
     * 将路径中的/ 替换成 \，并且将路径格式化以 \结尾
     * 
     * @param path
     * @return
     */
    public String filePathFormat(String path) {
        return path.replace("\\", "/").endsWith("/") ? path.replace("\\", "/")
                : path.replace("\\", "/") + "/";
    }

    /**
     * 将路径中的\替换成 /
     * 
     * @param path
     * @return
     */
    public String filePathFormat2(String path) {
        return path.replace("\\", "/").endsWith("/") ? path.replace("\\", "/")
                : path.replace("\\", "/");
    }

    /**
     * 判断路径中最后是否存在斜线，不存在的话添加一条斜线/
     * 
     * @param path
     * @return
     */
    public String filePathFormatEnds(String path) {
        return (path.endsWith("/") || path.endsWith("\\")) ? path
                : (path + "/");
    }

    /**
     * 判断路径中最后是否存在斜线，存在的话去掉这条斜线/
     * 
     * @param path
     * @return
     */
    public String filePathFormatEndsRemove(String path) {
        return (path.endsWith("/") || path.endsWith("\\")) ? path.substring(0,
                path.length() - 1) : path;
    }

    /**
     * 文件重命名
     * 
     * @param oldFile
     * @param newFile
     */
    public void renameFile(String oldFile, String newFile) {
        File file = new File(oldFile);
        file.renameTo(new File(newFile));
    }

    // [start]是否存在判断

    /**
     * 判断文件是否存在
     * 
     * @param fullFilePath 文件全路径
     */

    public boolean isFileExist(String fullFilePath) {
        File file = new File(fullFilePath);
        // 判断文件是否存在
        if (!file.exists()) {
            return false;
        }
        return true;
    }

    // [end]

    // [start]读取

    /**
     * 读文件
     * 
     * @param fileName 文件名
     * @return 文件内容
     */
    public String readFileAsString(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
            return sb.toString();
        }
        catch (IOException e) {
            logger.error(e);
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e1) {
                }
            }
        }
        return "";
    }

    /**
     * 读文件流
     * 
     * @param in 文件流
     * @return 文件内容
     */
    public String readFileAsString(InputStream in) {
        StringBuilder sb = new StringBuilder();
        if (in == null) {
            return "";
        }
        InputStreamReader inreader = null;
        try {
            inreader = new InputStreamReader(in, "UTF-8");
        }
        catch (UnsupportedEncodingException e1) {
            logger.error(e1);
        }
        if (inreader == null) {
            return "";
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(inreader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
            return sb.toString();
        }
        catch (IOException e) {
            logger.error(e);
        }
        finally {
            try {
                in.close();
                inreader.close();
                if (reader != null) {
                    reader.close();
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return "";
    }

    // [end]

    // [start]创建

    /**
     * 新建目录
     * 
     * @param folderPath 目录
     * @return 返回目录创建后的路径
     */
    public String createFolder(String folderPath) throws Exception {
        String txt = folderPath;
        java.io.File myFilePath = new java.io.File(txt);
        if (!myFilePath.exists()) {
            myFilePath.mkdir();
        }
        return txt;
    }

    /**
     * 多级目录创建
     * 
     * @param folderPath 准备要在本级目录下创建新目录的目录路径 例如 c:myf
     * @param paths 无限级目录参数，各级目录以单数线区分 例如 a|b|c
     * @return 返回创建文件后的路径 例如 c:myf/a/b/c
     */
    public String createFolders(String folderPath, String paths)
            throws Exception {
        String txts = folderPath;
        String[] st = paths.split("\\|");
        for (String str : st) {
            if (!str.equals("")) {
                if (txts.lastIndexOf("/") == txts.length() - 1) {
                    txts = createFolder(txts + str);
                }
                else {
                    txts = createFolder(txts + "/" + str);
                }
            }
        }
        return txts;
    }

    /**
     * 新建文件
     * 
     * @param fullFilePath 文本文件完整绝对路径及文件名
     * @param fileContent 文本文件内容
     * @return
     */
    public void createFile(String fullFilePath, String fileContent)
            throws Exception {
        String filePath = fullFilePath.replace("\\", "/");
        filePath = filePath.toString();

        String folderPath = "";// Linux 根路径
        if (filePath.startsWith("/")) {
            folderPath = "/";
        }
        else if (filePath.substring(1, 2).equals(":")) {// Windows根路径
            folderPath = filePath.substring(0, 2) + "/";
            filePath = filePath.substring(3);
        }

        createFolders(
                folderPath,
                filePath.substring(0, filePath.lastIndexOf("/") + 1).replace(
                        '/', '|'));
        File myFilePath = new File(fullFilePath.replace("\\", "/"));
        if (!myFilePath.exists()) {
            myFilePath.createNewFile();
        }
        if (fileContent != null && !fileContent.equals("")) {
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(fileContent);
            myFile.close();
            resultFile.close();
        }
    }

    /**
     * 有编码方式的文件创建
     * 
     * @param fullFilePath 文本文件完整绝对路径及文件名
     * @param fileContent 文本文件内容
     * @param encoding 编码方式 例如 GBK 或者 UTF-8
     * @return
     */
    public void createFile(String fullFilePath, String fileContent,
            String encoding) throws Exception {
        String filePath = fullFilePath.replace("\\", "/");
        filePath = filePath.toString();

        String folderPath = "";// Linux 根路径
        if (filePath.startsWith("/")) {
            folderPath = "/";
        }
        else if (filePath.substring(1, 2).equals(":")) {// Windows根路径
            folderPath = filePath.substring(0, 2) + "/";
            filePath = filePath.substring(3);
        }

        createFolders(
                folderPath,
                filePath.substring(0, filePath.lastIndexOf("/") + 1).replace(
                        '/', '|'));
        File myFilePath = new File(fullFilePath.replace("\\", "/"));
        if (!myFilePath.exists()) {
            myFilePath.createNewFile();
        }
        if (fileContent != null && !fileContent.equals("")) {
            PrintWriter myFile = new PrintWriter(myFilePath, encoding);
            myFile.println(fileContent);
            myFile.close();
        }
    }

    // [end]

    // [start]删除

    /**
     * 删除文件
     * 
     * @param fullFilePath 文本文件完整绝对路径及文件名
     * @return Boolean 成功删除返回true遭遇异常返回false
     */
    public boolean delFile(String fullFilePath) throws Exception {
        boolean bea = false;
        message = "";
        String filePath = fullFilePath;
        File myDelFile = new File(filePath);
        if (myDelFile.exists()) {
            myDelFile.delete();
            bea = true;
        }
        else {
            bea = false;
            message = (fullFilePath + "文件不存在");
        }
        return bea;
    }

    /**
     * 删除文件夹
     * 
     * @param folderPath 文件夹完整绝对路径
     * @return
     */
    public boolean delFolder(String folderPath) {
        try {
            delAllFile(folderPath);// 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // 删除空文件夹
        }
        catch (Exception e) {
            message = e.getMessage();
            return false;
        }
        return true;
    }

    /**
     * 删除指定文件夹下所有文件
     * 
     * @param path 文件夹完整绝对路径
     * @return
     */
    public boolean delAllFile(String path) throws Exception {
        boolean bea = false;
        File file = new File(path);
        if (!file.exists()) {
            return bea;
        }
        if (!file.isDirectory()) {
            return bea;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            }
            else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                // 先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                // 再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                bea = true;
            }
        }
        return bea;
    }

    // [end]

    // [start]复制

    /**
     * 复制单个文件
     * 
     * @param oldPathFile 准备复制的文件源
     * @param newPathFile 拷贝到新绝对路径带文件名
     * @return
     */
    public void copyFile(String oldPathFile, String newPathFile)
            throws Exception {
        int bytesum = 0;
        int byteread = 0;
        File oldfile = new File(oldPathFile);

        // 文件存在时
        if (oldfile.exists()) {
            InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
            FileOutputStream fs = new FileOutputStream(newPathFile);
            byte[] buffer = new byte[1444];
            while ((byteread = inStream.read(buffer)) != -1) {
                // 字节数 文件大小
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            inStream.close();
        }
    }

    /**
     * 复制整个文件夹的内容
     * 
     * @param oldPath 准备拷贝的目录
     * @param newPath 指定绝对路径的新目录
     * @return
     */
    public void copyFolder(String oldPath, String newPath) {
        try {
            // 如果文件夹不存在 则建立新文件夹
            new File(newPath).mkdirs();

            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                }
                else {
                    temp = new File(oldPath + File.separator + file[i]);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath
                            + "/" + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }

                // 如果是子文件夹
                if (temp.isDirectory()) {
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    // [end]

    // [start]移动

    /**
     * 移动文件
     * 
     * @param oldPath
     * @param newPath
     * @return
     */
    public void moveFile(String oldPath, String newPath) throws Exception {
        copyFile(oldPath, newPath);
        delFile(oldPath);
    }

    /**
     * 移动目录
     * 
     * @param oldPath
     * @param newPath
     * @return
     */
    public void moveFolder(String oldPath, String newPath) throws Exception {
        copyFolder(oldPath, newPath);
        delFolder(oldPath);
    }

    // [end]

    /**
     * 取得文件大小
     * 
     * @param fullFilePath 文件绝对路径
     * @return 文件大小
     */
    public long getFileSizes(String fullFilePath) throws Exception {
        long s = 0;
        File f = new File(fullFilePath);

        if (f.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
            s = fis.available();
        }
        else {
            f.createNewFile();
            message = ("文件不存在");
        }
        return s;
    }
}
