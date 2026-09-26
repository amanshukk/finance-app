package com.getcapacitor.plugin.util;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public interface ICapacitorHttpUrlConnection {
    InputStream getErrorStream();

    String getHeaderField(String str);

    InputStream getInputStream() throws IOException;
}
