package com.getcapacitor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.WebView;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class CapacitorWebView extends WebView {
    private Bridge bridge;
    private BaseInputConnection capInputConnection;

    public CapacitorWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) throws JSONException {
        CapConfig config;
        if (this.bridge != null) {
            config = this.bridge.getConfig();
        } else {
            config = CapConfig.loadDefault(getContext());
        }
        boolean captureInput = config.isInputCaptured();
        if (captureInput) {
            if (this.capInputConnection == null) {
                this.capInputConnection = new BaseInputConnection(this, false);
            }
            return this.capInputConnection;
        }
        return super.onCreateInputConnection(outAttrs);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == 2) {
            evaluateJavascript("document.activeElement.value = document.activeElement.value + '" + event.getCharacters() + "';", null);
            return false;
        }
        return super.dispatchKeyEvent(event);
    }
}
