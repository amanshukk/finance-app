package com.capacitorjs.plugins.camera;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.ionic.libs.ioncameralib.model.IONCAMRMediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IonGallerySettings.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000f¨\u0006,"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonGallerySettings;", "", "<init>", "()V", "mediaType", "Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;", "getMediaType", "()Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;", "setMediaType", "(Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;)V", "allowMultipleSelection", "", "getAllowMultipleSelection", "()Z", "setAllowMultipleSelection", "(Z)V", "limit", "", "getLimit", "()I", "setLimit", "(I)V", "includeMetadata", "getIncludeMetadata", "setIncludeMetadata", "editable", "Lcom/capacitorjs/plugins/camera/IonEditableMode;", "getEditable", "()Lcom/capacitorjs/plugins/camera/IonEditableMode;", "setEditable", "(Lcom/capacitorjs/plugins/camera/IonEditableMode;)V", "quality", "getQuality", "setQuality", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "correctOrientation", "getCorrectOrientation", "setCorrectOrientation", "Companion", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class IonGallerySettings {
    public static final boolean DEFAULT_CORRECT_ORIENTATION = true;
    public static final int DEFAULT_QUALITY = 90;
    private boolean allowMultipleSelection;
    private int height;
    private boolean includeMetadata;
    private int limit;
    private int width;
    private IONCAMRMediaType mediaType = IONCAMRMediaType.ALL;
    private IonEditableMode editable = IonEditableMode.NO;
    private int quality = 90;
    private boolean correctOrientation = true;

    public final IONCAMRMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(IONCAMRMediaType iONCAMRMediaType) {
        Intrinsics.checkNotNullParameter(iONCAMRMediaType, "<set-?>");
        this.mediaType = iONCAMRMediaType;
    }

    public final boolean getAllowMultipleSelection() {
        return this.allowMultipleSelection;
    }

    public final void setAllowMultipleSelection(boolean z) {
        this.allowMultipleSelection = z;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public final boolean getIncludeMetadata() {
        return this.includeMetadata;
    }

    public final void setIncludeMetadata(boolean z) {
        this.includeMetadata = z;
    }

    public final IonEditableMode getEditable() {
        return this.editable;
    }

    public final void setEditable(IonEditableMode ionEditableMode) {
        Intrinsics.checkNotNullParameter(ionEditableMode, "<set-?>");
        this.editable = ionEditableMode;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final void setQuality(int i) {
        this.quality = i;
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

    public final boolean getCorrectOrientation() {
        return this.correctOrientation;
    }

    public final void setCorrectOrientation(boolean z) {
        this.correctOrientation = z;
    }
}
