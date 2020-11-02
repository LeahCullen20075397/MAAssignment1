package ie.wit.LeahCullen.A1

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
    println("Adding Character...")
}

fun editRelationships(){
    println("Editing Relationships...")
}

fun editChoices(){
    println("Editing Choices...")
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