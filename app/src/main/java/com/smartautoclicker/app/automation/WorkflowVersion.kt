package com.smartautoclicker.app.automation

data class WorkflowVersion(

    val major: Int = 1,

    val minor: Int = 0,

    val patch: Int = 0

) {

    override fun toString(): String {
        return "$major.$minor.$patch"
    }

    fun nextMajor(): WorkflowVersion {
        return WorkflowVersion(major + 1, 0, 0)
    }

    fun nextMinor(): WorkflowVersion {
        return WorkflowVersion(major, minor + 1, 0)
    }

    fun nextPatch(): WorkflowVersion {
        return WorkflowVersion(major, minor, patch + 1)
    }
}
