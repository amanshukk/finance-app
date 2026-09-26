package com.capacitorjs.plugins.localnotifications;

import com.getcapacitor.JSObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class LocalNotificationAttachment {
    private String id;
    private JSONObject options;
    private String url;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getOptions() {
        return this.options;
    }

    public void setOptions(JSONObject options) {
        this.options = options;
    }

    public static List<LocalNotificationAttachment> getAttachments(JSObject notification) throws JSONException {
        List<LocalNotificationAttachment> attachmentsList = new ArrayList<>();
        JSONArray attachments = null;
        try {
            attachments = notification.getJSONArray("attachments");
        } catch (Exception e) {
        }
        if (attachments != null) {
            for (int i = 0; i < attachments.length(); i++) {
                LocalNotificationAttachment newAttachment = new LocalNotificationAttachment();
                JSONObject jsonObject = null;
                try {
                    jsonObject = attachments.getJSONObject(i);
                } catch (JSONException e2) {
                }
                if (jsonObject != null) {
                    JSObject jsObject = null;
                    try {
                        jsObject = JSObject.fromJSONObject(jsonObject);
                    } catch (JSONException e3) {
                    }
                    newAttachment.setId(jsObject.getString("id"));
                    newAttachment.setUrl(jsObject.getString("url"));
                    try {
                        newAttachment.setOptions(jsObject.getJSONObject("options"));
                    } catch (JSONException e4) {
                    }
                    attachmentsList.add(newAttachment);
                }
            }
        }
        return attachmentsList;
    }
}
