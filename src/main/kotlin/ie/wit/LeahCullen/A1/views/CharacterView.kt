package ie.wit.LeahCullen.A1.views

import ie.wit.LeahCullen.A1.models.characterMemStore
import ie.wit.LeahCullen.A1.models.characterModel

class CharacterView {
    fun listCharacters(characters: characterMemStore){
        println("List All Characters")
        println()
        characters.logAll()
        println()
    }

    fun showCharacter(character: characterModel){
        if(character != null)
            println("Character Details: $character")
        else
            println("Character Not Found...")
    }

    fun addCharacterData(character: characterModel): Boolean{
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

        return character.name.isNotEmpty() && character.gender.isNotEmpty() &&
                character.race.isNotEmpty() && character.background.isNotEmpty()
    }

    fun updateCharacterData(character: characterModel): Boolean{

        var tempName: String?
        var tempGender: String?
        var tempRace: String?
        var tempBackground: String?

        if(character != null) {

            println("Enter a new character name for " + character.name + ": ")
            tempName = readLine()!!
            println("Enter a new character gender for " + character.gender + ": ")
            tempGender = readLine()!!
            println("Enter a new character race for " + character.race + ": ")
            tempRace = readLine()!!
            println("Enter a new character background for " + character.background + ": ")
            tempBackground = readLine()!!
            if (!tempName.isNullOrEmpty() && !tempGender.isNullOrEmpty() && !tempRace.isNullOrEmpty()
                && !tempBackground.isNullOrEmpty()
            ) {
                character.name = tempName
                character.gender = tempGender
                character.race = tempRace
                character.background = tempBackground
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