package acosta.fernando.digimind.ui

import acosta.fernando.digimind.R
import acosta.fernando.digimind.ui.home.HomeFragment
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class TaskAdapter : BaseAdapter {
    lateinit var context: Context
    var taskList: ArrayList<Task> = ArrayList<Task>()

    constructor(context: Context, taskList: ArrayList<Task>){
        this.context = context
        this.taskList = taskList
    }



    override fun getItem(position: Int): Any {
        return taskList[position]
    }

    override fun getCount(): Int {
        return this.taskList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    fun delete(task: Task){
        val alertDialog: AlertDialog.Builder = context?.let{
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.ok_button,
                DialogInterface.OnClickListener { dialog, id ->
                        HomeFragment.taskList.remove(task)
                        HomeFragment.adapter.notifyDataSetChanged()
                        Toast.makeText(context, R.string.msg_deleted, Toast.LENGTH_SHORT).show()
                    })
                setNegativeButton(R.string.cancel_button,
                    DialogInterface.OnClickListener { dialog, id ->

                    })
            }
            builder?.setMessage(R.string.msg)
                .setTitle(R.string.title)
        }
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater: LayoutInflater = LayoutInflater.from(context)
        var taskView = inflater.inflate(R.layout.task_view, null)
        var task = taskList[p0]

        val tv_title: TextView = taskView.findViewById(R.id.tv_title)
        val tv_time: TextView = taskView.findViewById(R.id.tv_time)
        val tv_days: TextView = taskView.findViewById(R.id.tv_days)

        tv_title.text = task.title
        tv_time.text = task.time
        tv_days.text = task.day

        taskView.setOnClickListener {
            delete(task)
        }


        return taskView
    }
}
