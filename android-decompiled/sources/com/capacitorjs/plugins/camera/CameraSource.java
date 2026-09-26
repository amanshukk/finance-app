package com.capacitorjs.plugins.camera;

/* loaded from: classes2.dex */
public enum CameraSource {
    PROMPT("PROMPT"),
    CAMERA("CAMERA"),
    PHOTOS("PHOTOS");

    private String source;

    CameraSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }
}
