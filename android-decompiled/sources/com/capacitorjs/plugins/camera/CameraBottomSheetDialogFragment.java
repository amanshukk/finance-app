package com.capacitorjs.plugins.camera;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraBottomSheetDialogFragment extends BottomSheetDialogFragment {
    private BottomSheetOnCanceledListener canceledListener;
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.capacitorjs.plugins.camera.CameraBottomSheetDialogFragment.1
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            if (newState == 5) {
                CameraBottomSheetDialogFragment.this.dismiss();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
        }
    };
    private List<String> options;
    private BottomSheetOnSelectedListener selectedListener;
    private String title;

    interface BottomSheetOnCanceledListener {
        void onCanceled();
    }

    interface BottomSheetOnSelectedListener {
        void onSelected(int i);
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setOptions(List<String> options, BottomSheetOnSelectedListener selectedListener, BottomSheetOnCanceledListener canceledListener) {
        this.options = options;
        this.selectedListener = selectedListener;
        this.canceledListener = canceledListener;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (this.canceledListener != null) {
            this.canceledListener.onCanceled();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        if (this.options != null && this.options.size() != 0) {
            dialog.getWindow();
            float scale = getResources().getDisplayMetrics().density;
            int layoutPaddingPx16 = (int) ((16.0f * scale) + 0.5f);
            int layoutPaddingPx12 = (int) ((12.0f * scale) + 0.5f);
            int layoutPaddingPx8 = (int) ((8.0f * scale) + 0.5f);
            CoordinatorLayout parentLayout = new CoordinatorLayout(getContext());
            LinearLayout layout = new LinearLayout(getContext());
            layout.setOrientation(1);
            layout.setPadding(layoutPaddingPx16, layoutPaddingPx16, layoutPaddingPx16, layoutPaddingPx16);
            TextView ttv = new TextView(getContext());
            ttv.setTextColor(Color.parseColor("#757575"));
            ttv.setPadding(layoutPaddingPx8, layoutPaddingPx8, layoutPaddingPx8, layoutPaddingPx8);
            ttv.setText(this.title);
            layout.addView(ttv);
            for (int i = 0; i < this.options.size(); i++) {
                final int optionIndex = i;
                TextView tv = new TextView(getContext());
                tv.setTextColor(Color.parseColor("#000000"));
                tv.setPadding(layoutPaddingPx12, layoutPaddingPx12, layoutPaddingPx12, layoutPaddingPx12);
                tv.setText(this.options.get(i));
                tv.setOnClickListener(new View.OnClickListener() { // from class: com.capacitorjs.plugins.camera.CameraBottomSheetDialogFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setupDialog$0(optionIndex, view);
                    }
                });
                layout.addView(tv);
            }
            parentLayout.addView(layout.getRootView());
            dialog.setContentView(parentLayout.getRootView());
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) parentLayout.getParent()).getLayoutParams();
            CoordinatorLayout.Behavior<View> behavior = params.getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                BottomSheetBehavior<View> bottomSheetBehavior = (BottomSheetBehavior) behavior;
                bottomSheetBehavior.addBottomSheetCallback(this.mBottomSheetBehaviorCallback);
                bottomSheetBehavior.setState(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupDialog$0(int optionIndex, View view) {
        if (this.selectedListener != null) {
            this.selectedListener.onSelected(optionIndex);
        }
        dismiss();
    }
}
