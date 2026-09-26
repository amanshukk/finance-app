package com.capacitorjs.plugins.camera;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IonCameraSettings.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015¨\u0006)"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonCameraSettings;", "", "<init>", "()V", "quality", "", "getQuality", "()I", "setQuality", "(I)V", "targetWidth", "getTargetWidth", "setTargetWidth", "targetHeight", "getTargetHeight", "setTargetHeight", "correctOrientation", "", "getCorrectOrientation", "()Z", "setCorrectOrientation", "(Z)V", "encodingType", "getEncodingType", "setEncodingType", "saveToGallery", "getSaveToGallery", "setSaveToGallery", "editable", "Lcom/capacitorjs/plugins/camera/IonEditableMode;", "getEditable", "()Lcom/capacitorjs/plugins/camera/IonEditableMode;", "setEditable", "(Lcom/capacitorjs/plugins/camera/IonEditableMode;)V", "includeMetadata", "getIncludeMetadata", "setIncludeMetadata", "shouldResize", "getShouldResize", "setShouldResize", "Companion", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class IonCameraSettings {
    public static final boolean DEFAULT_CORRECT_ORIENTATION = true;
    public static final int DEFAULT_ENCODING_TYPE = 0;
    public static final int DEFAULT_QUALITY = 90;
    public static final boolean DEFAULT_SAVE_IMAGE_TO_GALLERY = false;
    private int encodingType;
    private boolean includeMetadata;
    private boolean saveToGallery;
    private boolean shouldResize;
    private int targetHeight;
    private int targetWidth;
    private int quality = 90;
    private boolean correctOrientation = true;
    private IonEditableMode editable = IonEditableMode.NO;

    public final int getQuality() {
        return this.quality;
    }

    public final void setQuality(int i) {
        this.quality = i;
    }

    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public final void setTargetWidth(int i) {
        this.targetWidth = i;
    }

    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public final void setTargetHeight(int i) {
        this.targetHeight = i;
    }

    public final boolean getCorrectOrientation() {
        return this.correctOrientation;
    }

    public final void setCorrectOrientation(boolean z) {
        this.correctOrientation = z;
    }

    public final int getEncodingType() {
        return this.encodingType;
    }

    public final void setEncodingType(int i) {
        this.encodingType = i;
    }

    public final boolean getSaveToGallery() {
        return this.saveToGallery;
    }

    public final void setSaveToGallery(boolean z) {
        this.saveToGallery = z;
    }

    public final IonEditableMode getEditable() {
        return this.editable;
    }

    public final void setEditable(IonEditableMode ionEditableMode) {
        Intrinsics.checkNotNullParameter(ionEditableMode, "<set-?>");
        this.editable = ionEditableMode;
    }

    public final boolean getIncludeMetadata() {
        return this.includeMetadata;
    }

    public final void setIncludeMetadata(boolean z) {
        this.includeMetadata = z;
    }

    public final boolean getShouldResize() {
        return this.shouldResize;
    }

    public final void setShouldResize(boolean z) {
        this.shouldResize = z;
    }
}
