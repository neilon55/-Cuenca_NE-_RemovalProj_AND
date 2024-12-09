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

class EditItemFragment : Fragment() {
    private val itemViewModel: ItemViewModel by activityViewModels()

    companion object {
        private const val ARG_ITEM_ID = "item_id"
        private const val ARG_ITEM_NAME = "item_name"

        fun newInstance(itemId: Int, itemName: String) = EditItemFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ITEM_ID, itemId)
                putString(ARG_ITEM_NAME, itemName)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_item, container, false)
        val nameInput: EditText = view.findViewById(R.id.name_input)
        val updateButton: Button = view.findViewById(R.id.update_button)

        val itemId = arguments?.getInt(ARG_ITEM_ID) ?: return view
        val itemName = arguments?.getString(ARG_ITEM_NAME) ?: return view

        nameInput.setText(itemName)

        updateButton.setOnClickListener {
            val newName = nameInput.text.toString()
            if (newName.isNotBlank()) {
                itemViewModel.updateItem(itemId, newName)
                parentFragmentManager.popBackStack()
            }
        }

        return view
    }
}