package ie.wit.LeahCullen.A1.main
//calls and imports
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

//main menu which runs at app start up
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
            //5 -> deletePlaythrough() //delete attempted but got confused as to how to integrate it into my own code
            0 -> println("Exiting app...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Shutting Down Dragon Age Console App"}
}

//search menu to find particular characters, relationships and choices(CR&C)
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

//menu which allows user to add (CR&C) into a playthough
fun createPlaythrough(){
    var input: Int
    var playthrough = playthroughModel()

    do{
        input = playthroughView.createMenu()
        when(input){
            1 -> addCharacter(playthrough)  //each function passes the newly created (CR&C) into the playthroughModel
            2 -> editRelationships(playthrough) //this puts the new data into its own playthrough
            3 -> editChoices(playthrough)
            0 -> println("Back to main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
    playthroughs.create(playthrough) //once all data is entered a new playthrough is created with that data
}

/*
update works. I wanted it so that you could update a particular pieces in a playthrough. However it doesnt
really need the playthrough id you can just enter the (CR&C) ids and itll work
 */
fun updatePlaythrough(){
    var input: Int
    playthroughs.listAll()
    println("Please enter the playthrough id: ") //not necessary but may be something I can properly implement later on
    val id = readLine()!!
    var playthrough = playthroughs.findOne(id.toLong())!!

    do{
        input = playthroughView.updateMenu()
        when(input){
            1 -> updateCharacter(playthrough)   //like with createPlaythrough() above everything is piped into the playthroughModel
            2 -> updateRelationships(playthrough)
            3 -> updateChoices(playthrough)
            0 -> println("Back main menu...")
            else -> println("Invalid option. Please try again")
        }
        println()
    }while(input != 0)
    logger.info{"Heading Back to the Main Menu"}
    playthroughs.update(playthrough)    //once data is updated, update the playthrough data
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

/*
this takes in user input from characterView and creates a new character. That new character is then piped into the
playthroughModel
 */
fun addCharacter(playthroughModel: playthroughModel) {

    var aCharacter = characterModel()

    if(characterView.addCharacterData(aCharacter))
        characters.create(aCharacter)
    else
        logger.info("Character Not Added...")
    playthroughModel.characters.add(aCharacter) //once character info is inputted, add it to its corresponding playthrough
}

/*
this takes in user input from relationshipView and creates new relationships. Those new relationships are then piped into the
playthroughModel
 */
fun editRelationships(playthroughModel: playthroughModel){
    var aRelationship = relationshipModel()

    if(relationshipView.addRelationshipData(aRelationship))
        relationships.create(aRelationship)
    else
        logger.info("Relationship Not Added")
    playthroughModel.relationships.add(aRelationship) //once relationship info is inputted, add it to its corresponding playthrough
}

/*
this takes in user input from choiceView and creates new choice. Those new choice are then piped into the
playthroughModel
 */
fun editChoices(playthroughModel: playthroughModel){
    var aChoice = choiceModel()

    if(choiceView.addChoiceData(aChoice))
        choices.create(aChoice)
    else
        logger.info("Choice Not Added...")
    playthroughModel.choices.add(aChoice) //once choice info is inputted, add it to its corresponding playthrough
}

/*
this takes in new user input from characterView and creates updated characters. I didn't know exactly how to pipe these
into the playthroughModel but once the individual data is updated it changes in the playthrough anyway. May need to
fix this in the future
 */
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

/*
this takes in new user input from relationshipView and creates updated relationships.
 */
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

/*
this takes in new user input from choiceView and creates updated choices.
 */
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

//search function to find characters by id
fun search1(id: Long): characterModel?{
    var foundCharacter = characters.findOne(id)
    return foundCharacter
}

//ties in with search1 to find a single character
fun searchCharacter(){
    val aCharacter = search1(characterView.getId())!!
    characterView.showCharacter(aCharacter)
}

//search function to find relationships by id
fun search2(id: Long): relationshipModel?{
    var foundRelationship = relationships.findOne(id)
    return foundRelationship
}

//ties in with search2 to find specific relationships
fun searchRelationship(){
    val aRelationship = search2(relationshipView.getId())!!
    relationshipView.showRelationship(aRelationship)
}

//search function to find choices by id
fun search3(id: Long): choiceModel?{
    var foundChoice = choices.findOne(id)
    return foundChoice
}

//ties in with search3 to find specific choices
fun searchChoice(){
    val aChoice = search3(choiceView.getId())!!
    choiceView.showChoice(aChoice)
}
