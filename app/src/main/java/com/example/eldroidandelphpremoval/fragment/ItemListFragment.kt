package com.example.eldroidandelphpremoval.fragment

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.eldroidandelphpremoval.R

class ItemListFragment : Fragment() {
    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val listView: ListView = view.findViewById(R.id.list_view)

        val adapter = ArrayAdapter<String>(
            requireContext(), android.R.layout.simple_list_item_1, mutableListOf()
        )
        listView.adapter = adapter

        itemViewModel.items.observe(viewLifecycleOwner, Observer { items ->
            adapter.clear()
            adapter.addAll(items.map { it.name })
        })

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = itemViewModel.items.value?.get(position)
            if (selectedItem != null) {
                val fragment = EditItemFragment.newInstance(selectedItem.id, selectedItem.name)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            val selectedItem = itemViewModel.items.value?.get(position)
            if (selectedItem != null) {
                itemViewModel.deleteItem(selectedItem.id)
            }
            true
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AddItemFragment())
                    .addToBackStack(null)
                    .commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}