package com.smartautoclicker.app.accessibility

import android.view.accessibility.AccessibilityNodeInfo

object UiInspector {

    fun findByText(
        root: AccessibilityNodeInfo?,
        text: String,
        ignoreCase: Boolean = true
    ): AccessibilityNodeInfo? {

        if (root == null) return null

        root.text?.toString()?.let {
            if (it.contains(text, ignoreCase)) {
                return root
            }
        }

        root.contentDescription?.toString()?.let {
            if (it.contains(text, ignoreCase)) {
                return root
            }
        }

        for (i in 0 until root.childCount) {
            val child = root.getChild(i) ?: continue

            val result = findByText(
                child,
                text,
                ignoreCase
            )

            if (result != null) {
                return result
            }
        }

        return null
    }

    fun findByViewId(
        root: AccessibilityNodeInfo?,
        viewId: String
    ): AccessibilityNodeInfo? {

        if (root == null) return null

        if (root.viewIdResourceName == viewId) {
            return root
        }

        for (i in 0 until root.childCount) {
            val child = root.getChild(i) ?: continue

            val result = findByViewId(
                child,
                viewId
            )

            if (result != null) {
                return result
            }
        }

        return null
    }

    fun findClickableParent(
        node: AccessibilityNodeInfo?
    ): AccessibilityNodeInfo? {

        var current = node

        while (current != null) {

            if (current.isClickable) {
                return current
            }

            current = current.parent
        }

        return null
    }

    fun flatten(
        root: AccessibilityNodeInfo?
    ): List<AccessibilityNodeInfo> {

        val result = mutableListOf<AccessibilityNodeInfo>()

        if (root == null) {
            return result
        }

        traverse(root, result)

        return result
    }

    private fun traverse(
        node: AccessibilityNodeInfo,
        output: MutableList<AccessibilityNodeInfo>
    ) {

        output.add(node)

        for (i in 0 until node.childCount) {

            val child = node.getChild(i) ?: continue

            traverse(child, output)
        }
    }
}
