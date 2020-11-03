package ie.wit.LeahCullen.A1.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }
var lastIdRelationship = 0L

internal fun getIdRelationship(): Long{
    return lastIdRelationship++
}

class relationshipMemStore: relationshipStore {

    val relationships = ArrayList<relationshipModel>()

    override fun findAll(): List<relationshipModel>{
        return relationships
    }

    override fun findOne(id: Long): relationshipModel?{
        var foundRelationship: relationshipModel? = relationships.find { p -> p.id == id }
        return foundRelationship
    }

    override fun create(relationship: relationshipModel){
        relationship.id = getIdRelationship()
        relationships.add(relationship)
        logAll()
    }

    override fun update(relationship: relationshipModel){
        var foundRelationship = findOne(relationship.id!!)
        if(foundRelationship != null){
            foundRelationship.rAlaistair = relationship.rAlaistair
            foundRelationship.rLeliana = relationship.rLeliana
            foundRelationship.rMorrigan = relationship.rMorrigan
            foundRelationship.rOghren = relationship.rOghren
            foundRelationship.rShale = relationship.rShale
            foundRelationship.rSten = relationship.rSten
            foundRelationship.rWynne = relationship.rWynne
            foundRelationship.rZevran = relationship.rZevran
        }
    }

    internal fun logAll(){
        relationships.forEach { logger.info("${it}") }
    }
}