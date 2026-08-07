package com.smartautoclicker.app.automation

import org.json.JSONArray
import org.json.JSONObject

object WorkflowStorage {

    fun toJson(workflow: Workflow): String {

        val root = JSONObject()

        root.put("id", workflow.id)
        root.put("name", workflow.name)
        root.put("enabled", workflow.enabled)

        val steps = JSONArray()

        workflow.steps.forEach { step ->

            val item = JSONObject()

            item.put("id", step.id)
            item.put("action", step.action.name)
            item.put("condition", step.condition.name)
            item.put("value", step.value)
            item.put("timeout", step.timeout)
            item.put("retryCount", step.retryCount)
            item.put("enabled", step.enabled)

            steps.put(item)
        }

        root.put("steps", steps)

        return root.toString(4)
    }

    fun fromJson(json: String): Workflow {

        val root = JSONObject(json)

        val workflow = Workflow(
            id = root.getString("id"),
            name = root.getString("name"),
            enabled = root.optBoolean("enabled", true)
        )

        val steps = root.getJSONArray("steps")

        for (i in 0 until steps.length()) {

            val item = steps.getJSONObject(i)

            workflow.steps.add(
                WorkflowStep(
                    id = item.getString("id"),
                    action = ActionType.valueOf(
                        item.getString("action")
                    ),
                    condition = ConditionType.valueOf(
                        item.getString("condition")
                    ),
                    value = item.optString("value", ""),
                    timeout = item.optLong("timeout", 10000L),
                    retryCount = item.optInt("retryCount", 0),
                    enabled = item.optBoolean("enabled", true)
                )
            )
        }

        return workflow
    }
}
