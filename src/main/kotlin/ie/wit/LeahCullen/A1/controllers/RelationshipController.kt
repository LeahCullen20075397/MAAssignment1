package ie.wit.LeahCullen.A1.controllers

import ie.wit.LeahCullen.A1.main.relationshipView
import ie.wit.LeahCullen.A1.main.relationships
import ie.wit.LeahCullen.A1.main.search2
import ie.wit.LeahCullen.A1.models.relationshipModel
import mu.KotlinLogging

class RelationshipController {
    val logger = KotlinLogging.logger {  }

    fun add(){
        var aRelationship = relationshipModel()
        if (relationshipView.addRelationshipData(aRelationship))
            relationships.create(aRelationship)
        else
            logger.info("Relationship Not Added...")
    }

    fun list(){
        relationshipView.listRelationships(relationships)
    }

    fun update(){
        relationshipView.listRelationships(relationships)
        var searchId = relationshipView.getId()
        val aRelationship = search2(searchId)

        if (aRelationship != null){
            if (relationshipView.updateRelationshipData(aRelationship)){
                relationships.update(aRelationship)
                relationshipView.showRelationship(aRelationship)
                logger.info("Relationship Updated: $aRelationship")
            }
            else
                logger.info("Relationship Not Updated...")
        }
        else
            println("Relationship Not Updated...")
    }

    fun search(){
        val aRelationship = search(relationshipView.getId())!!
        relationshipView.showRelationship(aRelationship)
    }

    fun search(id: Long): relationshipModel?{
        var foundRelationship = relationships.findOne(id)
        return foundRelationship
    }

    fun dummyData(){
        relationships.create(
            relationshipModel(1,"Romance", "Friend", "Enemy", "Friend",
                "Friend", "Enemy", "Friend", "Friend")
        )
        relationships.create(relationshipModel(2,"Friend", "Friend", "Friend", "Friend",
            "Friend", "Friend", "Friend", "Romance"))
        relationships.create(relationshipModel(3,"Enemy", "Romance", "Friend", "Friend",
            "Enemy", "Enemy", "Friend", "Friend"))
    }
}