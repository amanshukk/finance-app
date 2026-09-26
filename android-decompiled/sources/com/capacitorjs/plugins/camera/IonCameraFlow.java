package com.capacitorjs.plugins.camera;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.capacitorjs.plugins.camera.IonCameraFlow;
import com.getcapacitor.Bridge;
import com.getcapacitor.FileUtils;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.PluginCall;
import io.ionic.libs.ioncameralib.helper.IONCAMRExifHelper;
import io.ionic.libs.ioncameralib.helper.IONCAMRFileHelper;
import io.ionic.libs.ioncameralib.helper.IONCAMRImageHelper;
import io.ionic.libs.ioncameralib.helper.IONCAMRMediaHelper;
import io.ionic.libs.ioncameralib.manager.IONCAMRCameraManager;
import io.ionic.libs.ioncameralib.manager.IONCAMREditManager;
import io.ionic.libs.ioncameralib.manager.IONCAMRGalleryManager;
import io.ionic.libs.ioncameralib.manager.IONCAMRVideoManager;
import io.ionic.libs.ioncameralib.model.IONCAMRCameraParameters;
import io.ionic.libs.ioncameralib.model.IONCAMREditParameters;
import io.ionic.libs.ioncameralib.model.IONCAMRError;
import io.ionic.libs.ioncameralib.model.IONCAMRMediaMetadata;
import io.ionic.libs.ioncameralib.model.IONCAMRMediaResult;
import io.ionic.libs.ioncameralib.model.IONCAMRMediaType;
import io.ionic.libs.ioncameralib.model.IONCAMRVideoParameters;
import io.ionic.libs.ioncameralib.view.IONCAMRImageEditorActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: IonCameraFlow.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 i2\u00020\u0001:\u0002ijB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u000e\u0010/\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u000e\u00100\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u000e\u00101\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u000e\u00102\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u000e\u00103\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\b\u00104\u001a\u00020,H\u0002J\u000e\u00105\u001a\u00020)2\u0006\u0010.\u001a\u00020!J\u000e\u00106\u001a\u00020%2\u0006\u0010.\u001a\u00020!J\u000e\u00107\u001a\u00020#2\u0006\u0010.\u001a\u00020!J\u0010\u00108\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0002J\u000e\u00109\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u000e\u0010:\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u0010\u0010;\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0002J\u0010\u0010<\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0002J\u0010\u0010=\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0002J\u0010\u0010>\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0002J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010C\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010D\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u001aH\u0002J\u0010\u0010G\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\b\u00102\u001a\u00020,H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\u001a2\u0006\u0010I\u001a\u00020JH\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010F\u001a\u00020\u001aH\u0002J\u0010\u0010N\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020\tH\u0002J\u0010\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020,2\u0006\u0010R\u001a\u00020SH\u0002J\u0016\u0010U\u001a\u00020,2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020S0WH\u0002J\u0012\u0010X\u001a\u00020,2\b\u0010F\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010Y\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010Z\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010[\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0002J\f\u0010\\\u001a\u00020]*\u00020#H\u0002J\u0016\u0010^\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020!2\u0006\u0010_\u001a\u00020\u000fJ\u0010\u0010`\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020!H\u0002J\u000e\u0010a\u001a\u00020,2\u0006\u0010.\u001a\u00020!J\u0010\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020gH\u0002J\u0006\u0010h\u001a\u00020,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonCameraFlow;", "", "context", "Landroid/content/Context;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "bridge", "Lcom/getcapacitor/Bridge;", "appId", "", "permissionHelper", "Lcom/capacitorjs/plugins/camera/PermissionHelper;", "<init>", "(Landroid/content/Context;Landroidx/appcompat/app/AppCompatActivity;Lcom/getcapacitor/Bridge;Ljava/lang/String;Lcom/capacitorjs/plugins/camera/PermissionHelper;)V", "isFirstRequest", "", "cameraManager", "Lio/ionic/libs/ioncameralib/manager/IONCAMRCameraManager;", "videoManager", "Lio/ionic/libs/ioncameralib/manager/IONCAMRVideoManager;", "editManager", "Lio/ionic/libs/ioncameralib/manager/IONCAMREditManager;", "galleryManager", "Lio/ionic/libs/ioncameralib/manager/IONCAMRGalleryManager;", "cameraLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "cameraCropLauncher", "galleryCropLauncher", "galleryLauncher", "videoLauncher", "editLauncher", "currentCall", "Lcom/getcapacitor/PluginCall;", "cameraSettings", "Lcom/capacitorjs/plugins/camera/IonCameraSettings;", "gallerySettings", "Lcom/capacitorjs/plugins/camera/IonCameraFlow$IonGallerySettings;", "editParameters", "Lio/ionic/libs/ioncameralib/model/IONCAMREditParameters;", "videoParameters", "Lio/ionic/libs/ioncameralib/model/IONCAMRVideoParameters;", "lastEditUri", "load", "", "takePhoto", NotificationCompat.CATEGORY_CALL, "recordVideo", "playVideo", "chooseFromGallery", "editPhoto", "editURIPhoto", "setupLaunchers", "getVideoSettings", "getGallerySettings", "getCameraSettings", "showCamera", "openCamera", "openRecordVideo", "openPlayVideo", "openGallery", "callEditPhoto", "callEditURIPhoto", "handleCameraResult", "result", "Landroidx/activity/result/ActivityResult;", "handleVideoResult", "handleGalleryResult", "handleGalleryCropResult", "processResultEditFromGallery", "intent", "handleEditResult", "createEditIntent", "origPhotoUri", "Landroid/net/Uri;", "legacyQueryIntentActivities", "", "Landroid/content/pm/ResolveInfo;", "handleCameraCropResult", "handleEditBase64Result", "image", "handleMediaResult", "mediaResult", "Lio/ionic/libs/ioncameralib/model/IONCAMRMediaResult;", "handleVideoMediaResult", "handleGalleryMediaResults", "results", "", "processResult", "processResultFromVideo", "processResultFromGallery", "processResultFromEdit", "toIonParameters", "Lio/ionic/libs/ioncameralib/model/IONCAMRCameraParameters;", "checkCameraPermissions", "saveToGallery", "checkGalleryPermissions", "handlePermissionsCallback", "sendError", "error", "Lio/ionic/libs/ioncameralib/model/IONCAMRError;", "formatErrorCode", "code", "", "onDestroy", "Companion", "IonGallerySettings", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class IonCameraFlow {
    private static final String AUTHORITY = ".camera.provider";
    private static final String CAMERA = "camera";
    private static final String EDIT_FILE_NAME_KEY = "EditFileName";
    private static final String ERROR_FORMAT_PREFIX = "OS-PLUG-CAMR-";
    private static final int MEDIA_TYPE_PHOTO = 0;
    private static final String SAVE_GALLERY = "saveGallery";
    private static final String STORE = "CameraStore";
    private final AppCompatActivity activity;
    private final String appId;
    private final Bridge bridge;
    private ActivityResultLauncher<Intent> cameraCropLauncher;
    private ActivityResultLauncher<Intent> cameraLauncher;
    private IONCAMRCameraManager cameraManager;
    private IonCameraSettings cameraSettings;
    private final Context context;
    private PluginCall currentCall;
    private ActivityResultLauncher<Intent> editLauncher;
    private IONCAMREditManager editManager;
    private IONCAMREditParameters editParameters;
    private ActivityResultLauncher<Intent> galleryCropLauncher;
    private ActivityResultLauncher<Intent> galleryLauncher;
    private IONCAMRGalleryManager galleryManager;
    private IonGallerySettings gallerySettings;
    private boolean isFirstRequest;
    private String lastEditUri;
    private final PermissionHelper permissionHelper;
    private ActivityResultLauncher<Intent> videoLauncher;
    private IONCAMRVideoManager videoManager;
    private IONCAMRVideoParameters videoParameters;

    /* compiled from: IonCameraFlow.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IonEditableMode.values().length];
            try {
                iArr[IonEditableMode.IN_APP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[IonEditableMode.EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[IonEditableMode.NO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IonCameraFlow(Context context, AppCompatActivity activity, Bridge bridge, String appId, PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        this.context = context;
        this.activity = activity;
        this.bridge = bridge;
        this.appId = appId;
        this.permissionHelper = permissionHelper;
        this.isFirstRequest = true;
        this.editParameters = new IONCAMREditParameters("", false, false, false);
    }

    public final void load() {
        setupLaunchers();
        this.cameraManager = new IONCAMRCameraManager(this.appId, new IONCAMRExifHelper(), new IONCAMRFileHelper(), new IONCAMRMediaHelper(), new IONCAMRImageHelper());
        this.videoManager = new IONCAMRVideoManager(new IONCAMRFileHelper());
        this.galleryManager = new IONCAMRGalleryManager(new IONCAMRExifHelper(), new IONCAMRFileHelper(), new IONCAMRMediaHelper(), new IONCAMRImageHelper());
        this.editManager = new IONCAMREditManager(this.appId, new IONCAMRExifHelper(), new IONCAMRFileHelper(), new IONCAMRMediaHelper(), new IONCAMRImageHelper());
        IONCAMRCameraManager iONCAMRCameraManager = this.cameraManager;
        if (iONCAMRCameraManager != null) {
            iONCAMRCameraManager.deleteVideoFilesFromCache(this.activity);
        }
    }

    public final void takePhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.cameraSettings = getCameraSettings(call);
        this.currentCall = call;
        showCamera(call);
    }

    public final void recordVideo(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.videoParameters = getVideoSettings(call);
        this.currentCall = call;
        openRecordVideo(call);
    }

    public final void playVideo(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.currentCall = call;
        openPlayVideo(call);
    }

    public final void chooseFromGallery(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.gallerySettings = getGallerySettings(call);
        this.currentCall = call;
        openGallery(call);
    }

    public final void editPhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.currentCall = call;
        callEditPhoto(call);
    }

    public final void editURIPhoto(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.currentCall = call;
        callEditURIPhoto(call);
    }

    private final void setupLaunchers() {
        this.cameraLauncher = this.activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda7
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws XmlPullParserException, IOException {
                IonCameraFlow.setupLaunchers$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        this.cameraCropLauncher = this.activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws IOException {
                IonCameraFlow.setupLaunchers$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        this.videoLauncher = this.activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda9
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                IonCameraFlow.setupLaunchers$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        this.galleryLauncher = this.activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda10
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws FileNotFoundException {
                IonCameraFlow.setupLaunchers$lambda$3(this.f$0, (ActivityResult) obj);
            }
        });
        this.galleryCropLauncher = this.activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda11
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                IonCameraFlow.setupLaunchers$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        this.editLauncher = this.activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda12
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                IonCameraFlow.setupLaunchers$lambda$5(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLaunchers$lambda$0(IonCameraFlow this$0, ActivityResult result) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleCameraResult(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLaunchers$lambda$1(IonCameraFlow this$0, ActivityResult result) throws IOException {
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleCameraCropResult(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLaunchers$lambda$2(IonCameraFlow this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleVideoResult(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLaunchers$lambda$3(IonCameraFlow this$0, ActivityResult result) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleGalleryResult(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLaunchers$lambda$4(IonCameraFlow this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleGalleryCropResult(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLaunchers$lambda$5(IonCameraFlow this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleEditResult(result);
    }

    public final IONCAMRVideoParameters getVideoSettings(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Boolean bool = call.getBoolean("saveToGallery");
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = call.getBoolean("includeMetadata");
        boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = call.getBoolean("isPersistent");
        return new IONCAMRVideoParameters(zBooleanValue, zBooleanValue2, bool3 != null ? bool3.booleanValue() : true);
    }

    public final IonGallerySettings getGallerySettings(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IONCAMRMediaType.Companion companion = IONCAMRMediaType.INSTANCE;
        Integer num = call.getInt("mediaType");
        IONCAMRMediaType iONCAMRMediaTypeFromValue = companion.fromValue(num != null ? num.intValue() : 0);
        Boolean bool = call.getBoolean("allowMultipleSelection");
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Integer num2 = call.getInt("limit");
        int iIntValue = num2 != null ? num2.intValue() : 0;
        Boolean bool2 = call.getBoolean("includeMetadata");
        boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        IonEditableMode ionEditableModeFromString = IonEditableMode.INSTANCE.fromString(call.getString("editable"));
        Integer num3 = call.getInt("quality");
        int iIntValue2 = num3 != null ? num3.intValue() : 90;
        Integer num4 = call.getInt("targetWidth");
        int iIntValue3 = num4 != null ? num4.intValue() : 0;
        Integer num5 = call.getInt("targetHeight");
        int iIntValue4 = num5 != null ? num5.intValue() : 0;
        Boolean bool3 = call.getBoolean("correctOrientation");
        return new IonGallerySettings(iONCAMRMediaTypeFromValue, zBooleanValue, iIntValue, zBooleanValue2, ionEditableModeFromString, iIntValue2, iIntValue3, iIntValue4, bool3 != null ? bool3.booleanValue() : true);
    }

    /* compiled from: IonCameraFlow.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003Jc\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0007HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018¨\u0006:"}, d2 = {"Lcom/capacitorjs/plugins/camera/IonCameraFlow$IonGallerySettings;", "", "mediaType", "Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;", "allowMultipleSelection", "", "limit", "", "includeMetadata", "editable", "Lcom/capacitorjs/plugins/camera/IonEditableMode;", "quality", "width", "height", "correctOrientation", "<init>", "(Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;ZIZLcom/capacitorjs/plugins/camera/IonEditableMode;IIIZ)V", "getMediaType", "()Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;", "setMediaType", "(Lio/ionic/libs/ioncameralib/model/IONCAMRMediaType;)V", "getAllowMultipleSelection", "()Z", "setAllowMultipleSelection", "(Z)V", "getLimit", "()I", "setLimit", "(I)V", "getIncludeMetadata", "setIncludeMetadata", "getEditable", "()Lcom/capacitorjs/plugins/camera/IonEditableMode;", "setEditable", "(Lcom/capacitorjs/plugins/camera/IonEditableMode;)V", "getQuality", "setQuality", "getWidth", "setWidth", "getHeight", "setHeight", "getCorrectOrientation", "setCorrectOrientation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "capacitor-camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class IonGallerySettings {
        private boolean allowMultipleSelection;
        private boolean correctOrientation;
        private IonEditableMode editable;
        private int height;
        private boolean includeMetadata;
        private int limit;
        private IONCAMRMediaType mediaType;
        private int quality;
        private int width;

        public IonGallerySettings() {
            this(null, false, 0, false, null, 0, 0, 0, false, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public static /* synthetic */ IonGallerySettings copy$default(IonGallerySettings ionGallerySettings, IONCAMRMediaType iONCAMRMediaType, boolean z, int i, boolean z2, IonEditableMode ionEditableMode, int i2, int i3, int i4, boolean z3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                iONCAMRMediaType = ionGallerySettings.mediaType;
            }
            if ((i5 & 2) != 0) {
                z = ionGallerySettings.allowMultipleSelection;
            }
            if ((i5 & 4) != 0) {
                i = ionGallerySettings.limit;
            }
            if ((i5 & 8) != 0) {
                z2 = ionGallerySettings.includeMetadata;
            }
            if ((i5 & 16) != 0) {
                ionEditableMode = ionGallerySettings.editable;
            }
            if ((i5 & 32) != 0) {
                i2 = ionGallerySettings.quality;
            }
            if ((i5 & 64) != 0) {
                i3 = ionGallerySettings.width;
            }
            if ((i5 & 128) != 0) {
                i4 = ionGallerySettings.height;
            }
            if ((i5 & 256) != 0) {
                z3 = ionGallerySettings.correctOrientation;
            }
            int i6 = i4;
            boolean z4 = z3;
            int i7 = i2;
            int i8 = i3;
            IonEditableMode ionEditableMode2 = ionEditableMode;
            int i9 = i;
            return ionGallerySettings.copy(iONCAMRMediaType, z, i9, z2, ionEditableMode2, i7, i8, i6, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final IONCAMRMediaType getMediaType() {
            return this.mediaType;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAllowMultipleSelection() {
            return this.allowMultipleSelection;
        }

        /* renamed from: component3, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIncludeMetadata() {
            return this.includeMetadata;
        }

        /* renamed from: component5, reason: from getter */
        public final IonEditableMode getEditable() {
            return this.editable;
        }

        /* renamed from: component6, reason: from getter */
        public final int getQuality() {
            return this.quality;
        }

        /* renamed from: component7, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component8, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCorrectOrientation() {
            return this.correctOrientation;
        }

        public final IonGallerySettings copy(IONCAMRMediaType mediaType, boolean allowMultipleSelection, int limit, boolean includeMetadata, IonEditableMode editable, int quality, int width, int height, boolean correctOrientation) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics.checkNotNullParameter(editable, "editable");
            return new IonGallerySettings(mediaType, allowMultipleSelection, limit, includeMetadata, editable, quality, width, height, correctOrientation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IonGallerySettings)) {
                return false;
            }
            IonGallerySettings ionGallerySettings = (IonGallerySettings) other;
            return this.mediaType == ionGallerySettings.mediaType && this.allowMultipleSelection == ionGallerySettings.allowMultipleSelection && this.limit == ionGallerySettings.limit && this.includeMetadata == ionGallerySettings.includeMetadata && this.editable == ionGallerySettings.editable && this.quality == ionGallerySettings.quality && this.width == ionGallerySettings.width && this.height == ionGallerySettings.height && this.correctOrientation == ionGallerySettings.correctOrientation;
        }

        public int hashCode() {
            return (((((((((((((((this.mediaType.hashCode() * 31) + Boolean.hashCode(this.allowMultipleSelection)) * 31) + Integer.hashCode(this.limit)) * 31) + Boolean.hashCode(this.includeMetadata)) * 31) + this.editable.hashCode()) * 31) + Integer.hashCode(this.quality)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Boolean.hashCode(this.correctOrientation);
        }

        public String toString() {
            return "IonGallerySettings(mediaType=" + this.mediaType + ", allowMultipleSelection=" + this.allowMultipleSelection + ", limit=" + this.limit + ", includeMetadata=" + this.includeMetadata + ", editable=" + this.editable + ", quality=" + this.quality + ", width=" + this.width + ", height=" + this.height + ", correctOrientation=" + this.correctOrientation + ")";
        }

        public IonGallerySettings(IONCAMRMediaType mediaType, boolean allowMultipleSelection, int limit, boolean includeMetadata, IonEditableMode editable, int quality, int width, int height, boolean correctOrientation) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics.checkNotNullParameter(editable, "editable");
            this.mediaType = mediaType;
            this.allowMultipleSelection = allowMultipleSelection;
            this.limit = limit;
            this.includeMetadata = includeMetadata;
            this.editable = editable;
            this.quality = quality;
            this.width = width;
            this.height = height;
            this.correctOrientation = correctOrientation;
        }

        public /* synthetic */ IonGallerySettings(IONCAMRMediaType iONCAMRMediaType, boolean z, int i, boolean z2, IonEditableMode ionEditableMode, int i2, int i3, int i4, boolean z3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? IONCAMRMediaType.ALL : iONCAMRMediaType, (i5 & 2) != 0 ? false : z, (i5 & 4) != 0 ? 0 : i, (i5 & 8) != 0 ? false : z2, (i5 & 16) != 0 ? IonEditableMode.NO : ionEditableMode, (i5 & 32) != 0 ? 90 : i2, (i5 & 64) != 0 ? 0 : i3, (i5 & 128) != 0 ? 0 : i4, (i5 & 256) != 0 ? true : z3);
        }

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

    public final IonCameraSettings getCameraSettings(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraSettings settings = new IonCameraSettings();
        Integer num = call.getInt("quality");
        settings.setQuality(num != null ? num.intValue() : 90);
        Integer num2 = call.getInt("targetWidth");
        int width = num2 != null ? num2.intValue() : 0;
        Integer num3 = call.getInt("targetHeight");
        int height = num3 != null ? num3.intValue() : 0;
        settings.setTargetWidth(width < 1 ? -1 : width);
        settings.setTargetHeight(height >= 1 ? height : -1);
        Boolean bool = call.getBoolean("correctOrientation");
        settings.setCorrectOrientation(bool != null ? bool.booleanValue() : true);
        Integer num4 = call.getInt("encodingType");
        settings.setEncodingType(num4 != null ? num4.intValue() : 0);
        Boolean bool2 = call.getBoolean("saveToGallery");
        settings.setSaveToGallery(bool2 != null ? bool2.booleanValue() : false);
        settings.setEditable(IonEditableMode.INSTANCE.fromString(call.getString("editable")));
        Boolean bool3 = call.getBoolean("includeMetadata");
        settings.setIncludeMetadata(bool3 != null ? bool3.booleanValue() : false);
        settings.setShouldResize(settings.getTargetWidth() > 0 || settings.getTargetHeight() > 0);
        return settings;
    }

    private final void showCamera(PluginCall call) {
        if (!this.context.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            sendError(IONCAMRError.NO_CAMERA_AVAILABLE_ERROR);
        } else {
            openCamera(call);
        }
    }

    public final void openCamera(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IonCameraSettings settings = this.cameraSettings;
        if (settings == null) {
            IonCameraFlow $this$openCamera_u24lambda_u240 = this;
            $this$openCamera_u24lambda_u240.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
            return;
        }
        if (checkCameraPermissions(call, settings.getSaveToGallery())) {
            try {
                IONCAMRCameraManager manager = this.cameraManager;
                if (manager == null) {
                    IonCameraFlow $this$openCamera_u24lambda_u241 = this;
                    $this$openCamera_u24lambda_u241.sendError(IONCAMRError.CONTEXT_ERROR);
                    return;
                }
                this.currentCall = call;
                AppCompatActivity appCompatActivity = this.activity;
                int encodingType = settings.getEncodingType();
                ActivityResultLauncher<Intent> activityResultLauncher = this.cameraLauncher;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraLauncher");
                    activityResultLauncher = null;
                }
                manager.takePhoto(appCompatActivity, encodingType, activityResultLauncher);
            } catch (Exception e) {
                sendError(IONCAMRError.TAKE_PHOTO_ERROR);
            }
        }
    }

    public final void openRecordVideo(PluginCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        IONCAMRVideoParameters settings = this.videoParameters;
        if (settings == null) {
            IonCameraFlow $this$openRecordVideo_u24lambda_u240 = this;
            $this$openRecordVideo_u24lambda_u240.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
            return;
        }
        if (checkCameraPermissions(call, settings.getSaveToGallery())) {
            try {
                IONCAMRCameraManager manager = this.cameraManager;
                if (manager == null) {
                    IonCameraFlow $this$openRecordVideo_u24lambda_u241 = this;
                    $this$openRecordVideo_u24lambda_u241.sendError(IONCAMRError.CONTEXT_ERROR);
                    return;
                }
                this.currentCall = call;
                AppCompatActivity appCompatActivity = this.activity;
                boolean saveToGallery = settings.getSaveToGallery();
                ActivityResultLauncher<Intent> activityResultLauncher = this.videoLauncher;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoLauncher");
                    activityResultLauncher = null;
                }
                manager.recordVideo(appCompatActivity, saveToGallery, activityResultLauncher, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IonCameraFlow.openRecordVideo$lambda$2(this.f$0, (IONCAMRError) obj);
                    }
                });
            } catch (Exception e) {
                sendError(IONCAMRError.CAPTURE_VIDEO_ERROR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openRecordVideo$lambda$2(IonCameraFlow this$0, IONCAMRError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.sendError(it);
        return Unit.INSTANCE;
    }

    private final void openPlayVideo(final PluginCall call) {
        try {
            IONCAMRVideoManager manager = this.videoManager;
            if (manager == null) {
                IonCameraFlow $this$openPlayVideo_u24lambda_u240 = this;
                $this$openPlayVideo_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
                return;
            }
            String videoUri = call.getString("uri");
            if (videoUri == null) {
                sendError(IONCAMRError.PLAY_VIDEO_GENERAL_ERROR);
            } else {
                manager.playVideo(this.activity, videoUri, new Function0() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IonCameraFlow.openPlayVideo$lambda$1(call);
                    }
                }, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IonCameraFlow.openPlayVideo$lambda$2(this.f$0, (IONCAMRError) obj);
                    }
                });
            }
        } catch (Exception e) {
            sendError(IONCAMRError.PLAY_VIDEO_GENERAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openPlayVideo$lambda$1(PluginCall $call) {
        $call.resolve();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openPlayVideo$lambda$2(IonCameraFlow this$0, IONCAMRError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.sendError(it);
        return Unit.INSTANCE;
    }

    private final void openGallery(PluginCall call) {
        if (checkGalleryPermissions(call)) {
            IONCAMRGalleryManager iONCAMRGalleryManager = this.galleryManager;
            if (iONCAMRGalleryManager == null) {
                IonCameraFlow $this$openGallery_u24lambda_u240 = this;
                $this$openGallery_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
                return;
            }
            IonGallerySettings settings = this.gallerySettings;
            if (settings == null) {
                IonCameraFlow $this$openGallery_u24lambda_u241 = this;
                $this$openGallery_u24lambda_u241.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
                return;
            }
            AppCompatActivity appCompatActivity = this.activity;
            IONCAMRMediaType mediaType = settings.getMediaType();
            boolean allowMultipleSelection = settings.getAllowMultipleSelection();
            int limit = settings.getLimit();
            ActivityResultLauncher<Intent> activityResultLauncher = this.galleryLauncher;
            if (activityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryLauncher");
                activityResultLauncher = null;
            }
            iONCAMRGalleryManager.chooseFromGallery(appCompatActivity, mediaType, allowMultipleSelection, limit, activityResultLauncher);
        }
    }

    private final void callEditPhoto(PluginCall call) {
        IONCAMREditManager manager = this.editManager;
        if (manager == null) {
            IonCameraFlow $this$callEditPhoto_u24lambda_u240 = this;
            $this$callEditPhoto_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        this.editParameters = new IONCAMREditParameters("", false, false, false);
        String imageBase64 = call.getString("inputImage");
        String str = imageBase64;
        if (str == null || str.length() == 0) {
            sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
            return;
        }
        AppCompatActivity appCompatActivity = this.activity;
        ActivityResultLauncher<Intent> activityResultLauncher = this.editLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editLauncher");
            activityResultLauncher = null;
        }
        manager.editImage(appCompatActivity, imageBase64, activityResultLauncher);
    }

    private final void callEditURIPhoto(PluginCall call) {
        IONCAMREditManager manager = this.editManager;
        if (manager == null) {
            IonCameraFlow $this$callEditURIPhoto_u24lambda_u240 = this;
            $this$callEditURIPhoto_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        String photoPath = call.getString("uri");
        Boolean bool = call.getBoolean("saveToGallery");
        boolean saveToGallery = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = call.getBoolean("includeMetadata");
        boolean includeMetadata = bool2 != null ? bool2.booleanValue() : false;
        if (photoPath == null) {
            return;
        }
        this.editParameters = new IONCAMREditParameters(photoPath, true, saveToGallery, includeMetadata);
        AppCompatActivity appCompatActivity = this.activity;
        ActivityResultLauncher<Intent> activityResultLauncher = this.editLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editLauncher");
            activityResultLauncher = null;
        }
        manager.editURIPicture(appCompatActivity, photoPath, activityResultLauncher, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IonCameraFlow.callEditURIPhoto$lambda$1(this.f$0, (IONCAMRError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit callEditURIPhoto$lambda$1(IonCameraFlow this$0, IONCAMRError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.sendError(IONCAMRError.EDIT_IMAGE_ERROR);
        return Unit.INSTANCE;
    }

    private final void handleCameraResult(ActivityResult result) throws XmlPullParserException, IOException {
        switch (result.getResultCode()) {
            case -1:
                IonCameraSettings settings = this.cameraSettings;
                if (settings == null) {
                    IonCameraFlow $this$handleCameraResult_u24lambda_u240 = this;
                    $this$handleCameraResult_u24lambda_u240.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
                    return;
                }
                switch (WhenMappings.$EnumSwitchMapping$0[settings.getEditable().ordinal()]) {
                    case 1:
                        editPhoto();
                        return;
                    case 2:
                        IONCAMREditManager editor = this.editManager;
                        if (editor == null) {
                            IonCameraFlow $this$handleCameraResult_u24lambda_u241 = this;
                            $this$handleCameraResult_u24lambda_u241.sendError(IONCAMRError.CONTEXT_ERROR);
                            return;
                        }
                        String appId = this.appId;
                        AppCompatActivity appCompatActivity = this.activity;
                        String str = appId + AUTHORITY;
                        AppCompatActivity appCompatActivity2 = this.activity;
                        int encodingType = settings.getEncodingType();
                        String string = this.activity.getSharedPreferences(STORE, 0).getString(EDIT_FILE_NAME_KEY, "");
                        Uri tmpFile = FileProvider.getUriForFile(appCompatActivity, str, editor.createCaptureFile(appCompatActivity2, encodingType, string != null ? string : ""));
                        Intrinsics.checkNotNull(tmpFile);
                        Intent editIntent = createEditIntent(tmpFile);
                        if (editIntent == null) {
                            editPhoto();
                            return;
                        }
                        ActivityResultLauncher<Intent> activityResultLauncher = this.cameraCropLauncher;
                        if (activityResultLauncher == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cameraCropLauncher");
                            activityResultLauncher = null;
                        }
                        activityResultLauncher.launch(editIntent);
                        return;
                    case 3:
                        processResult(result.getData());
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 0:
                sendError(IONCAMRError.NO_PICTURE_TAKEN_ERROR);
                return;
            default:
                sendError(IONCAMRError.TAKE_PHOTO_ERROR);
                return;
        }
    }

    private final void handleVideoResult(ActivityResult result) {
        switch (result.getResultCode()) {
            case -1:
                processResultFromVideo(result);
                break;
            case 0:
                sendError(IONCAMRError.CAPTURE_VIDEO_CANCELLED_ERROR);
                break;
            default:
                sendError(IONCAMRError.CAPTURE_VIDEO_ERROR);
                break;
        }
    }

    private final void handleGalleryResult(ActivityResult result) throws FileNotFoundException {
        Uri tempUri;
        switch (result.getResultCode()) {
            case -1:
                IONCAMREditManager editor = this.editManager;
                if (editor == null) {
                    IonCameraFlow $this$handleGalleryResult_u24lambda_u240 = this;
                    $this$handleGalleryResult_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
                    break;
                } else {
                    IONCAMRGalleryManager manager = this.galleryManager;
                    if (manager == null) {
                        IonCameraFlow $this$handleGalleryResult_u24lambda_u241 = this;
                        $this$handleGalleryResult_u24lambda_u241.sendError(IONCAMRError.CONTEXT_ERROR);
                        break;
                    } else {
                        IonGallerySettings settings = this.gallerySettings;
                        if (settings == null) {
                            IonCameraFlow $this$handleGalleryResult_u24lambda_u242 = this;
                            $this$handleGalleryResult_u24lambda_u242.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
                            break;
                        } else {
                            List uris = manager.extractUris(result.getData());
                            if (uris.isEmpty()) {
                                sendError(IONCAMRError.GENERIC_CHOOSE_MULTIMEDIA_ERROR);
                                break;
                            } else if (settings.getEditable() != IonEditableMode.NO && uris.size() == 1 && settings.getMediaType() == IONCAMRMediaType.PICTURE) {
                                Uri originalUri = (Uri) CollectionsKt.first(uris);
                                ActivityResultLauncher<Intent> activityResultLauncher = null;
                                switch (WhenMappings.$EnumSwitchMapping$0[settings.getEditable().ordinal()]) {
                                    case 1:
                                        AppCompatActivity appCompatActivity = this.activity;
                                        ActivityResultLauncher<Intent> activityResultLauncher2 = this.galleryCropLauncher;
                                        if (activityResultLauncher2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("galleryCropLauncher");
                                        } else {
                                            activityResultLauncher = activityResultLauncher2;
                                        }
                                        editor.openCropActivity(appCompatActivity, originalUri, activityResultLauncher);
                                        break;
                                    case 2:
                                        if (Intrinsics.areEqual(originalUri.getScheme(), "content")) {
                                            tempUri = IonCameraUtils.INSTANCE.getGalleryTempImage$capacitor_camera_debug(this.activity, originalUri);
                                        } else {
                                            tempUri = originalUri;
                                        }
                                        if (tempUri == null) {
                                            sendError(IONCAMRError.EDIT_IMAGE_ERROR);
                                            break;
                                        } else {
                                            Intent editIntent = createEditIntent(tempUri);
                                            if (editIntent != null) {
                                                ActivityResultLauncher<Intent> activityResultLauncher3 = this.galleryCropLauncher;
                                                if (activityResultLauncher3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("galleryCropLauncher");
                                                } else {
                                                    activityResultLauncher = activityResultLauncher3;
                                                }
                                                activityResultLauncher.launch(editIntent);
                                                break;
                                            } else {
                                                AppCompatActivity appCompatActivity2 = this.activity;
                                                ActivityResultLauncher<Intent> activityResultLauncher4 = this.galleryCropLauncher;
                                                if (activityResultLauncher4 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("galleryCropLauncher");
                                                } else {
                                                    activityResultLauncher = activityResultLauncher4;
                                                }
                                                editor.openCropActivity(appCompatActivity2, originalUri, activityResultLauncher);
                                                break;
                                            }
                                        }
                                }
                            } else {
                                processResultFromGallery(result);
                                break;
                            }
                        }
                    }
                }
                break;
            case 0:
                sendError(IONCAMRError.CHOOSE_MULTIMEDIA_CANCELLED_ERROR);
                break;
            default:
                sendError(IONCAMRError.GENERIC_CHOOSE_MULTIMEDIA_ERROR);
                break;
        }
    }

    private final void handleGalleryCropResult(ActivityResult result) {
        IonGallerySettings settings = this.gallerySettings;
        if (settings == null) {
            IonCameraFlow $this$handleGalleryCropResult_u24lambda_u240 = this;
            $this$handleGalleryCropResult_u24lambda_u240.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
        }
        switch (result.getResultCode()) {
            case -1:
                Intent intent = result.getData();
                String resultPath = intent != null ? intent.getStringExtra(IONCAMRImageEditorActivity.IMAGE_OUTPUT_URI_EXTRAS) : null;
                String str = resultPath;
                if (str == null || str.length() == 0) {
                    String str2 = this.lastEditUri;
                    if (str2 == null || str2.length() == 0) {
                        sendError(IONCAMRError.EDIT_IMAGE_ERROR);
                        break;
                    } else {
                        Intent $this$handleGalleryCropResult_u24lambda_u241 = new Intent();
                        $this$handleGalleryCropResult_u24lambda_u241.putExtra(IONCAMRImageEditorActivity.IMAGE_OUTPUT_URI_EXTRAS, this.lastEditUri);
                        intent = $this$handleGalleryCropResult_u24lambda_u241;
                    }
                }
                processResultEditFromGallery(intent);
                this.lastEditUri = null;
                break;
            case 0:
                if (settings.getEditable() == IonEditableMode.EXTERNAL) {
                    String str3 = this.lastEditUri;
                    if (!(str3 == null || str3.length() == 0)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(IONCAMRImageEditorActivity.IMAGE_OUTPUT_URI_EXTRAS, this.lastEditUri);
                        processResultEditFromGallery(intent2);
                        break;
                    }
                }
                this.lastEditUri = null;
                sendError(IONCAMRError.EDIT_CANCELLED_ERROR);
                break;
            default:
                sendError(IONCAMRError.EDIT_IMAGE_ERROR);
                break;
        }
    }

    private final void processResultEditFromGallery(Intent intent) {
        IONCAMRGalleryManager iONCAMRGalleryManager = this.galleryManager;
        if (iONCAMRGalleryManager == null) {
            IonCameraFlow $this$processResultEditFromGallery_u24lambda_u240 = this;
            $this$processResultEditFromGallery_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        IonGallerySettings settings = this.gallerySettings;
        if (settings != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(iONCAMRGalleryManager, this, intent, settings, null), 3, null);
        } else {
            IonCameraFlow $this$processResultEditFromGallery_u24lambda_u241 = this;
            $this$processResultEditFromGallery_u24lambda_u241.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
        }
    }

    /* compiled from: IonCameraFlow.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.capacitorjs.plugins.camera.IonCameraFlow$processResultEditFromGallery$1", f = "IonCameraFlow.kt", i = {}, l = {570}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: com.capacitorjs.plugins.camera.IonCameraFlow$processResultEditFromGallery$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ IONCAMRGalleryManager $manager;
        final /* synthetic */ IonGallerySettings $settings;
        int label;
        final /* synthetic */ IonCameraFlow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IONCAMRGalleryManager iONCAMRGalleryManager, IonCameraFlow ionCameraFlow, Intent intent, IonGallerySettings ionGallerySettings, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$manager = iONCAMRGalleryManager;
            this.this$0 = ionCameraFlow;
            this.$intent = intent;
            this.$settings = ionGallerySettings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$manager, this.this$0, this.$intent, this.$settings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IONCAMRGalleryManager iONCAMRGalleryManager = this.$manager;
                    AppCompatActivity appCompatActivity = this.this$0.activity;
                    Intent intent = this.$intent;
                    boolean includeMetadata = this.$settings.getIncludeMetadata();
                    final IonCameraFlow ionCameraFlow = this.this$0;
                    Function1<? super List<IONCAMRMediaResult>, Unit> function1 = new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$processResultEditFromGallery$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IonCameraFlow.AnonymousClass1.invokeSuspend$lambda$0(ionCameraFlow, (List) obj);
                        }
                    };
                    final IonCameraFlow ionCameraFlow2 = this.this$0;
                    this.label = 1;
                    if (iONCAMRGalleryManager.onChooseFromGalleryEditResult(appCompatActivity, -1, intent, includeMetadata, function1, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$processResultEditFromGallery$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IonCameraFlow.AnonymousClass1.invokeSuspend$lambda$1(ionCameraFlow2, (IONCAMRError) obj);
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(IonCameraFlow this$0, List it) throws JSONException, IOException {
            this$0.handleGalleryMediaResults(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(IonCameraFlow this$0, IONCAMRError it) {
            this$0.sendError(it);
            return Unit.INSTANCE;
        }
    }

    private final void handleEditResult(ActivityResult result) {
        switch (result.getResultCode()) {
            case -1:
                processResultFromEdit(result);
                break;
            case 0:
                sendError(IONCAMRError.EDIT_CANCELLED_ERROR);
                break;
            default:
                sendError(IONCAMRError.EDIT_IMAGE_ERROR);
                break;
        }
    }

    private final void editPhoto() throws XmlPullParserException, IOException {
        IONCAMREditManager editor = this.editManager;
        if (editor == null) {
            IonCameraFlow $this$editPhoto_u24lambda_u240 = this;
            $this$editPhoto_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        IonCameraSettings settings = this.cameraSettings;
        if (settings == null) {
            IonCameraFlow $this$editPhoto_u24lambda_u241 = this;
            $this$editPhoto_u24lambda_u241.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
            return;
        }
        String appId = this.appId;
        AppCompatActivity appCompatActivity = this.activity;
        String str = appId + AUTHORITY;
        AppCompatActivity appCompatActivity2 = this.activity;
        int encodingType = settings.getEncodingType();
        String string = this.activity.getSharedPreferences(STORE, 0).getString(EDIT_FILE_NAME_KEY, "");
        Uri tmpFile = FileProvider.getUriForFile(appCompatActivity, str, editor.createCaptureFile(appCompatActivity2, encodingType, string != null ? string : ""));
        AppCompatActivity appCompatActivity3 = this.activity;
        ActivityResultLauncher<Intent> activityResultLauncher = this.cameraCropLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraCropLauncher");
            activityResultLauncher = null;
        }
        editor.openCropActivity(appCompatActivity3, tmpFile, activityResultLauncher);
    }

    private final Intent createEditIntent(Uri origPhotoUri) {
        List resInfoList;
        Uri editUri = origPhotoUri;
        try {
            if (Intrinsics.areEqual(origPhotoUri.getScheme(), "file")) {
                String path = origPhotoUri.getPath();
                Intrinsics.checkNotNull(path);
                File editFile = new File(path);
                Uri uriForFile = FileProvider.getUriForFile(this.activity, this.context.getPackageName() + AUTHORITY, editFile);
                Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
                editUri = uriForFile;
                this.lastEditUri = editFile.getAbsolutePath();
            } else if (Intrinsics.areEqual(origPhotoUri.getScheme(), "content")) {
                Uri tempUri = IonCameraUtils.INSTANCE.getCameraTempImage$capacitor_camera_debug(this.activity, origPhotoUri);
                if (tempUri == null) {
                    return null;
                }
                String path2 = tempUri.getPath();
                Intrinsics.checkNotNull(path2);
                File editFile2 = new File(path2);
                Uri uriForFile2 = FileProvider.getUriForFile(this.activity, this.context.getPackageName() + AUTHORITY, editFile2);
                Intrinsics.checkNotNullExpressionValue(uriForFile2, "getUriForFile(...)");
                editUri = uriForFile2;
                this.lastEditUri = editFile2.getAbsolutePath();
            }
            Intent editIntent = new Intent("android.intent.action.EDIT");
            editIntent.setDataAndType(editUri, "image/*");
            editIntent.addFlags(3);
            editIntent.putExtra("output", editUri);
            if (Build.VERSION.SDK_INT >= 33) {
                resInfoList = this.context.getPackageManager().queryIntentActivities(editIntent, PackageManager.ResolveInfoFlags.of(65536L));
            } else {
                resInfoList = legacyQueryIntentActivities(editIntent);
            }
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                this.context.grantUriPermission(packageName, editUri, 3);
            }
            return editIntent;
        } catch (Exception e) {
            return null;
        }
    }

    private final List<ResolveInfo> legacyQueryIntentActivities(Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities;
    }

    private final void handleCameraCropResult(ActivityResult result) throws IOException {
        IonCameraSettings settings = this.cameraSettings;
        if (settings == null) {
            IonCameraFlow $this$handleCameraCropResult_u24lambda_u240 = this;
            $this$handleCameraCropResult_u24lambda_u240.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
        }
        switch (result.getResultCode()) {
            case -1:
                Intent intent = result.getData();
                String resultPath = intent != null ? intent.getStringExtra(IONCAMRImageEditorActivity.IMAGE_OUTPUT_URI_EXTRAS) : null;
                String str = resultPath;
                if (str == null || str.length() == 0) {
                    String str2 = this.lastEditUri;
                    if (str2 == null || str2.length() == 0) {
                        sendError(IONCAMRError.EDIT_IMAGE_ERROR);
                        break;
                    } else {
                        Intent $this$handleCameraCropResult_u24lambda_u241 = new Intent();
                        $this$handleCameraCropResult_u24lambda_u241.putExtra(IONCAMRImageEditorActivity.IMAGE_OUTPUT_URI_EXTRAS, this.lastEditUri);
                        intent = $this$handleCameraCropResult_u24lambda_u241;
                    }
                }
                processResult(intent);
                this.lastEditUri = null;
                break;
            case 0:
                if (settings.getEditable() == IonEditableMode.EXTERNAL) {
                    String str3 = this.lastEditUri;
                    if (!(str3 == null || str3.length() == 0)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(IONCAMRImageEditorActivity.IMAGE_OUTPUT_URI_EXTRAS, this.lastEditUri);
                        processResult(intent2);
                        break;
                    }
                }
                this.lastEditUri = null;
                sendError(IONCAMRError.EDIT_CANCELLED_ERROR);
                break;
            default:
                sendError(IONCAMRError.EDIT_IMAGE_ERROR);
                break;
        }
    }

    private final void handleEditBase64Result(String image) throws JSONException {
        JSObject ret = new JSObject();
        ret.put("outputImage", image);
        PluginCall pluginCall = this.currentCall;
        if (pluginCall != null) {
            pluginCall.resolve(ret);
        }
        this.currentCall = null;
    }

    private final void handleMediaResult(IONCAMRMediaResult mediaResult) throws JSONException, IOException {
        File file = new File(mediaResult.getUri());
        Uri uri = Uri.fromFile(file);
        Bitmap bitmap = BitmapFactory.decodeFile(mediaResult.getUri());
        if (bitmap == null) {
            sendError(IONCAMRError.PROCESS_IMAGE_ERROR);
            return;
        }
        ExifWrapper exif = ImageUtils.getExifData(this.context, bitmap, uri);
        JSObject ret = new JSObject();
        ret.put("type", mediaResult.getType());
        ret.put("uri", mediaResult.getUri());
        ret.put("thumbnail", mediaResult.getThumbnail());
        ret.put("webPath", FileUtils.getPortablePath(this.context, this.bridge.getLocalUrl(), uri));
        ret.put("saved", mediaResult.getSaved());
        IONCAMRMediaMetadata it = mediaResult.getMetadata();
        if (it != null) {
            JSObject metadata = new JSObject();
            metadata.put(TypedValues.TransitionType.S_DURATION, (Object) it.getDuration());
            metadata.put("size", (Object) it.getSize());
            metadata.put("format", it.getFormat());
            metadata.put("resolution", it.getResolution());
            metadata.put("creationDate", it.getCreationDate());
            metadata.put("exif", (Object) exif.toJson());
            ret.put("metadata", (Object) metadata);
        }
        PluginCall pluginCall = this.currentCall;
        if (pluginCall != null) {
            pluginCall.resolve(ret);
        }
        this.currentCall = null;
        this.lastEditUri = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleVideoMediaResult(IONCAMRMediaResult mediaResult) throws JSONException {
        File file = new File(mediaResult.getUri());
        Uri uri = Uri.fromFile(file);
        JSObject ret = new JSObject();
        ret.put("type", mediaResult.getType());
        ret.put("uri", mediaResult.getUri());
        ret.put("thumbnail", mediaResult.getThumbnail());
        ret.put("webPath", FileUtils.getPortablePath(this.context, this.bridge.getLocalUrl(), uri));
        ret.put("saved", mediaResult.getSaved());
        IONCAMRMediaMetadata it = mediaResult.getMetadata();
        if (it != null) {
            JSObject metadata = new JSObject();
            metadata.put(TypedValues.TransitionType.S_DURATION, (Object) it.getDuration());
            metadata.put("size", (Object) it.getSize());
            metadata.put("format", it.getFormat());
            metadata.put("resolution", it.getResolution());
            metadata.put("creationDate", it.getCreationDate());
            ret.put("metadata", (Object) metadata);
        }
        PluginCall pluginCall = this.currentCall;
        if (pluginCall != null) {
            pluginCall.resolve(ret);
        }
        this.currentCall = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGalleryMediaResults(List<IONCAMRMediaResult> results) throws JSONException, IOException {
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        JSArray jSArray = new JSArray();
        List<IONCAMRMediaResult> $this$forEach$iv2 = results;
        int $i$f$forEach2 = 0;
        for (Object element$iv : $this$forEach$iv2) {
            IONCAMRMediaResult mediaResult = (IONCAMRMediaResult) element$iv;
            File file = new File(mediaResult.getUri());
            Uri uri = Uri.fromFile(file);
            JSObject ret = new JSObject();
            ret.put("type", mediaResult.getType());
            ret.put("uri", mediaResult.getUri());
            ret.put("thumbnail", mediaResult.getThumbnail());
            ret.put("saved", mediaResult.getSaved());
            ret.put("webPath", FileUtils.getPortablePath(this.context, this.bridge.getLocalUrl(), uri));
            IONCAMRMediaMetadata it = mediaResult.getMetadata();
            if (it == null) {
                $this$forEach$iv = $this$forEach$iv2;
                $i$f$forEach = $i$f$forEach2;
            } else {
                JSObject metadata = new JSObject();
                metadata.put(TypedValues.TransitionType.S_DURATION, (Object) it.getDuration());
                metadata.put("size", (Object) it.getSize());
                metadata.put("format", it.getFormat());
                metadata.put("resolution", it.getResolution());
                metadata.put("creationDate", it.getCreationDate());
                if (mediaResult.getType() != IONCAMRMediaType.PICTURE.getType()) {
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                } else {
                    Bitmap bitmap = BitmapFactory.decodeFile(mediaResult.getUri());
                    if (bitmap == null) {
                        sendError(IONCAMRError.PROCESS_IMAGE_ERROR);
                        return;
                    }
                    ExifWrapper exif = ImageUtils.getExifData(this.context, bitmap, uri);
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    metadata.put("exif", (Object) exif.toJson());
                }
                ret.put("metadata", (Object) metadata);
            }
            jSArray.put(ret);
            $this$forEach$iv2 = $this$forEach$iv;
            $i$f$forEach2 = $i$f$forEach;
        }
        JSObject jSObject = new JSObject();
        jSObject.put("results", (Object) jSArray);
        PluginCall pluginCall = this.currentCall;
        if (pluginCall != null) {
            pluginCall.resolve(jSObject);
        }
        this.currentCall = null;
        this.lastEditUri = null;
    }

    private final void processResult(Intent intent) throws IOException {
        IONCAMRCameraManager iONCAMRCameraManager = this.cameraManager;
        if (iONCAMRCameraManager == null) {
            IonCameraFlow $this$processResult_u24lambda_u240 = this;
            $this$processResult_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        IonCameraSettings settings = this.cameraSettings;
        if (settings == null) {
            IonCameraFlow $this$processResult_u24lambda_u241 = this;
            $this$processResult_u24lambda_u241.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
        } else {
            IONCAMRCameraParameters ionParams = toIonParameters(settings);
            iONCAMRCameraManager.processResultFromCamera(this.activity, intent, ionParams, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IonCameraFlow.processResult$lambda$2(this.f$0, (IONCAMRMediaResult) obj);
                }
            }, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IonCameraFlow.processResult$lambda$3(this.f$0, (IONCAMRError) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processResult$lambda$2(IonCameraFlow this$0, IONCAMRMediaResult mediaResult) throws JSONException, IOException {
        Intrinsics.checkNotNullParameter(mediaResult, "mediaResult");
        this$0.handleMediaResult(mediaResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processResult$lambda$3(IonCameraFlow this$0, IONCAMRError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this$0.sendError(error);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.net.Uri] */
    private final void processResultFromVideo(ActivityResult result) {
        IONCAMRCameraManager iONCAMRCameraManager = this.cameraManager;
        if (iONCAMRCameraManager == null) {
            sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intent data = result.getData();
        objectRef.element = data != null ? data.getData() : 0;
        if (objectRef.element == 0) {
            objectRef.element = Uri.parse(this.activity.getSharedPreferences(STORE, 0).getString(STORE, ""));
        }
        if (this.activity == null) {
            sendError(IONCAMRError.CAPTURE_VIDEO_ERROR);
            return;
        }
        IONCAMRVideoParameters iONCAMRVideoParameters = this.videoParameters;
        if (iONCAMRVideoParameters != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass2(iONCAMRCameraManager, this, objectRef, iONCAMRVideoParameters, null), 3, null);
        } else {
            sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
        }
    }

    /* compiled from: IonCameraFlow.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromVideo$2", f = "IonCameraFlow.kt", i = {}, l = {874}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromVideo$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IONCAMRCameraManager $manager;
        final /* synthetic */ IONCAMRVideoParameters $settings;
        final /* synthetic */ Ref.ObjectRef<Uri> $uri;
        int label;
        final /* synthetic */ IonCameraFlow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(IONCAMRCameraManager iONCAMRCameraManager, IonCameraFlow ionCameraFlow, Ref.ObjectRef<Uri> objectRef, IONCAMRVideoParameters iONCAMRVideoParameters, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$manager = iONCAMRCameraManager;
            this.this$0 = ionCameraFlow;
            this.$uri = objectRef;
            this.$settings = iONCAMRVideoParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$manager, this.this$0, this.$uri, this.$settings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IONCAMRCameraManager iONCAMRCameraManager = this.$manager;
                    AppCompatActivity appCompatActivity = this.this$0.activity;
                    Uri uri = this.$uri.element;
                    boolean saveToGallery = this.$settings.getSaveToGallery();
                    boolean zIsPersistent = this.$settings.isPersistent();
                    boolean includeMetadata = this.$settings.getIncludeMetadata();
                    final IonCameraFlow ionCameraFlow = this.this$0;
                    Function1<? super IONCAMRMediaResult, Unit> function1 = new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromVideo$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IonCameraFlow.AnonymousClass2.invokeSuspend$lambda$0(ionCameraFlow, (IONCAMRMediaResult) obj);
                        }
                    };
                    final IonCameraFlow ionCameraFlow2 = this.this$0;
                    this.label = 1;
                    if (iONCAMRCameraManager.processResultFromVideo(appCompatActivity, uri, saveToGallery, zIsPersistent, includeMetadata, function1, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromVideo$2$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IonCameraFlow.AnonymousClass2.invokeSuspend$lambda$1(ionCameraFlow2, (IONCAMRError) obj);
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(IonCameraFlow this$0, IONCAMRMediaResult mediaResult) throws JSONException {
            this$0.handleVideoMediaResult(mediaResult);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(IonCameraFlow this$0, IONCAMRError it) {
            this$0.sendError(IONCAMRError.CAPTURE_VIDEO_ERROR);
            return Unit.INSTANCE;
        }
    }

    private final void processResultFromGallery(ActivityResult result) {
        IONCAMRGalleryManager iONCAMRGalleryManager = this.galleryManager;
        if (iONCAMRGalleryManager == null) {
            IonCameraFlow $this$processResultFromGallery_u24lambda_u240 = this;
            $this$processResultFromGallery_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
            return;
        }
        IonGallerySettings settings = this.gallerySettings;
        if (settings != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C00331(iONCAMRGalleryManager, this, result, settings, null), 3, null);
        } else {
            IonCameraFlow $this$processResultFromGallery_u24lambda_u241 = this;
            $this$processResultFromGallery_u24lambda_u241.sendError(IONCAMRError.INVALID_ARGUMENT_ERROR);
        }
    }

    /* compiled from: IonCameraFlow.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromGallery$1", f = "IonCameraFlow.kt", i = {}, l = {TypedValues.Custom.TYPE_FLOAT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromGallery$1, reason: invalid class name and case insensitive filesystem */
    static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IONCAMRGalleryManager $manager;
        final /* synthetic */ ActivityResult $result;
        final /* synthetic */ IonGallerySettings $settings;
        int label;
        final /* synthetic */ IonCameraFlow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00331(IONCAMRGalleryManager iONCAMRGalleryManager, IonCameraFlow ionCameraFlow, ActivityResult activityResult, IonGallerySettings ionGallerySettings, Continuation<? super C00331> continuation) {
            super(2, continuation);
            this.$manager = iONCAMRGalleryManager;
            this.this$0 = ionCameraFlow;
            this.$result = activityResult;
            this.$settings = ionGallerySettings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00331(this.$manager, this.this$0, this.$result, this.$settings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IONCAMRGalleryManager iONCAMRGalleryManager = this.$manager;
                    AppCompatActivity appCompatActivity = this.this$0.activity;
                    int resultCode = this.$result.getResultCode();
                    Intent data = this.$result.getData();
                    boolean includeMetadata = this.$settings.getIncludeMetadata();
                    final IonCameraFlow ionCameraFlow = this.this$0;
                    Function1<? super List<IONCAMRMediaResult>, Unit> function1 = new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromGallery$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IonCameraFlow.C00331.invokeSuspend$lambda$0(ionCameraFlow, (List) obj);
                        }
                    };
                    final IonCameraFlow ionCameraFlow2 = this.this$0;
                    this.label = 1;
                    if (iONCAMRGalleryManager.onChooseFromGalleryResult(appCompatActivity, resultCode, data, includeMetadata, function1, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$processResultFromGallery$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IonCameraFlow.C00331.invokeSuspend$lambda$1(ionCameraFlow2, (IONCAMRError) obj);
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(IonCameraFlow this$0, List it) throws JSONException, IOException {
            this$0.handleGalleryMediaResults(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(IonCameraFlow this$0, IONCAMRError it) {
            this$0.sendError(it);
            return Unit.INSTANCE;
        }
    }

    private final void processResultFromEdit(ActivityResult result) {
        IONCAMREditManager iONCAMREditManager = this.editManager;
        if (iONCAMREditManager == null) {
            IonCameraFlow $this$processResultFromEdit_u24lambda_u240 = this;
            $this$processResultFromEdit_u24lambda_u240.sendError(IONCAMRError.CONTEXT_ERROR);
        } else {
            iONCAMREditManager.processResultFromEdit(this.activity, result.getData(), this.editParameters, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IonCameraFlow.processResultFromEdit$lambda$1(this.f$0, (String) obj);
                }
            }, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IonCameraFlow.processResultFromEdit$lambda$2(this.f$0, (IONCAMRMediaResult) obj);
                }
            }, new Function1() { // from class: com.capacitorjs.plugins.camera.IonCameraFlow$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IonCameraFlow.processResultFromEdit$lambda$3(this.f$0, (IONCAMRError) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processResultFromEdit$lambda$1(IonCameraFlow this$0, String image) throws JSONException {
        Intrinsics.checkNotNullParameter(image, "image");
        this$0.handleEditBase64Result(image);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processResultFromEdit$lambda$2(IonCameraFlow this$0, IONCAMRMediaResult mediaResult) throws JSONException, IOException {
        Intrinsics.checkNotNullParameter(mediaResult, "mediaResult");
        this$0.handleMediaResult(mediaResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processResultFromEdit$lambda$3(IonCameraFlow this$0, IONCAMRError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this$0.sendError(error);
        return Unit.INSTANCE;
    }

    private final IONCAMRCameraParameters toIonParameters(IonCameraSettings $this$toIonParameters) {
        return new IONCAMRCameraParameters($this$toIonParameters.getQuality(), $this$toIonParameters.getTargetWidth(), $this$toIonParameters.getTargetHeight(), $this$toIonParameters.getEncodingType(), 0, $this$toIonParameters.getEditable() != IonEditableMode.NO, $this$toIonParameters.getCorrectOrientation(), $this$toIonParameters.getSaveToGallery(), $this$toIonParameters.getIncludeMetadata());
    }

    public final boolean checkCameraPermissions(PluginCall call, boolean saveToGallery) {
        String[] aliases;
        Intrinsics.checkNotNullParameter(call, "call");
        boolean needCameraPerms = this.permissionHelper.isPermissionDeclared(CAMERA);
        boolean hasCameraPerms = !needCameraPerms || this.permissionHelper.getPermissionState(CAMERA) == PermissionState.GRANTED;
        boolean hasGalleryPerms = this.permissionHelper.getPermissionState(SAVE_GALLERY) == PermissionState.GRANTED;
        if (Build.VERSION.SDK_INT >= 29) {
            if (hasCameraPerms) {
                return true;
            }
            this.permissionHelper.requestPermissionForAlias(CAMERA, call, "ionCameraPermissionsCallback");
            return false;
        }
        if (saveToGallery && ((!hasCameraPerms || !hasGalleryPerms) && this.isFirstRequest)) {
            this.isFirstRequest = false;
            if (needCameraPerms) {
                aliases = new String[]{CAMERA, SAVE_GALLERY};
            } else {
                aliases = new String[]{SAVE_GALLERY};
            }
            this.permissionHelper.requestPermissionForAliases(aliases, call, "ionCameraPermissionsCallback");
            return false;
        }
        if (hasCameraPerms) {
            return true;
        }
        this.permissionHelper.requestPermissionForAlias(CAMERA, call, "ionCameraPermissionsCallback");
        return false;
    }

    private final boolean checkGalleryPermissions(PluginCall call) {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        boolean needGalleryPerms = this.permissionHelper.isPermissionDeclared(SAVE_GALLERY);
        boolean hasGalleryPerms = !needGalleryPerms || this.permissionHelper.getPermissionState(SAVE_GALLERY) == PermissionState.GRANTED;
        if (hasGalleryPerms) {
            return true;
        }
        this.permissionHelper.requestPermissionForAlias(SAVE_GALLERY, call, "ionCameraPermissionsCallback");
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void handlePermissionsCallback(PluginCall call) {
        IONCAMRVideoParameters iONCAMRVideoParameters;
        IonCameraSettings ionCameraSettings;
        Intrinsics.checkNotNullParameter(call, "call");
        if (!Intrinsics.areEqual(call.getMethodName(), "chooseFromGallery") && this.permissionHelper.getPermissionState(CAMERA) != PermissionState.GRANTED) {
            sendError(IONCAMRError.CAMERA_PERMISSION_DENIED_ERROR);
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            String methodName = call.getMethodName();
            boolean needsGalleryPerm = false;
            if (methodName != null) {
                switch (methodName.hashCode()) {
                    case 1132540337:
                        if (methodName.equals("chooseFromGallery")) {
                            needsGalleryPerm = true;
                            break;
                        }
                        break;
                    case 1308803754:
                        if (methodName.equals("recordVideo") && (iONCAMRVideoParameters = this.videoParameters) != null) {
                            needsGalleryPerm = iONCAMRVideoParameters.getSaveToGallery();
                            break;
                        }
                        break;
                    case 1484838379:
                        if (methodName.equals("takePhoto") && (ionCameraSettings = this.cameraSettings) != null) {
                            needsGalleryPerm = ionCameraSettings.getSaveToGallery();
                            break;
                        }
                        break;
                }
            }
            boolean galleryPermDeclared = this.permissionHelper.isPermissionDeclared(SAVE_GALLERY);
            if (needsGalleryPerm && galleryPermDeclared && this.permissionHelper.getPermissionState(SAVE_GALLERY) != PermissionState.GRANTED) {
                sendError(IONCAMRError.GALLERY_PERMISSION_DENIED_ERROR);
                return;
            }
        }
        String methodName2 = call.getMethodName();
        if (methodName2 != null) {
            switch (methodName2.hashCode()) {
                case 1132540337:
                    if (methodName2.equals("chooseFromGallery")) {
                        openGallery(call);
                        return;
                    }
                    break;
                case 1308803754:
                    if (methodName2.equals("recordVideo")) {
                        openRecordVideo(call);
                        return;
                    }
                    break;
                case 1484838379:
                    if (methodName2.equals("takePhoto")) {
                        openCamera(call);
                        return;
                    }
                    break;
            }
        }
        sendError(IONCAMRError.CONTEXT_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendError(IONCAMRError error) {
        try {
            try {
                JSObject jsonResult = new JSObject();
                jsonResult.put("code", formatErrorCode(error.getCode()));
                jsonResult.put("message", error.getDescription());
                PluginCall pluginCall = this.currentCall;
                if (pluginCall != null) {
                    pluginCall.reject(error.getDescription(), formatErrorCode(error.getCode()));
                }
                this.currentCall = null;
            } catch (Exception e) {
                PluginCall pluginCall2 = this.currentCall;
                if (pluginCall2 != null) {
                    pluginCall2.reject("There was an error performing the operation.");
                }
                this.currentCall = null;
            }
        } finally {
            this.lastEditUri = null;
        }
    }

    private final String formatErrorCode(int code) {
        String stringCode = Integer.toString(code);
        String strSubstring = ("0000" + stringCode).substring(stringCode.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return ERROR_FORMAT_PREFIX + strSubstring;
    }

    public final void onDestroy() {
        IONCAMRCameraManager iONCAMRCameraManager = this.cameraManager;
        if (iONCAMRCameraManager != null) {
            iONCAMRCameraManager.deleteVideoFilesFromCache(this.activity);
        }
    }
}
