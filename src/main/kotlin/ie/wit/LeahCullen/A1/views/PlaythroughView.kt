package ie.wit.LeahCullen.A1.views

import ie.wit.LeahCullen.A1.main.*
import ie.wit.LeahCullen.A1.models.characterMemStore
import ie.wit.LeahCullen.A1.models.characterModel
import ie.wit.LeahCullen.A1.models.choiceModel
import ie.wit.LeahCullen.A1.models.relationshipModel
import ie.wit.LeahCullen.A1.views.*
import mu.KotlinLogging

val characterView = CharacterView()
val relationshipView = RelationshipView()
val choiceView = ChoiceView()

class PlaythroughView {

    fun mainMenu(): Int{
        var option: Int
        var input: String? = null

        println("Main Menu")
        println("1.         Create New Playthrough")
        println("2.         Update a Playthough")
        println("3.         List All Playthroughs")
        println("4.         Search")
        //println("5.         Delete Playthrough")
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

    fun listPlaythroughs(){
        println("List All Playthroughs")
        println()

        playthroughs.listAll()
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

}