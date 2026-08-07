# Smart Auto Clicker ProGuard Rules

# Keep accessibility service
-keep class com.smartautoclicker.app.accessibility.** { *; }

# Keep all activities
-keep class * extends android.app.Activity { *; }

# Keep all services
-keep class * extends android.accessibilityservice.AccessibilityService { *; }

# Preserve source/debug information
-keepattributes SourceFile,LineNumberTable

# Don't warn about Kotlin metadata
-dontwarn kotlin.**
