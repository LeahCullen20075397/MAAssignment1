package ie.wit.LeahCullen.A1.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger{}
var lastIdChar = 0L

internal fun getIdChar(): Long{
    return lastIdChar++
}

class characterMemStore: characterStore {
    val characters = ArrayList<characterModel>()

    override fun findAll(): List<characterModel>{
        return characters
    }

    override fun findOne(id: Long): characterModel?{
        var foundCharacter: characterModel? = characters.find { p -> p.id == id }
        return foundCharacter
    }

    /*
    a new character is assigned a new id. the new id is the last id in the character list +1
     */
    override fun create(character: characterModel){
        character.id = getIdChar()
        characters.add(character)
        logAll()
    }

    /*
    replace old data with updated data
     */
    override fun update(character: characterModel){
        var foundCharacter = findOne(character.id!!)
        if(foundCharacter != null){
            foundCharacter.name = character.name
            foundCharacter.gender = character.gender
            foundCharacter.race = character.race
            foundCharacter.background = character.background
        }
    }

    //log each character to the console
    internal fun logAll(){
        characters.forEach { logger.info("${it}") }
    }
}