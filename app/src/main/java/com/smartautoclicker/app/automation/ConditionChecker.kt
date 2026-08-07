package com.smartautoclicker.app.automation

import android.view.accessibility.AccessibilityNodeInfo

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
                findText(root, step.value)

            ConditionType.TEXT_NOT_EXISTS ->
                !findText(root, step.value)

            ConditionType.VIEW_ID_EXISTS ->
                findViewId(root, step.value)

            ConditionType.VIEW_ID_NOT_EXISTS ->
                !findViewId(root, step.value)

            ConditionType.PACKAGE_IS ->
                root.packageName?.toString() == step.value

            ConditionType.IMAGE_FOUND ->
                false

            ConditionType.OCR_TEXT_FOUND ->
                false
        }
    }

    private fun findText(
        node: AccessibilityNodeInfo,
        text: String
    ): Boolean {

        if (node.text?.toString()?.contains(text, true) == true) {
            return true
        }

        if (node.contentDescription?.toString()?.contains(text, true) == true) {
            return true
        }

        for (i in 0 until node.childCount) {

            val child = node.getChild(i) ?: continue

            if (findText(child, text)) {
                return true
            }
        }

        return false
    }

    private fun findViewId(
        node: AccessibilityNodeInfo,
        viewId: String
    ): Boolean {

        if (node.viewIdResourceName == viewId) {
            return true
        }

        for (i in 0 until node.childCount) {

            val child = node.getChild(i) ?: continue

            if (findViewId(child, viewId)) {
                return true
            }
        }

        return false
    }
}
