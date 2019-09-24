package com.david.roomexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Item is a simple class to hold data related to items of navigation.
 * <p>
 *
 * @author david.mazo
 */

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int =0,
    @ColumnInfo(name = "name") var name: String =""
){
    constructor():this(0,"")
}
