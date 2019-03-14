package com.weicongli.demo.faketieba.view.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.demo.weicongli.library.utils.ObjectUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author: WeicongLi
 * @time: 2019/3/14 16:44
 * @email: 912220261@qq.com
 * @Function:
 */
public class BitmapUtils {
    public static Bitmap getBitmapFromUri(Activity ac, Uri uri, int reqHeight, int reqWidth) throws FileNotFoundException {
        InputStream inputStream = ac.getContentResolver().openInputStream(uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        //解析图片信息，不加载图片
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        //计算缩放比
        options.inSampleSize = calculateInSampleSize(options, reqHeight, reqWidth);
        //加载图片
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        ObjectUtils.closeQuietly(inputStream);
        return bitmap;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqHeight, int reqWidth) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            //计算缩放比，2的指数
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
