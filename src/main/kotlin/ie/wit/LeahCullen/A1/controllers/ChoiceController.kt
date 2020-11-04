package ie.wit.LeahCullen.A1.controllers

import ie.wit.LeahCullen.A1.main.choiceView
import ie.wit.LeahCullen.A1.main.choices
import ie.wit.LeahCullen.A1.main.search3
import ie.wit.LeahCullen.A1.models.choiceModel
import mu.KotlinLogging

class ChoiceController {
    val logger = KotlinLogging.logger {  }

    fun add(){
        var aChoice = choiceModel()

        if (choiceView.addChoiceData(aChoice))
            choices.create(aChoice)
        else
            logger.info("Choice Not Added...")
    }

    fun list(){
        choiceView.listChoices(choices)
    }

    fun update(){
        choiceView.listChoices(choices)
        var searchId = choiceView.getId()
        val aChoice = search3(searchId)

        if(aChoice != null){
            if (choiceView.updateChoiceData(aChoice)){
                choices.update(aChoice)
                choiceView.showChoice(aChoice)
                logger.info("Choice Updated: $aChoice")
            }
            else
                logger.info("Choice Not Updated...")
        }
        else
            logger.info("Choice Not Updated...")
    }

    fun search(){
        val aChoice = search(choiceView.getId())!!
        choiceView.showChoice(aChoice)
    }

    fun search(id: Long): choiceModel?{
        var foundChoice = choices.findOne(id)
        return foundChoice
    }

    fun dummyData(){
        choices.create(
            choiceModel(1,"No", "Brokered Peace", "Destroyed", "Bhelen",
                "Mages", "Anora", "No", "Survived, not possessed", "Warden"))
        choices.create(choiceModel(2,"Yes", "Sided with the werewolves", "Saved", "Harrowmount",
            "Templars", "Alaistair", "Yes", "Survived, possessed", "Alaistair"))
        choices.create(choiceModel(3,"Yes", "Sided with the Elves", "Destroyed", "Bhelen",
            "Mages", "Anora", "Yes", "Died", "Warden"))
    }
}