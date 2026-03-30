package com.plcoding.spring_boot_crash_course.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 * File: Note.java
 * Class: CSCI 1302
 * Author: Brian Abbott
 * Created on: 3/30/26
 * Last modified: 3/30/26
 * Description: To be filled in by the user.
 */

@Document("notes")
data class Note(
    val title: String,
    val content: String,
    val color: Long,
    val createdAt: Instant,
    @Id val id: ObjectId = ObjectId.get()
)
