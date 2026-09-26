package com.capacitorjs.plugins.camera;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: IonEditableMode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonEditableMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO", "IN_APP", "EXTERNAL", "Companion", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public enum IonEditableMode {
    NO("no"),
    IN_APP("in-app"),
    EXTERNAL("external");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<IonEditableMode> getEntries() {
        return $ENTRIES;
    }

    IonEditableMode(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }

    /* compiled from: IonEditableMode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonEditableMode$Companion;", "", "<init>", "()V", "fromString", "Lcom/capacitorjs/plugins/camera/IonEditableMode;", "value", "", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IonEditableMode fromString(String value) {
            IonEditableMode it;
            if (value == null) {
                return IonEditableMode.NO;
            }
            IonEditableMode[] ionEditableModeArrValues = IonEditableMode.values();
            int length = ionEditableModeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    it = null;
                    break;
                }
                it = ionEditableModeArrValues[i];
                if (StringsKt.equals(it.getValue(), value, true)) {
                    break;
                }
                i++;
            }
            if (it != null) {
                return it;
            }
            return IonEditableMode.NO;
        }
    }
}
