package ie.wit.LeahCullen.A1.views

import ie.wit.LeahCullen.A1.models.relationshipMemStore
import ie.wit.LeahCullen.A1.models.relationshipModel

/*
this view holds everything character related that you see in the console
 */
class RelationshipView {
    fun listRelationships(relationships: relationshipMemStore){
        println("List All Relationships")
        println()
        relationships.logAll()
        println()
    }

    fun showRelationship(relationship: relationshipModel){
        if(relationship != null)
            println("Relationship Details: $relationship")
        else
            println("Relationship Not Found...")
    }

    fun addRelationshipData(relationship: relationshipModel): Boolean{
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

        return relationship.rAlaistair.isNotEmpty() && relationship.rLeliana.isNotEmpty() &&
                relationship.rMorrigan.isNotEmpty() && relationship.rOghren.isNotEmpty() &&
                relationship.rShale.isNotEmpty() && relationship.rSten.isNotEmpty() &&
                relationship.rWynne.isNotEmpty() && relationship.rZevran.isNotEmpty()
    }

    fun updateRelationshipData(relationship: relationshipModel): Boolean{
        var tempAlaistair: String?
        var tempLeliana: String?
        var tempMorrigan: String?
        var tempOghren: String?
        var tempShale: String?
        var tempSten: String?
        var tempWynne: String?
        var tempZevran: String?

        if(relationship != null) {
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
            if (!tempAlaistair.isNullOrEmpty() && !tempLeliana.isNullOrEmpty() && !tempMorrigan.isNullOrEmpty() &&
                !tempOghren.isNullOrEmpty() && !tempShale.isNullOrEmpty() && !tempSten.isNullOrEmpty() &&
                !tempWynne.isNullOrEmpty() && !tempZevran.isNullOrEmpty()
            ) {
                relationship.rAlaistair = tempAlaistair
                relationship.rLeliana = tempLeliana
                relationship.rMorrigan = tempMorrigan
                relationship.rOghren = tempOghren
                relationship.rShale = tempShale
                relationship.rSten = tempSten
                relationship.rWynne = tempWynne
                relationship.rZevran = tempZevran
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