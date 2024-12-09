package com.example.eldroidandelphpremoval.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.eldroidandelphpremoval.R
import com.example.eldroidandelphpremoval.viewmodel.ItemViewModel

class AddItemFragment : Fragment() {
    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_item, container, false)
        val nameInput: EditText = view.findViewById(R.id.name_input)
        val addButton: Button = view.findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            if (name.isNotBlank()) {
                itemViewModel.addItem(name)
                parentFragmentManager.popBackStack()
            }
        }

        return view
    }
}