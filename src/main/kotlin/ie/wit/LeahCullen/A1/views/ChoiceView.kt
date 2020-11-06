package ie.wit.LeahCullen.A1.views

import ie.wit.LeahCullen.A1.models.choiceModel
import ie.wit.LeahCullen.A1.models.choiceMemStore
/*
this view holds everything choice related that you see in the console
 */
class ChoiceView {
    fun listChoices(choices: choiceMemStore){
        println("List All Choices")
        println()
        choices.logAll()
        println()
    }

    fun showChoice(choice: choiceModel){
        if(choice != null)
            println("Choice Details: $choice")
        else
            println("Choice Not Found...")
    }

    fun addChoiceData(choice: choiceModel): Boolean{
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

        return choice.hero.isNotEmpty() && choice.beast.isNotEmpty() &&
                choice.paragon1.isNotEmpty() && choice.paragon2.isNotEmpty() &&
                choice.mages.isNotEmpty() && choice.ruler.isNotEmpty() &&
                choice.urn.isNotEmpty() && choice.arl.isNotEmpty() && choice.archdemon.isNotEmpty()
    }

    fun updateChoiceData(choice: choiceModel): Boolean{
        var tempHero: String?
        var tempBeast: String?
        var tempParagon1: String?
        var tempParagon2: String?
        var tempMages: String?
        var tempRuler: String?
        var tempUrn: String?
        var tempArl: String?
        var tempArchdemon: String?

        if(choice != null) {
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

            if (!tempHero.isNullOrEmpty() && !tempBeast.isNullOrEmpty() && !tempParagon1.isNullOrEmpty() &&
                !tempParagon2.isNullOrEmpty() && !tempMages.isNullOrEmpty() && !tempRuler.isNullOrEmpty() &&
                !tempUrn.isNullOrEmpty() && !tempArl.isNullOrEmpty() && !tempArchdemon.isNullOrEmpty()
            ) {
                choice.hero = tempHero
                choice.beast = tempBeast
                choice.paragon1 = tempParagon1
                choice.paragon2 = tempParagon2
                choice.mages = tempMages
                choice.ruler = tempRuler
                choice.urn = tempUrn
                choice.arl = tempArl
                choice.archdemon = tempArchdemon
                return true
            }
        }
        return false
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

}