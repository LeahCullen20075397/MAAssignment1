package ie.wit.LeahCullen.A1.main

import ie.wit.LeahCullen.A1.models.characterModel
import ie.wit.LeahCullen.A1.models.choiceModel
import ie.wit.LeahCullen.A1.models.relationshipModel
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

var characters = characterModel()
var relationships = relationshipModel()
var choices = choiceModel()

fun main(args: Array<String>){
    logger.info{"Launching Dragon Age Console App"}
    println("Dragon Age Console App")

    var input: Int

    do{
        input = mainMenu()
        when(input){
            1 -> createPlaythrough()
            2 -> updatePlaythrough()
            3 -> listPlaythroughs()
            0 -> println("Exiting app...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Shutting Down Dragon Age Console App"}
}

fun mainMenu(): Int{
    var option: Int
    var input: String? = null

    println("Main Menu")
    println("1.         Create New Playthrough")
    println("2.         Update a Playthough")
    println("3.         List All Playthroughs")
    println("0.         Exit")
    println()
    println("Please enter a number: ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun createPlaythrough(){
    var input: Int

    do{
        input = createMenu()
        when(input){
            1 -> addCharacter()
            2 -> editRelationships()
            3 -> editChoices()
            0 -> println("Back to main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
}

fun createMenu(): Int {
    var option: Int
    var input: String? = null

    println("Playthrough Creation")
    println("1.         Create New A Character")
    println("2.         Edit Relationships")
    println("3.         Edit Choices")
    println("0.         Main Menu")
    println()
    println("Please enter a number: ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addCharacter(){

    println("Add Your Character")
    println()
    println("Enter character name: ")
    characters.name = readLine()!!
    println("Enter character gender: ")
    characters.gender = readLine()!!
    println("Enter character race: ")
    characters.race = readLine()!!
    println("Enter character background: ")
    characters.background = readLine()!!
    println("Your character's name is " + characters.name + ". They are "+ characters.gender + " and from the " + characters.race +
            " race. Their background is: " + characters.background + ".")
}

fun editRelationships(){

    println("Whats your character's relationship to these companions?")
    println()
    println("Alistair: ")
    relationships.rAlaistair = readLine()!!
    println("Leliana: ")
    relationships.rLeliana = readLine()!!
    println("Morrigan: ")
    relationships.rMorrigan = readLine()!!
    println("Oghren: ")
    relationships.rOghren = readLine()!!
    println("Shale: ")
    relationships.rShale = readLine()!!
    println("Sten: ")
    relationships.rSten = readLine()!!
    println("Wynne: ")
    relationships.rWynne = readLine()!!
    println("Zevran: ")
    relationships.rZevran = readLine()!!
    println("Here are your current relationships: ")
    println("Alistair: " + relationships.rAlaistair +"\nLeliana: " + relationships.rLeliana +"\nMorrigan: " + relationships.rMorrigan +
            "\nOghren: " + relationships.rOghren + "\nShale: " + relationships.rShale + "\nSten: " + relationships.rSten +
            "\nWynne: " + relationships.rWynne + "\nZevran: " + relationships.rZevran + ".")
}

fun editChoices(){

    println("What choices will you make?")
    println()
    println("THE BLIGHT")
    println("Did you die to end the Blight?(yes/no) ")
    choices.hero = readLine()!!
    println("THE NATURE OF THE BEAST")
    println("How did you resolve the problems between the werewolves and the elves? ")
    choices.beast = readLine()!!
    println("PARAGON OF HER KIND")
    println("What happened to the Anvil of the Void? ")
    choices.paragon1 = readLine()!!
    println("Who rules in Orzammar? ")
    choices.paragon2 = readLine()!!
    println("BROKEN CIRCLE")
    println("Who did you support at the Broken Circle? ")
    choices.mages = readLine()!!
    println("THE LANDSMEET")
    println("Who now rules Ferelden? ")
    choices.ruler = readLine()!!
    println("THE URN OF SACRED ASHES")
    println("Did you poison the Urn? ")
    choices.urn = readLine()!!
    println("THE ARL OF REDCLIFFE")
    println("What happened to Connor? ")
    choices.arl = readLine()!!
    println("THE BATTLE OF DENERIM")
    println("Who killed the Archdemon? ")
    choices.archdemon = readLine()!!
}

fun updatePlaythrough(){
    var input: Int

    do{
        input = updateMenu()
        when(input){
            1 -> updateCharacter()
            2 -> updateRelationships()
            3 -> updateChoices()
            0 -> println("Back main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
}

fun updateMenu(): Int{
    var option: Int
    var input: String? = null

    println("Update Playthrough")
    println("1.         Update Character")
    println("2.         Update Relationships")
    println("3.         Update Choices")
    println("0.         Main Menu")
    println()
    println("Please enter a number: ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun updateCharacter(){
    println("Update Character")
    println()

    println("Enter a new character name for " + characters.name + ": ")
    characters.name = readLine()!!
    println("Enter a new character gender for " + characters.gender + ": ")
    characters.gender = readLine()!!
    println("Enter a new character race for " + characters.race +": ")
    characters.race = readLine()!!
    println("Enter a new character background for " + characters.background + ": ")
    characters.background = readLine()!!
    println("Your character's name is now " + characters.name + ". They are now " +
            characters.gender + " and from the " + characters.race +
            " race. Their background is now: " + characters.background + ".")
}

fun updateRelationships(){
    println("Update relationships")
    println()

    println("Alistair: ")
    relationships.rAlaistair = readLine()!!
    println("Leliana: ")
    relationships.rLeliana = readLine()!!
    println("Morrigan: ")
    relationships.rMorrigan = readLine()!!
    println("Oghren: ")
    relationships.rOghren = readLine()!!
    println("Shale: ")
    relationships.rShale = readLine()!!
    println("Sten: ")
    relationships.rSten = readLine()!!
    println("Wynne: ")
    relationships.rWynne = readLine()!!
    println("Zevran: ")
    relationships.rZevran = readLine()!!
    println("Here are your updated relationships: ")
    println("Alistair: " + relationships.rAlaistair +"\nLeliana: " + relationships.rLeliana +"\nMorrigan: " + relationships.rMorrigan +
            "\nOghren: " + relationships.rOghren + "\nShale: " + relationships.rShale + "\nSten: " + relationships.rSten +
            "\nWynne: " + relationships.rWynne + "\nZevran: " + relationships.rZevran + ".")
}

fun updateChoices(){
    println("Update Choices")
    println()

    println("THE BLIGHT")
    println("Did you die to end the Blight?(yes/no) ")
    choices.hero = readLine()!!
    println("THE NATURE OF THE BEAST")
    println("How did you resolve the problems between the werewolves and the elves? ")
    choices.beast = readLine()!!
    println("PARAGON OF HER KIND")
    println("What happened to the Anvil of the Void? ")
    choices.paragon1 = readLine()!!
    println("Who rules in Orzammar? ")
    choices.paragon2 = readLine()!!
    println("BROKEN CIRCLE")
    println("Who did you support at the Broken Circle? ")
    choices.mages = readLine()!!
    println("THE LANDSMEET")
    println("Who now rules Ferelden? ")
    choices.ruler = readLine()!!
    println("THE URN OF SACRED ASHES")
    println("Did you poison the Urn? ")
    choices.urn = readLine()!!
    println("THE ARL OF REDCLIFFE")
    println("What happened to Connor? ")
    choices.arl = readLine()!!
    println("THE BATTLE OF DENERIM")
    println("Who killed the Archdemon? ")
    choices.archdemon = readLine()!!
    println("Your choices have been updated!")
}

fun listPlaythroughs(){
    println("Listing Playthroughs...")
}