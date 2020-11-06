package ie.wit.LeahCullen.A1.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }
var lastIdPlaythrough = 0L

internal fun getIdPlaythrough(): Long{
    return lastIdPlaythrough++
}

class MemStore: playthroughStore {
    val playthroughs = ArrayList<playthroughModel>()

    override fun findAll(): List<playthroughModel>{
        return playthroughs
    }

    override fun findOne(id: Long): playthroughModel?{
        var foundPlaythrough: playthroughModel? = playthroughs.find { p -> p.id == id }
        return foundPlaythrough
    }

    override fun create(playthrough: playthroughModel){
        playthrough.id = getIdPlaythrough()
        playthroughs.add(playthrough)
        logAll()
    }

    override fun update(playthrough: playthroughModel){
        var foundPlaythrough = findOne(playthrough.id!!)
        if(foundPlaythrough != null){
            foundPlaythrough.characters = playthrough.characters
            foundPlaythrough.relationships = playthrough.relationships
            foundPlaythrough.choices = playthrough.choices
        }
    }

    override fun delete(playthrough: playthroughModel) {
        playthroughs.remove(playthrough)
    }

    internal fun logAll(){
        playthroughs.forEach { logger.info("${it}") }
    }
}