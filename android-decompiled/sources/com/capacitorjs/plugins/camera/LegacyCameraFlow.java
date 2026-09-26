package com.capacitorjs.plugins.camera;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.capacitorjs.plugins.camera.CameraBottomSheetDialogFragment;
import com.getcapacitor.Bridge;
import com.getcapacitor.FileUtils;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PermissionState;
import com.getcapacitor.PluginCall;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class LegacyCameraFlow {
    private static final String CAMERA = "camera";
    private static final String IMAGE_EDIT_ERROR = "Unable to edit image";
    private static final String IMAGE_FILE_SAVE_ERROR = "Unable to create photo on disk";
    private static final String IMAGE_GALLERY_SAVE_ERROR = "Unable to save the image in the gallery";
    private static final String IMAGE_PROCESS_NO_FILE_ERROR = "Unable to process image, file not found on disk";
    private static final String INVALID_RESULT_TYPE_ERROR = "Invalid resultType option";
    private static final String LOG_TAG = "LegacyCameraFlow";
    private static final String NO_CAMERA_ACTIVITY_ERROR = "Unable to resolve camera activity";
    private static final String NO_CAMERA_ERROR = "Device doesn't have a camera available";
    private static final String NO_PHOTO_ACTIVITY_ERROR = "Unable to resolve photo activity";
    private static final String PERMISSION_DENIED_ERROR_CAMERA = "User denied access to camera";
    private static final String SAVE_GALLERY = "saveGallery";
    private static final String UNABLE_TO_PROCESS_IMAGE = "Unable to process image";
    private static final String USER_CANCELLED = "User cancelled photos app";
    private final AppCompatActivity activity;
    private final ActivityStarter activityStarter;
    private final String appId;
    private final Bridge bridge;
    private final Context context;
    private String imageEditedFileSavePath;
    private String imageFileSavePath;
    private Uri imageFileUri;
    private Uri imagePickedContentUri;
    private final PermissionHelper permissionHelper;
    private boolean isEdited = false;
    private boolean isFirstRequest = true;
    private boolean isSaved = false;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMultipleMedia = null;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia = null;
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private LegacyCameraSettings settings = new LegacyCameraSettings();

    public interface ActivityStarter {
        void startActivityForResult(PluginCall pluginCall, Intent intent, String str);
    }

    public LegacyCameraFlow(Context context, AppCompatActivity activity, Bridge bridge, String appId, PermissionHelper permissionHelper, ActivityStarter activityStarter) {
        this.context = context;
        this.activity = activity;
        this.bridge = bridge;
        this.appId = appId;
        this.permissionHelper = permissionHelper;
        this.activityStarter = activityStarter;
    }

    public void getPhoto(PluginCall call) {
        this.isEdited = false;
        this.settings = getSettings(call);
        doShow(call);
    }

    public void pickImages(PluginCall call) {
        this.settings = getSettings(call);
        openPhotos(call, true);
    }

    public void pickLimitedLibraryPhotos(PluginCall call) {
        call.unimplemented("not supported on android");
    }

    public void getLimitedLibraryPhotos(PluginCall call) {
        call.unimplemented("not supported on android");
    }

    private void doShow(PluginCall call) {
        switch (this.settings.getSource()) {
            case CAMERA:
                showCamera(call);
                break;
            case PHOTOS:
                showPhotos(call);
                break;
            default:
                showPrompt(call);
                break;
        }
    }

    private void showPrompt(final PluginCall call) {
        List<String> options = new ArrayList<>();
        options.add(call.getString("promptLabelPhoto", "From Photos"));
        options.add(call.getString("promptLabelPicture", "Take Picture"));
        CameraBottomSheetDialogFragment fragment = new CameraBottomSheetDialogFragment();
        fragment.setTitle(call.getString("promptLabelHeader", "Photo"));
        fragment.setOptions(options, new CameraBottomSheetDialogFragment.BottomSheetOnSelectedListener() { // from class: com.capacitorjs.plugins.camera.LegacyCameraFlow$$ExternalSyntheticLambda0
            @Override // com.capacitorjs.plugins.camera.CameraBottomSheetDialogFragment.BottomSheetOnSelectedListener
            public final void onSelected(int i) {
                this.f$0.lambda$showPrompt$0(call, i);
            }
        }, new CameraBottomSheetDialogFragment.BottomSheetOnCanceledListener() { // from class: com.capacitorjs.plugins.camera.LegacyCameraFlow$$ExternalSyntheticLambda1
            @Override // com.capacitorjs.plugins.camera.CameraBottomSheetDialogFragment.BottomSheetOnCanceledListener
            public final void onCanceled() {
                call.reject(LegacyCameraFlow.USER_CANCELLED);
            }
        });
        fragment.show(this.activity.getSupportFragmentManager(), "capacitorModalsActionSheet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPrompt$0(PluginCall call, int index) {
        if (index == 0) {
            this.settings.setSource(CameraSource.PHOTOS);
            openPhotos(call);
        } else if (index == 1) {
            this.settings.setSource(CameraSource.CAMERA);
            openCamera(call);
        }
    }

    private void showCamera(PluginCall call) {
        if (!this.context.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            call.reject(NO_CAMERA_ERROR);
        } else {
            openCamera(call);
        }
    }

    private void showPhotos(PluginCall call) {
        openPhotos(call);
    }

    public boolean checkCameraPermissions(PluginCall call) {
        String[] aliases;
        boolean needCameraPerms = this.permissionHelper.isPermissionDeclared(CAMERA);
        boolean hasCameraPerms = !needCameraPerms || this.permissionHelper.getPermissionState(CAMERA) == PermissionState.GRANTED;
        boolean hasGalleryPerms = this.permissionHelper.getPermissionState(SAVE_GALLERY) == PermissionState.GRANTED;
        if (Build.VERSION.SDK_INT >= 29) {
            if (hasCameraPerms) {
                return true;
            }
            this.permissionHelper.requestPermissionForAlias(CAMERA, call, "cameraPermissionsCallback");
            return false;
        }
        if (this.settings.getSaveToGallery() && ((!hasCameraPerms || !hasGalleryPerms) && this.isFirstRequest)) {
            this.isFirstRequest = false;
            if (needCameraPerms) {
                aliases = new String[]{CAMERA, SAVE_GALLERY};
            } else {
                aliases = new String[]{SAVE_GALLERY};
            }
            this.permissionHelper.requestPermissionForAliases(aliases, call, "cameraPermissionsCallback");
            return false;
        }
        if (hasCameraPerms) {
            return true;
        }
        this.permissionHelper.requestPermissionForAlias(CAMERA, call, "cameraPermissionsCallback");
        return false;
    }

    public void handleCameraPermissionsCallback(PluginCall call) {
        if (call.getMethodName().equals("pickImages")) {
            openPhotos(call, true);
        } else if (this.settings.getSource() == CameraSource.CAMERA && this.permissionHelper.getPermissionState(CAMERA) != PermissionState.GRANTED) {
            Logger.debug(LOG_TAG, "User denied camera permission: " + this.permissionHelper.getPermissionState(CAMERA));
            call.reject(PERMISSION_DENIED_ERROR_CAMERA);
        } else {
            doShow(call);
        }
    }

    private LegacyCameraSettings getSettings(PluginCall call) {
        LegacyCameraSettings settings = new LegacyCameraSettings();
        settings.setResultType(getResultType(call.getString("resultType")));
        settings.setSaveToGallery(call.getBoolean("saveToGallery", false).booleanValue());
        settings.setAllowEditing(call.getBoolean("allowEditing", false).booleanValue());
        settings.setQuality(call.getInt("quality", 90).intValue());
        settings.setWidth(call.getInt("width", 0).intValue());
        settings.setHeight(call.getInt("height", 0).intValue());
        settings.setShouldResize(settings.getWidth() > 0 || settings.getHeight() > 0);
        settings.setShouldCorrectOrientation(call.getBoolean("correctOrientation", true).booleanValue());
        try {
            settings.setSource(CameraSource.valueOf(call.getString("source", CameraSource.PROMPT.getSource())));
        } catch (IllegalArgumentException e) {
            settings.setSource(CameraSource.PROMPT);
        }
        return settings;
    }

    private CameraResultType getResultType(String resultType) {
        if (resultType == null) {
            return null;
        }
        try {
            return CameraResultType.valueOf(resultType.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            Logger.debug(LOG_TAG, "Invalid result type \"" + resultType + "\", defaulting to base64");
            return CameraResultType.BASE64;
        }
    }

    public void openCamera(PluginCall call) {
        if (checkCameraPermissions(call)) {
            Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (takePictureIntent.resolveActivity(this.context.getPackageManager()) != null) {
                try {
                    String appId = this.appId;
                    File photoFile = CameraUtils.createImageFile(this.activity);
                    this.imageFileSavePath = photoFile.getAbsolutePath();
                    this.imageFileUri = FileProvider.getUriForFile(this.activity, appId + ".fileprovider", photoFile);
                    takePictureIntent.putExtra("output", this.imageFileUri);
                    takePictureIntent.addFlags(3);
                    this.activityStarter.startActivityForResult(call, takePictureIntent, "processCameraImage");
                    return;
                } catch (Exception ex) {
                    call.reject(IMAGE_FILE_SAVE_ERROR, ex);
                    return;
                }
            }
            call.reject(NO_CAMERA_ACTIVITY_ERROR);
        }
    }

    public void openPhotos(PluginCall call) {
        openPhotos(call, false);
    }

    private <I, O> ActivityResultLauncher<I> registerActivityResultLauncher(ActivityResultContract<I, O> contract, ActivityResultCallback<O> callback) {
        String key = "cap_activity_rq#" + this.mNextLocalRequestCode.getAndIncrement();
        if (this.bridge.getFragment() != null) {
            Object host = this.bridge.getFragment().getHost();
            if (host instanceof ActivityResultRegistryOwner) {
                return ((ActivityResultRegistryOwner) host).getActivityResultRegistry().register(key, contract, callback);
            }
            return this.bridge.getFragment().requireActivity().getActivityResultRegistry().register(key, contract, callback);
        }
        return this.bridge.getActivity().getActivityResultRegistry().register(key, contract, callback);
    }

    private ActivityResultContract<PickVisualMediaRequest, List<Uri>> getContractForCall(PluginCall call) {
        int maxLimit;
        int limit = call.getInt("limit", 0).intValue();
        if (Build.VERSION.SDK_INT >= 33 && limit > (maxLimit = MediaStore.getPickImagesMaxLimit())) {
            limit = maxLimit;
        }
        if (limit > 1) {
            return new ActivityResultContracts.PickMultipleVisualMedia(limit);
        }
        return new ActivityResultContracts.PickMultipleVisualMedia();
    }

    private void openPhotos(final PluginCall call, boolean multiple) {
        try {
            if (multiple) {
                this.pickMultipleMedia = registerActivityResultLauncher(getContractForCall(call), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.LegacyCameraFlow$$ExternalSyntheticLambda2
                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        this.f$0.lambda$openPhotos$3(call, (List) obj);
                    }
                });
                this.pickMultipleMedia.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            } else {
                this.pickMedia = registerActivityResultLauncher(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: com.capacitorjs.plugins.camera.LegacyCameraFlow$$ExternalSyntheticLambda3
                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) throws IOException {
                        this.f$0.lambda$openPhotos$4(call, (Uri) obj);
                    }
                });
                this.pickMedia.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            }
        } catch (ActivityNotFoundException e) {
            call.reject(NO_PHOTO_ACTIVITY_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openPhotos$3(final PluginCall call, final List uris) {
        if (!uris.isEmpty()) {
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() { // from class: com.capacitorjs.plugins.camera.LegacyCameraFlow$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() throws JSONException, IOException {
                    this.f$0.lambda$openPhotos$2(uris, call);
                }
            });
        } else {
            call.reject(USER_CANCELLED);
        }
        this.pickMultipleMedia.unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openPhotos$2(List uris, PluginCall call) throws JSONException, IOException {
        JSObject processResult;
        JSObject ret = new JSObject();
        JSArray photos = new JSArray();
        Iterator it = uris.iterator();
        while (it.hasNext()) {
            Uri imageUri = (Uri) it.next();
            try {
                processResult = processPickedImages(imageUri);
            } catch (SecurityException e) {
                call.reject("SecurityException");
            }
            if (processResult.getString("error") != null && !processResult.getString("error").isEmpty()) {
                call.reject(processResult.getString("error"));
                return;
            }
            photos.put(processResult);
        }
        ret.put("photos", (Object) photos);
        call.resolve(ret);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openPhotos$4(PluginCall call, Uri uri) throws IOException {
        if (uri != null) {
            this.imagePickedContentUri = uri;
            processPickedImage(uri, call);
        } else {
            call.reject(USER_CANCELLED);
        }
        this.pickMedia.unregister();
    }

    public void processCameraImage(PluginCall call, ActivityResult result) throws JSONException, IOException, NumberFormatException {
        this.settings = getSettings(call);
        if (this.imageFileSavePath == null) {
            call.reject(IMAGE_PROCESS_NO_FILE_ERROR);
            return;
        }
        File f = new File(this.imageFileSavePath);
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Uri contentUri = Uri.fromFile(f);
        Bitmap bitmap = BitmapFactory.decodeFile(this.imageFileSavePath, bmOptions);
        if (bitmap == null) {
            call.reject(USER_CANCELLED);
        } else {
            returnResult(call, bitmap, contentUri);
        }
    }

    public void processPickedImage(PluginCall call, ActivityResult result) throws IOException {
        this.settings = getSettings(call);
        Intent data = result.getData();
        if (data == null) {
            call.reject(USER_CANCELLED);
            return;
        }
        Uri u = data.getData();
        this.imagePickedContentUri = u;
        processPickedImage(u, call);
    }

    private ArrayList<Parcelable> getLegacyParcelableArrayList(Bundle bundle, String key) {
        return bundle.getParcelableArrayList(key);
    }

    private void processPickedImage(Uri imageUri, PluginCall call) throws IOException {
        Bitmap bitmap;
        InputStream imageStream = null;
        try {
            try {
                try {
                    imageStream = this.context.getContentResolver().openInputStream(imageUri);
                    bitmap = BitmapFactory.decodeStream(imageStream);
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            imageStream.close();
                        } catch (IOException e) {
                            Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException ex) {
                call.reject("No such image found", ex);
                if (0 == 0) {
                    return;
                }
            }
        } catch (OutOfMemoryError e2) {
            call.reject("Out of memory");
            if (0 == 0) {
                return;
            }
        }
        if (bitmap == null) {
            call.reject("Unable to process bitmap");
            if (imageStream != null) {
                try {
                    imageStream.close();
                    return;
                } catch (IOException e3) {
                    Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e3);
                    return;
                }
            }
            return;
        }
        returnResult(call, bitmap, imageUri);
        if (imageStream == null) {
            return;
        }
        try {
            imageStream.close();
        } catch (IOException e4) {
            Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSObject processPickedImages(Uri imageUri) throws IOException {
        InputStream imageStream = null;
        JSObject ret = new JSObject();
        try {
            try {
                InputStream imageStream2 = this.context.getContentResolver().openInputStream(imageUri);
                Bitmap bitmap = BitmapFactory.decodeStream(imageStream2);
                if (bitmap == null) {
                    ret.put("error", "Unable to process bitmap");
                    if (imageStream2 != null) {
                        try {
                            imageStream2.close();
                        } catch (IOException e) {
                            Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e);
                        }
                    }
                    return ret;
                }
                ExifWrapper exif = ImageUtils.getExifData(this.context, bitmap, imageUri);
                try {
                    Bitmap bitmap2 = prepareBitmap(bitmap, imageUri, exif);
                    ByteArrayOutputStream bitmapOutputStream = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, this.settings.getQuality(), bitmapOutputStream);
                    Uri newUri = getTempImage(imageUri, bitmapOutputStream);
                    exif.copyExif(newUri.getPath());
                    if (newUri != null) {
                        ret.put("format", "jpeg");
                        ret.put("exif", (Object) exif.toJson());
                        ret.put("path", newUri.toString());
                        ret.put("webPath", FileUtils.getPortablePath(this.context, this.bridge.getLocalUrl(), newUri));
                    } else {
                        ret.put("error", UNABLE_TO_PROCESS_IMAGE);
                    }
                    if (imageStream2 != null) {
                        try {
                            imageStream2.close();
                        } catch (IOException e2) {
                            Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e2);
                        }
                    }
                    return ret;
                } catch (IOException e3) {
                    ret.put("error", UNABLE_TO_PROCESS_IMAGE);
                    if (imageStream2 != null) {
                        try {
                            imageStream2.close();
                        } catch (IOException e4) {
                            Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e4);
                        }
                    }
                    return ret;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        imageStream.close();
                    } catch (IOException e5) {
                        Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e5);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException ex) {
            ret.put("error", "No such image found");
            Logger.error(LOG_TAG, "No such image found", ex);
            if (0 != 0) {
                try {
                    imageStream.close();
                } catch (IOException e6) {
                    Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e6);
                }
            }
            return ret;
        } catch (OutOfMemoryError e7) {
            ret.put("error", "Out of memory");
            if (0 != 0) {
            }
            return ret;
        }
    }

    public void processEditedImage(PluginCall call, ActivityResult result) throws JSONException, IOException, NumberFormatException {
        this.isEdited = true;
        this.settings = getSettings(call);
        if (result.getResultCode() == 0) {
            if (this.imagePickedContentUri != null) {
                processPickedImage(this.imagePickedContentUri, call);
                return;
            } else {
                processCameraImage(call, result);
                return;
            }
        }
        processPickedImage(call, result);
    }

    private Uri saveImage(Uri uri, InputStream is) throws IOException {
        File outFile;
        if (uri.getScheme().equals("content")) {
            outFile = getTempFile(uri);
        } else {
            outFile = new File(uri.getPath());
        }
        try {
            writePhoto(outFile, is);
        } catch (FileNotFoundException e) {
            outFile = getTempFile(uri);
            writePhoto(outFile, is);
        }
        return Uri.fromFile(outFile);
    }

    private void writePhoto(File outFile, InputStream is) throws IOException {
        FileOutputStream fos = new FileOutputStream(outFile);
        byte[] buffer = new byte[1024];
        while (true) {
            int len = is.read(buffer);
            if (len != -1) {
                fos.write(buffer, 0, len);
            } else {
                fos.close();
                return;
            }
        }
    }

    private File getTempFile(Uri uri) {
        String filename = Uri.parse(Uri.decode(uri.toString())).getLastPathSegment();
        if (!filename.contains(".jpg") && !filename.contains(".jpeg")) {
            filename = filename + "." + new Date().getTime() + ".jpeg";
        }
        File cacheDir = this.context.getCacheDir();
        return new File(cacheDir, filename);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void returnResult(PluginCall call, Bitmap bitmap, Uri u) throws JSONException, IOException, NumberFormatException {
        String fileToSavePath;
        File fileToSave;
        ExifWrapper exif = ImageUtils.getExifData(this.context, bitmap, u);
        try {
            Bitmap bitmap2 = prepareBitmap(bitmap, u, exif);
            ByteArrayOutputStream bitmapOutputStream = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.JPEG, this.settings.getQuality(), bitmapOutputStream);
            if (this.settings.getAllowEditing() && !this.isEdited) {
                editImage(call, u, bitmapOutputStream);
                return;
            }
            boolean z = false;
            boolean saveToGallery = call.getBoolean("saveToGallery", false).booleanValue();
            if (saveToGallery && (this.imageEditedFileSavePath != null || this.imageFileSavePath != null)) {
                this.isSaved = true;
                try {
                    try {
                        if (this.imageEditedFileSavePath != null) {
                            try {
                                fileToSavePath = this.imageEditedFileSavePath;
                            } catch (FileNotFoundException e) {
                                e = e;
                                this.isSaved = z;
                                Logger.error(LOG_TAG, IMAGE_GALLERY_SAVE_ERROR, e);
                                if (this.settings.getResultType() != CameraResultType.BASE64) {
                                }
                                if (this.settings.getResultType() != CameraResultType.URI) {
                                }
                                this.imageFileSavePath = null;
                                this.imageFileUri = null;
                                this.imagePickedContentUri = null;
                                this.imageEditedFileSavePath = null;
                            } catch (IOException e2) {
                                e = e2;
                                this.isSaved = false;
                                Logger.error(LOG_TAG, IMAGE_GALLERY_SAVE_ERROR, e);
                                if (this.settings.getResultType() != CameraResultType.BASE64) {
                                }
                                if (this.settings.getResultType() != CameraResultType.URI) {
                                }
                                this.imageFileSavePath = null;
                                this.imageFileUri = null;
                                this.imagePickedContentUri = null;
                                this.imageEditedFileSavePath = null;
                            }
                        } else {
                            try {
                                fileToSavePath = this.imageFileSavePath;
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                z = false;
                                this.isSaved = z;
                                Logger.error(LOG_TAG, IMAGE_GALLERY_SAVE_ERROR, e);
                                if (this.settings.getResultType() != CameraResultType.BASE64) {
                                }
                                if (this.settings.getResultType() != CameraResultType.URI) {
                                }
                                this.imageFileSavePath = null;
                                this.imageFileUri = null;
                                this.imagePickedContentUri = null;
                                this.imageEditedFileSavePath = null;
                            }
                        }
                        fileToSave = new File(fileToSavePath);
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 29) {
                        ContentResolver resolver = this.context.getContentResolver();
                        ContentValues values = new ContentValues();
                        values.put("_display_name", fileToSave.getName());
                        values.put("mime_type", "image/jpeg");
                        values.put("relative_path", Environment.DIRECTORY_DCIM);
                        Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        Uri uri = resolver.insert(contentUri, values);
                        if (uri == null) {
                            throw new IOException("Failed to create new MediaStore record.");
                        }
                        OutputStream stream = resolver.openOutputStream(uri);
                        if (stream == null) {
                            throw new IOException("Failed to open output stream.");
                        }
                        Boolean inserted = Boolean.valueOf(bitmap2.compress(Bitmap.CompressFormat.JPEG, this.settings.getQuality(), stream));
                        if (!inserted.booleanValue()) {
                            this.isSaved = false;
                        }
                    } else {
                        String inserted2 = MediaStore.Images.Media.insertImage(this.context.getContentResolver(), fileToSavePath, fileToSave.getName(), "");
                        if (inserted2 == null) {
                            this.isSaved = false;
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    z = false;
                    this.isSaved = z;
                    Logger.error(LOG_TAG, IMAGE_GALLERY_SAVE_ERROR, e);
                    if (this.settings.getResultType() != CameraResultType.BASE64) {
                    }
                    if (this.settings.getResultType() != CameraResultType.URI) {
                    }
                    this.imageFileSavePath = null;
                    this.imageFileUri = null;
                    this.imagePickedContentUri = null;
                    this.imageEditedFileSavePath = null;
                } catch (IOException e7) {
                    e = e7;
                    this.isSaved = false;
                    Logger.error(LOG_TAG, IMAGE_GALLERY_SAVE_ERROR, e);
                    if (this.settings.getResultType() != CameraResultType.BASE64) {
                    }
                    if (this.settings.getResultType() != CameraResultType.URI) {
                    }
                    this.imageFileSavePath = null;
                    this.imageFileUri = null;
                    this.imagePickedContentUri = null;
                    this.imageEditedFileSavePath = null;
                }
            }
            if (this.settings.getResultType() != CameraResultType.BASE64) {
                returnBase64(call, exif, bitmapOutputStream);
            } else if (this.settings.getResultType() == CameraResultType.URI) {
                returnFileURI(call, exif, bitmap2, u, bitmapOutputStream);
            } else if (this.settings.getResultType() == CameraResultType.DATAURL) {
                returnDataUrl(call, exif, bitmapOutputStream);
            } else {
                call.reject(INVALID_RESULT_TYPE_ERROR);
            }
            if (this.settings.getResultType() != CameraResultType.URI) {
                deleteImageFile();
            }
            this.imageFileSavePath = null;
            this.imageFileUri = null;
            this.imagePickedContentUri = null;
            this.imageEditedFileSavePath = null;
        } catch (IOException e8) {
            call.reject(UNABLE_TO_PROCESS_IMAGE);
        }
    }

    private void deleteImageFile() {
        if (this.imageFileSavePath != null && !this.settings.getSaveToGallery()) {
            File photoFile = new File(this.imageFileSavePath);
            if (photoFile.exists()) {
                photoFile.delete();
            }
        }
    }

    private void returnFileURI(PluginCall call, ExifWrapper exif, Bitmap bitmap, Uri u, ByteArrayOutputStream bitmapOutputStream) throws JSONException, IOException {
        Uri newUri = getTempImage(u, bitmapOutputStream);
        exif.copyExif(newUri.getPath());
        if (newUri != null) {
            JSObject ret = new JSObject();
            ret.put("format", "jpeg");
            ret.put("exif", (Object) exif.toJson());
            ret.put("path", newUri.toString());
            ret.put("webPath", FileUtils.getPortablePath(this.context, this.bridge.getLocalUrl(), newUri));
            ret.put("saved", this.isSaved);
            call.resolve(ret);
            return;
        }
        call.reject(UNABLE_TO_PROCESS_IMAGE);
    }

    private Uri getTempImage(Uri u, ByteArrayOutputStream bitmapOutputStream) throws IOException {
        ByteArrayInputStream bis = null;
        Uri newUri = null;
        try {
            bis = new ByteArrayInputStream(bitmapOutputStream.toByteArray());
            newUri = saveImage(u, bis);
        } catch (IOException e) {
            if (bis != null) {
            }
        } catch (Throwable th) {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e2) {
                    Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e2);
                }
            }
            throw th;
        }
        try {
            bis.close();
        } catch (IOException e3) {
            Logger.error(LOG_TAG, UNABLE_TO_PROCESS_IMAGE, e3);
        }
        return newUri;
    }

    private Bitmap prepareBitmap(Bitmap bitmap, Uri imageUri, ExifWrapper exif) throws IOException, NumberFormatException {
        if (this.settings.getShouldCorrectOrientation()) {
            Bitmap newBitmap = ImageUtils.correctOrientation(this.context, bitmap, imageUri, exif);
            bitmap = replaceBitmap(bitmap, newBitmap);
        }
        if (this.settings.getShouldResize()) {
            Bitmap newBitmap2 = ImageUtils.resize(bitmap, this.settings.getWidth(), this.settings.getHeight());
            return replaceBitmap(bitmap, newBitmap2);
        }
        return bitmap;
    }

    private Bitmap replaceBitmap(Bitmap bitmap, Bitmap newBitmap) {
        if (bitmap != newBitmap) {
            bitmap.recycle();
        }
        return newBitmap;
    }

    private void returnDataUrl(PluginCall call, ExifWrapper exif, ByteArrayOutputStream bitmapOutputStream) throws JSONException {
        byte[] byteArray = bitmapOutputStream.toByteArray();
        String encoded = Base64.encodeToString(byteArray, 2);
        JSObject data = new JSObject();
        data.put("format", "jpeg");
        data.put("dataUrl", "data:image/jpeg;base64," + encoded);
        data.put("exif", (Object) exif.toJson());
        call.resolve(data);
    }

    private void returnBase64(PluginCall call, ExifWrapper exif, ByteArrayOutputStream bitmapOutputStream) throws JSONException {
        byte[] byteArray = bitmapOutputStream.toByteArray();
        String encoded = Base64.encodeToString(byteArray, 2);
        JSObject data = new JSObject();
        data.put("format", "jpeg");
        data.put("base64String", encoded);
        data.put("exif", (Object) exif.toJson());
        call.resolve(data);
    }

    private void editImage(PluginCall call, Uri uri, ByteArrayOutputStream bitmapOutputStream) {
        try {
            Uri tempImage = getTempImage(uri, bitmapOutputStream);
            Intent editIntent = createEditIntent(tempImage);
            if (editIntent != null) {
                this.activityStarter.startActivityForResult(call, editIntent, "processEditedImage");
            } else {
                call.reject(IMAGE_EDIT_ERROR);
            }
        } catch (Exception ex) {
            call.reject(IMAGE_EDIT_ERROR, ex);
        }
    }

    private Intent createEditIntent(Uri origPhotoUri) {
        List<ResolveInfo> resInfoList;
        try {
            File editFile = new File(origPhotoUri.getPath());
            Uri editUri = FileProvider.getUriForFile(this.activity, this.context.getPackageName() + ".fileprovider", editFile);
            Intent editIntent = new Intent("android.intent.action.EDIT");
            editIntent.setDataAndType(editUri, "image/*");
            this.imageEditedFileSavePath = editFile.getAbsolutePath();
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

    private List<ResolveInfo> legacyQueryIntentActivities(Intent intent) {
        return this.context.getPackageManager().queryIntentActivities(intent, 65536);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("cameraImageFileSavePath", this.imageFileSavePath);
        }
    }

    public void onRestoreState(Bundle state) {
        String storedImageFileSavePath = state.getString("cameraImageFileSavePath");
        if (storedImageFileSavePath != null) {
            this.imageFileSavePath = storedImageFileSavePath;
        }
    }

    public void onDestroy() {
        if (this.pickMedia != null) {
            this.pickMedia.unregister();
        }
        if (this.pickMultipleMedia != null) {
            this.pickMultipleMedia.unregister();
        }
    }
}
