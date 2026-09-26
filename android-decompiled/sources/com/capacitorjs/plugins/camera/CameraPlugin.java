package com.capacitorjs.plugins.camera;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.capacitorjs.plugins.camera.LegacyCameraFlow;
import com.getcapacitor.Bridge;
import com.getcapacitor.JSArray;
import com.getcapacitor.Logger;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* compiled from: CameraPlugin.kt */
@CapacitorPlugin(name = "Camera", permissions = {@Permission(alias = CameraPlugin.CAMERA, strings = {"android.permission.CAMERA"}), @Permission(alias = CameraPlugin.PHOTOS, strings = {}), @Permission(alias = CameraPlugin.SAVE_GALLERY, strings = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), @Permission(alias = CameraPlugin.READ_EXTERNAL_STORAGE, strings = {"android.permission.READ_EXTERNAL_STORAGE"})})
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0003J+\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0003J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0018\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010%0$H\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u001bH\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0002J\n\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020/H\u0014J\b\u00102\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/capacitorjs/plugins/camera/CameraPlugin;", "Lcom/getcapacitor/Plugin;", "<init>", "()V", "legacyFlow", "Lcom/capacitorjs/plugins/camera/LegacyCameraFlow;", "ionFlow", "Lcom/capacitorjs/plugins/camera/IonCameraFlow;", "load", "", "getPhoto", NotificationCompat.CATEGORY_CALL, "Lcom/getcapacitor/PluginCall;", "takePhoto", "recordVideo", "playVideo", "chooseFromGallery", "editPhoto", "editURIPhoto", "pickImages", "pickLimitedLibraryPhotos", "getLimitedLibraryPhotos", "cameraPermissionsCallback", "ionCameraPermissionsCallback", "requestPermissionForAliases", "aliases", "", "", "callbackName", "([Ljava/lang/String;Lcom/getcapacitor/PluginCall;Ljava/lang/String;)V", "processCameraImage", "result", "Landroidx/activity/result/ActivityResult;", "processEditedImage", "requestPermissions", "getPermissionStates", "", "Lcom/getcapacitor/PermissionState;", "getResultType", "Lcom/capacitorjs/plugins/camera/CameraResultType;", "resultType", "legacyQueryIntentActivities", "", "Landroid/content/pm/ResolveInfo;", "intent", "Landroid/content/Intent;", "saveInstanceState", "Landroid/os/Bundle;", "restoreState", "state", "handleOnDestroy", "Companion", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class CameraPlugin extends Plugin {
    private static final String CAMERA = "camera";
    private static final String PHOTOS = "photos";
    private static final String READ_EXTERNAL_STORAGE = "readExternalStorage";
    private static final String SAVE_GALLERY = "saveGallery";
    private IonCameraFlow ionFlow;
    private LegacyCameraFlow legacyFlow;

    @Override // com.getcapacitor.Plugin
    public void load() {
        super.load();
        PermissionHelper permissionHelper = new PermissionHelper(new Function1() { // from class: com.capacitorjs.plugins.camera.CameraPlugin$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CameraPlugin.load$lambda$0(this.f$0, (String) obj));
            }
        }, new Function1() { // from class: com.capacitorjs.plugins.camera.CameraPlugin$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraPlugin.load$lambda$1(this.f$0, (String) obj);
            }
        }, new Function3() { // from class: com.capacitorjs.plugins.camera.CameraPlugin$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CameraPlugin.load$lambda$2(this.f$0, (String) obj, (PluginCall) obj2, (String) obj3);
            }
        }, new Function3() { // from class: com.capacitorjs.plugins.camera.CameraPlugin$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CameraPlugin.load$lambda$3(this.f$0, (String[]) obj, (PluginCall) obj2, (String) obj3);
            }
        });
        this.legacyFlow = new LegacyCameraFlow(getContext(), getActivity(), this.bridge, getAppId(), permissionHelper, new LegacyCameraFlow.ActivityStarter() { // from class: com.capacitorjs.plugins.camera.CameraPlugin$$ExternalSyntheticLambda4
            @Override // com.capacitorjs.plugins.camera.LegacyCameraFlow.ActivityStarter
            public final void startActivityForResult(PluginCall pluginCall, Intent intent, String str) {
                this.f$0.startActivityForResult(pluginCall, intent, str);
            }
        });
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        AppCompatActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        Bridge bridge = this.bridge;
        Intrinsics.checkNotNullExpressionValue(bridge, "bridge");
        String appId = getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "getAppId(...)");
        this.ionFlow = new IonCameraFlow(context, activity, bridge, appId, permissionHelper);
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean load$lambda$0(CameraPlugin this$0, String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        return this$0.isPermissionDeclared(alias);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionState load$lambda$1(CameraPlugin this$0, String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        PermissionState permissionState = this$0.getPermissionState(alias);
        Intrinsics.checkNotNullExpressionValue(permissionState, "getPermissionState(...)");
        return permissionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2(CameraPlugin this$0, String alias, PluginCall call, String callbackName) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        this$0.requestPermissionForAlias(alias, call, callbackName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3(CameraPlugin this$0, String[] aliases, PluginCall call, String callbackName) {
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        this$0.requestPermissionForAliases(aliases, call, callbackName);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use either takePhoto for CameraSource.Camera or chooseFromGallery for CameraSource.Photos")
    @PluginMethod
    public final void getPhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.getPhoto(call);
    }

    @PluginMethod
    public final void takePhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.takePhoto(call);
    }

    @PluginMethod
    public final void recordVideo(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.recordVideo(call);
    }

    @PluginMethod
    public final void playVideo(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.playVideo(call);
    }

    @PluginMethod
    public final void chooseFromGallery(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.chooseFromGallery(call);
    }

    @PluginMethod
    public final void editPhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.editPhoto(call);
    }

    @PluginMethod
    public final void editURIPhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.editURIPhoto(call);
    }

    @Deprecated(message = "Use chooseFromGallery instead")
    @PluginMethod
    public final void pickImages(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.pickImages(call);
    }

    @PluginMethod
    public final void pickLimitedLibraryPhotos(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.pickLimitedLibraryPhotos(call);
    }

    @PluginMethod
    public final void getLimitedLibraryPhotos(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.getLimitedLibraryPhotos(call);
    }

    @PermissionCallback
    private final void cameraPermissionsCallback(PluginCall call) {
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.handleCameraPermissionsCallback(call);
    }

    @PermissionCallback
    private final void ionCameraPermissionsCallback(PluginCall call) {
        IonCameraFlow ionCameraFlow = this.ionFlow;
        if (ionCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
            ionCameraFlow = null;
        }
        ionCameraFlow.handlePermissionsCallback(call);
    }

    @Override // com.getcapacitor.Plugin
    protected void requestPermissionForAliases(String[] aliases, PluginCall call, String callbackName) {
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        if (Build.VERSION.SDK_INT >= 30) {
            int length = aliases.length;
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(aliases[i], SAVE_GALLERY)) {
                    aliases[i] = READ_EXTERNAL_STORAGE;
                }
            }
        }
        super.requestPermissionForAliases(aliases, call, callbackName);
    }

    @ActivityCallback
    public final void processCameraImage(PluginCall call, ActivityResult result) throws JSONException, IOException, NumberFormatException {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.processCameraImage(call, result);
    }

    @ActivityCallback
    private final void processEditedImage(PluginCall call, ActivityResult result) throws JSONException, IOException, NumberFormatException {
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.processEditedImage(call, result);
    }

    @Override // com.getcapacitor.Plugin
    @PluginMethod
    public void requestPermissions(PluginCall call) throws JSONException {
        Intrinsics.checkNotNullParameter(call, "call");
        if (isPermissionDeclared(CAMERA)) {
            super.requestPermissions(call);
            return;
        }
        JSArray providedPerms = call.getArray("permissions");
        List permsList = null;
        if (providedPerms != null) {
            try {
                permsList = providedPerms.toList();
            } catch (JSONException e) {
            }
        }
        if (Build.VERSION.SDK_INT >= 33 || (permsList != null && permsList.size() == 1 && (permsList.contains(CAMERA) || permsList.contains(PHOTOS)))) {
            checkPermissions(call);
        } else {
            requestPermissionForAlias(SAVE_GALLERY, call, "checkPermissions");
        }
    }

    @Override // com.getcapacitor.Plugin
    public Map<String, PermissionState> getPermissionStates() {
        Map permissionStates = super.getPermissionStates();
        if (!isPermissionDeclared(CAMERA)) {
            permissionStates.put(CAMERA, PermissionState.GRANTED);
        }
        if (permissionStates.containsKey(PHOTOS)) {
            permissionStates.put(PHOTOS, PermissionState.GRANTED);
        }
        if (Build.VERSION.SDK_INT >= 30 && permissionStates.containsKey(READ_EXTERNAL_STORAGE)) {
            permissionStates.put(SAVE_GALLERY, permissionStates.get(READ_EXTERNAL_STORAGE));
        }
        Intrinsics.checkNotNull(permissionStates);
        return permissionStates;
    }

    private final CameraResultType getResultType(String resultType) {
        if (resultType == null) {
            return null;
        }
        try {
            String upperCase = resultType.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return CameraResultType.valueOf(upperCase);
        } catch (IllegalArgumentException e) {
            Logger.debug(getLogTag(), "Invalid result type \"" + resultType + "\", defaulting to base64");
            return CameraResultType.BASE64;
        }
    }

    private final List<ResolveInfo> legacyQueryIntentActivities(Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = getContext().getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities;
    }

    @Override // com.getcapacitor.Plugin
    protected Bundle saveInstanceState() {
        Bundle bundle = super.saveInstanceState();
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.onSaveInstanceState(bundle);
        return bundle;
    }

    @Override // com.getcapacitor.Plugin
    protected void restoreState(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.restoreState(state);
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.onRestoreState(state);
    }

    @Override // com.getcapacitor.Plugin
    protected void handleOnDestroy() {
        LegacyCameraFlow legacyCameraFlow = this.legacyFlow;
        IonCameraFlow ionCameraFlow = null;
        if (legacyCameraFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFlow");
            legacyCameraFlow = null;
        }
        legacyCameraFlow.onDestroy();
        IonCameraFlow ionCameraFlow2 = this.ionFlow;
        if (ionCameraFlow2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ionFlow");
        } else {
            ionCameraFlow = ionCameraFlow2;
        }
        ionCameraFlow.onDestroy();
    }
}
