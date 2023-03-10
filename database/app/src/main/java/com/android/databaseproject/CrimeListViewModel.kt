package com.android.databaseproject

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
private const val TAG = "CrimeListViewModel"
class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    val crimes = mutableListOf<Crime>()

    init {
        viewModelScope.launch {
            Log.d(TAG, "coroutine launched")
            delay(5000)

            for (i in 0 until 100) {
                val crime = Crime(
                    id = UUID.randomUUID(),
                    title = "Crime #$i",
                    date = Date(),
                    isSolved = i % 2 == 0
                )

                crimes += crime
            }
            Log.d(TAG, "Loading crimes finished")
        }

    }
    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }
}

