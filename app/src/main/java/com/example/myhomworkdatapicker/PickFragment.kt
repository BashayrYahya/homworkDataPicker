
package com.example.myhomworkdatapicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.util.*


const val DATE_KEY = "Date"

class PickFragment : Fragment() ,DatePickerDialogFragment.DatePickerCallback {


    private lateinit var dateBtn: Button
    private lateinit var dateData: DateData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_pick, container, false)
        dateBtn = view.findViewById(R.id.date_btn)

        return view
    }

    override fun onDateSelected(date: Date) {
        dateData.date = date
        dateBtn.text = date.toString()

    }


    override fun onStart() {
        super.onStart()
        dateBtn.setOnClickListener {
//dateData.date = Date()
            val args = Bundle()
            args.putSerializable(DATE_KEY, dateData.date)

            val datePicker = DatePickerDialogFragment()

            datePicker.arguments = args
            datePicker.setTargetFragment(this, 0)
            datePicker.show(this.parentFragmentManager, "date picker")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dateData  =DateData ()
    }

}


