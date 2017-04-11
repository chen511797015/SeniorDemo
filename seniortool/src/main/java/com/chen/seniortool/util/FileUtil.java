package com.chen.seniortool.util;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created on 2017/4/8 17:00
 * 描述:所有的文件都是默认存储到/data/data/<package name>/files/目录下
 */

public class FileUtil {

    /**
     * 将数据存储到文件中
     *
     * @param mContext
     * @param mText:要保存的内容
     * @param mModel:Context.MODE_PRIVATE
     */
    public static void saveTextToFile(Context mContext, @NonNull String mFileName, String mText, @NonNull int mModel) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            fos = mContext.openFileOutput(mFileName, mModel);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(mText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bw) {
                    bw.close();
                }
                if (null != fos) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建时间:2017/4/8 17:07
     * 描述:从文件中读取数据
     */
    public static String loadDataFromFile(Context mContext, @NonNull String mFileName) {
        FileInputStream fis = null;
        BufferedReader br = null;
        StringBuilder mResult = new StringBuilder();
        try {
            fis = mContext.openFileInput(mFileName);
            br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = br.readLine()) != null) {
                mResult.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br) br.close();
                if (null != fis) fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mResult.toString();
    }


}
