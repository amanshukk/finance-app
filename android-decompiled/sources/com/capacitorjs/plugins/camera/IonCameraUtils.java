package com.capacitorjs.plugins.camera;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IonCameraUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tJ\u001f\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000bJ \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\u0015"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonCameraUtils;", "", "<init>", "()V", "getGalleryTempImage", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "uri", "getGalleryTempImage$capacitor_camera_debug", "getCameraTempImage", "getCameraTempImage$capacitor_camera_debug", "saveImage", "inputStream", "Ljava/io/InputStream;", "writePhoto", "", "outFile", "Ljava/io/File;", "input", "getTempFile", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class IonCameraUtils {
    public static final IonCameraUtils INSTANCE = new IonCameraUtils();

    private IonCameraUtils() {
    }

    public final Uri getGalleryTempImage$capacitor_camera_debug(Context context, Uri uri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return null;
            }
            InputStream inputStream2 = inputStream;
            try {
                InputStream it = inputStream2;
                Uri uriSaveImage = INSTANCE.saveImage(context, uri, it);
                CloseableKt.closeFinally(inputStream2, null);
                return uriSaveImage;
            } finally {
            }
        } catch (Exception e) {
            return null;
        }
    }

    public final Uri getCameraTempImage$capacitor_camera_debug(Context context, Uri uri) throws IOException {
        String extension = ".jpeg";
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return null;
            }
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (StringsKt.contains((CharSequence) string, (CharSequence) ".png", true)) {
                extension = ".png";
            } else {
                String string2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                if (!StringsKt.contains((CharSequence) string2, (CharSequence) ".jpeg", true)) {
                    extension = ".jpg";
                }
            }
            File tempFile = File.createTempFile("edit_", extension, context.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            try {
                FileOutputStream output = fileOutputStream;
                ByteStreamsKt.copyTo$default(inputStream, output, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                return Uri.fromFile(tempFile);
            } finally {
            }
        } catch (Exception e) {
            return null;
        }
    }

    private final Uri saveImage(Context context, Uri uri, InputStream inputStream) throws IOException {
        String it;
        File outFile = (Intrinsics.areEqual(uri.getScheme(), "content") || (it = uri.getPath()) == null) ? getTempFile(context, uri) : new File(it);
        try {
            writePhoto(outFile, inputStream);
        } catch (FileNotFoundException e) {
            outFile = getTempFile(context, uri);
            writePhoto(outFile, inputStream);
        }
        Uri uriFromFile = Uri.fromFile(outFile);
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    private final void writePhoto(File outFile, InputStream input) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        try {
            FileOutputStream output = fileOutputStream;
            ByteStreamsKt.copyTo$default(input, output, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    private final File getTempFile(Context context, Uri uri) {
        String $this$toUri$iv = Uri.decode(uri.toString());
        Intrinsics.checkNotNullExpressionValue($this$toUri$iv, "decode(...)");
        String filename = Uri.parse($this$toUri$iv).getLastPathSegment();
        Intrinsics.checkNotNull(filename);
        if (!StringsKt.contains$default((CharSequence) filename, (CharSequence) ".jpg", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) filename, (CharSequence) ".jpeg", false, 2, (Object) null)) {
            filename = filename + "." + System.currentTimeMillis() + ".jpeg";
        }
        return new File(context.getCacheDir(), filename);
    }
}
