package com.example.androidcapstone.viewmodel

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.feedbackmessage.FeedbackMessage
import com.example.androidcapstone.view.activities.HomeActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_feedback.*
import java.util.*

class FeedbackViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance()
    private val reference = database.reference
    val feedbackEmail : MutableLiveData<String> = MutableLiveData()
    val feedbackBody : MutableLiveData<String> = MutableLiveData()
    val statusMessage : MutableLiveData<String> = MutableLiveData()

    init{
        feedbackEmail.value = ""
        feedbackBody.value = ""
        statusMessage.postValue("Thank you for giving us feedback!\n")
    }

    fun onSendFeedback(view : View){

        when {
            feedbackEmail.value!!.isEmpty() -> {
                statusMessage.postValue("Please enter an email")
                (view.context as HomeActivity).tvStatusMessage.setTextColor(Color.RED)
            }
            feedbackBody.value!!.isEmpty() -> {
                statusMessage.postValue("Please enter some feedback")
                (view.context as HomeActivity).tvStatusMessage.setTextColor(Color.RED)
            }
            else -> {
                val feedback = FeedbackMessage(feedbackEmail.value, feedbackBody.value)
                val currentTime = Calendar.getInstance().time.toString()
                reference.child(currentTime).setValue(feedback)
                feedbackEmail.postValue("")
                feedbackBody.postValue("")
                statusMessage.postValue("Feedback sent!")
                (view.context as HomeActivity).tvStatusMessage.setTextColor(Color.GREEN)
            }
        }


    }

}