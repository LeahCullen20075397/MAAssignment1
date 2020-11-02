package ie.wit.LeahCullen.A1.main

import mu.KotlinLogging

private val logger = KotlinLogging.logger{}

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
    var name: String
    var gender: String
    var race: String
    var background: String

    println("Add Your Character")
    println()
    println("Enter character name: ")
    name = readLine()!!
    println("Enter character gender: ")
    gender = readLine()!!
    println("Enter character race: ")
    race = readLine()!!
    println("Enter character background: ")
    background = readLine()!!
    println("Your character's name is $name . They are $gender and from the $race race. Their background is: $background")
}

fun editRelationships(){
    var rAlaistair: String
    var rLeliana: String
    var rMorrigan: String
    var rOghren: String
    var rShale: String
    var rSten: String
    var rWynne: String
    var rZevran: String

    println("Whats your character's relationship to these companions?")
    println()
    println("Alistair: ")
    rAlaistair = readLine()!!
    println("Leliana: ")
    rLeliana = readLine()!!
    println("Morrigan: ")
    rMorrigan = readLine()!!
    println("Oghren: ")
    rOghren = readLine()!!
    println("Shale: ")
    rShale = readLine()!!
    println("Sten: ")
    rSten = readLine()!!
    println("Wynne: ")
    rWynne = readLine()!!
    println("Zevran: ")
    rZevran = readLine()!!
    println("Here are your current relationships: ")
    println("Alistair: $rAlaistair\nLeliana: $rLeliana\nMorrigan: $rMorrigan" +
            "\nOghren: $rOghren\nShale: $rShale\nSten: $rSten" +
            "\nWynne: $rWynne\nZevran: $rZevran")
}

fun editChoices(){
    var hero: String
    var beast: String
    var paragon1: String
    var paragon2: String
    var mages: String
    var ruler: String
    var urn: String
    var arl: String
    val archdemon: String

    println("What choices will you make?")
    println()
    println("THE BLIGHT")
    println("Did you die to end the Blight?(yes/no) ")
    hero = readLine()!!
    println("THE NATURE OF THE BEAST")
    println("How did you resolve the problems between the werewolves and the elves? ")
    beast = readLine()!!
    println("PARAGON OF HER KIND")
    println("What happened to the Anvil of the Void? ")
    paragon1 = readLine()!!
    println("Who rules in Orzammar? ")
    paragon2 = readLine()!!
    println("BROKEN CIRCLE")
    println("Who did you support at the Broken Circle? ")
    mages = readLine()!!
    println("THE LANDSMEET")
    println("Who now rules Ferelden? ")
    ruler = readLine()!!
    println("THE URN OF SACRED ASHES")
    println("Did you poison the Urn? ")
    urn = readLine()!!
    println("THE ARL OF REDCLIFFE")
    println("What happened to Connor? ")
    arl = readLine()!!
    println("THE BATTLE OF DENERIM")
    println("Who killed the Archdemon? ")
    archdemon = readLine()!!
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
    println("Updating character...")
}

fun updateRelationships(){
    println("Updating relationships...")
}

fun updateChoices(){
    println("Updating Choices...")
}

fun listPlaythroughs(){
    println("Listing Playthroughs...")
}