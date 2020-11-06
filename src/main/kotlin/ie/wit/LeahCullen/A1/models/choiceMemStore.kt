package ie.wit.LeahCullen.A1.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }
var lastIdChoice = 0L

internal fun getIdChoice(): Long{
    return lastIdChoice++
}

class choiceMemStore: choiceStore {
    val choices = ArrayList<choiceModel>()

    override fun findAll(): List<choiceModel>{
        return choices
    }

    override fun findOne(id: Long): choiceModel?{
        var foundChoice: choiceModel? = choices.find { p -> p.id == id }
        return foundChoice
    }

    /*
    a new choice is assigned a new id. the new id is the last id in the choice list +1
     */
    override fun create(choice: choiceModel){
        choice.id = getIdChoice()
        choices.add(choice)
        logAll()
    }

    /*
    update old data with updated data
     */
    override fun update(choice: choiceModel){
        var foundChoice = findOne(choice.id!!)
        if(foundChoice != null){
            foundChoice.hero = choice.hero
            foundChoice.beast = choice.beast
            foundChoice.paragon1 = choice.paragon1
            foundChoice.paragon2 = choice.paragon2
            foundChoice.mages = choice.mages
            foundChoice.ruler = choice.ruler
            foundChoice.urn = choice.urn
            foundChoice.arl = choice.arl
            foundChoice.archdemon = choice.archdemon
        }
    }

    /*
    log all choices to console
     */
    internal fun logAll(){
        choices.forEach { logger.info("${it}") }
    }
}