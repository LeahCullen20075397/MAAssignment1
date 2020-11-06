package ie.wit.LeahCullen.A1.main

import ie.wit.LeahCullen.A1.controllers.*
import ie.wit.LeahCullen.A1.models.*
import ie.wit.LeahCullen.A1.views.*
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

val playthroughView = PlaythroughView()
val characterView = CharacterView()
val relationshipView = RelationshipView()
val choiceView = ChoiceView()


val characters = characterMemStore()
val relationships = relationshipMemStore()
val choices = choiceMemStore()
val playthroughs = playthroughMemStore()

/*val playthroughController = PlaythroughController()
val characterController = CharacterController()
val relationshipController = RelationshipController()
val choiceController = ChoiceController()*/

fun main(args: Array<String>){
    logger.info{"Launching Dragon Age Console App"}
    println("Dragon Age Console App")

    var input: Int

    do{
        input = playthroughView.mainMenu()
        when(input){
            1 -> createPlaythrough()
            2 -> updatePlaythrough()
            3 -> playthroughView.listPlaythroughs()
            4 -> searching()
            //5 -> deletePlaythrough()
            0 -> println("Exiting app...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Shutting Down Dragon Age Console App"}
}

fun searching(){
    var input: Int

    do{
        input = playthroughView.searchMenu()
        when(input){
            1 -> searchCharacter()
            2 -> searchRelationship()
            3 -> searchChoice()
            0 -> println("Back to main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
}

fun createPlaythrough(){
    var input: Int
    var playthrough = playthroughModel()

    do{
        input = playthroughView.createMenu()
        when(input){
            1 -> addCharacter(playthrough)
            2 -> editRelationships(playthrough)
            3 -> editChoices(playthrough)
            0 -> println("Back to main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
    playthroughs.create(playthrough)
}

fun updatePlaythrough(){
    var input: Int
    playthroughs.listAll()
    println("Please enter the playthrough id: ")
    val id = readLine()!!
    var playthrough = playthroughs.findOne(id.toLong())!!

    do{
        input = playthroughView.updateMenu()
        when(input){
            1 -> updateCharacter(playthrough)
            2 -> updateRelationships(playthrough)
            3 -> updateChoices(playthrough)
            0 -> println("Back main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
    playthroughs.update(playthrough)
}

/*fun deletePlaythrough(){
    var input: Int
    playthroughs.listAll()
    println("Please enter the playthrough id: ")
    val id = readLine()!!
    var playthrough = playthroughs.findOne(id.toLong())!!

    do{
        input = playthroughView.deleteMenu()
        when(input){
            1 -> deleteCharacter(playthrough)
            2 -> deleteRelationships(playthrough)
            3 -> deleteChoices(playthrough)
            0 -> println("Back to Main Menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while (input != 0)
    logger.info { "Heading back to the Main Menu" }
    playthroughs.delete(playthrough)
}*/

fun addCharacter(playthroughModel: playthroughModel) {

    var aCharacter = characterModel()

    if(characterView.addCharacterData(aCharacter))
        characters.create(aCharacter)
    else
        logger.info("Character Not Added...")
    playthroughModel.characters.add(aCharacter)
}

fun editRelationships(playthroughModel: playthroughModel){
    var aRelationship = relationshipModel()

    if(relationshipView.addRelationshipData(aRelationship))
        relationships.create(aRelationship)
    else
        logger.info("Relationship Not Added")
    playthroughModel.relationships.add(aRelationship)
}

fun editChoices(playthroughModel: playthroughModel){
    var aChoice = choiceModel()

    if(choiceView.addChoiceData(aChoice))
        choices.create(aChoice)
    else
        logger.info("Choice Not Added...")
    playthroughModel.choices.add(aChoice)
}

fun updateCharacter(playthroughModel: playthroughModel){
    characterView.listCharacters(characters)
    var searchId = characterView.getId()
    val aCharacter = search1(searchId)

    if(aCharacter != null){
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

/*fun deleteCharacter(playthroughModel: playthroughModel){
    characterView.listCharacters(characters)
    val searchId = characterView.getId()
    val aCharacter = search1(searchId)

    if(aCharacter != null){
        if(characterView.)
    }
}*/

fun updateRelationships(playthroughModel: playthroughModel){
    relationshipView.listRelationships(relationships)
    val searchId = relationshipView.getId()
    val aRelationship = search2(searchId)

    if(aRelationship != null){
        if (relationshipView.updateRelationshipData(aRelationship)){
            relationships.update(aRelationship)
            relationshipView.showRelationship(aRelationship)
            logger.info("Relationship Added: $aRelationship")
        }
        else
            logger.info("Relationship Not Added...")
    }
    else
        println("Relationship Not Added...")
}

fun updateChoices(playthroughModel: playthroughModel){
    choiceView.listChoices(choices)
    var searchId = choiceView.getId()
    val aChoice = search3(searchId)

    if(aChoice != null){
        if(choiceView.updateChoiceData(aChoice)){
            choices.update(aChoice)
            choiceView.showChoice(aChoice)
            logger.info("Choice Updated: $aChoice")
        }
        else
            logger.info("Choice Not Updated...")
    }
    else
        println("Choice Not Updated...")
}

fun search1(id: Long): characterModel?{
    var foundCharacter = characters.findOne(id)
    return foundCharacter
}

fun searchCharacter(){
    val aCharacter = search1(characterView.getId())!!
    characterView.showCharacter(aCharacter)
}

fun search2(id: Long): relationshipModel?{
    var foundRelationship = relationships.findOne(id)
    return foundRelationship
}

fun searchRelationship(){
    val aRelationship = search2(relationshipView.getId())!!
    relationshipView.showRelationship(aRelationship)
}

fun search3(id: Long): choiceModel?{
    var foundChoice = choices.findOne(id)
    return foundChoice
}

fun searchChoice(){
    val aChoice = search3(choiceView.getId())!!
    choiceView.showChoice(aChoice)
}
