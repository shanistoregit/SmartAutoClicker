package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentLinkedQueue

object ExecutionQueue {

    private val queue = ConcurrentLinkedQueue<Workflow>()

    fun enqueue(workflow: Workflow) {
        queue.offer(workflow)
    }

    fun dequeue(): Workflow? {
        return queue.poll()
    }

    fun peek(): Workflow? {
        return queue.peek()
    }

    fun clear() {
        queue.clear()
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    fun size(): Int {
        return queue.size
    }

    fun toList(): List<Workflow> {
        return queue.toList()
    }
}
