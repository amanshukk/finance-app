package com.capacitorjs.plugins.camera;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: LegacyCameraSettings.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/capacitorjs/plugins/camera/LegacyCameraSettings;", "", "<init>", "()V", "resultType", "Lcom/capacitorjs/plugins/camera/CameraResultType;", "getResultType", "()Lcom/capacitorjs/plugins/camera/CameraResultType;", "setResultType", "(Lcom/capacitorjs/plugins/camera/CameraResultType;)V", "quality", "", "getQuality", "()I", "setQuality", "(I)V", "shouldResize", "", "getShouldResize", "()Z", "setShouldResize", "(Z)V", "shouldCorrectOrientation", "getShouldCorrectOrientation", "setShouldCorrectOrientation", "saveToGallery", "getSaveToGallery", "setSaveToGallery", "allowEditing", "getAllowEditing", "setAllowEditing", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "source", "Lcom/capacitorjs/plugins/camera/CameraSource;", "getSource", "()Lcom/capacitorjs/plugins/camera/CameraSource;", "setSource", "(Lcom/capacitorjs/plugins/camera/CameraSource;)V", "Companion", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class LegacyCameraSettings {
    public static final boolean DEFAULT_CORRECT_ORIENTATION = true;
    public static final int DEFAULT_QUALITY = 90;
    public static final boolean DEFAULT_SAVE_IMAGE_TO_GALLERY = false;
    private boolean allowEditing;
    private int height;
    private boolean saveToGallery;
    private boolean shouldResize;
    private int width;
    private CameraResultType resultType = CameraResultType.BASE64;
    private int quality = 90;
    private boolean shouldCorrectOrientation = true;
    private CameraSource source = CameraSource.PROMPT;

    public final CameraResultType getResultType() {
        return this.resultType;
    }

    public final void setResultType(CameraResultType cameraResultType) {
        this.resultType = cameraResultType;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final void setQuality(int i) {
        this.quality = i;
    }

    public final boolean getShouldResize() {
        return this.shouldResize;
    }

    public final void setShouldResize(boolean z) {
        this.shouldResize = z;
    }

    public final boolean getShouldCorrectOrientation() {
        return this.shouldCorrectOrientation;
    }

    public final void setShouldCorrectOrientation(boolean z) {
        this.shouldCorrectOrientation = z;
    }

    public final boolean getSaveToGallery() {
        return this.saveToGallery;
    }

    public final void setSaveToGallery(boolean z) {
        this.saveToGallery = z;
    }

    public final boolean getAllowEditing() {
        return this.allowEditing;
    }

    public final void setAllowEditing(boolean z) {
        this.allowEditing = z;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final CameraSource getSource() {
        return this.source;
    }

    public final void setSource(CameraSource cameraSource) {
        this.source = cameraSource;
    }
}
