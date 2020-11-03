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
            4 -> searchMenu()
            -99 -> dummyData()
            0 -> println("Exiting app...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Shutting Down Dragon Age Console App"}
}

fun searchMenu(): Int{
    var option: Int
    var input: String? = null

    println("Search menu")
    println("1.     Search Characters")
    println("2.     Search Relationships")
    println("3      Search Choices")
    println("0.     Main Menu")
    println()
    println("Please enter a number: ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun searching(){
    var input: Int

    do{
        input = searchMenu()
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

fun mainMenu(): Int{
    var option: Int
    var input: String? = null

    println("Main Menu")
    println("1.         Create New Playthrough")
    println("2.         Update a Playthough")
    println("3.         List All Playthroughs")
    println("4.         Search")
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
    println("2.         Relationships")
    println("3.         Choices")
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

    var aCharacter = characterModel()

    println("Add Your Character")
    println()
    println("Enter character name: ")
    aCharacter.name = readLine()!!
    println("Enter character gender: ")
    aCharacter.gender = readLine()!!
    println("Enter character race: ")
    aCharacter.race = readLine()!!
    println("Enter character background: ")
    aCharacter.background = readLine()!!

    if(aCharacter.name.isNotEmpty() && aCharacter.gender.isNotEmpty() && aCharacter.race.isNotEmpty()
        && aCharacter.background.isNotEmpty()){
        aCharacter.id = characters.size.toLong()
        characters.add(aCharacter.copy())
        logger.info("Character Added: [ $aCharacter]")
    }else
        logger.info("Character Not Added!!")
}

fun editRelationships(){

    var aRelationship = relationshipModel()
    println("Whats your character's relationship to these companions?")
    println()
    println("Alistair: ")
    aRelationship.rAlaistair = readLine()!!
    println("Leliana: ")
    aRelationship.rLeliana = readLine()!!
    println("Morrigan: ")
    aRelationship.rMorrigan = readLine()!!
    println("Oghren: ")
    aRelationship.rOghren = readLine()!!
    println("Shale: ")
    aRelationship.rShale = readLine()!!
    println("Sten: ")
    aRelationship.rSten = readLine()!!
    println("Wynne: ")
    aRelationship.rWynne = readLine()!!
    println("Zevran: ")
    aRelationship.rZevran = readLine()!!

    if(aRelationship.rAlaistair.isNotEmpty() && aRelationship.rLeliana.isNotEmpty() && aRelationship.rMorrigan.isNotEmpty()
        && aRelationship.rOghren.isNotEmpty() && aRelationship.rShale.isNotEmpty() && aRelationship.rSten.isNotEmpty()
        && aRelationship.rWynne.isNotEmpty() && aRelationship.rZevran.isNotEmpty()){
        aRelationship.id = relationships.size.toLong()
        relationships.add(aRelationship.copy())
        logger.info("Relationship added: [ $aRelationship]")
    }else
        logger.info("Relationship Not Added!!")
}

fun editChoices(){

    var aChoice = choiceModel()
    println("What choices will you make?")
    println()
    println("THE BLIGHT")
    println("Did you die to end the Blight?(yes/no) ")
    aChoice.hero = readLine()!!
    println("THE NATURE OF THE BEAST")
    println("How did you resolve the problems between the werewolves and the elves? ")
    aChoice.beast = readLine()!!
    println("PARAGON OF HER KIND")
    println("What happened to the Anvil of the Void? ")
    aChoice.paragon1 = readLine()!!
    println("Who rules in Orzammar? ")
    aChoice.paragon2 = readLine()!!
    println("BROKEN CIRCLE")
    println("Who did you support at the Broken Circle? ")
    aChoice.mages = readLine()!!
    println("THE LANDSMEET")
    println("Who now rules Ferelden? ")
    aChoice.ruler = readLine()!!
    println("THE URN OF SACRED ASHES")
    println("Did you poison the Urn? ")
    aChoice.urn = readLine()!!
    println("THE ARL OF REDCLIFFE")
    println("What happened to Connor? ")
    aChoice.arl = readLine()!!
    println("THE BATTLE OF DENERIM")
    println("Who killed the Archdemon? ")
    aChoice.archdemon = readLine()!!

    if(aChoice.hero.isNotEmpty() && aChoice.beast.isNotEmpty() && aChoice.paragon1.isNotEmpty()
        && aChoice.paragon2.isNotEmpty() && aChoice.mages.isNotEmpty() && aChoice.ruler.isNotEmpty()
        && aChoice.urn.isNotEmpty() && aChoice.arl.isNotEmpty() && aChoice.archdemon.isNotEmpty()){
        aChoice.id = choices.size.toLong()
        choices.add(aChoice.copy())
        logger.info("Choice added: [ $aChoice]")
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

    listPlaythroughs()

    var searchId = getId()
    val aCharacter = search1(searchId)
    var tempName: String?
    var tempGender: String?
    var tempRace: String?
    var tempBackground: String?

    if(aCharacter != null) {

        println("Enter a new character name for " + aCharacter.name + ": ")
        tempName = readLine()!!
        println("Enter a new character gender for " + aCharacter.gender + ": ")
        tempGender = readLine()!!
        println("Enter a new character race for " + aCharacter.race + ": ")
        tempRace = readLine()!!
        println("Enter a new character background for " + aCharacter.background + ": ")
        tempBackground = readLine()!!
        if(!tempName.isNullOrEmpty() && !tempGender.isNullOrEmpty() && !tempRace.isNullOrEmpty()
            && !tempBackground.isNullOrEmpty()){
            aCharacter.name = tempName
            aCharacter.gender = tempGender
            aCharacter.race = tempRace
            aCharacter.background = tempBackground
            println(
                "Your character's name is now " + aCharacter.name + ". They are now " +
                        aCharacter.gender + " and from the " + aCharacter.race +
                        " race. Their background is now: " + aCharacter.background + "."
            )
            logger.info("Character updated: $aCharacter")
        }else
            println("Character not updated...")
    }else
        println("Character not updated...")
}

fun updateRelationships(){
    println("Update relationships")
    println()

    listPlaythroughs()

    var searchId = getId()
    val aRelationship = search2(searchId)
    var tempAlaistair: String?
    var tempLeliana: String?
    var tempMorrigan: String?
    var tempOghren: String?
    var tempShale: String?
    var tempSten: String?
    var tempWynne: String?
    var tempZevran: String?

    if(aRelationship != null) {
        println("Alistair: ")
        tempAlaistair = readLine()!!
        println("Leliana: ")
        tempLeliana = readLine()!!
        println("Morrigan: ")
        tempMorrigan = readLine()!!
        println("Oghren: ")
        tempOghren = readLine()!!
        println("Shale: ")
        tempShale = readLine()!!
        println("Sten: ")
        tempSten = readLine()!!
        println("Wynne: ")
        tempWynne = readLine()!!
        println("Zevran: ")
        tempZevran = readLine()!!
        if(!tempAlaistair.isNullOrEmpty() && !tempLeliana.isNullOrEmpty() && !tempMorrigan.isNullOrEmpty() &&
                !tempOghren.isNullOrEmpty() && !tempShale.isNullOrEmpty() && !tempSten.isNullOrEmpty() &&
                !tempWynne.isNullOrEmpty() && !tempZevran.isNullOrEmpty()){
            aRelationship.rAlaistair = tempAlaistair
            aRelationship.rLeliana = tempLeliana
            aRelationship.rMorrigan = tempMorrigan
            aRelationship.rOghren = tempOghren
            aRelationship.rShale = tempShale
            aRelationship.rSten = tempSten
            aRelationship.rWynne = tempWynne
            aRelationship.rZevran = tempZevran
            println("Here are your updated relationships: ")
            println(
                "Alistair: " + aRelationship.rAlaistair + "\nLeliana: " + aRelationship.rLeliana + "\nMorrigan: " + aRelationship.rMorrigan +
                        "\nOghren: " + aRelationship.rOghren + "\nShale: " + aRelationship.rShale + "\nSten: " + aRelationship.rSten +
                        "\nWynne: " + aRelationship.rWynne + "\nZevran: " + aRelationship.rZevran + "."
            )
            logger.info("Relationship updated: $aRelationship")
        }else
            println("Relationship not updated...")
    }else
        println("Relationship not updated...")
}

fun updateChoices(){
    println("Update Choices")
    println()

    listPlaythroughs()

    var searchId = getId()
    val aChoice = search3(searchId)
    var tempHero: String?
    var tempBeast: String?
    var tempParagon1: String?
    var tempParagon2: String?
    var tempMages: String?
    var tempRuler: String?
    var tempUrn: String?
    var tempArl: String?
    var tempArchdemon: String?

    if(aChoice != null) {
        println("THE BLIGHT")
        println("Did you die to end the Blight?(yes/no) ")
        tempHero = readLine()!!
        println("THE NATURE OF THE BEAST")
        println("How did you resolve the problems between the werewolves and the elves? ")
        tempBeast = readLine()!!
        println("PARAGON OF HER KIND")
        println("What happened to the Anvil of the Void? ")
        tempParagon1 = readLine()!!
        println("Who rules in Orzammar? ")
        tempParagon2 = readLine()!!
        println("BROKEN CIRCLE")
        println("Who did you support at the Broken Circle? ")
        tempMages = readLine()!!
        println("THE LANDSMEET")
        println("Who now rules Ferelden? ")
        tempRuler = readLine()!!
        println("THE URN OF SACRED ASHES")
        println("Did you poison the Urn? ")
        tempUrn = readLine()!!
        println("THE ARL OF REDCLIFFE")
        println("What happened to Connor? ")
        tempArl = readLine()!!
        println("THE BATTLE OF DENERIM")
        println("Who killed the Archdemon? ")
        tempArchdemon = readLine()!!

        if(!tempHero.isNullOrEmpty() && !tempBeast.isNullOrEmpty() && !tempParagon1.isNullOrEmpty() &&
                !tempParagon2.isNullOrEmpty() && !tempMages.isNullOrEmpty() && !tempRuler.isNullOrEmpty() &&
                !tempUrn.isNullOrEmpty() && !tempArl.isNullOrEmpty() && !tempArchdemon.isNullOrEmpty()){
            aChoice.hero = tempHero
            aChoice.beast = tempBeast
            aChoice.paragon1 = tempParagon1
            aChoice.paragon2 = tempParagon2
            aChoice.mages = tempMages
            aChoice.ruler = tempRuler
            aChoice.urn = tempUrn
            aChoice.arl = tempArl
            aChoice.archdemon = tempArchdemon
            println("Your choices have been updated!")
            logger.info("Choice updated: $aChoice")
        }else
            println("Choice not updated...")
    }else
        println("Choice not updated...")
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

fun search1(id: Long): characterModel?{
    var foundCharacter: characterModel? = characters.find{p -> p.id == id}
    return foundCharacter
}

fun searchCharacter(){
    var searchId = getId()
    val aCharacter = search1(searchId)

    if(aCharacter != null)
        println("Character details: $aCharacter")
    else
        println("Character not found...")
}

fun search2(id: Long): relationshipModel?{
    var foundRelationship: relationshipModel? = relationships.find{p -> p.id == id}
    return foundRelationship
}

fun searchRelationship(){
    var searchId = getId()
    val aRelationship = search2(searchId)

    if(aRelationship != null)
        println("Relationship details: $aRelationship")
    else
        println("Relationship not found...")
}

fun search3(id: Long): choiceModel?{
    var foundChoice: choiceModel? = choices.find { p -> p.id == id }
    return foundChoice
}

fun searchChoice(){
    var searchId = getId()
    val aChoice = search3(searchId)

    if(aChoice != null)
        println("Choice details: $aChoice")
    else
        println("Choice not found...")
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