package ie.wit.LeahCullen.A1.controllers

import ie.wit.LeahCullen.A1.main.characters
import ie.wit.LeahCullen.A1.main.search1
import ie.wit.LeahCullen.A1.models.characterModel
import ie.wit.LeahCullen.A1.views.characterView
import mu.KotlinLogging

val logger = KotlinLogging.logger {  }

class CharacterController {
    fun add(){
        var aCharacter = characterModel()

        if (characterView.addCharacterData(aCharacter))
            characters.create(aCharacter)
        else
            logger.info("Character Not Added...")
    }

    fun list(){
        characterView.listCharacters(characters)
    }

    fun update(){
        characterView.listCharacters(characters)
        var searchId = characterView.getId()
        val aCharacter = search1(searchId)

        if (aCharacter != null){
            if (characterView.updateCharacterData(aCharacter)){
                characters.update(aCharacter)
                characterView.showCharacter(aCharacter)
                logger.info("Character Updated: $aCharacter")
            }
            else
                logger.info("Character Not Updated...")
        }
        else
            println("Character Not Updated...")
    }

    fun search(){
        val aCharacter = search(characterView.getId())!!
        characterView.showCharacter(aCharacter)
    }

    fun search(id: Long): characterModel? {
        var foundCharacter = characters.findOne(id)
        return foundCharacter
    }

    fun dummyData(){
        characters.create(characterModel(1,"Leah", "Female", "Human", "Noble"))
        characters.create(characterModel(2,"Susie", "Female", "Elf", "Dalish"))
        characters.create(characterModel(3,"Ruairi", "Male", "Dwarf", "Commoner"))
    }
}