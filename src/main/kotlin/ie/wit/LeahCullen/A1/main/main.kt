package ie.wit.LeahCullen.A1.main

import ie.wit.LeahCullen.A1.models.characterModel
import ie.wit.LeahCullen.A1.models.choiceModel
import ie.wit.LeahCullen.A1.models.relationshipModel
import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

var character = characterModel()
var relationship = relationshipModel()
var choice = choiceModel()

val  characters = ArrayList<characterModel>()
val relationships = ArrayList<relationshipModel>()
val choices = ArrayList<choiceModel>()

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
    character.name = readLine()!!
    println("Enter character gender: ")
    character.gender = readLine()!!
    println("Enter character race: ")
    character.race = readLine()!!
    println("Enter character background: ")
    character.background = readLine()!!

    if(character.name.isNotEmpty() && character.gender.isNotEmpty() && character.race.isNotEmpty()
        && character.background.isNotEmpty()){
        characters.add(character.copy())
        logger.info("Character Added: [ $character]")
    }else
        logger.info("Character Not Added!!")
}

fun editRelationships(){

    println("Whats your character's relationship to these companions?")
    println()
    println("Alistair: ")
    relationship.rAlaistair = readLine()!!
    println("Leliana: ")
    relationship.rLeliana = readLine()!!
    println("Morrigan: ")
    relationship.rMorrigan = readLine()!!
    println("Oghren: ")
    relationship.rOghren = readLine()!!
    println("Shale: ")
    relationship.rShale = readLine()!!
    println("Sten: ")
    relationship.rSten = readLine()!!
    println("Wynne: ")
    relationship.rWynne = readLine()!!
    println("Zevran: ")
    relationship.rZevran = readLine()!!

    if(relationship.rAlaistair.isNotEmpty() && relationship.rLeliana.isNotEmpty() && relationship.rMorrigan.isNotEmpty()
        && relationship.rOghren.isNotEmpty() && relationship.rShale.isNotEmpty() && relationship.rSten.isNotEmpty()
        && relationship.rWynne.isNotEmpty() && relationship.rZevran.isNotEmpty()){
        relationships.add(relationship.copy())
        logger.info("Relationship added: [ $relationships]")
    }else
        logger.info("Relationship Not Added!!")
}

fun editChoices(){

    println("What choices will you make?")
    println()
    println("THE BLIGHT")
    println("Did you die to end the Blight?(yes/no) ")
    choice.hero = readLine()!!
    println("THE NATURE OF THE BEAST")
    println("How did you resolve the problems between the werewolves and the elves? ")
    choice.beast = readLine()!!
    println("PARAGON OF HER KIND")
    println("What happened to the Anvil of the Void? ")
    choice.paragon1 = readLine()!!
    println("Who rules in Orzammar? ")
    choice.paragon2 = readLine()!!
    println("BROKEN CIRCLE")
    println("Who did you support at the Broken Circle? ")
    choice.mages = readLine()!!
    println("THE LANDSMEET")
    println("Who now rules Ferelden? ")
    choice.ruler = readLine()!!
    println("THE URN OF SACRED ASHES")
    println("Did you poison the Urn? ")
    choice.urn = readLine()!!
    println("THE ARL OF REDCLIFFE")
    println("What happened to Connor? ")
    choice.arl = readLine()!!
    println("THE BATTLE OF DENERIM")
    println("Who killed the Archdemon? ")
    choice.archdemon = readLine()!!

    if(choice.hero.isNotEmpty() && choice.beast.isNotEmpty() && choice.paragon1.isNotEmpty()
        && choice.paragon2.isNotEmpty() && choice.mages.isNotEmpty() && choice.ruler.isNotEmpty()
        && choice.urn.isNotEmpty() && choice.arl.isNotEmpty() && choice.archdemon.isNotEmpty()){
        choices.add(choice.copy())
        logger.info("Choice added: [ $choices]")
    }else
        logger.info("Choice Not Added!!")
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

    println("Enter a new character name for " + character.name + ": ")
    character.name = readLine()!!
    println("Enter a new character gender for " + character.gender + ": ")
    character.gender = readLine()!!
    println("Enter a new character race for " + character.race +": ")
    character.race = readLine()!!
    println("Enter a new character background for " + character.background + ": ")
    character.background = readLine()!!
    println("Your character's name is now " + character.name + ". They are now " +
            character.gender + " and from the " + character.race +
            " race. Their background is now: " + character.background + ".")
}

