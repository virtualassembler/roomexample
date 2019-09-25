package com.david.roomexample

import android.content.Context
import com.david.roomexample.model.ApiMovie

/**
 * DataSource provides all data related to items
 *
 * @author david.mazo
 */

class RawData {

    fun getItemsList(context: Context): ArrayList<ApiMovie> {
        val items = ArrayList<ApiMovie>()
        items.add(ApiMovie("429617", "Pelicula", "352.048","3791","false","/lcq8dVxeeOqHvvgcte707K0KVx5.jpg","false","/6ihyJWRLEngSnlW8HKeDOH3AfSQ.jpg","en","Spider-Man original title","Spider-Man","7.7","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","2019-07-02" ))
        items.add(ApiMovie("429618", "Pelicula", "352.048","3791","false","/lcq8dVxeeOqHvvgcte707K0KVx5.jpg","false","/6ihyJWRLEngSnlW8HKeDOH3AfSQ.jpg","en","Spider-Man original title","Spider-Man","7.7","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","2019-07-02" ))
        items.add(ApiMovie("429619", "Pelicula", "352.048","3791","false","/lcq8dVxeeOqHvvgcte707K0KVx5.jpg","false","/6ihyJWRLEngSnlW8HKeDOH3AfSQ.jpg","en","Spider-Man original title","Spider-Man","7.7","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","2019-07-02" ))
        items.add(ApiMovie("429620", "Pelicula", "352.048","3791","false","/lcq8dVxeeOqHvvgcte707K0KVx5.jpg","false","/6ihyJWRLEngSnlW8HKeDOH3AfSQ.jpg","en","Spider-Man original title","Spider-Man","7.7","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","2019-07-02" ))
        items.add(ApiMovie("429621", "Pelicula", "352.048","3791","false","/lcq8dVxeeOqHvvgcte707K0KVx5.jpg","false","/6ihyJWRLEngSnlW8HKeDOH3AfSQ.jpg","en","Spider-Man original title","Spider-Man","7.7","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","2019-07-02" ))
        return items
    }
}
