package com.example.android.devbyteviewer;

import java.lang.System;

/**
 * Override application to setup background work via WorkManager
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/android/devbyteviewer/DevByteApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "delayedInit", "", "onCreate", "setupRecurringWork", "Companion", "app_debug"})
public final class DevByteApplication extends android.app.Application {
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.android.devbyteviewer.DevByteApplication.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_NAME = "com.example.android.devbyteviewer.work.RefreshDataWorker";
    
    public DevByteApplication() {
        super();
    }
    
    /**
     * onCreate is called before the first screen is shown to the user.
     *
     * Use it to setup any background tasks, running expensive setup operations in a background
     * thread to avoid delaying app start.
     */
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * Setup WorkManager background job to 'fetch' new network data daily.
     */
    private final void setupRecurringWork() {
    }
    
    private final void delayedInit() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/android/devbyteviewer/DevByteApplication$Companion;", "", "()V", "WORK_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}