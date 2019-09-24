package com.david.roomexample.interfaces

import com.david.roomexample.model.ApiMovie

interface AdapterEvents {
    fun onItemClicked(item: ApiMovie)
}