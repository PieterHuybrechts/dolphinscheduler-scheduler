package be.pieterh.dolphinschedulerscheduler

import org.springframework.stereotype.Repository

@Repository
class DolphinSchedulerTaskRepository() {

    val tasksById = mutableMapOf("128090641501184" to "Send Slack Message")

    fun save(id: String, task: String) {
        tasksById.put(id, task)
    }

    fun findAll(): Map<String,String> {
        return tasksById.toMap()
    }

}