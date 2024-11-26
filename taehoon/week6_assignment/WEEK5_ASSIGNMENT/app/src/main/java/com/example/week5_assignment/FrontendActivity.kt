package com.example.week5_assignment
import com.example.week5_assignment.com.example.week5_assignment.TaskAdapter
import com.example.week5_assignment.com.example.week5_assignment.Task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

class FrontendActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_manager)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnAddTask = findViewById<Button>(R.id.btnAddTask)
        val btnRemoveChecked = findViewById<Button>(R.id.btnRemoveChecked)
        val etNewTask = findViewById<EditText>(R.id.etNewTask)

        taskAdapter = TaskAdapter(taskList) { task ->
            // 체크박스 변경 시 처리 (필요시 추가 로직)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        btnAddTask.setOnClickListener {
            val taskName = etNewTask.text.toString()
            if (taskName.isNotBlank()) {
                taskAdapter.addTask(Task(taskName))
                etNewTask.text.clear()
            }
        }

        btnRemoveChecked.setOnClickListener {
            taskAdapter.removeCheckedTasks()
        }
    }
}
