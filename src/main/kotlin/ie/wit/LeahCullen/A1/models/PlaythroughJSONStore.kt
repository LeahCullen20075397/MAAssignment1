package ie.wit.LeahCullen.A1.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import ie.wit.LeahCullen.A1.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {  }

val JSON_FILE = "playthrough.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object: TypeToken<ArrayList<playthroughModel>>() {}.type

fun generateRandomId(): Long{
    return Random().nextLong()
}

class PlaythroughJSONStore: playthroughStore {
    var playthroughs = mutableListOf<playthroughModel>()

    init {
        if (exists(JSON_FILE)){
            deserialize()
        }
    }

    override fun findAll(): MutableList<playthroughModel>{
        return playthroughs
    }

    override fun findOne(id: Long): playthroughModel? {
        var foundPlaythrough: playthroughModel? = playthroughs.find { p -> p.id == id }
        return foundPlaythrough
    }

    override fun create(playthrough: playthroughModel) {
        playthrough.id = generateRandomId()
        playthroughs.add(playthrough)
        serialize()
    }

    override fun update(playthrough: playthroughModel) {
        var foundPlaythrough = findOne(playthrough.id!!)
        if (foundPlaythrough != null){
            foundPlaythrough.characters = playthrough.characters
            foundPlaythrough.relationships = playthrough.relationships
            foundPlaythrough.choices = playthrough.choices
        }
        serialize()
    }

    internal fun logAll(){
        playthroughs.forEach { logger.info("${it}") }
    }

    private fun serialize(){
        val jsonString = gsonBuilder.toJson(playthroughs, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize(){
        val jsonString = read(JSON_FILE)
        playthroughs = Gson().fromJson(jsonString, listType)
    }
}