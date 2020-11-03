package ie.wit.LeahCullen.A1.main

import ie.wit.LeahCullen.A1.models.*
import ie.wit.LeahCullen.A1.views.PlaythroughView
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

val playthroughView = PlaythroughView()

val  characters = characterMemStore()
val relationships = relationshipMemStore()
val choices = choiceMemStore()

fun main(args: Array<String>){
    logger.info{"Launching Dragon Age Console App"}
    println("Dragon Age Console App")

    var input: Int

    do{
        input = playthroughView.mainMenu()
        when(input){
            1 -> createPlaythrough()
            2 -> updatePlaythrough()
            3 -> listPlaythroughs()
            4 -> playthroughView.searchMenu()
            -99 -> dummyData()
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
            1 -> playthroughView.searchCharacter()
            2 -> playthroughView.searchRelationship()
            3 -> playthroughView.searchChoice()
            0 -> println("Back to main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
}

fun createPlaythrough(){
    var input: Int

    do{
        input =
        when(input){
            1 -> playthroughView.addCharacter()
            2 -> playthroughView.editRelationships()
            3 -> playthroughView.editChoices()
            0 -> println("Back to main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
}

fun updatePlaythrough(){
    var input: Int

    do{
        input = playthroughView.updateMenu()
        when(input){
            1 -> playthroughView.updateCharacter()
            2 -> playthroughView.updateRelationships()
            3 -> playthroughView.updateChoices()
            0 -> println("Back main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
}

fun listPlaythroughs(){
    println("List All Playthroughs")
    println()
    characters.forEach{logger.info("${it}")}
    relationships.forEach { logger.info("${it}") }
    choices.forEach { logger.info("${it}") }

}

fun getId(): Long{
    var strId: String?
    var searchId: Long
    print("Enter Id to search/update: ")
    strId = readLine()!!
    searchId = if(strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun dummyData() {
    characters.add(characterModel(1,"Leah", "Female", "Human", "Noble"))
    relationships.add(
        relationshipModel(1,"Romance", "Friend", "Enemy", "Friend",
        "Friend", "Enemy", "Friend", "Friend")
    )
    choices.add(
        choiceModel(1,"No", "Brokered Peace", "Destroyed", "Bhelen",
    "Mages", "Anora", "No", "Survived, not possessed", "Warden")
    )
    characters.add(characterModel(2,"Susie", "Female", "Elf", "Dalish"))
    relationships.add(relationshipModel(2,"Friend", "Friend", "Friend", "Friend",
        "Friend", "Friend", "Friend", "Romance"))
    choices.add(choiceModel(2,"Yes", "Sided with the werewolves", "Saved", "Harrowmount",
        "Templars", "Alaistair", "Yes", "Survived, possessed", "Alaistair"))
    characters.add(characterModel(3,"Ruairi", "Male", "Dwarf", "Commoner"))
    relationships.add(relationshipModel(3,"Enemy", "Romance", "Friend", "Friend",
        "Enemy", "Enemy", "Friend", "Friend"))
    choices.add(choiceModel(3,"Yes", "Sided with the Elves", "Destroyed", "Bhelen",
        "Mages", "Anora", "Yes", "Died", "Warden"))
}