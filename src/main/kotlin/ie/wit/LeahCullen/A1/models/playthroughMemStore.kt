package ie.wit.LeahCullen.A1.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }
var lastIdPlaythrough = 0L

internal fun getIdPlaythrough(): Long{
    return lastIdPlaythrough++
}

class playthroughMemStore: playthroughStore {
    val playthroughs = ArrayList<playthroughModel>()

    override fun findAll(): List<playthroughModel>{
        return playthroughs
    }

    override fun findOne(id: Long): playthroughModel?{
        var foundPlaythrough: playthroughModel? = playthroughs.find { p -> p.id == id }
        return foundPlaythrough
    }

    /*
    a new playthrough is assigned a new id. the new id is the last id in the playthrough list +1
     */
    override fun create(playthrough: playthroughModel){
        playthrough.id = getIdPlaythrough()
        playthroughs.add(playthrough)
        logAll()
    }

    /*
    replace old data with updated data
     */
    override fun update(playthrough: playthroughModel){
        var foundPlaythrough = findOne(playthrough.id!!)
        if(foundPlaythrough != null){
            foundPlaythrough.characters = playthrough.characters
            foundPlaythrough.relationships = playthrough.relationships
            foundPlaythrough.choices = playthrough.choices
        }
    }

    /*
    not used but throws error if commented out
     */
    override fun delete(playthrough: playthroughModel) {
        playthroughs.remove(playthrough)
    }

    internal fun logAll(){
        playthroughs.forEach { logger.info("${it}") }
    }
    /*
    used instead of logall() cause it was easier for me to read while testing
     */
    fun listAll(){
        playthroughs.forEach { println("${it}") }
    }
}