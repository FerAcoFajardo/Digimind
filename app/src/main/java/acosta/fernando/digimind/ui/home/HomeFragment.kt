package acosta.fernando.digimind.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import acosta.fernando.digimind.databinding.FragmentHomeBinding
import acosta.fernando.digimind.ui.Task
import acosta.fernando.digimind.ui.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    companion object {
        var taskList: ArrayList<Task> = ArrayList<Task>()
        var first = true
        lateinit var adapter: TaskAdapter
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Get the view using the binding.
        val gridView = binding.gridview

        if(first){
            fillTasks()
            first = false
        }


        adapter = TaskAdapter(root.context, taskList)

        gridView.adapter = adapter

        return root
    }

    private fun fillTasks(){
        taskList.add(Task("Task 1", "Monday", "10:00"))
        taskList.add(Task("Task 2", "Monday", "10:00"))
        taskList.add(Task("Task 3", "Monday", "10:00"))
        taskList.add(Task("Task 4", "Monday", "10:00"))
        taskList.add(Task("Task 5", "Monday", "10:00"))
        taskList.add(Task("Task 6", "Monday", "10:00"))
        taskList.add(Task("Task 7", "Monday", "10:00"))
        taskList.add(Task("Task 8", "Monday", "10:00"))
        taskList.add(Task("Task 9", "Monday", "10:00"))


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}