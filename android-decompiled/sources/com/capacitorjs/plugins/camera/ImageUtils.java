package com.capacitorjs.plugins.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.getcapacitor.Logger;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ImageUtils {
    public static Bitmap resize(Bitmap bitmap, int desiredMaxWidth, int desiredMaxHeight) {
        return resizePreservingAspectRatio(bitmap, desiredMaxWidth, desiredMaxHeight);
    }

    private static Bitmap resizePreservingAspectRatio(Bitmap bitmap, int desiredMaxWidth, int desiredMaxHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int maxHeight = desiredMaxHeight == 0 ? height : desiredMaxHeight;
        int maxWidth = desiredMaxWidth == 0 ? width : desiredMaxWidth;
        float newWidth = Math.min(width, maxWidth);
        float newHeight = (height * newWidth) / width;
        if (newHeight > maxHeight) {
            newWidth = (width * maxHeight) / height;
            newHeight = maxHeight;
        }
        return Bitmap.createScaledBitmap(bitmap, Math.round(newWidth), Math.round(newHeight), false);
    }

    private static Bitmap transform(Bitmap bitmap, Matrix matrix) {
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap correctOrientation(Context c, Bitmap bitmap, Uri imageUri, ExifWrapper exif) throws IOException, NumberFormatException {
        int orientation = getOrientation(c, imageUri);
        if (orientation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(orientation);
            exif.resetOrientation();
            return transform(bitmap, matrix);
        }
        return bitmap;
    }

    private static int getOrientation(Context c, Uri imageUri) throws IOException {
        int result = 0;
        InputStream iStream = c.getContentResolver().openInputStream(imageUri);
        try {
            ExifInterface exifInterface = new ExifInterface(iStream);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (orientation == 6) {
                result = 90;
            } else if (orientation == 3) {
                result = 180;
            } else if (orientation == 8) {
                result = 270;
            }
            if (iStream != null) {
                iStream.close();
            }
            return result;
        } catch (Throwable th) {
            if (iStream != null) {
                try {
                    iStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static ExifWrapper getExifData(Context c, Bitmap bitmap, Uri imageUri) throws IOException {
        InputStream stream = null;
        try {
            try {
                stream = c.getContentResolver().openInputStream(imageUri);
                ExifInterface exifInterface = new ExifInterface(stream);
                ExifWrapper exifWrapper = new ExifWrapper(exifInterface);
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                    }
                }
                return exifWrapper;
            } catch (IOException ex) {
                Logger.error("Error loading exif data from image", ex);
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e2) {
                    }
                }
                return new ExifWrapper(null);
            }
        } catch (Throwable th) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
    }
}
