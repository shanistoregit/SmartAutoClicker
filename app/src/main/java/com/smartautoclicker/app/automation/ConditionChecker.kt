package com.smartautoclicker.app.automation

import android.view.accessibility.AccessibilityNodeInfo
import com.smartautoclicker.app.accessibility.UiInspector

object ConditionChecker {

    fun check(
        root: AccessibilityNodeInfo?,
        step: WorkflowStep
    ): Boolean {

        if (root == null) {
            return false
        }

        return when (step.condition) {

            ConditionType.NONE -> true

            ConditionType.TEXT_EXISTS ->
                UiInspector.findByText(root, step.value) != null

            ConditionType.TEXT_NOT_EXISTS ->
                UiInspector.findByText(root, step.value) == null

            ConditionType.VIEW_ID_EXISTS ->
                UiInspector.findByViewId(root, step.value) != null

            ConditionType.VIEW_ID_NOT_EXISTS ->
                UiInspector.findByViewId(root, step.value) == null

            ConditionType.PACKAGE_IS ->
                root.packageName?.toString() == step.value

            ConditionType.IMAGE_FOUND ->
                false

            ConditionType.OCR_TEXT_FOUND ->
                false
        }
    }
}
