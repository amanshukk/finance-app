package com.capacitorjs.plugins.camera;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.getcapacitor.PermissionState;
import com.getcapacitor.PluginCall;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u00002\u00020\u0001Bu\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\t\u0012$\u0010\f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004J)\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/capacitorjs/plugins/camera/PermissionHelper;", "", "isPermissionDeclaredFn", "Lkotlin/Function1;", "", "", "getPermissionStateFn", "Lcom/getcapacitor/PermissionState;", "requestPermissionForAliasFn", "Lkotlin/Function3;", "Lcom/getcapacitor/PluginCall;", "", "requestPermissionForAliasesFn", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "isPermissionDeclared", "alias", "getPermissionState", "requestPermissionForAlias", NotificationCompat.CATEGORY_CALL, "callbackName", "requestPermissionForAliases", "aliases", "([Ljava/lang/String;Lcom/getcapacitor/PluginCall;Ljava/lang/String;)V", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class PermissionHelper {
    private final Function1<String, PermissionState> getPermissionStateFn;
    private final Function1<String, Boolean> isPermissionDeclaredFn;
    private final Function3<String, PluginCall, String, Unit> requestPermissionForAliasFn;
    private final Function3<String[], PluginCall, String, Unit> requestPermissionForAliasesFn;

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionHelper(Function1<? super String, Boolean> isPermissionDeclaredFn, Function1<? super String, ? extends PermissionState> getPermissionStateFn, Function3<? super String, ? super PluginCall, ? super String, Unit> requestPermissionForAliasFn, Function3<? super String[], ? super PluginCall, ? super String, Unit> requestPermissionForAliasesFn) {
        Intrinsics.checkNotNullParameter(isPermissionDeclaredFn, "isPermissionDeclaredFn");
        Intrinsics.checkNotNullParameter(getPermissionStateFn, "getPermissionStateFn");
        Intrinsics.checkNotNullParameter(requestPermissionForAliasFn, "requestPermissionForAliasFn");
        Intrinsics.checkNotNullParameter(requestPermissionForAliasesFn, "requestPermissionForAliasesFn");
        this.isPermissionDeclaredFn = isPermissionDeclaredFn;
        this.getPermissionStateFn = getPermissionStateFn;
        this.requestPermissionForAliasFn = requestPermissionForAliasFn;
        this.requestPermissionForAliasesFn = requestPermissionForAliasesFn;
    }

    public final boolean isPermissionDeclared(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        return this.isPermissionDeclaredFn.invoke(alias).booleanValue();
    }

    public final PermissionState getPermissionState(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        return this.getPermissionStateFn.invoke(alias);
    }

    public final void requestPermissionForAlias(String alias, PluginCall call, String callbackName) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        this.requestPermissionForAliasFn.invoke(alias, call, callbackName);
    }

    public final void requestPermissionForAliases(String[] aliases, PluginCall call, String callbackName) {
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        this.requestPermissionForAliasesFn.invoke(aliases, call, callbackName);
    }
}