fun updateRelationships(){
    println("Update relationships")
    println()

    println("Alistair: ")
    relationship.rAlaistair = readLine()!!
    println("Leliana: ")
    relationship.rLeliana = readLine()!!
    println("Morrigan: ")
    relationship.rMorrigan = readLine()!!
    println("Oghren: ")
    relationship.rOghren = readLine()!!
    println("Shale: ")
    relationship.rShale = readLine()!!
    println("Sten: ")
    relationship.rSten = readLine()!!
    println("Wynne: ")
    relationship.rWynne = readLine()!!
    println("Zevran: ")
    relationship.rZevran = readLine()!!
    println("Here are your updated relationships: ")
    println("Alistair: " + relationship.rAlaistair +"\nLeliana: " + relationship.rLeliana +"\nMorrigan: " + relationship.rMorrigan +
            "\nOghren: " + relationship.rOghren + "\nShale: " + relationship.rShale + "\nSten: " + relationship.rSten +
            "\nWynne: " + relationship.rWynne + "\nZevran: " + relationship.rZevran + ".")
}

fun updateChoices(){
    println("Update Choices")
    println()

    println("THE BLIGHT")
    println("Did you die to end the Blight?(yes/no) ")
    choice.hero = readLine()!!
    println("THE NATURE OF THE BEAST")
    println("How did you resolve the problems between the werewolves and the elves? ")
    choice.beast = readLine()!!
    println("PARAGON OF HER KIND")
    println("What happened to the Anvil of the Void? ")
    choice.paragon1 = readLine()!!
    println("Who rules in Orzammar? ")
    choice.paragon2 = readLine()!!
    println("BROKEN CIRCLE")
    println("Who did you support at the Broken Circle? ")
    choice.mages = readLine()!!
    println("THE LANDSMEET")
    println("Who now rules Ferelden? ")
    choice.ruler = readLine()!!
    println("THE URN OF SACRED ASHES")
    println("Did you poison the Urn? ")
    choice.urn = readLine()!!
    println("THE ARL OF REDCLIFFE")
    println("What happened to Connor? ")
    choice.arl = readLine()!!
    println("THE BATTLE OF DENERIM")
    println("Who killed the Archdemon? ")
    choice.archdemon = readLine()!!
    println("Your choices have been updated!")
}

fun listPlaythroughs(){
    println("List All Playthroughs")
    println()
    characters.forEach{logger.info("${it}")}
    relationships.forEach { logger.info("${it}") }
    choices.forEach { logger.info("${it}") }

}

fun dummyData() {
    characters.add(characterModel("Leah", "Female", "Human", "Noble"))
    relationships.add(
        relationshipModel("Romance", "Friend", "Enemy", "Friend",
        "Friend", "Enemy", "Friend", "Friend")
    )
    choices.add(
        choiceModel("No", "Brokered Peace", "Destroyed", "Bhelen",
    "Mages", "Anora", "No", "Survived, not possessed", "Warden")
    )
    characters.add(characterModel("Susie", "Female", "Elf", "Dalish"))
    relationships.add(relationshipModel("Friend", "Friend", "Friend", "Friend",
        "Friend", "Friend", "Friend", "Romance"))
    choices.add(choiceModel("Yes", "Sided with the werewolves", "Saved", "Harrowmount",
        "Templars", "Alaistair", "Yes", "Survived, possessed", "Alaistair"))
    characters.add(characterModel("Ruairi", "Male", "Dwarf", "Commoner"))
    relationships.add(relationshipModel("Enemy", "Romance", "Friend", "Friend",
        "Enemy", "Enemy", "Friend", "Friend"))
    choices.add(choiceModel("Yes", "Sided with the Elves", "Destroyed", "Bhelen",
        "Mages", "Anora", "Yes", "Died", "Warden"))
}