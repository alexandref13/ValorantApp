package br.com.ale.valorantapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favorite_agents")
data class FavoriteAgentEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo("agent_id")
    var agentId: String,

    @ColumnInfo("agent_name")
    var name: String,

    @ColumnInfo("agent_icon")
    var icon: String,

    @ColumnInfo("role_name")
    var roleName: String,

    @ColumnInfo("role_icon")
    var roleIcon: String,
)